package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tasabolivarnegociadoList")
public class TasabolivarnegociadoList extends EntityQuery<Tasabolivarnegociado> {

	private static final String EJBQL = "select tasabolivarnegociado from Tasabolivarnegociado tasabolivarnegociado";

	private static final String[] RESTRICTIONS = {
			"lower(tasabolivarnegociado.id.documento) like lower(concat(#{tasabolivarnegociadoList.tasabolivarnegociado.id.documento},'%'))",
			"lower(tasabolivarnegociado.id.tipo) like lower(concat(#{tasabolivarnegociadoList.tasabolivarnegociado.id.tipo},'%'))",
			"lower(tasabolivarnegociado.usuariomod) like lower(concat(#{tasabolivarnegociadoList.tasabolivarnegociado.usuariomod},'%'))", };

	private Tasabolivarnegociado tasabolivarnegociado;

	public TasabolivarnegociadoList() {
		tasabolivarnegociado = new Tasabolivarnegociado();
		tasabolivarnegociado.setId(new TasabolivarnegociadoId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tasabolivarnegociado getTasabolivarnegociado() {
		return tasabolivarnegociado;
	}
}
