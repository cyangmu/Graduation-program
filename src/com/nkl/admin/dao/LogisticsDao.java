package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Logistics;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class LogisticsDao extends BaseDao {

	public void addLogistics(Logistics logistics){
		super.add(logistics);
	}

	public void delLogistics(String logistics_id){
		super.del(Logistics.class, logistics_id);
	}

	public void delLogisticss(String[] logistics_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <logistics_ids.length; i++) {
			sBuilder.append("'"+logistics_ids[i]+"'");
			if (i !=logistics_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Logistics WHERE logistics_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateLogistics(Logistics logistics){
		Logistics _logistics = (Logistics)super.get(Logistics.class, logistics.getLogistics_id());
		super.update(_logistics);
	}

	@SuppressWarnings("rawtypes")
	public Logistics getLogistics(Logistics logistics){
		Logistics _logistics=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Logistics WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (logistics.getLogistics_id()!=null) {
			sBuilder.append(" and logistics_id = ? ");
			paramsList.add(logistics.getLogistics_id());
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
			_logistics = (Logistics)list.get(0);
		}

		return _logistics;
	}

	@SuppressWarnings("rawtypes")
	public List<Logistics>  listLogisticss(Logistics logistics){
		List<Logistics> logisticss = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Logistics WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (logistics.getLogistics_id()!=null) {
			sBuilder.append(" and logistics_id = ? ");
			paramsList.add(logistics.getLogistics_id());
		}
		if (!StringUtil.isEmptyString(logistics.getOrders_no())) {
			sBuilder.append(" and orders_no = ? ");
			paramsList.add(logistics.getOrders_no());
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by logistics_date asc ");

		List list = null;
		if (logistics.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, logistics.getStart(), logistics.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			logisticss = new ArrayList<Logistics>();
			for (Object object : list) {
				logisticss.add((Logistics)object);
			}
		}

		return logisticss;
	}

	public int  listLogisticssCount(Logistics logistics){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Logistics WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (logistics.getLogistics_id()!=null) {
			sBuilder.append(" and logistics_id = ? ");
			paramsList.add(logistics.getLogistics_id());
		}
		if (!StringUtil.isEmptyString(logistics.getOrders_no())) {
			sBuilder.append(" and orders_no = ? ");
			paramsList.add(logistics.getOrders_no());
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
