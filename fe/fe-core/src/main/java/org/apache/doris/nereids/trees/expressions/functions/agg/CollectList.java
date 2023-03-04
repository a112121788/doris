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

package org.apache.doris.nereids.trees.expressions.functions.agg;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.ExplicitlyCastableSignature;
import org.apache.doris.nereids.trees.expressions.functions.PropagateNullable;
import org.apache.doris.nereids.trees.expressions.shape.UnaryExpression;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.ArrayType;
import org.apache.doris.nereids.types.BigIntType;
import org.apache.doris.nereids.types.BooleanType;
import org.apache.doris.nereids.types.CharType;
import org.apache.doris.nereids.types.DateTimeType;
import org.apache.doris.nereids.types.DateTimeV2Type;
import org.apache.doris.nereids.types.DateType;
import org.apache.doris.nereids.types.DateV2Type;
import org.apache.doris.nereids.types.DecimalV2Type;
import org.apache.doris.nereids.types.DoubleType;
import org.apache.doris.nereids.types.FloatType;
import org.apache.doris.nereids.types.IntegerType;
import org.apache.doris.nereids.types.LargeIntType;
import org.apache.doris.nereids.types.SmallIntType;
import org.apache.doris.nereids.types.StringType;
import org.apache.doris.nereids.types.TinyIntType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * AggregateFunction 'collect_list'. This class is generated by GenerateFunction.
 */
public class CollectList extends AggregateFunction
        implements UnaryExpression, ExplicitlyCastableSignature, PropagateNullable {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(ArrayType.of(BooleanType.INSTANCE)).args(BooleanType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(TinyIntType.INSTANCE)).args(TinyIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(SmallIntType.INSTANCE)).args(SmallIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(IntegerType.INSTANCE)).args(IntegerType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(BigIntType.INSTANCE)).args(BigIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(LargeIntType.INSTANCE)).args(LargeIntType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(FloatType.INSTANCE)).args(FloatType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DoubleType.INSTANCE)).args(DoubleType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DecimalV2Type.CATALOG_DEFAULT)).args(DecimalV2Type.CATALOG_DEFAULT),
            FunctionSignature.ret(ArrayType.of(DateType.INSTANCE)).args(DateType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateTimeType.INSTANCE)).args(DateTimeType.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateV2Type.INSTANCE)).args(DateV2Type.INSTANCE),
            FunctionSignature.ret(ArrayType.of(DateTimeV2Type.SYSTEM_DEFAULT)).args(DateTimeV2Type.SYSTEM_DEFAULT),
            FunctionSignature.ret(ArrayType.of(CharType.SYSTEM_DEFAULT)).args(CharType.SYSTEM_DEFAULT),
            FunctionSignature.ret(ArrayType.of(StringType.INSTANCE)).args(StringType.INSTANCE)
    );

    /**
     * constructor with 1 argument.
     */
    public CollectList(Expression arg) {
        super("collect_list", arg);
    }

    /**
     * constructor with 1 argument.
     */
    public CollectList(boolean distinct, Expression arg) {
        super("collect_list", distinct, arg);
    }

    @Override
    public FunctionSignature computeSignature(FunctionSignature signature) {
        signature = signature.withReturnType(ArrayType.of(getArgumentType(0)));
        return super.computeSignature(signature);
    }

    /**
     * withDistinctAndChildren.
     */
    @Override
    public CollectList withDistinctAndChildren(boolean distinct, List<Expression> children) {
        Preconditions.checkArgument(children.size() == 1);
        return new CollectList(distinct, children.get(0));
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitCollectList(this, context);
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }
}
