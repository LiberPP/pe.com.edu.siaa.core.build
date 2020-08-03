package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

/**
 * La Class Categoria.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Dec 22 11:10:34 COT 2017
 * @since SIAA-CORE 2.1
 */
public class ReferenciaPersonalDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    private String idReferenciaPersonal;
   
    /** El nombre. */
    private String nombre;
   
    /** El apellido paterno. */
    private String apellidoPaterno;
   
    /** El apellido materno. */
    private String apellidoMaterno;
   
    /** El nro doc. */
    private String nroDoc;
    
    /** El telefono2. */
    private String telefono;
   
    /** El celular. */
    private String celular;
    
    /** El ubigeo by nacimiento. */
    private EvaluacionCreditoDTO evaluacionCredito;
    
    /**
     * Instancia un nuevo categoria.
     */
    public ReferenciaPersonalDTO() {
    }

	public ReferenciaPersonalDTO(String idReferenciaPersonal, String nombre, String apellidoPaterno,
			String apellidoMaterno, String nroDoc, String telefono, String celular,
			EvaluacionCreditoDTO evaluacionCredito) {
		super();
		this.idReferenciaPersonal = idReferenciaPersonal;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nroDoc = nroDoc;
		this.telefono = telefono;
		this.celular = celular;
		this.evaluacionCredito = evaluacionCredito;
	}

	public String getIdReferenciaPersonal() {
		return idReferenciaPersonal;
	}

	public void setIdReferenciaPersonal(String idReferenciaPersonal) {
		this.idReferenciaPersonal = idReferenciaPersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReferenciaPersonal == null) ? 0 : idReferenciaPersonal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenciaPersonalDTO other = (ReferenciaPersonalDTO) obj;
		if (idReferenciaPersonal == null) {
			if (other.idReferenciaPersonal != null)
				return false;
		} else if (!idReferenciaPersonal.equals(other.idReferenciaPersonal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReferenciaPersonal [idReferenciaPersonal=" + idReferenciaPersonal + "]";
	}
 
    
    
    
}