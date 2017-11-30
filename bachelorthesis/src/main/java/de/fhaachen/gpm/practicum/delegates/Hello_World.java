package de.fhaachen.gpm.practicum.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Hello_World implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("hello");

        delegateExecution.setVariable("x", true);

    }
}
