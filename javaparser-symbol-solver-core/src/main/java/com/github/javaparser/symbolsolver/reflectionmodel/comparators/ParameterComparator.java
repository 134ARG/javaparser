/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2019 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser.symbolsolver.reflectionmodel.comparators;

import java.lang.reflect.Parameter;
import java.util.Comparator;

/**
 * @author Federico Tomassetti
 */
public class ParameterComparator implements Comparator<Parameter> {

    @Override
    public int compare(Parameter o1, Parameter o2) {
        int compareName = o1.getName().compareTo(o2.getName());
        if (compareName != 0) return compareName;
        int compareType = new ClassComparator().compare(o1.getType(), o2.getType());
        if (compareType != 0) return compareType;
        return 0;
    }
}
