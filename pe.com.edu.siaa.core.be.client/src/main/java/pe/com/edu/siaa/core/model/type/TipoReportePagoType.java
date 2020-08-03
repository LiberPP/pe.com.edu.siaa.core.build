package pe.com.edu.siaa.core.model.type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <ul>
 * <li>Copyright 2012 BUILD SOFT S.A.C - BS. Todos los derechos reservados.</li>
 * </ul>
 * 
 * La Enum TipoReportePagoType.
 *
 * @author ndavilal.
 * @version 1.0 , 09/09/2012
 * @since SIAA 2.0
 */
public enum TipoReportePagoType {

    /** La FICHA_MATRICULA_MASIVA. */
 //	FICHA_MATRICULA_MASIVA("1","Ficha matricula masiva"),
 	
	 /** REPORTE_INGRESO_DETALLADO. */
	 REPORTE_INGRESO_DETALLADO("1","Ingreso detallado"),
	 
 	/** EL REPORTE_ESTADISTICO_COMPARATIVO_MATRICULA_RANGO_SEMESTRE. */
	 //TODO:FALTA
	 //REPORTE_ESTADISTICO_COMPARATIVO_MATRICULA_RANGO_SEMESTRE("3","Reporte estadistico comparativo matricula rango semestre"),
	 
	 /** El REPORTE_RESUMEN_MATRICULA_POR_CICLO_Y_SEMESTRE. */
 	REPORTE_DE_PAGOS_BY_SEMESTRE_ALUMNO("2","Reporte de pago ordenado por semestre"),
 	
 	/** El REPORTE_PLAESTUDIO. */
 	REPORTE_INGRESO_RESUMEN_BANCO("3","Reporte ingreso resumen banco"),
 	
 	 /** El REPORTE_RESUMEN_ALUMNO_REGULAR. */
 	REPORTE_INGRESO_RESUMEN_POR_ESCUELA("4","Reporte ingreso resumen por escuela"),
 	
 	/** El REPORTE_DE_PAGOS_INGLES. */
 	REPORTE_DE_PAGOS_INGLES("5","Reporte de pago ingles"),
 	
 	/** El REPORTE_DE_PAGOS_RESUMEN_ALUMNO. */
 	REPORTE_DE_PAGOS_RESUMEN_ALUMNO("6","Reporte de pago resumen alumno"),
 	
 	/** El REPORTE_DE_PAGOS_TESIS_ASISTIDA. */
 	REPORTE_DE_PAGOS_TESIS_ASISTIDA("7","Reporte de pago tesis asistida"),
 	/** Cliente 	 */
 	/** El REPORTE_DE_PAGOS_CURSOS_TECNICOS. */
 	REPORTE_DE_PAGOS_CURSOS_TECNICOS("8","Reporte de pago cursos técnicos"),
 	
	REPORTE_DE_PAGOS_RESUMEN_CLIENTE("9","Reporte de pago resumen cliente");
	
 	
	/** La Constante LOO_KUP_MAP. */
	private static final Map<String, TipoReportePagoType> LOO_KUP_MAP = new HashMap<String, TipoReportePagoType>();	

	
	static {
		for (TipoReportePagoType s : EnumSet.allOf(TipoReportePagoType.class)) {
			LOO_KUP_MAP.put(s.getKey(), s);			
		}
	}

	/** El key. */
	private String key;
	
	/** El value. */
	private String value;

	/**
	 * Instancia un nuevo accion type.
	 *
	 * @param key el key
	 * @param value el value
	 */
	private TipoReportePagoType(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the.
	 *
	 * @param key el key
	 * @return the accion type
	 */
	public static TipoReportePagoType get(String key) {
		return LOO_KUP_MAP.get(key);
	}

	/**
	 * Obtiene key.
	 *
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Obtiene value.
	 *
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
}
