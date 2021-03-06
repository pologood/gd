
package com.gudeng.commerce.gd.admin.service.sysmgr.impl;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gudeng.commerce.gd.admin.service.sysmgr.SysUserRoleAdminService;
import com.gudeng.commerce.gd.admin.util.GdProperties;
import com.gudeng.commerce.gd.authority.sysmgr.entity.SysUserRole;
import com.gudeng.commerce.gd.authority.sysmgr.service.SysUserRoleService;

/**
 * 用户操作实现类;
 * 
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleAdminService {
	/**
	 * 属性文件，用于获得gd-setting.properties配置文件的值
	 */
	@Autowired
	public GdProperties gdProperties;
	
	private static  SysUserRoleService  sysUserRoleService;
	
	
	private SysUserRoleService hessianSysUserRoleService() throws MalformedURLException {
		String hessianUrl = gdProperties.getSysUserRoleServiceUrl();
		if(sysUserRoleService==null){
			HessianProxyFactory factory = new HessianProxyFactory();
			factory.setOverloadEnabled(true);
			sysUserRoleService = (SysUserRoleService) factory.create(SysUserRoleService.class, hessianUrl);
		}
		return sysUserRoleService;
	}
	
	@Override
	public void delete(String userID) throws Exception{
		hessianSysUserRoleService().delete(userID);
	}

	@Override
	public SysUserRole get(String userID) throws Exception {
		return hessianSysUserRoleService().get(userID);
	}

	@Override
	public List<SysUserRole> getByCondition(Map<String, Object> map) throws Exception {
		return hessianSysUserRoleService().getByCondition(map);
	}

	@Override
	public List<SysUserRole> getListSysUserRole(Map<String, Object> map) throws Exception {
		return hessianSysUserRoleService().getListSysUserRole(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) throws Exception {
		return hessianSysUserRoleService().getTotal(map);
	}

	@Override
	public void insert(SysUserRole sysUserRole) throws Exception {
		hessianSysUserRoleService().insert(sysUserRole);
	}

	@Override
	public void update(SysUserRole sysUserRole) throws Exception {
		hessianSysUserRoleService().update(sysUserRole);
	}

	@Override
	public void batchDelete(List<String> userIdlist) throws Exception {
		hessianSysUserRoleService().batchDelete(userIdlist);
	}

	@Override
	public void insertBatch(String userIDs,String roleID,String createUserID) throws Exception{
		
		hessianSysUserRoleService().insertBatch(userIDs, roleID, createUserID);
	}

	@Override
	public void deleteByUserID(String userID) throws Exception {
		hessianSysUserRoleService().deleteByUserID(userID);
	}

	@Override
	public List<SysUserRole> getUserRoleList(Map<String, Object> map) throws Exception {
		return hessianSysUserRoleService().getUserRoleList(map);
	}
	
	@Override
	public List<SysUserRole> getSysUserList(Map<String, Object> map) throws Exception {
		
		return hessianSysUserRoleService().getSysUserList(map);
	}

	@Override
	public int getSysUserCount(Map<String, Object> map) throws Exception {

		return hessianSysUserRoleService().getSysUserCount(map);
	}

	@Override
	public List<SysUserRole> getUserAllRoleList(Map<String, Object> map) throws Exception {
		
		return hessianSysUserRoleService().getUserAllRoleList(map);
	}

	@Override
	public int getUserAllRoleCount(Map<String, Object> map) throws Exception {
		
		return hessianSysUserRoleService().getUserAllRoleCount(map);
	}

	@Override
	public void insertUserRoleBatch(String userID, String roleIDs, String createUserID) throws Exception {
		hessianSysUserRoleService().insertUserRoleBatch(userID, roleIDs, createUserID);
	}
}
