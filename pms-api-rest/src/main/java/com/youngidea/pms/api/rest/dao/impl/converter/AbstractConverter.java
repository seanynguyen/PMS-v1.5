package com.youngidea.pms.api.rest.dao.impl.converter;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public abstract class AbstractConverter<Entity extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>
        implements IDozerConverter<Entity, RequestModel, ResponseModel>{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConverter.class);

    private static final List<String> mappingFilesNames = Lists.newArrayList();

    public static final DozerBeanMapper mapper = new DozerBeanMapper();

    private Class<Entity> entityClass;

    private Class<ResponseModel> responseModelClass;

    public AbstractConverter(Class<ResponseModel> responseModelClass, Class<Entity> entityClass, Collection<String> mappingFileNames) {
//        BasicConfigurator.configure();
        this.mappingFilesNames.addAll(mappingFileNames);
        mapper.setMappingFiles(this.mappingFilesNames);
        this.entityClass = entityClass;
        this.responseModelClass = responseModelClass;
    }

    @Override
    public ResponseModel convert(Entity input) {
        ResponseModel responseModel =
                (ResponseModel) mapper.map(input, responseModelClass);
        return responseModel;
    }

    @Override
    public Entity convertBack(RequestModel input) {
        Entity entity = (Entity) mapper.map(input, entityClass);
        return entity;
    }

    @Override
    public ResponseModel convertResToResp(RequestModel input) {
        return convert(convertBack(input));
    }

    public Class<ResponseModel> getResponseModelClass() {
        return this.responseModelClass;
    }
}
