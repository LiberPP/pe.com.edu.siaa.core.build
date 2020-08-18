package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.com.builderp.core.facturacion.model.jpa.venta.Aval; 
import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class Proforma.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Dec 22 11:10:36 COT 2017
 * @since SIAA-CORE 2.1
 */
@Entity
@Table(name = "AvalDatos", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class AvalDatos implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    @Id
    @Column(name = "idAvalDatos" , length = 32)
    private String idAvalDatos;
    
    /** El tipo usuario. */ 
    @Column(name = "tipoaval" , precision = 18 , scale = 0)
    private Long itemTipoAval;
   
    /** El codigo proforma. */
    @Column(name = "descripcion" , length = 150)
    private String descripcion;
    
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAval", referencedColumnName = "idAval")
    private Aval aval;
    
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    
     
    
    /**
     * Instancia un nuevo proforma.
     */
    public AvalDatos() {
    }



	public AvalDatos(String idAvalDatos, Long itemTipoAval, String descripcion, Aval aval,
			EvaluacionCredito evaluacionCredito) {
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



	public Aval getAval() {
		return aval;
	}



	public void setAval(Aval aval) {
		this.aval = aval;
	}



	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}



	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
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
		AvalDatos other = (AvalDatos) obj;
		if (idAvalDatos == null) {
			if (other.idAvalDatos != null)
				return false;
		} else if (!idAvalDatos.equals(other.idAvalDatos))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "AvalDatos [idAvalDatos=" + idAvalDatos + "]";
	}



    
}