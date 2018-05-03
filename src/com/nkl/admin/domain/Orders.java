package com.nkl.admin.domain;

import java.util.Date;

import com.nkl.common.domain.BaseDomain;
import com.nkl.common.util.DateUtil;

public class Orders extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -2121294232154660322L;
	private String rn;
	private String orders_id; // null
	private String orders_no; // null
	private String apply_id; // null
	private String apply_name; // null
	private Date apply_date; // null
	private String goods_id; // null
	private String goods_no; // null
	private String goods_name; // null
	private Integer goods_count; // null
	private Double goods_price; // null
	private Double orders_money; // null
	private String custom_id; // null
	private String custom_name; // null
	private Integer pay_type; // 1:信用付款 2:延期付款 3:分期付款 4:现金付款
	private String contract_file; // null
	private Integer orders_flag; // 1:待出库 2:待收货 3:已收货 4:待收款 5:已收款 6:待退货 7:已退货

	private String orders_flags; // null
	private Date apply_dateMin; // null
	private Date apply_dateMax; // null
	private String ids;
	private String random;

	public String getPay_typeDesc() {
		switch (pay_type) {
		case 1:
			return "信用付款";
		case 2:
			return "延期付款";
		case 3:
			return "分期付款";
		case 4:
			return "现金付款";
		default:
			return "";
		}
	}
	
	public String getOrders_flagDesc() {
		switch (orders_flag) {
		case 1:
			return "待出库";
		case 2:
			return "待收货";
		case 3:
			return "已收货";
		case 4:
			return "待收款";
		case 5:
			return "已收款";
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
	
	public void setOrders_id(String orders_id){
		this.orders_id=orders_id;
	}

	public String getOrders_id(){
		return orders_id;
	}

	public void setOrders_no(String orders_no){
		this.orders_no=orders_no;
	}

	public String getOrders_no(){
		return orders_no;
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

	public void setOrders_money(Double orders_money){
		this.orders_money=orders_money;
	}

	public Double getOrders_money(){
		return orders_money;
	}

	public void setCustom_id(String custom_id){
		this.custom_id=custom_id;
	}

	public String getCustom_id(){
		return custom_id;
	}

	public void setCustom_name(String custom_name){
		this.custom_name=custom_name;
	}

	public String getCustom_name(){
		return custom_name;
	}

	public void setPay_type(Integer pay_type){
		this.pay_type=pay_type;
	}

	public Integer getPay_type(){
		return pay_type;
	}

	public void setContract_file(String contract_file){
		this.contract_file=contract_file;
	}

	public String getContract_file(){
		return contract_file;
	}

	public void setOrders_flag(Integer orders_flag){
		this.orders_flag=orders_flag;
	}

	public Integer getOrders_flag(){
		return orders_flag;
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

	public String getOrders_flags() {
		return orders_flags;
	}

	public void setOrders_flags(String orders_flags) {
		this.orders_flags = orders_flags;
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

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public Double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

}
