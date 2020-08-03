package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable; 

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
public class AvalDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    private String idAval;
  
   
    private Long itemTipoAval;
    
    /** El codigo proforma. */
    private String descripcion;
 
   
    private ClienteDTO persona;
    
    private EvaluacionCreditoDTO evaluacionCredito;
    
     
    /**
     * Instancia un nuevo proformaDTO.
     */
    public AvalDTO() {
    }


	public AvalDTO(String idAval, Long itemTipoAval, String descripcion, ClienteDTO persona,EvaluacionCreditoDTO evaluacionCredito) {
		super();
		this.idAval = idAval;
		this.itemTipoAval = itemTipoAval;
		this.descripcion = descripcion;
		this.persona = persona;
		this.evaluacionCredito=evaluacionCredito;
	}


	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}


	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}


	public String getIdAval() {
		return idAval;
	}


	public void setIdAval(String idAval) {
		this.idAval = idAval;
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


	public ClienteDTO getPersona() {
		return persona;
	}


	public void setPersona(ClienteDTO persona) {
		this.persona = persona;
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