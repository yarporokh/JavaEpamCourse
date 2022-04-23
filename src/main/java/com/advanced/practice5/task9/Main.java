package com.advanced.practice5.task9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lot> lots = new ArrayList<>();
        lots.add(new Lot(1, 10));
        lots.add(new Lot(2, 20));
        lots.add(new Lot(3, 30));

        List<Member> members = new ArrayList<>();
        members.add(new Member(1, 30));
        members.add(new Member(2, 30));
        members.add(new Member(3, 30));

        Auction auction = new Auction(lots, members);
        auction.run();
    }
}
