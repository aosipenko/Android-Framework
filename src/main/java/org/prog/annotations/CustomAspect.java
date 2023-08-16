package org.prog.annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class CustomAspect {

    private static final Logger LOG = LogManager.getLogger(CustomAspect.class);

    @Around("@annotation(org.prog.annotations.CustomAnnotation)")
    public Object smth(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOG.info("processing call to method {}", proceedingJoinPoint);
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        CustomAnnotation ca = method.getAnnotation(CustomAnnotation.class);

        String argValue = (String) proceedingJoinPoint.getArgs()[0];

        if (argValue != null){
            return proceedingJoinPoint.proceed();
        } else {
            return proceedingJoinPoint.proceed(new String[]{ca.value()});
        }
    }
}
