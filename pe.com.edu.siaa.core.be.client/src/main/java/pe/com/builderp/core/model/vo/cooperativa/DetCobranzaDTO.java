package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

/**
 * La Class DetControlPagoDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Tue Apr 18 09:56:57 COT 2017
 * @since SIAA-CORE 2.1
 */
public class DetCobranzaDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id det control pago. */
    private String idDetCobranza;
   
    /** El control pago. */
    private CobranzaDTO cobranza;
   
    /** El det plan pagos. */
    private CreditoDTO credito;
   
    /** El fraccionamiento. */
    private String nroCuota;
   
    /** El descripcionconcepto. */
    private String descripcionConcepto;
   
    /** El monto. */
    private BigDecimal monto;
   
    /** El mora. */
    private BigDecimal mora;
   
    /** El fecha reversion. */
    private Date fechaReversion;
   
    /** El fecha creacion. */
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    private String usuarioCreacion;
   
    /** El fecha modificacion. */
    private Date fechaModificacion;
   
    /** El usuario modificacion. */
    private String usuarioModificacion;
   
    /** El estado. */
    private String estado;
   
    /** El ip. */
    private String ip;
   
    /**
     * Instancia un nuevo det control pagoDTO.
     */
    public DetCobranzaDTO() {
    }

	public DetCobranzaDTO(String idDetCobranza, CobranzaDTO cobranza, CreditoDTO credito, String nroCuota,
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

	public CobranzaDTO getCobranza() {
		return cobranza;
	}

	public void setCobranza(CobranzaDTO cobranza) {
		this.cobranza = cobranza;
	}

	public CreditoDTO getCredito() {
		return credito;
	}

	public void setCredito(CreditoDTO credito) {
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
		DetCobranzaDTO other = (DetCobranzaDTO) obj;
		if (idDetCobranza == null) {
			if (other.idDetCobranza != null)
				return false;
		} else if (!idDetCobranza.equals(other.idDetCobranza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetCobranzaDTO [idDetCobranza=" + idDetCobranza + "]";
	}
   
    
}