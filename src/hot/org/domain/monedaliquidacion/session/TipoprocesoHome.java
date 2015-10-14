package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoprocesoHome")
public class TipoprocesoHome extends EntityHome<Tipoproceso> {

	public void setTipoprocesoTipo(String id) {
		setId(id);
	}

	public String getTipoprocesoTipo() {
		return (String) getId();
	}

	@Override
	protected Tipoproceso createInstance() {
		Tipoproceso tipoproceso = new Tipoproceso();
		return tipoproceso;
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

	public Tipoproceso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
