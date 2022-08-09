package tech.echoing.bigdata.api;

import tech.echoing.bigdata.bean.DqcRule;

import java.util.List;

public interface RuleService {

    List<DqcRule> getRuleList(DqcRule dqcRule);

    DqcRule insertDqcRule(DqcRule dqcRule);

    DqcRule updateDqcRule(DqcRule dqcRule);

    void start(String group);
}