package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.ReferenciaPersonal;
import pe.com.builderp.core.model.vo.cooperativa.ReferenciaPersonalDTO;
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
public interface ReferenciaPersonalDaoLocal  extends GenericDAOLocal<String,ReferenciaPersonal> {
	/**
	 * Listar configuracion atributo.
	 *
	 * @param configuracionAtributo el configuracion atributoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ReferenciaPersonal> listarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal) throws Exception;
	
	/**
	 * contar lista configuracion atributo.
	 *
	 * @param ReferenciaPersonal el configuracion atributo
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarReferenciaPersonal(ReferenciaPersonalDTO referenciaPersonal);
	/**
	 * Generar id ReferenciaPersonal.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdReferenciaPersonal() throws Exception;
}