package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("bancoHome")
public class BancoHome extends EntityHome<Banco> {

	public void setBancoCodbanco(String id) {
		setId(id);
	}

	public String getBancoCodbanco() {
		return (String) getId();
	}

	@Override
	protected Banco createInstance() {
		Banco banco = new Banco();
		return banco;
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

	public Banco getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
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

	public List<Cuentapromotor> getCuentapromotors() {
		return getInstance() == null ? null : new ArrayList<Cuentapromotor>(
				getInstance().getCuentapromotors());
	}

	public List<Porcentajecomisiontxparam> getPorcentajecomisiontxparams() {
		return getInstance() == null ? null
				: new ArrayList<Porcentajecomisiontxparam>(getInstance()
						.getPorcentajecomisiontxparams());
	}

	public List<Tasadolarpromotorparametro> getTasadolarpromotorparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasadolarpromotorparametro>(getInstance()
						.getTasadolarpromotorparametros());
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

	public List<Tasaeuroparametro> getTasaeuroparametros() {
		return getInstance() == null ? null : new ArrayList<Tasaeuroparametro>(
				getInstance().getTasaeuroparametros());
	}

	public List<Cuenta> getCuentas() {
		return getInstance() == null ? null : new ArrayList<Cuenta>(
				getInstance().getCuentas());
	}

	public List<Activacion> getActivacions() {
		return getInstance() == null ? null : new ArrayList<Activacion>(
				getInstance().getActivacions());
	}

}
