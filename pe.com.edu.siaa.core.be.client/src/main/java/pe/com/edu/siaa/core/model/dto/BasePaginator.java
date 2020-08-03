package pe.com.edu.siaa.core.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La Class BasePaginator.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * Mapfre. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Wed Sep 30 11:24:54 COT 2017
 * @since SIAA-CORE 2.1
 */
public class BasePaginator implements Serializable {
	
	/** La Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** La offset. */
	private int offset;
	
	/** La start row. */
	private int startRow;
	
	private String search;
	
	private boolean checked;
	
	private Integer varCantidad = 0;
	
	private String idUsuarioLogin = "";
	
	private Long idEmpresaSelect = 0L;
	
	private boolean esEliminado = false;
	
	private Object id;
	
	private Object idFiltro1;
	
	private Object idFiltro2;
	
	private String descripcionView;
	
	private String serviceKey = "";
	
	private String authToken;
	
	private String codigoGeneradoReporte = "";
	
	private String ip = "";
	
	private String tipo = "";
	
	private Object idPadreView;
	
	private String idEntidadSelect = "";
	
	private Date fechaUltimoAcceso;
	
	private Integer position = 0;
	
	private String select ="";
	
	private String update ="";
	
	private String insert ="";
	
    private String sistem ="";
	
	private String admin ="";
	
	private String conta ="";
	
	private String derech ="";
	
	private String todos ="";
	
	private Long idItemComodin ;
	
	private String idanhosemestreEgreso ="";
	
	private String idEscuelaEgresado ="";
	
	private String tieneBachiller ="";
	
	private String tieneTitulo ="";
	
	private List<String> ListidEgresados = null;
	
	private String name ="";
	
	private List<String> objeList = new ArrayList<>();
	
	private String hash_cpe ="";
	
	private String cod_sunat ="";
	
	private String msj_sunat ="";
	
	private String hash_cdr ="";
	
	private Date fechaActual;
	
	private String fechaMensual;
	
	private String fechaAnual;
	
	private BigDecimal montoTotalItem;
	
	private String nameImpresoraCaja ="";
	
	private String nameImpresoraCocina ="";
	/**
	 * Establece el start row.
	 *
	 * @param startRow el new start row
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * Obtiene start row.
	 *
	 * @return start row
	 */
	public int getStartRow() {
		return startRow;
	}

	/**
	 * Establece el offset.
	 *
	 * @param offset el new offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * Obtiene offset.
	 *
	 * @return offset
	 */
	public int getOffset() {
		return offset;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}
	
	

	public String getTodos() {
		return todos;
	}

	public void setTodos(String todos) {
		this.todos = todos;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getSistem() {
		return sistem;
	}

	public void setSistem(String sistem) {
		this.sistem = sistem;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getDerech() {
		return derech;
	}

	public void setDerech(String derech) {
		this.derech = derech;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Integer getVarCantidad() {
		return varCantidad;
	}

	public void setVarCantidad(Integer cantidad) {
		this.varCantidad = cantidad;
	}

	public String getIdUsuarioLogin() {
		return idUsuarioLogin;
	}

	public void setIdUsuarioLogin(String idUsuarioLogin) {
		this.idUsuarioLogin = idUsuarioLogin;
	}

	public boolean isEsEliminado() {
		return esEliminado;
	}

	public void setEsEliminado(boolean esEliminado) {
		this.esEliminado = esEliminado;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}
	
	

	public Object getIdFiltro1() {
		return idFiltro1;
	}

	public void setIdFiltro1(Object idFiltro1) {
		this.idFiltro1 = idFiltro1;
	}

	public Object getIdFiltro2() {
		return idFiltro2;
	}

	public void setIdFiltro2(Object idFiltro2) {
		this.idFiltro2 = idFiltro2;
	}

	public Long getIdEmpresaSelect() {
		return idEmpresaSelect;
	}

	public void setIdEmpresaSelect(Long idEmpresaSelect) {
		this.idEmpresaSelect = idEmpresaSelect;
	}

	public String getDescripcionView() {
		return descripcionView;
	}

	public void setDescripcionView(String descripcionView) {
		this.descripcionView = descripcionView;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getCodigoGeneradoReporte() {
		return codigoGeneradoReporte;
	}

	public void setCodigoGeneradoReporte(String codigoGeneradoReporte) {
		this.codigoGeneradoReporte = codigoGeneradoReporte;
	}

	public String getServiceKey() {
		return serviceKey;
	}

	public void setServiceKey(String serviceKey) {
		this.serviceKey = serviceKey;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Object getIdPadreView() {
		return idPadreView;
	}

	public void setIdPadreView(Object idPadreView) {
		this.idPadreView = idPadreView;
	}

	public String getIdEntidadSelect() {
		return idEntidadSelect;
	}

	public void setIdEntidadSelect(String idEntidadSelect) {
		this.idEntidadSelect = idEntidadSelect;
	}

	public Date getFechaUltimoAcceso() {
		return fechaUltimoAcceso;
	}

	public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
		this.fechaUltimoAcceso = fechaUltimoAcceso;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Long getIdItemComodin() {
		return idItemComodin;
	}

	public void setIdItemComodin(Long idItemComodin) {
		this.idItemComodin = idItemComodin;
	}

	public String getIdanhosemestreEgreso() {
		return idanhosemestreEgreso;
	}

	public void setIdanhosemestreEgreso(String idanhosemestreEgreso) {
		this.idanhosemestreEgreso = idanhosemestreEgreso;
	}

	public String getIdEscuelaEgresado() {
		return idEscuelaEgresado;
	}

	public void setIdEscuelaEgresado(String idEscuelaEgresado) {
		this.idEscuelaEgresado = idEscuelaEgresado;
	}

	public String getTieneBachiller() {
		return tieneBachiller;
	}

	public void setTieneBachiller(String tieneBachiller) {
		this.tieneBachiller = tieneBachiller;
	}

	public String getTieneTitulo() {
		return tieneTitulo;
	}

	public void setTieneTitulo(String tieneTitulo) {
		this.tieneTitulo = tieneTitulo;
	}

	public List<String> getListidEgresados() {
		return ListidEgresados;
	}

	public void setListidEgresados(List<String> listidEgresados) {
		ListidEgresados = listidEgresados;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getObjeList() {
		return objeList;
	}

	public void setObjeList(List<String> objeList) {
		this.objeList = objeList;
	}

	public String getHash_cpe() {
		return hash_cpe;
	}

	public void setHash_cpe(String hash_cpe) {
		this.hash_cpe = hash_cpe;
	}

	public String getCod_sunat() {
		return cod_sunat;
	}

	public void setCod_sunat(String cod_sunat) {
		this.cod_sunat = cod_sunat;
	}

	public String getMsj_sunat() {
		return msj_sunat;
	}

	public void setMsj_sunat(String msj_sunat) {
		this.msj_sunat = msj_sunat;
	}

	public String getHash_cdr() {
		return hash_cdr;
	}

	public void setHash_cdr(String hash_cdr) {
		this.hash_cdr = hash_cdr;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public String getFechaMensual() {
		return fechaMensual;
	}

	public void setFechaMensual(String fechaMensual) {
		this.fechaMensual = fechaMensual;
	}

	public String getFechaAnual() {
		return fechaAnual;
	}

	public void setFechaAnual(String fechaAnual) {
		this.fechaAnual = fechaAnual;
	}

	public BigDecimal getMontoTotalItem() {
		return montoTotalItem;
	}

	public void setMontoTotalItem(BigDecimal montoTotalItem) {
		this.montoTotalItem = montoTotalItem;
	}

	public String getNameImpresoraCaja() {
		return nameImpresoraCaja;
	}

	public void setNameImpresoraCaja(String nameImpresoraCaja) {
		this.nameImpresoraCaja = nameImpresoraCaja;
	}

	public String getNameImpresoraCocina() {
		return nameImpresoraCocina;
	}

	public void setNameImpresoraCocina(String nameImpresoraCocina) {
		this.nameImpresoraCocina = nameImpresoraCocina;
	}
	
	
	
	
}
