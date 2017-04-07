package com.gudeng.commerce.gd.customer.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sensitive_log")
public class SensitiveLogEntity  implements java.io.Serializable{
    /**
    *ID
    */
    private Integer id;

    *敏感词
    */
    private String words;

    *创建时间,过滤时间
    */
    private Date createTime;

    *过滤来源，1为web主站，2为api
    */
    private Integer type;

    @Column(name = "id")
    public Integer getId(){

    }
    public void setId(Integer id){

    }
    @Column(name = "words")
    public String getWords(){

    }
    public void setWords(String words){

    }
    @Column(name = "createTime")
    public Date getCreateTime(){

    }
    public void setCreateTime(Date createTime){

    }
    @Column(name = "type")
    public Integer getType(){

    }
    public void setType(Integer type){

    }
}