package pe.com.edu.siaa.core.ejb.dao.reporte.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal;
import pe.com.edu.siaa.core.model.dto.reporte.ParametrosScriptSqlDTO;
import pe.com.edu.siaa.core.model.jpa.reporte.ParametrosScriptSql;

/**
 * La Class ParametrosScriptSqlDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:21 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface ParametrosScriptSqlDaoLocal  extends GenericDAOLocal<String,ParametrosScriptSql> {
	/**
	 * Listar parametros script sql.
	 *
	 * @param parametrosScriptSql el parametros script sqlDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ParametrosScriptSql> listarParametrosScriptSql(ParametrosScriptSqlDTO parametrosScriptSql) throws Exception;
	
	/**
	 * contar lista parametros script sql.
	 *
	 * @param parametrosScriptSql el parametros script sql
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarParametrosScriptSql(ParametrosScriptSqlDTO parametrosScriptSql);
	/**
	 * Generar id parametrosScriptSql.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdParametrosScriptSql() throws Exception;
}