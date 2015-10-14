package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("transaccionList")
public class TransaccionList extends EntityQuery<Transaccion> {

	private static final String EJBQL = "select transaccion from Transaccion transaccion";

	private static final String[] RESTRICTIONS = {
			"lower(transaccion.tipotx) like lower(concat(#{transaccionList.transaccion.tipotx},'%'))",
			"lower(transaccion.numfactura) like lower(concat(#{transaccionList.transaccion.numfactura},'%'))",
			"lower(transaccion.usuariomod) like lower(concat(#{transaccionList.transaccion.usuariomod},'%'))",
			"lower(transaccion.asesor) like lower(concat(#{transaccionList.transaccion.asesor},'%'))",
			"lower(transaccion.promotor) like lower(concat(#{transaccionList.transaccion.promotor},'%'))",
			"lower(transaccion.arrastrador) like lower(concat(#{transaccionList.transaccion.arrastrador},'%'))",
			"lower(transaccion.digitador) like lower(concat(#{transaccionList.transaccion.digitador},'%'))", };

	private Transaccion transaccion = new Transaccion();

	public TransaccionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Transaccion getTransaccion() {
		return transaccion;
	}
}
