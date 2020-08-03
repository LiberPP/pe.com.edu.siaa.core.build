package pe.com.edu.siaa.core.ejb.factory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pe.com.edu.siaa.core.ejb.util.excel.ExcelUtil;
import pe.com.edu.siaa.core.model.dto.ConfiguracionTramaDetalleDTO; 
import pe.com.edu.siaa.core.model.vo.AtributoEntityVO;


/**
 * <ul>
 * <li>Copyright 2017 ndavilal. Todos los derechos reservados.</li>
 * </ul> 
 * 
 * La Class Test.
 *
 * @author ndavilal
 * @version 1.0 , 07/04/2015
 * @since SIAA-CORE 2.1
 */
public class MigrarTablaPago {

	//private static Map<String,CatalogoCuentaDTO> catalogoCuentaMap = new HashMap<String, CatalogoCuentaDTO>();
	
	private static Map<String,String> pensionFraccionadoMap = new HashMap<String,String>();
	private static Map<String,String> pensionFraccionadoEquiValenciaMap = new HashMap<String,String>();
	
	static { 
		pensionFraccionadoMap.put("1RA", "");
		pensionFraccionadoMap.put("2DA", "");
		pensionFraccionadoMap.put("3RA", "");
		pensionFraccionadoMap.put("4TO", "");
		pensionFraccionadoMap.put("5TA", "");
		pensionFraccionadoEquiValenciaMap.put("4TA", "4TO");
		pensionFraccionadoEquiValenciaMap.put("5TO", "5TA");
		pensionFraccionadoEquiValenciaMap.put("3ER", "3RA");
		pensionFraccionadoEquiValenciaMap.put("1ERA", "1RA");
		pensionFraccionadoEquiValenciaMap.put("1 MATRICULA", "1 MATRICULA");
		
		pensionFraccionadoEquiValenciaMap.put("3ERA", "3RA");
		pensionFraccionadoEquiValenciaMap.put("2 DA", "2DA");
		
		
		pensionFraccionadoEquiValenciaMap.put("0MATRICULA", "0 MATRICULA");
	}
	/**
	 * El metodo principal.
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {		
		try {
			//CONTROL_DE_PAGOS_2017_-_I_(20)
			//hoja2
			System.out.println("Inici0 listaitem Procesando exel " + new Date());
			File rutaArchivo = new File("F:\\pag\\CONTROL_DE_PAGO_2015_-_2016_(7).xlsx");
			XSSFWorkbook hSSFWorkbook = ExcelUtil.leerExcelXlsx(rutaArchivo);
			
			Map<String,Integer> campoMappingExcelDetalleDataMap = new HashMap<String, Integer>();
			campoMappingExcelDetalleDataMap.put("nombreCampo", 0);//RESPONSE_APP
			campoMappingExcelDetalleDataMap.put("codigoUUID", 1);//ORIGIN_CODE
			campoMappingExcelDetalleDataMap.put("descripcionCampo", 2);//DESCRIPTION
			
			
			//Forma 1
			int contadorItem = 0;
			List<ConfiguracionTramaDetalleDTO> listaItem = transferObjetoEntityExcelXlsxDTO(hSSFWorkbook, 1 , 2, campoMappingExcelDetalleDataMap, ConfiguracionTramaDetalleDTO.class,null);
			long generarCodigo = 1;
			System.out.println("lista Obtenida del XLSX " + listaItem.size());
			StringBuilder sql = new StringBuilder();
			sql.append("delete from TIN.RESULT;\n");
			for (ConfiguracionTramaDetalleDTO itemDTO : listaItem) {
				itemDTO.setOrden(generarCodigo);
				sql.append("insert into [TIN].[RESULT] (RESPONSE_APP,ORIGIN_CODE,DESCRIPTION,RESPONSE_CODE) values('" + itemDTO.getNombreCampo()+ "', '" + itemDTO.getCodigoUUID() + "','" + itemDTO.getDescripcionCampo() + "','00');\n");
				generarCodigo++;
			}
			crearArchivo("TIN.RESULT", sql);
			System.out.println("fin TIN.RESULT.sql " + new Date());
			sql = null;
			System.out.println("Inici0 RESULT Procesando exel " + new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public  static <T> List<T>  transferObjetoEntityExcelXlsxDTO(XSSFWorkbook  workBook,int hoja,int filaData,Map<String,Integer> campoMappingExcelMap,Class<T> entityClassDTO, Integer cantidaData) {
		List<T> resultado = new ArrayList<T>();
		try {
			if (workBook == null) {
				return null;
			}
			List<AtributoEntityVO> listaAtributos = AtributosEntityCacheUtil.getInstance().obtenerListaAtributos(entityClassDTO);
			XSSFSheet hssfSheet = workBook.getSheetAt(hoja - 1);
			int contador = 0;
			int cantidadNulos = 0;
			int cantidaDataProcesar = 0;
			while (cantidadNulos <= 2) {
				XSSFRow hssfRow = hssfSheet.getRow(contador);
				if (hssfRow == null) {
					cantidadNulos++;
				}
				contador++;
				if (contador >= filaData) {
					cantidaDataProcesar++;
					if (hssfRow != null) {
						T resultadoTemp = entityClassDTO.newInstance();
						for (AtributoEntityVO objAtr : listaAtributos) {
							if (campoMappingExcelMap.containsKey(objAtr.getNombreAtributo())) {
								Field f = resultadoTemp.getClass().getDeclaredField(objAtr.getNombreAtributo());
								f.setAccessible(true);
								Object value = TransferDataObjectUtil.obtenerValorXlsx(hssfRow, campoMappingExcelMap.get(objAtr.getNombreAtributo()), objAtr);
								if (value != null) {
									f.set(resultadoTemp, value) ;
								}
							}
						}	
						resultado.add(resultadoTemp);
					}
					
					if (cantidaData != null) {
						if (cantidaDataProcesar == cantidaData) {
							break;
						}
					}
				}
				
			}	
			if (workBook != null) {
				workBook.close();
			}
		} catch (Exception e) {
			System.err.println("Error TransferDataObjectUtil.transferObjetoEntityExcelXlsxDTO(Object ressul,Class<T> entityClassDTO) al parsear " + entityClassDTO.getName() + "  " + e.getMessage() );
		}
		return resultado;
	}
	
	
	
	 private static void crearArchivo(String nombre,StringBuilder data) {
	        try {
	            String ruta = "f:/banbif/" + nombre + ".sql";
	            File archivo = new File(ruta);
	            BufferedWriter bw;
	            archivo.delete();
	            if(archivo.exists()) {
	                 archivo.delete();
	            } 
	             bw = new BufferedWriter(new FileWriter(archivo));
	             bw.write(data.toString());
	            bw.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }	
	
	
	

}
