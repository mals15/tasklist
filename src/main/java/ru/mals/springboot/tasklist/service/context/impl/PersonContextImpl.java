package ru.mals.springboot.tasklist.service.context.impl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.mals.springboot.tasklist.service.context.PersonContext;

@Component
@RequestScope
public class PersonContextImpl implements PersonContext {

    @Getter
    @Setter
    private String email = null;

}
