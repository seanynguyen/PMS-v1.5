/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.api.rest.dao.converter;

import java.io.Serializable;

/**
 *
 * @author sean
 */
public interface IConverter<I,M,B> extends Serializable {

    B convert(I input, B output);

    I convertBack(M input, I output);
}
