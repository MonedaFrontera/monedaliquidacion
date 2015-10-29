package org.domain.monedaliquidacion.bussines;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.domain.monedaliquidacion.entity.Banco;
import org.domain.monedaliquidacion.entity.Establecimiento;
import org.domain.monedaliquidacion.entity.Establecimientoprecio;
import org.domain.monedaliquidacion.entity.EstablecimientoprecioId;
import org.domain.monedaliquidacion.entity.Franquicia;
import org.domain.monedaliquidacion.entity.Pais;
import org.domain.monedaliquidacion.entity.Porcentajecomisiontxparam;
import org.domain.monedaliquidacion.entity.Porcentcomisiontxparampromo;
import org.domain.monedaliquidacion.entity.Promotor;
import org.domain.monedaliquidacion.entity.Tasadolarparametro;
import org.domain.monedaliquidacion.entity.Tasadolarpromotorparametro;
import org.domain.monedaliquidacion.entity.Tasaeuroparametro;
import org.domain.monedaliquidacion.entity.Tasaeuropromotorparametro;
import org.domain.monedaliquidacion.session.BancoHome;
import org.domain.monedaliquidacion.session.EstablecimientoHome;
import org.domain.monedaliquidacion.session.FranquiciaHome;
import org.domain.monedaliquidacion.session.PaisHome;
import org.domain.monedaliquidacion.session.PromotorHome;
import org.domain.monedaliquidacion.session.TasadolarpromotorparametroHome;
import org.domain.monedaliquidacion.util.CargarObjetos;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;



@Name("AdministrarTasa")
@Scope(ScopeType.CONVERSATION)
public class AdministrarTasa
{
	
	 	@Logger private Log log;

	    @In StatusMessages statusMessages; 

	    @In private FacesMessages facesMessages;
	    
	    @In
		private EntityManager entityManager;
	    
	    
	    /************************************************
	     * Entidades a ingresar en la clase de negocio	*
	     ************************************************/
	    
	    @In(create=true) @Out 
	    PaisHome paisHome;
	    
	    @In(create=true) @Out 
	    PromotorHome promotorHome;
	    
	    @In(create=true) @Out 
	    EstablecimientoHome establecimientoHome;
	    
	    @In(create=true) @Out 
	    FranquiciaHome franquiciaHome;
	    
	    @In(create=true) @Out 
	    BancoHome bancoHome;
	    
	    @In(create=true) @Out 
	    TasadolarpromotorparametroHome tasadolarpromotorparametroHome;
	    
	    @In(create=true)
		private CargarObjetos CargarObjetos;
	    
	    List<String> lista = new ArrayList<String>();
	    
	    //Campos del formulario
	    private Pais paisTemp;
	    private Promotor promoTemp;
	    private Establecimiento estaTemp;	  
	    private Franquicia frqTemp;
	    private Banco bancoTemp;
	    private String tipoCupoTemp = "V";
	    private Date fechaIniTemp;
	    private Date fechaFinTemp;
	    
	    private BigDecimal tasaDolarTemp;
	    private BigDecimal tasaDolarNegTemp;
	    private BigDecimal tasaDolarTacTemp;
	    private BigDecimal tasaDolarOfTemp;
	    
	    private BigDecimal tasaEuroTemp;
	    private BigDecimal tasaEuroNegTemp;
	    private BigDecimal tasaEuroTacTemp;
	    private BigDecimal tasaEuroOfTemp;
	    
	    private BigDecimal porcentCt;
	    private BigDecimal porcentOfi;

	    private BigDecimal paridadEstTemp;
	    private BigDecimal paridadClienteTemp;
	    
	    private String codMoneda;
	    
		private Tasaeuropromotorparametro tsEuroPromo;
		private Tasaeuroparametro tsEuroParam;
		private Tasadolarpromotorparametro tsDolarPromo;		
		private Tasadolarparametro tsDolarParam;
		
		private Porcentcomisiontxparampromo porcentajePromo;
		private Porcentajecomisiontxparam porcentajeGlob;
		
		private String pathBandera;
		
		private boolean formValido;
	    
		
		 public void administrarTasa() {
			 // implement your business logic here
			 log.info("AdministrarTasa.administrarTasa() action called");
			 statusMessages.add("administrarTasa");
		} 
		
	   //Getter and Setter variables del formulario
	   
	    public Pais getPaisTemp() {
			return paisTemp;
		}

		public void setPaisTemp(Pais paisTemp) {
			this.paisTemp = paisTemp;
		}

		public Promotor getPromoTemp() {
			return promoTemp;
		}

		public void setPromoTemp(Promotor promoTemp) {
			this.promoTemp = promoTemp;
		}

		public Franquicia getFrqTemp() {
			return frqTemp;
		}

		public void setFrqTemp(Franquicia frqTemp) {
			this.frqTemp = frqTemp;
		}

		public Banco getBancoTemp() {
			return bancoTemp;
		}

		public void setBancoTemp(Banco bancoTemp) {
			this.bancoTemp = bancoTemp;
		}

		public String getTipoCupoTemp() {
			return tipoCupoTemp;
		}

		public void setTipoCupoTemp(String tipoCupoTemp) {
			this.tipoCupoTemp = tipoCupoTemp;
		}

		public Date getFechaIniTemp() {
			return fechaIniTemp;
		}

		public void setFechaIniTemp(Date fechaIniTemp) {
			this.fechaIniTemp = fechaIniTemp;
		}

		public Date getFechaFinTemp() {
			return fechaFinTemp;
		}

		public void setFechaFinTemp(Date fechaFinTemp) {
			this.fechaFinTemp = fechaFinTemp;
		}

		public BigDecimal getTasaDolarTemp() {
			return tasaDolarTemp;
		}

		public void setTasaDolarTemp(BigDecimal tasaDolarTemp) {
			this.tasaDolarTemp = tasaDolarTemp;
		}

		public BigDecimal getTasaDolarNegTemp() {
			return tasaDolarNegTemp;
		}

		public void setTasaDolarNegTemp(BigDecimal tasaDolarNegTemp) {
			this.tasaDolarNegTemp = tasaDolarNegTemp;
		}

		public BigDecimal getTasaDolarTacTemp() {
			return tasaDolarTacTemp;
		}

		public void setTasaDolarTacTemp(BigDecimal tasaDolarTacTemp) {
			this.tasaDolarTacTemp = tasaDolarTacTemp;
		}

		public BigDecimal getTasaDolarOfTemp() {
			return tasaDolarOfTemp;
		}

		public void setTasaDolarOfTemp(BigDecimal tasaDolarOfTemp) {
			this.tasaDolarOfTemp = tasaDolarOfTemp;
		}

		public BigDecimal getTasaEuroTemp() {
			return tasaEuroTemp;
		}

		public void setTasaEuroTemp(BigDecimal tasaEuroTemp) {
			this.tasaEuroTemp = tasaEuroTemp;
		}

		public BigDecimal getTasaEuroNegTemp() {
			return tasaEuroNegTemp;
		}

		public void setTasaEuroNegTemp(BigDecimal tasaEuroNegTemp) {
			this.tasaEuroNegTemp = tasaEuroNegTemp;
		}

		public BigDecimal getTasaEuroTacTemp() {
			return tasaEuroTacTemp;
		}

		public void setTasaEuroTacTemp(BigDecimal tasaEuroTacTemp) {
			this.tasaEuroTacTemp = tasaEuroTacTemp;
		}

		public BigDecimal getTasaEuroOfTemp() {
			return tasaEuroOfTemp;
		}

		public void setTasaEuroOfTemp(BigDecimal tasaEuroOfTemp) {
			this.tasaEuroOfTemp = tasaEuroOfTemp;
		}

		public BigDecimal getPorcentCt() {
			return porcentCt;
		}

		public void setPorcentCt(BigDecimal porcentCt) {
			this.porcentCt = porcentCt;
		}

		public BigDecimal getPorcentOfi() {
			return porcentOfi;
		}

		public void setPorcentOfi(BigDecimal porcentOfi) {
			this.porcentOfi = porcentOfi;
		}

		public BigDecimal getParidadEstTemp() {
			return paridadEstTemp;
		}

		public void setParidadEstTemp(BigDecimal paridadEstTemp) {
			this.paridadEstTemp = paridadEstTemp;
		}

		public BigDecimal getParidadClienteTemp() {
			return paridadClienteTemp;
		}

		public void setParidadClienteTemp(BigDecimal paridadClienteTemp) {
			this.paridadClienteTemp = paridadClienteTemp;
		}
		
		public String getCodMoneda() {
			return codMoneda;
		}

		public void setCodMoneda(String codMoneda) {
			this.codMoneda = codMoneda;
		}

		public Establecimiento getEstaTemp() {
			return estaTemp;
		}

		public void setEstaTemp(Establecimiento estaTemp) {
			this.estaTemp = estaTemp;
		}
		
		
		public String getPathBandera() {
			return pathBandera;
		}

		public void setPathBandera(String pathBandera) {
			this.pathBandera = pathBandera;
		}
		
		public boolean isFormValido() {
			return formValido;
		}

		public void setFormValido(boolean formValido) {
			this.formValido = formValido;
		}

		//Metodos de servicio para la Vista		
		public void ubicarPromotor(){
			Promotor pr = CargarObjetos.ubicarPromotor(this.nombre);
			if(pr!=null){
				promotorHome.setPromotorDocumento(pr.getDocumento());
				promotorHome.setInstance(pr);
				this.setPromoTemp(pr);
			}
		}
		
		private String nombre = "";

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public void llenarPromotores(){
			entityManager.clear();
			String sql = "";
			List<String> resultList = entityManager.createQuery("select " +
					"p.personal.nombre||' '||p.personal.apellido from Promotor p "+ 
					sql).getResultList();
			lista = resultList;
		}		
		
	    public List<String> autocompletar(Object nom) {
			llenarPromotores(); 							// Metodo que carga la informacion de los nombres de las personas
			String nombre = (String) nom;
			List<String> result = new ArrayList<String>();
			StringTokenizer tokens = new StringTokenizer(nombre.toLowerCase());
			StringBuilder bldr = new StringBuilder();//builder usado para formar el patron
			
			long t1 = System.currentTimeMillis();
			// creamos el patron para la busqueda
			int lengthToken = nombre.split("\\s+").length;// longitud de palabras
															// en el nombre
			int cont = 1;
			while (tokens.hasMoreTokens()) {			
				if (cont == lengthToken && lengthToken == 1) {
					bldr.append(".*").append(tokens.nextToken()).append(".*");
				} else {
					if (cont++ < lengthToken--) {
						bldr.append(".*").append(tokens.nextToken()).append(".*");
						lengthToken--;
					} else {
						bldr.append(tokens.nextToken()).append(".*");
					}
				}
			}		
			Pattern p = Pattern.compile(bldr.toString().trim());
			Matcher match;		
			// realiza la busqueda
			for (String promo : lista) {			
				match = p.matcher(promo.toLowerCase());
				boolean b = match.find();
				if (b) {
					result.add(promo);				
				}		
			}
			long t2 = System.currentTimeMillis() - t1;
			System.out.println(">>>Tiempo total de la busqueda: " + t2 + "ms");		
		
			return result;
		}
	    
	    
	    private String sugestion = "";
	    
	    public String getSugestion() {
			return sugestion;
		}

		public void setSugestion(String sugestion) {
			this.sugestion = sugestion;
		}
		
		public void ubicarEstablecimiento()
		{
			entityManager.clear();			
			List<Establecimiento> e = (ArrayList)entityManager
			.createQuery("select e from Establecimiento e where trim(e.nombreestable) = " +
					"trim('"+this.sugestion+"')").getResultList();
			
			if (e.size() > 0) {
				Establecimiento es = e.get(0); 				
					establecimientoHome.setEstablecimientoCodigounico(es.getCodigounico());
				establecimientoHome.setInstance(es);
				this.setEstaTemp(es);
			}		
		}
		
		public void llenarEstablcimiento(){
			entityManager.clear();
		
			List<String> resultList = entityManager.createQuery(" select e.nombreestable from Establecimiento e " +  
					"where e.pais.codigopais = '" + 
					this.getPaisTemp().getCodigopais()+"'" ).getResultList();
			lista = resultList;
		}
		
		public List<String> autocompletarEstablecimiento(Object suggest) {
			long t1 = System.currentTimeMillis();

			llenarEstablcimiento();
			String nombre = (String) suggest;
			List<String> result = new ArrayList<String>();
			StringTokenizer tokens = new StringTokenizer(nombre.toLowerCase());
			StringBuilder bldr = new StringBuilder();//builder usado para formar el patron
			
			// creamos el patron para la busqueda
			int lengthToken = nombre.split("\\s+").length;// longitud de palabras
															// en el nombre
			int cont = 1;
			while (tokens.hasMoreTokens()) {			
				if (cont == lengthToken && lengthToken == 1) {
					bldr.append(".*").append(tokens.nextToken()).append(".*");
				} else {
					if (cont++ < lengthToken--) {
						bldr.append(".*").append(tokens.nextToken()).append(".*");
						lengthToken--;
					} else {
						bldr.append(tokens.nextToken()).append(".*");
					}
				}
			}		
			Pattern p = Pattern.compile(bldr.toString().trim());
			Matcher match;		
			// realiza la busqueda
			for (String establecimiento : lista) {			
				match = p.matcher(establecimiento.toLowerCase());
				boolean b = match.find();
				if (b) {
					result.add(establecimiento);				
				}		
			}
			long t2 = System.currentTimeMillis() - t1;
			System.out.println(">>>Tiempo total de la busqueda: " + t2 + "ms");	
		return result;
		}
		
		public void listarComercios( String codPaisT){
			this.llenarEstablcimiento();
			Pais paisT = entityManager.find(Pais.class, codPaisT);
			System.out.println("Estableciendo codigo moneda.....");
			
			this.setCodMoneda(paisT.getPaisiso().getCodigomoneda().trim());
			this.setPathBandera( "img/flags" + 
									paisT.getPaisiso().getPathBanderaGui());
			
			System.out.println("PATH BANDERA: " + this.getPathBandera());
		}
		
		
		//Metodos de persistencia
		
		/**
		 * Graba los parametros de liquidacion de las transacciones como
		 * Tasa Dolar, Tasa Euro, porcentajes de comision y paridad de monedas
		 * @return
		 */
		public String guardarTasaDolarParam(){			
			
			// Valida que se haya elegido un pais
			if( this.getPaisTemp() == null || this.getPaisTemp().equals("") ){
				facesMessages.addToControl("paisSel",
						"Se debe seleccionar un pais");
					return null;
			}			
			// Valida que se haya seleccionado la fecha
			if( this.getFechaIniTemp() == null){
				facesMessages.addToControl("fechainicio",	
				"Se debe seleccionar una fecha para esta tasa");
				return null;
				
			}
			// Valida que se haya ingresado las tasas y porcentajes para estableicimiento
			if( this.getPaisTemp().getPaisiso().getCodigomoneda().equals("EUR")){
				if( this.getTasaEuroOfTemp() == null ){
					facesMessages.addToControl("tasaeurorOf",	
					"Se debe ingresar la tasa de euro para la oficina");
					return null;
				}
				if(this.getTasaEuroTacTemp() == null){
					facesMessages.addToControl("tasaeuroTac",	
					"Se debe ingresar la tasa de euro para clientes TAC");
					return null;
				}					
				if(this.getTasaEuroTemp() == null){					
					facesMessages.addToControl("tasaEuro",	
					"Se debe ingresar la tasa de euro para clientes");
					return null;
				}	
				//Valida el porcentaje de oficna y cliente 
				if( this.getPorcentCt() == null ){
					facesMessages.addToControl("porcentClient",	
					"Se debe ingresar la tasa de porcentaje  para cliente");
					return null;
				}
				if( this.getPorcentOfi()== null ){
					facesMessages.addToControl("porcentOf",	
					"Se debe ingresar la tasa de porcentaje para oficina");
					return null;
				}
			}else{
				if( this.getTasaDolarOfTemp() == null ){
					facesMessages.addToControl("tasadolarOf",	
					"Se debe ingresar la tasa de dolar para la oficina");
					return null;
				}
				if(this.getTasaEuroTacTemp() == null){
					facesMessages.addToControl("tasadolarTac",	
					"Se debe ingresar la tasa de dolar para clientes TAC");
					return null;
				}					
				if(this.getTasaEuroTemp() == null){					
					facesMessages.addToControl("tasadolar",	
					"Se debe ingresar la tasa de dolar para clientes");
					return null;
				}
				//Valida el porcentaje de oficna y cliente 
				if( this.getPorcentCt() == null ){
					facesMessages.addToControl("porcentClient",	
					"Se debe ingresar la tasa de porcentaje  para cliente");
					return null;
				}
				if( this.getPorcentOfi()== null ){
					facesMessages.addToControl("porcentOf",	
					"Se debe ingresar la tasa de porcentaje para oficina");
					return null;
				}
			}			
			
			// Valida que se haya seleccionado un establecimiento
			System.out.println(this.getTasaEuroOfTemp() != null);
			System.out.println(this.getTasaDolarOfTemp() != null);
			if((this.getTasaDolarOfTemp() != null || this.getTasaEuroOfTemp() != null) &&
					this.getEstaTemp() == null ){
				facesMessages.addToControl("name",	
					"Se debe seleccionar el establecimiento");
					return null;
			}
			// Valida los parametros de euro negociado para promotor
			if( this.getPromoTemp() != null && 
					this.getPaisTemp().getPaisiso().getCodigomoneda().equals("EUR") ){
				if( this.getPorcentCt() == null){
					facesMessages.addToControl("porcentClient",	
					"Se debe ingresar la tasa de porcentaje  para cliente");
					return null;					
				}
				if(this.getTasaEuroNegTemp() == null){
					facesMessages.addToControl("tasaeurorNeg",	
					"Se debe ingresar la tasa de euro  para cliente");
					return null;
					
				}
			}
			// Valida los parametros de dolar negociado para promotor
			if( this.getPromoTemp() != null && 
					this.getPaisTemp().getPaisiso().getCodigomoneda().equals("USD") ){
				if( this.getPorcentCt() == null){
					facesMessages.addToControl("porcentClient",	
					"Se debe ingresar la tasa de porcentaje  para cliente");
					return null;					
				}
				if(this.getTasaDolarNegTemp() == null){
					facesMessages.addToControl("tasadolarNeg",	
					"Se debe ingresar la tasa de euro  para cliente");
					return null;
					
				}
			}
			
			
			Boolean euro = false;
			Boolean negociado = false;
			Boolean estbto = false;
			String mensaje= null;
			
			//1. Determina si se graba dolar o euros
			if( this.getCodMoneda().equals("EUR")){
				euro = true;
			}
			
			//2. Determina si es tasa negociada para cliente o global
			if( this.getPromoTemp() != null ){
				negociado = true;
			}
			
			//3. Variable para parametros del comercio
			if( this.getEstaTemp() != null && this.getPromoTemp() == null ){
				estbto = true;
			}
			
			System.out.println("EURO: " + euro);
			System.out.println("NEGOCIADO: " + negociado);
			
			System.out.println("");

			//3. Proceso de persistencia negociado o global con base en el paso 2
			// Primero Identifica que no exista esa tasa para esa misma fecha y parametros
			// Segundo Cierra las Tasas anteriores vigentes
			// Tercero Realiza el proceso de persistencia
			if( negociado ){
				if( euro ){
					System.out.println("EURO NEGOCIADO PROMOTOR");
					if (this.buscarEuroActualPromotor()){							
						facesMessages.addToControl("name",
							"Ya se encuentra grabada la tasa para "
									+ "esta fecha y promotor");
						return null;
					}
					
					this.cerrarTasaEuroPromotor();
					this.cerrarComisionNegociada();
					
					if( this.getPorcentCt() != null ){
						this.grabarComisionNegociada();
					}
					mensaje = this.grabarTasaEuroPromotor(); 
				}else{
					System.out.println("DOLAR NEGOCIADO PROMOTOR");
					if( this.buscarDolarActualPromotor()){
						facesMessages.addToControl("name",
								"Ya se encuentra grabada la tasa para "
										+ "esta fecha y promotor");
							return null;
					}
					
					this.cerrarTasaDolarPromotor();
					this.cerrarComisionNegociada();
					
					if( this.getPorcentCt() != null ){
						this.grabarComisionNegociada();
					}
					mensaje = this.grabarTasaDolarPromotor(); 
				}
			}else{
				if( euro ){
					
					System.out.println("EURO GENERAL");					
					if(buscarEuroActualGlobal()){
						facesMessages.addToControl("name", "Ya se encuentra grabada la tasa para " +
								"esta fecha y establecimiento");
						return null;
					}				
					this.cerrarTasaEuroGlobal();
					this.cerrarComisionGlobal();
					
					if( this.getPorcentCt() != null ){
						this.grabarComisionGlobal();
					}
					mensaje = this.grabarTasaEuroGlobal();				
				}else{
					System.out.println("DOLAR GENERAL");
					if( this.buscarDolarActualGlobal()){
						facesMessages.addToControl("name",
								"Ya se encuentra grabada la tasa para "
										+ "esta fecha y establecimiento");
							return null;
					}					
					this.cerrarTasaDolarGlobal();
					this.cerrarComisionGlobal();
					
					if( this.getPorcentCt() != null ){
						this.grabarComisionGlobal();
					}
					mensaje = this.grabarTasaDolarGlobal();
				}
			}			
			// Si es global Instancio el objeto Establecimiento precio
			if( estbto ){
				// Cierra los parametros de %, � o $ para el establecimiento
				if( this.getPorcentOfi() != null ){
					this.cerrarParametrosComercio();
					mensaje = this.grabarPrecioComercio( euro );
					System.out.println("DESPUES DE GRABAR EL PRECIO DEL ESTABLECIMIENTO");
				}
			}
			//5. Proceso de auditoria
			return mensaje;
		}
		
		
		public void validarCamposFormulario(){
			// Se implementa proceso de validacion del formulario 
			// con alerta de interfaz.
		}
		
		///////////////////////////////
		// Metodos para Grabar Tasas //
		///////////////////////////////
		
		/**
		 * Persiste Tasa EURO PROMOTOR		
		 * @return
		 */
		private String grabarTasaEuroPromotor(){
			
			System.out.println("");
			System.out.println("GRABANDO TASA EURO PROMOTOR");
			System.out.println("");
			
			this.tsEuroPromo = new Tasaeuropromotorparametro();
			this.tsEuroPromo.setPais(this.getPaisTemp());
			this.tsEuroPromo.setPromotor(this.getPromoTemp());
			this.tsEuroPromo.setEstablecimiento(this.getEstaTemp());
			this.tsEuroPromo.setFranquicia(this.getFrqTemp());
			this.tsEuroPromo.setBanco(this.getBancoTemp());
			this.tsEuroPromo.setFechainicio(this.getFechaIniTemp());
			this.tsEuroPromo.setFechafin(this.getFechaFinTemp());
			this.tsEuroPromo.setTasaeuro( this.getTasaEuroNegTemp() );		
			this.tsEuroPromo.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('tasaeuropromo_consecutivo_seq')").getSingleResult();			
			this.tsEuroPromo.setConsecutivo(conse.intValue());
			
			entityManager.persist(tsEuroPromo);			
			entityManager.flush();
			entityManager.clear();
			
			statusMessages.add("Se ha registrado tasa de dolar para el pais " + 
						this.getPaisTemp().getNombre() + " ");
			tsEuroPromo.setPais(null);
			tsEuroPromo.setPromotor(null);
			tsEuroPromo.setEstablecimiento(null);
			tsEuroPromo.setFranquicia(null);
			tsEuroPromo.setBanco(null);
			tsEuroPromo.setTipocupo(null);
			tsEuroPromo.setFechainicio(null);
			tsEuroPromo.setFechafin(null);
			tsEuroPromo.setTasaeuro(null);
			
			return "persisted";
		}
		
		/**
		 * Persiste Tasa EURO GLOBAL		
		 * @return
		 */
		private String grabarTasaEuroGlobal(){
			
			System.out.println("");
			System.out.println("GRABANDO TASA EURO GENERAL");
			System.out.println("");
			
			this.tsEuroParam = new Tasaeuroparametro();
			this.tsEuroParam.setPais(this.getPaisTemp());
			this.tsEuroParam.setEstablecimiento(this.getEstaTemp());
			this.tsEuroParam.setFranquicia(this.getFrqTemp());
			this.tsEuroParam.setBanco(this.getBancoTemp());
			this.tsEuroParam.setFechainicio(this.getFechaIniTemp());
			this.tsEuroParam.setFechafin(this.getFechaFinTemp());
			this.tsEuroParam.setTasaeuro(this.getTasaEuroTemp());
			this.tsEuroParam.setTasaeuroTac(this.getTasaEuroTacTemp());
			this.tsEuroParam.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('tasaeuroparam_consecutivo_seq')").getSingleResult();			
			this.tsEuroParam.setConsecutivo(conse.intValue());
			
			entityManager.persist(tsEuroParam);			
			entityManager.flush();
			entityManager.clear();
		
			
			statusMessages.add("Se ha registrado tasa de dolar para el pais " + 
						this.getPaisTemp().getNombre() + " ");
			tsEuroParam.setPais(null);
			tsEuroParam.setEstablecimiento(null);
			tsEuroParam.setFranquicia(null);
			tsEuroParam.setBanco(null);
			tsEuroParam.setTipocupo(null);
			tsEuroParam.setFechainicio(null);
			tsEuroParam.setFechafin(null);
			tsEuroParam.setTasaeuro(null);
			
			return "persisted";
		}
		
		/**
		 * Persiste Tasa DOLAR PROMOTOR		
		 * @return
		 */
		private String grabarTasaDolarPromotor(){	
			
			System.out.println("");
			System.out.println("GRABANDO TASA DOLAR PROMOTOR");
			System.out.println("");
			
			this.tsDolarPromo = new Tasadolarpromotorparametro();
			this.tsDolarPromo.setPais(this.getPaisTemp());
			this.tsDolarPromo.setPromotor(this.getPromoTemp());
			this.tsDolarPromo.setEstablecimiento(this.getEstaTemp());
			this.tsDolarPromo.setFranquicia(this.getFrqTemp());
			this.tsDolarPromo.setBanco(this.getBancoTemp());
			this.tsDolarPromo.setFechainicio(this.getFechaIniTemp());
			this.tsDolarPromo.setFechafin(this.getFechaFinTemp());
			this.tsDolarPromo.setTasadolar( this.getTasaDolarNegTemp());
			this.tsDolarPromo.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('tasadolarpromoparam_consecutivo_seq')").getSingleResult();			
			this.tsDolarPromo.setConsecutivo(conse.intValue());
			
			entityManager.persist(tsDolarPromo);			
			entityManager.flush();
			entityManager.clear();
			
			statusMessages.add("Se ha registrado tasa de dolar para el pais " + 
						this.getPaisTemp().getNombre() + " ");
			tsDolarPromo.setPais(null);
			tsDolarPromo.setPromotor(null);
			tsDolarPromo.setEstablecimiento(null);
			tsDolarPromo.setFranquicia(null);
			tsDolarPromo.setBanco(null);
			tsDolarPromo.setTipocupo(null);
			tsDolarPromo.setFechainicio(null);
			tsDolarPromo.setFechafin(null);
			tsDolarPromo.setTasadolar(null);
			
			return "persisted";
		}
		
		
		/**
		 * Persiste Tasa DOLAR GLOBAL		
		 * @return
		 */
		private String grabarTasaDolarGlobal(){
			
			this.tsDolarParam = new Tasadolarparametro();
			this.tsDolarParam.setPais(this.getPaisTemp());
			this.tsDolarParam.setEstablecimiento(this.getEstaTemp());
			this.tsDolarParam.setFranquicia(this.getFrqTemp());
			this.tsDolarParam.setBanco(this.getBancoTemp());
			this.tsDolarParam.setFechainicio(this.getFechaIniTemp());
			this.tsDolarParam.setFechafin(this.getFechaFinTemp());
			this.tsDolarParam.setTasadolar(this.getTasaDolarTemp());
			this.tsDolarParam.setTasadolarTac(this.getTasaDolarTacTemp());
			this.tsDolarParam.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('tasadolarparam_consecutivo_seq')").getSingleResult();			
			this.tsDolarParam.setConsecutivo(conse.intValue());
			
			entityManager.persist(tsDolarParam);			
			entityManager.flush();
			entityManager.clear();
			
			statusMessages.add("Se ha registrado tasa de dolar para el pais " + 
						this.getPaisTemp().getNombre() + " ");
			tsDolarParam.setPais(null);
			tsDolarParam.setEstablecimiento(null);
			tsDolarParam.setFranquicia(null);
			tsDolarParam.setBanco(null);
			tsDolarParam.setTipocupo(null);
			tsDolarParam.setFechainicio(null);
			tsDolarParam.setFechafin(null);
			this.tsDolarParam.setTasadolar(null);
			this.tsDolarParam.setTasadolarTac(null);
			
			return "persisted";
		}
		
		
		/**
		 * 
		 */
		private void grabarComisionNegociada(){
			System.out.println("");
			System.out.println("GRABANDO PORCENTAJE PARA EL PROMOTOR ");
			System.out.println("");
			
			this.porcentajePromo = new Porcentcomisiontxparampromo();
			this.porcentajePromo.setPais(this.getPaisTemp());
			this.porcentajePromo.setPromotor(this.getPromoTemp());
			this.porcentajePromo.setEstablecimiento(this.getEstaTemp());
			this.porcentajePromo.setFranquicia(this.getFrqTemp());
			this.porcentajePromo.setBanco(this.getBancoTemp());
			this.porcentajePromo.setFechainicio(this.getFechaIniTemp());
			this.porcentajePromo.setFechafin(this.getFechaFinTemp());
			this.porcentajePromo.setPorcentaje(this.getPorcentCt());
			this.porcentajePromo.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('porcentpromo_consecutivo_seq')").getSingleResult();			
			this.porcentajePromo.setConsecutivo(conse.intValue());
			
			entityManager.persist(porcentajePromo);			
			entityManager.flush();
			entityManager.clear();
			
			porcentajePromo.setPais(null);
			porcentajePromo.setPromotor(null);
			porcentajePromo.setEstablecimiento(null);
			porcentajePromo.setFranquicia(null);
			porcentajePromo.setBanco(null);
			porcentajePromo.setTipocupo(null);
			porcentajePromo.setFechainicio(null);
			porcentajePromo.setFechafin(null);
			porcentajePromo.setPorcentaje(null);
			
		}
		
		/**
		 *		 
		 */
		private void grabarComisionGlobal(){
			
			System.out.println("");
			System.out.println("GRABANDO PORCENTAJE GLOBAL");
			System.out.println("");
			
			this.porcentajeGlob = new Porcentajecomisiontxparam();
			this.porcentajeGlob.setPais(this.getPaisTemp());
			this.porcentajeGlob.setEstablecimiento(this.getEstaTemp());
			this.porcentajeGlob.setFranquicia(this.getFrqTemp());
			this.porcentajeGlob.setBanco(this.getBancoTemp());
			this.porcentajeGlob.setFechainicio(this.getFechaIniTemp());
			this.porcentajeGlob.setFechafin(this.getFechaFinTemp());
			this.porcentajeGlob.setPorcentaje(this.getPorcentCt());
			this.porcentajeGlob.setTipocupo(this.getTipoCupoTemp());
			//Genera el consecutivo de la tabla (id del registro)
			BigInteger conse = (BigInteger)entityManager.createNativeQuery( 
							"select nextval('porcent_consecutivo_seq')").getSingleResult();			
			this.porcentajeGlob.setConsecutivo(conse.intValue());
			
			entityManager.persist(porcentajeGlob);			
			entityManager.flush();
			entityManager.clear();
			
			porcentajeGlob.setPais(null);
			porcentajeGlob.setEstablecimiento(null);
			porcentajeGlob.setFranquicia(null);
			porcentajeGlob.setBanco(null);
			porcentajeGlob.setTipocupo(null);
			porcentajeGlob.setFechainicio(null);
			porcentajeGlob.setFechafin(null);
			porcentajeGlob.setPorcentaje(null);
		}
		
		/**
		 * Persiste los valores de liquidacion de las transaccion 
		 * para el ESTABLECIMIENTO
		 * @param moneda
		 * @return
		 */
		public String grabarPrecioComercio(Boolean moneda){
			
			System.out.println("");
			System.out.println("GRABANDO PORCENTAJE Y DOLAR DEL COMERCIO");
			System.out.println("");

			EstablecimientoprecioId idEst;
			idEst = new  EstablecimientoprecioId( 
					this.getEstaTemp().getCodigounico(), this.fechaIniTemp );
			
			//Valida que ya no este grabado los parametros 
			Establecimientoprecio est = entityManager.find(Establecimientoprecio.class, idEst);
			
			if( est == null){
				est = new Establecimientoprecio(idEst, this.getEstaTemp());
				if( moneda ){//si es euro
					est.setDolaroficina( this.getTasaEuroOfTemp());
				}else{
					est.setDolaroficina(this.getTasaDolarOfTemp());
				}
				
				est.setParidad(this.getParidadEstTemp());
				est.setParidadCliente(this.getParidadClienteTemp());
				est.setPorcentajeoficina(this.getPorcentOfi());
				
				entityManager.persist(est);			
				entityManager.flush();
				entityManager.clear();
				
				return "persisted";
			}else{
				facesMessages.addToControl("nameestable",
				"Ya estan guardados los parametros para este establecimiento para esta fecha");
				return "Ya se tiene grabada una tasa para este pais en la fecha indicada";
				
			}
		}
		
		//////////////////////////////////////////
		// Metodos para Cerrar Tasas Anteriores //
		//////////////////////////////////////////
		
		/**
		 * Cierra Tasa Euro Global
		 * 
		 */
		public void cerrarTasaEuroGlobal(){
			try {
				System.out.println("Cerrando Tasa Euro Global");
				
				Tasaeuroparametro tEuroGlobal = null;
				try{
					String queryString = 
						"select tsp from Tasaeuroparametro tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
						
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					tEuroGlobal = (Tasaeuroparametro) 
											entityManager.createQuery(queryString).getSingleResult();			
				}catch( NoResultException e ){
					//Por implementar...
				}
				
				if( tEuroGlobal != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
					tEuroGlobal.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(tEuroGlobal);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Cierra Tasa Euro Promotor
		 * 
		 */
		public void cerrarTasaEuroPromotor(){
			try {
				System.out.println("Cerrando Tasa Euro Promotor");
				
				Tasaeuropromotorparametro tEuroPromotor = null;
				try{
					String queryString = 
						"select tsp from Tasaeuropromotorparametro tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getPromoTemp() != null ){
						queryString += " and tsp.promotor.documento = '" + this.getPromoTemp().getDocumento() + "'";
					}else{
						queryString += " and tsp.promotor.documento =  null";
					}
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					tEuroPromotor = (Tasaeuropromotorparametro) 
											entityManager.createQuery(queryString).getSingleResult();				
				}catch( NoResultException e ){
					//Por implementar..
				}
				
				if( tEuroPromotor != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        tEuroPromotor.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(tEuroPromotor);
					entityManager.flush();
					entityManager.clear();
					System.out.println("EURO PORMOTOR CERRADA");
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * Cierra Tasa Dolar Global
		 * 
		 */
		public void cerrarTasaDolarGlobal(){
			try {
				System.out.println("");
				System.out.println("Cerrando Tasa Dolar Global");
				
				Tasadolarparametro tDolarGlobal = null;
				try{
					String queryString = 
						"select tsp from Tasadolarparametro tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
						
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					tDolarGlobal = (Tasadolarparametro) 
											entityManager.createQuery(queryString).getSingleResult();					
				}catch( NoResultException e ){
					//Por implementar...
				}
				
				if( tDolarGlobal != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        tDolarGlobal.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(tDolarGlobal);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * Cierra Tasa Dolar Promotor
		 * 
		 */
		public void cerrarTasaDolarPromotor(){
			try {
				System.out.println("Cerrando Tasa Dolar Promotor");
				
				Tasadolarpromotorparametro tDolarPr = null;
				try{
					String queryString = 
						"select tsp from Tasadolarpromotorparametro tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getPromoTemp() != null ){
						queryString += " and tsp.promotor.documento = '" + this.getPromoTemp().getDocumento() + "'";
					}else{
						queryString += " and tsp.promotor.documento =  null";
					}
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					tDolarPr = (Tasadolarpromotorparametro) 
											entityManager.createQuery(queryString).getSingleResult();			
				}catch( NoResultException e ){
					//Por implementar..
				}
				
				if( tDolarPr != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        tDolarPr.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(tDolarPr);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Cierra Tasa Comision Negociada
		 * 
		 */
		public void cerrarComisionNegociada(){
			try {
				System.out.println("");
				System.out.println("Cerrando Comision Negociada");
				
				Porcentcomisiontxparampromo comiPromo = null;
				try{
					String queryString = 
						"select tsp from Porcentcomisiontxparampromo tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getPromoTemp() != null ){
						queryString += " and tsp.promotor.documento = '" + this.getPromoTemp().getDocumento() + "'";
					}else{
						queryString += " and tsp.promotor.documento =  null";
					}
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					comiPromo = (Porcentcomisiontxparampromo) 
											entityManager.createQuery(queryString).getSingleResult();					
				}catch( NoResultException e ){
					//Por implementar..
				}
				
				if( comiPromo != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        comiPromo.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(comiPromo);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * Cierra Tasa Comision Global
		 * 
		 */
		public void cerrarComisionGlobal(){
			try {
				System.out.println("");
				System.out.println("Cerrando Porcentaje Global");
				
				Porcentajecomisiontxparam porcentajeGlob = null;
				try{
					
					String queryString = 
						"select tsp from Porcentajecomisiontxparam tsp where tsp.fechainicio != null and " +
						"tsp.fechainicio < current_date and tsp.fechafin is null and " +
						"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
					
					if( this.getEstaTemp() != null ){
						queryString += " and tsp.establecimiento.codigounico= '" +
											this.getEstaTemp().getCodigounico() + "'";
					}else{
						queryString += " and tsp.establecimiento.codigounico = null";
					}
					if( this.getFrqTemp() != null ){
						queryString += " and tsp.franquicia.codfranquicia = '" +
											this.getFrqTemp().getCodfranquicia() + "'";
					}else{
						queryString += " and tsp.franquicia.codfranquicia = null";
						
					}
					if( this.getBancoTemp() != null ){
						queryString += " and tsp.banco.codbanco = '" + 
											this.getBancoTemp().getCodbanco() + "'";
					}else{
						queryString += " and tsp.banco.codbanco = null";
					}
					porcentajeGlob = (Porcentajecomisiontxparam) 
											entityManager.createQuery(queryString).getSingleResult();						
				}catch( NoResultException e ){
					//Por implementar...
				}
				
				if( porcentajeGlob != null ){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        porcentajeGlob.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(porcentajeGlob);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
		 * Cierra los parametros del establecimiento (los precios de 
		 * OFICINA)
		 */
		public void cerrarParametrosComercio(){
			try {
				System.out.println("");
				System.out.println("CerrandoParametros Establecimiento");
				
				Establecimientoprecio  estPrecio = null;
				try{
					String queryString = "select est from Establecimientoprecio est where " + 
						" est.id.fechainicio = ( select max( es.id.fechainicio ) from Establecimientoprecio es) " +
						"and est.id.codigounico ='" + this.getEstaTemp().getCodigounico() +"'" ;
					estPrecio =  (Establecimientoprecio) 
									entityManager.createQuery(queryString).getSingleResult();				
				}catch( NoResultException e ){
					//Por implementar...
				}				
				if( estPrecio != null ){
					
					System.out.println( estPrecio != null );
					System.out.println("ESTABLECIMIENTO: " + 
							estPrecio.getEstablecimiento().getNombreestable());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date fin;
					
					Calendar calendar = Calendar.getInstance();
			        calendar.setTime(new Date()); 
			        calendar.add(Calendar.DAY_OF_YEAR, -1);//restamos 1 dia a la fecha actual
			        fin = sdf.parse(sdf.format( calendar.getTime()));
										
			        estPrecio.setFechafin(fin);//Establece la fecha fin
					entityManager.merge(estPrecio);
					entityManager.flush();
					entityManager.clear();
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		
		/////////////////////////////////////////////////
		// Metodos para Buscar Tasas de la misma Fecha //
		/////////////////////////////////////////////////
		
		public boolean buscarEuroActualGlobal(){	
			
			System.out.println("");
			System.out.println("Buscando Tasa Euro Global para esta fecha");
			
			Tasaeuroparametro tEuroGlobal = null;
			try{
				//HQL
				String queryString = 
					"select tsp from Tasaeuroparametro tsp where tsp.fechainicio != null and " +
					"tsp.fechainicio = '"+ this.getFechaIniTemp() +"' and tsp.fechafin is null and " +
					"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
				
				if( this.getEstaTemp() != null ){
					queryString += " and tsp.establecimiento.codigounico= '" +
										this.getEstaTemp().getCodigounico() + "'";
				}else{
					queryString += " and tsp.establecimiento.codigounico = null";
				}
				if( this.getFrqTemp() != null ){
					queryString += " and tsp.franquicia.codfranquicia = '" +
										this.getFrqTemp().getCodfranquicia() + "'";
				}else{
					queryString += " and tsp.franquicia.codfranquicia = null";
					
				}
				if( this.getBancoTemp() != null ){
					queryString += " and tsp.banco.codbanco = '" + 
										this.getBancoTemp().getCodbanco() + "'";
				}else{
					queryString += " and tsp.banco.codbanco = null";
				}
				tEuroGlobal = (Tasaeuroparametro) 
										entityManager.createQuery(queryString).getSingleResult();
						
			}catch( NoResultException e ){
				//Por implementar...
			}			
			if( tEuroGlobal != null ){
				return true;
			}
			return false;
		}
		
		
		public boolean buscarEuroActualPromotor(){		
			
			System.out.println("");
			System.out.println("Buscando Tasa Euro Promotor para esta fecha");
			
			Tasaeuropromotorparametro tEuroPromotor = null;
			try{
				String queryString = 
					"select tsp from Tasaeuropromotorparametro tsp where tsp.fechainicio != null and " +
					"tsp.fechainicio = '"+ this.getFechaIniTemp() +"' and tsp.fechafin is null and " +
					"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
				
				if( this.getPromoTemp() != null ){
					queryString += " and tsp.promotor.documento = '" + this.getPromoTemp().getDocumento() + "'";
				}else{
					queryString += " and tsp.promotor.documento =  null";
				}
				if( this.getEstaTemp() != null ){
					queryString += " and tsp.establecimiento.codigounico= '" +
										this.getEstaTemp().getCodigounico() + "'";
				}else{
					queryString += " and tsp.establecimiento.codigounico = null";
				}
				if( this.getFrqTemp() != null ){
					queryString += " and tsp.franquicia.codfranquicia = '" +
										this.getFrqTemp().getCodfranquicia() + "'";
				}else{
					queryString += " and tsp.franquicia.codfranquicia = null";
					
				}
				if( this.getBancoTemp() != null ){
					queryString += " and tsp.banco.codbanco = '" + 
										this.getBancoTemp().getCodbanco() + "'";
				}else{
					queryString += " and tsp.banco.codbanco = null";
				}
				tEuroPromotor = (Tasaeuropromotorparametro) 
										entityManager.createQuery(queryString).getSingleResult();
						
			}catch( NoResultException e ){
				//Por implementar...
			}			
			if( tEuroPromotor != null ){
				return true;
			}
			return false;
		}
		
		
		
		public boolean buscarDolarActualGlobal(){	
			
			System.out.println("");
			System.out.println("Buscando Tasa Dolar Global para esta fecha");
			
			Tasadolarparametro tDolarGlobal = null;
			try{
				//HQL
				String queryString = 
					"select tsp from Tasadolarparametro tsp where tsp.fechainicio != null and " +
					"tsp.fechainicio = '"+ this.getFechaIniTemp() +"' and tsp.fechafin is null and " +
					"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
				
				if( this.getEstaTemp() != null ){
					queryString += " and tsp.establecimiento.codigounico= '" +
										this.getEstaTemp().getCodigounico() + "'";
				}else{
					queryString += " and tsp.establecimiento.codigounico = null";
				}
				if( this.getFrqTemp() != null ){
					queryString += " and tsp.franquicia.codfranquicia = '" +
										this.getFrqTemp().getCodfranquicia() + "'";
				}else{
					queryString += " and tsp.franquicia.codfranquicia = null";
					
				}
				if( this.getBancoTemp() != null ){
					queryString += " and tsp.banco.codbanco = '" + 
										this.getBancoTemp().getCodbanco() + "'";
				}else{
					queryString += " and tsp.banco.codbanco = null";
				}
				tDolarGlobal = (Tasadolarparametro) 
										entityManager.createQuery(queryString).getSingleResult();
						
			}catch( NoResultException e ){
				//Por implementar...
			}			
			if( tDolarGlobal != null ){
				return true;
			}
			return false;
		}
		
		
		
		public boolean buscarDolarActualPromotor(){		
			
			System.out.println("");
			System.out.println("Buscando Tasa Dolar Promotor para esta fecha");
			
			Tasadolarpromotorparametro tDolarPromo = null;
			try{
				String queryString = 
					"select tsp from Tasadolarpromotorparametro tsp where tsp.fechainicio != null and " +
					"tsp.fechainicio = '"+ this.getFechaIniTemp() +"' and tsp.fechafin is null and " +
					"tsp.tipocupo = '" + this.getTipoCupoTemp() + "'";
				
				if( this.getPromoTemp() != null ){
					queryString += " and tsp.promotor.documento = '" + this.getPromoTemp().getDocumento() + "'";
				}else{
					queryString += " and tsp.promotor.documento =  null";
				}
				if( this.getEstaTemp() != null ){
					queryString += " and tsp.establecimiento.codigounico= '" +
										this.getEstaTemp().getCodigounico() + "'";
				}else{
					queryString += " and tsp.establecimiento.codigounico = null";
				}
				if( this.getFrqTemp() != null ){
					queryString += " and tsp.franquicia.codfranquicia = '" +
										this.getFrqTemp().getCodfranquicia() + "'";
				}else{
					queryString += " and tsp.franquicia.codfranquicia = null";
					
				}
				if( this.getBancoTemp() != null ){
					queryString += " and tsp.banco.codbanco = '" + 
										this.getBancoTemp().getCodbanco() + "'";
				}else{
					queryString += " and tsp.banco.codbanco = null";
				}
				tDolarPromo = (Tasadolarpromotorparametro) 
										entityManager.createQuery(queryString).getSingleResult();
						
			}catch( NoResultException e ){
				//Por implementar...
			}			
			if( tDolarPromo != null ){
				return true;
			}
			return false;
		}
	
		
	
}
