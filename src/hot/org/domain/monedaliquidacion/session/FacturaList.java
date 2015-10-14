package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("facturaList")
public class FacturaList extends EntityQuery<Factura> {

	private static final String EJBQL = "select factura from Factura factura";

	private static final String[] RESTRICTIONS = {
			"lower(factura.id.numfactura) like lower(concat(#{facturaList.factura.id.numfactura},'%'))",
			"lower(factura.id.codigounico) like lower(concat(#{facturaList.factura.id.codigounico},'%'))", };

	private Factura factura;

	public FacturaList() {
		factura = new Factura();
		factura.setId(new FacturaId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Factura getFactura() {
		return factura;
	}
}
