package events;

public record AllocateObject(int objectId) implements GCEvent {}