package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cuentaList")
public class CuentaList extends EntityQuery<Cuenta> {

	private static final String EJBQL = "select cuenta from Cuenta cuenta";

	private static final String[] RESTRICTIONS = {
			"lower(cuenta.numcuenta) like lower(concat(#{cuentaList.cuenta.numcuenta},'%'))",
			"lower(cuenta.nombre) like lower(concat(#{cuentaList.cuenta.nombre},'%'))", };

	private Cuenta cuenta = new Cuenta();

	public CuentaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Cuenta getCuenta() {
		return cuenta;
	}
}
