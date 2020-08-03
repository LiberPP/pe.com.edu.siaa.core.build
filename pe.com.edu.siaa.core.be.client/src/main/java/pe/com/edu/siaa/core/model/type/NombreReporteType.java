package pe.com.edu.siaa.core.model.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
* La Enum NombreReporteType.
* <ul>
* <li>Copyright 2017 ndavilal -
* MAPFRE. Todos los derechos reservados.</li>
* </ul>
*
* @author ndavilal
* @version 1.0, Thu Jul 31 10:21:30 COT 2017
* @since SIAA-CORE 2.1
*/
public enum NombreReporteType {

	 /** El JR_REP_FICHA_MATRICULA_INDIVIDUAL. */
	JR_REP_FICHA_MATRICULA_INDIVIDUAL("jrFichaMatriculaIndividual.jasper","FichaMatriculaIndividual","jrFichaMatriculaIndividual",""),
	
	/** El JR_REP_RECORD_NOTA_INDIVIDUAL. */
 	JR_REP_RECORD_NOTA_INDIVIDUAL("jrRecordNotaIndividual.jasper","RecordNotaIndividual","jrRecordNotaIndividual",""),
 	
	/** El JR_REP_REPORTE_NOTA_ORDENADO_BY_SEMESTRE. */
 	JR_REP_REPORTE_NOTA_ORDENADO_BY_SEMESTRE("jrReporteNotaOrdenadoBySemestre.jasper","ReporteNotaOrdenadoBySemestre","jrReporteNotaOrdenadoBySemestre",""),
 	
 	/** El JR_REP_REPORTE_NOTA_ORDENADO_BY_CICLO. */
 	JR_REP_REPORTE_NOTA_ORDENADO_BY_CICLO("jrReporteNotaOrdenadoByCiclo.jasper","ReporteNotaOrdenadoByCiclo","jrReporteNotaOrdenadoByCiclo",""),
 	
 	/** El JR_REP_REPORTE_CETIFICADO_ESTUDIO_BY_RANGO_CICLO. */
 	JR_REP_REPORTE_CETIFICADO_ESTUDIO_BY_RANGO_CICLO("jrRepCertificadoEstudio.jasper","ReporteCertificadoByRangoCiclo","jrReporteCertificadoByRangoCiclo",""),
 	
 	//agregando
 	 	/** El JR_REP_MATRICULA_ESTADISTICO. */
 	 	JR_REP_MATRICULA_ESTADISTICO_RANGO_SEMESTRE("jrRepMatriculaEstadistico.jasper","RepMatriculaEstadistico","jrRepMatriculaEstadistico",""),
 	 	
 	 	/** El JR_REP_RESUMEN_MATRICULA_POR_CICLO_Y_SEMESTRE. */
 		JR_REP_RESUMEN_MATRICULA_POR_CICLO_Y_SEMESTRE("jrResumenMatricula.jasper","ResumenMatriculaPorCicloYSemstre","jrResumenMatricula",""),
 		
 		/** El JR_REP_PLAN_ESTUDIO. */
 		JR_REP_PLANESTUDIO("jrRepPlanEstudio.jasper","ReportePlanEstudio","jrRepPlanEstudio",""),
 		//Alumno estadistica regular iregular
 		/** El JR_REP_ALUMNO_REGULAR. */
 	 	JR_REP_ALUMNO_REGULAR("jrRepAlumRegular.jasper","CuadroEstadisticoMatricula","jrCuadroEstadisticoMatricula",""),	
 	 	
 	 	/** El JR_REP_ALUMNO_REGULAR. */
 	 	JR_REP_ALUMNO_IREGULAR("jrRepAlumIregular.jasper","CuadroEstadisticoMatricula","jrCuadroEstadisticoMatricula",""),
 	 	
 	 	/** El JR_REP_ALUMNO_REGULAR. */
 	 	JR_REP_ALUMNO_MATRICULA_GENERO("jrRepAlumMatGenero.jasper","CuadroEstadisticoMatricula","jrCuadroEstadisticoMatricula",""),
 	 	
 //reporte pago ingreso
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_INGRESO_DETALLADO("jrRepIngresoDetallado.jasper","RepDetallePagos","jrRepDetallePagos",""),
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO.*/
 	JR_REP_PAGOS_BY_SEMESTRE_ALUM("jrRepPagoBySemestreAlum.jasper","RepPagoBySemestreAlum","jrRepPagoBySemestreAlum",""),
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_INGRESO_RESUMEN_BY_BANCO("jrRepIngresoResumenByBanco.jasper","RepIngresoResumenByBanco","jrRepDetallePagos",""),

 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_INGRESO_RESUMEN_BY_ESCUELA("jrRepIngresoResumeByEscuela.jasper","RepIngresoResumeByEscuela","jrRepDetallePagos",""),
 	
 	/** agregado reporte alumno	 */ 	
 	/**JR_REP_PAGOS_INGLES.*/
 	JR_REP_PAGOS_INGLES("jrRepPagoIngles.jasper","RepPagoIngles","jrRepPagoIngles",""),
 	
 	/**JR_REP_PAGO_RESUMEN_ALUM.*/
 	JR_REP_PAGOS_RESUMEN_ALUM("jrRepPagoResumenAlum.jasper","RepPagoResumenAlum","jrRepPagoResumenAlum",""),
 	
 	/**JR_REP_PAGO_TESIS_ASISTIDA.*/
 	JR_REP_PAGOS_TESIS_ASISTIDA("jrRepPagoTesisAsistida.jasper","RepPagoTesisAsistida","jrRepPagoTesisAsistida",""),
 	
 	/** Cliente  */
 	/**JR_REP_PAGO_TESIS_ASISTIDA.*/
 	JR_REP_PAGOS_CURSOS_TECNICOS("jrRepPagoCursosTecnicos.jasper","RepPagoCursosTecnicos","jrRepPagoCursosTecnicos",""),
 	
 	JR_REP_PAGOS_RESUMEN_CLIENTE("jrRepPagoResumenCliente.jasper","RepPagoResumenCliente","jrRepPagoResumenCliente",""),

 	
 	/** El JR_REP_REPORTE_ACTA_EVALUACION_FINAL. */
 	JR_REP_REPORTE_ACTA_EVALUACION_FINAL("jrRepActaEvaluacionFinal.jasper","ReporteActaEvaluacionFinal","jrReporteActaEvaluacionFinal",""),
 	
 	//add
	/** El JR_REP_REPORTE_ACTA_EVALUACION_FINAL_FORMATO. */
 	JR_REP_REPORTE_ACTA_EVALUACION_FINAL_FORMATO("jrRepActaEvaluacionFinalFormato.jasper","ReporteActaEvaluacionFinal","jrReporteActaEvaluacionFinalFormato",""),
 	
	//para formato de asistencia
 	/** El JR_REP_REPORTE_FORMATO_UNICO_ASISTENCIA. */
 	JR_REP_REPORTE_FORMATO_UNICO_ASISTENCIA("jrRepFormatoUnicoAsistencia.jasper","ReporteActaEvaluacionFinal","jrReporteFormatoUnicoAsistencia",""),
 	 	
 	//para reporte de matriculados por curso
 	/** EL JR_REP_REPORTE_MATRICULADOS_POR_CURSO. */
 	JR_REP_REPORTE_MATRICULADOS_POR_CURSO("jrRepReproteMatriculadosPorCurso.jasper","ReporteActaEvaluacionFinal","jrRepReproteMatriculadosPorCurso",""),
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_PAGOS_POR_CURSO("jrReportePagoPorCurso.jasper","ReportePagoPorCurso","jrReportePagoPorCurso",""),
 	
 	/**JR_REP_PAGOS_POR_CICLO. */
 	JR_REP_PAGOS_POR_CICLO("jrReportePagoPorCiclo.jasper","ReportePagoPorCiclo","jrReportePagoPorCiclo",""),
 	
 	/** El JR_REP_RECORD_NOTA_MASIVO. */
 	JR_REP_RECORD_NOTA_MASIVO("jrRecordNotaMasivo.jasper","RecordNotaMasivo","jrRecordNotaMasivo",""),
 	
 	/** El JR_REP_RESUMEN_NOTA_BY_SEMESTRE. */
 	JR_REP_RESUMEN_NOTA_BY_SEMESTRE("jrResumenPorEscuelaCurso.jasper","ResumenPorEscuelaCurso","jrResumenPorEscuelaCurso",""),
 	
 	/** El JR_REP_BOLETA_PAGOS_REALIZADOS_ALUMNO. */
 	JR_REP_BOLETA_PAGOS_REALIZADOS_ALUMNO("jrReportePagoIndividual.jasper","ReportePagoIndividual","jrReportePagoIndividual",""),
 	
 	/** El JR_REP_BOLETA_PAGOS_REALIZADOS_CLIENTE. */
 	JR_REP_BOLETA_PAGOS_REALIZADOS_CLIENTE("jrReportePagoIndividualCliente.jasper","ReportePagoIndividualCliente","jrReportePagoIndividualCliente",""),
 	
 	//add
 	/** El JR_REP_BOLETA_VENTA. */
 	JR_REP_BOLETA_VENTA("jrReporteVentaIndividual.jasper","ReporteVentaIndividual","jrReporteVentaIndividual",""),
 	
 	/** El JR_REP_REPORTE_PRODUCTO_CODIGO_BARRA. */
 	JR_REP_REPORTE_PRODUCTO_CODIGO_BARRA("jrReporteCodigoBarraProducto.jasper","ReporteCodigoBarraProducto","jrReporteCodigoBarraProducto",""),
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_CONVENIO_ALUMNO("jrReporteConvenioAlumno.jasper","ReporteConvenioAlumno","jrReporteConvenioAlumno",""),
 	
 	/**JR_REP_REPORTE_DET_MOVIMIENTO. */
 	JR_REP_CONVENIO_PERSONAL("jrReporteConvenioPersonal.jasper","ReporteConvenioPersonal","jrReporteConvenioPersonal",""), 
 	//add
 	/**JR_REP_CONVENIO. */
 	JR_REP_CONVENIO("jrReporteConvenio.jasper","ReporteConvenio","jrReporteConvenio",""),
 	//constancia de registro GyT
 	/** El JR_REP_REPORTE_ACTA_EVALUACION_FINAL. */
 	JR_REP_REPORTE_GRADO_TITULO("jrReporteCuotasPrestamo.jasper","ReporteCuotaPrestamo","jrReporteCuotasPrestamo",""),
 	
 	JR_REP_REPORTE_GRADO_TITULO_DIPLOMA("jrRepGradoTituloDiploma.jasper","ReporteGradoTituloDiploma","jrReporteGradoTitulodDiploma",""),
 	
 	//constancia de registro GyT
 	/** El JR_REP_REPORTE_ACTA_EVALUACION_FINAL. */
 	JR_REP_REPORTE_EGRESADO_FORMULARIO("jrReporteEgresadoFormulario.jasper","ReporteFormularioEgresado","jrReporteEgresadoFormulario",""),
 	
 	JR_REP_REPORTE_EGRESADO_GYT_CRITERIO("jrReporteEgresadoGyTCriterio.jasper","ReporteEgresado","jrReporteEgresadoGyTCriterio",""),
 	
 	JR_REP_REPORTE_EGRESADO("jrReporteEgresado.jasper","ReporteEgresado","jrReporteEgresado",""),
 	
 	//agregadoimprimirhorario
 	/** El JR_REP_REPORTE_ACTA_EVALUACION_FINAL. */
 	JR_REP_REPORTE_IMPRIMIR_HORARIO("jrRepImprimirHorario.jasper","ReporteImprimirHorario","jrRepImprimirHorario",""),
 	
 	
 	/**JR_REP_SERVICIO_COMPLEMENTARIO_ALUMNO. */
 	JR_REP_SERVICIO_COMPLEMENTARIO_ALUMNO("jrReporteServicioComplementarioAlumno.jasper","ReporteServicioComplementarioAlumno","jrReporteServicioComplementarioAlumno",""),
 	
 	/**JR_REP_SERVICIO_COMPLEMENTARIO_PERSONAL. */	
 	JR_REP_SERVICIO_COMPLEMENTARIO_PERSONAL("jrReporteServicioComplementarioPersonal.jasper","ReporteServicioComplementarioPersonal","jrReporteServicioComplementarioPersonal",""),
 	
 	/**JR_REP_INSERCION_LABORAL_ALUMNO. */
 	JR_REP_INSERCION_LABORAL_ALUMNO("jrReporteInsercionLaboralAlumno.jasper","ReporteInsercionLaboralAlumno","jrReporteInsercionLaboralAlumno",""),
 	
 	JR_REP_REPORTE_CUOTA_PRESTAMO("jrReporteCronogramaPagos.jasper","ReporteCuotaPrestamo","jrReporteCronogramaPagos",""),
 	
	 /** El NULO. */
	 NULO("","","","")
	 ;
 	
	 
	/** La Constante LOO_KUP_MAP. */
	private static final Map<String, NombreReporteType> LOO_KUP_MAP = new HashMap<String, NombreReporteType>();
	
	static {
		for (NombreReporteType s : EnumSet.allOf(NombreReporteType.class)) {
			LOO_KUP_MAP.put(s.getKey(), s);
		}
	}

	/** El key. */
	private String key;
	
	/** El value. */
	private String value;
	
	private String carperta;
	
	private String codigoReporte;

	
	/**
	 * Instancia un nuevo nombre reporte type.
	 *
	 * @param key el key
	 * @param value el value
	 * @param carperta el carperta
	 * @param codigoReporte el codigo reporte
	 */
	private NombreReporteType(String key, String value,String carperta,String codigoReporte) {
		this.key = key;
		this.value = value;
		this.carperta = carperta;
		this.codigoReporte = codigoReporte;
	}
	
	/**
	 * Gets the.
	 *
	 * @param key el key
	 * @return the accion type
	 */
	public static NombreReporteType get(String key) {
		if (LOO_KUP_MAP.containsKey(key)) {
			return LOO_KUP_MAP.get(key);
		} 
		return NULO;
		
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
	
	/**
	 * Obtiene carpeta.
	 *
	 * @return carpeta
	 */
	public String getCarpeta() {
		return carperta;
	}

	/**
	 * Obtiene codigo reporte.
	 *
	 * @return codigo reporte
	 */
	public String getCodigoReporte() {
		return codigoReporte;
	}	
	
}