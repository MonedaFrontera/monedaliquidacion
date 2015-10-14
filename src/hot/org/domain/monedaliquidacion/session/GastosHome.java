package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gastosHome")
public class GastosHome extends EntityHome<Gastos> {

	@In(create = true)
	PersonalHome personalHome;
	@In(create = true)
	TipogastoHome tipogastoHome;
	@In(create = true)
	TransferenciaHome transferenciaHome;

	public void setGastosConsecutivo(Integer id) {
		setId(id);
	}

	public Integer getGastosConsecutivo() {
		return (Integer) getId();
	}

	@Override
	protected Gastos createInstance() {
		Gastos gastos = new Gastos();
		return gastos;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Personal personal = personalHome.getDefinedInstance();
		if (personal != null) {
			getInstance().setPersonal(personal);
		}
		Tipogasto tipogasto = tipogastoHome.getDefinedInstance();
		if (tipogasto != null) {
			getInstance().setTipogasto(tipogasto);
		}
		Transferencia transferencia = transferenciaHome.getDefinedInstance();
		if (transferencia != null) {
			getInstance().setTransferencia(transferencia);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Gastos getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
