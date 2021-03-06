package com.gudeng.commerce.gd.customer.dto.certif;

import com.gudeng.commerce.gd.customer.annotation.ExcelConf;
import com.gudeng.commerce.gd.customer.entity.certif.CertifBaseEntity;

/**
 * 谷登科技代码生成器出品,模板不代表正确，请酌情修改
 *
 * @author lidong
 *
 */
public class CertifBaseDTO extends CertifBaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = -1218201106647386295L;

	/**
	 * 临近市场名称
	 */
	private String marketNames;

	private String cateName;

	private String mobile;

	@ExcelConf(excelHeader = "状态", sort = 4)
	private String statusStr;

	@ExcelConf(excelHeader = "申请时间", sort = 3)
	private String commitTimeString;

	/**
	 * 省,中文
	 */
	private String provinceStr;

	/**
	 * 市,中文
	 */
	private String cityStr;

	/**
	 * 县,中文
	 */
	private String areaStr;

	private String reason;

	private String imgHost;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getImgHost() {
		return imgHost;
	}

	public void setImgHost(String imgHost) {
		this.imgHost = imgHost;
	}

	public String getProvinceStr() {
		return provinceStr;
	}

	public void setProvinceStr(String provinceStr) {
		this.provinceStr = provinceStr;
	}

	public String getCityStr() {
		return cityStr;
	}

	public void setCityStr(String cityStr) {
		this.cityStr = cityStr;
	}

	public String getAreaStr() {
		return areaStr;
	}

	public void setAreaStr(String areaStr) {
		this.areaStr = areaStr;
	}

	public String getStatusStr() {
		if ("2".equals(this.getStatus())) {
			return "已驳回";
		} else if ("1".equals(this.getStatus())) {
			return "已认证";
		} else {
			return "待认证";
		}
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getCommitTimeString() {
		return commitTimeString;
	}

	public void setCommitTimeString(String commitTimeString) {
		this.commitTimeString = commitTimeString;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getMarketNames() {
		return marketNames;
	}

	public void setMarketNames(String marketNames) {
		this.marketNames = marketNames;
	}

	private String userStatus;

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}