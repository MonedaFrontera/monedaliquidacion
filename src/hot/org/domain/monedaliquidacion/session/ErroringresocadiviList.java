package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("erroringresocadiviList")
public class ErroringresocadiviList extends EntityQuery<Erroringresocadivi> {

	private static final String EJBQL = "select erroringresocadivi from Erroringresocadivi erroringresocadivi";

	private static final String[] RESTRICTIONS = {};

	private Erroringresocadivi erroringresocadivi;

	public ErroringresocadiviList() {
		erroringresocadivi = new Erroringresocadivi();
		erroringresocadivi.setId(new ErroringresocadiviId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Erroringresocadivi getErroringresocadivi() {
		return erroringresocadivi;
	}
}
