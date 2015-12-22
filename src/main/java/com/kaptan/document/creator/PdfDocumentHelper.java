package com.kaptan.document.creator;

import java.util.Map;
import java.util.TreeMap;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.kaptan.document.config.FrequentlyUsedFontStyles;
import com.kaptan.document.data.DocumentMetaData;
import com.kaptan.document.data.TableCellData;
import com.kaptan.document.data.TableData;
import com.kaptan.document.data.TableRowData;

/**
 * This class helps you create PDF documemnt.
 * 
 * @author mustafa.kapdan
 *
 */
public class PdfDocumentHelper {

	public static void addMetaData(Document document, DocumentMetaData metadata) {
		document.addTitle(metadata.getTitle());
		document.addSubject(metadata.getSubject());
		document.addKeywords(metadata.getLinearizedKeys());
		document.addAuthor(metadata.getAuthor());
		document.addCreator(metadata.getCreator());
	}

	public static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static List createList(boolean numbered, boolean lettered, float symbolIndent) {
		List list = new List(numbered, lettered, symbolIndent);

		return list;
	}

	public static ListItem createListItem(String string) {
		ListItem listItem = new ListItem(string);
		return listItem;
	}

	public static Paragraph createTitle(String title) {
		return createParagraph(title, FrequentlyUsedFontStyles.TITLE, -1);
	}

	public static Paragraph createTitle(String title, int alignment) {
		return createParagraph(title, FrequentlyUsedFontStyles.TITLE, alignment);
	}

	public static Paragraph createTitle(String title, Font font) {
		return createParagraph(title, font, -1);
	}

	public static Paragraph createTitle(String title, Font font, int alignment) {
		return createParagraph(title, font, alignment);
	}

	public static Paragraph createSubTitle(String title) {
		return createParagraph(title, FrequentlyUsedFontStyles.SUB_TITLE, -1);
	}

	public static Paragraph createSubTitle(String title, int alignment) {
		return createParagraph(title, FrequentlyUsedFontStyles.SUB_TITLE, alignment);
	}

	public static Paragraph createSubTitle(String title, Font font) {
		return createParagraph(title, font, -1);
	}

	public static Paragraph createSubTitle(String title, Font font, int alignment) {
		return createParagraph(title, font, alignment);
	}

	public static Paragraph createParagraph(String title) {
		Paragraph paragraph = null;
		paragraph = new Paragraph(title, FrequentlyUsedFontStyles.NORMAL_TEXT);
		return paragraph;
	}

	public static Paragraph createParagraph(String title, Font font) {
		return createParagraph(title, font, -1);
	}

	public static Paragraph createParagraph(String title, int alignment) {
		Paragraph paragraph = null;
		paragraph = new Paragraph(title);
		if (alignment >= 0) {
			paragraph.setAlignment(alignment);
		}

		return paragraph;
	}

	public static Paragraph createParagraph(String title, Font font, int alignment) {
		Paragraph paragraph = null;
		paragraph = new Paragraph(title, font);
		if (alignment >= 0) {
			paragraph.setAlignment(alignment);
		}

		return paragraph;
	}

	public static PdfPTable createTable(TableData tableData) throws BadElementException {
		PdfPTable table = new PdfPTable(tableData.getNumbersOfColumn());
		table.setHeaderRows(1);
		fillTableContent(table, tableData.getTableDataMap());
		return table;

	}

	private static void fillTableContent(PdfPTable table, TreeMap<Integer, TableRowData> tableDataMap) {

		// Iterate over each row
		for (Map.Entry<Integer, TableRowData> rowDataMap : tableDataMap.entrySet()) {

			// Get next row
			TableRowData row = rowDataMap.getValue();

			// Look for row based alignment
			int rowAlignment = row.getAligment();
			for (Map.Entry<Integer, TableCellData> cellDataMap : row.getDataMap().entrySet()) {

				TableCellData cellData = cellDataMap.getValue();
				String cellValue = cellData.getCellValue();

				// If cell alignment did not set, directly use row alignment
				int cellAlignment = cellData.getAlignment();
				if (cellAlignment < 0) {
					cellAlignment = rowAlignment;
				}

				Phrase phrase = null;

				if (null != cellData.getFont()) {
					phrase = new Phrase(cellValue, cellData.getFont());
				} else {
					phrase = new Phrase(cellValue);
				}
				cellData.setPhrase(phrase);
				cellData.setHorizontalAlignment(cellAlignment);
				table.addCell(cellData);
			}
		}
	}

	public static Anchor createAnchor(String name, Font font) {
		Anchor anchor = new Anchor(name, font);
		anchor.setName(name);
		return anchor;
	}

	public static Chapter createChapter(String name, Font font, int chapterNumber) {
		return new Chapter(new Paragraph(createAnchor(name, font)), chapterNumber);
	}

	public static Chapter createBlankChapter(int chapterNo) {
		return new Chapter(new Paragraph(), chapterNo);
	}

}