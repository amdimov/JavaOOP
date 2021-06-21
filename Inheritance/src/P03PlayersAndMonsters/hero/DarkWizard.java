package P03PlayersAndMonsters.hero;

public class DarkWizard extends Wizard {
    public DarkWizard(String username, int level) {
        super(username, level);
    }
    public int getSomething(){
        return 1;
    }

    @Override
    public String getUsername() {
        return "The name is " + super.getUsername();
    }
}
