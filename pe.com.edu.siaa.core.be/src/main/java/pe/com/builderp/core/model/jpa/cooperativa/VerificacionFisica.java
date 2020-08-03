package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.edu.siaa.core.model.jpa.seguridad.Usuario;
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
@Table(name = "VerificacionFisica", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class VerificacionFisica implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idVerificacionFisica" , length = 32)
    private String idVerificacionFisica;
   
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
    
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaVerificacion")
    private Date fechaVerificacion;
    
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario verificador;
    
    /** El nro doc. */
    @Column(name = "estado" , length = 2)
    private String estado;
    
 
    /** El nro doc. */
    @Column(name = "observacion")
    private String observacion;
    
    /** El nro doc. */
    @Column(name = "codigo" , length = 10)
    private String codigo;
    
    /** El nro doc. */
    @Column(name = "hora" , length = 10)
    private String hora;
    /**
     * Instancia un nuevo categoria.
     */
    public VerificacionFisica() {
    }
	public VerificacionFisica(String idVerificacionFisica, EvaluacionCredito evaluacionCredito, Date fechaCreacion,
			Date fechaVerificacion, Usuario verificador, String estado, String observacion,String codigo,String hora) {
		super();
		this.idVerificacionFisica = idVerificacionFisica;
		this.evaluacionCredito = evaluacionCredito;
		this.fechaCreacion = fechaCreacion;
		this.fechaVerificacion = fechaVerificacion;
		this.verificador = verificador;
		this.estado = estado;
		this.observacion = observacion;
		this.codigo=codigo;
		this.hora=hora;
	}
	
	
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdVerificacionFisica() {
		return idVerificacionFisica;
	}
	public void setIdVerificacionFisica(String idVerificacionFisica) {
		this.idVerificacionFisica = idVerificacionFisica;
	}
	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}
	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaVerificacion() {
		return fechaVerificacion;
	}
	public void setFechaVerificacion(Date fechaVerificacion) {
		this.fechaVerificacion = fechaVerificacion;
	}
	public Usuario getVerificador() {
		return verificador;
	}
	public void setVerificador(Usuario verificador) {
		this.verificador = verificador;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVerificacionFisica == null) ? 0 : idVerificacionFisica.hashCode());
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
		VerificacionFisica other = (VerificacionFisica) obj;
		if (idVerificacionFisica == null) {
			if (other.idVerificacionFisica != null)
				return false;
		} else if (!idVerificacionFisica.equals(other.idVerificacionFisica))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "VerificacionFisica [idVerificacionFisica=" + idVerificacionFisica + "]";
	}
}