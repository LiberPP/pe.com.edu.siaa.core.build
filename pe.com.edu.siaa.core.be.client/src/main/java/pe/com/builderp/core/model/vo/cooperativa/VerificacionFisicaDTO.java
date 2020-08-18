package pe.com.builderp.core.model.vo.cooperativa;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import pe.com.edu.siaa.core.model.dto.BasePaginator;
import pe.com.edu.siaa.core.model.dto.seguridad.UsuarioDTO;
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
public class VerificacionFisicaDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    private String idVerificacionFisica;
   
    private EvaluacionCreditoDTO evaluacionCredito;
    
    private Date fechaCreacion;
    
    private Date fechaVerificacion;
    
    private UsuarioDTO verificador;
    
    private String estado;
    
    private String observacion;
    
    private String codigo;
    
    private String hora;
    
    
    private List<ImagenAdjuntoDTO> listaImgaenAdjunto = new ArrayList<ImagenAdjuntoDTO>();
    
    /** El compra detalle compra list. */
    private List<InformacionLaboralDTO> informacionLaboralAvalList = new ArrayList<InformacionLaboralDTO>(); 
 
	    /** El postulante documento requerido list. */
	private List<SelectItemVO> listaDocumentoRequeridoAval = new ArrayList<SelectItemVO>();
    
    /**
     * Instancia un nuevo categoria.
     */
    public VerificacionFisicaDTO() {
    }

	public VerificacionFisicaDTO(String idVerificacionFisica, EvaluacionCreditoDTO evaluacionCredito,
			Date fechaCreacion, Date fechaVerificacion, UsuarioDTO verificador, String estado, String observacion,String codigo,
			String hora) {
		super();
		this.idVerificacionFisica = idVerificacionFisica;
		this.evaluacionCredito = evaluacionCredito;
		this.fechaCreacion = fechaCreacion;
		this.fechaVerificacion = fechaVerificacion;
		this.verificador = verificador;
		this.estado = estado;
		this.observacion = observacion;
		this.codigo=codigo;
		this.hora=hora;
	}
	
	
	

	public List<InformacionLaboralDTO> getInformacionLaboralAvalList() {
		return informacionLaboralAvalList;
	}

	public void setInformacionLaboralAvalList(List<InformacionLaboralDTO> informacionLaboralAvalList) {
		this.informacionLaboralAvalList = informacionLaboralAvalList;
	}

	public List<SelectItemVO> getListaDocumentoRequeridoAval() {
		return listaDocumentoRequeridoAval;
	}

	public void setListaDocumentoRequeridoAval(List<SelectItemVO> listaDocumentoRequeridoAval) {
		this.listaDocumentoRequeridoAval = listaDocumentoRequeridoAval;
	}

	public List<ImagenAdjuntoDTO> getListaImgaenAdjunto() {
		return listaImgaenAdjunto;
	}

	public void setListaImgaenAdjunto(List<ImagenAdjuntoDTO> listaImgaenAdjunto) {
		this.listaImgaenAdjunto = listaImgaenAdjunto;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdVerificacionFisica() {
		return idVerificacionFisica;
	}

	public void setIdVerificacionFisica(String idVerificacionFisica) {
		this.idVerificacionFisica = idVerificacionFisica;
	}

	public EvaluacionCreditoDTO getEvaluacionCredito() {
		return evaluacionCredito;
	}

	public void setEvaluacionCredito(EvaluacionCreditoDTO evaluacionCredito) {
		this.evaluacionCredito = evaluacionCredito;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaVerificacion() {
		return fechaVerificacion;
	}

	public void setFechaVerificacion(Date fechaVerificacion) {
		this.fechaVerificacion = fechaVerificacion;
	}

	public UsuarioDTO getVerificador() {
		return verificador;
	}

	public void setVerificador(UsuarioDTO verificador) {
		this.verificador = verificador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVerificacionFisica == null) ? 0 : idVerificacionFisica.hashCode());
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
		VerificacionFisicaDTO other = (VerificacionFisicaDTO) obj;
		if (idVerificacionFisica == null) {
			if (other.idVerificacionFisica != null)
				return false;
		} else if (!idVerificacionFisica.equals(other.idVerificacionFisica))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VerificacionFisicaDTO [idVerificacionFisica=" + idVerificacionFisica + "]";
	}
}