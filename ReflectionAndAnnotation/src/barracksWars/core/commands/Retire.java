package barracksWars.core.commands;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Retire extends Command {
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        super.getRepository().removeUnit(super.getData()[1]);
        return super.getData()[1] + " retired!";
    }
}
