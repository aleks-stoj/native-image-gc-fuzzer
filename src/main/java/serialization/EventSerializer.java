package serialization;

import events.GCEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class EventSerializer {
    public void serializeEvents(List<GCEvent> events, String filename) {
        try(FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file)
        ){
            for(GCEvent event : events) {
                out.writeObject(event);
            }
            System.out.println("Event(s) serialized!");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file");
        } catch (IOException e) {
            System.out.println("Cannot write to file");
        }
    }
}
