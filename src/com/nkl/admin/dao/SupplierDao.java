package com.nkl.admin.dao;

import java.util.ArrayList;
import java.util.List;

import com.nkl.admin.domain.Supplier;
import com.nkl.common.dao.BaseDao;
import com.nkl.common.util.StringUtil;

public class SupplierDao extends BaseDao {

	public void addSupplier(Supplier supplier){
		super.add(supplier);
	}

	public void delSupplier(String supplier_id){
		super.del(Supplier.class, supplier_id);
	}

	public void delSuppliers(String[] supplier_ids){
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i <supplier_ids.length; i++) {
			sBuilder.append("'"+supplier_ids[i]+"'");
			if (i !=supplier_ids.length-1) {
				sBuilder.append(",");
			}
		}
		String hql = "DELETE FROM Supplier WHERE supplier_id IN(" +sBuilder.toString()+")";

		Object[] params = null;

		super.executeUpdateHql(hql, params);
	}

	public void updateSupplier(Supplier supplier){
		Supplier _supplier = (Supplier)super.get(Supplier.class, supplier.getSupplier_id());
		if (!StringUtil.isEmptyString(supplier.getSupplier_name())) {
			_supplier.setSupplier_name(supplier.getSupplier_name());
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_note())) {
			_supplier.setSupplier_note(supplier.getSupplier_note());
		}else {
			_supplier.setSupplier_note("");
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_mail())) {
			_supplier.setSupplier_mail(supplier.getSupplier_mail());
		}else {
			_supplier.setSupplier_mail("");
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_phone())) {
			_supplier.setSupplier_phone(supplier.getSupplier_phone());
		}else {
			_supplier.setSupplier_phone("");
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_address())) {
			_supplier.setSupplier_address(supplier.getSupplier_address());
		}else {
			_supplier.setSupplier_address("");
		}
		super.update(_supplier);
	}

	@SuppressWarnings("rawtypes")
	public Supplier getSupplier(Supplier supplier){
		Supplier _supplier=null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Supplier WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (supplier.getSupplier_id()!=null) {
			sBuilder.append(" and supplier_id = ? ");
			paramsList.add(supplier.getSupplier_id());
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
			_supplier = (Supplier)list.get(0);
		}

		return _supplier;
	}

	@SuppressWarnings("rawtypes")
	public List<Supplier>  listSuppliers(Supplier supplier){
		List<Supplier> suppliers = null;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("FROM Supplier WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (supplier.getSupplier_id()!=null) {
			sBuilder.append(" and supplier_id = ? ");
			paramsList.add(supplier.getSupplier_id());
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_name())) {
			sBuilder.append(" and supplier_name like ? ");
			paramsList.add("%"+supplier.getSupplier_name()+"%");
		}

		Object[] params = null;
		if (paramsList.size()>0) {
			params = new Object[paramsList.size()];
			for (int i = 0; i < paramsList.size(); i++) {
				params[i] = paramsList.get(i);
			}
		}

		sBuilder.append(" order by supplier_id asc ");

		List list = null;
		if (supplier.getStart()!=-1) {
			list = super.findByPageHql(sBuilder.toString(), params, supplier.getStart(), supplier.getLimit());
		}else {
			list = super.executeQueryHql(sBuilder.toString(), params);
		}
		if (list != null && list.size() > 0) {
			suppliers = new ArrayList<Supplier>();
			for (Object object : list) {
				suppliers.add((Supplier)object);
			}
		}

		return suppliers;
	}

	public int  listSuppliersCount(Supplier supplier){
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("SELECT count(*) FROM Supplier WHERE 1=1");
		List<Object> paramsList = new ArrayList<Object>();
		if (supplier.getSupplier_id()!=null) {
			sBuilder.append(" and supplier_id = ? ");
			paramsList.add(supplier.getSupplier_id());
		}
		if (!StringUtil.isEmptyString(supplier.getSupplier_name())) {
			sBuilder.append(" and supplier_name like ? ");
			paramsList.add("%"+supplier.getSupplier_name()+"%");
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
