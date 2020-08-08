package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable; 
import java.util.Date;

import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.edu.siaa.core.model.dto.BasePaginator; 

/**
 * La Class ProformaDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Fri Dec 22 11:07:03 COT 2017
 * @since SIAA-CORE 2.1
 */
public class CompromisoPagoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idCompromisoPago;
  
   
    /** El codigo proforma. */
    private String descripcion;
 
   
    /** El tipo cambio. */
    private ClienteDTO cliente;
   
    /** El nro doc. */
    private Date fechaPago;
   
    /** El monto total. */
    private Date fechaIngreso;
    
    /** El monto total. */
    private String usuarioCreacion;
   
    /** El usuario creacion. */
    private Date fechaCreacion;
   
    private String usuarioModificacion;
 
    /** El fecha creacion. */
    private Date fechaModificacion;
   
    
    /**
     * Instancia un nuevo proformaDTO.
     */
    public CompromisoPagoDTO() {
    }


	public CompromisoPagoDTO(String idCompromisoPago, String descripcion, ClienteDTO cliente, Date fechaPago,
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


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO cliente) {
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
		CompromisoPagoDTO other = (CompromisoPagoDTO) obj;
		if (idCompromisoPago == null) {
			if (other.idCompromisoPago != null)
				return false;
		} else if (!idCompromisoPago.equals(other.idCompromisoPago))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CompromisoPagoDTO [idCompromisoPago=" + idCompromisoPago + "]";
	}
 
    
}