package pe.com.builderp.core.facturacion.model.dto.venta;

import java.io.Serializable; 
import java.util.Date; 

import pe.com.edu.siaa.core.model.dto.BasePaginator;
import pe.com.edu.siaa.core.model.dto.common.ItemDTO;
import pe.com.edu.siaa.core.model.dto.seguridad.EntidadDTO; 

/**
 * La Class ClienteDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Fri Dec 22 11:07:00 COT 2017
 * @since SIAA-CORE 2.1
 */
public class AvalDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id cliente. */
    private String idAval;
   
    /** El entidad. */
    private EntidadDTO entidad;
   
    /** El nombre. */
    private String nombre;
   
    /** El apellido paterno. */
    private String apellidoPaterno;
   
    /** El apellido materno. */
    private String apellidoMaterno;
   
    /** El item by tipo documento identidad. */
    private ItemDTO itemByTipoDocumentoIdentidad;
   
    /** El nro doc. */
    private String nroDoc;
   
    /** El email. */
    private String email;
   
    /** El telefono. */
    private String telefono;
   
    /** El celular. */
    private String celular;
   
    /** El pagina web. */
    private String paginaWeb;
   
    /** El direccion. */
    private String direccion;
   
    /** El estado. */
    private String estado;
    
    /** El foto. */
    private String foto;
    
    /** El item by estado civil. */
    private ItemDTO itemByEstadoCivil;
    
    /** El fecha nacimiento. */
    private Date fechaNacimiento;
    
    private String genero;
    
   
    /**
     * Instancia un nuevo clienteDTO.
     */
    public AvalDTO() {
    }


	public AvalDTO(String idAval, EntidadDTO entidad, String nombre, String apellidoPaterno, String apellidoMaterno,
			ItemDTO itemByTipoDocumentoIdentidad, String nroDoc, String email, String telefono, String celular,
			String paginaWeb, String direccion, String estado, String foto, ItemDTO itemByEstadoCivil,
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


	public EntidadDTO getEntidad() {
		return entidad;
	}


	public void setEntidad(EntidadDTO entidad) {
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


	public ItemDTO getItemByTipoDocumentoIdentidad() {
		return itemByTipoDocumentoIdentidad;
	}


	public void setItemByTipoDocumentoIdentidad(ItemDTO itemByTipoDocumentoIdentidad) {
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


	public ItemDTO getItemByEstadoCivil() {
		return itemByEstadoCivil;
	}


	public void setItemByEstadoCivil(ItemDTO itemByEstadoCivil) {
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
		AvalDTO other = (AvalDTO) obj;
		if (idAval == null) {
			if (other.idAval != null)
				return false;
		} else if (!idAval.equals(other.idAval))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AvalDTO [idAval=" + idAval + "]";
	}
   
    
}