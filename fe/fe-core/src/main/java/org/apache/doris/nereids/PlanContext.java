// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.nereids;

import org.apache.doris.nereids.memo.GroupExpression;
import org.apache.doris.nereids.trees.plans.Plan;
import org.apache.doris.statistics.StatsDeriveResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Context for plan.
 * Abstraction for group expressions and stand-alone expressions/DAGs.
 * A ExpressionHandle is attached to either {@link Plan} or {@link GroupExpression}.
 * Inspired by GPORCA-CExpressionHandle.
 */
public class PlanContext {
    private List<StatsDeriveResult> childrenStats = new ArrayList<>();
    private StatsDeriveResult planStats = new StatsDeriveResult(0);
    private int arity = 0;

    /**
     * Constructor for PlanContext.
     */
    public PlanContext(GroupExpression groupExpression) {
        this.arity = groupExpression.arity();
        if (groupExpression.getOwnerGroup() == null) {
            return;
        }
        planStats = groupExpression.getOwnerGroup().getStatistics();
        childrenStats = new ArrayList<>();
        for (int i = 0; i < groupExpression.arity(); i++) {
            childrenStats.add(groupExpression.childStatistics(i));
        }
    }

    public PlanContext(StatsDeriveResult planStats, StatsDeriveResult... childrenStats) {
        this.planStats = planStats;
        this.childrenStats = Arrays.asList(childrenStats);
        this.arity = this.childrenStats.size();
    }

    public int arity() {
        return arity;
    }

    public StatsDeriveResult getStatisticsWithCheck() {
        return planStats;
    }

    /**
     * Get child statistics.
     */
    public StatsDeriveResult getChildStatistics(int index) {
        return childrenStats.get(index);
    }
}
