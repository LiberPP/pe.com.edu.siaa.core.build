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
@Table(name = "Credito", schema = ConfiguracionEntityManagerUtil.ESQUEMA_COOPERATIVA)
public class Credito implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id categoria. */
    @Id
    @Column(name = "idCredito" , length = 32)
    private String idCredito;
   
    /** El cliente. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVerificacionFisica", referencedColumnName = "idVerificacionFisica")
    private VerificacionFisica verificacionFisica;
    
    /** El cuota. */
    @Column(name = "formatoPago" , precision = 18)
    private BigDecimal formatoPago;
    
    /** El cuota. */
    @Column(name = "diasPagos" , precision = 18)
    private BigDecimal diasPagos;
    
    /** El cuota. */
    @Column(name = "monto" , precision = 18 , scale = 2)
    private BigDecimal monto;

    /** El interes. */
    @Column(name = "interes" , precision = 18 , scale = 2)
    private BigDecimal interes;
    
    /** El montototal. */
    @Column(name = "montoTotal" , precision = 18 , scale = 2)
    private BigDecimal montoTotal;
    
    /** El cuota. */
    @Column(name = "montoResta" , precision = 18 , scale = 2)
    private BigDecimal montoResta;
    
    /** El cuota. */
    @Column(name = "montoInteres" , precision = 18 , scale = 2)
    private BigDecimal montoInteres;
    
    /** El cuota. */
    @Column(name = "valorporCuota" , precision = 18 , scale = 2)
    private BigDecimal valorporCuota;
    
    /** El mora. */
    @Column(name = "mora" , precision = 18 , scale = 2)
    private BigDecimal mora;
    
    /** El cuota. */
    @Column(name = "limiteMonto" , precision = 18 , scale = 2)
    private BigDecimal limiteMonto;
    
    /** El fecha vencimiento. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;
    
    /** El fecha vencimiento. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechaprimerpago")
    private Date fechaprimerpago;
   
    /** El flag fraccionado. */
    @Column(name = "flagFraccionado" , length = 1)
    private String flagFraccionado;
    
    /** El flag fraccionado. */
    @Column(name = "descripcion" , length = 200)
    private String descripcion;
    
    /** El fecha vencimiento. */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name = "fechacontrato")
    private Date fechacontrato;
   
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
    
    /** El det plan pagos fraccionamiento list. */
    @OneToMany(mappedBy = "credito", fetch = FetchType.LAZY)
    private List<Fraccionamiento> detPlanPagosFraccionamientoList = new ArrayList<Fraccionamiento>();
    
    /**
     * Instancia un nuevo categoria.
     */
    public Credito() {
    }

	public Credito(String idCredito, VerificacionFisica verificacionFisica, BigDecimal formatoPago,
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

	public String getIdCredito() {
		return idCredito;
	}

	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	public VerificacionFisica getVerificacionFisica() {
		return verificacionFisica;
	}

	public void setVerificacionFisica(VerificacionFisica verificacionFisica) {
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

	public List<Fraccionamiento> getDetPlanPagosFraccionamientoList() {
		return detPlanPagosFraccionamientoList;
	}

	public void setDetPlanPagosFraccionamientoList(List<Fraccionamiento> detPlanPagosFraccionamientoList) {
		this.detPlanPagosFraccionamientoList = detPlanPagosFraccionamientoList;
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
		Credito other = (Credito) obj;
		if (idCredito == null) {
			if (other.idCredito != null)
				return false;
		} else if (!idCredito.equals(other.idCredito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credito [idCredito=" + idCredito + "]";
	}
	
    
}