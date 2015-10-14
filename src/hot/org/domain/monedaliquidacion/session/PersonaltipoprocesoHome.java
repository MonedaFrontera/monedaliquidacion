package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.Date;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("personaltipoprocesoHome")
public class PersonaltipoprocesoHome extends EntityHome<Personaltipoproceso> {

	public void setPersonaltipoprocesoId(PersonaltipoprocesoId id) {
		setId(id);
	}

	public PersonaltipoprocesoId getPersonaltipoprocesoId() {
		return (PersonaltipoprocesoId) getId();
	}

	public PersonaltipoprocesoHome() {
		setPersonaltipoprocesoId(new PersonaltipoprocesoId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPersonaltipoprocesoId().getDocumento() == null
				|| "".equals(getPersonaltipoprocesoId().getDocumento()))
			return false;
		if (getPersonaltipoprocesoId().getFechainicio() == null)
			return false;
		if (getPersonaltipoprocesoId().getPuntodeventa() == null
				|| "".equals(getPersonaltipoprocesoId().getPuntodeventa()))
			return false;
		if (getPersonaltipoprocesoId().getTipoproceso() == null
				|| "".equals(getPersonaltipoprocesoId().getTipoproceso()))
			return false;
		return true;
	}

	@Override
	protected Personaltipoproceso createInstance() {
		Personaltipoproceso personaltipoproceso = new Personaltipoproceso();
		personaltipoproceso.setId(new PersonaltipoprocesoId());
		return personaltipoproceso;
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

	public Personaltipoproceso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
