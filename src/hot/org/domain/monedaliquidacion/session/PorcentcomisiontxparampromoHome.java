package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("porcentcomisiontxparampromoHome")
public class PorcentcomisiontxparampromoHome extends
		EntityHome<Porcentcomisiontxparampromo> {

	@In(create = true)
	PromotorHome promotorHome;
	@In(create = true)
	FranquiciaHome franquiciaHome;
	@In(create = true)
	PaisHome paisHome;
	@In(create = true)
	EstablecimientoHome establecimientoHome;
	@In(create = true)
	BancoHome bancoHome;

	public void setPorcentcomisiontxparampromoConsecutivo(Integer id) {
		setId(id);
	}

	public Integer getPorcentcomisiontxparampromoConsecutivo() {
		return (Integer) getId();
	}

	@Override
	protected Porcentcomisiontxparampromo createInstance() {
		Porcentcomisiontxparampromo porcentcomisiontxparampromo = new Porcentcomisiontxparampromo();
		return porcentcomisiontxparampromo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Promotor promotor = promotorHome.getDefinedInstance();
		if (promotor != null) {
			getInstance().setPromotor(promotor);
		}
		Franquicia franquicia = franquiciaHome.getDefinedInstance();
		if (franquicia != null) {
			getInstance().setFranquicia(franquicia);
		}
		Pais pais = paisHome.getDefinedInstance();
		if (pais != null) {
			getInstance().setPais(pais);
		}
		Establecimiento establecimiento = establecimientoHome
				.getDefinedInstance();
		if (establecimiento != null) {
			getInstance().setEstablecimiento(establecimiento);
		}
		Banco banco = bancoHome.getDefinedInstance();
		if (banco != null) {
			getInstance().setBanco(banco);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Porcentcomisiontxparampromo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
