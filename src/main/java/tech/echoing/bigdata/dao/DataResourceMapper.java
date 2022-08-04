package tech.echoing.bigdata.dao;

import org.apache.ibatis.annotations.Mapper;
import tech.echoing.bigdata.bean.DataResource;

@Mapper
public interface DataResourceMapper {

//    @Insert("INSERT INTO dqc_data_resource(resource_id, resource_name, db_type, db_name, db_host, remark) VALUES(#{resourceId}, #{resourceName}, #{resourceName}, #{resourceName}, #{resourceName}, #{resourceName})")
    void insert(DataResource record);

}
