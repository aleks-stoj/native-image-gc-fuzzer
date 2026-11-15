package deserializer;

import events.GCEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class EventDeserializer {
    public List<GCEvent> deserializeEvents(String filename) {
        List<GCEvent> events = new ArrayList<>();
        try(FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file)) {

            GCEvent event = (GCEvent) in.readObject();
            events.add(event);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }

        return events;
    }
}
