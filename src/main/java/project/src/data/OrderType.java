package project.src.data;

import java.util.ArrayList;

public enum OrderType {
    ADD,
    LIST,
    EXIT;

    public static String getAvailableOrders(){
        ArrayList<String> result = new ArrayList<String>();
        for (OrderType i : OrderType.values()) {
            result.add(i.toString().toLowerCase());
        }
        return String.join("/", result);
    }
}
