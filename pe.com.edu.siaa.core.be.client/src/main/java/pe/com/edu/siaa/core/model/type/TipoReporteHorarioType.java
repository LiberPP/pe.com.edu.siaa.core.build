package pe.com.edu.siaa.core.model.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>Copyright 2012 BUILD SOFT S.A.C - BS. Todos los derechos reservados.</li>
 * </ul>
 * 
 * La Enum TipoReporteNotaType.
 *
 * @author ndavilal.
 * @version 1.0 , 09/09/2012
 * @since SIAA 2.0
 */
public enum TipoReporteHorarioType {

    /** El RECORD_NOTA_MASIVA. */
	DOCENTE("D","Reporte Horario Docente"),	 
 	
	 /** El REPORTE_RESUMEN_NOTA_POR_CICLO_Y_SEMESTRE. */
	ALUMNO("A","Reporte Horario Alumno"),
	
	CICLO("C","Reporte Horario Ciclo");
 	
	/** La Constante LOO_KUP_MAP. */
	private static final Map<String, TipoReporteHorarioType> LOO_KUP_MAP = new HashMap<String, TipoReporteHorarioType>();
	
	
	static {
		for (TipoReporteHorarioType s : EnumSet.allOf(TipoReporteHorarioType.class)) {
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
	private TipoReporteHorarioType(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Gets the.
	 *
	 * @param key el key
	 * @return the accion type
	 */
	public static TipoReporteHorarioType get(String key) {
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
