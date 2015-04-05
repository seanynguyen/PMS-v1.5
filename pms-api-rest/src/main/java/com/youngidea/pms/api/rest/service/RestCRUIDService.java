package com.youngidea.pms.api.rest.service;

import com.youngidea.pms.api.rest.model.AbstractModel;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 4/4/15.
 */
@Local
public interface RestCRUIDService<Model extends AbstractModel> {

    Response create(@Valid Model model);

    Response edit(@Valid Model model, @PathParam("id") Long id);

    Response remove(@PathParam("id") Long id);

    Response find(@PathParam("id") Long id);
}
