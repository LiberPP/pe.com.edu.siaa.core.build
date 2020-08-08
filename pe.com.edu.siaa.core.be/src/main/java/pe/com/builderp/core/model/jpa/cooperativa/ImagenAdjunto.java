package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;
 
import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class VerificacionFisica.
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
@Table(name = "ImagenAdjunto", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class ImagenAdjunto implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id VerificacionFisica. */
    @Id
    @Column(name = "idImagenAdjunto" , length = 32)
    private String idImagenAdjunto;
   
    /** El entidad. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVerificacionFisica", referencedColumnName = "idVerificacionFisica")
    private VerificacionFisica verificacionFisica;
   
    /** El nombre. */
    @Column(name = "nombre" , length = 50)
    private String nombre;
    
    
    /**
     * Instancia un nuevo VerificacionFisica.
     */
    public ImagenAdjunto() {
    }

    

	public ImagenAdjunto(String idImagenAdjunto, VerificacionFisica verificacionFisica, String nombre) {
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




	public VerificacionFisica getVerificacionFisica() {
		return verificacionFisica;
	}



	public void setVerificacionFisica(VerificacionFisica verificacionFisica) {
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
		ImagenAdjunto other = (ImagenAdjunto) obj;
		if (idImagenAdjunto == null) {
			if (other.idImagenAdjunto != null)
				return false;
		} else if (!idImagenAdjunto.equals(other.idImagenAdjunto))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ImagenAdjunto [idImagenAdjunto=" + idImagenAdjunto + "]";
	}

 

}