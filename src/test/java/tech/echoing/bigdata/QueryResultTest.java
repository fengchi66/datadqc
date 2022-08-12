package tech.echoing.bigdata;

import com.apple.eawt.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.echoing.bigdata.bean.DataResource;
import tech.echoing.bigdata.bean.ReportResult;
import tech.echoing.bigdata.datasource.MysqlDataSource;
import tech.echoing.bigdata.datasource.PrestoDataSource;
import tech.echoing.bigdata.service.DataResourceServiceImpl;

@SpringBootApplication(scanBasePackages = "tech.echoing.bigdata")
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class QueryResultTest {

    @Autowired
    private DataResourceServiceImpl impl;


    @Test
    public void mysqlSql() {
        DataResource dataResource = new DataResource();
        dataResource.setDbName("dwd");
        dataResource.setDbHost("10.20.180.2:9030");

        MysqlDataSource mysqlDataSource = new MysqlDataSource(dataResource);
        Double doubleValue = mysqlDataSource.queryForSingleDoubleValue("SELECT COUNT(1) FROM dwd_access_log");

        System.out.println(doubleValue);
    }

    @Test
    public void mysqlSql2() {
        DataResource dataResource = new DataResource();
        dataResource.setDbName("dwd");
        dataResource.setDbHost("10.20.180.2:9030");

        MysqlDataSource mysqlDataSource = new MysqlDataSource(dataResource);

        ReportResult reportResult = mysqlDataSource.queryForReportResult("SELECT * FROM dwd_access_log");

        System.out.println(reportResult);

    }

    @Test
    public void prestoSql() {

        DataResource dataResource = new DataResource();
        dataResource.setDbName("hudi_ods");
        dataResource.setDbHost("10.20.221.242:9090");

        PrestoDataSource prestoDataSource = new PrestoDataSource(dataResource);

        Double aDouble = prestoDataSource.queryForSingleDoubleValue("SELECT COUNT(1) FROM ods_category");

        System.out.println(aDouble);
    }

    @Test
    public void prestoSql2() {
        DataResource dataResource = new DataResource();
        dataResource.setDbName("hudi_ods");
        dataResource.setDbHost("10.20.221.242:9090");

        PrestoDataSource prestoDataSource = new PrestoDataSource(dataResource);

        System.out.println(prestoDataSource.queryForReportResult("SELECT * FROM ods_category limit 10"));
    }

}
