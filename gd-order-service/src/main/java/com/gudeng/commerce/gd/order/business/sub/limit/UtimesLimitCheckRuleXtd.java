/**
 * @Title: UtimesLimitCheck.java
 * @Package com.gudeng.commerce.gd.admin.service.impl.sub
 * @Description: TODO(单一用户总交易频率管理)
 * @author mpan
 * @date 2015年12月2日 下午8:02:15
 * @version V1.0
 */ 
package com.gudeng.commerce.gd.order.business.sub.limit;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gudeng.commerce.gd.exception.ServiceException;
import com.gudeng.commerce.gd.order.dao.BaseDao;
import com.gudeng.commerce.gd.order.dto.OrderBaseinfoDTO;
import com.gudeng.commerce.gd.order.dto.SubRangeLimitRuleDTO;
import com.gudeng.commerce.gd.order.service.SubHelpService;

/**
 * @Description: TODO(补贴用户交易频率限制检查类)
 * @author mpan
 * @date 2015年12月2日 下午8:02:15
 */
 public class UtimesLimitCheckRuleXtd extends ACheckRule {
	
	 @Autowired
	private SubHelpService subHelpService;
	private BaseDao baseDao;
	private String result1;
	private String result2;
	private String result3;
	 
	@Override
	protected String dayRangeValid(Map map, SubRangeLimitRuleDTO rultDTO) throws ServiceException {
		// TODO Auto-generated method stub
		
		Integer dailyTrading = (Integer) map.get("dailyTrading"); 
		Integer getCountdaily = rultDTO.getCount();
		
		    String result1 = "OK";
		    if(dailyTrading.compareTo(getCountdaily) < 0){//可以补贴
		    	return result1;
		    }else{                                       //不满足条件
		    	result1 = "用户每天实际交易频率大于或等于设定值，不满足条件";
		    	return result1;
		    }	
}
	
	@Override
	protected String weekRangeValid(Map map, SubRangeLimitRuleDTO rultDTO) throws ServiceException {
		// TODO Auto-generated method stub	
		Integer weeklyTrading = (Integer) map.get("weeklyTrading"); 
		Integer getCountweekly = rultDTO.getCount();
		    String result2 = "OK";
		    if(weeklyTrading.compareTo(getCountweekly) < 0){//可以补贴
		    	return result2;
		    }else{                                       //不满足条件
		    	result2 = "用户每周实际交易频率大于或等于设定值，不满足条件";
		    	return result2;
		    }	
   }
	

	@Override
	protected String monthRangeValid(Map map, SubRangeLimitRuleDTO rultDTO) throws ServiceException {
		// TODO Auto-generated method stub
		Integer monthlyTrading = (Integer) map.get("monthlyTrading"); 
		Integer getCountmonthly = rultDTO.getCount();
		    String result = "OK";

		    if(monthlyTrading.compareTo(getCountmonthly) < 0){//可以补贴
		    	return result;
		    }else{                                       //不满足条件
		    	result = "用户每月实际交易频率大于或等于设定值，不满足条件";
		    	return result;
		    }	
	}
	
	@SuppressWarnings("unchecked")
	protected String Writesub(OrderBaseinfoDTO orderBase)throws ServiceException{
	
	List<SubRangeLimitRuleDTO> subRuleList = getSubRangeLimitType(); //获取服务类型；
	Map map1 = getOrderData(orderBase);
	long orderno = orderBase.getOrderNo();
	
	String result1 = dayRangeValid(map1, subRuleList.get(0));
	String result2 = weekRangeValid(map1, subRuleList.get(1));
	String result3 = monthRangeValid(map1, subRuleList.get(2));

	try{
		// 1.对于同一个类型的判断必须是每天、每周、每月都审批通过，才能写库
		if("ok".equals(result1)&"ok".equals(result2)&"ok".equals(result3)){
			//1.1 向order_baseinfo更新订单状态
		     @SuppressWarnings("rawtypes")
			 Map map = new HashMap();
		    map.put("orderno",orderno);//订单号
		  	map.put("buySubStatus", 21);// 买家补贴状态 0无补贴 11已计算补贴 10待出岗计算补贴 21验证通过 20验证不通过
		  	map.put("sellSubStatus", 21);//农批商补贴状态 0无补贴 11已计算补贴 10待出岗计算补贴 21验证通过 20验证不通过
		  	map.put("createTime", new Date());
		  	map.put("createUserId", "");
		  	 int tam = baseDao.execute("OrderBaseinfo.updateBuySubStatus", map);
		  	   
		    //1.2 向AuditLog 插入一条数据
		  	 @SuppressWarnings("rawtypes")
			Map map11 = new HashMap();
	    	 map11.put("orderno", orderno);//订单号
	  	     map11.put("type", 1);//类型 1补贴审核 2提现审核 3订单审核
	  	     map11.put("auditName","sys");//审核人姓名,sys
	  	     map11.put("createTime",new Date());//创建时间
	  	     int tam1 = baseDao.execute("AuditLog.addAuditLog", map11);  
	  	     
	  	   //1.3 向SubAudit插入一条数据
		  	 @SuppressWarnings("rawtypes")
			   Map map2 = new HashMap();
	    	 map2.put("orderNo",orderno);//订单号
		     map2.put("subStatus 补贴状态", 1);//补贴状态 1待补贴 2系统驳回 3已补贴 4不予补贴
		     map2.put("auditName", "sys");//创建人员
		     map2.put("createTime", new Date());//创建时间
		     map2.put("rejectReason", 1); //驳回原因	    
	  	   int tam2 = baseDao.execute("SubAudit.addAccTransInfo", map1);							
			}
		
		// 2.对于同一个类型的判断，如果每天、每周、每月每月全部通过，则审批不通过，也得写库
		
		else{
			 //向order_baseinfo更新订单状态
			 @SuppressWarnings("rawtypes")
			 Map map = new HashMap();
		     map.put("orderno",orderno);//订单号
		     map.put("buySubStatus", 20);// 买家补贴状态 0无补贴 11已计算补贴 10待出岗计算补贴 21验证通过 20验证不通过
		     map.put("sellSubStatus", 20);//农批商补贴状态 0无补贴 11已计算补贴 10待出岗计算补贴 21验证通过 20验证不通过
		     map.put("createTime",new Date());
		     map.put("createUserId", "");
		  	 int tam = baseDao.execute("OrderBaseinfo.updateBuySubStatus", map);
		
		  	   
		       //向AuditLog 插入一条数据		   
		  	 @SuppressWarnings("rawtypes")
			Map map2 = new HashMap();
		  	map2.put("type", 1);
		  	map2.put("orderNo", orderno);
	  	     int tam1 = baseDao.execute("AuditLog.addAuditLog", map2);  
	  	     
	  	   //向SubAudit插入一条数据
	  	    @SuppressWarnings("rawtypes")
			 Map map11 = new HashMap();
	  	     map11.put("orderNo",orderno);//订单号
		     map11.put("subStatus 补贴状态", 4);//补贴状态 1待补贴 2系统驳回 3已补贴 4不予补贴
		     map11.put("auditName", "sys");//创建人员
		     map11.put("createTime", new Date());//创建时间
		     map11.put("rejectReason", 1); //驳回原因	    
	  	   int tam2 = baseDao.execute("SubAudit.addAccTransInfo", map11);	
		 }
      } catch(Exception e){
         e.printStackTrace();
       }
         return null;
      }

	@Override
	protected String getLimitType() {
		// TODO Auto-generated method stub
		return "3";
	}

	@Override
	protected Map getOrderData(OrderBaseinfoDTO orderBase)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String validationVehL(OrderBaseinfoDTO orderInfo)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String validationUamount(OrderBaseinfoDTO orderInfo)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String validationUtim(OrderBaseinfoDTO orderBase)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String validationtwo(OrderBaseinfoDTO orderBase)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String validationtam(OrderBaseinfoDTO orderBase)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String Switch(OrderBaseinfoDTO orderBase) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
////	protected String weekRangeValid(Map map, SubRangeLimitRuleDTO rultDTO) throws ServiceException {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	@Override
//	protected String monthRangeValid(Map map, SubRangeLimitRuleDTO rultDTO) throws ServiceException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
