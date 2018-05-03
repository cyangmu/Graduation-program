package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Goods;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class GoodsDao extends BaseDao {

	public void addGoods(Goods goods){
		super.add(goods);
	}

	public void delGoods(String goods_id){
		super.del(Goods.class, goods_id);
	}

	public void delGoodss(String[] goods_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <goods_ids.length; i++) {
			sBuilder.append("'"+goods_ids[i]+"'");
			if (i !=goods_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Goods WHERE goods_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateGoods(Goods goods){
		Goods _goods = (Goods)super.get(Goods.class, goods.getGoods_id());
		if (!StringUtil.isEmptyString(goods.getGoods_no())) {
			_goods.setGoods_no(goods.getGoods_no());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_name())) {
			_goods.setGoods_name(goods.getGoods_name());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_desc())) {
			_goods.setGoods_desc(goods.getGoods_desc());
		}else {
			_goods.setGoods_desc("");
		}
		if (goods.getGoods_count()!=null) {
			_goods.setGoods_count(goods.getGoods_count());
		}
		if (goods.getAlarm_count()!=null) {
			_goods.setAlarm_count(goods.getAlarm_count());
		}
		if (goods.getMax_count()!=null) {
			_goods.setMax_count(goods.getMax_count());
		}
		if (goods.getGoods_flag()!=null && goods.getGoods_flag().intValue()!=0) {
			_goods.setGoods_flag(goods.getGoods_flag());
		}
		if (goods.getKind()!=null && !StringUtil.isEmptyString(goods.getKind().getKind_id())) {
			_goods.setKind(goods.getKind());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_mate())) {
			_goods.setGoods_mate(goods.getGoods_mate());
		}else {
			_goods.setGoods_mate("");
		}
		if (!StringUtil.isEmptyString(goods.getGoods_brand())) {
			_goods.setGoods_brand(goods.getGoods_brand());
		}else {
			_goods.setGoods_brand("");
		}
		if (!StringUtil.isEmptyString(goods.getGoods_year())) {
			_goods.setGoods_year(goods.getGoods_year());
		}else {
			_goods.setGoods_year("");
		}
		if (!StringUtil.isEmptyString(goods.getGoods_pic())) {
			_goods.setGoods_pic(goods.getGoods_pic());
		}
		super.update(_goods);
	}
	public void updateGoodsCount(Goods goods){
		Goods _goods = (Goods)super.get(Goods.class, goods.getGoods_id());
		if (goods.getGoods_count()!=null) {
			_goods.setGoods_count(goods.getGoods_count());
		}
		if (goods.getAlarm_count()!=null) {
			_goods.setAlarm_count(goods.getAlarm_count());
		}
		if (goods.getMax_count()!=null) {
			_goods.setMax_count(goods.getMax_count());
		}
		if (goods.getGoods_flag()!=null && goods.getGoods_flag()!=0) {
			_goods.setGoods_flag(goods.getGoods_flag());
		}
		super.update(_goods);
	}

	@SuppressWarnings("rawtypes")
	public Goods getGoods(Goods goods){
		Goods _goods=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Goods g join fetch g.kind k WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (goods.getGoods_id()!=null) {
			sBuilder.append(" and goods_id = ? ");
			paramsList.add(goods.getGoods_id());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_no())) {
			sBuilder.append(" and goods_no = ? ");
			paramsList.add(goods.getGoods_no());
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
			_goods = (Goods)list.get(0);
		}

		return _goods;
	}

	@SuppressWarnings("rawtypes")
	public List<Goods>  listGoodss(Goods goods){
		List<Goods> goodss = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Goods g join fetch g.kind k WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (goods.getGoods_id()!=null) {
			sBuilder.append(" and goods_id = ? ");
			paramsList.add(goods.getGoods_id());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+goods.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(goods.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+goods.getGoods_name()+"%");
		}
		if (goods.getKind()!=null && !StringUtil.isEmptyString(goods.getKind().getKind_id())) {
			sBuilder.append(" and k.kind_id = ? ");
			paramsList.add(goods.getKind().getKind_id());
		}
		if (goods.getGoods_flag()!=null && goods.getGoods_flag().intValue()!=0) {
			sBuilder.append(" and goods_flag = ? ");
			paramsList.add(goods.getGoods_flag());
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by goods_id asc ");

		List list = null;
		if (goods.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, goods.getStart(), goods.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			goodss = new ArrayList<Goods>();
			for (Object object : list) {
				goodss.add((Goods)object);
			}
		}

		return goodss;
	}

	public int  listGoodssCount(Goods goods){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Goods g WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (goods.getGoods_id()!=null) {
			sBuilder.append(" and goods_id = ? ");
			paramsList.add(goods.getGoods_id());
		}
		if (!StringUtil.isEmptyString(goods.getGoods_no())) {
			sBuilder.append(" and goods_no like ? ");
			paramsList.add("%"+goods.getGoods_no()+"%");
		}
		if (!StringUtil.isEmptyString(goods.getGoods_name())) {
			sBuilder.append(" and goods_name like ? ");
			paramsList.add("%"+goods.getGoods_name()+"%");
		}
		if (goods.getKind()!=null && !StringUtil.isEmptyString(goods.getKind().getKind_id())) {
			sBuilder.append(" and g.kind.kind_id = ? ");
			paramsList.add(goods.getKind().getKind_id());
		}
		if (goods.getGoods_flag()!=null && goods.getGoods_flag().intValue()!=0) {
			sBuilder.append(" and goods_flag = ? ");
			paramsList.add(goods.getGoods_flag());
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
