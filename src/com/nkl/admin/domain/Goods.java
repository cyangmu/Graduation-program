package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;

public class Goods extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 7908671110299325743L;
	private String rn;
	private String goods_id; // null
	private String goods_no; // null
	private String goods_name; // null
	private Kind kind; // null
	private Integer goods_count; // null
	private String goods_desc; // null
	private Integer alarm_count; // null
	private Integer max_count; // null
	private Integer goods_flag; // 1:正常 2:缺货 3:已满
	private String goods_brand; // null
	private String goods_mate; // null
	private String goods_year; // null
	private String goods_pic; // null

	private String ids;
	private String random;

	public String getGoods_flagDesc() {
		switch (goods_flag) {
		case 1:
			return "正常";
		case 2:
			return "缺货";
		case 3:
			return "已满";
		default:
			return "";
		}
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

	public void setGoods_desc(String goods_desc){
		this.goods_desc=goods_desc;
	}

	public String getGoods_desc(){
		return goods_desc;
	}

	public void setAlarm_count(Integer alarm_count){
		this.alarm_count=alarm_count;
	}

	public Integer getAlarm_count(){
		return alarm_count;
	}

	public void setMax_count(Integer max_count){
		this.max_count=max_count;
	}

	public Integer getMax_count(){
		return max_count;
	}

	public void setGoods_flag(Integer goods_flag){
		this.goods_flag=goods_flag;
	}

	public Integer getGoods_flag(){
		return goods_flag;
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

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public String getGoods_brand() {
		return goods_brand;
	}

	public String getGoods_mate() {
		return goods_mate;
	}

	public String getGoods_year() {
		return goods_year;
	}

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_brand(String goods_brand) {
		this.goods_brand = goods_brand;
	}

	public void setGoods_mate(String goods_mate) {
		this.goods_mate = goods_mate;
	}

	public void setGoods_year(String goods_year) {
		this.goods_year = goods_year;
	}

	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

}
