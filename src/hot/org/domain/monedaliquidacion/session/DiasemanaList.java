package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("diasemanaList")
public class DiasemanaList extends EntityQuery<Diasemana> {

	private static final String EJBQL = "select diasemana from Diasemana diasemana";

	private static final String[] RESTRICTIONS = { "lower(diasemana.nombredia) like lower(concat(#{diasemanaList.diasemana.nombredia},'%'))", };

	private Diasemana diasemana = new Diasemana();

	public DiasemanaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Diasemana getDiasemana() {
		return diasemana;
	}
}
