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
 * La Class Proforma.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Dec 22 11:10:36 COT 2017
 * @since SIAA-CORE 2.1
 */
@Entity
@Table(name = "CompromisoPago", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class CompromisoPago implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    @Id
    @Column(name = "idCompromisoPago" , length = 32)
    private String idCompromisoPago;
   
    /** El codigo proforma. */
    @Column(name = "descripcion" , length = 50)
    private String descripcion;
  
 
    /** El igv. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    

    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaPago")
    private Date fechaPago;
    
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;
    
    
    /** El usuario creacion. */
    @Column(name = "usuarioCreacion" , length = 50)
    private String usuarioCreacion;
    
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
   
    /** El usuario modificacion. */
    @Column(name = "usuarioModificacion" , length = 50)
    private String usuarioModificacion;
    
   
    /** El fecha modificacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;
   
 
    
    /**
     * Instancia un nuevo proforma.
     */
    public CompromisoPago() {
    }



	public CompromisoPago(String idCompromisoPago, String descripcion, Cliente cliente, Date fechaPago,
			Date fechaIngreso, String usuarioCreacion, Date fechaCreacion, String usuarioModificacion,
			Date fechaModificacion) {
		super();
		this.idCompromisoPago = idCompromisoPago;
		this.descripcion = descripcion;
		this.cliente = cliente;
		this.fechaPago = fechaPago;
		this.fechaIngreso = fechaIngreso;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
	}



	public String getIdCompromisoPago() {
		return idCompromisoPago;
	}



	public void setIdCompromisoPago(String idCompromisoPago) {
		this.idCompromisoPago = idCompromisoPago;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Date getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}



	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}



	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}



	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}



	public Date getFechaModificacion() {
		return fechaModificacion;
	}



	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCompromisoPago == null) ? 0 : idCompromisoPago.hashCode());
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
		CompromisoPago other = (CompromisoPago) obj;
		if (idCompromisoPago == null) {
			if (other.idCompromisoPago != null)
				return false;
		} else if (!idCompromisoPago.equals(other.idCompromisoPago))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "CompromisoPago [idCompromisoPago=" + idCompromisoPago + "]";
	} 
    
    
    
}