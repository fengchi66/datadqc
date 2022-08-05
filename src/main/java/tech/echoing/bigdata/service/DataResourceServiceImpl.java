package tech.echoing.bigdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.echoing.bigdata.api.DataResourceService;
import tech.echoing.bigdata.bean.DataResource;
import tech.echoing.bigdata.dao.DataResourceMapper;

import java.util.List;

@Service
public class DataResourceServiceImpl implements DataResourceService {

    @Autowired
    private DataResourceMapper mapper;

    @Override
    public List<DataResource> getDataResourceList(DataResource dataResource) {
        return mapper.select(dataResource);
    }

    @Override
    public void insertDataResource(DataResource dataResource) {
        mapper.insert(dataResource);
    }

    @Override
    public void updateDataResource(DataResource dataResource) {
        mapper.update(dataResource);

    }
}
