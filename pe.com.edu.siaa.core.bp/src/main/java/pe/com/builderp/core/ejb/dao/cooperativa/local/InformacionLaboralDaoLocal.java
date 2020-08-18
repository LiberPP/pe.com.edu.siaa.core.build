package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.InformacionLaboral; 
import pe.com.builderp.core.model.vo.cooperativa.InformacionLaboralDTO; 
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;

/**
 * La Class ConfiguracionAtributoDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:02:21 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface InformacionLaboralDaoLocal  extends GenericDAOLocal<String,InformacionLaboral> {
	/**
	 * Listar configuracion atributo.
	 *
	 * @param configuracionAtributo el configuracion atributoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<InformacionLaboral> listarInformacionLaboral(InformacionLaboralDTO InformacionLaboral) throws Exception;
	
	/**
	 * contar lista configuracion atributo.
	 *
	 * @param InformacionLaboral el configuracion atributo
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarInformacionLaboral(InformacionLaboralDTO InformacionLaboral);
	/**
	 * Generar id InformacionLaboral.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdInformacionLaboral() throws Exception;
	
	InformacionLaboral findByInformacionLaboralID(String idEvaluacionCredito) throws Exception;
	
	InformacionLaboral findByinformacionLaboralAvalDatos(String idAvalDatos) throws Exception;
}