package by.vladsimonenko.spring.entity;

import java.util.ArrayList;
import java.util.List;

public class AvailableHours {
    private List<Integer> hours;
    private static final AvailableHours INSTANCE = new AvailableHours();
    private AvailableHours() {
        hours = new ArrayList<>();
        hours.add(2);
        hours.add(5);
        hours.add(10);
        hours.add(24);
        hours.add(48);
    }

    public static AvailableHours getInstance(){
        return INSTANCE;
    }

    public List<Integer> getHours() {
        return hours;
    }
}
