package com.youngidea.pms.core.api.rest.dao.converter;

import com.youngidea.pms.core.api.rest.model.AbstractModel;
import com.youngidea.pms.core.entity.PMSEntity;
import org.apache.log4j.BasicConfigurator;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sean on 3/26/15.
 */
public abstract class AbstractDozerConverter<E extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel>
        implements IDozerConverter<E, RequestModel, ResponseModel>{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDozerConverter.class);

    public static final DozerBeanMapper mapper = new DozerBeanMapper();

    public AbstractDozerConverter() {
         BasicConfigurator.configure();
         mapper.setMappingFiles(getMappingFilesNames());
    }

    protected abstract List<String> getMappingFilesNames();

    @Override
    public ResponseModel convert(E input, ResponseModel output) {
        LOGGER.info(output.getClass().toString());
        ResponseModel responseModel =
                (ResponseModel) mapper.map(input, output.getClass());
        LOGGER.info(responseModel.getClass().toString());
        return responseModel;
    }

    @Override
    public E convertBack(RequestModel input, E output) {
        E entity = (E) mapper.map(input, output.getClass());
        return entity;
    }

}
