package pe.com.builderp.core.facturacion.model.jpa.venta;

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

import pe.com.edu.siaa.core.model.jpa.common.Item;
import pe.com.edu.siaa.core.model.jpa.seguridad.Entidad; 
import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class Cliente.
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
@Table(name = "Aval", schema = ConfiguracionEntityManagerUtil.ESQUEMA_FACTURACION)
public class Aval implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id cliente. */
    @Id
    @Column(name = "idAval" , length = 32)
    private String idAval;
   
    /** El entidad. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad")
    private Entidad entidad;
   
    /** El nombre. */
    @Column(name = "nombre" , length = 100)
    private String nombre;
   
    /** El apellido paterno. */
    @Column(name = "apellidoPaterno" , length = 100)
    private String apellidoPaterno;
   
    /** El apellido materno. */
    @Column(name = "apellidoMaterno" , length = 100)
    private String apellidoMaterno;
   
    /** El item by tipo documento identidad. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDocumentoIdentidad", referencedColumnName = "idItem")
    private Item itemByTipoDocumentoIdentidad;
   
    /** El nro doc. */
    @Column(name = "nroDoc" , length = 20)
    private String nroDoc;
   
    /** El email. */
    @Column(name = "email" , length = 20)
    private String email;
   
    /** El telefono. */
    @Column(name = "telefono" , length = 20)
    private String telefono;
   
    /** El celular. */
    @Column(name = "celular" , length = 20)
    private String celular;
   
    /** El pagina web. */
    @Column(name = "paginaWeb" , length = 20)
    private String paginaWeb;
   
    /** El direccion. */
    @Column(name = "direccion" , length = 200)
    private String direccion;
   
    /** El estado. */
    @Column(name = "estado" , length = 1)
    private String estado;
    
    /** El estado. */
    @Column(name = "foto" , length = 50)
    private String foto;
    
    
    /** El item by categoria cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstadoCivil", referencedColumnName = "idItem")
    private Item itemByEstadoCivil;
   
    /** El fecha venta. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    
    /** El estado. */
    @Column(name = "genero" , length = 1)
    private String genero;
   
    
    /**
     * Instancia un nuevo cliente.
     */
    public Aval() {
    }


	public Aval(String idAval, Entidad entidad, String nombre, String apellidoPaterno, String apellidoMaterno,
			Item itemByTipoDocumentoIdentidad, String nroDoc, String email, String telefono, String celular,
			String paginaWeb, String direccion, String estado, String foto, Item itemByEstadoCivil,
			Date fechaNacimiento, String genero) {
		super();
		this.idAval = idAval;
		this.entidad = entidad;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.itemByTipoDocumentoIdentidad = itemByTipoDocumentoIdentidad;
		this.nroDoc = nroDoc;
		this.email = email;
		this.telefono = telefono;
		this.celular = celular;
		this.paginaWeb = paginaWeb;
		this.direccion = direccion;
		this.estado = estado;
		this.foto = foto;
		this.itemByEstadoCivil = itemByEstadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}


	public String getIdAval() {
		return idAval;
	}


	public void setIdAval(String idAval) {
		this.idAval = idAval;
	}


	public Entidad getEntidad() {
		return entidad;
	}


	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
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


	public Item getItemByTipoDocumentoIdentidad() {
		return itemByTipoDocumentoIdentidad;
	}


	public void setItemByTipoDocumentoIdentidad(Item itemByTipoDocumentoIdentidad) {
		this.itemByTipoDocumentoIdentidad = itemByTipoDocumentoIdentidad;
	}


	public String getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPaginaWeb() {
		return paginaWeb;
	}


	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Item getItemByEstadoCivil() {
		return itemByEstadoCivil;
	}


	public void setItemByEstadoCivil(Item itemByEstadoCivil) {
		this.itemByEstadoCivil = itemByEstadoCivil;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAval == null) ? 0 : idAval.hashCode());
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
		Aval other = (Aval) obj;
		if (idAval == null) {
			if (other.idAval != null)
				return false;
		} else if (!idAval.equals(other.idAval))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Aval [idAval=" + idAval + "]";
	}
   
    
}