package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class Fraccionamiento.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 09:56:48 COT 2017
 * @since SIAA-CORE 2.1
 */
@Entity
@Table(name = "Fraccionamiento", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class Fraccionamiento implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id fraccionamiento. */
    @Id
    @Column(name = "idFraccionamiento" , length = 100)
    private String idFraccionamiento;
   
    /** El det plan pagos. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCredito", referencedColumnName = "idCredito")
    private Credito credito;
   
    /** El nro. */
    @Column(name = "nro" , length = 5)
    private String nro;
   
    /** El cuota fracionada. */
    @Column(name = "cuotaFracionada" , precision = 18 , scale = 2)
    private BigDecimal cuotaFracionada;
   
    /** El monto fraccionado resta. */
    @Column(name = "montoFraccionadoResta" , precision = 18 , scale = 2)
    private BigDecimal montoFraccionadoResta;
   
    /** El fecha vencimiento. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;
   
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    @Column(name = "usuarioCreacion" , length = 50)
    private String usuarioCreacion;
    
    @Column(name = "estado" , length = 50)
    private String estado;
    
    /** El monto fraccionado resta. */
    @Column(name = "interes" , precision = 18 , scale = 2)
    private BigDecimal interes;
    
    
    @Column(name = "saldo" , precision = 18 , scale = 2)
    private BigDecimal saldo;
    /** El estado. 
    @Column(name = "estado" , length = 50)
    private String estado;*/
    
    /**
     * Instancia un nuevo fraccionamiento.
     */
    public Fraccionamiento() {
    }
   
   
    /**
     * Instancia un nuevo fraccionamiento.
     *
     * @param idFraccionamiento el id fraccionamiento
     * @param detPlanPagos el det plan pagos
     * @param nro el nro
     * @param cuotaFracionada el cuota fracionada
     * @param montoFraccionadoResta el monto fraccionado resta
     * @param fechaVencimiento el fecha vencimiento
     * @param fechaCreacion el fecha creacion
     * @param usuarioCreacion el usuario creacion
     */
    public Fraccionamiento(String estado,String idFraccionamiento, Credito credito,String nro, BigDecimal cuotaFracionada, 
    		BigDecimal montoFraccionadoResta, Date fechaVencimiento, Date fechaCreacion, String usuarioCreacion,
    		BigDecimal interes,BigDecimal saldo) {
        super();
        this.idFraccionamiento = idFraccionamiento;
        this.credito = credito;
        this.nro = nro;
        this.cuotaFracionada = cuotaFracionada;
        this.montoFraccionadoResta = montoFraccionadoResta;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.estado = estado;
        this.interes=interes;
        this.saldo=saldo;
       // this.estado = estado;
    }
    
    
   
    public BigDecimal getSaldo() {
		return saldo;
	}


	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	public BigDecimal getInteres() {
		return interes;
	}


	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}


	//get y set
    /**
     * Obtiene id fraccionamiento.
     *
     * @return id fraccionamiento
     */
     public String getIdFraccionamiento() {
        return this.idFraccionamiento;
    }
    /**
     * Establece el id fraccionamiento.
     *
     * @param idFraccionamiento el new id fraccionamiento
     */
    public void setIdFraccionamiento(String idFraccionamiento) {
        this.idFraccionamiento = idFraccionamiento;
    }
    /**
     * Obtiene det plan pagos.
     *
     * @return det plan pagos
     */

    /**
     * Obtiene nro.
     *
     * @return nro
     */
     public String getNro() {
        return this.nro;
    }
    public Credito getCredito() {
		return credito;
	}


	public void setCredito(Credito credito) {
		this.credito = credito;
	}


	/**
     * Establece el nro.
     *
     * @param nro el new nro
     */
    public void setNro(String nro) {
        this.nro = nro;
    }
    
    



	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
     * Obtiene cuota fracionada.
     *
     * @return cuota fracionada
     */
     public BigDecimal getCuotaFracionada() {
        return this.cuotaFracionada;
    }
    /**
     * Establece el cuota fracionada.
     *
     * @param cuotaFracionada el new cuota fracionada
     */
    public void setCuotaFracionada(BigDecimal cuotaFracionada) {
        this.cuotaFracionada = cuotaFracionada;
    }
    /**
     * Obtiene monto fraccionado resta.
     *
     * @return monto fraccionado resta
     */
     public BigDecimal getMontoFraccionadoResta() {
        return this.montoFraccionadoResta;
    }
    /**
     * Establece el monto fraccionado resta.
     *
     * @param montoFraccionadoResta el new monto fraccionado resta
     */
    public void setMontoFraccionadoResta(BigDecimal montoFraccionadoResta) {
        this.montoFraccionadoResta = montoFraccionadoResta;
    }
    /**
     * Obtiene fecha vencimiento.
     *
     * @return fecha vencimiento
     */
     public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    /**
     * Establece el fecha vencimiento.
     *
     * @param fechaVencimiento el new fecha vencimiento
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    /**
     * Obtiene fecha creacion.
     *
     * @return fecha creacion
     */
     public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    /**
     * Establece el fecha creacion.
     *
     * @param fechaCreacion el new fecha creacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    /**
     * Obtiene usuario creacion.
     *
     * @return usuario creacion
     */
     public String getUsuarioCreacion() {
        return this.usuarioCreacion;
    }
    /**
     * Establece el usuario creacion.
     *
     * @param usuarioCreacion el new usuario creacion
     */
    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idFraccionamiento == null) ? 0 : idFraccionamiento.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Fraccionamiento other = (Fraccionamiento) obj;
        if (idFraccionamiento == null) {
            if (other.idFraccionamiento != null) {
                return false;
            }
        } else if (!idFraccionamiento.equals(other.idFraccionamiento)) {
            return false;
        }
        return true;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Fraccionamiento [idFraccionamiento=" + idFraccionamiento + "]";
    }
   
}