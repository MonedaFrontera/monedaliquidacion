package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;

/**
 * VistasaldodiariopromotorId generated by hbm2java
 */
@Embeddable
public class VistasaldodiariopromotorId implements java.io.Serializable {

	private Date fecha;
	private String documento;
	private String promotor;
	private BigDecimal saldoaldia;

	public VistasaldodiariopromotorId() {
	}

	public VistasaldodiariopromotorId(Date fecha, String documento,
			String promotor, BigDecimal saldoaldia) {
		this.fecha = fecha;
		this.documento = documento;
		this.promotor = promotor;
		this.saldoaldia = saldoaldia;
	}

	@Column(name = "fecha", length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "documento", length = 15)
	@Length(max = 15)
	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Column(name = "promotor")
	public String getPromotor() {
		return this.promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	@Column(name = "saldoaldia", precision = 131089, scale = 0)
	public BigDecimal getSaldoaldia() {
		return this.saldoaldia;
	}

	public void setSaldoaldia(BigDecimal saldoaldia) {
		this.saldoaldia = saldoaldia;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VistasaldodiariopromotorId))
			return false;
		VistasaldodiariopromotorId castOther = (VistasaldodiariopromotorId) other;

		return ((this.getFecha() == castOther.getFecha()) || (this.getFecha() != null
				&& castOther.getFecha() != null && this.getFecha().equals(
				castOther.getFecha())))
				&& ((this.getDocumento() == castOther.getDocumento()) || (this
						.getDocumento() != null
						&& castOther.getDocumento() != null && this
						.getDocumento().equals(castOther.getDocumento())))
				&& ((this.getPromotor() == castOther.getPromotor()) || (this
						.getPromotor() != null
						&& castOther.getPromotor() != null && this
						.getPromotor().equals(castOther.getPromotor())))
				&& ((this.getSaldoaldia() == castOther.getSaldoaldia()) || (this
						.getSaldoaldia() != null
						&& castOther.getSaldoaldia() != null && this
						.getSaldoaldia().equals(castOther.getSaldoaldia())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFecha() == null ? 0 : this.getFecha().hashCode());
		result = 37 * result
				+ (getDocumento() == null ? 0 : this.getDocumento().hashCode());
		result = 37 * result
				+ (getPromotor() == null ? 0 : this.getPromotor().hashCode());
		result = 37
				* result
				+ (getSaldoaldia() == null ? 0 : this.getSaldoaldia()
						.hashCode());
		return result;
	}

}
