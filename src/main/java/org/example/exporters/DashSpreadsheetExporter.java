package org.example.exporters;

import org.example.engine.SpreadsheetImpl;

public class DashSpreadsheetExporter extends AbstractExporter{

    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        super(sheet);
    }
    public String export() {
        return super.export("-");
    }

}
