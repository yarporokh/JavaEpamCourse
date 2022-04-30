package com.advanced.practice6.observer.git;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    List<WebHook> webHookList;
    List<Event> eventList;

    public RepositoryImpl() {
        this.webHookList = new ArrayList<>();
        this.eventList = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
        webHookList.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit commit = new Commit(author, changes);
        List<Commit> list = new ArrayList<>();
        list.add(commit);

        for (WebHook webHook : webHookList) {
            if (webHook.branch().equals(branch) && webHook.type() == Event.Type.COMMIT) {
                Event event = new Event(Event.Type.COMMIT, branch, list);
                webHook.onEvent(event);
                eventList.add(event);
            }
        }
        return commit;
    }


    @Override
    public void merge(String sourceBranchName, String targetBranchName) {
        if (webHookList.size() == 0)
            return;

        List<Commit> commits = new ArrayList<>();

        WebHook source = null;
        WebHook target = null;

        for (WebHook webHook : webHookList) {

            if (webHook.branch().equals(sourceBranchName) && webHook.type() == Event.Type.COMMIT) {
                source = webHook;
            } else if (webHook.branch().equals(targetBranchName) && webHook.type() == Event.Type.MERGE) {
                target = webHook;
            }
        }
        if (source != null && target != null) {
            for (var event : source.caughtEvents())
                commits.addAll(event.commits());
            if (commits.size() != 0)
                target.onEvent(new Event(Event.Type.MERGE, targetBranchName, commits));
            webHookList.set(webHookList.indexOf(source), new WebHookImpl(source.type(), source.branch()));
        }
    }
}
