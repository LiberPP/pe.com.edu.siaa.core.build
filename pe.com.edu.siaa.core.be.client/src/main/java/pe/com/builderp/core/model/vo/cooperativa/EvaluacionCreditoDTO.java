package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.edu.siaa.core.model.dto.BasePaginator; 
import pe.com.edu.siaa.core.model.vo.SelectItemVO;

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
public class EvaluacionCreditoDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    private String idEvaluacionCredito;
   
    private ClienteDTO cliente;
    
    private String tipoPersona;
    
    private String tipoCredito;
    
    private Date fechaEvaluacion;
    
    private String codigo;
    
    private String descripcion;
    
    private String tipoVivienda;    
    
    private String condicionLaboral;  
    
    private String calificaVerificacion;  
    
    /** El compra detalle compra list. */
    private List<ReferenciaPersonalDTO> referenciaPersonalDTOList = new ArrayList<ReferenciaPersonalDTO>();
    
    /** El compra detalle compra list. */
    private List<InformacionLaboralDTO> informacionLaboralList = new ArrayList<InformacionLaboralDTO>();
    
    /** El compra detalle compra list. */
    private List<AvalDatosDTO> avalDatosList = new ArrayList<AvalDatosDTO>();
 
	    /** El postulante documento requerido list. */
	private List<SelectItemVO> listaDocumentoRequerido = new ArrayList<SelectItemVO>();
	 
	 
	private List<DocumentoRequeridoDTO> listaDocumentoRequeridoPer = new ArrayList<DocumentoRequeridoDTO>();
    
    /**
     * Instancia un nuevo categoria.
     */
    public EvaluacionCreditoDTO() {
    }

	public EvaluacionCreditoDTO(String idEvaluacionCredito, ClienteDTO cliente, String tipoPersona,
			String tipoCredito, Date fechaEvaluacion, String codigo, String descripcion,String tipoVivienda,
			String condicionLaboral,String calificaVerificacion) {
		super();
		this.idEvaluacionCredito = idEvaluacionCredito;
		this.cliente = cliente;
		this.tipoPersona = tipoPersona;
		this.tipoCredito = tipoCredito;
		this.fechaEvaluacion = fechaEvaluacion;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipoVivienda=tipoVivienda;
		this.condicionLaboral=condicionLaboral;
		this.calificaVerificacion=calificaVerificacion;
	}

	
	
	
	


	public List<AvalDatosDTO> getAvalDatosList() {
		return avalDatosList;
	}

	public void setAvalDatosList(List<AvalDatosDTO> avalDatosList) {
		this.avalDatosList = avalDatosList;
	}

	public List<DocumentoRequeridoDTO> getListaDocumentoRequeridoPer() {
		return listaDocumentoRequeridoPer;
	}

	public void setListaDocumentoRequeridoPer(List<DocumentoRequeridoDTO> listaDocumentoRequeridoPer) {
		this.listaDocumentoRequeridoPer = listaDocumentoRequeridoPer;
	}

	public String getCondicionLaboral() {
		return condicionLaboral;
	}

	public void setCondicionLaboral(String condicionLaboral) {
		this.condicionLaboral = condicionLaboral;
	}

	public String getCalificaVerificacion() {
		return calificaVerificacion;
	}

	public void setCalificaVerificacion(String calificaVerificacion) {
		this.calificaVerificacion = calificaVerificacion;
	}

	public String getTipoVivienda() {
		return tipoVivienda;
	}

	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}

	public List<SelectItemVO> getListaDocumentoRequerido() {
		return listaDocumentoRequerido;
	}

	public void setListaDocumentoRequerido(List<SelectItemVO> listaDocumentoRequerido) {
		this.listaDocumentoRequerido = listaDocumentoRequerido;
	}

	public List<ReferenciaPersonalDTO> getReferenciaPersonalDTOList() {
		return referenciaPersonalDTOList;
	}

	public void setReferenciaPersonalDTOList(List<ReferenciaPersonalDTO> referenciaPersonalDTOList) {
		this.referenciaPersonalDTOList = referenciaPersonalDTOList;
	}
 
	
	public List<InformacionLaboralDTO> getInformacionLaboralList() {
		return informacionLaboralList;
	}

	public void setInformacionLaboralList(List<InformacionLaboralDTO> informacionLaboralList) {
		this.informacionLaboralList = informacionLaboralList;
	}

	public String getIdEvaluacionCredito() {
		return idEvaluacionCredito;
	}

	public void setIdEvaluacionCredito(String idEvaluacionCredito) {
		this.idEvaluacionCredito = idEvaluacionCredito;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}


	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

 
	
	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvaluacionCredito == null) ? 0 : idEvaluacionCredito.hashCode());
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
		EvaluacionCreditoDTO other = (EvaluacionCreditoDTO) obj;
		if (idEvaluacionCredito == null) {
			if (other.idEvaluacionCredito != null)
				return false;
		} else if (!idEvaluacionCredito.equals(other.idEvaluacionCredito))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvaluacionCreditoDTO [idEvaluacionCredito=" + idEvaluacionCredito + "]";
	}
 
}