package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("franquiciaHome")
public class FranquiciaHome extends EntityHome<Franquicia> {

	public void setFranquiciaCodfranquicia(String id) {
		setId(id);
	}

	public String getFranquiciaCodfranquicia() {
		return (String) getId();
	}

	@Override
	protected Franquicia createInstance() {
		Franquicia franquicia = new Franquicia();
		return franquicia;
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

	public Franquicia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tasadolarpromotorparametro> getTasadolarpromotorparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasadolarpromotorparametro>(getInstance()
						.getTasadolarpromotorparametros());
	}

	public List<Porcentajecomisiontxparam> getPorcentajecomisiontxparams() {
		return getInstance() == null ? null
				: new ArrayList<Porcentajecomisiontxparam>(getInstance()
						.getPorcentajecomisiontxparams());
	}

	public List<Tasaeuroparametro> getTasaeuroparametros() {
		return getInstance() == null ? null : new ArrayList<Tasaeuroparametro>(
				getInstance().getTasaeuroparametros());
	}

	public List<Tasaeuropromotorparametro> getTasaeuropromotorparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasaeuropromotorparametro>(getInstance()
						.getTasaeuropromotorparametros());
	}

	public List<Tasadolarparametro> getTasadolarparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasadolarparametro>(getInstance()
						.getTasadolarparametros());
	}

	public List<Porcentcomisiontxparampromo> getPorcentcomisiontxparampromos() {
		return getInstance() == null ? null
				: new ArrayList<Porcentcomisiontxparampromo>(getInstance()
						.getPorcentcomisiontxparampromos());
	}

	public List<Tarjeta> getTarjetas() {
		return getInstance() == null ? null : new ArrayList<Tarjeta>(
				getInstance().getTarjetas());
	}

	public List<Promotorfranquicia> getPromotorfranquicias() {
		return getInstance() == null ? null
				: new ArrayList<Promotorfranquicia>(getInstance()
						.getPromotorfranquicias());
	}

}
