package com.luisjimz.kattool.library.events;

public class GenericEvent<T> {
    private final T payload;
    private final boolean success;

    public GenericEvent(T payload, boolean success) {
        this.payload = payload;
        this.success = success;
    }

    // Getters
}

