package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * AuditTarjetaviajeId generated by hbm2java
 */
@Embeddable
public class AuditTarjetaviajeId implements java.io.Serializable {

	private String numerotarjeta;
	private int consecutivoviaje;
	private Boolean estado;
	private Date fechamod;
	private String usuariomod;

	public AuditTarjetaviajeId() {
	}

	public AuditTarjetaviajeId(String numerotarjeta, int consecutivoviaje) {
		this.numerotarjeta = numerotarjeta;
		this.consecutivoviaje = consecutivoviaje;
	}

	public AuditTarjetaviajeId(String numerotarjeta, int consecutivoviaje,
			Boolean estado, Date fechamod, String usuariomod) {
		this.numerotarjeta = numerotarjeta;
		this.consecutivoviaje = consecutivoviaje;
		this.estado = estado;
		this.fechamod = fechamod;
		this.usuariomod = usuariomod;
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

	@Column(name = "consecutivoviaje", nullable = false)
	public int getConsecutivoviaje() {
		return this.consecutivoviaje;
	}

	public void setConsecutivoviaje(int consecutivoviaje) {
		this.consecutivoviaje = consecutivoviaje;
	}

	@Column(name = "estado", precision = 1, scale = 0)
	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Column(name = "fechamod", length = 22)
	public Date getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Date fechamod) {
		this.fechamod = fechamod;
	}

	@Column(name = "usuariomod", length = 20)
	@Length(max = 20)
	public String getUsuariomod() {
		return this.usuariomod;
	}

	public void setUsuariomod(String usuariomod) {
		this.usuariomod = usuariomod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuditTarjetaviajeId))
			return false;
		AuditTarjetaviajeId castOther = (AuditTarjetaviajeId) other;

		return ((this.getNumerotarjeta() == castOther.getNumerotarjeta()) || (this
				.getNumerotarjeta() != null
				&& castOther.getNumerotarjeta() != null && this
				.getNumerotarjeta().equals(castOther.getNumerotarjeta())))
				&& (this.getConsecutivoviaje() == castOther
						.getConsecutivoviaje())
				&& ((this.getEstado() == castOther.getEstado()) || (this
						.getEstado() != null
						&& castOther.getEstado() != null && this.getEstado()
						.equals(castOther.getEstado())))
				&& ((this.getFechamod() == castOther.getFechamod()) || (this
						.getFechamod() != null
						&& castOther.getFechamod() != null && this
						.getFechamod().equals(castOther.getFechamod())))
				&& ((this.getUsuariomod() == castOther.getUsuariomod()) || (this
						.getUsuariomod() != null
						&& castOther.getUsuariomod() != null && this
						.getUsuariomod().equals(castOther.getUsuariomod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getNumerotarjeta() == null ? 0 : this.getNumerotarjeta()
						.hashCode());
		result = 37 * result + this.getConsecutivoviaje();
		result = 37 * result
				+ (getEstado() == null ? 0 : this.getEstado().hashCode());
		result = 37 * result
				+ (getFechamod() == null ? 0 : this.getFechamod().hashCode());
		result = 37
				* result
				+ (getUsuariomod() == null ? 0 : this.getUsuariomod()
						.hashCode());
		return result;
	}

}
