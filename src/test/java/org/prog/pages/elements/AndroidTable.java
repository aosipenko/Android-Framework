package org.prog.pages.elements;

public enum AndroidTable {

    CELL_NAME("//table_row[%s]/table_column[%s]", 1),
    CELL_SURNAME("//table_row[%s]/table_column[%s]", 2),
    CELL_CARD_NUMBER("//table_row[%s]/table_column[%s]", 3);

    private final String xPathPattern;
    private final int columnIndex;

    AndroidTable(String xPathPattern, int index) {
        this.xPathPattern = xPathPattern;
        this.columnIndex = index;
    }

    public String getPath(int rowIndex) {
        return String.format(xPathPattern, rowIndex, columnIndex);
    }
}

/*
|NAME       |SURNAME    |CARD_NUMBER|
|OLEKSII    |OSYPENKO   |1234       |
|OLEKSII    |OSYPENKO   |4567       |
 */