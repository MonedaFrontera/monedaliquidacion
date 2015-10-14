package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("establecimientoList")
public class EstablecimientoList extends EntityQuery<Establecimiento> {

	private static final String EJBQL = "select establecimiento from Establecimiento establecimiento";

	private static final String[] RESTRICTIONS = {
			"lower(establecimiento.codigounico) like lower(concat(#{establecimientoList.establecimiento.codigounico},'%'))",
			"lower(establecimiento.nombreestable) like lower(concat(#{establecimientoList.establecimiento.nombreestable},'%'))",
			"lower(establecimiento.direccion) like lower(concat(#{establecimientoList.establecimiento.direccion},'%'))",
			"lower(establecimiento.telefono) like lower(concat(#{establecimientoList.establecimiento.telefono},'%'))",
			"lower(establecimiento.numcuenta) like lower(concat(#{establecimientoList.establecimiento.numcuenta},'%'))", };

	private Establecimiento establecimiento = new Establecimiento();

	public EstablecimientoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}
}
