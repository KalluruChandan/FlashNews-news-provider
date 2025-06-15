package app.flashnews.news_provider.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* app.flashnews.news_provider..*(..)) && " +
            "!within(app.flashnews.news_provider.config..*) && " +
            "!within(app.flashnews.news_provider.aspect..*) && " +
            "!within(app.flashnews.news_provider.properties..*) && " +
            "!within(app.flashnews.news_provider.util..*)")
    public void applicationPackagePointcut() {}

    @Around("applicationPackagePointcut()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        Object[] methodArgs = joinPoint.getArgs();

        log.info("→ Entering {}.{}() ", className, methodName);

        Object result;
        try {
            result = joinPoint.proceed(); // Execute the actual method
            log.info("← Exiting {}.{}() ", className, methodName);
            return result;
        } catch (Throwable throwable) {
            log.error("✖ Exception in {}.{}() with cause: {}", className, methodName, throwable.getMessage());
            throw throwable;
        }
    }
}
