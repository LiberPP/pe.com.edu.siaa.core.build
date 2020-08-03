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
public class EgresoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idEgreso;
  
   
    /** El codigo proforma. */
    private String descripcion;
 
   
    /** El tipo cambio. */
    private BigDecimal montoEgreso;
   
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
    private Date fechaEgreso;
    
	private String fechaPago;
   
    /**
     * Instancia un nuevo proformaDTO.
     */
    public EgresoDTO() {
    }

	public EgresoDTO(String idEgreso, String descripcion, BigDecimal montoEgreso, String hora, UsuarioDTO usuario,
			Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion,
			String estado, ItemDTO itemByCategoria,Date fechaEgreso) {
		super();
		this.idEgreso = idEgreso;
		this.descripcion = descripcion;
		this.montoEgreso = montoEgreso;
		this.hora = hora;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
		this.itemByCategoria = itemByCategoria;
		this.fechaEgreso=fechaEgreso;
	}
	

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdEgreso() {
		return idEgreso;
	}

	public void setIdEgreso(String idEgreso) {
		this.idEgreso = idEgreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getMontoEgreso() {
		return montoEgreso;
	}

	public void setMontoEgreso(BigDecimal montoEgreso) {
		this.montoEgreso = montoEgreso;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEgreso == null) ? 0 : idEgreso.hashCode());
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
		EgresoDTO other = (EgresoDTO) obj;
		if (idEgreso == null) {
			if (other.idEgreso != null)
				return false;
		} else if (!idEgreso.equals(other.idEgreso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EgresoDTO [idEgreso=" + idEgreso + "]";
	}

	
}