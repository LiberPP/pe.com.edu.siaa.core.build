package pe.com.builderp.core.model.vo.cooperativa;

import java.io.Serializable;
import java.math.BigDecimal; 

import pe.com.edu.siaa.core.model.dto.BasePaginator;

public class IngresoVoDTO extends BasePaginator implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private String cliente;
	private String descripcionConcepto;
	private String userName;
	private BigDecimal monto;
	private String fechaPago;

	
	
	public IngresoVoDTO() {
		super();
	}
	
	



	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
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



	public String getFechaPago() {
		return fechaPago;
	}



	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}



	
}
