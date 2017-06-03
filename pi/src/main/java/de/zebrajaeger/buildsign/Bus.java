package de.zebrajaeger.buildsign;

import com.google.common.eventbus.EventBus;

/**
 * @author Lars Brandt
 */
public class Bus {
    private static final EventBus EVENT_BUS = new EventBus();

    public static EventBus get() {
        return EVENT_BUS;
    }

    public static void post(Object msg) {
        EVENT_BUS.post(msg);
    }
    public static void register(Object msg) {
        EVENT_BUS.register(msg);
    }
    public static void unregister(Object msg) {
        EVENT_BUS.unregister(msg);
    }
}
