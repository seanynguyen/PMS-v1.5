package com.youngidea.pms.api.rest.dao.impl.converter;


import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.entity.PMSEntity;

/**
 * Created by sean on 3/26/15.
 */
public interface IDozerConverter<Entity extends PMSEntity, RequestModel extends AbstractModel, ResponseModel extends AbstractModel> {

    ResponseModel convert(Entity input, Class<ResponseModel> responseModelClass);

    Entity convertBack(RequestModel input, Class<Entity> entityClass);

    ResponseModel convertResToResp(RequestModel input);

}
