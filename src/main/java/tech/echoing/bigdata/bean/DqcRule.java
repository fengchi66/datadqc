package tech.echoing.bigdata.bean;

import lombok.Data;
import org.springframework.context.annotation.Description;

import java.util.Date;

@Data
@Description("校验规则")
public class DqcRule {

    // 规则id
    public String ruleId;

    // 规则名称
    public String ruleName;

    // 规则组：default
    public String ruleGroup;

    // 规则类型：@system 系统内置 @customer 自定义
    public String ruleType;

    // 内置规则枚举 @table_count
    public String sysRuleEnum;

    // 资源id @R001
    public String resourceId;

    // 资源名称
    public String resourceName;

    // db类型：hive/starrocks/mysql
    public String resourceDbType;

    // 数据库名称
    public String resourceDbName;

    // 数据库地址：port/库名
    public String resourceDbHost;

    // 表名
    public String tableName;

    // 分区表达式 例如：n天前，dt='${yyyy-mm-dd - N}'；非分区表不填
    public String partitionExpression;

    // 字段名
    public String columnName;

    // 比较方式: @lt 小于，@gt 大于，@lte 小于等于，@gte 大于等于，@eq 等于，@neq 不等于
    public String compareMethod;

    // 期望值:100
    public double expectValue;

    // 橙色警告阀值:500
    public double warnValue;

    // 红色警告阀值:1000
    public double errorValue;

    // 接收报警的级别 @info 每次都发，@warn 到达warn_value的值就发，@error 到达error_value的值就发
    public String receiveReportLevel;

    // 自定义的校验SQL: SELECT COUNT(1) FROM t
    public String checkSql;

    // 警告返回内容SQL: 警告返回内容SQL
    public String resultSql;

    // 接收报告的邮件列表
    public String reportEmails;

    // 接收报告的手机号列表,多个用逗号隔开
    public String reportPhones;

    // 接收报告的飞书账号列表，多个用逗号隔开
    public String reportFeiShu;

    // 接收报告的飞书群列表
    public String reportFeiShuGroups;

    // remark
    public String remark;

    // 创建时间
    public Date createTime;

    // 更新时间
    public Date updateTime;

}

