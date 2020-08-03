package pe.com.builderp.core.facturacion.model.dto.venta;

import java.io.Serializable;
import java.math.BigDecimal;

import pe.com.edu.siaa.core.model.dto.BasePaginator;

/**
 * La Class DetalleVentaDTO.
 * <ul>
 * <li>Copyright 2017 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 1.0, Fri Dec 22 11:07:01 COT 2017
 * @since SIAA-CORE 2.1
 */
public class DetalleVentaDTO extends BasePaginator implements Serializable {
 
    /** La Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** El id detalle venta. */
    private String idDetalleVenta;
   
    /** El venta. */
    private VentaDTO venta;
   
    /** El producto. */
    private ProductoDTO producto;
   
    /** El descripcion producto. */
    private String descripcionProducto;
   
    /** El precio. */
    private BigDecimal precio;
   
    /** El cantidad. */
    private BigDecimal cantidad;
   
    /** El igv. */
    private BigDecimal igv;
    
    /** El descuento. */
    private BigDecimal descuento;
   
    /** El sub monto total. */
    private BigDecimal subMontoTotal;
   
    /** El monto total. */
    private BigDecimal montoTotal;
   
    /**
     * Instancia un nuevo detalle ventaDTO.
     */
    public DetalleVentaDTO() {
    }
   
   
    /**
     * Instancia un nuevo detalle ventaDTO.
     *
     * @param idDetalleVenta el id detalle venta
     * @param venta el venta
     * @param producto el producto
     * @param descripcionProducto el descripcion producto
     * @param precio el precio
     * @param cantidad el cantidad
     * @param descuento el descuento
     * @param subMontoTotal el sub monto total
     * @param montoTotal el monto total
     */
    public DetalleVentaDTO(String idDetalleVenta, VentaDTO venta,ProductoDTO producto,String descripcionProducto, BigDecimal precio, BigDecimal cantidad, BigDecimal descuento, BigDecimal subMontoTotal, BigDecimal montoTotal ) {
        super();
        this.idDetalleVenta = idDetalleVenta;
        this.venta = venta;
        this.producto = producto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.subMontoTotal = subMontoTotal;
        this.montoTotal = montoTotal;
    }
   
    //get y set
    /**
     * Obtiene id detalle venta.
     *
     * @return id detalle venta
     */
     public String getIdDetalleVenta() {
        return this.idDetalleVenta;
    }
    /**
     * Establece el id detalle venta.
     *
     * @param idDetalleVenta el new id detalle venta
     */
    public void setIdDetalleVenta(String idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }
    /**
     * Obtiene venta.
     *
     * @return venta
     */
     public VentaDTO getVenta() {
        return this.venta;
    }
    /**
     * Establece el venta.
     *
     * @param venta el new venta
     */
    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }
    /**
     * Obtiene producto.
     *
     * @return producto
     */
     public ProductoDTO getProducto() {
        return this.producto;
    }
    /**
     * Establece el producto.
     *
     * @param producto el new producto
     */
    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    /**
     * Obtiene descripcion producto.
     *
     * @return descripcion producto
     */
     public String getDescripcionProducto() {
        return this.descripcionProducto;
    }
    /**
     * Establece el descripcion producto.
     *
     * @param descripcionProducto el new descripcion producto
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    /**
     * Obtiene precio.
     *
     * @return precio
     */
     public BigDecimal getPrecio() {
        return this.precio;
    }
    /**
     * Establece el precio.
     *
     * @param precio el new precio
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    /**
     * Obtiene cantidad.
     *
     * @return cantidad
     */
     public BigDecimal getCantidad() {
        return this.cantidad;
    }
    /**
     * Establece el cantidad.
     *
     * @param cantidad el new cantidad
     */
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Obtiene igv.
     *
     * @return igv
     */
     public BigDecimal getIgv() {
        return this.igv;
    }
    /**
     * Establece el igv.
     *
     * @param igv el new igv
     */
    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }
    /**
     * Obtiene descuento.
     *
     * @return descuento
     */
     public BigDecimal getDescuento() {
        return this.descuento;
    }
    /**
     * Establece el descuento.
     *
     * @param descuento el new descuento
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
    /**
     * Obtiene sub monto total.
     *
     * @return sub monto total
     */
     public BigDecimal getSubMontoTotal() {
        return this.subMontoTotal;
    }
    /**
     * Establece el sub monto total.
     *
     * @param subMontoTotal el new sub monto total
     */
    public void setSubMontoTotal(BigDecimal subMontoTotal) {
        this.subMontoTotal = subMontoTotal;
    }
    /**
     * Obtiene monto total.
     *
     * @return monto total
     */
     public BigDecimal getMontoTotal() {
        return this.montoTotal;
    }
    /**
     * Establece el monto total.
     *
     * @param montoTotal el new monto total
     */
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idDetalleVenta == null) ? 0 : idDetalleVenta.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DetalleVentaDTO other = (DetalleVentaDTO) obj;
        if (idDetalleVenta == null) {
            if (other.idDetalleVenta != null) {
                return false;
            }
        } else if (!idDetalleVenta.equals(other.idDetalleVenta)) {
            return false;
        }
        return true;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DetalleVentaDTO [idDetalleVenta=" + idDetalleVenta + "]";
    }
   
}