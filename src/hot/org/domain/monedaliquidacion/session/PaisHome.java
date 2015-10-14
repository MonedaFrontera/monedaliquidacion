package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("paisHome")
public class PaisHome extends EntityHome<Pais> {

	@In(create = true)
	PaisisoHome paisisoHome;

	public void setPaisCodigopais(String id) {
		setId(id);
	}

	public String getPaisCodigopais() {
		return (String) getId();
	}

	@Override
	protected Pais createInstance() {
		Pais pais = new Pais();
		return pais;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Paisiso paisiso = paisisoHome.getDefinedInstance();
		if (paisiso != null) {
			getInstance().setPaisiso(paisiso);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Pais getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tasaeuroparametro> getTasaeuroparametros() {
		return getInstance() == null ? null : new ArrayList<Tasaeuroparametro>(
				getInstance().getTasaeuroparametros());
	}

	public List<Promotorcomisiontx> getPromotorcomisiontxes() {
		return getInstance() == null ? null
				: new ArrayList<Promotorcomisiontx>(getInstance()
						.getPromotorcomisiontxes());
	}

	public List<Promotortasa> getPromotortasas() {
		return getInstance() == null ? null : new ArrayList<Promotortasa>(
				getInstance().getPromotortasas());
	}

	public List<Tasaeuropromotorparametro> getTasaeuropromotorparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasaeuropromotorparametro>(getInstance()
						.getTasaeuropromotorparametros());
	}

	public List<Porcentajecomisiontx> getPorcentajecomisiontxes() {
		return getInstance() == null ? null
				: new ArrayList<Porcentajecomisiontx>(getInstance()
						.getPorcentajecomisiontxes());
	}

	public List<Porcentcomisiontxparampromo> getPorcentcomisiontxparampromos() {
		return getInstance() == null ? null
				: new ArrayList<Porcentcomisiontxparampromo>(getInstance()
						.getPorcentcomisiontxparampromos());
	}

	public List<Tasadolarparametro> getTasadolarparametros() {
		return getInstance() == null ? null
				: new ArrayList<Tasadolarparametro>(getInstance()
						.getTasadolarparametros());
	}

	public List<Establecimiento> getEstablecimientos() {
		return getInstance() == null ? null : new ArrayList<Establecimiento>(
				getInstance().getEstablecimientos());
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

	public List<Tasadolar> getTasadolars() {
		return getInstance() == null ? null : new ArrayList<Tasadolar>(
				getInstance().getTasadolars());
	}

}
