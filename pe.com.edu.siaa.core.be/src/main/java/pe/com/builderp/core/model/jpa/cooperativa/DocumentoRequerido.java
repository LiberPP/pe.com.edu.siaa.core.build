package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.com.edu.siaa.core.model.jpa.common.Item;
import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class Categoria.
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
@Table(name = "DocumentoRequerido", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class DocumentoRequerido implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idDocumentoRequerido" , length = 32)
    private String idDocumentoRequerido;
      
    /** El ubigeo by nacimiento. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    
    /** El item by documento. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocumento", referencedColumnName = "idItem")
    private Item itemByDocumento;
   
    /** El descripcion otro. */
    @Column(name = "descripcionOtro" , length = 50)
    private String descripcionOtro;
    
    /** El descripcion otro. */
    @Column(name = "digital" , length = 50)
    private String digital;
    
    /** El ubigeo by nacimiento. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAvalDatos", referencedColumnName = "idAvalDatos")
    private AvalDatos avalDatos;
    
    
    /**
     * Instancia un nuevo categoria.
     */
    public DocumentoRequerido() {
    }

	public DocumentoRequerido(String idDocumentoRequerido, EvaluacionCredito evaluacionCredito, Item itemByDocumento,
			String descripcionOtro,String digital,AvalDatos avalDatos) {
		super();
		this.idDocumentoRequerido = idDocumentoRequerido;
		this.evaluacionCredito = evaluacionCredito;
		this.itemByDocumento = itemByDocumento;
		this.descripcionOtro = descripcionOtro;
		this.digital = digital;
		this.avalDatos=avalDatos;
	}
	
	
	

	public AvalDatos getAvalDatos() {
		return avalDatos;
	}

	public void setAvalDatos(AvalDatos avalDatos) {
		this.avalDatos = avalDatos;
	}

	public String getDigital() {
		return digital;
	}

	public void setDigital(String digital) {
		this.digital = digital;
	}

	public String getIdDocumentoRequerido() {
		return idDocumentoRequerido;
	}

	public void setIdDocumentoRequerido(String idDocumentoRequerido) {
		this.idDocumentoRequerido = idDocumentoRequerido;
	}

	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}

	public Item getItemByDocumento() {
		return itemByDocumento;
	}

	public void setItemByDocumento(Item itemByDocumento) {
		this.itemByDocumento = itemByDocumento;
	}

	public String getDescripcionOtro() {
		return descripcionOtro;
	}

	public void setDescripcionOtro(String descripcionOtro) {
		this.descripcionOtro = descripcionOtro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDocumentoRequerido == null) ? 0 : idDocumentoRequerido.hashCode());
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
		DocumentoRequerido other = (DocumentoRequerido) obj;
		if (idDocumentoRequerido == null) {
			if (other.idDocumentoRequerido != null)
				return false;
		} else if (!idDocumentoRequerido.equals(other.idDocumentoRequerido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentoRequerido [idDocumentoRequerido=" + idDocumentoRequerido + "]";
	}
    
}