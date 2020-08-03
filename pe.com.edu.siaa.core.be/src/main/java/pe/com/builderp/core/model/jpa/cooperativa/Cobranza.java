package pe.com.builderp.core.model.jpa.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.builderp.core.facturacion.model.jpa.venta.Cliente; 
import pe.com.edu.siaa.core.model.jpa.common.Item; 
import pe.com.edu.siaa.core.model.util.ConfiguracionEntityManagerUtil;

/**
 * La Class ControlPago.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Fri Dec 15 11:01:56 COT 2017
 * @since SIAA-CORE 2.1
 */
@Entity
@Table(name = "Cobranza", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class Cobranza implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id control pago. */
    @Id
    @Column(name = "idCobranza" , length = 12)
    private String idCobranza;
    
   
    /** El item by tipo moneda. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMoneda", referencedColumnName = "idItem")
    private Item itemByTipoMoneda;
   
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
   
    /** El tipo cambio. */
    @Column(name = "tipoCambio" , precision = 18 , scale = 2)
    private BigDecimal tipoCambio;
   
    /** El nro doc. */
    @Column(name = "nroDoc" , length = 50)
    private String nroDoc;
   
    /** El sub monto total. */
    @Column(name = "subMontoTotal" , precision = 18 , scale = 2)
    private BigDecimal subMontoTotal;
   
    /** El monto total. */
    @Column(name = "montoTotal" , precision = 18 , scale = 2)
    private BigDecimal montoTotal;
   
    /** El fecha pago. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaPago")
    private Date fechaPago;
   
    /** El fecha creacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
   
    /** El usuario creacion. */
    @Column(name = "usuarioCreacion" , length = 50)
    private String usuarioCreacion;
   
    /** El fecha modificacion. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechamodificacion")
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
    
    /** El usuario modificacion. */
    @Column(name = "observacion" , length = 500)
    private String observacion;

    /** El usuario modificacion. */
    @Column(name = "nroTicket" , length = 32)
    private String nroTicket;
    
    
    /** El usuario modificacion. */
    @Column(name = "formaPago" , length = 32)
    private String formaPago;
    
    /** El usuario modificacion. */
    @Column(name = "nroBaucher" , length = 32)
    private String nroBaucher;
   
    
    /** El control pago det control pago list. */
    @OneToMany(mappedBy = "cobranza", fetch = FetchType.LAZY)
    private List<DetCobranza> controlPagoDetControlPagoList = new ArrayList<DetCobranza>();
    
    /**
     * Instancia un nuevo control pago.
     */
    public Cobranza() {
    }

	public Cobranza(String idCobranza, Item itemByTipoMoneda, Cliente cliente, BigDecimal tipoCambio, String nroDoc,
			BigDecimal subMontoTotal, BigDecimal montoTotal, Date fechaPago, Date fechaCreacion, String usuarioCreacion,
			Date fechaModificacion, String usuarioModificacion, String estado, String ip, String observacion,
			String nroTicket,String formaPago,String nroBaucher) {
		super();
		this.idCobranza = idCobranza;
		this.itemByTipoMoneda = itemByTipoMoneda;
		this.cliente = cliente;
		this.tipoCambio = tipoCambio;
		this.nroDoc = nroDoc;
		this.subMontoTotal = subMontoTotal;
		this.montoTotal = montoTotal;
		this.fechaPago = fechaPago;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.estado = estado;
		this.ip = ip;
		this.observacion = observacion; 
		this.nroTicket=nroTicket;
		this.formaPago=formaPago;
		this.nroBaucher=nroBaucher;
				
	}
	
	

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getNroBaucher() {
		return nroBaucher;
	}

	public void setNroBaucher(String nroBaucher) {
		this.nroBaucher = nroBaucher;
	}

	public String getNroTicket() {
		return nroTicket;
	}

	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public String getIdCobranza() {
		return idCobranza;
	}

	public void setIdCobranza(String idCobranza) {
		this.idCobranza = idCobranza;
	}

	public Item getItemByTipoMoneda() {
		return itemByTipoMoneda;
	}

	public void setItemByTipoMoneda(Item itemByTipoMoneda) {
		this.itemByTipoMoneda = itemByTipoMoneda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public BigDecimal getSubMontoTotal() {
		return subMontoTotal;
	}

	public void setSubMontoTotal(BigDecimal subMontoTotal) {
		this.subMontoTotal = subMontoTotal;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<DetCobranza> getControlPagoDetControlPagoList() {
		return controlPagoDetControlPagoList;
	}

	public void setControlPagoDetControlPagoList(List<DetCobranza> controlPagoDetControlPagoList) {
		this.controlPagoDetControlPagoList = controlPagoDetControlPagoList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCobranza == null) ? 0 : idCobranza.hashCode());
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
		Cobranza other = (Cobranza) obj;
		if (idCobranza == null) {
			if (other.idCobranza != null)
				return false;
		} else if (!idCobranza.equals(other.idCobranza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cobranza [idCobranza=" + idCobranza + "]";
	}

	 
}