package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GangNeighbourhood implements Neighbourhood {
    public GangNeighbourhood(){
    }
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        int index = 0;
        if(mainPlayer.isAlive() && !civilPlayers.isEmpty()){
            while (!mainPlayer.getGunRepository().getModels().isEmpty()) {
                int livePoints = mainPlayer.getGunRepository().getModels().fire();
                for (Player civilPlayer : civilPlayers) {
                    civilPlayer.takeLifePoints(livePoints);
                    if (!civilPlayer.isAlive()){
                        civilPlayers.remove(civilPlayer);
                    }
                    if (!gun.canFire()){
                        mainPlayer.getGunRepository().getModels().remove(gun);
                        break;
                    }
                }
            }
        }
        if (civilPlayers.isEmpty()){
            return;
        }
        if (mainPlayer.isAlive()){
            for (Player civilPlayer : civilPlayers) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                    mainPlayer.takeLifePoints(gun.fire());
                    if (!mainPlayer.isAlive()){
                        return;
                    }
                    if (civilPlayer.getGunRepository().getModels().isEmpty()){
                        civilPlayer.getGunRepository().getModels().remove(gun);
                        break;
                    }
                }
            }
        }

    }

}
