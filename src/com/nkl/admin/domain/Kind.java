package com.nkl.admin.domain;

import com.nkl.common.domain.BaseDomain;

public class Kind extends BaseDomain {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -1016816483613207366L;
	private String rn;
	private String kind_id; // null
	private String kind_name; // null
	private String kind_note; // null

	private String ids;
	private String random;

	public void setKind_id(String kind_id){
		this.kind_id=kind_id;
	}

	public String getKind_id(){
		return kind_id;
	}

	public void setKind_name(String kind_name){
		this.kind_name=kind_name;
	}

	public String getKind_name(){
		return kind_name;
	}

	public void setKind_note(String kind_note){
		this.kind_note=kind_note;
	}

	public String getKind_note(){
		return kind_note;
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
