package com.advanced.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;

public class WebHookImpl implements WebHook{
    private Event.Type type;
    private List<Event> caughtEvents;
    private String branch;

    public WebHookImpl(Event.Type type, String branch) {
        this.type = type;
        this.caughtEvents = new ArrayList<>();
        this.branch = branch;
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return caughtEvents;
    }

    @Override
    public void onEvent(Event event) {
        caughtEvents.add(event);
    }
}
