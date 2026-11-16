package events;

public record RemoveGCRoot(int objectId) implements GCEvent {}
