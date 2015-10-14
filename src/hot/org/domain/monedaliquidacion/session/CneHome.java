package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cneHome")
public class CneHome extends EntityHome<Cne> {

	public void setCneCedula(String id) {
		setId(id);
	}

	public String getCneCedula() {
		return (String) getId();
	}

	@Override
	protected Cne createInstance() {
		Cne cne = new Cne();
		return cne;
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

	public Cne getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
