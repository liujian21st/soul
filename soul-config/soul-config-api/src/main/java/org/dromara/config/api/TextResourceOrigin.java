/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.config.api;

import java.io.InputStream;

/**
 * {@link Origin} for an item loaded from a text resource. Provides access to the original
 * {@link InputStream} that loaded the text and a {@link Location} within it.
 *
 * @author Madhura Bhave
 * @author Phillip Webb
 * @since 2.0.0
 */
public class TextResourceOrigin {

    private final InputStream resource;

    private final Location location;

    public TextResourceOrigin(InputStream resource, Location location) {
        this.resource = resource;
        this.location = location;
    }

    /**
     * Return the resource where the property originated.
     *
     * @return the text resource or {@code null}
     */
    public InputStream getResource() {
        return this.resource;
    }

    /**
     * Return the location of the property within the source (if known).
     *
     * @return the location or {@code null}
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * A location (line and column number) within the resource.
     */
    public static final class Location {

        private final int line;

        private final int column;

        /**
         * Create a new {@link Location} instance.
         *
         * @param line   the line number (zero indexed)
         * @param column the column number (zero indexed)
         */
        public Location(int line, int column) {
            this.line = line;
            this.column = column;
        }

        /**
         * Return the line of the text resource where the property originated.
         *
         * @return the line number (zero indexed)
         */
        public int getLine() {
            return this.line;
        }

        /**
         * Return the column of the text resource where the property originated.
         *
         * @return the column number (zero indexed)
         */
        public int getColumn() {
            return this.column;
        }

        @Override
        public int hashCode() {
            return (31 * this.line) + this.column;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Location other = (Location) obj;
            boolean result = true;
            result = result && this.line == other.line;
            result = result && this.column == other.column;
            return result;
        }

        @Override
        public String toString() {
            return (this.line + 1) + ":" + (this.column + 1);
        }

    }

}
