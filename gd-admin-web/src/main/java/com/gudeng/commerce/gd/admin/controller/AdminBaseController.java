package com.gudeng.commerce.gd.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gudeng.commerce.gd.admin.entity.UserSummary;
import com.gudeng.commerce.gd.admin.util.JSONMessage;
import com.gudeng.commerce.gd.authority.sysmgr.entity.SysRegisterUser;
import com.gudeng.commerce.gd.authority.sysmgr.util.Constant;
import com.gudeng.framework.core2.GdLogger;
import com.gudeng.framework.web.controller.BaseController;

public class AdminBaseController  extends BaseController {
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	protected HttpSession session;

	/** 分页参数：起始页 */
	protected final String START_ROW = "startRow";
	/** 分页参数：结束页 */
	protected final String END_ROW = "endRow";
	/** 总记录数 */
	protected final String ALL_RECORDERS = "allRecorders";
	/** 总页数 */
	protected final String PAGE_COUNT = "pageCount";
	/** 当前页 */
	protected final String PAGE_NO = "pageNo";
	/** 每页数据条数 */
	protected final String PAGE_SIZE = "pageSize";

	public AdminBaseController() {

	}
	
	public HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	@ModelAttribute
	public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession(true);
	}

	public void putModel(String key,Object result){
		HttpServletRequest request = this.getRequest();
		request.setAttribute(key, result);
	}
	
	/**
	 * 获取sessian中用户信息,由于登录系统更换，该方法已过期，请使用public SysRegisterUser getUser(HttpServletRequest request)
	 * @param request
	 * @return
	 * @date 2015年4月16日下午7:16:17
	 * @UpdateDate 2015年10月20日 下午4:56:30 
	 * @Author lidong(dli@cnagri-products.com)
	 */
	@Deprecated
	public UserSummary getUserInfo(HttpServletRequest request){
		return (UserSummary) request.getSession().getAttribute("userSummaryForAuthority");
	}
	/**
	 * @Description getUser 获取登录用户的信息
	 * @param request
	 * @return
	 * @CreationDate 2015年10月20日 下午4:55:44
	 * @Author lidong(dli@cnagri-products.com)
	*/
	public SysRegisterUser getUser(HttpServletRequest request){
		return  (SysRegisterUser) request.getSession().getAttribute(Constant.SYSTEM_SMGRLOGINUSER);
	}
	
	
	/**
	 * 根据总记录计算出 分页条件起始页 记录总页数 
	 * 
	 * @param request
	 * @param map
	 */
	protected void setCommParameters(HttpServletRequest request, Map<String, Object> map){

		//排序字段名称。
		String sort=StringUtils.trimToNull(request.getParameter("sort"));
		//排序顺序
		String sortOrder=StringUtils.trimToNull(request.getParameter("order"));
		//当前第几页
		String page=request.getParameter("page");
		//每页显示的记录数
		String rows=request.getParameter("rows"); 
		//当前页  
        int currentPage = Integer.parseInt((page == null || page == "0") ? "1":page);  
        //每页显示条数  
        int pageSize = Integer.parseInt((rows == null || rows == "0") ? "10":rows);  
        //每页的开始记录  第一页为1  第二页为number +1   
        int startRow = (currentPage-1)*pageSize;  
        map.put(START_ROW, startRow);
		map.put(END_ROW, pageSize);
		map.put("sortName", sort);
		map.put("sortOrder", sortOrder);
	}
	
	/**
	 * 获取异常信息
	 * @author wwj
	 * @date 创建时间：2015年7月23日 下午5:48:13
	 * @param e
	 * @param logger
	 * @return
	 *
	 */
	public String getExceptionMessage(Exception e,GdLogger logger){
		
		e.printStackTrace();
		logger.info(e.getMessage());
		if(e.getMessage()==null){
			return "操作异常";
		}
		return e.getMessage();
	}
	
	/**
	 * 获取异常信息
	 * @author wwj
	 * @date 创建时间：2015年7月29日 下午2:01:09
	 * @param e
	 * @return
	 *
	 */
	public String getExceptionMessage(Exception e){
		
		e.printStackTrace();
		if(e.getMessage()==null){
			return "操作异常";
		}
		return e.getMessage();
	}

	/**
	 * 响应json消息
	 */
	public void sendJsonMessage(String json) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}
	
	public void sendJsonMessage(JSONMessage jsonM) throws Exception {
		sendJsonMessage(jsonM.toString());
	}

}
