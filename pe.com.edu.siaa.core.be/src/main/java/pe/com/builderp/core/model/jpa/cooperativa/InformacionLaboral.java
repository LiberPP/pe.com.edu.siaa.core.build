package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.com.edu.siaa.core.model.jpa.common.Item;
import pe.com.edu.siaa.core.model.jpa.seguridad.Entidad;
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
@Table(name = "InformacionLaboral", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class InformacionLaboral implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idInformacionLaboral" , length = 32)
    private String idInformacionLaboral;
   
    /** El nombre. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad")
    private Entidad entidad;
   
    /** El celular. */
    @Column(name = "salario" , precision = 18 , scale = 2)
    private BigDecimal salario;
    
    /** El telefono2. */
    @Column(name = "tiempolabor" , length = 50)
    private String tiempolabor;
    
    
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCargo", referencedColumnName = "idItem")
    private Item itemByCargo;
    
    /** El ubigeo by nacimiento. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    /**
     * Instancia un nuevo categoria.
     */
    public InformacionLaboral() {
    }


	public InformacionLaboral(String idInformacionLaboral, Entidad entidad, BigDecimal salario, String tiempolabor,
			Item itemByCargo,EvaluacionCredito evaluacionCredito) {
		super();
		this.idInformacionLaboral = idInformacionLaboral;
		this.entidad = entidad;
		this.salario = salario;
		this.tiempolabor = tiempolabor;
		this.itemByCargo = itemByCargo;
		this.evaluacionCredito=evaluacionCredito;
	}
	


	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}


	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}


	public String getIdInformacionLaboral() {
		return idInformacionLaboral;
	}


	public void setIdInformacionLaboral(String idInformacionLaboral) {
		this.idInformacionLaboral = idInformacionLaboral;
	}


	public Entidad getEntidad() {
		return entidad;
	}


	public void setEntidad(Entidad entidad) {
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


	public Item getItemByCargo() {
		return itemByCargo;
	}


	public void setItemByCargo(Item itemByCargo) {
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
		InformacionLaboral other = (InformacionLaboral) obj;
		if (idInformacionLaboral == null) {
			if (other.idInformacionLaboral != null)
				return false;
		} else if (!idInformacionLaboral.equals(other.idInformacionLaboral))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "InformacionLaboral [idInformacionLaboral=" + idInformacionLaboral + "]";
	}

    
}