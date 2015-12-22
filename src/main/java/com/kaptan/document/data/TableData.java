package com.kaptan.document.data;

import java.util.Map;
import java.util.TreeMap;
/**
 * This class holds properties of whole data in pdf table
 * @author mustafa.kapdan
 *
 */
public class TableData {

	private static int rowCount;
	// Row Order, Row Data
	private TreeMap<Integer, TableRowData> tableDataMap;

	public TableData() {
		super();
		rowCount = 0;
	}

	public TableData(TreeMap<Integer, TableRowData> tableDataMap) {
		super();
		this.tableDataMap = tableDataMap;
		rowCount = 0;
	}

	public TreeMap<Integer, TableRowData> getTableDataMap() {
		if (null == tableDataMap) {
			this.tableDataMap = new TreeMap<Integer, TableRowData>();
		}
		return tableDataMap;
	}

	public void setTableDataMap(TreeMap<Integer, TableRowData> tableDataMap) {
		this.tableDataMap = tableDataMap;
	}

	/**
	 * Header Row should be point as header
	 * 
	 * @return
	 */
	public int getNumbersOfColumn() {

		int numColumns = 0;
		Map.Entry<Integer, TableRowData> firstRow = getTableDataMap().firstEntry();
		if (null != firstRow) {
			if (firstRow.getValue().isHeaderRow()) {
				numColumns = firstRow.getValue().getDataMap().size();
			} else {

				/*
				 * Look for which one is header row
				 */
				for (Map.Entry<Integer, TableRowData> row : getTableDataMap().entrySet()) {
					if (row.getValue().isHeaderRow()) {
						numColumns = row.getValue().getDataMap().size();
						break;
					}
				}

				/**
				 * İlk satırı head kabul edelim. Kullanıcı, headerRow
				 * isaretlemeyi unutmus olabilir
				 */
				if (numColumns < 1) {
					numColumns = firstRow.getValue().getDataMap().size();
				}
			}
		}

		return numColumns;

	}

	public void addRowData(TableRowData rowData) {
		getTableDataMap().put(++rowCount, rowData);
	}

}
