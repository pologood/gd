package com.gudeng.commerce.gd.customer.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "mq_async_error")
public class MqAsyncErrorEntity  implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7901691603660262714L;

	/**
    *主键id
    */
    private Integer id;

    *操作类型：0 创建 1 更新 2删除
    */
    private Integer crud;

    * mq 消息 Dto json
    */
    private String content;

    *创建时间
    */
    private Date createTime;

    *是否已经发送：0 未重新发送 1 已经重新发送
    */
    private Integer status;

    *标识为哪个mq：1为会员（member) 2为银行卡（bank) 其余待补
    */
    private Integer type;

    @Column(name = "id")
    public Integer getId(){

    }
    public void setId(Integer id){

    }
    @Column(name = "crud")
    public Integer getCrud(){

    }
    public void setCrud(Integer crud){

    }
    @Column(name = "content")
    public String getContent(){

    }
    public void setContent(String content){

    }
    @Column(name = "createTime")
    public Date getCreateTime(){

    }
    public void setCreateTime(Date createTime){

    }
    @Column(name = "status")
    public Integer getStatus(){

    }
    public void setStatus(Integer status){

    }
    @Column(name = "type")
    public Integer getType(){

    }
    public void setType(Integer type){

    }
}