package com.gudeng.commerce.info.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gudeng.commerce.info.admin.util.CommonPropertiesUtil;
import com.gudeng.commerce.info.admin.util.LoginUserUtil;
import com.gudeng.commerce.info.customer.dto.BaseMenu;
import com.gudeng.commerce.info.customer.util.CommonConstant;
import com.gudeng.commerce.info.customer.util.Constant;
import com.gudeng.commerce.info.customer.util.PathUtil;

/**
 * 类说明 首页
 **/
@Controller
@RequestMapping("")
public class SysIndexController {

	// private Logger logger = Logger.getLogger(IndexController.class);

	// @Autowired
	// private OrderService orderService;

	@Autowired
	private CommonPropertiesUtil commonPropertiesUtil;

	/**
	 * 首页
	 * 
	 * @param request
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("index")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (LoginUserUtil.getLoginUserId(request) != null) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<BaseMenu> subMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_SENCONDMENU);
				List<BaseMenu> baseMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_ALLMENU);
				List<BaseMenu> trdMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_THIRDMENU);
				List<BaseMenu> menuList = new ArrayList<>();
				for (BaseMenu baseMenu : baseMenuList) {
					menuList.add(baseMenu);
				}
				for (BaseMenu subMenu : subMenuList) {
					menuList.add(subMenu);
				}
				for (BaseMenu subMenu : trdMenuList) {
				    menuList.add(subMenu);
				}
				map.put("trdMenuList", trdMenuList);
				map.put("subMenuList", subMenuList);
				map.put("baseMenuList", baseMenuList);
				map.put("menuList", menuList);
				request.getSession().setAttribute("menuList", menuList);
				request.setAttribute("index", map);
			}else {
				return "redirect:"+PathUtil.getBasePath(request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main/index";
	}

	/**
	 * 获取登录用户菜单
	 * 
	 * @author songhui
	 * @date 创建时间：2015年7月29日 下午3:19:06
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping("getMenu")
	@ResponseBody
	public String getMenu(HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		List<BaseMenu> list = new ArrayList<>();
		List<BaseMenu> subMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_SENCONDMENU);
		List<BaseMenu> baseMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_ALLMENU);
		for (BaseMenu baseMenu : baseMenuList) {
			list.add(baseMenu);
		}
		for (BaseMenu subMenu : subMenuList) {
			list.add(subMenu);
		}

		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("[");
		for (int i = 0; i < baseMenuList.size(); i++) {
			BaseMenu baseMenu = baseMenuList.get(i);
			sbBuilder.append("{");
			sbBuilder.append("\"id\":" + baseMenu.getMenuID() + ",");
			sbBuilder.append("\"text\":" + baseMenu.getMenuName() + ",");
			sbBuilder.append("\"state\":open,");
			sbBuilder.append("\"children\":");
			if (baseMenu.getChildren() != null && baseMenu.getChildren().size() > 0) {
				sbBuilder.append("[");
				for (int j = 0; j < baseMenu.getChildren().size(); j++) {
					BaseMenu subMenu = baseMenu.getChildren().get(i);
					sbBuilder.append("{");
					sbBuilder.append("\"id\":" + subMenu.getMenuID() + ",");
					sbBuilder.append("\"text\":" + subMenu.getMenuName() + ",");
					sbBuilder.append("\"state\":open,");
					sbBuilder.append("\"attributes\":");
					sbBuilder.append("{");
					sbBuilder.append("\"actionUrl\":" + subMenu.getActionUrl() + ",");
					sbBuilder.append("\"curLevel\":" + subMenu.getCurLevel());
					sbBuilder.append("},");
				}
				sbBuilder.append("]");
				sbBuilder.append("}");
			}
			sbBuilder.append("},");
		}

		sbBuilder.append("]");
		if (list != null) {
			String json = JSONObject.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
			return json;
		} else {
			return null;
		}
	}

	/**
	 * 验证是否有URL权限
	 * 
	 * @author songhui
	 * @date 创建时间：2015年8月5日 上午11:27:38
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping("checkUrl")
	@ResponseBody
	public String checkUrl(HttpServletRequest request) {

		String actionUrl = StringUtils.trimToNull(request.getParameter("actionUrl"));
		@SuppressWarnings("unchecked")
		List<BaseMenu> subMenuList = (List<BaseMenu>) request.getSession().getAttribute(Constant.SYSTEM_SENCONDMENU);
		for (BaseMenu baseMenu : subMenuList) {
			if (actionUrl.equals(baseMenu.getActionUrl())) {
				return CommonConstant.COMMON_AJAX_SUCCESS;
			}
		}
		return CommonConstant.COMMON_AJAX_ERROR;
	}
}
