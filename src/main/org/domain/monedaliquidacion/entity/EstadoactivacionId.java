package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * EstadoactivacionId generated by hbm2java
 */
@Embeddable
public class EstadoactivacionId implements java.io.Serializable {

	private int consecutivo;
	private String estado;
	private Date fecha;

	public EstadoactivacionId() {
	}

	public EstadoactivacionId(int consecutivo, String estado, Date fecha) {
		this.consecutivo = consecutivo;
		this.estado = estado;
		this.fecha = fecha;
	}

	@Column(name = "consecutivo", nullable = false)
	public int getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	@Column(name = "estado", nullable = false, length = 2)
	@NotNull
	@Length(max = 2)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "fecha", nullable = false, length = 29)
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
		if (!(other instanceof EstadoactivacionId))
			return false;
		EstadoactivacionId castOther = (EstadoactivacionId) other;

		return (this.getConsecutivo() == castOther.getConsecutivo())
				&& ((this.getEstado() == castOther.getEstado()) || (this
						.getEstado() != null
						&& castOther.getEstado() != null && this.getEstado()
						.equals(castOther.getEstado())))
				&& ((this.getFecha() == castOther.getFecha()) || (this
						.getFecha() != null
						&& castOther.getFecha() != null && this.getFecha()
						.equals(castOther.getFecha())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getConsecutivo();
		result = 37 * result
				+ (getEstado() == null ? 0 : this.getEstado().hashCode());
		result = 37 * result
				+ (getFecha() == null ? 0 : this.getFecha().hashCode());
		return result;
	}

}
