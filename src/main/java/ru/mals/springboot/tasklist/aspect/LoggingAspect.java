package ru.mals.springboot.tasklist.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.mals.springboot.tasklist.annotation.Loggable;
import ru.mals.springboot.tasklist.service.context.PersonContext;

@Aspect
@Component
@Order(2)

public class LoggingAspect {

    private final PersonContext personContext;

    public LoggingAspect (PersonContext usercontext) {
        this.personContext = usercontext;
    }

    @After("@annotation(loggable)")
    public void loggable (JoinPoint joinPoint, Loggable loggable){
        String email = personContext.getEmail();

        System.out.printf(
                "[email = %s] Hello, execute: %s",
                email, joinPoint.getSignature().getName()
        );
    }

}
