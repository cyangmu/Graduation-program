package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Users;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class UsersDao extends BaseDao {

	public void addUsers(Users users){
		super.add(users);
	}

	public void delUsers(String user_id){
		super.del(Users.class, user_id);
	}

	public void delUserss(String[] user_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <user_ids.length; i++) {
			sBuilder.append("'"+user_ids[i]+"'");
			if (i !=user_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Users WHERE user_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateUsers(Users users){
		Users _users = (Users)super.get(Users.class, users.getUser_id());
		if (!StringUtil.isEmptyString(users.getUser_name())) {
			_users.setUser_name(users.getUser_name());
		}
		if (!StringUtil.isEmptyString(users.getUser_pass())) {
			_users.setUser_pass(users.getUser_pass());
		}
		if (!StringUtil.isEmptyString(users.getReal_name())) {
			_users.setReal_name(users.getReal_name());
		}
		if (users.getUser_sex()!=null && users.getUser_sex()!=0) {
			_users.setUser_sex(users.getUser_sex());
		}
		if (!StringUtil.isEmptyString(users.getUser_mail())) {
			_users.setUser_mail(users.getUser_mail());
		}else {
			_users.setUser_mail("");
		}
		if (!StringUtil.isEmptyString(users.getUser_phone())) {
			_users.setUser_phone(users.getUser_phone());
		}else {
			_users.setUser_phone("");
		}
		super.update(_users);
	}

	@SuppressWarnings("rawtypes")
	public Users getUsers(Users users){
		Users _users=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Users WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (users.getUser_id()!=null) {
			sBuilder.append(" and user_id = ? ");
			paramsList.add(users.getUser_id());
		}
		if (!StringUtil.isEmptyString(users.getUser_name())) {
			sBuilder.append(" and user_name = ? ");
			paramsList.add(users.getUser_name());
		}
		if (!StringUtil.isEmptyString(users.getUser_pass())) {
			sBuilder.append(" and user_pass = ? ");
			paramsList.add(users.getUser_pass());
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		List list = super.executeQueryHql(sBuilder.toString(), params);
		if (list != null && list.size() > 0) {
			_users = (Users)list.get(0);
		}

		System.out.println("连接测试1"+users.getUser_name()+"pass:"+users.getUser_pass());
		return _users;
	}

	@SuppressWarnings("rawtypes")
	public List<Users>  listUserss(Users users){
		List<Users> userss = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Users WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (users.getUser_id()!=null) {
			sBuilder.append(" and user_id = ? ");
			paramsList.add(users.getUser_id());
		}
		if (!StringUtil.isEmptyString(users.getUser_name())) {
			sBuilder.append(" and user_name like ? ");
			paramsList.add("%"+users.getUser_name()+"%");
		}
		if (!StringUtil.isEmptyString(users.getReal_name())) {
			sBuilder.append(" and real_name like ? ");
			paramsList.add("%"+users.getReal_name()+"%");
		}
		if (users.getUser_type()!=null) {
			sBuilder.append(" and user_type = ? ");
			paramsList.add(users.getUser_type());
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by user_id asc ");

		List list = null;
		if (users.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, users.getStart(), users.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			userss = new ArrayList<Users>();
			for (Object object : list) {
				userss.add((Users)object);
			}
		}

		return userss;
	}

	public int  listUserssCount(Users users){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Users WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (users.getUser_id()!=null) {
			sBuilder.append(" and user_id = ? ");
			paramsList.add(users.getUser_id());
		}
		if (!StringUtil.isEmptyString(users.getUser_name())) {
			sBuilder.append(" and user_name like ? ");
			paramsList.add("%"+users.getUser_name()+"%");
		}
		if (!StringUtil.isEmptyString(users.getReal_name())) {
			sBuilder.append(" and real_name like ? ");
			paramsList.add("%"+users.getReal_name()+"%");
		}
		if (users.getUser_type()!=null) {
			sBuilder.append(" and user_type = ? ");
			paramsList.add(users.getUser_type());
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		long count = (Long)super.executeQueryCountHql(sBuilder.toString(), params);
		sum = (int)count;
		return sum;
	}

}
