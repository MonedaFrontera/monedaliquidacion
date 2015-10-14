package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("monedaHome")
public class MonedaHome extends EntityHome<Moneda> {

	public void setMonedaCodigomoneda(String id) {
		setId(id);
	}

	public String getMonedaCodigomoneda() {
		return (String) getId();
	}

	@Override
	protected Moneda createInstance() {
		Moneda moneda = new Moneda();
		return moneda;
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

	public Moneda getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Paridadmoneda> getParidadmonedasForCodmonedadestino() {
		return getInstance() == null ? null : new ArrayList<Paridadmoneda>(
				getInstance().getParidadmonedasForCodmonedadestino());
	}

	public List<Paridadmoneda> getParidadmonedasForCodmonedaorigen() {
		return getInstance() == null ? null : new ArrayList<Paridadmoneda>(
				getInstance().getParidadmonedasForCodmonedaorigen());
	}

}
