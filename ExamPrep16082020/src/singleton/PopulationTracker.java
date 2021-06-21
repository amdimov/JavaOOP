package singleton;

import java.util.HashMap;
import java.util.Map;

public class PopulationTracker implements Builder<PopulationTracker>{
    private Map<String, Integer> count;
    private static PopulationTracker instance;
    private String trackerName;
    private String trackerID;
    private static boolean isItSet;

    private PopulationTracker(){
        this.count = new HashMap<>();
    }

    public void add(String location, int quantity){
        this.count.putIfAbsent(location, 0);
        this.count.put(location, this.count.get(location) + quantity);
    }
    public void remove(String location, int quantity){
        if (!this.count.containsKey(location)){
            throw new IllegalStateException("No such location");
        }
        this.count.remove(location, this.count.get(location) - quantity);
    }
    public int getPopulation(String location){
        return this.count.get(location);
    }
    public static PopulationTracker getInstance(){
        if (instance == null){
            instance = new PopulationTracker();
        }
        return instance;
    }


    @Override
    public PopulationTracker setTrackerName(String name) {
        if (!isItSet) {
            isItSet = true;
            this.trackerName = name;
            return this;
        }else {
            throw new IllegalStateException("Tracker name has been already set");
        }
    }

    @Override
    public PopulationTracker setTrackerID(String id) {
        this.trackerID = id;
        return this;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public String getTrackerID() {
        return trackerID;
    }

}
