package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("viajeHome")
public class ViajeHome extends EntityHome<Viaje> {

	public void setViajeConsecutivo(Integer id) {
		setId(id);
	}

	public Integer getViajeConsecutivo() {
		return (Integer) getId();
	}

	@Override
	protected Viaje createInstance() {
		Viaje viaje = new Viaje();
		return viaje;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Viaje getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<AuditTarjetaviaje> getAuditTarjetaviajes() {
		return getInstance() == null ? null : new ArrayList<AuditTarjetaviaje>(
				getInstance().getAuditTarjetaviajes());
	}

	public List<Tarjetaviaje> getTarjetaviajes() {
		return getInstance() == null ? null : new ArrayList<Tarjetaviaje>(
				getInstance().getTarjetaviajes());
	}

}
