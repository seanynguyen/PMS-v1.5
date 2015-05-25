package com.youngidea.pms.core.ultilities;

import com.youngidea.pms.core.entity.PMSEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by sean on 3/31/15.
 */
public class FacadeHelper<T extends PMSEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeHelper.class);

    private static final String DEFAULT_PROPERTIES_FILE_PATH = "default.properties";

    public static Properties getPropertyRetriever(Class clazz) {
        Properties properties = new Properties();
        try {
            properties.load(clazz.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE_PATH));
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        }
        return properties;
    }

}
