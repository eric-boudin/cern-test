package org.example.exporters;

import org.example.engine.SpreadsheetImpl;

public class StarSpreadsheetExporter extends AbstractExporter{

    public StarSpreadsheetExporter(SpreadsheetImpl sheet) {
        super(sheet);
    }

    public String export() {
        return super.export("*");
    }
}
