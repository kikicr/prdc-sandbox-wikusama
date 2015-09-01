package com.anabatic.sandbox.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anabatic.sandbox.model.Role;
import com.anabatic.sandbox.model.User;
import com.anabatic.sandbox.service.UserManager;

@Controller
@RequestMapping("/report")
public class ReportController {
	private Map<String, Object> maps;
	private UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public String getReportPdf(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<User> users = userManager.getAll();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

		
		for (User user : users) {
			Map<String, Object> mapParam=new HashMap<String, Object>();
			System.out.println("versi baru,size =" + user.getId());
			mapParam.put("field1", user.getId());
			mapParam.put("field2", user.getName());
			mapParam.put("field3", user.getEmail());
			mapParam.put("field4", user.getAddress());
			
			for (Role role : user.getRole()) {
				mapParam.put("field5", role.getName());

			}
			resultList.add(mapParam);
		}
		
		System.out.println(resultList.size());
		
		
		
		try {
			JRDataSource jasperDataSource = new JRBeanCollectionDataSource(resultList);
		
			JasperReport jasperReport = JasperCompileManager
					.compileReport("D:/data akbar rizqi/development tools/reportExample.jrxml");
				
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport,maps, jasperDataSource);
			JRPdfExporter pdf=new JRPdfExporter();
			pdf.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			pdf.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"D:/sample1.pdf");
			pdf.exportReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/list-user";
	}

}
