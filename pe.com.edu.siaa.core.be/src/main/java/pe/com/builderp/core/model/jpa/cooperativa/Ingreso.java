package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
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

import pe.com.edu.siaa.core.model.jpa.common.Item;
import pe.com.edu.siaa.core.model.jpa.seguridad.Usuario;
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
@Table(name = "Ingreso", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class Ingreso implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    @Id
    @Column(name = "idIngreso" , length = 32)
    private String idIngreso;
   
    /** El codigo proforma. */
    @Column(name = "descripcion" , length = 150)
    private String descripcion;
  
   
    /** El igv. */
    @Column(name = "montoIngreso" , precision = 18 , scale = 2)
    private BigDecimal montoIngreso;
   
    /** El usuario creacion. */
    @Column(name = "hora" , length = 50)
    private String hora;
       
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;
    

    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    @Column(name = "usuarioCreacion" , length = 50)
    private String usuarioCreacion;
   
    /** El fecha modificacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;
   
    /** El usuario modificacion. */
    @Column(name = "usuarioModificacion" , length = 50)
    private String usuarioModificacion;
    
    
    /** El estado. */
    @Column(name = "estado" , length = 2)
    private String estado;
    
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", referencedColumnName = "idItem")
    private Item itemByCategoria;
    
    /** El fecha modificacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;
    
    
    
    /**
     * Instancia un nuevo proforma.
     */
    public Ingreso() {
    }



	public Ingreso(String idIngreso, String descripcion, BigDecimal montoIngreso, String hora, Usuario usuario,
			Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion,
			String estado, Item itemByCategoria, Date fechaIngreso) {
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



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
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



	public Item getItemByCategoria() {
		return itemByCategoria;
	}



	public void setItemByCategoria(Item itemByCategoria) {
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
		Ingreso other = (Ingreso) obj;
		if (idIngreso == null) {
			if (other.idIngreso != null)
				return false;
		} else if (!idIngreso.equals(other.idIngreso))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Ingreso [idIngreso=" + idIngreso + "]";
	}
    
    
}