package org.domain.monedaliquidacion.entity;

// Generated 9/06/2015 03:23:02 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

/**
 * Promotortasa generated by hbm2java
 */
@Entity
@Table(name = "promotortasa")
public class Promotortasa implements java.io.Serializable {

	private PromotortasaId id;
	private Promotor promotor;
	private Pais pais;
	private BigDecimal tasa;
	private BigDecimal tasadolar;
	private Date fechafin;

	public Promotortasa() {
	}

	public Promotortasa(PromotortasaId id, Promotor promotor, Pais pais) {
		this.id = id;
		this.promotor = promotor;
		this.pais = pais;
	}

	public Promotortasa(PromotortasaId id, Promotor promotor, Pais pais,
			BigDecimal tasa, BigDecimal tasadolar, Date fechafin) {
		this.id = id;
		this.promotor = promotor;
		this.pais = pais;
		this.tasa = tasa;
		this.tasadolar = tasadolar;
		this.fechafin = fechafin;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "documento", column = @Column(name = "documento", nullable = false, length = 15)),
			@AttributeOverride(name = "codigopais", column = @Column(name = "codigopais", nullable = false, length = 5)),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", nullable = false, length = 13)) })
	@NotNull
	public PromotortasaId getId() {
		return this.id;
	}

	public void setId(PromotortasaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Promotor getPromotor() {
		return this.promotor;
	}

	public void setPromotor(Promotor promotor) {
		this.promotor = promotor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigopais", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Column(name = "tasa", precision = 6)
	public BigDecimal getTasa() {
		return this.tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	@Column(name = "tasadolar", precision = 6)
	public BigDecimal getTasadolar() {
		return this.tasadolar;
	}

	public void setTasadolar(BigDecimal tasadolar) {
		this.tasadolar = tasadolar;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechafin", length = 13)
	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

}
