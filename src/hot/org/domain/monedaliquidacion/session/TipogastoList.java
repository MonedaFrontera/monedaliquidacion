package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipogastoList")
public class TipogastoList extends EntityQuery<Tipogasto> {

	private static final String EJBQL = "select tipogasto from Tipogasto tipogasto";

	private static final String[] RESTRICTIONS = {
			"lower(tipogasto.codtipogasto) like lower(concat(#{tipogastoList.tipogasto.codtipogasto},'%'))",
			"lower(tipogasto.descripcion) like lower(concat(#{tipogastoList.tipogasto.descripcion},'%'))",
			"lower(tipogasto.tipo) like lower(concat(#{tipogastoList.tipogasto.tipo},'%'))", };

	private Tipogasto tipogasto = new Tipogasto();

	public TipogastoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tipogasto getTipogasto() {
		return tipogasto;
	}
}
