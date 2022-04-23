package com.advanced.practice5.task9;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Auction {
    List<Lot> lots;
    List<Member> members;

    public Auction(List<Lot> lots, List<Member> members) {
        this.lots = lots;
        this.members = members;
    }

    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Lot lot : lots) {

            for (Member member : members) {
                member.setLot(lot);
                try {
                    service.execute(member);
                } catch (Exception e) {
                    continue;
                }

            }
            service.notifyAll();
            service.shutdown();
        }


    }
}

