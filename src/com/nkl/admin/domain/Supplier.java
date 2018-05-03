package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;

public class Supplier extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3053829400448001322L;
	private String rn;
	private String supplier_id; // null
	private String supplier_name; // null
	private String supplier_note; // null
	private String supplier_mail;
	private String supplier_phone;
	private String supplier_address;

	private String ids;
	private String random;

	public void setSupplier_id(String supplier_id){
		this.supplier_id=supplier_id;
	}

	public String getSupplier_id(){
		return supplier_id;
	}

	public void setSupplier_name(String supplier_name){
		this.supplier_name=supplier_name;
	}

	public String getSupplier_name(){
		return supplier_name;
	}

	public void setSupplier_note(String supplier_note){
		this.supplier_note=supplier_note;
	}

	public String getSupplier_note(){
		return supplier_note;
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

	public String getSupplier_mail() {
		return supplier_mail;
	}

	public String getSupplier_phone() {
		return supplier_phone;
	}

	public String getSupplier_address() {
		return supplier_address;
	}

	public void setSupplier_mail(String supplier_mail) {
		this.supplier_mail = supplier_mail;
	}

	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}

	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}

}
