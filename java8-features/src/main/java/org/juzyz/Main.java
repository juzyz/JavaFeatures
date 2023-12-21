package org.juzyz;

import lambda.consumer.ConsumerUsage;
import lambda.function.FunctionUsage;
import lambda.general.InterfaceForMultiInputParams;
import lambda.general.InterfaceUsageForZeroInputParams;
import lambda.predicate.PredicateUsage;
import lambda.supplier.SupplierUsage;

public class Main {
    public static void main(String[] args) {
        checkLambdaExpressions();
    }

    private static void checkLambdaExpressions() {
        System.out.println("Check the interface usage for zero input parameters:");
        InterfaceUsageForZeroInputParams simpleUsage = new InterfaceUsageForZeroInputParams();
        simpleUsage.check();

        System.out.println();
        System.out.println("Check the interface usage for multi input parameters:");
        InterfaceForMultiInputParams multiInputParams = new InterfaceForMultiInputParams();
        multiInputParams.check();

        System.out.println();
        System.out.println("Check the Predicate interface usage:");
        PredicateUsage predicateUsage = new PredicateUsage();
        predicateUsage.check();

        System.out.println();
        System.out.println("Check the Functional  interface usage:");
        FunctionUsage functionUsage = new FunctionUsage();
        functionUsage.check();

        System.out.println();
        System.out.println("Check the Consumer  interface usage:");
        ConsumerUsage consumerUsage = new ConsumerUsage();
        consumerUsage.check();

        System.out.println();
        System.out.println("Check the Supplier  interface usage:");
        SupplierUsage supplierUsage = new SupplierUsage();
        supplierUsage.check();
    }
}