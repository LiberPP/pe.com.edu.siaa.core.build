package pe.com.edu.siaa.core.model.vo;

import java.io.Serializable;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

public class EgresadoFiltroVO extends BasePaginator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer creditoAcumulado;
	private String idEntidad;
	private String idEscuela;
	private String idAnhoSemestre;
	private String idEgresado;
	private String idAlumno;
	private Long idItem;
	private String idFiltro;
	private String idUsuario;
	
	private Long entidad;
	private Long idCiclo;
	private Long idTurno;
	private String idPersonal;
	private String tipoHorario;
	
	public EgresadoFiltroVO() {
		super();
	}

	


	public Long getEntidad() {
		return entidad;
	}




	public void setEntidad(Long entidad) {
		this.entidad = entidad;
	}




	public Long getIdCiclo() {
		return idCiclo;
	}




	public void setIdCiclo(Long idCiclo) {
		this.idCiclo = idCiclo;
	}




	public Long getIdTurno() {
		return idTurno;
	}




	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}




	public String getIdPersonal() {
		return idPersonal;
	}




	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}




	public String getTipoHorario() {
		return tipoHorario;
	}




	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}




	public String getIdEntidad() {
		return idEntidad;
	}


	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}



	public String getIdAnhoSemestre() {
		return idAnhoSemestre;
	}


	public void setIdAnhoSemestre(String idAnhoSemestre) {
		this.idAnhoSemestre = idAnhoSemestre;
	}



	public Integer getCreditoAcumulado() {
		return creditoAcumulado;
	}



	public void setCreditoAcumulado(Integer creditoAcumulado) {
		this.creditoAcumulado = creditoAcumulado;
	}



	public String getIdEscuela() {
		return idEscuela;
	}



	public void setIdEscuela(String idEscuela) {
		this.idEscuela = idEscuela;
	}



	public String getIdEgresado() {
		return idEgresado;
	}



	public void setIdEgresado(String idEgresado) {
		this.idEgresado = idEgresado;
	}



	public String getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}



	public Long getIdItem() {
		return idItem;
	}



	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}



	public String getIdFiltro() {
		return idFiltro;
	}



	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro;
	}



	public String getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	

}
