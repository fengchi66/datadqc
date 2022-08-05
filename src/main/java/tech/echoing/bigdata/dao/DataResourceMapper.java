package tech.echoing.bigdata.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.echoing.bigdata.bean.DataResource;

import java.util.List;

@Mapper
public interface DataResourceMapper {

    void insert(DataResource resource);

    void update(DataResource resource);

    List<DataResource> select(DataResource resource);

}
