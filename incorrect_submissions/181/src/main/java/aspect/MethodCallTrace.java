package aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
public class MethodCallTrace {
    private BufferedWriter writer;

    public MethodCallTrace() throws IOException {
        writer = new BufferedWriter(new FileWriter("method-executions.log", false));
    }

    @Pointcut("execution(* uk.ac.sheffield.com1003.cafe.*.*(..)) || execution(* uk.ac.sheffield.com1003.cafe.*.*.*(..))")
    public void recordTestExecution() {
    }

    @Before("recordTestExecution()")
    public void logTestExecution(JoinPoint joinPoint) throws Throwable {
        logExecution(joinPoint);
    }

    private void logExecution(JoinPoint joinPoint) throws IOException {
        String methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        writer.write(methodName + "\n");
        writer.flush();
    }
}