package fr.sendmail.bankass.busObj;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "mail")
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Column(name = "id")
	@Id
	private long id;

	private String objet;

	@Lob
	@Type(type = "org.hibernate.type.BlobType")
	private String corps;

	private String idregion;

	public Email() {
		super();
	}

	public Email(long id, String idRegion, String corps) {
		super();
		this.id = id;
		this.idregion = idRegion;
		this.corps = corps;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdRegion() {
		return idregion;
	}

	public void setIdRegion(String idRegion) {
		this.idregion = idRegion;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

}
