package generator;

import events.AllocateArray;
import events.AllocateObject;
import events.Collect;
import events.GCEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    private final Random random;

    public EventGenerator(long seed) {
        this.random = new Random(seed);
    }

    private GCEvent generate() {
        return switch (random.nextInt(3)) {
            case 0 -> new AllocateObject();
            case 1 -> new AllocateArray();
            case 2 -> new Collect();
            default -> throw new IllegalStateException();
        };
    }
    
    public List<GCEvent> createEventList(int length) {
        List<GCEvent> events = new ArrayList<>();
        
        for(int i = 0; i < length; i++) {
            events.add(generate());
        }
        
        return events;
    }
}
