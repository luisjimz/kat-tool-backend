package com.luisjimz.kattool.library.events;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class UseCaseBase {

    @Autowired
    private EventBus eventBus;

    protected abstract void execute();

    public void run() {
        try {
            execute();
            eventBus.publish(new GenericEvent<>(this, true));
        } catch (Exception e) {
            eventBus.publish(new GenericEvent<>(this, false));
            // Handle exception
        }
    }
}

