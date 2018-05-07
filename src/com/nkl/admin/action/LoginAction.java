package com.nkl.admin.action;

import com.nkl.admin.domain.Users;
import com.nkl.admin.manager.LoginManager;
import com.nkl.common.action.BaseAction;
import com.nkl.common.util.BeanLocator;
import com.nkl.common.util.Param;

public class LoginAction  extends BaseAction {

	private static final long serialVersionUID = 1L;
	LoginManager loginManager = (LoginManager)BeanLocator.getInstance().getBean("loginManager");
	
	Users params;
	String tip;

	/**
	 * @Title: InSystem
	 * @Description: 用户登录
	 * @return String
	 */
	public String InSystem(){
		try {
			//验证码验证
			String random = (String) Param.getSession("random");
			if (random == "" && random != null) {
			if (!random.equals(params.getRandom())) {
				tip = "验证码错误";
				return "error";
			}
			}
			//用户登录查询
			Users admin = loginManager.getUsers(params);
			if (admin!=null) {
				Param.setSession("admin", admin);
			}else {
				tip="用户名或密码错误";
				return "error";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			tip="登录异常，请稍后重试";
			return "error";
		}
		
		return "success";
	}
	
	/**
	 * @Title: OutSystem
	 * @Description: 退出登录
	 * @return String
	 */
	public String OutSystem(){
		try {
			//用户查询
			Users user = (Users)Param.getSession("admin");
			if (user!=null) {
				//退出登录
				Param.removeSession("admin");
			}
			
		} catch (Exception e) {
			return "logout";
		}
		
		return "logout";
	}
	
	public Users getParams() {
		return params;
	}

	public void setParams(Users params) {
		this.params = params;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
