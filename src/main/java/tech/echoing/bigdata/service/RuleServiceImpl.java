package tech.echoing.bigdata.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.echoing.bigdata.api.RuleService;
import tech.echoing.bigdata.bean.DqcRule;
import tech.echoing.bigdata.dao.DqcRuleMapper;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private DqcRuleMapper mapper;

    @Override
    public List<DqcRule> getRuleList(DqcRule dqcRule) {
        return mapper.select(dqcRule);
    }

    @Override
    public DqcRule insertDqcRule(DqcRule dqcRule) {
        mapper.insert(dqcRule);
        return dqcRule;
    }

    @Override
    public DqcRule updateDqcRule(DqcRule dqcRule) {
        mapper.update(dqcRule);
        System.out.println(dqcRule);
        return dqcRule;
    }

    @Override
    public void start(String group) {

    }
}