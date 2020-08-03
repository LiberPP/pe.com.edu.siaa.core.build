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
@Table(name = "IngresoTotal", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class IngresoTotal implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    @Id
    @Column(name = "idIngresoTotal" , length = 32)
    private String idIngresoTotal;
   
    /** El codigo proforma. */
    @Column(name = "descripcion" , length = 150)
    private String descripcion;
  
   
    /** El igv. */
    @Column(name = "montoIngresoTotal" , precision = 18 , scale = 2)
    private BigDecimal montoIngresoTotal;
   
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
    @Column(name = "fechaIngresoTotal")
    private Date fechaIngresoTotal;
    
    
    
    /**
     * Instancia un nuevo proforma.
     */
    public IngresoTotal() {
    }



	public IngresoTotal(String idIngresoTotal, String descripcion, BigDecimal montoIngresoTotal, String hora, Usuario usuario,
			Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion,
			String estado, Item itemByCategoria, Date fechaIngresoTotal) {
		super();
		this.idIngresoTotal = idIngresoTotal;
		this.descripcion = descripcion;
		this.montoIngresoTotal = montoIngresoTotal;
		this.hora = hora;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
		this.itemByCategoria = itemByCategoria;
		this.fechaIngresoTotal = fechaIngresoTotal;
	}



	public String getIdIngresoTotal() {
		return idIngresoTotal;
	}



	public void setIdIngresoTotal(String idIngresoTotal) {
		this.idIngresoTotal = idIngresoTotal;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public BigDecimal getMontoIngresoTotal() {
		return montoIngresoTotal;
	}



	public void setMontoIngresoTotal(BigDecimal montoIngresoTotal) {
		this.montoIngresoTotal = montoIngresoTotal;
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



	public Date getFechaIngresoTotal() {
		return fechaIngresoTotal;
	}



	public void setFechaIngresoTotal(Date fechaIngresoTotal) {
		this.fechaIngresoTotal = fechaIngresoTotal;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idIngresoTotal == null) ? 0 : idIngresoTotal.hashCode());
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
		IngresoTotal other = (IngresoTotal) obj;
		if (idIngresoTotal == null) {
			if (other.idIngresoTotal != null)
				return false;
		} else if (!idIngresoTotal.equals(other.idIngresoTotal))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "IngresoTotal [idIngresoTotal=" + idIngresoTotal + "]";
	}

 
}