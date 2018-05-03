package com.nkl.admin.domain;

import java.util.Date;

import com.nkl.common.domain.BaseDomain;
import com.nkl.common.util.DateUtil;

public class Users extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -6195473411597268689L;
	private String rn;
	private String user_id; // null
	private String user_name; // null
	private String user_pass; // null
	private String real_name; // null
	private Integer user_sex; // 1：男 2：女
	private String user_mail; // null
	private String user_phone; // null
	private Date reg_date; // null
	private Integer user_type; // 1:库存部 2:采购部 3:销售部 4:财务部 5:系统管理员

	private String ids;
	private String random;

	public String getUser_typeDesc() {
		switch (user_type) {
		case 1:
			return "库存部用户";
		case 2:
			return "采购部用户";
		case 3:
			return "销售部用户";
		case 4:
			return "财务部用户";
		case 5:
			return "系统管理员";
		default:
			return "";
		}
	}
	
	public String getUser_sexDesc(){
		switch (user_sex) {
		case 1:
			return "男";
		case 2:
			return "女";
		default:
			return "";
		}
	}
	
	public String getReg_dateDesc(){
		try {
			return DateUtil.dateToDateString(reg_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void setUser_id(String user_id){
		this.user_id=user_id;
	}

	public String getUser_id(){
		return user_id;
	}

	public void setUser_name(String user_name){
		this.user_name=user_name;
	}

	public String getUser_name(){
		return user_name;
	}

	public void setUser_pass(String user_pass){
		this.user_pass=user_pass;
	}

	public String getUser_pass(){
		return user_pass;
	}

	public void setReal_name(String real_name){
		this.real_name=real_name;
	}

	public String getReal_name(){
		return real_name;
	}

	public void setUser_sex(Integer user_sex){
		this.user_sex=user_sex;
	}

	public Integer getUser_sex(){
		return user_sex;
	}

	public void setUser_mail(String user_mail){
		this.user_mail=user_mail;
	}

	public String getUser_mail(){
		return user_mail;
	}

	public void setUser_phone(String user_phone){
		this.user_phone=user_phone;
	}

	public String getUser_phone(){
		return user_phone;
	}

	public void setReg_date(Date reg_date){
		this.reg_date=reg_date;
	}

	public Date getReg_date(){
		return reg_date;
	}
	
	public void setUser_type(Integer user_type){
		this.user_type=user_type;
	}

	public Integer getUser_type(){
		return user_type;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getIds() {
		return ids;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getRandom() {
		return random;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getRn() {
		return rn;
	}

}
