package singleton;

public interface Builder<T extends Builder> {
    T setTrackerName(String name);
    T setTrackerID(String id);
}
