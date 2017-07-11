package com.pensumorganizer.ejb;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pensumorganizer.util.structures.Course;

public class Pdfgenerator extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AutoPrioritizerEJBImpl Apei = new AutoPrioritizerEJBImpl(); 
	public void generator(HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("application/pdf");
		Map<Integer, List<Course>> pensum = Apei.getOrganizedPensum();
		Font f1 = new Font();
		f1.setColor(BaseColor.WHITE);
		f1.setStyle("BOLD");
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, response.getOutputStream());
			PdfPTable reorganization = new PdfPTable(6);
			PdfPCell trimesterTitle;
			doc.open();
			doc.add(new Paragraph(new Date().toString()));
			
			
			for (int trimester = 0; trimester< pensum.size();trimester++) {
				Phrase title = new Phrase("Trimestre "+ trimester);
				String preReqs = new String();
				String coReqs = new String();
				title.setFont(f1);
				trimesterTitle = new PdfPCell(title);
				trimesterTitle.setColspan(6);
				trimesterTitle.setBackgroundColor(new BaseColor(236,62,62));
				reorganization.addCell(trimesterTitle);
				List<Course> subjects = pensum.get(trimester);
				reorganization.addCell("Clave");
				reorganization.addCell("Asigantura");
				reorganization.addCell("Créditos");
				reorganization.addCell("Pre-Requisito");
				reorganization.addCell("Co-Requisito");
				reorganization.addCell("Créditos Requeridos");
				
				for (Course course : subjects) {
					reorganization.addCell(course.getId());
					reorganization.addCell(course.getName());
					reorganization.addCell(Integer.toString(course.getCredits()));
					for (String id : course.getPreqID()) {
						preReqs += " "+id;
					}
					for (String id : course.getCoReqID()) {
						coReqs += " "+id;
					}
					reorganization.addCell(preReqs);
					reorganization.addCell(coReqs);
					reorganization.addCell(Integer.toString(course.getCreditsReq()));
				}
				
			}
			doc.add(new Paragraph(""));
			doc.add(reorganization);
			 
	         doc.close();
		} catch (DocumentException e) {
			throw new IOException(e.getMessage());
			// TODO: handle exception
		}
		
	}

}
