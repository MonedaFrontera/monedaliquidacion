package org.domain.monedaliquidacion.entity;

// Generated 28/12/2011 08:51:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * Usuariorol generated by hbm2java
 */
@Entity
@Table(name = "usuariorol")
public class Usuariorol implements java.io.Serializable {

	private UsuariorolId id;

	public Usuariorol() {
	}

	public Usuariorol(UsuariorolId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "usuario", column = @Column(name = "usuario", nullable = false, length = 15)),
			@AttributeOverride(name = "rol", column = @Column(name = "rol", nullable = false)) })
	@NotNull
	public UsuariorolId getId() {
		return this.id;
	}

	public void setId(UsuariorolId id) {
		this.id = id;
	}

}
