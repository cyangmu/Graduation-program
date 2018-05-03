package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;

public class Custom extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3053829400448001322L;
	private String rn;
	private String custom_id; // null
	private String custom_name; // null
	private String custom_note; // null
	private String custom_mail;
	private String custom_phone;
	private String custom_address;

	private String ids;
	private String random;

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

	public void setCustom_note(String custom_note){
		this.custom_note=custom_note;
	}

	public String getCustom_note(){
		return custom_note;
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

	public String getCustom_mail() {
		return custom_mail;
	}

	public String getCustom_phone() {
		return custom_phone;
	}

	public String getCustom_address() {
		return custom_address;
	}

	public void setCustom_mail(String custom_mail) {
		this.custom_mail = custom_mail;
	}

	public void setCustom_phone(String custom_phone) {
		this.custom_phone = custom_phone;
	}

	public void setCustom_address(String custom_address) {
		this.custom_address = custom_address;
	}

}
