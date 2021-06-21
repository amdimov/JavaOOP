package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;

import static viceCity.common.ConstantMessages.*;


public class ControllerImpl implements Controller {
    private List<Gun> guns;
    private List<Player> players;
    private Player mainPlayer;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.guns = new ArrayList<>();
        this.players = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        players.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        switch (type){
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return "Invalid gun type!";
        }
        guns.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()){
            return GUN_QUEUE_IS_EMPTY;
        }
        String gunType = guns.get(0).getName();
        if (name.equals("Vercetti")){
            mainPlayer.getGunRepository().getModels().add(guns.get(0));
            guns.remove(0);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER,gunType, "Tommy Vercetti");
        }
        for (Player player : players) {
            if (player.getName().equals(name)){
                player.getGunRepository().getModels().add(guns.get(0));
                guns.remove(0);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gunType, name);
            }
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        int civilsAtStart = players.size();
        neighbourhood.action(mainPlayer, players);
        boolean isItHurt = false;
        for (Player player : players) {
            if (player.getLifePoints() < 50){
                isItHurt = true;
            }
        }
        if (!isItHurt){
            return FIGHT_HOT_HAPPENED;
        }

        return String.format("A fight happened:%nTommy live points: %s!%nTommy has killed: %d players!%nLeft Civil Players: %d!",
                mainPlayer.getLifePoints(), civilsAtStart - players.size(), players.size());
    }
}
