package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;

import pe.com.builderp.core.facturacion.model.dto.venta.AvalDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.edu.siaa.core.model.dto.BasePaginator; 

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
public class AvalDatosDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idAvalDatos;
  
   
    private Long itemTipoAval;
    
    /** El codigo proforma. */
    private String descripcion;
 
   
    private AvalDTO aval;
    
    private EvaluacionCreditoDTO evaluacionCredito;
    
     
    /**
     * Instancia un nuevo proformaDTO.
     */
    public AvalDatosDTO() {
    }


	public AvalDatosDTO(String idAvalDatos, Long itemTipoAval, String descripcion, AvalDTO aval,
			EvaluacionCreditoDTO evaluacionCredito) {
		super();
		this.idAvalDatos = idAvalDatos;
		this.itemTipoAval = itemTipoAval;
		this.descripcion = descripcion;
		this.aval = aval;
		this.evaluacionCredito = evaluacionCredito;
	}


	public String getIdAvalDatos() {
		return idAvalDatos;
	}


	public void setIdAvalDatos(String idAvalDatos) {
		this.idAvalDatos = idAvalDatos;
	}


	public Long getItemTipoAval() {
		return itemTipoAval;
	}


	public void setItemTipoAval(Long itemTipoAval) {
		this.itemTipoAval = itemTipoAval;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public AvalDTO getAval() {
		return aval;
	}


	public void setAval(AvalDTO aval) {
		this.aval = aval;
	}


	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}


	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAvalDatos == null) ? 0 : idAvalDatos.hashCode());
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
		AvalDatosDTO other = (AvalDatosDTO) obj;
		if (idAvalDatos == null) {
			if (other.idAvalDatos != null)
				return false;
		} else if (!idAvalDatos.equals(other.idAvalDatos))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AvalDatosDTO [idAvalDatos=" + idAvalDatos + "]";
	}

    
}