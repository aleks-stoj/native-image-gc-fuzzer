package events;

public record AllocateArray(int objectId, int arrayLength) implements GCEvent {}