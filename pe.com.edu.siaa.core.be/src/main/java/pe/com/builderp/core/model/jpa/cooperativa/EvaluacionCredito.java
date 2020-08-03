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

import pe.com.builderp.core.facturacion.model.jpa.venta.Cliente; 
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
@Table(name = "EvaluacionCredito", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class EvaluacionCredito implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idEvaluacionCredito" , length = 32)
    private String idEvaluacionCredito;
   
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
     
    @Column(name = "tipoPersona" , length = 5)
    private String tipoPersona;
    
    /** El item by tipo doc identidad. */
    @Column(name = "tipoCredito" , length = 5)
    private String tipoCredito;
    
    /** El item by tipo doc identidad. */
    @Column(name = "tipoVivienda" , length = 10)
    private String tipoVivienda;  
    
    /** El item by tipo doc identidad. */
    @Column(name = "condicionLaboral" , length = 30)
    private String condicionLaboral;  
    
    /** El item by tipo doc identidad. */
    @Column(name = "calificaVerificacion" , length = 2)
    private String calificaVerificacion;  
    
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaEvaluacion")
    private Date fechaEvaluacion;
    
    /** El nro doc. */
    @Column(name = "codigo" , length = 10)
    private String codigo;
    
    /** El nro doc. */
    @Column(name = "descripcion" , length = 5)
    private String descripcion;
    /**
     * Instancia un nuevo categoria.
     */
    public EvaluacionCredito() {
    }
	public EvaluacionCredito(String idEvaluacionCredito, Cliente cliente,String tipoPersona,
			String tipoCredito, Date fechaEvaluacion, String codigo, String descripcion,String tipoVivienda,
			String condicionLaboral,String calificaVerificacion) {
		super();
		this.idEvaluacionCredito = idEvaluacionCredito;
		this.cliente = cliente;
		this.tipoPersona = tipoPersona;
		this.tipoCredito = tipoCredito;
		this.fechaEvaluacion = fechaEvaluacion;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipoVivienda=tipoVivienda;
		this.condicionLaboral=condicionLaboral;
		this.calificaVerificacion=calificaVerificacion;
	}
	
	
	public String getCondicionLaboral() {
		return condicionLaboral;
	}
	public void setCondicionLaboral(String condicionLaboral) {
		this.condicionLaboral = condicionLaboral;
	}
	public String getCalificaVerificacion() {
		return calificaVerificacion;
	}
	public void setCalificaVerificacion(String calificaVerificacion) {
		this.calificaVerificacion = calificaVerificacion;
	}
	public String getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	public String getIdEvaluacionCredito() {
		return idEvaluacionCredito;
	}
	public void setIdEvaluacionCredito(String idEvaluacionCredito) {
		this.idEvaluacionCredito = idEvaluacionCredito;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	public String getTipoCredito() {
		return tipoCredito;
	}
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvaluacionCredito == null) ? 0 : idEvaluacionCredito.hashCode());
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
		EvaluacionCredito other = (EvaluacionCredito) obj;
		if (idEvaluacionCredito == null) {
			if (other.idEvaluacionCredito != null)
				return false;
		} else if (!idEvaluacionCredito.equals(other.idEvaluacionCredito))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EvaluacionCredito [idEvaluacionCredito=" + idEvaluacionCredito + "]";
	}

	
}