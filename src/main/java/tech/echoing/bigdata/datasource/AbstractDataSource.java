package tech.echoing.bigdata.datasource;

import tech.echoing.bigdata.bean.ReportResult;

/**
 * 数据源抽象类
 */
public abstract class AbstractDataSource {

    /**
     * 数据库类型
     *
     * @return
     */
    public abstract DbType getDbType();

    /**
     * 获取单个double类型的值（用于校验数据）
     *
     * @param sql
     * @return
     */
    public abstract Double queryForSingleDoubleValue(String sql);

    /**
     * 获取报告结果
     *
     * @param sql
     * @return
     */
    public abstract ReportResult queryForReportResult(String sql);

}
