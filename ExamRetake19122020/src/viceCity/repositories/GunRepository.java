package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public List<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)){
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
