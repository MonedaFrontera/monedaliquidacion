package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * GravamenestablecimientoId generated by hbm2java
 */
@Embeddable
public class GravamenestablecimientoId implements java.io.Serializable {

	private String codigounico;
	private String gravamen;

	public GravamenestablecimientoId() {
	}

	public GravamenestablecimientoId(String codigounico, String gravamen) {
		this.codigounico = codigounico;
		this.gravamen = gravamen;
	}

	@Column(name = "codigounico", nullable = false, length = 8)
	@NotNull
	@Length(max = 8)
	public String getCodigounico() {
		return this.codigounico;
	}

	public void setCodigounico(String codigounico) {
		this.codigounico = codigounico;
	}

	@Column(name = "gravamen", nullable = false, length = 2)
	@NotNull
	@Length(max = 2)
	public String getGravamen() {
		return this.gravamen;
	}

	public void setGravamen(String gravamen) {
		this.gravamen = gravamen;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GravamenestablecimientoId))
			return false;
		GravamenestablecimientoId castOther = (GravamenestablecimientoId) other;

		return ((this.getCodigounico() == castOther.getCodigounico()) || (this
				.getCodigounico() != null
				&& castOther.getCodigounico() != null && this.getCodigounico()
				.equals(castOther.getCodigounico())))
				&& ((this.getGravamen() == castOther.getGravamen()) || (this
						.getGravamen() != null
						&& castOther.getGravamen() != null && this
						.getGravamen().equals(castOther.getGravamen())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigounico() == null ? 0 : this.getCodigounico()
						.hashCode());
		result = 37 * result
				+ (getGravamen() == null ? 0 : this.getGravamen().hashCode());
		return result;
	}

}
