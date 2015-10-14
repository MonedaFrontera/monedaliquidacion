package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * BaucherId generated by hbm2java
 */
@Embeddable
public class BaucherId implements java.io.Serializable {

	private int consecutivo;
	private String numautorizacion;

	public BaucherId() {
	}

	public BaucherId(int consecutivo, String numautorizacion) {
		this.consecutivo = consecutivo;
		this.numautorizacion = numautorizacion;
	}

	@Column(name = "consecutivo", nullable = false)
	public int getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	@Column(name = "numautorizacion", nullable = false, length = 8)
	@NotNull
	@Length(max = 8)
	public String getNumautorizacion() {
		return this.numautorizacion;
	}

	public void setNumautorizacion(String numautorizacion) {
		this.numautorizacion = numautorizacion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BaucherId))
			return false;
		BaucherId castOther = (BaucherId) other;

		return (this.getConsecutivo() == castOther.getConsecutivo())
				&& ((this.getNumautorizacion() == castOther
						.getNumautorizacion()) || (this.getNumautorizacion() != null
						&& castOther.getNumautorizacion() != null && this
						.getNumautorizacion().equals(
								castOther.getNumautorizacion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getConsecutivo();
		result = 37
				* result
				+ (getNumautorizacion() == null ? 0 : this.getNumautorizacion()
						.hashCode());
		return result;
	}

}
