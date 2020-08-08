package pe.com.edu.siaa.core.ejb.service.rest.common.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.com.edu.siaa.core.ejb.service.common.local.CommonServiceLocal;
import pe.com.edu.siaa.core.ejb.service.rest.impl.GenericServiceRestImpl;
import pe.com.edu.siaa.core.model.util.ConstanteConfigUtil;
import pe.com.edu.siaa.core.model.vo.FileVO;
import pe.com.edu.siaa.core.vo.ResultadoRestVO;


/**
 * La Class FileUploadRestController.
 * <ul>
 * <li>Copyright 2018 ndavilal -
 * ndavilal. Todos los derechos reservados.</li>
 * </ul>
 *
 * @author ndavilal
 * @version 2.1, 05/04/2018 03:13 pm
 * @since SIAA-CORE 2.1
 */
@Stateless
@Path("/fileUploadRestController")
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON)
public class FileUploadRestController extends GenericServiceRestImpl {
 
	@EJB
	private transient CommonServiceLocal commonServiceLocal;
	
	@POST
	@Path("/alumno")
	public ResultadoRestVO<FileVO> subirImagen(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
	@Path("/personal")
	public ResultadoRestVO<FileVO> subirImagenPersonal(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/alumno/{fotoImg}")
	public ResultadoRestVO<String> obtenerImagenEncodeBase64(@PathParam("fotoImg") String fotoImg) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  fotoImg);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/personal/{fotoImg}")
	public ResultadoRestVO<String> obtenerImagenEncodeBase64Personal(@PathParam("fotoImg") String fotoImg) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + "086" + fotoImg);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	
	
	@POST
	@Path("/subirpdfConvenio")
	public ResultadoRestVO<FileVO> subirPDF(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_CONVENIO + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/obtenerpdfConvenio/{pdf}")
	public ResultadoRestVO<String> obtenerPDFEncodeBase64(@PathParam("pdf") String pdf) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_CONVENIO + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  pdf);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	
	
	@POST
	@Path("/subirpdfTraslado")
	public ResultadoRestVO<FileVO> subirpdfTraslado(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_TRASLADO + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/obtenertrasladopdf/{pdf}")
	public ResultadoRestVO<String> obtenerpdfTrasladoEncodeBase64(@PathParam("pdf") String pdf) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_TRASLADO + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  pdf);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
	@Path("/subirpdfServicioActividad")
	public ResultadoRestVO<FileVO> subirpdfServicioActividad(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_SERVICIO_ACTIVIDAD + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/obtenerServicioActividadpdf/{pdf}")
	public ResultadoRestVO<String> obtenerServicioActividadpdfEncodeBase64(@PathParam("pdf") String pdf) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_SERVICIO_ACTIVIDAD + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  pdf);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	
	@POST
	@Path("/subirpdfFormacionActividad")
	public ResultadoRestVO<FileVO> subirpdfFormacionActividad(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_FORMACION_ACTIVIDAD + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/obtenerFormacionctividadpdf/{pdf}")
	public ResultadoRestVO<String> obtenerFormacionActividadpdfEncodeBase64(@PathParam("pdf") String pdf) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_FORMACION_ACTIVIDAD + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  pdf);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	
	
 
	@POST
	@Path("/subirpdfCvPerfiles")
	public ResultadoRestVO<FileVO> subirpdfCvPerfiles(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_CVPERFILES + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
	@Path("/subirLogoEmpresa")
	public ResultadoRestVO<FileVO> subirLogoEmpresa(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_LOGO_EMPRESAS + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@GET
	@Path("/obtenerLogoEmpresa/{logo}")
	public ResultadoRestVO<String> obtenerLogoEmpresa(@PathParam("logo") String logo) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_LOGO_EMPRESAS + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  logo);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}	
	
	@GET
	@Path("/obtenerPDFCvPerfiles/{pdf}")
	public ResultadoRestVO<String> obtenerPDFCvPerfiles(@PathParam("pdf") String pdf) throws Exception {
		ResultadoRestVO<String> resultado = new ResultadoRestVO<String>();
		 try {
			 FileVO fileVO = new FileVO();
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_PDF_CVPERFILES + ConstanteConfigUtil.SEPARADOR_FILE + "086" +  pdf);
			 resultado.setObjetoResultado(commonServiceLocal.obtenerImagenEncodeBase64(fileVO));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	
	@POST
	@Path("/subirDoc")
	public ResultadoRestVO<FileVO> subirDoc(FileVO fileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_DOC + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
			 commonServiceLocal.subirImagen(fileVO);
			 
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
	@Path("/obtenerListaImagenEncodeBase64")
	public ResultadoRestVO<FileVO> obtenerListaImagenEncodeBase64(FileVO[] fileVo) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {  
			 resultado.setListaResultado(commonServiceLocal.obtenerListaImagenEncodeBase64(fileVo));
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
	
	@POST
	@Path("/subirImagenesAdjunto")
	public ResultadoRestVO<FileVO> subirImagenesAdjunto(FileVO[] listaFileVO) throws Exception {
		ResultadoRestVO<FileVO> resultado = new ResultadoRestVO<FileVO>();
		 try {
			 for(FileVO fileVO:listaFileVO) {
				 fileVO.setRuta(ConstanteConfigUtil.RUTA_RECURSOS_FOTO_ALUMN + ConstanteConfigUtil.SEPARADOR_FILE + fileVO.getName() + "." + fileVO.getExtension());
				 commonServiceLocal.subirImagen(fileVO); 
			 }
		} catch (Exception e) {
			parsearResultadoError(e, resultado);
		}
		return resultado;
	}
}