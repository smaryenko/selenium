package com.mysite.selenium.Interceptor;

import org.junit.runners.model.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * A statement for our custom runner.
 *
 * @version $Id: InterceptorStatement.java 201 2009-02-15 19:18:09Z paranoid12 $
 */
public class InterceptorStatement extends Statement {
    /**
     * A wrapping invoker that will procede the execution, once we execute our interceptors.
     */
    private final Statement invoker;

    /**
     * A list of interceptors that will be executed before the other statements.
     */
    private List<Interceptor> interceptors = new ArrayList<Interceptor>();

    /**
     * A constructor that takes another invoker to wrap our statement.
     *
     * @param invoker the invoker
     */
    public InterceptorStatement(Statement invoker) {
        this.invoker = invoker;
    }

    /**
     * We override this method to call our interceptors, and then evaluate the wrapping invoker.
     *
     * @throws Throwable the throwable
     */
    @Override
    public void evaluate() throws Throwable {
        for (Interceptor interceptor : interceptors) {
            interceptor.interceptBefore();
        }

        invoker.evaluate();

        for (Interceptor interceptor : interceptors) {
            interceptor.interceptAfter();
        }
    }

    /**
     * Add another interceptor to the list of interceptors we have.
     *
     * @param interceptor we want to add
     */
    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}