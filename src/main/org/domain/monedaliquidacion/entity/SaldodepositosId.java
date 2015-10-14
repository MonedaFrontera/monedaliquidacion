package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * SaldodepositosId generated by hbm2java
 */
@Embeddable
public class SaldodepositosId implements java.io.Serializable {

	private String numerotarjeta;
	private Date fecha;

	public SaldodepositosId() {
	}

	public SaldodepositosId(String numerotarjeta, Date fecha) {
		this.numerotarjeta = numerotarjeta;
		this.fecha = fecha;
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

	@Column(name = "fecha", nullable = false, length = 13)
	@NotNull
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SaldodepositosId))
			return false;
		SaldodepositosId castOther = (SaldodepositosId) other;

		return ((this.getNumerotarjeta() == castOther.getNumerotarjeta()) || (this
				.getNumerotarjeta() != null
				&& castOther.getNumerotarjeta() != null && this
				.getNumerotarjeta().equals(castOther.getNumerotarjeta())))
				&& ((this.getFecha() == castOther.getFecha()) || (this
						.getFecha() != null
						&& castOther.getFecha() != null && this.getFecha()
						.equals(castOther.getFecha())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumerotarjeta() == null ? 0 : this.getNumerotarjeta()
						.hashCode());
		result = 37 * result
				+ (getFecha() == null ? 0 : this.getFecha().hashCode());
		return result;
	}

}
