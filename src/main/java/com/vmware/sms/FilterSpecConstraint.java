package com.vmware.sms;

import com.vmware.sms.types.FilterSpecComparisonOperator;
import com.vmware.sms.types.FilterSpecLogicalOperator;

/**
 * Copyright 2015 Michael Rice <michael@michaelrice.org>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class FilterSpecConstraint extends DynamicData {

    public FilterSpecConstraint[] childConstraint;
    public FilterSpecLogicalOperator childConstraintLogicalOperator;
    public FilterSpecComparisonOperator comparisonOperator;
    public String propertyName;
    public String propertyValue;

    public FilterSpecConstraint[] getChildConstraint() {
        return childConstraint;
    }

    public void setChildConstraint(FilterSpecConstraint[] childConstraint) {
        this.childConstraint = childConstraint;
    }

    public FilterSpecLogicalOperator getChildConstraintLogicalOperator() {
        return childConstraintLogicalOperator;
    }

    public void setChildConstraintLogicalOperator(FilterSpecLogicalOperator childConstraintLogicalOperator) {
        this.childConstraintLogicalOperator = childConstraintLogicalOperator;
    }

    public FilterSpecComparisonOperator getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(FilterSpecComparisonOperator comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
