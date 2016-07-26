package com.mysite.selenium.Interceptor;

import junitparams.JUnitParamsRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A custom runner for JUnit4.5 in which we demonstrate the interceptor pattern.
 *
 * @version $Id: InterceptorRunner.java 201 2009-02-15 19:18:09Z paranoid12 $
 */
public class InterceptorRunner extends JUnitParamsRunner {
    /**
     * This is the InterceptorClasses annotation, which serves to hold our interceptor class
     * implementations.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface InterceptorClasses {

        /**
         * Value.
         *
         * @return the classes to be run
         */
        public Class<?>[] value();
    }

    /**
     * This constructor is a must.
     *
     * @param clazz the test-case class
     * @throws InitializationError the initialization error
     */
    public InterceptorRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    /**
     * Override the methodInvoker, so that when it is called we wrap the statement with our own.
     *
     * @param method the test method
     * @param test the test-case
     * @return the statement
     */
    @Override
    public Statement methodInvoker(FrameworkMethod method, Object test) {
        InterceptorStatement statement = new InterceptorStatement(super.methodInvoker(method, test));
        InterceptorClasses annotation = test.getClass().getAnnotation(InterceptorClasses.class);
        Class<?>[] klasez = annotation.value();
        try {
            for (Class<?> klaz : klasez) {

                statement.addInterceptor((Interceptor) klaz.newInstance());

            }
        } catch (IllegalAccessException ilex) {
            ilex.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
