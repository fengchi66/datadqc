package tech.echoing.bigdata.api;

import tech.echoing.bigdata.bean.DataResource;

import java.util.List;

/**
 * 数据源管理
 */
public interface DataResourceService {

    List<DataResource> getDataResourceList(DataResource dataResource);

    void insertDataResource(DataResource dataResource);

    void updateDataResource(DataResource dataResource);

}