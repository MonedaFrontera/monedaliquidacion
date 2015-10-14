package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tasabolivartransferpaisList")
public class TasabolivartransferpaisList extends
		EntityQuery<Tasabolivartransferpais> {

	private static final String EJBQL = "select tasabolivartransferpais from Tasabolivartransferpais tasabolivartransferpais";

	private static final String[] RESTRICTIONS = { "lower(tasabolivartransferpais.id.codigopais) like lower(concat(#{tasabolivartransferpaisList.tasabolivartransferpais.id.codigopais},'%'))", };

	private Tasabolivartransferpais tasabolivartransferpais;

	public TasabolivartransferpaisList() {
		tasabolivartransferpais = new Tasabolivartransferpais();
		tasabolivartransferpais.setId(new TasabolivartransferpaisId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tasabolivartransferpais getTasabolivartransferpais() {
		return tasabolivartransferpais;
	}
}
