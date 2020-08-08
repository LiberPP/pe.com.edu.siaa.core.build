package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable; 

import pe.com.edu.siaa.core.model.dto.BasePaginator; 

/**
 * La Class VerificacionFisicaDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Fri Dec 22 11:07:00 COT 2017
 * @since SIAA-CORE 2.1
 */
public class ImagenAdjuntoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id cliente. */
    private String idImagenAdjunto;
   
    /** El entidad. */
    private VerificacionFisicaDTO verificacionFisica;
   
    /** El nombre. */
    private String nombre;
    

     
    public ImagenAdjuntoDTO() {
    }

	public ImagenAdjuntoDTO(String idImagenAdjunto, VerificacionFisicaDTO verificacionFisica, String nombre) {
		super();
		this.idImagenAdjunto = idImagenAdjunto;
		this.verificacionFisica = verificacionFisica;
		this.nombre = nombre;
	}

	public String getIdImagenAdjunto() {
		return idImagenAdjunto;
	}

	public void setIdImagenAdjunto(String idImagenAdjunto) {
		this.idImagenAdjunto = idImagenAdjunto;
	}

	public VerificacionFisicaDTO getVerificacionFisica() {
		return verificacionFisica;
	}

	public void setVerificacionFisica(VerificacionFisicaDTO verificacionFisica) {
		this.verificacionFisica = verificacionFisica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idImagenAdjunto == null) ? 0 : idImagenAdjunto.hashCode());
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
		ImagenAdjuntoDTO other = (ImagenAdjuntoDTO) obj;
		if (idImagenAdjunto == null) {
			if (other.idImagenAdjunto != null)
				return false;
		} else if (!idImagenAdjunto.equals(other.idImagenAdjunto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImagenAdjuntoDTO [idImagenAdjunto=" + idImagenAdjunto + "]";
	}
 
}