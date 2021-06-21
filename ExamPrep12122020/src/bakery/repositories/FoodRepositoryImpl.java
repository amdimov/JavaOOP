package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new LinkedHashSet<>();
    }
    @Override
    public BakedFood getByName(String name) {
        for (BakedFood model : models) {
            if (model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(BakedFood food) {
        this.models.add(food);
    }
}
