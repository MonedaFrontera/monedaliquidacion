package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("paridadmonedaList")
public class ParidadmonedaList extends EntityQuery<Paridadmoneda> {

	private static final String EJBQL = "select paridadmoneda from Paridadmoneda paridadmoneda";

	private static final String[] RESTRICTIONS = {};

	private Paridadmoneda paridadmoneda = new Paridadmoneda();

	public ParidadmonedaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Paridadmoneda getParidadmoneda() {
		return paridadmoneda;
	}
}
