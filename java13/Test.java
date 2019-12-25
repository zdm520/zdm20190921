package com.java.zhao;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CardDeam cd=new CardDeam();
        List<Card> L=cd.buyDeck();
        cd.washCard(L);
        System.out.println(L);
    }
}
