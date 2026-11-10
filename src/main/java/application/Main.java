package application;

import generator.EventGenerator;
import events.GCEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Main {
    static void main() {
        EventGenerator generator = new EventGenerator(123L);
        List<GCEvent> events = generator.createEventList(100);
        System.out.println("Generating events...");

        for(int i = 0; i < events.size(); i++) {
            System.out.println(i+1 + ": " + events.get(i));
        }

        try(FileOutputStream file = new FileOutputStream("events.txt");
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
