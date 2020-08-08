package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

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
@Entity
@Table(name = "ReferenciaPersonal", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class ReferenciaPersonal implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idReferenciaPersonal" , length = 32)
    private String idReferenciaPersonal;
   
    /** El nombre. */
    @Column(name = "nombre" , length = 50)
    private String nombre;
   
    /** El apellido paterno. */
    @Column(name = "apellidoPaterno" , length = 50)
    private String apellidoPaterno;
   
    /** El apellido materno. */
    @Column(name = "apellidoMaterno" , length = 50)
    private String apellidoMaterno;
   
    /** El nro doc. */
    @Column(name = "nroDoc" , length = 50)
    private String nroDoc;
    
    /** El telefono2. */
    @Column(name = "telefono" , length = 50)
    private String telefono;
   
    /** El celular. */
    @Column(name = "celular" , length = 50)
    private String celular;

    /** El celular. */
    @Column(name = "parentesco" , length = 100)
    private String parentesco;
    
    
    /** El ubigeo by nacimiento. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    
    /**
     * Instancia un nuevo categoria.
     */
    public ReferenciaPersonal() {
    }

	public ReferenciaPersonal(String idReferenciaPersonal, String nombre, String apellidoPaterno,
			String apellidoMaterno, String nroDoc, String telefono, String celular,
			EvaluacionCredito evaluacionCredito,String parentesco) {
		super();
		this.idReferenciaPersonal = idReferenciaPersonal;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nroDoc = nroDoc;
		this.telefono = telefono;
		this.celular = celular;
		this.evaluacionCredito = evaluacionCredito;
		this.parentesco=parentesco;
	}
	

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
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

	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
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
		ReferenciaPersonal other = (ReferenciaPersonal) obj;
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