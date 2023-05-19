package com.knoldus.producer;

import com.knoldus.model.CoffeeOrder;

public class CoffeeOrderUtil {

    public static CoffeeOrder buildOrder(){
        return CoffeeOrder.newBuilder()
                .setId(2)
                .setName("Cake")
                .setStoreName("Bing")
                .build();

    }

}
