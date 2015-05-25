package com.youngidea.pms.core.api.rest.dao.converter;


import com.youngidea.pms.core.api.rest.model.AbstractModel;
import com.youngidea.pms.core.entity.PMSEntity;

/**
 * Created by sean on 3/26/15.
 */
public interface GenericConverter<Entity extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel> {

    ResponseModel convert(Entity input, Class<ResponseModel> responseModelClass);

    Entity convertBack(RequestModel input, Class<Entity> entityClass);

    ResponseModel convertResToResp(RequestModel input);

}
