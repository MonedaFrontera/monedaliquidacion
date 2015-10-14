package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("deduccionesList")
public class DeduccionesList extends EntityQuery<Deducciones> {

	private static final String EJBQL = "select deducciones from Deducciones deducciones";

	private static final String[] RESTRICTIONS = {
			"lower(deducciones.id.descripcion) like lower(concat(#{deduccionesList.deducciones.id.descripcion},'%'))",
			"lower(deducciones.tipo) like lower(concat(#{deduccionesList.deducciones.tipo},'%'))", };

	private Deducciones deducciones;

	public DeduccionesList() {
		deducciones = new Deducciones();
		deducciones.setId(new DeduccionesId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Deducciones getDeducciones() {
		return deducciones;
	}
}
