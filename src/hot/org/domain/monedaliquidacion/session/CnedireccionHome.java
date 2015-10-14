package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cnedireccionHome")
public class CnedireccionHome extends EntityHome<Cnedireccion> {

	public void setCnedireccionCodCentro(String id) {
		setId(id);
	}

	public String getCnedireccionCodCentro() {
		return (String) getId();
	}

	@Override
	protected Cnedireccion createInstance() {
		Cnedireccion cnedireccion = new Cnedireccion();
		return cnedireccion;
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

	public Cnedireccion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
