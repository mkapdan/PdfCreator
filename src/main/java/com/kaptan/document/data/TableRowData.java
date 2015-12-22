package com.kaptan.document.data;

import java.util.TreeMap;

/**
 * This class holds properties of each row data in pdf table
 * 
 * @author mustafa.kapdan
 *
 */
public class TableRowData {

	private static int cellCount;

	private int aligment = 1; // Default none

	private boolean isHeaderRow; // This sign to draw header row

	// Column Order, Column Data
	private TreeMap<Integer, TableCellData> dataMap;

	public TableRowData(boolean isHeaderRow, TreeMap<Integer, TableCellData> dataMap) {
		super();
		this.isHeaderRow = isHeaderRow;
		this.dataMap = dataMap;
		cellCount = 0;
	}

	public TableRowData() {
		super();
		cellCount = 0;
	}

	public TableRowData(boolean isHeaderRow) {
		super();
		this.isHeaderRow = isHeaderRow;
		cellCount = 0;
	}

	public TableRowData(int aligment) {
		super();
		this.aligment = aligment;
		cellCount = 0;
	}

	public TableRowData(int aligment, boolean isHeaderRow) {
		super();
		this.aligment = aligment;
		this.isHeaderRow = isHeaderRow;
		cellCount = 0;
	}

	public TreeMap<Integer, TableCellData> getDataMap() {
		if (null == dataMap) {
			this.dataMap = new TreeMap<Integer, TableCellData>();
		}
		return dataMap;
	}

	public void setDataMap(TreeMap<Integer, TableCellData> dataMap) {
		this.dataMap = dataMap;
	}

	public boolean isHeaderRow() {
		return isHeaderRow;
	}

	public void setHeaderRow(boolean isHeaderRow) {
		this.isHeaderRow = isHeaderRow;
	}

	public int getAligment() {
		return aligment;
	}

	public void setAligment(int aligment) {
		this.aligment = aligment;
	}

	public void addCell(TableCellData cellData) {

		getDataMap().put(++cellCount, cellData);
	}

}
