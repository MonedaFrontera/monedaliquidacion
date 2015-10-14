package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("auditUsuarioList")
public class AuditUsuarioList extends EntityQuery<AuditUsuario> {

	private static final String EJBQL = "select auditUsuario from AuditUsuario auditUsuario";

	private static final String[] RESTRICTIONS = {
			"lower(auditUsuario.id.usuario) like lower(concat(#{auditUsuarioList.auditUsuario.id.usuario},'%'))",
			"lower(auditUsuario.id.descripcion) like lower(concat(#{auditUsuarioList.auditUsuario.id.descripcion},'%'))",
			"lower(auditUsuario.id.ipcliente) like lower(concat(#{auditUsuarioList.auditUsuario.id.ipcliente},'%'))", };

	private AuditUsuario auditUsuario;

	public AuditUsuarioList() {
		auditUsuario = new AuditUsuario();
		auditUsuario.setId(new AuditUsuarioId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public AuditUsuario getAuditUsuario() {
		return auditUsuario;
	}
}
