package com.sf;

public class SadFortuneService extends FortuneService {

    @Override
    public String getFortune() {
        return "Today is a sad day";
    }

}