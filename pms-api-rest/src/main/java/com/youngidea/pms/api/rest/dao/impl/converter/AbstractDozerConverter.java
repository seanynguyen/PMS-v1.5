package com.youngidea.pms.api.rest.dao.impl.converter;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import org.apache.log4j.BasicConfigurator;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public abstract class AbstractDozerConverter<Entity extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>
        implements IDozerConverter<Entity, RequestModel, ResponseModel>{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDozerConverter.class);

    public static final DozerBeanMapper mapper = new DozerBeanMapper();

    private Class<Entity> entityClass;

    private Class<ResponseModel> responseModelClass;

    public AbstractDozerConverter(Class<ResponseModel> responseModelClass, Class<Entity> entityClass) {
//        BasicConfigurator.configure();
        mapper.setMappingFiles(getMappingFilesNames());
        this.entityClass = entityClass;
        this.responseModelClass = responseModelClass;
    }

    protected abstract List<String> getMappingFilesNames();

    @Override
    public ResponseModel convert(Entity input) {
//        LOGGER.info(output.getClass().toString());
        ResponseModel responseModel =
                (ResponseModel) mapper.map(input, responseModelClass);
//        LOGGER.info(responseModel.getClass().toString());
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

}
