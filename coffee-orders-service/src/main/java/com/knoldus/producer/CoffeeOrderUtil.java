package com.knoldus.producer;

import com.knoldus.model.*;

import java.util.List;
import java.util.Random;

public class CoffeeOrderUtil {

    public static CoffeeOrder buildOrder(){
        return CoffeeOrder.newBuilder()
                .setId(randomId())
                .setName("Riya Sharma")
                .setNickName("Riya")
                .setStore(generateStore())
                .setOrderLineItems(generateOrderLineItems())
                .build();

    }

    private static List<OrderLineItem> generateOrderLineItems(){
        var orderLineItem = OrderLineItem.newBuilder()
                .setName("Latte")
                .setQuantity(2)
                .setSize(Size.MEDIUM)
                .build();

        return List.of(orderLineItem);
    }

    private static Store generateStore(){
            return Store.newBuilder()
                    .setId(randomId())
                    .setAddress(buildAddress())
                    .build();
    }

    private static Address buildAddress(){
        return Address.newBuilder()
                .setCity("Manhattan")
                .setStreet("141 Lane")
                .setZip(11001)
                .build();
    }


    public static int randomId(){
        Random random = new Random();
        return random.nextInt(1000);
    }

}
