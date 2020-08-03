package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import pe.com.edu.siaa.core.model.dto.BasePaginator; 
import pe.com.edu.siaa.core.model.dto.seguridad.UsuarioDTO; 

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
public class PrestamoInternoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idPrestamoInterno;
  
   
    /** El codigo proforma. */
    private String descripcion;
 
   
    /** El tipo cambio. */
    private BigDecimal monto;
    
    /** El tipo cambio. */
    private BigDecimal montoResta;
   
    /** El nro doc. */
    private String hora;
   
    private UsuarioDTO usuario;
 
    
   /** El fecha creacion. */
   private Date fechaPrestamo;
   
    /** El fecha creacion. */
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    private String usuarioCreacion;
   
    /** El fecha modificacion. */
    private Date fechaModificacion;
   
    /** El usuario modificacion. */
    private String usuarioModificacion;
   
    /** El estado. */
    private String estado;

     
   
    /**
     * Instancia un nuevo proformaDTO.
     */
    public PrestamoInternoDTO() {
    }



	public PrestamoInternoDTO(String idPrestamoInterno, String descripcion, BigDecimal monto, BigDecimal montoResta,
			String hora, UsuarioDTO usuario, Date fechaPrestamo, Date fechaCreacion, String usuarioCreacion,
			Date fechaModificacion, String usuarioModificacion, String estado) {
		super();
		this.idPrestamoInterno = idPrestamoInterno;
		this.descripcion = descripcion;
		this.monto = monto;
		this.montoResta = montoResta;
		this.hora = hora;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
	}



	public String getIdPrestamoInterno() {
		return idPrestamoInterno;
	}



	public void setIdPrestamoInterno(String idPrestamoInterno) {
		this.idPrestamoInterno = idPrestamoInterno;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public BigDecimal getMonto() {
		return monto;
	}



	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}



	public BigDecimal getMontoResta() {
		return montoResta;
	}



	public void setMontoResta(BigDecimal montoResta) {
		this.montoResta = montoResta;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public UsuarioDTO getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}



	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}



	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}



	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}



	public Date getFechaModificacion() {
		return fechaModificacion;
	}



	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}



	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}



	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPrestamoInterno == null) ? 0 : idPrestamoInterno.hashCode());
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
		PrestamoInternoDTO other = (PrestamoInternoDTO) obj;
		if (idPrestamoInterno == null) {
			if (other.idPrestamoInterno != null)
				return false;
		} else if (!idPrestamoInterno.equals(other.idPrestamoInterno))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "PrestamoInternoDTO [idPrestamoInterno=" + idPrestamoInterno + "]";
	}


    
}