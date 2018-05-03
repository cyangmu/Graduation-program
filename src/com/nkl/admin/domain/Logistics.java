package com.nkl.admin.domain;

import java.util.Date;

import com.nkl.common.domain.BaseDomain;
import com.nkl.common.util.DateUtil;

public class Logistics extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4967278615538873232L;
	private String rn;
	private String logistics_id; // null
	private String orders_no; // null
	private Date logistics_date; // null
	private String logistics_desc; // null

	private String ids;
	private String random;

	public void setLogistics_id(String logistics_id){
		this.logistics_id=logistics_id;
	}

	public String getLogistics_id(){
		return logistics_id;
	}

	public void setOrders_no(String orders_no){
		this.orders_no=orders_no;
	}

	public String getOrders_no(){
		return orders_no;
	}

	public void setLogistics_date(Date logistics_date){
		this.logistics_date=logistics_date;
	}

	public Date getLogistics_date(){
		return logistics_date;
	}
	
	public String getLogistics_dateDesc(){
		try {
			return DateUtil.dateToDateString(logistics_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void setLogistics_desc(String logistics_desc){
		this.logistics_desc=logistics_desc;
	}

	public String getLogistics_desc(){
		return logistics_desc;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getIds() {
		return ids;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public String getRandom() {
		return random;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getRn() {
		return rn;
	}

}
