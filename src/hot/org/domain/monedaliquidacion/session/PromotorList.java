package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("promotorList")
public class PromotorList extends EntityQuery<Promotor> {

	private static final String EJBQL = "select promotor from Promotor promotor";

	private static final String[] RESTRICTIONS = { "lower(promotor.documento) like lower(concat(#{promotorList.promotor.documento},'%'))", };

	private Promotor promotor = new Promotor();

	public PromotorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Promotor getPromotor() {
		return promotor;
	}
}
