/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2013 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.api.config.internal;

import org.apache.commons.lang.StringUtils;

import java.util.Locale;

/**
 * @since 3.7
 */
public class Category {

  private final String originalKey;
  private final boolean special;

  public Category(String originalKey) {
    this(originalKey, false);
  }

  public Category(String originalKey, boolean special) {
    this.originalKey = originalKey;
    this.special = special;
  }

  public String originalKey() {
    return originalKey;
  }

  public String key() {
    return StringUtils.lowerCase(originalKey, Locale.ENGLISH);
  }

  public boolean isSpecial() {
    return special;
  }

  @Override
  public int hashCode() {
    return key().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Category)) {
      return false;
    }
    return StringUtils.equalsIgnoreCase(((Category) obj).originalKey, this.originalKey);
  }

  @Override
  public String toString() {
    return this.originalKey;
  }

}
