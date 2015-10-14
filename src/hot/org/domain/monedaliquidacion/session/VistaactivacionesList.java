package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("vistaactivacionesList")
public class VistaactivacionesList extends EntityQuery<Vistaactivaciones> {

	private static final String EJBQL = "select vistaactivaciones from Vistaactivaciones vistaactivaciones";

	private static final String[] RESTRICTIONS = {
			"lower(vistaactivaciones.id.estado) like lower(concat(#{vistaactivacionesList.vistaactivaciones.id.estado},'%'))",
			"lower(vistaactivaciones.id.documento) like lower(concat(#{vistaactivacionesList.vistaactivaciones.id.documento},'%'))", };

	private Vistaactivaciones vistaactivaciones;

	public VistaactivacionesList() {
		vistaactivaciones = new Vistaactivaciones();
		vistaactivaciones.setId(new VistaactivacionesId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Vistaactivaciones getVistaactivaciones() {
		return vistaactivaciones;
	}
}
