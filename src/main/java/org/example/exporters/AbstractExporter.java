package org.example.exporters;

import org.example.engine.SpreadsheetImpl;

public abstract class AbstractExporter {
    protected SpreadsheetImpl spreadsheet;

    protected AbstractExporter(SpreadsheetImpl sheet) {
        this.spreadsheet = sheet;
    }

    protected String export(String separator) {
        StringBuilder builder = new StringBuilder(spreadsheet.getRowSize() + "," + spreadsheet.getColumnsSize() + "#");
        for(int i=0; i<spreadsheet.getRowSize(); i++) {
            spreadsheet.getSheet().get(i).forEach(column -> {
                if("".equals(column)){
                    builder.append(separator);
                }
                else {
                    builder.append(column).append(separator);
                }
            });
        }
        return builder.toString();
    };

}
