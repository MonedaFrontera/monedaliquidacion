package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Vistasaldomiercoles generated by hbm2java
 */
@Entity
@Table(name = "vistasaldomiercoles")
public class Vistasaldomiercoles implements java.io.Serializable {

	private VistasaldomiercolesId id;

	public Vistasaldomiercoles() {
	}

	public Vistasaldomiercoles(VistasaldomiercolesId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "docupromo", column = @Column(name = "docupromo", length = 15)),
			@AttributeOverride(name = "nombrepromo", column = @Column(name = "nombrepromo")),
			@AttributeOverride(name = "asesora", column = @Column(name = "asesora")),
			@AttributeOverride(name = "saldoCliente", column = @Column(name = "saldo_cliente", precision = 131089, scale = 0)) })
	public VistasaldomiercolesId getId() {
		return this.id;
	}

	public void setId(VistasaldomiercolesId id) {
		this.id = id;
	}

}
