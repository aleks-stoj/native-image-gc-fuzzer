package application;

import generator.EventGenerator;
import events.GCEvent;

import java.util.List;

public class Main {
    static void main() {
        EventGenerator generator = new EventGenerator(123L);
        List<GCEvent> events = generator.createEventList(100);

        for(int i = 0; i < events.size(); i++) {
            System.out.println(i+1 + ": " + events.get(i));
        }
    }
}
