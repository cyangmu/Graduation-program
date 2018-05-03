package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Custom;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class CustomDao extends BaseDao {

	public void addCustom(Custom custom){
		super.add(custom);
	}

	public void delCustom(String custom_id){
		super.del(Custom.class, custom_id);
	}

	public void delCustoms(String[] custom_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <custom_ids.length; i++) {
			sBuilder.append("'"+custom_ids[i]+"'");
			if (i !=custom_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Custom WHERE custom_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateCustom(Custom custom){
		Custom _custom = (Custom)super.get(Custom.class, custom.getCustom_id());
		if (!StringUtil.isEmptyString(custom.getCustom_name())) {
			_custom.setCustom_name(custom.getCustom_name());
		}
		if (!StringUtil.isEmptyString(custom.getCustom_note())) {
			_custom.setCustom_note(custom.getCustom_note());
		}else {
			_custom.setCustom_note("");
		}
		if (!StringUtil.isEmptyString(custom.getCustom_mail())) {
			_custom.setCustom_mail(custom.getCustom_mail());
		}else {
			_custom.setCustom_mail("");
		}
		if (!StringUtil.isEmptyString(custom.getCustom_phone())) {
			_custom.setCustom_phone(custom.getCustom_phone());
		}else {
			_custom.setCustom_phone("");
		}
		if (!StringUtil.isEmptyString(custom.getCustom_address())) {
			_custom.setCustom_address(custom.getCustom_address());
		}else{
			_custom.setCustom_address("");
		}
		super.update(_custom);
	}

	@SuppressWarnings("rawtypes")
	public Custom getCustom(Custom custom){
		Custom _custom=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Custom WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (custom.getCustom_id()!=null) {
			sBuilder.append(" and custom_id = ? ");
			paramsList.add(custom.getCustom_id());
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
			_custom = (Custom)list.get(0);
		}

		return _custom;
	}

	@SuppressWarnings("rawtypes")
	public List<Custom>  listCustoms(Custom custom){
		List<Custom> customs = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Custom WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (custom.getCustom_id()!=null) {
			sBuilder.append(" and custom_id = ? ");
			paramsList.add(custom.getCustom_id());
		}
		if (!StringUtil.isEmptyString(custom.getCustom_name())) {
			sBuilder.append(" and custom_name like ? ");
			paramsList.add("%"+custom.getCustom_name()+"%");
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by custom_id asc ");

		List list = null;
		if (custom.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, custom.getStart(), custom.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			customs = new ArrayList<Custom>();
			for (Object object : list) {
				customs.add((Custom)object);
			}
		}

		return customs;
	}

	public int  listCustomsCount(Custom custom){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Custom WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (custom.getCustom_id()!=null) {
			sBuilder.append(" and custom_id = ? ");
			paramsList.add(custom.getCustom_id());
		}
		if (!StringUtil.isEmptyString(custom.getCustom_name())) {
			sBuilder.append(" and custom_name like ? ");
			paramsList.add("%"+custom.getCustom_name()+"%");
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
