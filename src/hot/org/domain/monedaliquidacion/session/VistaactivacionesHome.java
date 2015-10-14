package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.Date;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("vistaactivacionesHome")
public class VistaactivacionesHome extends EntityHome<Vistaactivaciones> {

	public void setVistaactivacionesId(VistaactivacionesId id) {
		setId(id);
	}

	public VistaactivacionesId getVistaactivacionesId() {
		return (VistaactivacionesId) getId();
	}

	public VistaactivacionesHome() {
		setVistaactivacionesId(new VistaactivacionesId());
	}

	@Override
	public boolean isIdDefined() {
		if (getVistaactivacionesId().getConsecutivo() == null)
			return false;
		if (getVistaactivacionesId().getFecha() == null)
			return false;
		if (getVistaactivacionesId().getEstado() == null
				|| "".equals(getVistaactivacionesId().getEstado()))
			return false;
		if (getVistaactivacionesId().getDocumento() == null
				|| "".equals(getVistaactivacionesId().getDocumento()))
			return false;
		return true;
	}

	@Override
	protected Vistaactivaciones createInstance() {
		Vistaactivaciones vistaactivaciones = new Vistaactivaciones();
		vistaactivaciones.setId(new VistaactivacionesId());
		return vistaactivaciones;
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

	public Vistaactivaciones getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
