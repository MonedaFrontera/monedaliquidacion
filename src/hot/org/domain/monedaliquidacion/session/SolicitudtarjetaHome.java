package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("solicitudtarjetaHome")
public class SolicitudtarjetaHome extends EntityHome<Solicitudtarjeta> {

	public void setSolicitudtarjetaId(SolicitudtarjetaId id) {
		setId(id);
	}

	public SolicitudtarjetaId getSolicitudtarjetaId() {
		return (SolicitudtarjetaId) getId();
	}

	public SolicitudtarjetaHome() {
		setSolicitudtarjetaId(new SolicitudtarjetaId());
	}

	@Override
	public boolean isIdDefined() {
		if (getSolicitudtarjetaId().getConsecutivo() == 0)
			return false;
		if (getSolicitudtarjetaId().getNumerotarjeta() == null
				|| "".equals(getSolicitudtarjetaId().getNumerotarjeta()))
			return false;
		return true;
	}

	@Override
	protected Solicitudtarjeta createInstance() {
		Solicitudtarjeta solicitudtarjeta = new Solicitudtarjeta();
		solicitudtarjeta.setId(new SolicitudtarjetaId());
		return solicitudtarjeta;
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

	public Solicitudtarjeta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
