/*
 * SonarQube CSS / SCSS / Less Analyzer
 * Copyright (C) 2013-2016 David RACODON
 * mailto: david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.css.scss;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.css.checks.CheckList;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

public class ScssRulesDefinition implements RulesDefinition {

  @Override
  public void define(Context context) {
    NewRepository repository = context
      .createRepository(CheckList.SCSS_REPOSITORY_KEY, ScssLanguage.KEY)
      .setName(CheckList.SCSS_REPOSITORY_NAME);

    new AnnotationBasedRulesDefinition(repository, ScssLanguage.KEY).addRuleClasses(false, CheckList.getScssChecks());
    repository.done();
  }

}
