package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tarjetaviajeList")
public class TarjetaviajeList extends EntityQuery<Tarjetaviaje> {

	private static final String EJBQL = "select tarjetaviaje from Tarjetaviaje tarjetaviaje";

	private static final String[] RESTRICTIONS = {
			"lower(tarjetaviaje.id.numerotarjeta) like lower(concat(#{tarjetaviajeList.tarjetaviaje.id.numerotarjeta},'%'))",
			"lower(tarjetaviaje.usuariomod) like lower(concat(#{tarjetaviajeList.tarjetaviaje.usuariomod},'%'))", };

	private Tarjetaviaje tarjetaviaje;

	public TarjetaviajeList() {
		tarjetaviaje = new Tarjetaviaje();
		tarjetaviaje.setId(new TarjetaviajeId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tarjetaviaje getTarjetaviaje() {
		return tarjetaviaje;
	}
}
