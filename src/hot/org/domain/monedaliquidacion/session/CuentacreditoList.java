package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cuentacreditoList")
public class CuentacreditoList extends EntityQuery<Cuentacredito> {

	private static final String EJBQL = "select cuentacredito from Cuentacredito cuentacredito";

	private static final String[] RESTRICTIONS = {
			"lower(cuentacredito.usuario) like lower(concat(#{cuentacreditoList.cuentacredito.usuario},'%'))",
			"lower(cuentacredito.usuariomod) like lower(concat(#{cuentacreditoList.cuentacredito.usuariomod},'%'))",
			"lower(cuentacredito.observacion) like lower(concat(#{cuentacreditoList.cuentacredito.observacion},'%'))", };

	private Cuentacredito cuentacredito = new Cuentacredito();

	public CuentacreditoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cuentacredito getCuentacredito() {
		return cuentacredito;
	}
}
