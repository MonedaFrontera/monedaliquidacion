package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("personaltipoprocesoList")
public class PersonaltipoprocesoList extends EntityQuery<Personaltipoproceso> {

	private static final String EJBQL = "select personaltipoproceso from Personaltipoproceso personaltipoproceso";

	private static final String[] RESTRICTIONS = {
			"lower(personaltipoproceso.id.documento) like lower(concat(#{personaltipoprocesoList.personaltipoproceso.id.documento},'%'))",
			"lower(personaltipoproceso.id.puntodeventa) like lower(concat(#{personaltipoprocesoList.personaltipoproceso.id.puntodeventa},'%'))",
			"lower(personaltipoproceso.id.tipoproceso) like lower(concat(#{personaltipoprocesoList.personaltipoproceso.id.tipoproceso},'%'))", };

	private Personaltipoproceso personaltipoproceso;

	public PersonaltipoprocesoList() {
		personaltipoproceso = new Personaltipoproceso();
		personaltipoproceso.setId(new PersonaltipoprocesoId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Personaltipoproceso getPersonaltipoproceso() {
		return personaltipoproceso;
	}
}
