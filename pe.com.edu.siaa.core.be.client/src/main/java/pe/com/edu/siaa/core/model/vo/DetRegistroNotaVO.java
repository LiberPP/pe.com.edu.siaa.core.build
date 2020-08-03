package pe.com.edu.siaa.core.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

public class DetRegistroNotaVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idDetRegistroNota;
	private String idRegistroNota;
	private String idAlumno;
	private String idEscuela;
	private String idDetCargaLectiva;
	private String idCargaLectiva;
	private BigDecimal idNotaLetra;
	private BigDecimal idNotaLetraAplazado;
	private String idDetMatricula;
	private String idMatricula;
	private String idPlanEstudio;
	
	private List<CursoNotaVO> cursoNotaEvaluar = new ArrayList<CursoNotaVO>();
	
	public DetRegistroNotaVO() {
		super();
	}

	
	public String getIdPlanEstudio() {
		return idPlanEstudio;
	}


	public void setIdPlanEstudio(String idPlanEstudio) {
		this.idPlanEstudio = idPlanEstudio;
	}


	public String getIdRegistroNota() {
		return idRegistroNota;
	}


	public void setIdRegistroNota(String idRegistroNota) {
		this.idRegistroNota = idRegistroNota;
	}


	public String getIdDetRegistroNota() {
		return idDetRegistroNota;
	}

	public void setIdDetRegistroNota(String idDetRegistroNota) {
		this.idDetRegistroNota = idDetRegistroNota;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getIdEscuela() {
		return idEscuela;
	}

	public void setIdEscuela(String idEscuela) {
		this.idEscuela = idEscuela;
	}

	public String getIdDetCargaLectiva() {
		return idDetCargaLectiva;
	}

	public void setIdDetCargaLectiva(String idDetCargaLectiva) {
		this.idDetCargaLectiva = idDetCargaLectiva;
	}

	public String getIdCargaLectiva() {
		return idCargaLectiva;
	}

	public void setIdCargaLectiva(String idCargaLectiva) {
		this.idCargaLectiva = idCargaLectiva;
	}

	public BigDecimal getIdNotaLetra() {
		return idNotaLetra;
	}

	public void setIdNotaLetra(BigDecimal idNotaLetra) {
		this.idNotaLetra = idNotaLetra;
	}

	public BigDecimal getIdNotaLetraAplazado() {
		return idNotaLetraAplazado;
	}

	public void setIdNotaLetraAplazado(BigDecimal idNotaLetraAplazado) {
		this.idNotaLetraAplazado = idNotaLetraAplazado;
	}

	public String getIdDetMatricula() {
		return idDetMatricula;
	}

	public void setIdDetMatricula(String idDetMatricula) {
		this.idDetMatricula = idDetMatricula;
	}

	public String getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(String idMatricula) {
		this.idMatricula = idMatricula;
	}

	public List<CursoNotaVO> getCursoNotaEvaluar() {
		return cursoNotaEvaluar;
	}

	public void setCursoNotaEvaluar(List<CursoNotaVO> cursoNotaEvaluar) {
		this.cursoNotaEvaluar = cursoNotaEvaluar;
	}

	
 
}
