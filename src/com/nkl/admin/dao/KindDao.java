package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Kind;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class KindDao extends BaseDao {

	public void addKind(Kind kind){
		super.add(kind);
	}

	public void delKind(String kind_id){
		super.del(Kind.class, kind_id);
	}

	public void delKinds(String[] kind_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <kind_ids.length; i++) {
			sBuilder.append("'"+kind_ids[i]+"'");
			if (i !=kind_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Kind WHERE kind_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateKind(Kind kind){
		Kind _kind = (Kind)super.get(Kind.class, kind.getKind_id());
		if (!StringUtil.isEmptyString(kind.getKind_name())) {
			_kind.setKind_name(kind.getKind_name());
		}
		if (!StringUtil.isEmptyString(kind.getKind_note())) {
			_kind.setKind_note(kind.getKind_note());
		}else {
			_kind.setKind_note("");
		}
		super.update(_kind);
	}

	@SuppressWarnings("rawtypes")
	public Kind getKind(Kind kind){
		Kind _kind=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Kind WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (kind.getKind_id()!=null) {
			sBuilder.append(" and kind_id = ? ");
			paramsList.add(kind.getKind_id());
		}
		if (!StringUtil.isEmptyString(kind.getKind_name())) {
			sBuilder.append(" and kind_name = ? ");
			paramsList.add(kind.getKind_name());
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
			_kind = (Kind)list.get(0);
		}

		return _kind;
	}

	@SuppressWarnings("rawtypes")
	public List<Kind>  listKinds(Kind kind){
		List<Kind> kinds = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Kind WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (kind.getKind_id()!=null) {
			sBuilder.append(" and kind_id = ? ");
			paramsList.add(kind.getKind_id());
		}
		if (!StringUtil.isEmptyString(kind.getKind_name())) {
			sBuilder.append(" and kind_name like ? ");
			paramsList.add("%"+kind.getKind_name()+"%");
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by kind_id asc ");

		List list = null;
		if (kind.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, kind.getStart(), kind.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			kinds = new ArrayList<Kind>();
			for (Object object : list) {
				kinds.add((Kind)object);
			}
		}

		return kinds;
	}

	public int  listKindsCount(Kind kind){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Kind WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (kind.getKind_id()!=null) {
			sBuilder.append(" and kind_id = ? ");
			paramsList.add(kind.getKind_id());
		}
		if (!StringUtil.isEmptyString(kind.getKind_name())) {
			sBuilder.append(" and kind_name like ? ");
			paramsList.add("%"+kind.getKind_name()+"%");
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
