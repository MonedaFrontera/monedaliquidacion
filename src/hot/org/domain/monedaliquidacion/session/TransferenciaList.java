package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("transferenciaList")
public class TransferenciaList extends EntityQuery<Transferencia> {

	private static final String EJBQL = "select transferencia from Transferencia transferencia";

	private static final String[] RESTRICTIONS = {
			"lower(transferencia.tipobolivar) like lower(concat(#{transferenciaList.transferencia.tipobolivar},'%'))",
			"lower(transferencia.numcuenta) like lower(concat(#{transferenciaList.transferencia.numcuenta},'%'))", };

	private Transferencia transferencia = new Transferencia();

	public TransferenciaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}
}
