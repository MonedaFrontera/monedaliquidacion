package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("transferenciaHome")
public class TransferenciaHome extends EntityHome<Transferencia> {

	@In(create = true)
	GastosHome gastosHome;
	@In(create = true)
	CuentapromotorHome cuentapromotorHome;

	public void setTransferenciaConsecutivo(Integer id) {
		setId(id);
	}

	public Integer getTransferenciaConsecutivo() {
		return (Integer) getId();
	}

	@Override
	protected Transferencia createInstance() {
		Transferencia transferencia = new Transferencia();
		return transferencia;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Gastos gastos = gastosHome.getDefinedInstance();
		if (gastos != null) {
			getInstance().setGastos(gastos);
		}
		Cuentapromotor cuentapromotor = cuentapromotorHome.getDefinedInstance();
		if (cuentapromotor != null) {
			getInstance().setCuentapromotor(cuentapromotor);
		}
	}

	public boolean isWired() {
		if (getInstance().getGastos() == null)
			return false;
		return true;
	}

	public Transferencia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
