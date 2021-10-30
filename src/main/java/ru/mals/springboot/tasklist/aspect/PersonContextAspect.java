package ru.mals.springboot.tasklist.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.mals.springboot.tasklist.service.context.PersonContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
@Order(2)
public class PersonContextAspect {

    private static final String HEADER_NAME_EMAIL = "email";

    private final PersonContext personContext;

    public PersonContextAspect(PersonContext personContext) {
        this.personContext = personContext;
    }

    @Before("execution(public * *(..)) " +
            "&& within(@org.springframework.web.bind.annotation.RestController *)")
    public void setUserContext() {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        String email = request.getHeader(HEADER_NAME_EMAIL);

        personContext.setEmail(email);
    }

}
