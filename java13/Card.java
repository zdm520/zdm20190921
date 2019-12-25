package com.java.zhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    private String suit;
    private int rank;
    public Card(String suit,int rank){
        this.suit=suit;
        this.rank=rank;
    }

    @Override
    public String toString() {
        String str=String.format("%d",rank);
        switch (rank)
        {
            case 11:
                str="J";
                break;
            case 12:
                str="Q";
                break;
            case 13:
                str="K";
                break;
        }
        return suit+":"+str;
    }
}
class CardDeam{

    //构造一副扑克牌
    String  Color[]={"♥","♠","♣","♦"};
    public List<Card> buyDeck(){
        List<Card> cards=new ArrayList<>();
        for(int i=0;i<4;i++){
            for (int j=1;j<14;j++){
                Card card=new Card(Color[i],j);
                cards.add(card);
            }
        }
        return cards;
    }

    public void washCard(List<Card> cards){
        for(int i=cards.size()-1;i>0;i--){
            Random random=new Random(20191224);
            int j=random.nextInt(i);
            Swap(cards,i,j);
        }
    }
    public void Swap(List<Card> cards,int i,int j){
        Card temp=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,temp);
    }


}