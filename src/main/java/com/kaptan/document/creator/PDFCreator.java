package com.kaptan.document.creator;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * This class creates document with the given path
 * 
 * @author mustafa.kapdan
 *
 */
public class PDFCreator {

	public static Document createDocument(String filePath) {

		Document document = null;

		try {
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(filePath));

		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append(new Date());
			sb.append("\tERROR :: CREATE PDF DOCUMENT HALTED...");
			sb.append("\tREASON :: ");
			sb.append(e.toString());
		}

		return document;

	}

	public static PdfWriter createPDFWriter(String filePath) {

		PdfWriter writer = null;

		try {
			Document document = new Document();
			writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

		} catch (Exception e) {
			StringBuilder sb = new StringBuilder();
			sb.append(new Date());
			sb.append("\tERROR :: CREATE PDF WRITER HALTED...");
			sb.append("\tREASON :: ");
			sb.append(e.toString());
		}

		return writer;

	}

}
