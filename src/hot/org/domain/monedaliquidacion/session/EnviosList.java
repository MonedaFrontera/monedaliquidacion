package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("enviosList")
public class EnviosList extends EntityQuery<Envios> {

	private static final String EJBQL = "select envios from Envios envios";

	private static final String[] RESTRICTIONS = {
			"lower(envios.envia) like lower(concat(#{enviosList.envios.envia},'%'))",
			"lower(envios.recibe) like lower(concat(#{enviosList.envios.recibe},'%'))",
			"lower(envios.oficina) like lower(concat(#{enviosList.envios.oficina},'%'))",
			"lower(envios.ciudad) like lower(concat(#{enviosList.envios.ciudad},'%'))",
			"lower(envios.nrocupon) like lower(concat(#{enviosList.envios.nrocupon},'%'))", };

	private Envios envios = new Envios();

	public EnviosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Envios getEnvios() {
		return envios;
	}
}
