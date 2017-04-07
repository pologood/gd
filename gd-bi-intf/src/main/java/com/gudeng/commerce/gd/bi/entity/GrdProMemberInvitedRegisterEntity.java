package com.gudeng.commerce.gd.bi.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.gudeng.commerce.gd.bi.annotation.ExcelConf;

@Entity(name = "grd_pro_member_invited_register")
public class GrdProMemberInvitedRegisterEntity  implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6624758126802012564L;

	/**
    *
    */
    private Long id;

    *
    */
    private Long marketId;
    
    private int type;

    *
    */
    //@ExcelConf(excelHeader="所属市场", sort=1)
    private String marketName;

    *团队id
    */
    private Integer teamId;

    *团队名称
    */
    //@ExcelConf(excelHeader="团队名称", sort=2)
    private String teamName;

    *地推人员信息Id
    */
    private Integer grdId;

    *地推姓名
    */
    //@ExcelConf(excelHeader="地推姓名", sort=3)
    private String grdUserName;

    *地推人员手机号
    */
    //@ExcelConf(excelHeader="地推手机", sort=4)
    private String grdMobile;

    *会员Id
    */
    private Integer memberId;

    *会员账号
    */
    //@ExcelConf(excelHeader="会员账号", sort=5)
    private String account;

    *注册来源code
    */
    private String regetype;

    *注册来源显示值
    */
    //@ExcelConf(excelHeader="注册来源", sort=6)
    private String regetypeName;

    *会员姓名
    */
   // @ExcelConf(excelHeader="会员姓名", sort=7)
    private String realName;
    /**
    *会员手机号
    */
    //@ExcelConf(excelHeader="会员手机号", sort=8)
    private String memberMobile;

    *注册时间
    */
   // @ExcelConf(excelHeader="注册时间", sort=9)
    private Date registerTime;

    *
    */
    private String createUserId;

    *
    */
    private Date createTime;

    *
    */
    private String updateUserId;

    *
    */
    private Date updateTime;

    @Column(name = "id")
    public Long getId(){

    }
    public void setId(Long id){

    }
    @Column(name = "marketId")
    public Long getMarketId(){

    }
    public void setMarketId(Long marketId){

    }
    @Column(name = "marketName")
    public String getMarketName(){

    }
    public void setMarketName(String marketName){

    }
    @Column(name = "teamId")
    public Integer getTeamId(){

    }
    public void setTeamId(Integer teamId){

    }
    @Column(name = "teamName")
    public String getTeamName(){

    }
    public void setTeamName(String teamName){

    }
    @Column(name = "grdId")
    public Integer getGrdId(){

    }
    public void setGrdId(Integer grdId){

    }
    @Column(name = "grdUserName")
    public String getGrdUserName(){

    }
    public void setGrdUserName(String grdUserName){

    }
    @Column(name = "grdMobile")
    public String getGrdMobile(){

    }
    public void setGrdMobile(String grdMobile){

    }
    @Column(name = "memberId")
    public Integer getMemberId(){

    }
    public void setMemberId(Integer memberId){

    }
    @Column(name = "account")
    public String getAccount(){

    }
    public void setAccount(String account){

    }
    @Column(name = "regetype")
    public String getRegetype(){

    }
    public void setRegetype(String regetype){

    }
    @Column(name = "regetypeName")
    public String getRegetypeName(){
    	if (regetype != null){
    		if (regetype.equalsIgnoreCase("0")){
    			regetypeName = "管理后台";
    		}else if (regetype.equalsIgnoreCase("1")){
    			regetypeName = "谷登农批网" ;
    		}else if (regetype.equalsIgnoreCase("2")){
    			regetypeName = "农速通(旧)" ;
    		}else if (regetype.equalsIgnoreCase("3")){
    			regetypeName = "农商友" ;
    		}else if (regetype.equalsIgnoreCase("4")){
    			regetypeName = "农商友-农批商" ;
    		}else if (regetype.equalsIgnoreCase("5")){
    			regetypeName = "农批友" ;
    		}else if (regetype.equalsIgnoreCase("6")){
    			regetypeName = "供应商" ;
    		}else if (regetype.equalsIgnoreCase("7")){
    			regetypeName = "POS刷卡" ;
    		}else if (regetype.equalsIgnoreCase("8")){
    			regetypeName = "微信授权" ;
    		}else if (regetype.equalsIgnoreCase("9")){
    			regetypeName = "农速通-货主" ;
    		}else if (regetype.equalsIgnoreCase("10")){
    			regetypeName = "农速通-司机" ;
    		}else if (regetype.equalsIgnoreCase("11")){
    			regetypeName = "农速通-物流公司" ;
    		}else{
    			regetypeName = "";
    		}
    	}
    }
    public void setRegetypeName(String regetypeName){

    }
    @Column(name = "realName")
    public String getRealName(){

    }
    public void setRealName(String realName){

    }
    @Column(name = "memberMobile")
    public String getMemberMobile(){

    }
    public void setMemberMobile(String memberMobile){

    }
    @Column(name = "registerTime")
    public Date getRegisterTime(){

    }
    public void setRegisterTime(Date registerTime){

    }
    @Column(name = "createUserId")
    public String getCreateUserId(){

    }
    public void setCreateUserId(String createUserId){

    }
    @Column(name = "createTime")
    public Date getCreateTime(){

    }
    public void setCreateTime(Date createTime){

    }
    @Column(name = "updateUserId")
    public String getUpdateUserId(){

    }
    public void setUpdateUserId(String updateUserId){

    }
    @Column(name = "updateTime")
    public Date getUpdateTime(){

    }
    public void setUpdateTime(Date updateTime){

    }
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    
}