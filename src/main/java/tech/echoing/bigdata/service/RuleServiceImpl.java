package tech.echoing.bigdata.service;

import org.springframework.stereotype.Service;
import tech.echoing.bigdata.api.RuleService;
import tech.echoing.bigdata.bean.DqcRule;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Override
    public List<DqcRule> getRuleList(DqcRule dqcRule) {
        return null;
    }

    @Override
    public boolean insertDqcRule(DqcRule dqcRule) {
        return false;
    }

    @Override
    public boolean updateDqcRule(DqcRule dqcRule) {
        return false;
    }

    @Override
    public boolean start(String group) {
        return false;
    }
}