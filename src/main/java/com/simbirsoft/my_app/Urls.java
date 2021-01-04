package com.simbirsoft.my_app;

public interface Urls {

    String API = "api";
    String API_VERSION = "v1";
    String ROOT = "/" + API + "/" + API_VERSION;

    interface Electricity{
        String PART = "electricity";
        String FULL = ROOT + "/" + PART;
    }
    interface Expense{
        String PART = "expenses";
        String FULL = ROOT + "/" + PART;
    }
    interface Rate{
        String PART = "rates";
        String FULL = ROOT + "/" + PART;
    }
    interface WaterSupply{
        String PART = "waterSupply";
        String FULL = ROOT + "/" + PART;
    }

    interface Authentication{
        String PART = "authentication";
        String FULL = ROOT + "/" + PART;
    }
}
