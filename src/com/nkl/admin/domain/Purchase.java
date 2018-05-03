package com.nkl.admin.domain;

import java.util.Date;

import com.nkl.common.domain.BaseDomain;
import com.nkl.common.util.DateUtil;

public class Purchase extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -95193746588923120L;
	private String rn;
	private String purchase_id; // null
	private String goods_id; // null
	private String goods_no; // null
	private String goods_name; // null
	private Integer goods_count; // null
	private Double goods_price; // null
	private Double purchase_money; // null
	private String supplier_id; // null
	private String supplier_name; // null
	private String apply_id; // null
	private String apply_name; // null
	private Date apply_date; // null
	private Integer apply_flag; // 1:初始 2:生成订单 3:删除
	private String purchase_no; // null
	private Date orders_date; // null
	private String buy_id; // null
	private String buy_name; // null
	private Integer purchase_flag; // 1:待确认 2:采购中 3:已收货 4:待入库 5:已入库 6:待退货 7:已退货
	private Integer check_flag; // 1:未检验 2:合格 3:不合格

	private String purchase_flags; // null
	private String apply_flags; 
	private Date apply_dateMin; // null
	private Date apply_dateMax; // null
	private Date orders_dateMin; // null
	private Date orders_dateMax; // null
	private String ids;
	private String random;

	public String getApply_flagDesc() {
		switch (apply_flag) {
		case 1:
			return "初始";
		case 2:
			return "生成订单";
		case 3:
			return "删除";
		default:
			return "";
		}
	}
	public String getCheck_flagDesc() {
		switch (check_flag) {
		case 1:
			return "未检验";
		case 2:
			return "合格";
		case 3:
			return "不合格";
		default:
			return "";
		}
	}
	public String getPurchase_flagDesc() {
		switch (purchase_flag) {
		case 1:
			return "待确认";
		case 2:
			return "采购中";
		case 3:
			return "已收货";
		case 4:
			return "待入库";
		case 5:
			return "已入库";
		case 6:
			return "待退货";
		case 7:
			return "已退货";
		default:
			return "";
		}
	}
	public String getApply_dateDesc(){
		try {
			return DateUtil.dateToDateString(apply_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String getOrders_dateDesc(){
		try {
			return DateUtil.dateToDateString(orders_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void setPurchase_id(String purchase_id){
		this.purchase_id=purchase_id;
	}

	public String getPurchase_id(){
		return purchase_id;
	}

	public void setGoods_id(String goods_id){
		this.goods_id=goods_id;
	}

	public String getGoods_id(){
		return goods_id;
	}

	public void setGoods_no(String goods_no){
		this.goods_no=goods_no;
	}

	public String getGoods_no(){
		return goods_no;
	}

	public void setGoods_name(String goods_name){
		this.goods_name=goods_name;
	}

	public String getGoods_name(){
		return goods_name;
	}

	public void setGoods_count(Integer goods_count){
		this.goods_count=goods_count;
	}

	public Integer getGoods_count(){
		return goods_count;
	}

	public void setPurchase_money(Double purchase_money){
		this.purchase_money=purchase_money;
	}

	public Double getPurchase_money(){
		return purchase_money;
	}

	public void setApply_id(String apply_id){
		this.apply_id=apply_id;
	}

	public String getApply_id(){
		return apply_id;
	}

	public void setApply_name(String apply_name){
		this.apply_name=apply_name;
	}

	public String getApply_name(){
		return apply_name;
	}

	public void setApply_date(Date apply_date){
		this.apply_date=apply_date;
	}

	public Date getApply_date(){
		return apply_date;
	}

	public void setApply_flag(Integer apply_flag){
		this.apply_flag=apply_flag;
	}

	public Integer getApply_flag(){
		return apply_flag;
	}

	public void setPurchase_no(String purchase_no){
		this.purchase_no=purchase_no;
	}

	public String getPurchase_no(){
		return purchase_no;
	}

	public void setOrders_date(Date orders_date){
		this.orders_date=orders_date;
	}

	public Date getOrders_date(){
		return orders_date;
	}

	public void setBuy_id(String buy_id){
		this.buy_id=buy_id;
	}

	public String getBuy_id(){
		return buy_id;
	}

	public void setBuy_name(String buy_name){
		this.buy_name=buy_name;
	}

	public String getBuy_name(){
		return buy_name;
	}

	public void setPurchase_flag(Integer purchase_flag){
		this.purchase_flag=purchase_flag;
	}

	public Integer getPurchase_flag(){
		return purchase_flag;
	}

	public void setCheck_flag(Integer check_flag){
		this.check_flag=check_flag;
	}

	public Integer getCheck_flag(){
		return check_flag;
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

	public String getPurchase_flags() {
		return purchase_flags;
	}

	public void setPurchase_flags(String purchase_flags) {
		this.purchase_flags = purchase_flags;
	}
	public Date getOrders_dateMin() {
		return orders_dateMin;
	}
	public Date getOrders_dateMax() {
		return orders_dateMax;
	}
	public void setOrders_dateMin(Date orders_dateMin) {
		this.orders_dateMin = orders_dateMin;
	}
	public void setOrders_dateMax(Date orders_dateMax) {
		this.orders_dateMax = orders_dateMax;
	}
	public String getApply_flags() {
		return apply_flags;
	}
	public void setApply_flags(String apply_flags) {
		this.apply_flags = apply_flags;
	}
	public Date getApply_dateMin() {
		return apply_dateMin;
	}
	public Date getApply_dateMax() {
		return apply_dateMax;
	}
	public void setApply_dateMin(Date apply_dateMin) {
		this.apply_dateMin = apply_dateMin;
	}
	public void setApply_dateMax(Date apply_dateMax) {
		this.apply_dateMax = apply_dateMax;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}
	public String getSupplier_id() {
		return supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

}
