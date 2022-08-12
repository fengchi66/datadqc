package tech.echoing.bigdata.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import tech.echoing.bigdata.bean.DataResource;
import tech.echoing.bigdata.bean.ReportResult;
import tech.echoing.bigdata.util.ArrayUtil;
import tech.echoing.bigdata.util.SqlUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class PrestoDataSource extends AbstractDataSource {

    private DataResource dataResource;

    private Map<String, JdbcTemplate> jdbcTemplateMap = new HashMap<>();

    public PrestoDataSource() {
    }

    public PrestoDataSource(DataResource dataResource) {
        this.dataResource = dataResource;
    }

    @Override
    public DbType getDbType() {
        return DbType.presto;
    }

    @Override
    public Double queryForSingleDoubleValue(String sql) {
        return getJdbcTemplate(dataResource).queryForObject(sql, Double.class);
    }

    @Override
    public ReportResult queryForReportResult(String sql) {
        ReportResult reportResult = new ReportResult();

        List<List<Object>> rows = new ArrayList<>();

        try {
            sql = SqlUtil.limit500(sql);

            List<Map<String, Object>> result = getJdbcTemplate(dataResource).queryForList(sql);

            for (Map map : result) {
                //设置column
                if (ArrayUtil.isEmpty(reportResult.getColumns())) {
                    reportResult.setColumns(new ArrayList<>(map.keySet()));
                }

                //设置rows
                rows.add(new ArrayList<>(map.values()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        reportResult.setRows(rows);
        return reportResult;
    }

    /**
     * 根据DataResource 构建对应JdbcTemplate
     *
     * @param dataResource
     * @return
     */
    private JdbcTemplate getJdbcTemplate(DataResource dataResource) {

        JdbcTemplate jdbcTemplate = jdbcTemplateMap.get(dataResource.getResourceId());
        if (jdbcTemplate != null) {
            return jdbcTemplate;
        }

        //构造dataSource
        DruidDataSource dataSource = new DruidDataSource();

        // TODO presto相关的数据库连接从apollo配置中获取
        dataSource.setUrl(generateConnectUrl(dataResource.getDbHost(), dataResource.getDbName()));
        dataSource.setUsername("datadqc");
        dataSource.setPassword(null);
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(4);
        dataSource.setMinIdle(1);
        dataSource.setMaxWait(10000);
        dataSource.setQueryTimeout(10000);

        return new JdbcTemplate(dataSource);
    }

    /**
     * 生成jdbc url
     *
     * @param dbHost
     * @param dbName
     * @return
     */
    private String generateConnectUrl(String dbHost, String dbName) {
        return "jdbc:presto://" + dbHost + "/" + "hive" + "/" + dbName;
    }
}
