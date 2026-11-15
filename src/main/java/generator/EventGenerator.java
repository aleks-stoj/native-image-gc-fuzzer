package generator;

import events.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    private final Random random;
    private final List<Integer> allocatedObjects;

    private int nextObjectId = 0;

    public EventGenerator(long seed) {
        this.random = new Random(seed);
        this.allocatedObjects = new ArrayList<>();
    }

    private GCEvent generate() {
        return switch (random.nextInt(5)) {
            case 0 -> generateAllocatedObject();
            case 1 -> generateAllocatedArray();
            case 2 -> generateWriteFieldReference();
            case 3 -> generateWriteArrayReference();
            case 4 -> new Collect();
            default -> throw new IllegalStateException();
        };
    }

    private GCEvent generateAllocatedObject() {
        int id = nextObjectId++;
        allocatedObjects.add(id);
        return new AllocateObject(id, 0);
    }

    private GCEvent generateAllocatedArray() {
        int id = nextObjectId++;
        allocatedObjects.add(id);
        return new AllocateArray(id, random.nextInt(100));
    }

    private GCEvent generateWriteFieldReference() {
        int sourceId = 1;
        int targetId = 2;
        return new WriteFieldReference(sourceId, 0, targetId);
    }

    private GCEvent generateWriteArrayReference() {
        int sourceId = 2;
        int targetId = 3;
        return new WriteArrayReference(sourceId, 0, targetId);
    }
    
    public List<GCEvent> createEventList(int length) {
        List<GCEvent> events = new ArrayList<>();
        
        for(int i = 0; i < length; i++) {
            events.add(generate());
        }
        
        return events;
    }
}
