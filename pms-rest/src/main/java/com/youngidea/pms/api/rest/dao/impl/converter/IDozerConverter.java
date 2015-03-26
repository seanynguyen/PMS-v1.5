package com.youngidea.pms.api.rest.dao.impl.converter;


import com.youngidea.pms.entity.PMSEntity;

/**
 * Created by sean on 3/26/15.
 */
public interface IDozerConverter<PMSEntity, RequestModel, ResponseModel> {

    ResponseModel convert(PMSEntity input, ResponseModel output);

    PMSEntity convertBack(RequestModel input, PMSEntity output);

}
