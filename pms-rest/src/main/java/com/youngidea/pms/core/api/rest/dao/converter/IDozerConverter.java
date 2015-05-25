package com.youngidea.pms.core.api.rest.dao.converter;


/**
 * Created by sean on 3/26/15.
 */
public interface IDozerConverter<PMSEntity, RequestModel, ResponseModel> {

    ResponseModel convert(PMSEntity input, ResponseModel output);

    PMSEntity convertBack(RequestModel input, PMSEntity output);

}
