package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.nkl.admin.domain.Orders;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.StringUtil;

public class OrdersDao extends BaseDao {

	public void addOrders(Orders orders){
		super.add(orders);
	}

	public void delOrders(String orders_id){
		super.del(Orders.class, orders_id);
	}

	public void delOrderss(String[] orders_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <orders_ids.length; i++) {
			sBuilder.append("'"+orders_ids[i]+"'");
			if (i !=orders_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Orders WHERE orders_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateOrders(Orders orders){
		Orders _orders = (Orders)super.get(Orders.class, orders.getOrders_id());
		if (!StringUtil.isEmptyString(orders.getGoods_id())) {
			_orders.setGoods_id(orders.getGoods_id());
		}
		if (!StringUtil.isEmptyString(orders.getGoods_no())) {
			_orders.setGoods_no(orders.getGoods_no());
		}
		if (!StringUtil.isEmptyString(orders.getGoods_name())) {
			_orders.setGoods_name(orders.getGoods_name());
		}
		if (orders.getGoods_count()!=null) {
			_orders.setGoods_count(orders.getGoods_count());
		}
		if (orders.getGoods_price()!=null) {
			_orders.setGoods_price(orders.getGoods_price());
		}
		if (orders.getOrders_money()!=null) {
			_orders.setOrders_money(orders.getOrders_money());
		}
		if (orders.getCustom_id()!=null) {
			orders.setCustom_id(orders.getCustom_id());
		}
		if (!StringUtil.isEmptyString(orders.getCustom_name())) {
			orders.setCustom_name(orders.getCustom_name());
		}
		if (orders.getPay_type()!=null) {
			_orders.setPay_type(orders.getPay_type());
		}
		if (!StringUtil.isEmptyString(orders.getContract_file())) {
			_orders.setContract_file(orders.getContract_file());
		}
		if (orders.getOrders_flag()!=null && orders.getOrders_flag().intValue()!=0) {
			_orders.setOrders_flag(orders.getOrders_flag());
		}
		super.update(_orders);
	}

	@SuppressWarnings("rawtypes")
	public Orders getOrders(Orders orders){
		Orders _orders=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Orders WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (orders.getOrders_id()!=null) {
			sBuilder.append(" and orders_id = ? ");
			paramsList.add(orders.getOrders_id());
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
			_orders = (Orders)list.get(0);
		}

		return _orders;
	}

	@SuppressWarnings("rawtypes")
	public List<Orders>  listOrderss(Orders orders){
		List<Orders> orderss = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Orders WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (orders.getOrders_id()!=null) {
			sBuilder.append(" and orders_id = ? ");
			paramsList.add(orders.getOrders_id());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_no())) {
			sBuilder.append(" and orders_no like ? ");
			paramsList.add("%"+orders.getOrders_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+orders.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+orders.getGoods_name()+"%");
		}
		if (orders.getOrders_flag()!=null && orders.getOrders_flag().intValue()!=0) {
			sBuilder.append(" and orders_flag = ? ");
			paramsList.add(orders.getOrders_flag());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_flags())) {
			sBuilder.append(" and orders_flag in ("+orders.getOrders_flags()+") ");
		}
		if (orders.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(orders.getApply_dateMin());
		}
		if (orders.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(orders.getApply_dateMax(),1));
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by apply_date desc ");

		List list = null;
		if (orders.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, orders.getStart(), orders.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			orderss = new ArrayList<Orders>();
			for (Object object : list) {
				orderss.add((Orders)object);
			}
		}

		return orderss;
	}

	public int  listOrderssCount(Orders orders){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Orders WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (orders.getOrders_id()!=null) {
			sBuilder.append(" and orders_id = ? ");
			paramsList.add(orders.getOrders_id());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_no())) {
			sBuilder.append(" and orders_no like ? ");
			paramsList.add("%"+orders.getOrders_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+orders.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+orders.getGoods_name()+"%");
		}
		if (orders.getOrders_flag()!=null && orders.getOrders_flag().intValue()!=0) {
			sBuilder.append(" and orders_flag = ? ");
			paramsList.add(orders.getOrders_flag());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_flags())) {
			sBuilder.append(" and orders_flag in ("+orders.getOrders_flags()+") ");
		}
		if (orders.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(orders.getApply_dateMin());
		}
		if (orders.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(orders.getApply_dateMax(),1));
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
	
	@SuppressWarnings("rawtypes")
	public List<Orders>  listOrderssSum(Orders orders){
		List<Orders> orderss = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Select goods_no,goods_name,sum(goods_count) goods_count,sum(orders_money) orders_money FROM orders WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (!StringUtil.isEmptyString(orders.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+orders.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+orders.getGoods_name()+"%");
		}
		if (orders.getOrders_flag()!=null && orders.getOrders_flag().intValue()!=0) {
			sBuilder.append(" and orders_flag = ? ");
			paramsList.add(orders.getOrders_flag());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_flags())) {
			sBuilder.append(" and orders_flag in ("+orders.getOrders_flags()+") ");
		}
		if (orders.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(orders.getApply_dateMin());
		}
		if (orders.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(orders.getApply_dateMax(),1));
		}
		sBuilder.append(" group by goods_no,goods_name ");
		sBuilder.append(" order by goods_no,goods_name ");
		
		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		String[] scalars = {"goods_no","goods_name","goods_count","orders_money"};
		Type[] types = {Hibernate.STRING,Hibernate.STRING,Hibernate.INTEGER,Hibernate.DOUBLE};

		List list = null;
		if (orders.getStart()!=-1) {
			list = super.executeQueryJavaBeanSql(sBuilder.toString(), orders.getClass(), params, scalars, types, orders.getStart(), orders.getLimit());
		}else {
			list = super.executeQueryJavaBeanSql(sBuilder.toString(), orders.getClass(), params, scalars, types);
		}
		if (list != null && list.size() > 0) {
			orderss = new ArrayList<Orders>();
			for (Object object : list) {
				orderss.add((Orders)object);
			}
		}

		return orderss;
	}

	public int  listOrderssSumCount(Orders orders){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(distinct goods_no) FROM Orders WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (!StringUtil.isEmptyString(orders.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+orders.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(orders.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+orders.getGoods_name()+"%");
		}
		if (orders.getOrders_flag()!=null && orders.getOrders_flag().intValue()!=0) {
			sBuilder.append(" and orders_flag = ? ");
			paramsList.add(orders.getOrders_flag());
		}
		if (!StringUtil.isEmptyString(orders.getOrders_flags())) {
			sBuilder.append(" and orders_flag in ("+orders.getOrders_flags()+") ");
		}
		if (orders.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(orders.getApply_dateMin());
		}
		if (orders.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(orders.getApply_dateMax(),1));
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
