package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("puntodeventaHome")
public class PuntodeventaHome extends EntityHome<Puntodeventa> {

	public void setPuntodeventaCodpuntoventa(String id) {
		setId(id);
	}

	public String getPuntodeventaCodpuntoventa() {
		return (String) getId();
	}

	@Override
	protected Puntodeventa createInstance() {
		Puntodeventa puntodeventa = new Puntodeventa();
		return puntodeventa;
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

	public Puntodeventa getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Puntoestablecimiento> getPuntoestablecimientos() {
		return getInstance() == null ? null
				: new ArrayList<Puntoestablecimiento>(getInstance()
						.getPuntoestablecimientos());
	}

}
