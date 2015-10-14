package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * Observacion generated by hbm2java
 */
@Entity
@Table(name = "observacion")
public class Observacion implements java.io.Serializable {

	private ObservacionId id;
	private Activacion activacion;
	private String observacion;

	public Observacion() {
	}

	public Observacion(ObservacionId id, Activacion activacion) {
		this.id = id;
		this.activacion = activacion;
	}

	public Observacion(ObservacionId id, Activacion activacion,
			String observacion) {
		this.id = id;
		this.activacion = activacion;
		this.observacion = observacion;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "consecutivo", column = @Column(name = "consecutivo", nullable = false)),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", nullable = false, length = 29)) })
	@NotNull
	public ObservacionId getId() {
		return this.id;
	}

	public void setId(ObservacionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consecutivo", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Activacion getActivacion() {
		return this.activacion;
	}

	public void setActivacion(Activacion activacion) {
		this.activacion = activacion;
	}

	@Column(name = "observacion", length = 2000)
	@Length(max = 2000)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
