package application;

import events.GCEvent;
import generator.EventGenerator;
import serialization.EventDeserializer;
import serialization.EventSerializer;

import java.util.List;

public class Main {
    private static final String FILENAME = "events.txt";
    static void main() {
        EventGenerator generator = new EventGenerator(123L);
        List<GCEvent> events = generator.createEventList(100);

        EventSerializer serializer = new EventSerializer();
        EventDeserializer deserializer = new EventDeserializer();

        System.out.println("Generating events...");

        for(int i = 0; i < events.size(); i++) {
            System.out.println(i+1 + ": " + events.get(i));
        }

        serializer.serializeEvents(events, FILENAME);

        for(GCEvent event : deserializer.deserializeEvents(FILENAME)) {
            System.out.println(event);
        }
    }
}
