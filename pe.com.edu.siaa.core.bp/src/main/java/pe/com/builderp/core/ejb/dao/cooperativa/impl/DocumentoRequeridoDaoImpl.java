package pe.com.builderp.core.ejb.dao.cooperativa.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import pe.com.builderp.core.ejb.dao.cooperativa.local.DocumentoRequeridoDaoLocal;
import pe.com.builderp.core.model.jpa.cooperativa.DocumentoRequerido;
import pe.com.edu.siaa.core.ejb.dao.generic.impl.GenericFacturacionDAOImpl;
import pe.com.edu.siaa.core.model.util.StringUtils;

/**
 * La Class CategoriaDaoImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:55 COT 2017
 * @since SIAA-CORE 2.1
 */
@Stateless
public class DocumentoRequeridoDaoImpl extends  GenericFacturacionDAOImpl<String, DocumentoRequerido> implements DocumentoRequeridoDaoLocal  {

	/* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.DocumentoRequeridoDaoLocal#listarDocumentoRequerido(pe.com.edu.siaa.core.model.jpa.seguridad.DocumentoRequerido)
     */  
    @Override	 
    public List<DocumentoRequerido> listarDocumentoRequerido(String idPostulante) {
        Query query = generarQueryListaDocumentoRequerido(idPostulante);
        //query.setFirstResult(documentoRequerido.getStartRow());
        //query.setMaxResults(documentoRequerido.getOffset());
        return query.getResultList();
    } 
    
    @Override	 
    public List<DocumentoRequerido> listarDocumentoRequeridoVerificacionFisica(String idAvalDatos) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" select o from DocumentoRequerido o  left join fetch o.itemByDocumento left join fetch o.avalDatos where 1=1 and o.avalDatos.idAvalDatos=:idAvalDatos ");
        parametros.put("idAvalDatos", idAvalDatos);
        Query query = createQuery(jpaql.toString(), parametros); 
        return query.getResultList();
    } 
    
    @Override	 
    public boolean eliminarDocumentoRequerido(String idEvaluacionCredito) throws Exception {
    	boolean resultado = false;
    	Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" delete from DocumentoRequerido o where  o.evaluacionCredito.idEvaluacionCredito=:idEvaluacionCredito ");
        parametros.put("idEvaluacionCredito", idEvaluacionCredito);
        Query query = createQuery(jpaql.toString(), parametros);
        query.executeUpdate();
        return resultado;
    }
    
    @Override	 
    public boolean eliminarDocumentoRequeridoAvalDatos(String idAvalDatos) throws Exception {
    	boolean resultado = false;
    	Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" delete from DocumentoRequerido o where  o.avalDatos.idAvalDatos=:idAvalDatos ");
        parametros.put("idAvalDatos", idAvalDatos);
        Query query = createQuery(jpaql.toString(), parametros);
        query.executeUpdate();
        return resultado;
    }
    /**
     * Generar query lista DocumentoRequerido.
     *
     * @param DocumentoRequeridoDTO el documentoRequerido
     * @param esContador el es contador
     * @return the query
     */
    private Query generarQueryListaDocumentoRequerido(String idEvaluacionCredito) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        StringBuilder jpaql = new StringBuilder();
        jpaql.append(" select o from DocumentoRequerido o  left join fetch o.itemByDocumento left join fetch o.evaluacionCredito where 1=1 and o.evaluacionCredito.idEvaluacionCredito=:idEvaluacionCredito ");
        parametros.put("idEvaluacionCredito", idEvaluacionCredito);
        Query query = createQuery(jpaql.toString(), parametros);
        return query;
    }

  
    /* (non-Javadoc)
     * @see pe.com.edu.siaa.core.ejb.dao.seguridad.local.DocumentoRequeridoDaoLocal#generarIdDocumentoRequerido()
     */
	 @Override
    public Long generarIdDocumentoRequerido() {
        Long resultado = 1L;
        Query query = createQuery("select max(o.idDocumentoRequerido) from DocumentoRequerido o", null);
        List<Object> listLong =  query.getResultList();
        if (listLong != null && listLong.size() > 0 && listLong.get(0) != null)  {
            Long ultimoIdGenerado = Long.valueOf(listLong.get(0).toString());
            if (!StringUtils.isNullOrEmpty(ultimoIdGenerado)) {
                resultado = resultado + ultimoIdGenerado;
            }
        }
        return resultado;
    }
}