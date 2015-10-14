package org.domain.monedaliquidacion.session;

import org.domain.monedaliquidacion.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("facturaHome")
public class FacturaHome extends EntityHome<Factura> {

	@In(create = true)
	TransaccionHome transaccionHome;

	public void setFacturaId(FacturaId id) {
		setId(id);
	}

	public FacturaId getFacturaId() {
		return (FacturaId) getId();
	}

	public FacturaHome() {
		setFacturaId(new FacturaId());
	}

	@Override
	public boolean isIdDefined() {
		if (getFacturaId().getNumfactura() == null
				|| "".equals(getFacturaId().getNumfactura()))
			return false;
		if (getFacturaId().getCodigounico() == null
				|| "".equals(getFacturaId().getCodigounico()))
			return false;
		return true;
	}

	@Override
	protected Factura createInstance() {
		Factura factura = new Factura();
		factura.setId(new FacturaId());
		return factura;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Transaccion transaccion = transaccionHome.getDefinedInstance();
		if (transaccion != null) {
			getInstance().setTransaccion(transaccion);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Factura getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Detallefactura> getDetallefacturas() {
		return getInstance() == null ? null : new ArrayList<Detallefactura>(
				getInstance().getDetallefacturas());
	}

}
