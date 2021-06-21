package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private List<Decoration> decorations;
    private List<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        //TODO check again
        if (capacity < this.fish.size()){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fishRep : fish) {
            fishRep.eat();
        }
    }

    @Override
    public String getInfo() {
        if (this.fish.isEmpty()){
            return "none";
        }
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName())).append(System.lineSeparator());
        String fishNames = "";
        for (Fish fish1 : fish) {
            fishNames += fish1.getName() + " ";
        }
        fishNames = fishNames.trim();
        result.append(String.format("Fish: %s", fishNames)).append(System.lineSeparator());
        result.append(String.format("Decorations: %d", this.decorations.size())).append(System.lineSeparator());
        result.append(String.format("Comfort: %d", this.calculateComfort()));
        return result.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public boolean isItFull(){
        return this.capacity >= this.decorations.size();
    }
}
