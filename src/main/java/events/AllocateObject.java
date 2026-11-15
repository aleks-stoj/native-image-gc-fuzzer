package events;

public record AllocateObject(int objectId, int classId) implements GCEvent {}