package de.consulting.it.harder;
/*
 * This program FileContentScanner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * @author Tim Harder - Harder IT Consulting - www.harder-it-consulting.de
 * <p>
 * System Properties Recovery for UNIT Testing
 */

import java.util.Properties;
import org.junit.rules.ExternalResource;

public class SystemPropertiesRecovery extends ExternalResource {

    private Properties recoveryProperties;

    protected void before() {
        this.recoveryProperties = System.getProperties();
        Properties copy = new Properties();
        copy.putAll(this.recoveryProperties);
        System.setProperties(copy);
    }

    protected void after() {
        System.setProperties(this.recoveryProperties);
    }
}