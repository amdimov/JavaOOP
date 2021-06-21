package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.List;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl(){
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }
    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        if (aquariumType.equals("FreshwaterAquarium")){
            aquarium = new FreshwaterAquarium(aquariumName);
        }else if (aquariumType.equals("SaltwaterAquarium")){
            aquarium = new SaltwaterAquarium(aquariumName);
        }else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;
        if (type.equals("Ornament")){
            decoration = new Ornament();
        }else if (type.equals("Plant")){
            decoration = new Plant();
        }else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        //Insert from depository to Aquarium
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration != null) {
            for (Aquarium aquarium : aquariums) {
                if (aquarium.getName().equals(aquariumName)) {
                    aquarium.addDecoration(decoration);
                    this.decorations.remove(decoration);
                    break;
                }
            }
        }else {
            throw new IllegalStateException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        BaseAquarium aquarium = null;
        Fish fish = null;
        boolean isItSuitable = false;
        String aquariumType = "";
        for (Aquarium aquarium1 : aquariums) {
            if (aquarium1.getName().equals(aquariumName)){
                aquarium = (BaseAquarium) aquarium1;
                aquariumType = aquarium1.getClass().getSimpleName();
                break;
            }
        }
        if (aquarium == null){
            throw new IllegalArgumentException("No such aquarium! (Cusotm excpt)");
        }
        if (fishType.equals("FreshwaterFish")){
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        }else if (fishType.equals("SaltwaterFish")){
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        }else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        if (!aquarium.isItFull()){
            return "Not enough capacity.";
        }
        if (fish.getClass().getSimpleName().equals(fishType) && aquariumType.equals("FreshwaterAquarium")){
            aquarium.addFish(fish);
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
        }else if (fish.getClass().getSimpleName().equals(fishType) && aquariumType.equals("SaltwaterAquarium")){
            aquarium.addFish(fish);
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
        }else {
            return WATER_NOT_SUITABLE;
        }

    }

    @Override
    public String feedFish(String aquariumName) {
        for (Aquarium aquarium : aquariums) {
            if(aquarium.getName().equals(aquariumName)){
                return String.format("Fish fed: %d", aquarium.getFish().size());
            }
        }
        return null;
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : aquariums) {
            if (aquariumName.equals(aquarium1.getName())){
                //VALUE_AQUARIUM = "The value of Aquarium %s is %.2f.";
                return String.format(VALUE_AQUARIUM, aquariumName,
                        aquarium1.getFish().stream().mapToDouble(Fish::getPrice).sum()
                                + aquarium1.getDecorations().stream().mapToDouble(Decoration::getPrice).sum());
            }
        }
        return null;
    }

    @Override
    public String report() {
        StringBuilder result = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            result.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
