package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.com.edu.siaa.core.model.dto.BasePaginator;
import pe.com.edu.siaa.core.model.dto.common.ItemDTO;
import pe.com.edu.siaa.core.model.dto.seguridad.EntidadDTO;

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
public class InformacionLaboralDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    private String idInformacionLaboral;
   
    /** El nombre. */
    private EntidadDTO entidad;
    
    /** El telefono2. */
    private BigDecimal salario;
   
    /** El celular. */
    private String tiempolabor;
    
    /** El ubigeo by nacimiento. */
    private ItemDTO itemByCargo;
    
    private EvaluacionCreditoDTO evaluacionCredito;
    
    private AvalDatosDTO avalDatos;
    
    /**
     * Instancia un nuevo categoria.
     */
    public InformacionLaboralDTO() {
    }

	public InformacionLaboralDTO(String idInformacionLaboral, EntidadDTO entidad, BigDecimal salario,
			String tiempolabor, ItemDTO itemByCargo,EvaluacionCreditoDTO evaluacionCredito,AvalDatosDTO avalDatos) {
		super();
		this.idInformacionLaboral = idInformacionLaboral;
		this.entidad = entidad;
		this.salario = salario;
		this.tiempolabor = tiempolabor;
		this.itemByCargo = itemByCargo;
		this.evaluacionCredito = evaluacionCredito;
		this.avalDatos=avalDatos;
	}

	
	
	
	public AvalDatosDTO getAvalDatos() {
		return avalDatos;
	}

	public void setAvalDatos(AvalDatosDTO avalDatos) {
		this.avalDatos = avalDatos;
	}

	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}

	public String getIdInformacionLaboral() {
		return idInformacionLaboral;
	}

	public void setIdInformacionLaboral(String idInformacionLaboral) {
		this.idInformacionLaboral = idInformacionLaboral;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getTiempolabor() {
		return tiempolabor;
	}

	public void setTiempolabor(String tiempolabor) {
		this.tiempolabor = tiempolabor;
	}

	public ItemDTO getItemByCargo() {
		return itemByCargo;
	}

	public void setItemByCargo(ItemDTO itemByCargo) {
		this.itemByCargo = itemByCargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInformacionLaboral == null) ? 0 : idInformacionLaboral.hashCode());
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
		InformacionLaboralDTO other = (InformacionLaboralDTO) obj;
		if (idInformacionLaboral == null) {
			if (other.idInformacionLaboral != null)
				return false;
		} else if (!idInformacionLaboral.equals(other.idInformacionLaboral))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InformacionLaboralDTO [idInformacionLaboral=" + idInformacionLaboral + "]";
	}
    
    
}