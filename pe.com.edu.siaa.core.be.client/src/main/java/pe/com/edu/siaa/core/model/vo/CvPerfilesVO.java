package pe.com.edu.siaa.core.model.vo;

import java.io.Serializable;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

public class CvPerfilesVO extends BasePaginator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idEgresado;
	private String idAlumno;
	private String idAnhoSemestre;
	
	
	public CvPerfilesVO() {
		super();
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


	public String getIdAnhoSemestre() {
		return idAnhoSemestre;
	}


	public void setIdAnhoSemestre(String idAnhoSemestre) {
		this.idAnhoSemestre = idAnhoSemestre;
	}




}
