package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.com.edu.siaa.core.model.dto.BasePaginator; 

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
public class CreditoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    private String idCredito;
    
    private VerificacionFisicaDTO verificacionFisica;
    
    private BigDecimal formatoPago;
    
    private BigDecimal diasPagos;
    
    private BigDecimal monto;
    
    private BigDecimal interes;
    
    private BigDecimal montoTotal;
    
    private BigDecimal montoResta;
    
    private BigDecimal montoInteres;
    
    private BigDecimal valorporCuota;
    
    private BigDecimal mora;
    
    private BigDecimal limiteMonto;
    
    private Date fechaVencimiento;
    
    private Date fechaprimerpago;
    
    private String flagFraccionado;
    
    private String descripcion;
    
    private Date fechacontrato;
    
    private Date fechaCreacion;
    
    private String usuarioCreacion;
    
    private Date fechaModificacion;
    
    private String usuarioModificacion;
    
    /** El det plan pagos fraccionamiento list. */
    private List<FraccionamientoDTO> listaFraccionamientos = new ArrayList<FraccionamientoDTO>();
    
    /** La flag fraccionado descripcion. */
	private String flagFraccionadoDescripcion;
	
    private Long numeroDiasRetrazo = 0L;
    
    private BigDecimal saldoMonto;
    
    private BigDecimal montoPagar;
    
    private String estadoPrestamo;
	
    /**
     * Instancia un nuevo categoria.
     */
    public CreditoDTO() {
    }

	public CreditoDTO(String idCredito, VerificacionFisicaDTO verificacionFisica, BigDecimal formatoPago,
			BigDecimal diasPagos, BigDecimal monto, BigDecimal interes, BigDecimal montoTotal, BigDecimal montoResta,
			BigDecimal montoInteres, BigDecimal valorporCuota, BigDecimal mora, BigDecimal limiteMonto,
			Date fechaVencimiento, Date fechaprimerpago, String flagFraccionado, String descripcion, Date fechacontrato,
			Date fechaCreacion, String usuarioCreacion, Date fechaModificacion, String usuarioModificacion) {
		super();
		this.idCredito = idCredito;
		this.verificacionFisica = verificacionFisica;
		this.formatoPago = formatoPago;
		this.diasPagos = diasPagos;
		this.monto = monto;
		this.interes = interes;
		this.montoTotal = montoTotal;
		this.montoResta = montoResta;
		this.montoInteres = montoInteres;
		this.valorporCuota = valorporCuota;
		this.mora = mora;
		this.limiteMonto = limiteMonto;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaprimerpago = fechaprimerpago;
		this.flagFraccionado = flagFraccionado;
		this.descripcion = descripcion;
		this.fechacontrato = fechacontrato;
		this.fechaCreacion = fechaCreacion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}
	
	
	
	public Long getNumeroDiasRetrazo() {
		return numeroDiasRetrazo;
	}

	public void setNumeroDiasRetrazo(Long numeroDiasRetrazo) {
		this.numeroDiasRetrazo = numeroDiasRetrazo;
	}

	public BigDecimal getSaldoMonto() {
		return saldoMonto;
	}

	public void setSaldoMonto(BigDecimal saldoMonto) {
		this.saldoMonto = saldoMonto;
	}

	public BigDecimal getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(BigDecimal montoPagar) {
		this.montoPagar = montoPagar;
	}

	public String getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(String estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public String getFlagFraccionadoDescripcion() {
		return flagFraccionadoDescripcion;
	}

	public void setFlagFraccionadoDescripcion(String flagFraccionadoDescripcion) {
		this.flagFraccionadoDescripcion = flagFraccionadoDescripcion;
	}

	public List<FraccionamientoDTO> getListaFraccionamientos() {
		return listaFraccionamientos;
	}

	public void setListaFraccionamientos(List<FraccionamientoDTO> listaFraccionamientos) {
		this.listaFraccionamientos = listaFraccionamientos;
	}

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public VerificacionFisicaDTO getVerificacionFisica() {
		return verificacionFisica;
	}

	public void setVerificacionFisica(VerificacionFisicaDTO verificacionFisica) {
		this.verificacionFisica = verificacionFisica;
	}

	public BigDecimal getFormatoPago() {
		return formatoPago;
	}

	public void setFormatoPago(BigDecimal formatoPago) {
		this.formatoPago = formatoPago;
	}

	public BigDecimal getDiasPagos() {
		return diasPagos;
	}

	public void setDiasPagos(BigDecimal diasPagos) {
		this.diasPagos = diasPagos;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public BigDecimal getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}

	public BigDecimal getMontoResta() {
		return montoResta;
	}

	public void setMontoResta(BigDecimal montoResta) {
		this.montoResta = montoResta;
	}

	public BigDecimal getMontoInteres() {
		return montoInteres;
	}

	public void setMontoInteres(BigDecimal montoInteres) {
		this.montoInteres = montoInteres;
	}

	public BigDecimal getValorporCuota() {
		return valorporCuota;
	}

	public void setValorporCuota(BigDecimal valorporCuota) {
		this.valorporCuota = valorporCuota;
	}

	public BigDecimal getMora() {
		return mora;
	}

	public void setMora(BigDecimal mora) {
		this.mora = mora;
	}

	public BigDecimal getLimiteMonto() {
		return limiteMonto;
	}

	public void setLimiteMonto(BigDecimal limiteMonto) {
		this.limiteMonto = limiteMonto;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaprimerpago() {
		return fechaprimerpago;
	}

	public void setFechaprimerpago(Date fechaprimerpago) {
		this.fechaprimerpago = fechaprimerpago;
	}

	public String getFlagFraccionado() {
		return flagFraccionado;
	}

	public void setFlagFraccionado(String flagFraccionado) {
		this.flagFraccionado = flagFraccionado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechacontrato() {
		return fechacontrato;
	}

	public void setFechacontrato(Date fechacontrato) {
		this.fechacontrato = fechacontrato;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCredito == null) ? 0 : idCredito.hashCode());
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
		CreditoDTO other = (CreditoDTO) obj;
		if (idCredito == null) {
			if (other.idCredito != null)
				return false;
		} else if (!idCredito.equals(other.idCredito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CreditoDTO [idCredito=" + idCredito + "]";
	}

	
}