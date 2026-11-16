package events;

public record AddGCRoot(int objectId) implements GCEvent {}
