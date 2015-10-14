package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("autovozList")
public class AutovozList extends EntityQuery<Autovoz> {

	private static final String EJBQL = "select autovoz from Autovoz autovoz";

	private static final String[] RESTRICTIONS = {
			"lower(autovoz.tipotx) like lower(concat(#{autovozList.autovoz.tipotx},'%'))",
			"lower(autovoz.usuariomod) like lower(concat(#{autovozList.autovoz.usuariomod},'%'))",
			"lower(autovoz.numautorizacion) like lower(concat(#{autovozList.autovoz.numautorizacion},'%'))",
			"lower(autovoz.asesor) like lower(concat(#{autovozList.autovoz.asesor},'%'))", };

	private Autovoz autovoz = new Autovoz();

	public AutovozList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Autovoz getAutovoz() {
		return autovoz;
	}
}
