package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tasadolarList")
public class TasadolarList extends EntityQuery<Tasadolar> {

	private static final String EJBQL = "select tasadolar from Tasadolar tasadolar";

	private static final String[] RESTRICTIONS = { "lower(tasadolar.id.codigopais) like lower(concat(#{tasadolarList.tasadolar.id.codigopais},'%'))", };

	private Tasadolar tasadolar;

	public TasadolarList() {
		tasadolar = new Tasadolar();
		tasadolar.setId(new TasadolarId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tasadolar getTasadolar() {
		return tasadolar;
	}
}
