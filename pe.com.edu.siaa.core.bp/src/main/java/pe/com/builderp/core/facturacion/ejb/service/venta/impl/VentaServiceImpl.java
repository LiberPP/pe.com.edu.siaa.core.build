package pe.com.builderp.core.facturacion.ejb.service.venta.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import pe.com.builderp.core.contabilidad.model.vo.RegistroAsientoFiltroVO;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.AvalDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.CategoriaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ClienteDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ConfiguracionAtributoDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ConfiguracionAtributoValueDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetallePedidoDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleProformaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.DetalleVentaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.LineaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.MarcaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ModeloDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.PedidoDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProductoDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.ProformaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.TipoDocSunatEntidadDaoLocal;
import pe.com.builderp.core.facturacion.ejb.dao.venta.local.VentaDaoLocal;
import pe.com.builderp.core.facturacion.ejb.service.venta.local.VentaServiceLocal;
import pe.com.builderp.core.facturacion.model.dto.venta.AvalDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.CategoriaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ClienteDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ConfiguracionAtributoDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ConfiguracionAtributoValueDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.DetallePedidoDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.DetalleProformaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.DetalleVentaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.LineaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.MarcaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ModeloDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.PedidoDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ProductoDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.ProformaDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.TipoDocSunatEntidadDTO;
import pe.com.builderp.core.facturacion.model.dto.venta.VentaDTO;
import pe.com.builderp.core.facturacion.model.jpa.venta.Categoria;
import pe.com.builderp.core.facturacion.model.jpa.venta.Cliente;
import pe.com.builderp.core.facturacion.model.jpa.venta.Aval;
import pe.com.builderp.core.facturacion.model.jpa.venta.ConfiguracionAtributo;
import pe.com.builderp.core.facturacion.model.jpa.venta.ConfiguracionAtributoValue;
import pe.com.builderp.core.facturacion.model.jpa.venta.DetallePedido;
import pe.com.builderp.core.facturacion.model.jpa.venta.DetalleProforma;
import pe.com.builderp.core.facturacion.model.jpa.venta.DetalleVenta;
import pe.com.builderp.core.facturacion.model.jpa.venta.Linea;
import pe.com.builderp.core.facturacion.model.jpa.venta.Marca;
import pe.com.builderp.core.facturacion.model.jpa.venta.Modelo;
import pe.com.builderp.core.facturacion.model.jpa.venta.Pedido;
import pe.com.builderp.core.facturacion.model.jpa.venta.Producto;
import pe.com.builderp.core.facturacion.model.jpa.venta.Proforma;
import pe.com.builderp.core.facturacion.model.jpa.venta.TipoDocSunatEntidad;
import pe.com.builderp.core.facturacion.model.jpa.venta.Venta;
import pe.com.builderp.core.facturacion.model.vo.venta.RegistroVentaVO;
import pe.com.edu.siaa.core.ejb.dao.seguridad.local.UsuarioDaoLocal;
import pe.com.edu.siaa.core.ejb.factory.CollectionUtil;
import pe.com.edu.siaa.core.ejb.factory.TransferDataObjectUtil;
import pe.com.edu.siaa.core.ejb.service.common.local.CommonServiceLocal;
import pe.com.edu.siaa.core.ejb.service.local.GenerarReporteServiceLocal;
import pe.com.edu.siaa.core.ejb.service.seguridad.local.SeguridadServiceLocal;
import pe.com.edu.siaa.core.ejb.service.util.FechaUtil;
import pe.com.edu.siaa.core.ejb.util.cache.AppAuthenticator;
import pe.com.edu.siaa.core.ejb.util.cache.ConstanteCommonUtil;
import pe.com.edu.siaa.core.ejb.util.cache.ParametroCacheUtil;
import pe.com.edu.siaa.core.ejb.util.cache.SelectItemServiceCacheUtil;
import pe.com.edu.siaa.core.ejb.util.excel.DataExportExcelPersonalizadoUtil;
import pe.com.edu.siaa.core.ejb.util.jms.UUIDUtil;
import pe.com.edu.siaa.core.ejb.util.log.Logger;
import pe.com.edu.siaa.core.ejb.util.txt.TXTUtil;
import pe.com.edu.siaa.core.model.dto.contabilidad.AsientoContableDTO;
import pe.com.edu.siaa.core.model.dto.contabilidad.AsientoContableDetDTO;
import pe.com.edu.siaa.core.model.dto.contabilidad.ConfiguracionCuentaDTO;
import pe.com.edu.siaa.core.model.dto.contabilidad.PlanContableDTO;
import pe.com.edu.siaa.core.model.dto.seguridad.EntidadDTO;
import pe.com.edu.siaa.core.model.dto.seguridad.UsuarioDTO;
import pe.com.edu.siaa.core.model.estate.EstadoGeneralState;
import pe.com.edu.siaa.core.model.jpa.seguridad.Usuario;
import pe.com.edu.siaa.core.model.type.AccionType;
import pe.com.edu.siaa.core.model.type.NombreReporteType;
import pe.com.edu.siaa.core.model.type.RespuestaNaturalType;
import pe.com.edu.siaa.core.model.type.TipoMovimientoType;
import pe.com.edu.siaa.core.model.type.TipoProductoType;
import pe.com.edu.siaa.core.model.type.TipoReporteGenerarType;
import pe.com.edu.siaa.core.model.util.ConstanteConfigUtil;
import pe.com.edu.siaa.core.model.util.NumerosUtil;
import pe.com.edu.siaa.core.model.util.ObjectUtil;
import pe.com.edu.siaa.core.model.util.StringUtils;
import pe.com.edu.siaa.core.model.vo.ExcelHederDataVO;
import pe.com.edu.siaa.core.model.vo.ExcelHederTitleVO;
import pe.com.edu.siaa.core.model.vo.FileVO;
import pe.com.edu.siaa.core.model.vo.ParametroReporteVO;
import pe.com.edu.siaa.core.ui.paginator.IDataProvider;
import pe.com.edu.siaa.core.ui.paginator.LazyLoadingList;


/**
 * La Class VentaServiceImpl.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:52 COT 2017
 * @since SIAA-CORE 2.1
 */
 @Stateless
public class VentaServiceImpl implements VentaServiceLocal {
	 
	private Logger log = Logger.getLogger(VentaServiceImpl.class);
	 
	/** El servicio categoria dao impl. */
	@EJB
	private CategoriaDaoLocal categoriaDaoImpl; 
	
	/** El servicio cliente dao impl. */
	@EJB
	private ClienteDaoLocal clienteDaoImpl; 
	
	/** El servicio configuracion atributo dao impl. */
	@EJB
	private ConfiguracionAtributoDaoLocal configuracionAtributoDaoImpl; 
	
	/** El servicio configuracion atributo value dao impl. */
	@EJB
	private ConfiguracionAtributoValueDaoLocal configuracionAtributoValueDaoImpl; 
	
	/** El servicio detalle pedido dao impl. */
	@EJB
	private DetallePedidoDaoLocal detallePedidoDaoImpl; 
	
	/** El servicio detalle proforma dao impl. */
	@EJB
	private DetalleProformaDaoLocal detalleProformaDaoImpl; 
	
	/** El servicio detalle venta dao impl. */
	@EJB
	private DetalleVentaDaoLocal detalleVentaDaoImpl; 
	
	/** El servicio linea dao impl. */
	@EJB
	private LineaDaoLocal lineaDaoImpl; 
	
	/** El servicio marca dao impl. */
	@EJB
	private MarcaDaoLocal marcaDaoImpl; 
	
	/** El servicio modelo dao impl. */
	@EJB
	private ModeloDaoLocal modeloDaoImpl; 
	
	/** El servicio pedido dao impl. */
	@EJB
	private PedidoDaoLocal pedidoDaoImpl; 
	
	/** El servicio producto dao impl. */
	@EJB
	private ProductoDaoLocal productoDaoImpl; 
	
	/** El servicio proforma dao impl. */
	@EJB
	private ProformaDaoLocal proformaDaoImpl; 
	
	/** El servicio tipo doc sunat entidad dao impl. */
	@EJB
	private TipoDocSunatEntidadDaoLocal tipoDocSunatEntidadDaoImpl; 
	
	/** El servicio venta dao impl. */
	@EJB
	private VentaDaoLocal ventaDaoImpl; 
	
	@EJB
	private SeguridadServiceLocal seguridadServiceLocal; 
	
	//Integrando con la contabilidad para generar asientos contables
	
	@EJB
	private GenerarReporteServiceLocal	 generarReporteServiceImpl;
	
	@EJB
	private UsuarioDaoLocal usuarioServiceImpl; 
	
	@EJB
	private transient CommonServiceLocal commonServiceLocal;
	
	/** El servicio cliente dao impl. */
	@EJB
	private AvalDaoLocal avalDaoImpl; 
	
	
	@Override
	public String generarReporteProductoCodigoBarra(ProductoDTO productoFiltro) throws Exception {
		String fileName = UUIDUtil.generarElementUUID();
		String codigoGeneradoReporte = fileName;
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			String[] subreportes;
			subreportes = new String[0];	
			parametros.put("ruta", "");
			List<ProductoDTO> listaProducto = new ArrayList<ProductoDTO>();
			listaProducto = buscarPaginadoProducto(listaProducto, 2000, productoFiltro);
			NombreReporteType reporte = NombreReporteType.JR_REP_REPORTE_PRODUCTO_CODIGO_BARRA;
			ParametroReporteVO parametroReporteVO = new ParametroReporteVO(parametros, listaProducto, reporte, subreportes, null, true, "", "");
			parametroReporteVO.setFormato(TipoReporteGenerarType.PDF.getKey());
			//parametroReporteVO.setUserName(usuario);
			parametroReporteVO.setFileName(fileName);
			codigoGeneradoReporte = generarReporteServiceImpl.obtenerParametroReporteBigMemory(parametroReporteVO);
			return codigoGeneradoReporte;
		} catch (Exception e) {
			log.error(e);
		}
		return codigoGeneradoReporte;
	}
	
	private List<ProductoDTO> buscarPaginadoProducto(List<ProductoDTO> listaProducto, int cantidadPagina, final ProductoDTO productoFiltro) {
		IDataProvider<ProductoDTO> dataProvider = new IDataProvider<ProductoDTO>() {
			private int total = 0;
			private int cuenta = 0;
			@Override
			public List<ProductoDTO> getBufferedData(int startRow, int offset) {
				List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
				productoFiltro.setStartRow(startRow);
				productoFiltro.setOffset(offset);
				try {
					lista = listarProducto(productoFiltro);
				} catch (Exception e) {
					lista = new ArrayList<ProductoDTO>();
				}
				return lista;
			}
			@Override
			public int getTotalResultsNumber() {
				if (total == 0 && cuenta == 0) {
					try {
						total = contarListarProducto(productoFiltro);
					} catch (Exception e) {
						//e.printStackTrace();
					}					
					cuenta++;
				}
				return total;
			}
		};
		listaProducto = new LazyLoadingList<ProductoDTO>(dataProvider, cantidadPagina);
		return listaProducto;
	}
	
	@Override
	public  List<DetalleVentaDTO> listarDetalleVenta(DetalleVentaDTO detalleVenta) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.detalleVentaDaoImpl.listarDetalleVenta(detalleVenta),DetalleVentaDTO.class,"producto");
	}
	
	@Override
	public String generarReporteRegistroVentaTXT(RegistroAsientoFiltroVO registroAsientoFiltroVO) throws Exception {
		String resultado = UUIDUtil.generarElementUUID();
		EntidadDTO entidadFiltro = new EntidadDTO();
		entidadFiltro.setIdEntidad(registroAsientoFiltroVO.getIdEntidad());
		EntidadDTO entidad = seguridadServiceLocal.controladorAccionEntidad(entidadFiltro, AccionType.FIND_BY_ID);
		String archivoName = "LE" + entidad.getCodigoExterno() +"" + registroAsientoFiltroVO.getEjercicio() +"" + registroAsientoFiltroVO.getPeriodo() + "00140100001111";
		String userName = AppAuthenticator.getInstance().getUserName(registroAsientoFiltroVO.getAuthToken());
		List<Map<String,Object>> listaDetalleVenta = new ArrayList<Map<String,Object>>();
		listaDetalleVenta = this.buscarPaginadoDetalleVentaTXT(listaDetalleVenta, 3000, registroAsientoFiltroVO);
		TXTUtil.escribirArchivo(listaDetalleVenta, userName, resultado, "txt", "|");
		TXTUtil.generarTXTViewMap(userName,resultado,archivoName,TipoReporteGenerarType.TXT);
		return resultado;
	}
	private List<Map<String,Object>> buscarPaginadoDetalleVentaTXT(List<Map<String,Object>> listaAsientoContableDet, int cantidadPagina, final RegistroAsientoFiltroVO registroVentaFiltroVO) {
		IDataProvider<Map<String,Object>> dataProvider = new IDataProvider<Map<String,Object>>() {
			private int total = 0;
			private int cuenta = 0;
			@Override
			public List<Map<String,Object>> getBufferedData(int startRow, int offset) {
				List<Map<String,Object>> lista = new ArrayList<Map<String,Object>>();
				registroVentaFiltroVO.setStartRow(startRow);
				registroVentaFiltroVO.setOffset(startRow + offset);
				try {
					lista = listarVentaReporteTXT(registroVentaFiltroVO);
				} catch (Exception e) {
					lista = new ArrayList<Map<String,Object>>();
				}
				return lista;
			}
			@Override
			public int getTotalResultsNumber() {
				if (total == 0 && cuenta == 0) {
					try {
						total = contarListarVentaReporteTXT(registroVentaFiltroVO);
					} catch (Exception e) {
						//e.printStackTrace();
					}					
					cuenta++;
				}
				return total;
			}
		};
		listaAsientoContableDet = new LazyLoadingList<Map<String,Object>>(dataProvider, cantidadPagina);
		return listaAsientoContableDet;
	}
	private List<Map<String,Object>> listarVentaReporteTXT(RegistroAsientoFiltroVO registroVentaFiltroVO) throws Exception {
		return  this.ventaDaoImpl.listarVentaReporteTXT(registroVentaFiltroVO);
	}
	private int contarListarVentaReporteTXT(RegistroAsientoFiltroVO registroVentaFiltroVO){
		return  this.ventaDaoImpl.contarListarVentaReporteTXT(registroVentaFiltroVO);
	}
	@Override
	public String generarReporteRegistroVenta(RegistroAsientoFiltroVO registroVentaFiltroVO) throws Exception {
		String fileName = UUIDUtil.generarElementUUID();
		EntidadDTO entidadFiltro = new EntidadDTO();
		entidadFiltro.setIdEntidad(registroVentaFiltroVO.getIdEntidad());
		EntidadDTO entidad = seguridadServiceLocal.controladorAccionEntidad(entidadFiltro, AccionType.FIND_BY_ID);
		registroVentaFiltroVO.setCodigoEntidadUniversitaria(entidad.getCodigo());
		List<RegistroVentaVO> listaDetalleVenta = new ArrayList<RegistroVentaVO>();
		listaDetalleVenta = this.buscarPaginadoDetalleVenta(listaDetalleVenta, 3000, registroVentaFiltroVO);
		String archivoName = fileName;
		
		if (listaDetalleVenta != null) {
			Map<String, Object> propiedadesMap = new HashMap<String, Object>();
			propiedadesMap.put("calcularWitchDemanda", "true");
			propiedadesMap.put("exluirCabecera", "true");
			//propiedadesMap.put("anexarHojaExistente", "true");
			//propiedadesMap.put("nombreArchivo", "formato_registro_nota.xlsx");
			//propiedadesMap.put("anexarHojaPosition",1);
			//propiedadesMap.put("printTitleView", "true");
			String titulo = "Data";
			propiedadesMap.put("fechaEmisionFormat", FechaUtil.DATE_DMY);
			propiedadesMap.put("fechaVencimientoOPagoFormat", FechaUtil.DATE_DMY);
			List<ExcelHederDataVO> listaHeaderData = new ArrayList<ExcelHederDataVO>();
			listaHeaderData.add(new ExcelHederDataVO("codigoOperacion","codigoOperacion"));
			listaHeaderData.add(new ExcelHederDataVO("fechaEmision","fechaEmision"));
			listaHeaderData.add(new ExcelHederDataVO("fechaVencien","fechaVencimientoOPago"));
			
			listaHeaderData.add(new ExcelHederDataVO("01","tipoDocumentoPago"));
			listaHeaderData.add(new ExcelHederDataVO("00001","serieDocumentoPago"));
			listaHeaderData.add(new ExcelHederDataVO("nroDocumentoPago","nroDocumentoPago"));
			
			listaHeaderData.add(new ExcelHederDataVO("DNI01","tipoDocIdentidad"));
			listaHeaderData.add(new ExcelHederDataVO("nroDocIdentidad","nroDocIdentidad"));
			listaHeaderData.add(new ExcelHederDataVO("nombreORazonSocial","nombreORazonSocial"));
			
			listaHeaderData.add(new ExcelHederDataVO("valorFacturado","valorFacturadoExportacion"));
			listaHeaderData.add(new ExcelHederDataVO("baseImponibl","baseImponibleOperacionGrabada"));
			
			listaHeaderData.add(new ExcelHederDataVO("importeTotal","importeTotalOperacionExonerada"));
			listaHeaderData.add(new ExcelHederDataVO("importeTotal","importeTotalOperacionInafecto"));
			
			listaHeaderData.add(new ExcelHederDataVO("ISC","ISC"));
			listaHeaderData.add(new ExcelHederDataVO("IGVoIPM","IGVoIPM"));
			
			listaHeaderData.add(new ExcelHederDataVO("otroTribut","otroTributoBaseImponible"));
			listaHeaderData.add(new ExcelHederDataVO("importeTotal","importeTotalComprobantePago"));
			listaHeaderData.add(new ExcelHederDataVO("tipoCambio","tipoCambio"));
			
			listaHeaderData.add(new ExcelHederDataVO("fehaRefCo","fehaRefComprobanteDocModifica"));
			listaHeaderData.add(new ExcelHederDataVO("tipoDocRefC","tipoDocRefComprobanteDocModifica"));
			listaHeaderData.add(new ExcelHederDataVO("serieDocRefCom","serieDocRefComprobanteDocModifica"));
			listaHeaderData.add(new ExcelHederDataVO("nroDocRefCompr","nroDocRefComprobanteDocModifica"));
			
			
			List<ExcelHederTitleVO> listaExcelHederTitle = new ArrayList<ExcelHederTitleVO>();
			listaExcelHederTitle.add(new ExcelHederTitleVO(entidad.getNombre(), HorizontalAlignment.LEFT.getCode(), VerticalAlignment.JUSTIFY.getCode(), 1, 1, 6,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO(entidad.getCodigoExterno(), HorizontalAlignment.LEFT.getCode(), VerticalAlignment.JUSTIFY.getCode(), 1, 2, 0,0,true));
			
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("REGISTRO DE VENTAS - INGRESOS", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.JUSTIFY.getCode(), 1, 3, 7,0,(short)14,false));
			
			String dataReporte = "EJERCICIO : " + registroVentaFiltroVO.getEjercicio()  +"               PERIODO : " + registroVentaFiltroVO.getPeriodo() + "               RUC : " + entidad.getCodigoExterno() + "               APELLIDOS Y NOMBRES, DENOMINACION O RAZON SOCIAL : " + entidad.getNombre() + "";
			listaExcelHederTitle.add(new ExcelHederTitleVO(dataReporte, HorizontalAlignment.LEFT.getCode(),(short)-1, 1,4, 22,0,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("Nº CORRELATIVO DEL REGISTRO O CODIGO UNICO DE LA OPERACION ", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 1,5, 0,3,0,25,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("FECHA DE EMISION DEL COMPROBANTE DE PAGO O DOCUMENTO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 2,5, 0,3,1,22,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("FECHA DE VENCIMIENTO Y/O PAGO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 3,5, 0,3,2,22,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("COMPROBANTE DE PAGO O DOCUMENTO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 4,5, 3,0,3,22,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("TIPO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 4,6, 0,2,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("Nº SERIE", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 5,6, 0,2,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("NUMERO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 6,6, 0,2,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("INFORMACION DEL CLIENTE", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 7,5, 3,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("DOCUMENTO DE IDENTIDAD", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),7, 6, 2,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("TIPO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),7, 7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("NUMERO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),8, 7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("APELLIDOS Y NOMBRES, DENOMINACION O RAZON SOCIAL", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),9, 6, 0,2,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("VALOR FACTURADO DE LA EXPORTACION", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 10,5, 0,3,9,16,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("BASE IMPONIBLE DE LA OPERACION GRAVADA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 11,5, 0,3,10,16,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("IMPORTE TOTAL DE LA OPERACION EXONERADA O INAFECTA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 12,5, 2,2,11,20,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("EXONERADA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),12, 7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("INAFECTA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(),13, 7, 0,0,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("ISC", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 14,5, 0,3,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("IGV Y/O IPM", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 15,5, 0,3,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("OTROS TRIBUTOS Y CARGOS QUE NO FORMAN PARTE DE LA BASE IMPONIBLE", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 16,5, 0,3,15,25,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("IMPORTE TOTAL DEL COMPROBANTE DE PAGO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 17,5, 0,3,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("TIPO DE CAMBIO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 18,5, 0,3,true));
			
			listaExcelHederTitle.add(new ExcelHederTitleVO("REFERENCIA DEL COMPROBANTE DE PAGO O DOCUMENTO ORIGINAL QUE SE MODIFICA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 19,5, 4,2,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("FECHA", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 19,7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("TIPO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 20,7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("SERIE", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 21,7, 0,0,true));
			listaExcelHederTitle.add(new ExcelHederTitleVO("Nº DEL COMPROBANTE DE PAGO O DOCUMENTO", HorizontalAlignment.CENTER.getCode(),VerticalAlignment.CENTER.getCode(), 22,7, 0,0,true));
			
			propiedadesMap.put("listaTituloFinal", listaExcelHederTitle);//para crear con esta lista
			
			DataExportExcelPersonalizadoUtil.generarExcelXLSX(listaHeaderData, listaDetalleVenta, archivoName, titulo, propiedadesMap);
		}
		DataExportExcelPersonalizadoUtil.generarExcelXLSXViewMap(archivoName);
		return fileName;
	}
	
	private List<RegistroVentaVO> buscarPaginadoDetalleVenta(List<RegistroVentaVO> listaAsientoContableDet, int cantidadPagina, final RegistroAsientoFiltroVO registroVentaFiltroVO) {
		IDataProvider<RegistroVentaVO> dataProvider = new IDataProvider<RegistroVentaVO>() {
			private int total = 0;
			private int cuenta = 0;
			@Override
			public List<RegistroVentaVO> getBufferedData(int startRow, int offset) {
				List<RegistroVentaVO> lista = new ArrayList<RegistroVentaVO>();
				registroVentaFiltroVO.setStartRow(startRow);
				registroVentaFiltroVO.setOffset(startRow + offset);
				try {
					lista = listarVentaReporte(registroVentaFiltroVO);
				} catch (Exception e) {
					lista = new ArrayList<RegistroVentaVO>();
				}
				return lista;
			}
			@Override
			public int getTotalResultsNumber() {
				if (total == 0 && cuenta == 0) {
					try {
						total = contarListarVentaReporte(registroVentaFiltroVO);
					} catch (Exception e) {
						//e.printStackTrace();
					}					
					cuenta++;
				}
				return total;
			}
		};
		listaAsientoContableDet = new LazyLoadingList<RegistroVentaVO>(dataProvider, cantidadPagina);
		return listaAsientoContableDet;
	}
	private List<RegistroVentaVO> listarVentaReporte(RegistroAsientoFiltroVO registroVentaFiltroVO) throws Exception {
		return  this.ventaDaoImpl.listarVentaReporte(registroVentaFiltroVO);
	}
	private int contarListarVentaReporte(RegistroAsientoFiltroVO registroVentaFiltroVO){
		return  this.ventaDaoImpl.contarListarVentaReporte(registroVentaFiltroVO);
	}
	@Override
	public CategoriaDTO controladorAccionCategoria(CategoriaDTO categoria, AccionType accionType) throws Exception {
		CategoriaDTO resultado = null;
		Categoria resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				categoria.setIdCategoria(this.categoriaDaoImpl.generarIdCategoria());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(categoria, Categoria.class,"linea@PK@","subCategoria@PK@","entidad@PK@");
				this.categoriaDaoImpl.save(resultadoEntity);	
				resultado = categoria;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(categoria, Categoria.class,"linea@PK@","subCategoria@PK@","entidad@PK@");
				this.categoriaDaoImpl.update(resultadoEntity);
				resultado = categoria;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.categoriaDaoImpl.find(Categoria.class, categoria.getIdCategoria());
				this.categoriaDaoImpl.delete(resultadoEntity);
				resultado = categoria;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.categoriaDaoImpl.find(Categoria.class, categoria.getIdCategoria());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,CategoriaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.categoriaDaoImpl.findByNombre(categoria),CategoriaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<CategoriaDTO> listarCategoria(CategoriaDTO categoria) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.categoriaDaoImpl.listarCategoria(categoria),CategoriaDTO.class,"linea","subCategoria");
	}
	@Override
	public int contarListarCategoria(CategoriaDTO categoria){
		return  this.categoriaDaoImpl.contarListarCategoria(categoria);
	}
	@Override
	public ClienteDTO controladorAccionCliente(ClienteDTO cliente, AccionType accionType) throws Exception {
		ClienteDTO resultado = null;
		Cliente resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				cliente.setIdCliente(this.clienteDaoImpl.generarIdCliente());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(cliente, Cliente.class,"usuario@PK@","entidad@PK@","itemByTipoDocumentoIdentidad@PK@","itemByCategoriaCliente@PK@","itemByEstadoCivil@PK@");
				this.clienteDaoImpl.save(resultadoEntity);	
				resultado = cliente;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(cliente, Cliente.class,"usuario@PK@","entidad@PK@","itemByTipoDocumentoIdentidad@PK@","itemByCategoriaCliente@PK@","itemByEstadoCivil@PK@");
				this.clienteDaoImpl.update(resultadoEntity);
				resultado = cliente;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.clienteDaoImpl.find(Cliente.class, cliente.getIdCliente());
				this.clienteDaoImpl.delete(resultadoEntity);
				resultado = cliente;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.clienteDaoImpl.find(Cliente.class, cliente.getIdCliente());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ClienteDTO.class,"itemByTipoDocumentoIdentidad");
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.clienteDaoImpl.findByNombre(cliente),ClienteDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ClienteDTO> listarCliente(ClienteDTO cliente) throws Exception {
		List<Cliente> listaTemp = this.clienteDaoImpl.listarCliente(cliente);
		List<ClienteDTO> listaCli = new ArrayList<ClienteDTO>(); 
		for (Cliente clie : listaTemp) {
			ClienteDTO clienteDTO = TransferDataObjectUtil.transferObjetoEntityDTO(clie, ClienteDTO.class,"usuario","itemByTipoDocumentoIdentidad","itemByCategoriaCliente","itemByEstadoCivil");
			FileVO fileVO = new FileVO();
			fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  clienteDTO.getFoto());
			clienteDTO.setFoto(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
			listaCli.add(clienteDTO);
		}	
		listaTemp = null;
		return listaCli;
		//return TransferDataObjectUtil.transferObjetoEntityDTOList(this.clienteDaoImpl.listarCliente(cliente),ClienteDTO.class,"usuario","itemByTipoDocumentoIdentidad","itemByCategoriaCliente","itemByEstadoCivil");
	}
	@Override
	public int contarListarCliente(ClienteDTO cliente){
		return  this.clienteDaoImpl.contarListarCliente(cliente);
	}
	@Override
	public ConfiguracionAtributoDTO controladorAccionConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo, AccionType accionType) throws Exception {
		ConfiguracionAtributoDTO resultado = null;
		ConfiguracionAtributo resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				configuracionAtributo.setIdConfiguracionAtributo(this.configuracionAtributoDaoImpl.generarIdConfiguracionAtributo());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(configuracionAtributo, ConfiguracionAtributo.class,"itemByIdNombreEntidad@PK@","itemByIdComponte@PK@","listaItem@PK@");
				this.configuracionAtributoDaoImpl.save(resultadoEntity);	
				resultado = configuracionAtributo;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(configuracionAtributo, ConfiguracionAtributo.class,"itemByIdNombreEntidad@PK@","itemByIdComponte@PK@","listaItem@PK@");
				this.configuracionAtributoDaoImpl.update(resultadoEntity);
				resultado = configuracionAtributo;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.configuracionAtributoDaoImpl.find(ConfiguracionAtributo.class, configuracionAtributo.getIdConfiguracionAtributo());
				this.configuracionAtributoDaoImpl.delete(resultadoEntity);
				resultado = configuracionAtributo;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.configuracionAtributoDaoImpl.find(ConfiguracionAtributo.class, configuracionAtributo.getIdConfiguracionAtributo());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ConfiguracionAtributoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.configuracionAtributoDaoImpl.findByNombre(configuracionAtributo),ConfiguracionAtributoDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ConfiguracionAtributoDTO> listarConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.configuracionAtributoDaoImpl.listarConfiguracionAtributo(configuracionAtributo),ConfiguracionAtributoDTO.class);
	}
	@Override
	public int contarListarConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo){
		return  this.configuracionAtributoDaoImpl.contarListarConfiguracionAtributo(configuracionAtributo);
	}
	@Override
	public ConfiguracionAtributoValueDTO controladorAccionConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue, AccionType accionType) throws Exception {
		ConfiguracionAtributoValueDTO resultado = null;
		ConfiguracionAtributoValue resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				configuracionAtributoValue.setIdConfiguracionAtributoValue(this.configuracionAtributoValueDaoImpl.generarIdConfiguracionAtributoValue());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(configuracionAtributoValue, ConfiguracionAtributoValue.class,"configuracionAtributo@PK@");
				this.configuracionAtributoValueDaoImpl.save(resultadoEntity);	
				resultado = configuracionAtributoValue;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(configuracionAtributoValue, ConfiguracionAtributoValue.class,"configuracionAtributo@PK@");
				this.configuracionAtributoValueDaoImpl.update(resultadoEntity);
				resultado = configuracionAtributoValue;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.configuracionAtributoValueDaoImpl.find(ConfiguracionAtributoValue.class, configuracionAtributoValue.getIdConfiguracionAtributoValue());
				this.configuracionAtributoValueDaoImpl.delete(resultadoEntity);
				resultado = configuracionAtributoValue;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.configuracionAtributoValueDaoImpl.find(ConfiguracionAtributoValue.class, configuracionAtributoValue.getIdConfiguracionAtributoValue());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ConfiguracionAtributoValueDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.configuracionAtributoValueDaoImpl.findByNombre(configuracionAtributoValue),ConfiguracionAtributoValueDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ConfiguracionAtributoValueDTO> listarConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.configuracionAtributoValueDaoImpl.listarConfiguracionAtributoValue(configuracionAtributoValue),ConfiguracionAtributoValueDTO.class);
	}
	@Override
	public int contarListarConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue){
		return  this.configuracionAtributoValueDaoImpl.contarListarConfiguracionAtributoValue(configuracionAtributoValue);
	}
	@Override
	public DetallePedidoDTO controladorAccionDetallePedido(DetallePedidoDTO detallePedido, AccionType accionType) throws Exception {
		DetallePedidoDTO resultado = null;
		DetallePedido resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				detallePedido.setIdDetallePedido(this.detallePedidoDaoImpl.generarIdDetallePedido());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detallePedido, DetallePedido.class,"pedido@PK@","producto@PK@");
				this.detallePedidoDaoImpl.save(resultadoEntity);	
				resultado = detallePedido;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detallePedido, DetallePedido.class,"pedido@PK@","producto@PK@");
				this.detallePedidoDaoImpl.update(resultadoEntity);
				resultado = detallePedido;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.detallePedidoDaoImpl.find(DetallePedido.class, detallePedido.getIdDetallePedido());
				this.detallePedidoDaoImpl.delete(resultadoEntity);
				resultado = detallePedido;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.detallePedidoDaoImpl.find(DetallePedido.class, detallePedido.getIdDetallePedido());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,DetallePedidoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.detallePedidoDaoImpl.findByNombre(detallePedido),DetallePedidoDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<DetallePedidoDTO> listarDetallePedido(DetallePedidoDTO detallePedido) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.detallePedidoDaoImpl.listarDetallePedido(detallePedido),DetallePedidoDTO.class);
	}
	@Override
	public int contarListarDetallePedido(DetallePedidoDTO detallePedido){
		return  this.detallePedidoDaoImpl.contarListarDetallePedido(detallePedido);
	}
	@Override
	public DetalleProformaDTO controladorAccionDetalleProforma(DetalleProformaDTO detalleProforma, AccionType accionType) throws Exception {
		DetalleProformaDTO resultado = null;
		DetalleProforma resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				detalleProforma.setIdDetalleProforma(this.detalleProformaDaoImpl.generarIdDetalleProforma());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detalleProforma, DetalleProforma.class,"proforma@PK@","producto@PK@");
				this.detalleProformaDaoImpl.save(resultadoEntity);	
				resultado = detalleProforma;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detalleProforma, DetalleProforma.class,"proforma@PK@","producto@PK@");
				this.detalleProformaDaoImpl.update(resultadoEntity);
				resultado = detalleProforma;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.detalleProformaDaoImpl.find(DetalleProforma.class, detalleProforma.getIdDetalleProforma());
				this.detalleProformaDaoImpl.delete(resultadoEntity);
				resultado = detalleProforma;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.detalleProformaDaoImpl.find(DetalleProforma.class, detalleProforma.getIdDetalleProforma());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,DetalleProformaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.detalleProformaDaoImpl.findByNombre(detalleProforma),DetalleProformaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<DetalleProformaDTO> listarDetalleProforma(DetalleProformaDTO detalleProforma) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.detalleProformaDaoImpl.listarDetalleProforma(detalleProforma),DetalleProformaDTO.class);
	}
	@Override
	public int contarListarDetalleProforma(DetalleProformaDTO detalleProforma){
		return  this.detalleProformaDaoImpl.contarListarDetalleProforma(detalleProforma);
	}
	private DetalleVentaDTO controladorAccionDetalleVenta(DetalleVentaDTO detalleVenta,Venta venta, AccionType accionType) throws Exception {
		DetalleVentaDTO resultado = null;
		DetalleVenta resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				detalleVenta.setIdDetalleVenta(this.detalleVentaDaoImpl.generarIdDetalleVenta());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detalleVenta, DetalleVenta.class,"venta@PK@","producto@PK@");
				resultadoEntity.setVenta(venta);
				this.detalleVentaDaoImpl.save(resultadoEntity);	
				resultado = detalleVenta;
				this.actualizarStock(detalleVenta,false);
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(detalleVenta, DetalleVenta.class,"venta@PK@","producto@PK@");
			    resultadoEntity.setVenta(venta);
				this.detalleVentaDaoImpl.update(resultadoEntity);
				resultado = detalleVenta;	
				this.actualizarStock(detalleVenta,false);
				break;
				
			case ELIMINAR:
				resultadoEntity = this.detalleVentaDaoImpl.find(DetalleVenta.class, detalleVenta.getIdDetalleVenta());
				//this.detalleVentaDaoImpl.update(resultadoEntity);
				this.actualizarStock(detalleVenta,true);
				resultado = detalleVenta;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.detalleVentaDaoImpl.find(DetalleVenta.class, detalleVenta.getIdDetalleVenta());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,DetalleVentaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.detalleVentaDaoImpl.findByNombre(detalleVenta),DetalleVentaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	private boolean actualizarStock(DetalleVentaDTO detalleVenta, boolean esSumar) {
		Producto producto = this.productoDaoImpl.find(Producto.class, detalleVenta.getProducto().getIdProducto());
		if (producto != null && TipoProductoType.BIEN.getKey().equals(producto.getTipo())) {
			if (!esSumar) { 
				producto.setStock(producto.getStock().subtract(detalleVenta.getCantidad()));
			} else {
				producto.setStock(producto.getStock().add(detalleVenta.getCantidad()));
			}
			this.productoDaoImpl.update(producto);
			return true;
		}
		return false;
	}
	@Override
	public LineaDTO controladorAccionLinea(LineaDTO linea, AccionType accionType) throws Exception {
		LineaDTO resultado = null;
		Linea resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				linea.setIdLinea(this.lineaDaoImpl.generarIdLinea());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(linea, Linea.class,"entidad@PK@");
				this.lineaDaoImpl.save(resultadoEntity);	
				resultado = linea;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(linea, Linea.class,"entidad@PK@");
				this.lineaDaoImpl.update(resultadoEntity);
				resultado = linea;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.lineaDaoImpl.find(Linea.class, linea.getIdLinea());
				this.lineaDaoImpl.delete(resultadoEntity);
				resultado = linea;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.lineaDaoImpl.find(Linea.class, linea.getIdLinea());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,LineaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.lineaDaoImpl.findByNombre(linea),LineaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<LineaDTO> listarLinea(LineaDTO linea) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.lineaDaoImpl.listarLinea(linea),LineaDTO.class);
	}
	@Override
	public int contarListarLinea(LineaDTO linea){
		return  this.lineaDaoImpl.contarListarLinea(linea);
	}
	@Override
	public MarcaDTO controladorAccionMarca(MarcaDTO marca, AccionType accionType) throws Exception {
		MarcaDTO resultado = null;
		Marca resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				marca.setIdMarca(this.marcaDaoImpl.generarIdMarca());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(marca, Marca.class,"entidad@PK@");
				this.marcaDaoImpl.save(resultadoEntity);	
				resultado = marca;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(marca, Marca.class,"entidad@PK@");
				this.marcaDaoImpl.update(resultadoEntity);
				resultado = marca;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.marcaDaoImpl.find(Marca.class, marca.getIdMarca());
				this.marcaDaoImpl.delete(resultadoEntity);
				resultado = marca;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.marcaDaoImpl.find(Marca.class, marca.getIdMarca());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,MarcaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.marcaDaoImpl.findByNombre(marca),MarcaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<MarcaDTO> listarMarca(MarcaDTO marca) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.marcaDaoImpl.listarMarca(marca),MarcaDTO.class);
	}
	@Override
	public int contarListarMarca(MarcaDTO marca){
		return  this.marcaDaoImpl.contarListarMarca(marca);
	}
	@Override
	public ModeloDTO controladorAccionModelo(ModeloDTO modelo, AccionType accionType) throws Exception {
		ModeloDTO resultado = null;
		Modelo resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				modelo.setIdModelo(this.modeloDaoImpl.generarIdModelo());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(modelo, Modelo.class,"marca@PK@","subModelo@PK@","entidad@PK@");
				this.modeloDaoImpl.save(resultadoEntity);	
				resultado = modelo;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(modelo, Modelo.class,"marca@PK@","subModelo@PK@","entidad@PK@");
				this.modeloDaoImpl.update(resultadoEntity);
				resultado = modelo;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.modeloDaoImpl.find(Modelo.class, modelo.getIdModelo());
				this.modeloDaoImpl.delete(resultadoEntity);
				resultado = modelo;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.modeloDaoImpl.find(Modelo.class, modelo.getIdModelo());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ModeloDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.modeloDaoImpl.findByNombre(modelo),ModeloDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ModeloDTO> listarModelo(ModeloDTO modelo) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.modeloDaoImpl.listarModelo(modelo),ModeloDTO.class,"marca","subModelo");
	}
	@Override
	public int contarListarModelo(ModeloDTO modelo){
		return  this.modeloDaoImpl.contarListarModelo(modelo);
	}
	@Override
	public PedidoDTO controladorAccionPedido(PedidoDTO pedido, AccionType accionType) throws Exception {
		PedidoDTO resultado = null;
		Pedido resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				pedido.setIdPedido(this.pedidoDaoImpl.generarIdPedido());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(pedido, Pedido.class,"entidad@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
				this.pedidoDaoImpl.save(resultadoEntity);	
				resultado = pedido;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(pedido, Pedido.class,"entidad@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
				this.pedidoDaoImpl.update(resultadoEntity);
				resultado = pedido;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.pedidoDaoImpl.find(Pedido.class, pedido.getIdPedido());
				this.pedidoDaoImpl.delete(resultadoEntity);
				resultado = pedido;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.pedidoDaoImpl.find(Pedido.class, pedido.getIdPedido());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,PedidoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.pedidoDaoImpl.findByNombre(pedido),PedidoDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<PedidoDTO> listarPedido(PedidoDTO pedido) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.pedidoDaoImpl.listarPedido(pedido),PedidoDTO.class);
	}
	@Override
	public int contarListarPedido(PedidoDTO pedido){
		return  this.pedidoDaoImpl.contarListarPedido(pedido);
	}
	@Override
	public ProductoDTO controladorAccionProducto(ProductoDTO producto, AccionType accionType) throws Exception {
		ProductoDTO resultado = null;
		Producto resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				producto.setIdProducto(this.productoDaoImpl.generarIdProducto());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(producto, Producto.class,"categoria@PK@","itemByUnidadMedida@PK@","modelo@PK@","itemByColor@PK@","itemByTalla@PK@","planContableVenta@PK@","planContableCompra@PK@","entidad@PK@");
				this.productoDaoImpl.save(resultadoEntity);	
				resultado = producto;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(producto, Producto.class,"categoria@PK@","itemByUnidadMedida@PK@","modelo@PK@","itemByColor@PK@","itemByTalla@PK@","planContableVenta@PK@","planContableCompra@PK@","entidad@PK@");
				this.productoDaoImpl.update(resultadoEntity);
				resultado = producto;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.productoDaoImpl.find(Producto.class, producto.getIdProducto());
				this.productoDaoImpl.delete(resultadoEntity);
				resultado = producto;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.productoDaoImpl.find(Producto.class, producto.getIdProducto());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ProductoDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.productoDaoImpl.findByNombre(producto),ProductoDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ProductoDTO> listarProducto(ProductoDTO producto) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.productoDaoImpl.listarProducto(producto),ProductoDTO.class,"categoria","itemByUnidadMedida","modelo","itemByColor","itemByTalla","planContableVenta","planContableCompra");
	}
	@Override
	public int contarListarProducto(ProductoDTO producto){
		return  this.productoDaoImpl.contarListarProducto(producto);
	}
	@Override
	public ProformaDTO controladorAccionProforma(ProformaDTO proforma, AccionType accionType) throws Exception {
		ProformaDTO resultado = null;
		Proforma resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				proforma.setIdProforma(this.proformaDaoImpl.generarIdProforma());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(proforma, Proforma.class,"entidad@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
				this.proformaDaoImpl.save(resultadoEntity);	
				resultado = proforma;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(proforma, Proforma.class,"entidad@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
				this.proformaDaoImpl.update(resultadoEntity);
				resultado = proforma;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.proformaDaoImpl.find(Proforma.class, proforma.getIdProforma());
				this.proformaDaoImpl.delete(resultadoEntity);
				resultado = proforma;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.proformaDaoImpl.find(Proforma.class, proforma.getIdProforma());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,ProformaDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.proformaDaoImpl.findByNombre(proforma),ProformaDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<ProformaDTO> listarProforma(ProformaDTO proforma) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.proformaDaoImpl.listarProforma(proforma),ProformaDTO.class);
	}
	@Override
	public int contarListarProforma(ProformaDTO proforma){
		return  this.proformaDaoImpl.contarListarProforma(proforma);
	}
	@Override
	public TipoDocSunatEntidadDTO controladorAccionTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad, AccionType accionType) throws Exception {
		TipoDocSunatEntidadDTO resultado = null;
		TipoDocSunatEntidad resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				tipoDocSunatEntidad.setIdTipoDocSunatEntidad(this.tipoDocSunatEntidadDaoImpl.generarIdTipoDocSunatEntidad());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(tipoDocSunatEntidad, TipoDocSunatEntidad.class,"itemByTipoDocSunat@PK@","entidad@PK@");
				this.tipoDocSunatEntidadDaoImpl.save(resultadoEntity);	
				resultado = tipoDocSunatEntidad;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(tipoDocSunatEntidad, TipoDocSunatEntidad.class,"itemByTipoDocSunat@PK@","entidad@PK@");
				this.tipoDocSunatEntidadDaoImpl.update(resultadoEntity);
				resultado = tipoDocSunatEntidad;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.tipoDocSunatEntidadDaoImpl.find(TipoDocSunatEntidad.class, tipoDocSunatEntidad.getIdTipoDocSunatEntidad());
				this.tipoDocSunatEntidadDaoImpl.delete(resultadoEntity);
				resultado = tipoDocSunatEntidad;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.tipoDocSunatEntidadDaoImpl.find(TipoDocSunatEntidad.class, tipoDocSunatEntidad.getIdTipoDocSunatEntidad());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,TipoDocSunatEntidadDTO.class);
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.tipoDocSunatEntidadDaoImpl.findByNombre(tipoDocSunatEntidad),TipoDocSunatEntidadDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<TipoDocSunatEntidadDTO> listarTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.tipoDocSunatEntidadDaoImpl.listarTipoDocSunatEntidad(tipoDocSunatEntidad),TipoDocSunatEntidadDTO.class,"itemByTipoDocSunat");
	}
	@Override
	public int contarListarTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad){
		return  this.tipoDocSunatEntidadDaoImpl.contarListarTipoDocSunatEntidad(tipoDocSunatEntidad);
	}
	@Override
	public VentaDTO registrarVenta(VentaDTO venta) throws Exception {
		VentaDTO resultado = null;
		Venta resultadoEntity = null;
		String userName = AppAuthenticator.getInstance().getUserName(venta.getAuthToken());
		venta.setIdEntidadSelect(venta.getEntidad().getIdEntidad());
		if (StringUtils.isNotNullOrBlank(venta.getTipoDocSunat().getIdItem())) {
			String nroDocCalc = tipoDocSunatEntidadDaoImpl.actualizarTipoDocSunat(venta.getTipoDocSunat().getIdItem(),venta.getIdEntidadSelect(),venta.getNroDoc(),venta.getSerie());
			if (!StringUtils.isNotNullOrBlank(venta.getNroDoc())) {
				//generar el nro doc
				venta.setNroDoc(nroDocCalc);
			}
		}
		
		if (!StringUtils.isNotNullOrBlank(venta.getIdVenta())) {
			venta.setFechaCreacion(FechaUtil.obtenerFecha());
			venta.setFechaVenta(FechaUtil.obtenerFecha());
			venta.setUsuarioCreacion(userName);
			venta.setEstado(EstadoGeneralState.ACTIVO.getKey());
			venta.setIdVenta(this.ventaDaoImpl.generarIdVenta());
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(venta, Venta.class,"entidad@PK@","pedido@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
			this.ventaDaoImpl.save(resultadoEntity);
			String nroCorrelativoOperacion = registrarAsientoContable(venta, userName);
			resultadoEntity.setNroCorrelativoOperacion(nroCorrelativoOperacion);
			resultado = venta;
		} else {
			resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(venta, Venta.class,"entidad@PK@","pedido@PK@","cliente@PK@","tipoDocSunat@PK@","itemByTipoMoneda@PK@");
			this.ventaDaoImpl.update(resultadoEntity);
			resultado = venta;	
			//resultadoEntity = this.ventaDaoImpl.find(Venta.class, venta.getIdVenta());
		}
		if (!CollectionUtil.isEmpty(venta.getVentaDetalleVentaList())) {
			for (DetalleVentaDTO detalleVenta : venta.getVentaDetalleVentaList()) {
				if (!detalleVenta.isEsEliminado()) {
					if (StringUtils.isNullOrEmpty(detalleVenta.getIdDetalleVenta())) {
						controladorAccionDetalleVenta(detalleVenta,resultadoEntity,AccionType.CREAR);
					} else {
						controladorAccionDetalleVenta(detalleVenta,resultadoEntity,AccionType.MODIFICAR);
					}
					
				} else {
					controladorAccionDetalleVenta(detalleVenta,resultadoEntity, AccionType.ELIMINAR);
				}
			}
		}
		
		return resultado;
	}
	private String registrarAsientoContable(VentaDTO venta,String userName) throws Exception {
		String resultado = "";
		AsientoContableDTO asientoContable = new AsientoContableDTO();
		asientoContable.setIdEntidadSelect(venta.getIdEntidadSelect());
		asientoContable.setEntidad(new EntidadDTO());
		asientoContable.getEntidad().setIdEntidad(venta.getIdEntidadSelect());
		//asientoContable.setIdAsientoContable();
		String keyLibro =  "49" + "" + "5";
		String keySubLibro =  "49" + "" + "14";
		asientoContable.setItemByLibro(SelectItemServiceCacheUtil.getInstance().obtenerItemByCodigo(keyLibro));
		asientoContable.setItemBySubLibro(SelectItemServiceCacheUtil.getInstance().obtenerItemByCodigo(keySubLibro));
		//asientoContable.setNroCorrelativoAsiento(0L);//Generar en el servicio
		asientoContable.setFechaOperacion(venta.getFechaVenta());//TODO:VER_NATAN_CONTABILIDAD
		String glosa = "Provision de la venta {nuroDocumento}, {cliente}";
		glosa = glosa.replace("{nuroDocumento}", venta.getNroDoc());
		glosa = glosa.replace("{cliente}", (venta.getCliente().getNombre() + " " + venta.getCliente().getApellidoPaterno() + " " + venta.getCliente().getApellidoPaterno()).trim());
		asientoContable.setGlosa(glosa);//TODO:VER_NATAN Pasar al parametro
		//asientoContable.setNroCorrelativoOperacion(controlPago.getNroCorrelativoOperacion());//Auto genere en base a libro y sub libro
		asientoContable.setNroDocumentoOperacion(venta.getNroDoc());
		asientoContable.setIdOperacion(venta.getIdVenta() + "");
		asientoContable.setFechaCreacion(FechaUtil.obtenerFecha());
		asientoContable.setUsuarioCreacion(venta.getUsuarioCreacion());
		asientoContable.setFechaModificacion(null);
		asientoContable.setUsuarioModificacion(null);
		asientoContable.setIpAcceso(venta.getIpAcceso());
		//detalle
		boolean isFlagAplicaIGV = false;
		for (DetalleVentaDTO detalleVentaDTO : venta.getVentaDetalleVentaList()) {//TODO:Mejorar esto
				if (RespuestaNaturalType.SI.getKey().toString().equals(detalleVentaDTO.getProducto().getEsAfectoIGV())) {
					isFlagAplicaIGV = true;
					break;
				}
		}
		//Cuenta libro venta 14 ==> cuenta 12
		String keyCuenta =  venta.getIdEntidadSelect() + "14";
		//ConfiguracionCuentaDTO configuracionCuentaDTO = ContabilidadCacheUtil.getInstance().getConfiguracionCuentaMap().get(keyCuenta);
		
		AsientoContableDetDTO asientoContableDet = new AsientoContableDetDTO();
		//asientoContableDet.setPlanContable(configuracionCuentaDTO.getPlanContable());
		asientoContableDet.setMonto(venta.getMontoTotal());
		asientoContableDet.setTipo(TipoMovimientoType.DEBE.getKey());
		asientoContable.getAsientoContableAsientoContableDetList().add(asientoContableDet);
        // cuenta 40
		String porcentajeIGV = "";
		if (isFlagAplicaIGV) {
			String procentajeIgvKey = venta.getIdEntidadSelect() +  ConstanteCommonUtil.PARAMETRO_IGV;
			porcentajeIGV = ParametroCacheUtil.getInstance().getParamtroMap().get(procentajeIgvKey) + "";			
			
		}
		//cuenta 70
		BigDecimal montoIGV = BigDecimal.ZERO;
		for (DetalleVentaDTO detalleVentaDTO : venta.getVentaDetalleVentaList()) {//TODO:Mejorar esto
			 String keyCuentaVenta =  detalleVentaDTO.getProducto().getPlanContableVenta().getIdPlanContable();
			// PlanContableDTO planContableDTO = ContabilidadCacheUtil.getInstance().getPlanContableMap().get(keyCuentaVenta);
			 asientoContableDet = new AsientoContableDetDTO();
			// asientoContableDet.setPlanContable(planContableDTO);
			 asientoContableDet.setMonto(detalleVentaDTO.getMontoTotal());
			 asientoContableDet.setTipo(TipoMovimientoType.HABER.getKey());
			 asientoContable.getAsientoContableAsientoContableDetList().add(asientoContableDet);
			 
			 if (RespuestaNaturalType.SI.getKey().toString().equals(detalleVentaDTO.getProducto().getEsAfectoIGV())) {
				 montoIGV = montoIGV.add(detalleVentaDTO.getMontoTotal().multiply(ObjectUtil.objectToBigDecimal(porcentajeIGV)));
			 }
		}
		if (isFlagAplicaIGV) {			
			String igvCuentaAsignadaKey = venta.getIdEntidadSelect() +  ConstanteCommonUtil.PARAMETRO_IGV_CUENTA_ASIGANDA;
			String IGVCuentaAsignadaValue =  ParametroCacheUtil.getInstance().getParamtroMap().get(igvCuentaAsignadaKey) + "";
			//PlanContableDTO planContableDTO = ContabilidadCacheUtil.getInstance().getPlanContableMap().get(IGVCuentaAsignadaValue);
			asientoContableDet = new AsientoContableDetDTO();
			//asientoContableDet.setPlanContable(planContableDTO);
			asientoContableDet.setMonto(montoIGV);
			asientoContableDet.setTipo(TipoMovimientoType.HABER.getKey());
			asientoContable.getAsientoContableAsientoContableDetList().add(asientoContableDet);			
		}
	    //AsientoContableDTO asientoContableDetPersit = contabilidadServiceImpl.registrarAsientoContable(asientoContable ,userName, AccionType.CREAR);
	    //resultado = asientoContableDetPersit.getNroCorrelativoOperacion();
	    return resultado;
	}
	@Override
	public List<VentaDTO> listarVenta(VentaDTO venta) throws Exception {
		return TransferDataObjectUtil.transferObjetoEntityDTOList(this.ventaDaoImpl.listarVenta(venta),VentaDTO.class,"tipoDocSunat","itemByTipoMoneda","cliente","pedido");
	}
	@Override
	public int contarListarVenta(VentaDTO venta){
		return  this.ventaDaoImpl.contarListarVenta(venta);
	}
	
	
	//add
	@Override
	public String generarReportePago(String idVenta,String idCliente,String usuario) throws Exception {
		String fileName = UUIDUtil.generarElementUUID();
		String codigoGeneradoReporte = fileName;
		UsuarioDTO resultado = null;
		Usuario resultadoEntity = null;
		try {
			ClienteDTO cliente = new ClienteDTO();
			cliente.setIdCliente(idCliente);
			cliente = this.controladorAccionCliente(cliente, AccionType.FIND_BY_ID);
			Map<String, Object> parametros = new HashMap<String, Object>();
			String[] subreportes;
			subreportes = new String[0];	
			parametros.put("nombreCliente", cliente.getNombre() + " " +  cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno());
			parametros.put("ruta", "");
			parametros.put("nroDocCli", cliente.getNroDoc());
			parametros.put("direccion", cliente.getDireccion());
			
			List<VentaDTO> listaVentaGenerar = new ArrayList<VentaDTO>();
			VentaDTO ventaReporte = new VentaDTO();
			ventaReporte.setIdVenta(idVenta);
			ventaReporte.setId(idCliente);
			ventaReporte.setCliente(cliente);

			ventaReporte = this.listarVenta(ventaReporte).get(0);
			if (ventaReporte.getCliente() == null || ventaReporte.getCliente().getIdCliente() == null) {
				ventaReporte.setCliente(new ClienteDTO());
			}
			parametros.put("nroDoc", ventaReporte.getNroDoc());
			resultadoEntity= this.usuarioServiceImpl.findUsuario(ventaReporte.getUsuarioCreacion());
			resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,UsuarioDTO.class);
			parametros.put("nombreCajero", resultado.getNombre()+ " " + resultado.getApellidoPaterno()+ " " +resultado.getApellidoMaterno());
			NumerosUtil numLetra= new NumerosUtil();
			parametros.put("montoLetra", numLetra.Convertir(ventaReporte.getMontoTotal().toString(), true));
			
			ventaReporte.setCliente(cliente);
			List<DetalleVentaDTO> listaDetVenta = new ArrayList<DetalleVentaDTO>();
			ventaReporte.setVentaDetalleVentaList(listaDetVenta);
			listaVentaGenerar.add(ventaReporte);
			NombreReporteType reporte = NombreReporteType.JR_REP_BOLETA_VENTA;
			ParametroReporteVO parametroReporteVO = new ParametroReporteVO(parametros, listaVentaGenerar, reporte, subreportes, null, true, "", "");
			parametroReporteVO.setFormato(TipoReporteGenerarType.PDF.getKey());
			parametroReporteVO.setUserName(usuario);
			parametroReporteVO.setFileName(fileName);
			codigoGeneradoReporte = generarReporteServiceImpl.obtenerParametroReporteBigMemory(parametroReporteVO);
			return codigoGeneradoReporte;
		} catch (Exception e) {
			log.error(e);
		}
		return codigoGeneradoReporte;
	}
	
	
	
	
	@Override
	public AvalDTO controladorAccionAval(AvalDTO Aval, AccionType accionType) throws Exception {
		AvalDTO resultado = null;
		Aval resultadoEntity = null;
		switch (accionType) {
			case CREAR:
				Aval.setIdAval(this.avalDaoImpl.generarIdAval());
				resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(Aval, Aval.class,"entidad@PK@","itemByTipoDocumentoIdentidad@PK@","itemByEstadoCivil@PK@");
				this.avalDaoImpl.save(resultadoEntity);	
				resultado = Aval;
				break;				
			case MODIFICAR:
			    resultadoEntity = TransferDataObjectUtil.transferObjetoEntity(Aval, Aval.class,"entidad@PK@","itemByTipoDocumentoIdentidad@PK@","itemByEstadoCivil@PK@");
				this.avalDaoImpl.update(resultadoEntity);
				resultado = Aval;	
				break;
				
			case ELIMINAR:
				resultadoEntity = this.avalDaoImpl.find(Aval.class, Aval.getIdAval());
				this.avalDaoImpl.delete(resultadoEntity);
				resultado = Aval;
				break;
				
			case FIND_BY_ID:
				resultadoEntity = this.avalDaoImpl.find(Aval.class, Aval.getIdAval());
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(resultadoEntity,AvalDTO.class,"itemByTipoDocumentoIdentidad");
				break;
				
			/*case FIND_BY_NOMBRE:
				resultado = TransferDataObjectUtil.transferObjetoEntityDTO(this.AvalDaoImpl.findByNombre(Aval),AvalDTO .class);
				break;*/
				
			default:
				break;
		}
		
		return resultado;
	}
	@Override
	public List<AvalDTO> listarAval(AvalDTO Aval) throws Exception {
		List<Aval> listaTemp = this.avalDaoImpl.listarAval(Aval);
		List<AvalDTO> listaCli = new ArrayList<AvalDTO>(); 
		for (Aval clie : listaTemp) {
			AvalDTO AvalDTO = TransferDataObjectUtil.transferObjetoEntityDTO(clie, AvalDTO.class, "itemByTipoDocumentoIdentidad", "itemByEstadoCivil");
			FileVO fileVO = new FileVO();
			fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  AvalDTO.getFoto());
			AvalDTO.setFoto(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
			listaCli.add(AvalDTO);
		}	
		listaTemp = null;
		return listaCli;
		//return TransferDataObjectUtil.transferObjetoEntityDTOList(this.AvalDaoImpl.listarAval(Aval),AvalDTO.class,"usuario","itemByTipoDocumentoIdentidad","itemByCategoriaAval","itemByEstadoCivil");
	}
	@Override
	public int contarListarAval(AvalDTO Aval){
		return  this.avalDaoImpl.contarListarAval(Aval);
	}
	
	 
}