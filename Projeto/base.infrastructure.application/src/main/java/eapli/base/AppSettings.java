/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * the application settings.
 *
 * @author Paulo Gandra Sousa
 */
public class AppSettings {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppSettings.class);

    private static final String PROPERTIES_RESOURCE = "application.properties";
    private static final String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";
    private static final String UI_MENU_LAYOUT_KEY = "ui.menu.layout";
    private static final String PERSISTENCE_UNIT_KEY = "persistence.persistenceUnit";
    private static final String SCHEMA_GENERATION_KEY = "javax.persistence.schema-generation.database.action";

    private static final String MAXIMUM_NUMBER_OF_LINES_IN_A_BOARD = "MaximumNumberOfLinesInABoard";
    private static final String MAXIMUM_NUMBER_OF_COLUMNS_IN_A_BOARD = "MaximumNumberOfColumnsInABoard";

    private static final String SHARED_BOARD_SERVER_ADDRESS = "shared_board.server.address";
    private static final String SHARED_BOARD_SERVER_PORT = "shared_board.server.port";

    private static final String SHARED_BOARD_PORT = "shared_board.port";

    private final Properties applicationProperties = new Properties();

    public AppSettings() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream propertiesStream = this.getClass().getClassLoader()
                .getResourceAsStream(PROPERTIES_RESOURCE)) {
            if (propertiesStream != null) {
                this.applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (final IOException exio) {
            setDefaultProperties();

            LOGGER.warn("Loading default properties", exio);
        }
    }

    private void setDefaultProperties() {
        this.applicationProperties.setProperty(REPOSITORY_FACTORY_KEY, "eapli.base.persistence.jpa.JpaRepositoryFactory");
        this.applicationProperties.setProperty(UI_MENU_LAYOUT_KEY, "horizontal");
        this.applicationProperties.setProperty(PERSISTENCE_UNIT_KEY, "eapli" + ".base");
        this.applicationProperties.setProperty(MAXIMUM_NUMBER_OF_LINES_IN_A_BOARD, "20");
        this.applicationProperties.setProperty(MAXIMUM_NUMBER_OF_COLUMNS_IN_A_BOARD, "10");
        this.applicationProperties.setProperty(SHARED_BOARD_SERVER_ADDRESS, "127.0.0.1");
        this.applicationProperties.setProperty(SHARED_BOARD_SERVER_PORT, "8890");
        this.applicationProperties.setProperty(SHARED_BOARD_PORT, "8080");
    }

    public Boolean isMenuLayoutHorizontal() {
        return "horizontal".equalsIgnoreCase(this.applicationProperties.getProperty(UI_MENU_LAYOUT_KEY));
    }

    public String getPersistenceUnitName() {
        return this.applicationProperties.getProperty(PERSISTENCE_UNIT_KEY);
    }

    public String getRepositoryFactory() {
        return this.applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }

    public Integer maximumNumberOfLinesInABoard() {
        return Integer.valueOf(this.applicationProperties.getProperty(MAXIMUM_NUMBER_OF_LINES_IN_A_BOARD));
    }

    public Integer maximumNumberOfColumnsInABoard() {
        return Integer.valueOf(this.applicationProperties.getProperty(MAXIMUM_NUMBER_OF_COLUMNS_IN_A_BOARD));
    }

    public String getSharedBoardServerAddress() {
        return this.applicationProperties.getProperty(SHARED_BOARD_SERVER_ADDRESS);
    }

    public Integer getSharedBoardServerPort() {
        return Integer.valueOf(this.applicationProperties.getProperty(SHARED_BOARD_SERVER_PORT));
    }

    public Integer getSharedBoardPort() {
        return Integer.valueOf(this.applicationProperties.getProperty(SHARED_BOARD_PORT));
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public Map getExtendedPersistenceProperties() {
        final Map ret = new HashMap();
        ret.put(SCHEMA_GENERATION_KEY,
                this.applicationProperties.getProperty(SCHEMA_GENERATION_KEY));
        return ret;
    }

    public String getProperty(final String prop) {
        return this.applicationProperties.getProperty(prop);
    }
}
