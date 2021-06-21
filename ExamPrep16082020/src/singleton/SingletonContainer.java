package singleton;

public class SingletonContainer {
    private static PopulationTracker tracker;
    private static boolean isItInit;
    private SingletonContainer(){

    }
    public static void initTracker(){
        if (!isItInit) {
            isItInit = true;
            tracker = PopulationTracker.getInstance();
        }
    }
    public static PopulationTracker getTracker(){
        if (!isItInit){
            throw new IllegalStateException("SingletonContainer not initialized. Call initTracker() first!");
        }
        return tracker;
    }


}
