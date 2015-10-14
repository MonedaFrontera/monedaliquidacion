package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cnedireccionList")
public class CnedireccionList extends EntityQuery<Cnedireccion> {

	private static final String EJBQL = "select cnedireccion from Cnedireccion cnedireccion";

	private static final String[] RESTRICTIONS = {
			"lower(cnedireccion.codCentro) like lower(concat(#{cnedireccionList.cnedireccion.codCentro},'%'))",
			"lower(cnedireccion.tipo) like lower(concat(#{cnedireccionList.cnedireccion.tipo},'%'))",
			"lower(cnedireccion.codEstado) like lower(concat(#{cnedireccionList.cnedireccion.codEstado},'%'))",
			"lower(cnedireccion.codMunicipio) like lower(concat(#{cnedireccionList.cnedireccion.codMunicipio},'%'))",
			"lower(cnedireccion.codParroquia) like lower(concat(#{cnedireccionList.cnedireccion.codParroquia},'%'))",
			"lower(cnedireccion.nombreCentro) like lower(concat(#{cnedireccionList.cnedireccion.nombreCentro},'%'))",
			"lower(cnedireccion.direccionCentro) like lower(concat(#{cnedireccionList.cnedireccion.direccionCentro},'%'))",
			"lower(cnedireccion.centroNuevo) like lower(concat(#{cnedireccionList.cnedireccion.centroNuevo},'%'))", };

	private Cnedireccion cnedireccion = new Cnedireccion();

	public CnedireccionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cnedireccion getCnedireccion() {
		return cnedireccion;
	}
}
