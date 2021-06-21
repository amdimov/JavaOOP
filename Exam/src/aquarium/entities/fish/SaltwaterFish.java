package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static int INITIAL_SIZE = 5;
    //Can only live in SaltwaterAquarium!
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }
    @Override
    public void eat() {
        super.setSize(INITIAL_SIZE*2);
    }


}
