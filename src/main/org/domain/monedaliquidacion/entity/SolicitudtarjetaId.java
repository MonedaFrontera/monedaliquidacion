package org.domain.monedaliquidacion.entity;

// Generated 21/06/2012 01:37:44 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * SolicitudtarjetaId generated by hbm2java
 */
@Embeddable
public class SolicitudtarjetaId implements java.io.Serializable {

	private int consecutivo;
	private String numerotarjeta;

	public SolicitudtarjetaId() {
	}

	public SolicitudtarjetaId(int consecutivo, String numerotarjeta) {
		this.consecutivo = consecutivo;
		this.numerotarjeta = numerotarjeta;
	}

	@Column(name = "consecutivo", nullable = false)
	public int getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	@Column(name = "numerotarjeta", nullable = false, length = 16)
	@NotNull
	@Length(max = 16)
	public String getNumerotarjeta() {
		return this.numerotarjeta;
	}

	public void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SolicitudtarjetaId))
			return false;
		SolicitudtarjetaId castOther = (SolicitudtarjetaId) other;

		return (this.getConsecutivo() == castOther.getConsecutivo())
				&& ((this.getNumerotarjeta() == castOther.getNumerotarjeta()) || (this
						.getNumerotarjeta() != null
						&& castOther.getNumerotarjeta() != null && this
						.getNumerotarjeta()
						.equals(castOther.getNumerotarjeta())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getConsecutivo();
		result = 37
				* result
				+ (getNumerotarjeta() == null ? 0 : this.getNumerotarjeta()
						.hashCode());
		return result;
	}

}
