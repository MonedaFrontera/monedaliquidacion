package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("franquiciaestablecimientoHome")
public class FranquiciaestablecimientoHome extends
		EntityHome<Franquiciaestablecimiento> {

	public void setFranquiciaestablecimientoId(FranquiciaestablecimientoId id) {
		setId(id);
	}

	public FranquiciaestablecimientoId getFranquiciaestablecimientoId() {
		return (FranquiciaestablecimientoId) getId();
	}

	public FranquiciaestablecimientoHome() {
		setFranquiciaestablecimientoId(new FranquiciaestablecimientoId());
	}

	@Override
	public boolean isIdDefined() {
		if (getFranquiciaestablecimientoId().getEstablecimiento() == null
				|| "".equals(getFranquiciaestablecimientoId()
						.getEstablecimiento()))
			return false;
		if (getFranquiciaestablecimientoId().getFranquicia() == null
				|| "".equals(getFranquiciaestablecimientoId().getFranquicia()))
			return false;
		return true;
	}

	@Override
	protected Franquiciaestablecimiento createInstance() {
		Franquiciaestablecimiento franquiciaestablecimiento = new Franquiciaestablecimiento();
		franquiciaestablecimiento.setId(new FranquiciaestablecimientoId());
		return franquiciaestablecimiento;
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

	public Franquiciaestablecimiento getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
