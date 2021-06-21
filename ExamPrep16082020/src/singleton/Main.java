package singleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingletonContainer.initTracker();
        PopulationTracker tracker = SingletonContainer.getTracker();
        tracker.add("Sofia", 100);
        PopulationTracker tracker2 = SingletonContainer.getTracker();
        tracker2.add("Plovdiv", 200);
        System.out.println(tracker.getPopulation("Sofia"));
        System.out.println(tracker2.getPopulation("Plovdiv"));
        tracker2.add("Sofia", 500);
        System.out.println(tracker.getPopulation("Sofia"));
        addValue(tracker);
        System.out.println(tracker2.getPopulation("Sofia"));
        tracker2.setTrackerName("My Tracker").setTrackerID("TR1231");
        System.out.println(tracker.getTrackerName());
        System.out.println(tracker.getTrackerName());
        System.out.println(tracker.getTrackerID());
    }
    private static void addValue(PopulationTracker tracker){
        tracker = SingletonContainer.getTracker();
        tracker.add("Sofia", 100);
    }
}
