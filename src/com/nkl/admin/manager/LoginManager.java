package com.nkl.admin.manager;

import com.nkl.admin.dao.UsersDao;
import com.nkl.admin.domain.Users;
import com.nkl.common.util.MD5Util;
import com.nkl.common.util.StringUtil;

public class LoginManager {
	
	UsersDao usersDao;

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	/**
	 * @Title: getUser
	 * @Description: 查询用户
	 * @param users
	 * @return User
	 */
	public Users getUsers(Users users){
		if (!StringUtil.isEmptyString(users.getUser_pass())) {
//			users.setUser_pass(Md5.makeMd5(users.getUser_pass()));
			users.setUser_pass(MD5Util.code32(users.getUser_pass(), "UTF-8"));
		}
		Users _user = usersDao.getUsers(users);
		System.out.println("用户："+users.getUser_name()+"密码："+users.getUser_pass());
		return _user;
	}
	
	/**
	 * @Title: addUser
	 * @Description: 用户注册
	 * @return void
	 */
	public void addUsers(Users users) {
		//密码加密
		if (!StringUtil.isEmptyString(users.getUser_pass())) {
//			users.setUser_pass(Md5.makeMd5(users.getUser_pass()));
			users.setUser_pass(MD5Util.code32(users.getUser_pass(), "UTF-8"));
		}
		usersDao.addUsers(users);
		
	}  
}
