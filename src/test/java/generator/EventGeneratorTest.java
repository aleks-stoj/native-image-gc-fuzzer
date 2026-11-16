package generator;

import events.GCEvent;
import org.junit.jupiter.api.Test;
import serialization.EventDeserializer;
import serialization.EventSerializer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventGeneratorTest {
    @Test
    public void sameSeedProducesSameEvents() {
        EventGenerator generator1 = new EventGenerator(123L);
        EventGenerator generator2 = new EventGenerator(123L);

        assertEquals(generator1.createEventList(100), generator2.createEventList(100));
    }

    @Test
    public void serializationDeserializationTest() {
        EventGenerator generator = new EventGenerator(123L);
        EventSerializer serializer = new EventSerializer();
        EventDeserializer deserializer = new EventDeserializer();

        List<GCEvent> events = generator.createEventList(100);
        serializer.serializeEvents(events, "test.txt");
        List<GCEvent> deserializedEvents = deserializer.deserializeEvents("test.txt");

        assertEquals(events, deserializedEvents);
    }
}