package events;

public record WriteArrayReference(int arrayId, int arrayIndex, int targetId) implements GCEvent {}
