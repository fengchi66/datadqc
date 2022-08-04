package tech.echoing.bigdata.bean;

import lombok.Data;
import org.springframework.context.annotation.Description;

import java.util.Date;

@Data
@Description("数据源")
public class DataResource {

    // 数据源id: R001
    public String resourceId;

    // 数据源名称: 数仓ODS层
    public String resourceName;

    // db类型:hive/starrocks
    public String dbType;

    // 数据库名称: ods
    public String dbName;

    // 数据库地址: 192.168.1.1:3306/product
    public String dbHost;

    // 备注
    public String remark;

    // 创建时间
    public Date createTime;

    // 创建时间
    public Date updateTime;
}

