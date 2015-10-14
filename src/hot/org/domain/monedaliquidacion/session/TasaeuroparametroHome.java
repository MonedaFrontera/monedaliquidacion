package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tasaeuroparametroHome")
public class TasaeuroparametroHome extends EntityHome<Tasaeuroparametro> {

	@In(create = true)
	FranquiciaHome franquiciaHome;
	@In(create = true)
	PaisHome paisHome;
	@In(create = true)
	EstablecimientoHome establecimientoHome;
	@In(create = true)
	BancoHome bancoHome;

	public void setTasaeuroparametroConsecutivo(Integer id) {
		setId(id);
	}

	public Integer getTasaeuroparametroConsecutivo() {
		return (Integer) getId();
	}

	@Override
	protected Tasaeuroparametro createInstance() {
		Tasaeuroparametro tasaeuroparametro = new Tasaeuroparametro();
		return tasaeuroparametro;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
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

	public Tasaeuroparametro getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
