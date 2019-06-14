package fr.sendmail.bankass.busObj;

import java.io.Serializable;

public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String idRegion;
	private String corps;
	
	
	public Email() {
		super();
	}


	public Email(long id, String idRegion, String corps) {
		super();
		this.id = id;
		this.idRegion = idRegion;
		this.corps = corps;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIdRegion() {
		return idRegion;
	}


	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}


	public String getCorps() {
		return corps;
	}


	public void setCorps(String corps) {
		this.corps = corps;
	}

}
