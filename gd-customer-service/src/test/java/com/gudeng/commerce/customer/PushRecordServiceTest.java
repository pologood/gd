package com.gudeng.commerce.customer;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gudeng.commerce.gd.customer.dto.MemberBaseinfoDTO;
import com.gudeng.commerce.gd.customer.entity.MemberBaseinfoEntity;
import com.gudeng.commerce.gd.customer.entity.PushRecordEntity;
import com.gudeng.commerce.gd.customer.service.MemberBaseinfoService;
import com.gudeng.commerce.gd.customer.service.PushRecordService;
import com.gudeng.commerce.gd.customer.util.DateUtil;

public class PushRecordServiceTest extends TestCase{
	private static PushRecordService getService() throws MalformedURLException{
		String url = "http://localhost:8080/gd-customer/service/pushRecordService.hs";
		HessianProxyFactory factory = new HessianProxyFactory();
		return (PushRecordService) factory.create(PushRecordService.class, url);				
	}
	
//	@SuppressWarnings("static-access")
//	public void testGetDic()throws Exception {
//		DemoService service=this.getService();
//		DictDTO dto = service.getById("1");
//		if(null != dto){
//			System.out.println(dto.getId()+":"+dto.getName());
//		}
//	}
	
//	public void testGetByBirthday() throws Exception{
//		DemoService service=this.getService();
//		Map<String,Object> map=new HashMap<String,Object>();
//		String startdate="2000-03-01 00:00:00";
//		
//		Date st=DateUtil.formateDate(startdate,DateUtil.DATE_FORMAT_DATETIME);
//		
//		String enddate="2015-03-02 00:00:00";
//		
//		Date ed=DateUtil.formateDate(enddate,DateUtil.DATE_FORMAT_DATETIME);
//
//		
//		map.put("startdate",st);
//		map.put("enddate",ed);
//		map.put("startRow", 0);
//		map.put("endRow", 10);
//		List<DictDTO> dicList = service.getByBirthday(map);
//		
//		if(null != dicList){
//			for(DictDTO dto : dicList){
//				System.out.println(dto.getId() + " : " + dto.getName()+" : "+dto.getBirthday());
//			}
//		}
//	}
//	public void testGetByAccount() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map<String,Object> map=new HashMap<String,Object>();
//		MemberBaseinfoDTO dto = service.getByAccount("testAccount2");
//		System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//	}
	
	
	
//	public void testGetByAccountLike() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("account","12");
//		map.put("startRow", 0);
//		map.put("endRow", 10);
//		List<MemberBaseinfoDTO> dtos = service.getByAccountLike(map);
//		for(MemberBaseinfoDTO dto:dtos){
//			System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//		}
//	}
//	
//	
//	public void testGetByMobile() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map<String,Object> map=new HashMap<String,Object>();
//		MemberBaseinfoDTO dto = service.getByMobile("13430135673");
//		System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//	}
	
	
	
//	public void testGetBySearch() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map map =new HashMap();
////		map.put("nickName", "test");
////		map.put("mobile", "13430135673");
//		map.put("startRow", 0);
//		map.put("endRow", 10);
//		int total= service.getTotal(map);
//
//		List<MemberBaseinfoDTO> list=service.getBySearch(map);
//
//		for(MemberBaseinfoDTO dto:list){
//			System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//		}	
//		System.out.print(total+"        " +list.size());
//		}
	
//	public void testGetByName() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map map =new HashMap();
//		map.put("nickName", "test");
//		map.put("startRow", 0);
//		map.put("endRow", 10);
//		List<MemberBaseinfoDTO> list=service.getByNickName(map);
//
//		for(MemberBaseinfoDTO dto:list){
//			System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//		}	
//		}
//	
//	public void testGetAll() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		List<MemberBaseinfoDTO> list=service.getAll();
//		for(MemberBaseinfoDTO dto:list){
//			System.out.println(dto.getMemberId() + " : " + dto.getNickName()+" : "+dto.getBirthday());
//		}
//	}
	
//	
//	public void testGetTotal() throws Exception{
//		MemberBaseinfoService service=this.getService();
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("id", "1");
//		System.out.println("total:" + service.getTotal(map));
//		
//	}
//	
	
//	public void testDelete()throws Exception {
//	MemberBaseinfoService service=this.getService();
//		 int i= service.deleteById("1");
//		if(i==1){
//			System.out.println("删除id为"+1+"的记录成功");
//		}
//	}
	
//	public void testAddByDto()throws Exception {
//		MemberBaseinfoService service=this.getService();
//		MemberBaseinfoDTO mb = new MemberBaseinfoDTO();
//		mb.setAccount("testAccount2");
//		mb.setBirthday_string("2000-03-01 00:00:00"); 
//		mb.setCreateTime_string(DateUtil.toString(new Date(), DateUtil.DATE_FORMAT_DATETIME));
//		mb.setUpdateTime_string(DateUtil.toString(new Date(), DateUtil.DATE_FORMAT_DATETIME));
//		mb.setPassword("123456");
//		mb.setCreateUserId(""); 
//		int i=service.addMemberBaseinfoDTO(mb) ;
//		if(i==1){
//			System.out.println("增加dto成功");
//		}
//	}
//	
	
	
	
	/*public void testAddByDto()throws Exception {
		MemberBaseinfoService service=this.getService();
		MemberBaseinfoDTO mb = new MemberBaseinfoDTO();
		MemberBaseinfoEntity me = new MemberBaseinfoEntity();
		me.setAccount("testAccount2");
		me.setPassword("123456");
		Long l=service.addMemberBaseinfoEnt(me) ;
		
		mb.setAccount("testAccount2");
		mb.setPassword("123456");
//		int i=service.addMemberBaseinfoDTO(mb) ;
//		if(i==1){
			System.out.println("增加dto成功");
//		}
	}*/
	
//	public void testAddByEnt()throws Exception {
//		MemberBaseinfoService service=this.getService();
//		MemberBaseinfoEntity mb = new MemberBaseinfoEntity();
//		mb.setAccount("testAccount1");
//		mb.setPassword("123456");
//		mb.setCreateUserId("123"); 
//		Long i=service.addMemberBaseinfoEnt(mb);
//	 
//			System.out.println("。。。。。。。。。"+ i);
//	 
//	}
	
//	public void testupdate()throws Exception {
//		MemberBaseinfoService service=this.getService();
//		MemberBaseinfoDTO mb = new MemberBaseinfoDTO();
//		mb.setMemberId(2L);
//		mb.setAccount("testAccount");
//		mb.setBirthday_string("2001-03-01 00:00:00"); 
//		mb.setCreateTime_string(DateUtil.toString(new Date(), DateUtil.DATE_FORMAT_DATETIME));
//		mb.setUpdateTime_string(DateUtil.toString(new Date(), DateUtil.DATE_FORMAT_DATETIME));
//		mb.setPassword("1234567");
//		mb.setNickName("test123");
//		mb.setMobile("13430135673");
//		mb.setLevel(2);
//		mb.setCreateUserId(1L); 
//		int i=service.updateMemberBaseinfoDTO(mb) ;
//		if(i==1){
//			System.out.println("修改dto成功");
//		}
//	}
	
	public void testGetLogin()throws Exception {
		PushRecordService service = this.getService();
		
		PushRecordEntity mb = new PushRecordEntity();
		mb.setContent("addtest");
		Long i=service.add(mb);
//	 
		
		System.out.println(mb.getId());
	}
	
}
