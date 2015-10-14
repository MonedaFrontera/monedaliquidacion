package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("diasemanaHome")
public class DiasemanaHome extends EntityHome<Diasemana> {

	public void setDiasemanaCodigodia(Integer id) {
		setId(id);
	}

	public Integer getDiasemanaCodigodia() {
		return (Integer) getId();
	}

	@Override
	protected Diasemana createInstance() {
		Diasemana diasemana = new Diasemana();
		return diasemana;
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

	public Diasemana getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
