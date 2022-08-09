package tech.echoing.bigdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.apple.eawt.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.echoing.bigdata.bean.DataResource;
import tech.echoing.bigdata.service.DataResourceServiceImpl;

import java.util.List;

@SpringBootApplication(scanBasePackages = "tech.echoing.bigdata")
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class DataResourceTest {

    @Autowired
    private DataResourceServiceImpl impl;

    @Test
    public void dataResourceInsertTest() {

        DataResource resource = new DataResource();
        resource.setResourceId("R001");
        resource.setResourceName("实时dwd");
        resource.setDbHost("10.20.180.2:9030");
        resource.setDbName("dwd");
        resource.setDbType("starrocks");
        resource.setRemark("olap分析dwd");

        impl.insertDataResource(resource);
    }

    @Test
    public void dataResourceUpdateTest() {

        DataResource resource = new DataResource();
        resource.setResourceId("hadoop");
        resource.setResourceName("flink");

        impl.updateDataResource(resource);
    }

    @Test
    public void select() {

        List<DataResource> dataResourceList = impl.getDataResourceList(null);
        System.out.println(dataResourceList);
    }

}
