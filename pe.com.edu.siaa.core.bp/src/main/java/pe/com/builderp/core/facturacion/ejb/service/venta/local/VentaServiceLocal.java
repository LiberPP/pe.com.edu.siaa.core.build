package pe.com.builderp.core.facturacion.ejb.service.venta.local;

import java.util.List;

import javax.ejb.Local;

import pe.com.builderp.core.contabilidad.model.vo.RegistroAsientoFiltroVO;
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
import pe.com.edu.siaa.core.model.type.AccionType;

/**
 * La Class VentaServiceLocal.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, Thu Dec 28 12:32:52 COT 2017
 * @since SIAA-CORE 2.1
 */
@Local
public interface VentaServiceLocal{
	
	String generarReporteProductoCodigoBarra(ProductoDTO productoFiltro) throws Exception;
	
	List<DetalleVentaDTO> listarDetalleVenta(DetalleVentaDTO detalleVenta) throws Exception;
	
	String generarReporteRegistroVentaTXT(RegistroAsientoFiltroVO registroVentaFiltro) throws Exception;
	
	String generarReporteRegistroVenta(RegistroAsientoFiltroVO registroVentaFiltro) throws Exception;
	/**
	 * Controlador accion categoria.
	 *
	 * @param categoria el categoria
	 * @param accionType el accion type
	 * @return the categoria
	 * @throws Exception the exception
	 */
	CategoriaDTO controladorAccionCategoria(CategoriaDTO categoria,AccionType accionType) throws Exception; 
	
	/**
	 * Listar categoria.
	 *
	 * @param categoria el categoria
	 * @return the list
	 * @throws Exception the exception
	 */
	List<CategoriaDTO> listarCategoria(CategoriaDTO categoria) throws Exception;
	
	/**
	 * contar lista categoria.
	 *
	 * @param categoria el categoria
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCategoria(CategoriaDTO categoria);
	
	/**
	 * Controlador accion cliente.
	 *
	 * @param cliente el cliente
	 * @param accionType el accion type
	 * @return the cliente
	 * @throws Exception the exception
	 */
	ClienteDTO controladorAccionCliente(ClienteDTO cliente,AccionType accionType) throws Exception; 
	
	/**
	 * Listar cliente.
	 *
	 * @param cliente el cliente
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ClienteDTO> listarCliente(ClienteDTO cliente) throws Exception;
	
	/**
	 * contar lista cliente.
	 *
	 * @param cliente el cliente
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarCliente(ClienteDTO cliente);
	
	/**
	 * Controlador accion configuracion atributo.
	 *
	 * @param configuracionAtributo el configuracion atributo
	 * @param accionType el accion type
	 * @return the configuracion atributo
	 * @throws Exception the exception
	 */
	ConfiguracionAtributoDTO controladorAccionConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo,AccionType accionType) throws Exception; 
	
	/**
	 * Listar configuracion atributo.
	 *
	 * @param configuracionAtributo el configuracion atributo
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ConfiguracionAtributoDTO> listarConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo) throws Exception;
	
	/**
	 * contar lista configuracion atributo.
	 *
	 * @param configuracionAtributo el configuracion atributo
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarConfiguracionAtributo(ConfiguracionAtributoDTO configuracionAtributo);
	
	/**
	 * Controlador accion configuracion atributo value.
	 *
	 * @param configuracionAtributoValue el configuracion atributo value
	 * @param accionType el accion type
	 * @return the configuracion atributo value
	 * @throws Exception the exception
	 */
	ConfiguracionAtributoValueDTO controladorAccionConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue,AccionType accionType) throws Exception; 
	
	/**
	 * Listar configuracion atributo value.
	 *
	 * @param configuracionAtributoValue el configuracion atributo value
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ConfiguracionAtributoValueDTO> listarConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue) throws Exception;
	
	/**
	 * contar lista configuracion atributo value.
	 *
	 * @param configuracionAtributoValue el configuracion atributo value
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarConfiguracionAtributoValue(ConfiguracionAtributoValueDTO configuracionAtributoValue);
	
	/**
	 * Controlador accion detalle pedido.
	 *
	 * @param detallePedido el detalle pedido
	 * @param accionType el accion type
	 * @return the detalle pedido
	 * @throws Exception the exception
	 */
	DetallePedidoDTO controladorAccionDetallePedido(DetallePedidoDTO detallePedido,AccionType accionType) throws Exception; 
	
	/**
	 * Listar detalle pedido.
	 *
	 * @param detallePedido el detalle pedido
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DetallePedidoDTO> listarDetallePedido(DetallePedidoDTO detallePedido) throws Exception;
	
	/**
	 * contar lista detalle pedido.
	 *
	 * @param detallePedido el detalle pedido
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarDetallePedido(DetallePedidoDTO detallePedido);
	
	/**
	 * Controlador accion detalle proforma.
	 *
	 * @param detalleProforma el detalle proforma
	 * @param accionType el accion type
	 * @return the detalle proforma
	 * @throws Exception the exception
	 */
	DetalleProformaDTO controladorAccionDetalleProforma(DetalleProformaDTO detalleProforma,AccionType accionType) throws Exception; 
	
	/**
	 * Listar detalle proforma.
	 *
	 * @param detalleProforma el detalle proforma
	 * @return the list
	 * @throws Exception the exception
	 */
	List<DetalleProformaDTO> listarDetalleProforma(DetalleProformaDTO detalleProforma) throws Exception;
	
	/**
	 * contar lista detalle proforma.
	 *
	 * @param detalleProforma el detalle proforma
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarDetalleProforma(DetalleProformaDTO detalleProforma);
	
	
	/**
	 * Controlador accion linea.
	 *
	 * @param linea el linea
	 * @param accionType el accion type
	 * @return the linea
	 * @throws Exception the exception
	 */
	LineaDTO controladorAccionLinea(LineaDTO linea,AccionType accionType) throws Exception; 
	
	/**
	 * Listar linea.
	 *
	 * @param linea el linea
	 * @return the list
	 * @throws Exception the exception
	 */
	List<LineaDTO> listarLinea(LineaDTO linea) throws Exception;
	
	/**
	 * contar lista linea.
	 *
	 * @param linea el linea
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarLinea(LineaDTO linea);
	
	/**
	 * Controlador accion marca.
	 *
	 * @param marca el marca
	 * @param accionType el accion type
	 * @return the marca
	 * @throws Exception the exception
	 */
	MarcaDTO controladorAccionMarca(MarcaDTO marca,AccionType accionType) throws Exception; 
	
	/**
	 * Listar marca.
	 *
	 * @param marca el marca
	 * @return the list
	 * @throws Exception the exception
	 */
	List<MarcaDTO> listarMarca(MarcaDTO marca) throws Exception;
	
	/**
	 * contar lista marca.
	 *
	 * @param marca el marca
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarMarca(MarcaDTO marca);
	
	/**
	 * Controlador accion modelo.
	 *
	 * @param modelo el modelo
	 * @param accionType el accion type
	 * @return the modelo
	 * @throws Exception the exception
	 */
	ModeloDTO controladorAccionModelo(ModeloDTO modelo,AccionType accionType) throws Exception; 
	
	/**
	 * Listar modelo.
	 *
	 * @param modelo el modelo
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ModeloDTO> listarModelo(ModeloDTO modelo) throws Exception;
	
	/**
	 * contar lista modelo.
	 *
	 * @param modelo el modelo
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarModelo(ModeloDTO modelo);
	
	/**
	 * Controlador accion pedido.
	 *
	 * @param pedido el pedido
	 * @param accionType el accion type
	 * @return the pedido
	 * @throws Exception the exception
	 */
	PedidoDTO controladorAccionPedido(PedidoDTO pedido,AccionType accionType) throws Exception; 
	
	/**
	 * Listar pedido.
	 *
	 * @param pedido el pedido
	 * @return the list
	 * @throws Exception the exception
	 */
	List<PedidoDTO> listarPedido(PedidoDTO pedido) throws Exception;
	
	/**
	 * contar lista pedido.
	 *
	 * @param pedido el pedido
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarPedido(PedidoDTO pedido);
	
	/**
	 * Controlador accion producto.
	 *
	 * @param producto el producto
	 * @param accionType el accion type
	 * @return the producto
	 * @throws Exception the exception
	 */
	ProductoDTO controladorAccionProducto(ProductoDTO producto,AccionType accionType) throws Exception; 
	
	/**
	 * Listar producto.
	 *
	 * @param producto el producto
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ProductoDTO> listarProducto(ProductoDTO producto) throws Exception;
	
	/**
	 * contar lista producto.
	 *
	 * @param producto el producto
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarProducto(ProductoDTO producto);
	
	/**
	 * Controlador accion proforma.
	 *
	 * @param proforma el proforma
	 * @param accionType el accion type
	 * @return the proforma
	 * @throws Exception the exception
	 */
	ProformaDTO controladorAccionProforma(ProformaDTO proforma,AccionType accionType) throws Exception; 
	
	/**
	 * Listar proforma.
	 *
	 * @param proforma el proforma
	 * @return the list
	 * @throws Exception the exception
	 */
	List<ProformaDTO> listarProforma(ProformaDTO proforma) throws Exception;
	
	/**
	 * contar lista proforma.
	 *
	 * @param proforma el proforma
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarProforma(ProformaDTO proforma);
	
	/**
	 * Controlador accion tipo doc sunat entidad.
	 *
	 * @param tipoDocSunatEntidad el tipo doc sunat entidad
	 * @param accionType el accion type
	 * @return the tipo doc sunat entidad
	 * @throws Exception the exception
	 */
	TipoDocSunatEntidadDTO controladorAccionTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad,AccionType accionType) throws Exception; 
	
	/**
	 * Listar tipo doc sunat entidad.
	 *
	 * @param tipoDocSunatEntidad el tipo doc sunat entidad
	 * @return the list
	 * @throws Exception the exception
	 */
	List<TipoDocSunatEntidadDTO> listarTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad) throws Exception;
	
	/**
	 * contar lista tipo doc sunat entidad.
	 *
	 * @param tipoDocSunatEntidad el tipo doc sunat entidad
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarTipoDocSunatEntidad(TipoDocSunatEntidadDTO tipoDocSunatEntidad);
	
	/**
	 * Controlador accion venta.
	 *
	 * @param venta el venta
	 * @param accionType el accion type
	 * @return the venta
	 * @throws Exception the exception
	 */
	VentaDTO registrarVenta(VentaDTO venta) throws Exception; 
	
	/**
	 * Listar venta.
	 *
	 * @param venta el venta
	 * @return the list
	 * @throws Exception the exception
	 */
	List<VentaDTO> listarVenta(VentaDTO venta) throws Exception;
	
	/**
	 * contar lista venta.
	 *
	 * @param venta el venta
	 * @return the list
	 * @throws Exception the exception
	 */
	int contarListarVenta(VentaDTO venta);
	
	String generarReportePago(String idVenta,String idCliente,String usuario) throws Exception;
	
}