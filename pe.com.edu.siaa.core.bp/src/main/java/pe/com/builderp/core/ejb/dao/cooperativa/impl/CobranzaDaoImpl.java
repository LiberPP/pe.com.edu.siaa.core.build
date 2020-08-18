package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.ibm.icu.text.DecimalFormat;

import pe.com.builderp.core.ejb.dao.cooperativa.local.CobranzaDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.Cobranza;
import pe.com.builderp.core.model.vo.cooperativa.CobranzaDTO;
import pe.com.builderp.core.model.vo.cooperativa.IngresoVoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericAcademicoDAOImpl; 
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.log.Logger; 
import pe.com.edu.siaa.core.model.util.StringUtils;
import pe.com.edu.siaa.core.model.vo.PagoFiltroVO;

/**
 * La Class CobranzaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 19:53:43 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class CobranzaDaoImpl extends  GenericAcademicoDAOImpl<String, Cobranza> implements CobranzaDaoLocal  {

	private Logger log = Logger.getLogger(CobranzaDaoImpl.class);
	
	@Override
	public String generarNumeroOperacion(Integer anho) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		String resultado = "0000000001";
		parametros.put("anho", anho);
		Query query = createQuery("select max(cc.nroCorrelativoOperacion) from Cobranza cc where YEAR(cc.fechaCreacion) =:anho",parametros);
		query.setParameter("anho", anho);
		List<String> listLong =  query.getResultList();
		if (listLong != null && listLong.size() > 0) {
			String ultimoIdGenerado = listLong.get(0);
			if (StringUtils.isNotNullOrBlank(ultimoIdGenerado)) {
				long ultimoId = Long.parseLong(ultimoIdGenerado.trim());
				ultimoId++;
				resultado = "" + ultimoId;
			}
		}
		resultado = StringUtils.completeLeft(resultado, '0', 10);
		return resultado;
	}
	//ID GENERADO:200510000001
	@Override
	public String generarIdCobranza(String idAnhoSemestre) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
			String resultado = idAnhoSemestre + "0000001";
			parametros.put("idAnhoSemestre", idAnhoSemestre);
			Query query = createQuery("select max(cc.idCobranza) from Cobranza cc where cc.anhoSemestre.idAnhoSemestre=:idAnhoSemestre",parametros);
			query.setParameter("idAnhoSemestre", idAnhoSemestre);
			List<String> listLong =  query.getResultList();
			if (listLong != null && listLong.size() > 0) {
				String ultimoIdGenerado = listLong.get(0);
				if (StringUtils.isNotNullOrBlank(ultimoIdGenerado)) {
					long ultimoId = Long.parseLong(ultimoIdGenerado.trim());
					ultimoId++;
					resultado = "" + ultimoId;
				}
			}
			return resultado;
		}
		
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.CobranzaDaoLocal#listarCobranza(pe.com.edu.siaa.core.model.jpa.seguridad.Cobranza)
     */  
    @Override	 
    public List<Cobranza> listarCobranza(CobranzaDTO cobranza) throws ParseException {
        Query query = generarQueryListaCobranza(cobranza, false);
        query.setFirstResult(cobranza.getStartRow());
        query.setMaxResults(cobranza.getOffset());
        return query.getResultList();
    }   
   
    /**
     * Generar query lista cobranza.
     *
     * @param CobranzaDTO el Cobranza
     * @param esContador el es contador
     * @return the query
     * @throws ParseException 
     */
    private Query generarQueryListaCobranza(CobranzaDTO cobranza, boolean esContador) throws ParseException {

        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        if (esContador) {
            jpaql.append(" select count(o.idCobranza) from Cobranza o where 1=1 ");
        } else {
            jpaql.append(" select o from Cobranza o  ");
            jpaql.append(" left join fetch o.itemByTipoMoneda  ");
            jpaql.append(" left join fetch o.cliente where 1=1 ");         
        }
       /*jpaql.append(" and o.alumno.idAlumno = :idAlumno ");
        parametros.put("idAlumno", cobranza.getId());*/
        
        jpaql.append(" and o.cliente.idCliente = :idCliente ");
        parametros.put("idCliente", cobranza.getId());
		 if (!StringUtils.isNullOrEmpty(cobranza.getListidEgresados())) {
		        jpaql.append(" and o.idCobranza in(:listaIdPlanPagos) ");
		        parametros.put("listaIdPlanPagos", cobranza.getListidEgresados());
		 }
        
       /*if (!StringUtils.isNullOrEmpty(cobranza.getId())) {
            jpaql.append(" and to_char(fechaPago,'dd/MM/yyyy')=:fechaPa ");
            try {
				parametros.put("fechaPa", FechaUtil.obtenerFechaFormatoPersonalizado(cobranza.getId().toString(), "dd/MM/yyyy") );
			} catch (ParseException e) { 
				e.printStackTrace();
			}
        }*/
	        
        
       if (!StringUtils.isNullOrEmpty(cobranza.getIdFiltro1() )) {
           jpaql.append(" and to_char(o.fechaCreacion,'dd/MM/yyyy') =:fechaCreacion ");
           parametros.put("fechaCreacion",FechaUtil.obtenerFechaFormatoPersonalizado(FechaUtil.obtenerFecha(),"dd/MM/yyyy"));
       }
       
       if (!StringUtils.isNullOrEmpty(cobranza.getIdPadreView())) {
            jpaql.append(" and o.cliente.idCliente =:idFiltro2 ");
            parametros.put("idFiltro2",cobranza.getIdPadreView());
        }

   
		if (!StringUtils.isNullOrEmpty(cobranza.getSearch())) {
	          jpaql.append(" and upper(o.nroDoc) like :search or o.idCobranza in (select detc.cobranza.idCobranza from DetCobranza detc where detc.cobranza.idCobranza in( select cot from Cobranza cot where cot.alumno.idAlumno = :idAlumno) and  upper(detc.descripcionConcepto) like :search )  ");
	          parametros.put("idAlumno", cobranza.getId());
	          parametros.put("search", "%" + cobranza.getSearch().toUpperCase() + "%");
	    }else {
	    	if (!StringUtils.isNullOrEmpty(cobranza.getIdCobranza())) {
				jpaql.append(" and o.idCobranza = :idCobranza ");
				parametros.put("idCobranza", cobranza.getIdCobranza());
			}
			if (!StringUtils.isNullOrEmptyNumeric(cobranza.getTipoCambio())) {
				jpaql.append(" and o.tipoCambio = :tipoCambio ");
				parametros.put("tipoCambio", cobranza.getTipoCambio());
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getNroDoc())) {
				jpaql.append(" and upper(o.nroDoc) like :nroDoc ");
				parametros.put("nroDoc", "%" + cobranza.getNroDoc().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmptyNumeric(cobranza.getSubMontoTotal())) {
				jpaql.append(" and o.subMontoTotal = :subMontoTotal ");
				parametros.put("subMontoTotal", cobranza.getSubMontoTotal());
			}
			if (!StringUtils.isNullOrEmptyNumeric(cobranza.getMontoTotal())) {
				jpaql.append(" and o.montoTotal = :montoTotal ");
				parametros.put("montoTotal", cobranza.getMontoTotal());
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getFechaPago())) {
				jpaql.append(" and o.fechaPago = :fechaPago ");
				parametros.put("fechaPago", cobranza.getFechaPago());
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getFechaCreacion())) {
				jpaql.append(" and o.fechaCreacion = :fechaCreacion ");
				parametros.put("fechaCreacion", cobranza.getFechaCreacion());
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getUsuarioCreacion())) {
				jpaql.append(" and upper(o.usuarioCreacion) like :usuarioCreacion ");
				parametros.put("usuarioCreacion", "%" + cobranza.getUsuarioCreacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getFechaModificacion())) {
				jpaql.append(" and o.fechaModificacion = :fechaModificacion ");
				parametros.put("fechaModificacion", cobranza.getFechaModificacion());
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getUsuarioModificacion())) {
				jpaql.append(" and upper(o.usuarioModificacion) like :usuarioModificacion ");
				parametros.put("usuarioModificacion", "%" + cobranza.getUsuarioModificacion().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getEstado())) {
				jpaql.append(" and upper(o.estado) like :estado ");
				parametros.put("estado", "%" + cobranza.getEstado().toUpperCase() + "%");
			}
			if (!StringUtils.isNullOrEmpty(cobranza.getIp())) {
				jpaql.append(" and upper(o.ip) like :ip ");
				parametros.put("ip", "%" + cobranza.getIp().toUpperCase() + "%");
			}
		}
        if (!esContador) {
            jpaql.append(" ORDER BY o.fechaPago,o.fechaCreacion asc ");
        }
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.CobranzaDaoLocal#contarListar{entity.getClassName()}(pe.com.edu.siaa.core.model.jpa.seguridad.CobranzaDTO)
     */
	@Override
    public int contarListarCobranza(CobranzaDTO Cobranza) {
        int resultado = 0;
        try {
            //StringBuilder jpaql = new StringBuilder();
            Query query = generarQueryListaCobranza(Cobranza, true);
            resultado = ((Long) query.getSingleResult()).intValue();
        } catch (Exception e) {
            resultado = 0;
        }
        return resultado;
    }
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.CobranzaDaoLocal#generarIdCobranza()
     */
	 @Override
    public String generarIdCobranza() throws Exception {
	        String resultado = FechaUtil.obtenerFechaFormatoPersonalizado(FechaUtil.obtenerFecha(), "yyyy") + "0000001";
	        Query query = createQuery("select max(o.idCobranza) from Cobranza o", null);
			List<String> listLong =  query.getResultList();
			if (listLong != null && listLong.size() > 0) {
				String ultimoIdGenerado = listLong.get(0);
				if (StringUtils.isNotNullOrBlank(ultimoIdGenerado)) {
					long ultimoId = Long.parseLong(ultimoIdGenerado.trim());
					ultimoId++;
					resultado = "" + ultimoId;
				}
			}
			return resultado;
    }
   
	 
		 
			
			//add ojo
			
			/**
			    * Parsear datos registro nota dto.
			    *
			    * @param listaObject el lista object
			    * @return the list
			    */
		   private List<PagoFiltroVO> parsearDatosIgresoDetalladoDTO(List<Object[]>   listaObject) {
		 	  List<PagoFiltroVO> resultado = new  ArrayList<PagoFiltroVO>();
		 	  try {
		 		  if (listaObject != null) {
		 				for (Object[] res : listaObject) {
		 					PagoFiltroVO detallePagoDTO  = new PagoFiltroVO();	 	
		 					if(res[0] != null) {
			 					detallePagoDTO.setFechaPago((String)res[0]);
		 					}
		 					if(res[1] != null) {
			 					detallePagoDTO.setTipoComprobante((String)res[1]);
		 					}
		 					if(res[2] != null) {
			 					detallePagoDTO.setSerie((String)res[2]);
		 					}
		 					if(res[3] != null) {
			 					detallePagoDTO.setNroComprobante((String)res[3]);	
		 					}
		 					if(res[4] != null) {
			 					detallePagoDTO.setClienteNombre((String)res[4]);
		 					}
		 					if(res[5] != null) {
			 					detallePagoDTO.setTipoDoc((String)res[5]);
		 					}
		 					if(res[6] != null) {
			 					detallePagoDTO.setNroDoc((String)res[6]);
		 					}
		 					if(StringUtils.isNotNullOrBlank(res[7])) {
			 					detallePagoDTO.setMoneda((String)res[7]);
		 					}
		 					if(StringUtils.isNotNullOrBlank(res[8])) {
			 					detallePagoDTO.setCondicion((String)res[8]);
		 					}
		 					if(res[9] != null) {
			 					detallePagoDTO.setNroCuenta((String)res[9]);
		 					}
		 					if(res[10] != null) {
			 					detallePagoDTO.setCuentaContableTotal((Integer)res[10]);
		 					}
		 					if(res[11] != null) {
			 					detallePagoDTO.setMedioPago((String)res[11]);
		 					}
		 					if(res[12] != null) {
			 					detallePagoDTO.setConcepto((String)res[12]);
		 					}
		 					if(res[13] != null) {
		 						double doble = Double.parseDouble(res[13].toString());
		 						BigDecimal formatNumber = new BigDecimal(doble);
		 						DecimalFormat formatea = new DecimalFormat("###,###.00");
		 						formatNumber = formatNumber.setScale(2, RoundingMode.DOWN);
		 	 					detallePagoDTO.setEfectivo(formatea.format(formatNumber));		 	 					
		 					}
		 					
		 					resultado.add(detallePagoDTO);
		 				}
		 			}
		 	  } catch (Exception e) {
		 			log.error(e);
		 		}
		 	  
		 	  System.out.println("pasear" + resultado.size());
		 	  return resultado;
		   }	
		   
		 
		
			
			//agregado	
			private StringBuilder generarQueryIngresoDetallado()  {		
				StringBuilder jpaql = new StringBuilder();		
				jpaql.append(" SELECT  to_char(cobranza.fechaPago,'dd/MM/yyyy') as FechaPago, case when docSunat.idITem = 686 then '01' when docSunat.idITem = 688 then '03' end as TipoComprobante,cobranza.serie as Serie,cobranza.nrodoc as NroBoleta,case when  Cliente.nombre is null then  (Persona.apellidoPaterno || ' ' || Persona.apellidoMaterno || ' ' || Persona.nombre) else Cliente.nombre end as Cliente, ");
				jpaql.append("case when  Cliente.idtipodocumentoidentidad is null  then (case when Persona.idtipodocidentidad = 20 then '1' when Persona.idtipodocidentidad = 21 then '4' when Persona.idtipodocidentidad = 22 then '7' when Persona.idtipodocidentidad = 911 then '6'end ) else (case when Cliente.idtipodocumentoidentidad = 20 then '1' when Cliente.idtipodocumentoidentidad = 21 then '4' when Cliente.idtipodocumentoidentidad = 22 then '7' when Cliente.idtipodocumentoidentidad = 911 then '6'end ) end as TipoDoc, "); 	
				jpaql.append("case when  Cliente.nroDoc is null then Persona.nrodoc else Cliente.nroDoc end as nroDoc, Cast('S' as varchar) as Moneda,Cast('CON' as varchar) as Condicion, CatalogoCuenta.nroCuenta as NroCuenta, 1212 as CuentaContableTotal, case when cobranza.deposito = 'S' then '001' when cobranza.deposito = 'N' then '009' when cobranza.deposito is null then '009' end as MedioPago, Detcobranza.descripcionConcepto as Concepto,case  when cobranza.descuento = 0.00 then Detcobranza.monto when cobranza.descuento > 0.00 then CAST((Detcobranza.monto-(Detcobranza.monto*cobranza.descuento/100))AS DECIMAL(6,2)) end as Efectivo"); 		
				jpaql.append(" from dbo.Cobranza Cobranza LEFT JOIN ");
				jpaql.append("dbo.Alumno Alumno on cobranza.idAlumno = Alumno.idAlumno LEFT JOIN ");
				jpaql.append("dbo.Postulante Postulante on  Alumno.idPostulante = Postulante.idPostulante LEFT JOIN ");
				jpaql.append("dbo.Persona Persona on Postulante.idPersona = Persona.idPersona LEFT JOIN ");
				
				jpaql.append("factu.Cliente Cliente on cobranza.idCliente = Cliente.idCliente INNER JOIN ");
				jpaql.append("commo.item docSunat on  cobranza.idtipodocsunat = docSunat.iditem LEFT JOIN ");
				
				jpaql.append("dbo.DetCobranza DetCobranza ON  cobranza.idCobranza = Detcobranza.idCobranza LEFT JOIN ");
				jpaql.append("dbo.CuotaConcepto on Detcobranza.idCuotaConcepto = CuotaConcepto.idCuotaConcepto LEFT JOIN ");
				jpaql.append("dbo.CatalogoCuenta on CuotaConcepto.idCatalogoCuenta = CatalogoCuenta.idCatalogoCuenta ");
				jpaql.append("where cobranza.fechaPago  BETWEEN :fechaInicio  AND :fechaFin  ");	
				
				jpaql.append(" order by cobranza.fechaPago asc ");		
				return jpaql;
			}
			
			@Override
			public Cobranza findAlumnoByCobranza(String idDetCobranza) throws Exception {
				Cobranza resultado = null;
				StringBuilder jpaql = new StringBuilder();
				jpaql.append("from Cobranza o  left join fetch o.tipoDocSunat "); 
				jpaql.append(" left join fetch o.cliente");
				jpaql.append(" where o.idCobranza =:idDetCobranza");
				Query query = createQuery(jpaql.toString(),null);
				query.setParameter("idDetCobranza", idDetCobranza); 
				List<Cobranza> listaAlumno = query.getResultList();
				if (listaAlumno != null && listaAlumno.size() > 0) {
					resultado = listaAlumno.get(0);
				}
				return resultado;	
			}
		

		@Override
	    public BigDecimal contarMontoTotalCobranza(String userName,Date fecha) {
			int valor =0;
	        BigDecimal resultado = BigDecimal.ZERO;
	        try {
	            Map<String, Object> parametros = new HashMap<String, Object>();
	            StringBuilder jpaql = new StringBuilder();
	            jpaql.append(" select sum(montototal) from cooperativa.cobranza where 1=1");
				if (!StringUtils.isNullOrEmptyNumeric(userName)) {
					jpaql.append(" and usuariocreacion = :userName ");
					parametros.put("userName", userName);
				}
				if (!StringUtils.isNullOrEmptyNumeric(fecha)) {
					jpaql.append(" and to_char(fechapago,'dd/MM/yyyy') = :fecha ");
					parametros.put("fecha", FechaUtil.obtenerFechaFormatoPersonalizado(fecha, "dd/MM/yyyy"));
				}
	            Query query = createNativeQuery(jpaql.toString(), parametros);
	            valor = ((Long) query.getSingleResult()).intValue();
	            resultado=new BigDecimal(valor);
	        } catch (Exception e) {
	            resultado = BigDecimal.ZERO;
	        }
	        return resultado;
	    }
		
		
	@Override
	public List<IngresoVoDTO> listarIngresos(IngresoVoDTO filtro) throws Exception {
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<IngresoVoDTO> resultado = new ArrayList<IngresoVoDTO>();
		StringBuilder jpaql = new StringBuilder();
		jpaql.append("select case  when cliente.nombre is null then '' else cliente.nombre end ,case when cliente.apellidoPaterno is null then '' else cliente.apellidoPaterno end ,case when cliente.apellidoMaterno is null then '' else cliente.apellidoMaterno end, descripcionconcepto,cobranza.montototal,to_char(cobranza.fechapago,'dd/MM/yyyy') ");
		jpaql.append(" from cooperativa.detcobranza");
		jpaql.append(" inner join cooperativa.cobranza ON detcobranza.idcobranza=cobranza.idcobranza");
		jpaql.append(" inner join factu.cliente ON cobranza.idcliente=cliente.idcliente");
		jpaql.append(" where 1=1 ");
		if(!StringUtils.isNullOrEmpty(filtro.getFechaPago())) {
	          jpaql.append(" and to_char(cobranza.fechapago,'dd/MM/yyyy') =:formaP1");
	          parametros.put("formaP1", filtro.getFechaPago());
		}
		if(!StringUtils.isNullOrEmpty(filtro.getIdUsuarioLogin())) {
	          jpaql.append(" and cobranza.usuariocreacion =:user1");
	          parametros.put("user1",  filtro.getIdUsuarioLogin());
		}
		jpaql.append(" group by cliente.nombre,cliente.apellidoPaterno,cliente.apellidoMaterno, descripcionconcepto,cobranza.montototal,to_char(cobranza.fechapago,'dd/MM/yyyy')  ");
		jpaql.append(" UNION ALL ");
		jpaql.append(" select cliente.nombre,cliente.apellidoPaterno,cliente.apellidoMaterno,descripcionproducto,detalleventa.montototal,to_char(venta.fechaventa,'dd/MM/yyyy') ");
		jpaql.append(" from factu.detalleventa");
		jpaql.append(" inner join factu.venta ON detalleventa.idventa=venta.idventa ");
		jpaql.append(" inner join factu.cliente ON venta.idcliente=cliente.idcliente ");
		jpaql.append(" where 1=1 "); 
		if(!StringUtils.isNullOrEmpty(filtro.getFechaPago())) {	
	          jpaql.append(" and to_char(venta.fechaventa,'dd/MM/yyyy') =:formaP");
	          parametros.put("formaP",  filtro.getFechaPago());
		}
		if(!StringUtils.isNullOrEmpty(filtro.getIdUsuarioLogin())) {
	          jpaql.append(" and venta.usuariocreacion =:user");
	          parametros.put("user", filtro.getIdUsuarioLogin());
		}
		jpaql.append(" group by cliente.nombre,cliente.apellidoPaterno,cliente.apellidoMaterno,descripcionproducto,detalleventa.montototal,to_char(venta.fechaventa,'dd/MM/yyyy')"); 
		jpaql.append(" UNION ALL ");
		jpaql.append(" select 'demmo','demmo','demmo',descripcion,montoingreso,to_char(fechaingreso,'dd/MM/yyyy') ");
		jpaql.append(" from cooperativa.ingreso"); 
		jpaql.append(" where 1=1 "); 
		if(!StringUtils.isNullOrEmpty(filtro.getFechaPago())) {	
	          jpaql.append(" and to_char(fechacreacion,'dd/MM/yyyy') =:formaP");
	          parametros.put("formaP",  filtro.getFechaPago());
		}
		if(!StringUtils.isNullOrEmpty(filtro.getIdUsuarioLogin())) {
	          jpaql.append(" and usuariocreacion =:user");
	          parametros.put("user", filtro.getIdUsuarioLogin());
		}
		jpaql.append(" group by descripcion,montoingreso,to_char(fechaingreso,'dd/MM/yyyy')"); 
		
		
		Query query = createNativeQuery(jpaql.toString(),parametros);
		List<Object[]> lisObject = query.getResultList();
		for (Object[] objects : lisObject) {
			IngresoVoDTO filtroTemp = new  IngresoVoDTO(); 
			if(StringUtils.isNullOrEmpty((String)objects[0])) {
				objects[0]="";
			}else if(StringUtils.isNullOrEmpty((String)objects[1])) {
				objects[1]="";
			}else if(StringUtils.isNullOrEmpty((String)objects[2])) {
				objects[2]="";
			}
			filtroTemp.setCliente((String)objects[0]+" "+(String)objects[1]+" "+(String)objects[2]);
			filtroTemp.setDescripcionConcepto((String)objects[3]);
			filtroTemp.setMonto((BigDecimal)objects[4]);
			filtroTemp.setFechaPago((String)objects[5]); 
			resultado.add(filtroTemp);
		}
		return resultado;
	}
}