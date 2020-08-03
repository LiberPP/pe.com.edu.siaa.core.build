package pe.com.edu.siaa.core.ejb.factory;

import java.io.Serializable;



/**
 * <ul>
 * <li>Copyright 2017 ndavilal. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class SqlMapingUtil.
 *
 * @author ndavilal
 * @version 1.0 , 07/04/2015
 * @since SIAA-CORE 2.1
 */
public class SqlMapingUtil implements Serializable {

	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Obtener sql sentencia tron200.
	 *
	 * @param nombreSQL el nombre sql
	 * @return the string
	 */
	public static String obtenerSqlSentenciaBuildERP(String nombreSQL) {
		return SqlMapingCacheUtil.getInstance().getSqlSentenciaTronBuilERPMap().get(nombreSQL.trim());
	}
	
	public static String obtenerSqlSentenciaSystem(String nombreSQL) {
		return SqlMapingCacheUtil.getInstance().getSqlSentenciaSystemMap().get(nombreSQL.trim());
	}
	

}
