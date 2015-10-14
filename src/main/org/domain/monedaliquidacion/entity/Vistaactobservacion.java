package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Vistaactobservacion generated by hbm2java
 */
@Entity
@Table(name = "vistaactobservacion")
public class Vistaactobservacion implements java.io.Serializable {

	private VistaactobservacionId id;

	public Vistaactobservacion() {
	}

	public Vistaactobservacion(VistaactobservacionId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "tipo", column = @Column(name = "tipo")),
			@AttributeOverride(name = "consecutivo", column = @Column(name = "consecutivo")),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", length = 29)),
			@AttributeOverride(name = "observacion", column = @Column(name = "observacion", length = 2000)),
			@AttributeOverride(name = "dato", column = @Column(name = "dato")) })
	public VistaactobservacionId getId() {
		return this.id;
	}

	public void setId(VistaactobservacionId id) {
		this.id = id;
	}

}
