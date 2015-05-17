package com.youngidea.pms.api.rest.service;

import com.youngidea.pms.api.rest.model.ItemStatusModel;
import com.youngidea.pms.api.rest.model.validator.ValidStatus;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 3/31/15.
 */
@Local
public interface ItemStatusService extends RestCRUIDService<ItemStatusModel> {
//

}
