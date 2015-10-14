package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.Deducciones;
import org.domain.monedaliquidacion.entity.DeduccionesId;
import org.domain.monedaliquidacion.entity.Transaccion;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("deduccionesHome")
public class DeduccionesHome extends EntityHome<Deducciones> {

	@In(create = true)
	TransaccionHome transaccionHome;

	public void setDeduccionesId(DeduccionesId id) {
		setId(id);
	}

	public DeduccionesId getDeduccionesId() {
		return (DeduccionesId) getId();
	}

	public DeduccionesHome() {
		setDeduccionesId(new DeduccionesId());
	}

	@Override
	public boolean isIdDefined() {
		if (getDeduccionesId().getConsecutivo() == 0)
			return false;
		if (getDeduccionesId().getTipo() == null
				|| "".equals(getDeduccionesId().getTipo()))
			return false;
		return true;
	}

	@Override
	protected Deducciones createInstance() {
		Deducciones deducciones = new Deducciones();
		deducciones.setId(new DeduccionesId());
		return deducciones;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Transaccion transaccion = transaccionHome.getDefinedInstance();
		if (transaccion != null) {
			getInstance().setTransaccion(transaccion);
		}
	}

	public boolean isWired() {
		if (getInstance().getTransaccion() == null)
			return false;
		return true;
	}

	public Deducciones getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
