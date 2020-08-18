package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;

import pe.com.edu.siaa.core.model.dto.BasePaginator;
import pe.com.edu.siaa.core.model.dto.common.ItemDTO;
 

public class DocumentoRequeridoDTO extends BasePaginator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idDocumentoRequerido;
	
    private EvaluacionCreditoDTO evaluacionCredito;
    
    private ItemDTO itemByDocumento;
    
    private String descripcionOtro;
    
    private String digital;
    
    private AvalDatosDTO avalDatos;
    
    public DocumentoRequeridoDTO() {
    }

	public DocumentoRequeridoDTO(String idDocumentoRequerido, EvaluacionCreditoDTO evaluacionCredito,
			ItemDTO itemByDocumento, String descripcionOtro,String digital,AvalDatosDTO avalDatos) {
		super();
		this.idDocumentoRequerido = idDocumentoRequerido;
		this.evaluacionCredito = evaluacionCredito;
		this.itemByDocumento = itemByDocumento;
		this.descripcionOtro = descripcionOtro;
		this.digital= digital;
		this.avalDatos=avalDatos;
	}
	
	

	public AvalDatosDTO getAvalDatos() {
		return avalDatos;
	}

	public void setAvalDatos(AvalDatosDTO avalDatos) {
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

	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}

	public ItemDTO getItemByDocumento() {
		return itemByDocumento;
	}

	public void setItemByDocumento(ItemDTO itemByDocumento) {
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
		DocumentoRequeridoDTO other = (DocumentoRequeridoDTO) obj;
		if (idDocumentoRequerido == null) {
			if (other.idDocumentoRequerido != null)
				return false;
		} else if (!idDocumentoRequerido.equals(other.idDocumentoRequerido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentoRequeridoDTO [idDocumentoRequerido=" + idDocumentoRequerido + "]";
	}
    
}
