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

package org.apache.doris.nereids.trees.expressions.functions.scalar;

import org.apache.doris.catalog.FunctionSignature;
import org.apache.doris.nereids.trees.expressions.Expression;
import org.apache.doris.nereids.trees.expressions.functions.AlwaysNullable;
import org.apache.doris.nereids.trees.expressions.shape.BinaryExpression;
import org.apache.doris.nereids.trees.expressions.visitor.ExpressionVisitor;
import org.apache.doris.nereids.types.ArrayType;
import org.apache.doris.nereids.types.BigIntType;
import org.apache.doris.nereids.types.BooleanType;
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
import org.apache.doris.nereids.types.VarcharType;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * ScalarFunction 'arrays_overlap'. This class is generated by GenerateFunction.
 */
public class ArraysOverlap extends CompatibleTypeArrayFunction
        implements BinaryExpression, AlwaysNullable {

    public static final List<FunctionSignature> SIGNATURES = ImmutableList.of(
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(BooleanType.INSTANCE), ArrayType.of(BooleanType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(TinyIntType.INSTANCE), ArrayType.of(TinyIntType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(SmallIntType.INSTANCE), ArrayType.of(SmallIntType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(IntegerType.INSTANCE), ArrayType.of(IntegerType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(BigIntType.INSTANCE), ArrayType.of(BigIntType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(LargeIntType.INSTANCE), ArrayType.of(LargeIntType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DateTimeType.INSTANCE), ArrayType.of(DateTimeType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DateType.INSTANCE), ArrayType.of(DateType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DateTimeV2Type.SYSTEM_DEFAULT), ArrayType.of(DateTimeV2Type.SYSTEM_DEFAULT)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DateV2Type.INSTANCE), ArrayType.of(DateV2Type.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(FloatType.INSTANCE), ArrayType.of(FloatType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DoubleType.INSTANCE), ArrayType.of(DoubleType.INSTANCE)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT), ArrayType.of(DecimalV2Type.SYSTEM_DEFAULT)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(VarcharType.SYSTEM_DEFAULT), ArrayType.of(VarcharType.SYSTEM_DEFAULT)),
            FunctionSignature.ret(BooleanType.INSTANCE)
                    .args(ArrayType.of(StringType.INSTANCE), ArrayType.of(StringType.INSTANCE))
    );

    /**
     * constructor with 2 arguments.
     */
    public ArraysOverlap(Expression arg0, Expression arg1) {
        super("arrays_overlap", arg0, arg1);
    }

    /**
     * withChildren.
     */
    @Override
    public ArraysOverlap withChildren(List<Expression> children) {
        Preconditions.checkArgument(children.size() == 2);
        return new ArraysOverlap(children.get(0), children.get(1));
    }

    @Override
    public <R, C> R accept(ExpressionVisitor<R, C> visitor, C context) {
        return visitor.visitArraysOverlap(this, context);
    }

    @Override
    public List<FunctionSignature> getSignatures() {
        return SIGNATURES;
    }
}
