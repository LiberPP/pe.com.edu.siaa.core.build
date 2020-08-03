package pe.com.builderp.core.ejb.dao.cooperativa.local;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import pe.com.builderp.core.model.jpa.cooperativa.Fraccionamiento;
import pe.com.builderp.core.model.vo.cooperativa.FraccionamientoDTO;
import pe.com.edu.siaa.core.ejb.dao.generic.local.GenericDAOLocal; 
/**
 * La Class FraccionamientoDaoLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 11:25:06 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface FraccionamientoDaoLocal  extends GenericDAOLocal<String,Fraccionamiento> {
	
	/**
	 * Generar id fraccionamiento.
	 *
	 * @param fraccionamiento el cuota concepto
	 * @return the long
	 * @throws Exception the exception
	 */
	String generarIdFraccionamiento(String idDetPlanPagos) throws Exception;
	
	/**
	 * Actualizar monto resta.
	 *
	 * @param fraccionamiento el fraccionamiento
	 * @throws Exception the exception
	 */
	void actualizarMontoResta(Fraccionamiento fraccionamiento ) throws Exception;
	
	/**
	 * Obtener lista fraccionamiento map.
	 *
	 * @param listaDetPlanPagos el lista det plan pagos
	 * @param fraccionamiento el fraccionamiento
	 * @return the map
	 * @throws Exception the exception
	 */
	Map<String,List<Fraccionamiento>> obtenerListaFraccionamientoMap(List<String> listaDetPlanPagos, boolean flagFaltaMontoResta) throws Exception;

	/**
	 * Listar fraccionamiento.
	 *
	 * @param fraccionamiento el fraccionamientoDTO
	 * @return the list
	 * @throws Exception the exception
	 */
	List<Fraccionamiento> listarFraccionamiento(FraccionamientoDTO fraccionamiento) throws Exception;
	
	/**
	 * contar lista fraccionamiento.
	 *
	 * @param fraccionamiento el fraccionamiento
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarFraccionamiento(FraccionamientoDTO fraccionamiento);
	/**
	 * Generar id fraccionamiento.
	 *
	 * @return the String
	 * @throws Exception the exception
	 */
	String generarIdFraccionamiento() throws Exception;
	
	void eliminarFraccionamiento(String idDetPlanPagos ) throws Exception;
	
	List<Fraccionamiento> listarFraccionamientoByDetPl(String idDetPlanpagos) throws Exception;
	
	BigDecimal listarSumaFraccionamientoByDetplanpagos(String idDetPlanpagos) throws Exception;
	

}