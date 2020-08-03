package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.edu.siaa.core.model.dto.BasePaginator; 
import pe.com.edu.siaa.core.model.dto.common.ItemDTO; 

/**
 * La Class ControlPagoDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Fri Dec 15 11:57:51 COT 2017
 * @since SIAA-CORE 2.1
 */
public class CobranzaDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id control pago. */
    private String idCobranza;
   
    /** El item by tipo moneda. */
    private ItemDTO itemByTipoMoneda;
   
    /** El cliente. */
    private ClienteDTO cliente;
   
    /** El tipo cambio. */
    private BigDecimal tipoCambio;
   
    /** El nro doc. */
    private String nroDoc;
   
    /** El sub monto total. */
    private BigDecimal subMontoTotal;
   
    /** El monto total. */
    private BigDecimal montoTotal;
   
    /** El fecha pago. */
    private Date fechaPago;
   
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
    
    private String observacion;
    
    private String nroTicket;
    
    private String formaPago;
    
    private String nroBaucher;
   
    /** El control pago det control pago list. */
    private List<DetCobranzaDTO> controlPagoDetControlPagoList = new ArrayList<DetCobranzaDTO>();
  
    
    private List<ConceptoCobranzaDTO> listaConceptoPagoDTO = new ArrayList<ConceptoCobranzaDTO>();
    
    private BigDecimal montoresta;
    
    private BigDecimal montototalDet;
    
    private Long numeroDiasRetrazo = 0L;
     
    
    
    /**
     * Instancia un nuevo control pagoDTO.
     */
    public CobranzaDTO() {
    }



	public CobranzaDTO(String idCobranza, ItemDTO itemByTipoMoneda, ClienteDTO cliente, BigDecimal tipoCambio,
			String nroDoc, BigDecimal subMontoTotal, BigDecimal montoTotal, Date fechaPago, Date fechaCreacion,
			String usuarioCreacion, Date fechaModificacion, String usuarioModificacion, String estado, String ip,
			String observacion,String nroTicket,String formaPago,String nroBaucher) {
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



	public List<ConceptoCobranzaDTO> getListaConceptoPagoDTO() {
		return listaConceptoPagoDTO;
	}



	public void setListaConceptoPagoDTO(List<ConceptoCobranzaDTO> listaConceptoPagoDTO) {
		this.listaConceptoPagoDTO = listaConceptoPagoDTO;
	}



	public String getIdCobranza() {
		return idCobranza;
	}



	public void setIdCobranza(String idCobranza) {
		this.idCobranza = idCobranza;
	}



	public ItemDTO getItemByTipoMoneda() {
		return itemByTipoMoneda;
	}



	public void setItemByTipoMoneda(ItemDTO itemByTipoMoneda) {
		this.itemByTipoMoneda = itemByTipoMoneda;
	}



	public ClienteDTO getCliente() {
		return cliente;
	}



	public void setCliente(ClienteDTO cliente) {
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



	public List<DetCobranzaDTO> getControlPagoDetControlPagoList() {
		return controlPagoDetControlPagoList;
	}



	public void setControlPagoDetControlPagoList(List<DetCobranzaDTO> controlPagoDetControlPagoList) {
		this.controlPagoDetControlPagoList = controlPagoDetControlPagoList;
	}



 

	public BigDecimal getMontoresta() {
		return montoresta;
	}



	public void setMontoresta(BigDecimal montoresta) {
		this.montoresta = montoresta;
	}



	public BigDecimal getMontototalDet() {
		return montototalDet;
	}



	public void setMontototalDet(BigDecimal montototalDet) {
		this.montototalDet = montototalDet;
	}



	public Long getNumeroDiasRetrazo() {
		return numeroDiasRetrazo;
	}



	public void setNumeroDiasRetrazo(Long numeroDiasRetrazo) {
		this.numeroDiasRetrazo = numeroDiasRetrazo;
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
		CobranzaDTO other = (CobranzaDTO) obj;
		if (idCobranza == null) {
			if (other.idCobranza != null)
				return false;
		} else if (!idCobranza.equals(other.idCobranza))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "CobranzaDTO [idCobranza=" + idCobranza + "]";
	}
    
    
}