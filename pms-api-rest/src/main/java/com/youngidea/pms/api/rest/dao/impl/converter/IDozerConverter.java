package com.youngidea.pms.api.rest.dao.impl.converter;


/**
 * Created by sean on 3/26/15.
 */
public interface IDozerConverter<PMSEntity, RequestModel, ResponseModel> {

    ResponseModel convert(PMSEntity input);

    PMSEntity convertBack(RequestModel input);

}
