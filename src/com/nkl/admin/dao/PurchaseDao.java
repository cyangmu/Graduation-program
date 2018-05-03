package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.nkl.admin.domain.Purchase;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.DateUtil;
import com.nkl.common.util.StringUtil;

public class PurchaseDao extends BaseDao {

	public void addPurchase(Purchase purchase){
		super.add(purchase);
	}

	public void delPurchase(String purchase_id){
		super.del(Purchase.class, purchase_id);
	}

	public void delPurchases(String[] purchase_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <purchase_ids.length; i++) {
			sBuilder.append("'"+purchase_ids[i]+"'");
			if (i !=purchase_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Purchase WHERE purchase_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}
	
	public void delPurchases2(String[] purchase_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <purchase_ids.length; i++) {
			sBuilder.append("'"+purchase_ids[i]+"'");
			if (i !=purchase_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "UPDATE Purchase set apply_flag=3 WHERE purchase_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updatePurchase(Purchase purchase){
		Purchase _purchase = (Purchase)super.get(Purchase.class, purchase.getPurchase_id());
		if (!StringUtil.isEmptyString(purchase.getGoods_id())) {
			_purchase.setGoods_id(purchase.getGoods_id());
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_no())) {
			_purchase.setGoods_no(purchase.getGoods_no());
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_name())) {
			_purchase.setGoods_name(purchase.getGoods_name());
		}
		if (purchase.getGoods_count()!=null) {
			_purchase.setGoods_count(purchase.getGoods_count());
		}
		if (purchase.getGoods_price()!=null) {
			_purchase.setGoods_price(purchase.getGoods_price());
		}
		if (purchase.getPurchase_money()!=null) {
			_purchase.setPurchase_money(purchase.getPurchase_money());
		}
		if (!StringUtil.isEmptyString(purchase.getSupplier_id())) {
			_purchase.setSupplier_id(purchase.getSupplier_id());
		}
		if (!StringUtil.isEmptyString(purchase.getSupplier_name())) {
			_purchase.setSupplier_name(purchase.getSupplier_name());
		}
		if (purchase.getApply_flag()!=null && purchase.getApply_flag().intValue()!=0) {
			_purchase.setApply_flag(purchase.getApply_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_no())) {
			_purchase.setPurchase_no(purchase.getPurchase_no());
		}
		if (purchase.getOrders_date()!=null) {
			_purchase.setOrders_date(purchase.getOrders_date());
		}
		if (purchase.getBuy_id()!=null) {
			_purchase.setBuy_id(purchase.getBuy_id());
		}
		if (!StringUtil.isEmptyString(purchase.getBuy_name())) {
			_purchase.setBuy_name(purchase.getBuy_name());
		}
		if (purchase.getPurchase_flag()!=null && purchase.getPurchase_flag().intValue()!=0) {
			_purchase.setPurchase_flag(purchase.getPurchase_flag());
		}
		if (purchase.getCheck_flag()!=null && purchase.getCheck_flag().intValue()!=0) {
			_purchase.setCheck_flag(purchase.getCheck_flag());
		}
		super.update(_purchase);
	}

	@SuppressWarnings("rawtypes")
	public Purchase getPurchase(Purchase purchase){
		Purchase _purchase=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Purchase WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (purchase.getPurchase_id()!=null) {
			sBuilder.append(" and purchase_id = ? ");
			paramsList.add(purchase.getPurchase_id());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_no())) {
			sBuilder.append(" and purchase_no = ? ");
			paramsList.add(purchase.getPurchase_no());
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
			_purchase = (Purchase)list.get(0);
		}

		return _purchase;
	}

	@SuppressWarnings("rawtypes")
	public List<Purchase>  listPurchases(Purchase purchase){
		List<Purchase> purchases = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Purchase WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (purchase.getPurchase_id()!=null) {
			sBuilder.append(" and purchase_id = ? ");
			paramsList.add(purchase.getPurchase_id());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_no())) {
			sBuilder.append(" and purchase_no like ? ");
			paramsList.add("%"+purchase.getPurchase_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+purchase.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+purchase.getGoods_name()+"%");
		}
		if (purchase.getApply_flag()!=null && purchase.getApply_flag().intValue()!=0) {
			sBuilder.append(" and apply_flag = ? ");
			paramsList.add(purchase.getApply_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getApply_flags())) {
			sBuilder.append(" and apply_flag in ("+purchase.getApply_flags()+") ");
		}
		if (purchase.getPurchase_flag()!=null && purchase.getPurchase_flag().intValue()!=0) {
			sBuilder.append(" and purchase_flag = ? ");
			paramsList.add(purchase.getPurchase_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_flags())) {
			sBuilder.append(" and purchase_flag in ("+purchase.getPurchase_flags()+") ");
		}
		if (purchase.getCheck_flag()!=null && purchase.getCheck_flag().intValue()!=0) {
			sBuilder.append(" and check_flag = ? ");
			paramsList.add(purchase.getCheck_flag());
		}
		if (purchase.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(purchase.getApply_dateMin());
		}
		if (purchase.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getApply_dateMax(), 1));
		}
		if (purchase.getOrders_dateMin()!=null) {
			sBuilder.append(" and orders_date >= ? ");
			paramsList.add(purchase.getOrders_dateMin());
		}
		if (purchase.getOrders_dateMax()!=null) {
			sBuilder.append(" and orders_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getOrders_dateMax(),1));
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by orders_date desc ");

		List list = null;
		if (purchase.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, purchase.getStart(), purchase.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			purchases = new ArrayList<Purchase>();
			for (Object object : list) {
				purchases.add((Purchase)object);
			}
		}

		return purchases;
	}

	public int  listPurchasesCount(Purchase purchase){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Purchase WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (purchase.getPurchase_id()!=null) {
			sBuilder.append(" and purchase_id = ? ");
			paramsList.add(purchase.getPurchase_id());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_no())) {
			sBuilder.append(" and purchase_no like ? ");
			paramsList.add("%"+purchase.getPurchase_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+purchase.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+purchase.getGoods_name()+"%");
		}
		if (purchase.getApply_flag()!=null && purchase.getApply_flag().intValue()!=0) {
			sBuilder.append(" and apply_flag = ? ");
			paramsList.add(purchase.getApply_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getApply_flags())) {
			sBuilder.append(" and apply_flag in ("+purchase.getApply_flags()+") ");
		}
		if (purchase.getPurchase_flag()!=null && purchase.getPurchase_flag().intValue()!=0) {
			sBuilder.append(" and purchase_flag = ? ");
			paramsList.add(purchase.getPurchase_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_flags())) {
			sBuilder.append(" and purchase_flag in ("+purchase.getPurchase_flags()+") ");
		}
		if (purchase.getCheck_flag()!=null && purchase.getCheck_flag().intValue()!=0) {
			sBuilder.append(" and check_flag = ? ");
			paramsList.add(purchase.getCheck_flag());
		}
		if (purchase.getApply_dateMin()!=null) {
			sBuilder.append(" and apply_date >= ? ");
			paramsList.add(purchase.getApply_dateMin());
		}
		if (purchase.getApply_dateMax()!=null) {
			sBuilder.append(" and apply_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getApply_dateMax(), 1));
		}
		if (purchase.getOrders_dateMin()!=null) {
			sBuilder.append(" and orders_date >= ? ");
			paramsList.add(purchase.getOrders_dateMin());
		}
		if (purchase.getOrders_dateMax()!=null) {
			sBuilder.append(" and orders_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getOrders_dateMax(),1));
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
	public List<Purchase>  listPurchasesSum(Purchase purchase){
		List<Purchase> purchases = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("Select goods_no,goods_name,sum(goods_count) goods_count,sum(purchase_money) purchase_money FROM purchase WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (!StringUtil.isEmptyString(purchase.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+purchase.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+purchase.getGoods_name()+"%");
		}
		if (purchase.getPurchase_flag()!=null && purchase.getPurchase_flag().intValue()!=0) {
			sBuilder.append(" and purchase_flag = ? ");
			paramsList.add(purchase.getPurchase_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_flags())) {
			sBuilder.append(" and purchase_flag in ("+purchase.getPurchase_flags()+") ");
		}
		if (purchase.getOrders_dateMin()!=null) {
			sBuilder.append(" and orders_date >= ? ");
			paramsList.add(purchase.getOrders_dateMin());
		}
		if (purchase.getOrders_dateMax()!=null) {
			sBuilder.append(" and orders_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getOrders_dateMax(),1));
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

		String[] scalars = {"goods_no","goods_name","goods_count","purchase_money"};
		Type[] types = {Hibernate.STRING,Hibernate.STRING,Hibernate.INTEGER,Hibernate.DOUBLE};

		List list = null;
		if (purchase.getStart()!=-1) {
			list = super.executeQueryJavaBeanSql(sBuilder.toString(), purchase.getClass(), params, scalars, types, purchase.getStart(), purchase.getLimit());
		}else {
			list = super.executeQueryJavaBeanSql(sBuilder.toString(), purchase.getClass(), params, scalars, types);
		}
		if (list != null && list.size() > 0) {
			purchases = new ArrayList<Purchase>();
			for (Object object : list) {
				purchases.add((Purchase)object);
			}
		}

		return purchases;
	}

	public int  listPurchasesSumCount(Purchase purchase){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(distinct goods_no) FROM Purchase WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (!StringUtil.isEmptyString(purchase.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+purchase.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(purchase.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+purchase.getGoods_name()+"%");
		}
		if (purchase.getPurchase_flag()!=null && purchase.getPurchase_flag().intValue()!=0) {
			sBuilder.append(" and purchase_flag = ? ");
			paramsList.add(purchase.getPurchase_flag());
		}
		if (!StringUtil.isEmptyString(purchase.getPurchase_flags())) {
			sBuilder.append(" and purchase_flag in ("+purchase.getPurchase_flags()+") ");
		}
		if (purchase.getOrders_dateMin()!=null) {
			sBuilder.append(" and orders_date >= ? ");
			paramsList.add(purchase.getOrders_dateMin());
		}
		if (purchase.getOrders_dateMax()!=null) {
			sBuilder.append(" and orders_date <= ? ");
			paramsList.add(DateUtil.getDateAfter(purchase.getOrders_dateMax(),1));
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
