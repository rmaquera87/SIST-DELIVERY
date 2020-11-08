package com.pe.delivery.resources;


import com.mysql.jdbc.Connection;
import com.pe.delivery.domain.Categoria;
import java.net.URI;

import javax.validation.Valid;
import com.pe.delivery.domain.Pedido;
import com.pe.delivery.dto.CategoriaDTO;
import com.pe.delivery.dto.PedidoDTO;
import com.pe.delivery.services.CategoriaService;
import com.pe.delivery.services.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.activation.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;



import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value = "/historial")
public class HistorialPedidoResource {
	@Autowired
	private CategoriaService service;
        
        @RequestMapping(method=RequestMethod.GET)
	public String historial() {
		
		return "Historial";
	}
        /*
        public void ejecutarReporte(String archivo) {
        try {
          Map parameters = new HashMap();
          parameters.put("TITULO", "PAISES");
          parameters.put("FECHA", new java.util.Date());
          JasperReport report = JasperCompileManager.compileReport(
              "C:\\informes JAsper\\JRXML\\InformeMySql.jrxml");
          
            WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
            Connection conn=null;
            DataSource datasource = (DataSource) applicationContext.getBean("datasource");
            conn = datasource.getConnection();
            
          JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
          // Exporta el informe a PDF
          JasperExportManager.exportReportToPdfFile(print,
              "C:\\informes JAsper\\PDF's\\InformePaisesMySQL.pdf");
          //Para visualizar el pdf directamente desde java
          JasperViewer.viewReport(print, false);
        }
        catch (Exception e) {
          e.printStackTrace();
        }

        }
        */

	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>>findAll() {
		List<Categoria> list= service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
  
                return ResponseEntity.ok().body(listDto);
	}*/
}
