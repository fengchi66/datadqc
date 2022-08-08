package tech.echoing.bigdata.api;

import tech.echoing.bigdata.bean.DqcRule;

import java.util.List;

public interface RuleService {

    List<DqcRule> getRuleList(DqcRule dqcRule);

    boolean insertDqcRule(DqcRule dqcRule);

    boolean updateDqcRule(DqcRule dqcRule);

    boolean start(String group);
}