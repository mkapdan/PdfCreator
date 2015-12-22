package com.kaptan.document.data;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * This class holds properties of cell in pdf table
 * 
 * @author mustafa.kapdan
 *
 */
public class TableCellData extends PdfPCell {

	private int alignment = -1; // Default center

	private String cellValue;

	private Font font;

	public TableCellData() {
		super();
	}

	public TableCellData(String cellValue) {
		super();
		this.cellValue = cellValue;
	}

	public TableCellData(int alignment, String cellValue) {
		super();
		this.alignment = alignment;
		this.cellValue = cellValue;
	}

	public TableCellData(int alignment, String cellValue, Font font) {
		super();
		this.alignment = alignment;
		this.cellValue = cellValue;
		this.font = font;
	}

	public TableCellData(String cellValue, Font font) {
		super();
		this.cellValue = cellValue;
		this.font = font;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellValue == null) ? 0 : cellValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableCellData other = (TableCellData) obj;
		if (cellValue == null) {
			if (other.cellValue != null)
				return false;
		} else if (!cellValue.equals(other.cellValue))
			return false;
		return true;
	}

	public String getCellValue() {
		return cellValue;
	}

	public void setCellValue(String cellValue) {
		this.cellValue = cellValue;
	}

	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

}
