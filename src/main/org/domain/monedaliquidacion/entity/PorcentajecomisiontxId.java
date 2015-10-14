package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * PorcentajecomisiontxId generated by hbm2java
 */
@Embeddable
public class PorcentajecomisiontxId implements java.io.Serializable {

	private String codpais;
	private Date fechainicio;

	public PorcentajecomisiontxId() {
	}

	public PorcentajecomisiontxId(String codpais, Date fechainicio) {
		this.codpais = codpais;
		this.fechainicio = fechainicio;
	}

	@Column(name = "codpais", nullable = false, length = 5)
	@NotNull
	@Length(max = 5)
	public String getCodpais() {
		return this.codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	@Column(name = "fechainicio", nullable = false, length = 13)
	@NotNull
	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PorcentajecomisiontxId))
			return false;
		PorcentajecomisiontxId castOther = (PorcentajecomisiontxId) other;

		return ((this.getCodpais() == castOther.getCodpais()) || (this
				.getCodpais() != null
				&& castOther.getCodpais() != null && this.getCodpais().equals(
				castOther.getCodpais())))
				&& ((this.getFechainicio() == castOther.getFechainicio()) || (this
						.getFechainicio() != null
						&& castOther.getFechainicio() != null && this
						.getFechainicio().equals(castOther.getFechainicio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodpais() == null ? 0 : this.getCodpais().hashCode());
		result = 37
				* result
				+ (getFechainicio() == null ? 0 : this.getFechainicio()
						.hashCode());
		return result;
	}

}
