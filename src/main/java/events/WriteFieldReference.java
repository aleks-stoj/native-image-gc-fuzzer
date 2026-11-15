package events;

public record WriteFieldReference(int sourceId, int fieldIndex, int targetId) implements GCEvent{
}
