package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gastosList")
public class GastosList extends EntityQuery<Gastos> {

	private static final String EJBQL = "select gastos from Gastos gastos";

	private static final String[] RESTRICTIONS = { "lower(gastos.observacion) like lower(concat(#{gastosList.gastos.observacion},'%'))", };

	private Gastos gastos = new Gastos();

	public GastosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Gastos getGastos() {
		return gastos;
	}
}
