package tech.echoing.bigdata.api;

import tech.echoing.bigdata.bean.DataResource;

import java.util.List;

public interface DataResourceService {

    List<DataResource> getDataResourceList();

    void insertDataResource(DataResource dataResource);

    boolean updateDataResource(DataResource dataResource);

}
