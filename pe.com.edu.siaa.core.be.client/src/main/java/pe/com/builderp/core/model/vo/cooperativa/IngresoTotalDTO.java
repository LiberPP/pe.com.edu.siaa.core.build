package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import pe.com.edu.siaa.core.model.dto.BasePaginator;
import pe.com.edu.siaa.core.model.dto.common.ItemDTO;
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
public class IngresoTotalDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idIngreso;
  
   
    /** El codigo proforma. */
    private String descripcion;
 
   
    /** El tipo cambio. */
    private BigDecimal montoIngreso;
   
    /** El nro doc. */
    private String hora;
   
    private UsuarioDTO usuario;
 
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
    
    private ItemDTO itemByCategoria;
    
    /** El fecha creacion. */
    private Date fechaIngreso;
     
   
    /**
     * Instancia un nuevo proformaDTO.
     */
    public IngresoTotalDTO() {
    }


	public IngresoTotalDTO(String idIngreso, String descripcion, BigDecimal montoIngreso, String hora, UsuarioDTO usuario,
			Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion,
			String estado, ItemDTO itemByCategoria, Date fechaIngreso) {
		super();
		this.idIngreso = idIngreso;
		this.descripcion = descripcion;
		this.montoIngreso = montoIngreso;
		this.hora = hora;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
		this.itemByCategoria = itemByCategoria;
		this.fechaIngreso = fechaIngreso;
	}


	public String getIdIngreso() {
		return idIngreso;
	}


	public void setIdIngreso(String idIngreso) {
		this.idIngreso = idIngreso;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public BigDecimal getMontoIngreso() {
		return montoIngreso;
	}


	public void setMontoIngreso(BigDecimal montoIngreso) {
		this.montoIngreso = montoIngreso;
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


	public ItemDTO getItemByCategoria() {
		return itemByCategoria;
	}


	public void setItemByCategoria(ItemDTO itemByCategoria) {
		this.itemByCategoria = itemByCategoria;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idIngreso == null) ? 0 : idIngreso.hashCode());
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
		IngresoTotalDTO other = (IngresoTotalDTO) obj;
		if (idIngreso == null) {
			if (other.idIngreso != null)
				return false;
		} else if (!idIngreso.equals(other.idIngreso))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "IngresoDTO [idIngreso=" + idIngreso + "]";
	}

    
}