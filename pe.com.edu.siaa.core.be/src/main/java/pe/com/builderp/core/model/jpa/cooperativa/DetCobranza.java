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
 * La Class DetControlPago.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Tue Apr 18 09:56:57 COT 2017
 * @since SIAA-CORE 2.1
 */
@Entity
@Table(name = "DetCobranza", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class DetCobranza implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id det control pago. */
    @Id
    @Column(name = "idDetCobranza" , length = 14)
    private String idDetCobranza;
   
    /** El control pago. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCobranza", referencedColumnName = "idCobranza")
    private Cobranza cobranza;

    /** El det plan pagos. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCredito", referencedColumnName = "idCredito")
    private Credito credito;
      
    /** El nro. */
    @Column(name = "nroCuota" , length = 5)
    private String nroCuota;
   
    /** El descripcionconcepto. */
    @Column(name = "descripcionConcepto" , length = 150)
    private String descripcionConcepto;
   
    /** El monto. */
    @Column(name = "monto" , precision = 18 , scale = 2)
    private BigDecimal monto;
   
    /** El mora. */
    @Column(name = "mora" , precision = 18 , scale = 2)
    private BigDecimal mora;
   
    /** El fecha reversion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaReversion")
    private Date fechaReversion;
   
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    @Column(name = "usuarioCreacion" , length = 50)
    private String usuarioCreacion;
   
    /** El fecha modificacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;
   
    /** El usuario modificacion. */
    @Column(name = "usuarioModificacion" , length = 50)
    private String usuarioModificacion;
   
    /** El estado. */
    @Column(name = "estado" , length = 1)
    private String estado;
   
    /** El ip. */
    @Column(name = "ip" , length = 150)
    private String ip;
   
    /**
     * Instancia un nuevo det control pago.
     */
    public DetCobranza() {
    }

	public DetCobranza(String idDetCobranza, Cobranza cobranza, Credito credito, String nroCuota,
			String descripcionConcepto, BigDecimal monto, BigDecimal mora, Date fechaReversion, Date fechaCreacion,
			String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, String estado, String ip) {
		super();
		this.idDetCobranza = idDetCobranza;
		this.cobranza = cobranza;
		this.credito = credito;
		this.nroCuota = nroCuota;
		this.descripcionConcepto = descripcionConcepto;
		this.monto = monto;
		this.mora = mora;
		this.fechaReversion = fechaReversion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
		this.ip = ip;
	}

	public String getIdDetCobranza() {
		return idDetCobranza;
	}

	public void setIdDetCobranza(String idDetCobranza) {
		this.idDetCobranza = idDetCobranza;
	}

	public Cobranza getCobranza() {
		return cobranza;
	}

	public void setCobranza(Cobranza cobranza) {
		this.cobranza = cobranza;
	}

	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	public String getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(String nroCuota) {
		this.nroCuota = nroCuota;
	}

	public String getDescripcionConcepto() {
		return descripcionConcepto;
	}

	public void setDescripcionConcepto(String descripcionConcepto) {
		this.descripcionConcepto = descripcionConcepto;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getMora() {
		return mora;
	}

	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}

	public Date getFechaReversion() {
		return fechaReversion;
	}

	public void setFechaReversion(Date fechaReversion) {
		this.fechaReversion = fechaReversion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetCobranza == null) ? 0 : idDetCobranza.hashCode());
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
		DetCobranza other = (DetCobranza) obj;
		if (idDetCobranza == null) {
			if (other.idDetCobranza != null)
				return false;
		} else if (!idDetCobranza.equals(other.idDetCobranza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetCobranza [idDetCobranza=" + idDetCobranza + "]";
	}
   
 
}