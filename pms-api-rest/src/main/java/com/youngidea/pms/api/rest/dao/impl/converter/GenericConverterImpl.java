package com.youngidea.pms.api.rest.dao.impl.converter;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;
import org.apache.log4j.BasicConfigurator;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.Arrays;

/**
 * Created by sean on 3/26/15.
 */
@Stateless
public class GenericConverterImpl<Entity extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>
        implements IDozerConverter<Entity, RequestModel, ResponseModel>{
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericConverterImpl.class);

    private static final String[] DEFAULT_MAPPING_FILE_NAMES = {"dozer.xml"};

    public static final DozerBeanMapper mapper = new DozerBeanMapper();

    @PostConstruct
    public void initializeMappingFiles() {
        BasicConfigurator.configure();
        setMappingFiles();
    }

    // to be override if need
    protected void setMappingFiles() {
        mapper.setMappingFiles(Arrays.asList(DEFAULT_MAPPING_FILE_NAMES));
    }

    @Override
    public ResponseModel convert(Entity input, Class<ResponseModel> responseModelClass) {
        ResponseModel responseModel =
                (ResponseModel) mapper.map(input, responseModelClass);
        return responseModel;
    }

    @Override
    public Entity convertBack(RequestModel input, Class<Entity> entityClass) {
        Entity entity = (Entity) mapper.map(input, entityClass);
        return entity;
    }

    @Override
    public ResponseModel convertResToResp(RequestModel input) {
//        return convert(convertBack(input));
        return null;
    }

}
