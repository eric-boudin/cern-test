package org.example.engine;

import org.example.enums.ValueType;

import java.util.ArrayList;
import java.util.List;

public class SpreadsheetImpl {
    private int rows;
    private int columns;

    List<List<String>> sheet;

    private SpreadsheetImpl(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        sheet = new ArrayList<>(rows);
        for(int i = 0; i<rows; i++) {
            sheet.add(new ArrayList<>(columns));
            for(int j=0; j<columns; j++) {
                sheet.get(i).add("");
            }
        }
    }

    public String get(int row, int column) {
        checkLimits(row, column);
        return sheet.get(row).get(column);
    }

    public void put (int row, int column, String value) {
        checkLimits(row, column);
        if(isInteger(value.trim())) {
            sheet.get(row).set(column, value.trim());
        }
        else {
            sheet.get(row).set(column, value);
        }
    }

    public ValueType getValueType(int row, int column) {
        checkLimits(row, column);
        String value = sheet.get(row).get(column);

        if(value.startsWith("=")) {
            return ValueType.FORMULA;
        }
        else if (isInteger(value)){
            return ValueType.INTEGER;
        }
        return ValueType.STRING;
    }

    private void checkLimits(int row, int column) {
        if(row < 0 && column < 0) {
            throw new IllegalArgumentException("Rows and columns values must be equals or higher than 0");
        }
        else if(row > this.rows || column > this.columns) {
            throw new IndexOutOfBoundsException("Rows must be between 0 and "+ (this.rows-1) + " and column must be between 0 and " + (this.columns-1));
        }
    }

    private boolean isInteger(String valueToCheck) {
        try {
            Integer.parseInt(valueToCheck);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public class Office {
        public static SpreadsheetImpl newSpreadsheet(int rows, int columns){
            if(rows > 0 && columns > 0) {
                return new SpreadsheetImpl(rows, columns);
            }
            else {
                throw new IllegalArgumentException("Rows and columns values must be higher than 0");
            }
        }
    }
}
