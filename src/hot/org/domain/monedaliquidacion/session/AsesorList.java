package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("asesorList")
public class AsesorList extends EntityQuery<Asesor> {

	private static final String EJBQL = "select asesor from Asesor asesor";

	private static final String[] RESTRICTIONS = {
			"lower(asesor.documento) like lower(concat(#{asesorList.asesor.documento},'%'))",
			"lower(asesor.telefonooficina) like lower(concat(#{asesorList.asesor.telefonooficina},'%'))",
			"lower(asesor.extension) like lower(concat(#{asesorList.asesor.extension},'%'))", };

	private Asesor asesor = new Asesor();

	public AsesorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Asesor getAsesor() {
		return asesor;
	}
}
