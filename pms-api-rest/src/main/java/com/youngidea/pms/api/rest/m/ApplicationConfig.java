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
package com.youngidea.pms.api.rest.m;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("rest1")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(org.glassfish.jersey.media.multipart.MultiPartFeature.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     * resources.add(org.glassfish.jersey.media.multipart.MultiPartFeature.class);
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Persons.class);
        resources.add(ValidationExceptionMapper.class);

        resources.add(org.glassfish.jersey.media.multipart.MultiPartFeature.class);
    }
}