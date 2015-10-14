package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cneList")
public class CneList extends EntityQuery<Cne> {

	private static final String EJBQL = "select cne from Cne cne";

	private static final String[] RESTRICTIONS = {
			"lower(cne.cedula) like lower(concat(#{cneList.cne.cedula},'%'))",
			"lower(cne.nacionalidad) like lower(concat(#{cneList.cne.nacionalidad},'%'))",
			"lower(cne.primerApellido) like lower(concat(#{cneList.cne.primerApellido},'%'))",
			"lower(cne.segundoApellido) like lower(concat(#{cneList.cne.segundoApellido},'%'))",
			"lower(cne.primerNombre) like lower(concat(#{cneList.cne.primerNombre},'%'))",
			"lower(cne.segundoNombre) like lower(concat(#{cneList.cne.segundoNombre},'%'))",
			"lower(cne.estado) like lower(concat(#{cneList.cne.estado},'%'))",
			"lower(cne.codCentro) like lower(concat(#{cneList.cne.codCentro},'%'))", };

	private Cne cne = new Cne();

	public CneList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cne getCne() {
		return cne;
	}
}
