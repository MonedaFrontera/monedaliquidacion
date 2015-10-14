package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("configHome")
public class ConfigHome extends EntityHome<Config> {

	public void setConfigNautovoz(Integer id) {
		setId(id);
	}

	public Integer getConfigNautovoz() {
		return (Integer) getId();
	}

	@Override
	protected Config createInstance() {
		Config config = new Config();
		return config;
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

	public Config getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
