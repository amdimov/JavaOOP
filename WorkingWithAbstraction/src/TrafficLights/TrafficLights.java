package TrafficLights;

public enum TrafficLights {
    RED,
    GREEN,
    YELLOW;

    public TrafficLights getNextLight(TrafficLights currentLight){
        TrafficLights nextTrafficLight;
        if (currentLight == YELLOW){
            nextTrafficLight = RED;
        }else if (currentLight == RED){
            nextTrafficLight = GREEN;
        }else {
            nextTrafficLight = YELLOW;
        }
        return nextTrafficLight;
    }
}
