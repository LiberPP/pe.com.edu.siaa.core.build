package pe.com.edu.siaa.core.model.vo;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * <ul>
 * <li>Copyright 2017 ndavilal. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class CorreoVO.
 *
 * @author ndavilal
 * @version 1.0 , 06/04/2015
 * @since SIAA-CORE 2.1
 */
public class CursoNotaVO implements Serializable {

	/** El asunto. */
	private String asunto;
	
	/** El contenido. */
	private String contenido;
	
    /** La Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;
     
   
 
    
    private String idCursoNota;
    private String idDetRegistroNota;
   
    private String idConceptoNota;
    private Long itemByTipoNota;
    private BigDecimal nota;
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getIdCursoNota() {
		return idCursoNota;
	}
	public void setIdCursoNota(String idCursoNota) {
		this.idCursoNota = idCursoNota;
	}
	public String getIdDetRegistroNota() {
		return idDetRegistroNota;
	}
	public void setIdDetRegistroNota(String idDetRegistroNota) {
		this.idDetRegistroNota = idDetRegistroNota;
	}
	public String getIdConceptoNota() {
		return idConceptoNota;
	}
	public void setIdConceptoNota(String idConceptoNota) {
		this.idConceptoNota = idConceptoNota;
	}
	public Long getItemByTipoNota() {
		return itemByTipoNota;
	}
	public void setItemByTipoNota(Long itemByTipoNota) {
		this.itemByTipoNota = itemByTipoNota;
	}
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
    
    
     
   
 

}
