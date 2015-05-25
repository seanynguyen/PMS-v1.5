/*
 * Integrating Bean Validation with JAX-RS in Java EE 7
 * https://github.com/samaxes/jaxrs-beanvalidation-javaee7
 *
 * Copyright (c) 2013 samaxes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.youngidea.pms.core.api.rest.m;

import com.youngidea.pms.core.api.rest.model.request.ItemRequestModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.validation.Valid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.validation.ValidationError;

@Path("persons")
@Produces(MediaType.APPLICATION_JSON)
public class Persons {

    private static final ConcurrentMap<String, Person> persons = new ConcurrentHashMap<String, Person>();

    @GET
    public Collection<Person> getAll() {
        return persons.values();
    }

    @GET
    @Path("/test")
    @Produces("application/json")
    public Response getValidationError() {
        ValidationError ve = new ValidationError();
        ve.setMessage("Fail !!!!!!!");
        return Response.status(Response.Status.CREATED).entity(ve).build();
    }
    
    @GET
    @Path("{id}")
    public Person getPerson(
            @PathParam("id")
            @NotNull(message = "The id must not be null")
            @Pattern(regexp = "[0-9]+", message = "The id must be a valid number")
            String id) {
        return persons.get(id);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createPerson(
//            @FormParam("id")
////            @NotNull(message = "{person.id.notnull}")
////            @Pattern(regexp = "[0-9]+", message = "{person.id.pattern}")
//            String id,
//            @FormParam("name")
////            @Size(min = 2, max = 50, message = "{person.name.size}")
//            String name) {
    public Response createPerson(@Valid Person person) {    
//        Person person = new Person();
//        person.setId(Integer.valueOf(id));
//        person.setName(name);
        persons.put(person.getId().toString(), person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }
    
    @POST
    @Path("/testItem")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createItem(@Valid ItemRequestModel item) {
        
        return Response.status(Response.Status.CREATED).entity(item).build();
    }
    
    @GET
    @Path("/testArrayList")
    public Response testArrayList() {
        return Response.status(Response.Status.FOUND).entity(new ArrayList()).build();
    }
    
}
