package tech.echoing.bigdata;

import com.apple.eawt.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tech.echoing.bigdata.bean.DqcRule;
import tech.echoing.bigdata.service.RuleServiceImpl;

import java.util.List;

@SpringBootApplication(scanBasePackages = "tech.echoing.bigdata")
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RuleServiceTest {

    @Autowired
    private RuleServiceImpl impl;

    @Test
    public void addRuleTest() {

        DqcRule dqcRule = new DqcRule();
        dqcRule.setRuleId("R001");
        dqcRule.setRuleName("网关日志异常ip监测");
        dqcRule.setRuleGroup("default");
        dqcRule.setRuleType("system");
        dqcRule.setSysRuleEnum("table_count");
        dqcRule.setTableName("dwd.dwd_access_log");
        dqcRule.setColumnName("");
        dqcRule.setCompareMethod("lt");
        dqcRule.setCheckSql("SELECT COUNT(1) FROM dwd_access_log");
        dqcRule.setExpectValue(6000);
        dqcRule.setWarnValue(5000);
        dqcRule.setErrorValue(4000);
        dqcRule.setResourceId("R001");
        dqcRule.setResultSql("SELECT COUNT(1) FROM dwd_access_log");
        dqcRule.setReceiveReportLevel("info");
        dqcRule.setReportFeiShu("dd");
        dqcRule.setReportFeiShuGroups("dd");
        dqcRule.setReportEmails("itwufc@163.com");
        dqcRule.setReportPhones("188");
        dqcRule.setRemark("dd");

        impl.insertDqcRule(dqcRule);
    }

    @Test
    public void updateRuleTest() {

        DqcRule dqcRule = new DqcRule();
        dqcRule.setRuleId("R001");
        dqcRule.setReportEmails("itwufc@163.com, joeyooa@126.com");

        impl.updateDqcRule(dqcRule);

    }

    @Test
    public void selectRuleTest() {

//        Mysql mysql = new Mysql("");

        DqcRule dqcRule = new DqcRule();
        dqcRule.setResourceId("R001");

        List<DqcRule> ruleList = impl.getRuleList(dqcRule);

        System.out.println(ruleList);
    }
}
