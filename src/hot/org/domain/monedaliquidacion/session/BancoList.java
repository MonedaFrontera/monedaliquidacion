package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("bancoList")
public class BancoList extends EntityQuery<Banco> {

	private static final String EJBQL = "select banco from Banco banco";

	private static final String[] RESTRICTIONS = {
			"lower(banco.codbanco) like lower(concat(#{bancoList.banco.codbanco},'%'))",
			"lower(banco.nombrebanco) like lower(concat(#{bancoList.banco.nombrebanco},'%'))", };

	private Banco banco = new Banco();

	public BancoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Banco getBanco() {
		return banco;
	}
}
