package tech.echoing.bigdata.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.echoing.bigdata.bean.DqcRule;

import java.util.List;

@Mapper
public interface DqcRuleMapper {

    int insert(DqcRule record);

    int update(DqcRule record);

    List<DqcRule> select(DqcRule record);

}
