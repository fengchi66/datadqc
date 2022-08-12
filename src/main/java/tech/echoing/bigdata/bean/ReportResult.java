package tech.echoing.bigdata.bean;

import lombok.Data;

import java.util.List;

@Data
public class ReportResult {

    /**
     * 列名
     */
    private List<String> columns;

    /**
     * 结果集
     */
    private List<List<Object>> rows;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }


}
