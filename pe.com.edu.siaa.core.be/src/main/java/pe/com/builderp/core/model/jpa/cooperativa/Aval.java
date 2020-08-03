package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

import pe.com.builderp.core.facturacion.model.jpa.venta.Cliente; 
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
@Table(name = "Aval", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class Aval implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id proforma. */
    @Id
    @Column(name = "idAval" , length = 32)
    private String idAval;
    
    /** El tipo usuario. */ 
    @Column(name = "tipoaval" , precision = 18 , scale = 0)
    private Long itemTipoAval;
   
    /** El codigo proforma. */
    @Column(name = "descripcion" , length = 150)
    private String descripcion;
    
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", referencedColumnName = "idCliente")
    private Cliente persona;
    
    /** El tipo usuario. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacionCredito", referencedColumnName = "idEvaluacionCredito")
    private EvaluacionCredito evaluacionCredito;
    
     
    
    /**
     * Instancia un nuevo proforma.
     */
    public Aval() {
    }



	public Aval(String idAval, Long itemTipoAval, String descripcion, Cliente persona,EvaluacionCredito evaluacionCredito) {
		super();
		this.idAval = idAval;
		this.itemTipoAval = itemTipoAval;
		this.descripcion = descripcion;
		this.persona = persona;
		this.evaluacionCredito=evaluacionCredito;
	}


	public EvaluacionCredito getEvaluacionCredito() {
		return evaluacionCredito;
	}



	public void setEvaluacionCredito(EvaluacionCredito evaluacionCredito) {
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



	public Cliente getPersona() {
		return persona;
	}



	public void setPersona(Cliente persona) {
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
		Aval other = (Aval) obj;
		if (idAval == null) {
			if (other.idAval != null)
				return false;
		} else if (!idAval.equals(other.idAval))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Aval [idAval=" + idAval + "]";
	}


	
}