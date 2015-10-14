package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Clasetarjeta generated by hbm2java
 */
@Entity
@Table(name = "clasetarjeta")
public class Clasetarjeta implements java.io.Serializable {

	private ClasetarjetaId id;
	private String nombretipo;
	private Byte diastransaccion;
	private Byte diasdeposito;

	public Clasetarjeta() {
	}

	public Clasetarjeta(ClasetarjetaId id) {
		this.id = id;
	}

	public Clasetarjeta(ClasetarjetaId id, String nombretipo,
			Byte diastransaccion, Byte diasdeposito) {
		this.id = id;
		this.nombretipo = nombretipo;
		this.diastransaccion = diastransaccion;
		this.diasdeposito = diasdeposito;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "codbanco", column = @Column(name = "codbanco", nullable = false, length = 3)),
			@AttributeOverride(name = "codfranquicia", column = @Column(name = "codfranquicia", nullable = false, length = 1)),
			@AttributeOverride(name = "clase", column = @Column(name = "clase", nullable = false, length = 1)) })
	@NotNull
	public ClasetarjetaId getId() {
		return this.id;
	}

	public void setId(ClasetarjetaId id) {
		this.id = id;
	}

	@Column(name = "nombretipo", length = 50)
	@Length(max = 50)
	public String getNombretipo() {
		return this.nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}

	@Column(name = "diastransaccion", precision = 2, scale = 0)
	public Byte getDiastransaccion() {
		return this.diastransaccion;
	}

	public void setDiastransaccion(Byte diastransaccion) {
		this.diastransaccion = diastransaccion;
	}

	@Column(name = "diasdeposito", precision = 2, scale = 0)
	public Byte getDiasdeposito() {
		return this.diasdeposito;
	}

	public void setDiasdeposito(Byte diasdeposito) {
		this.diasdeposito = diasdeposito;
	}

}
