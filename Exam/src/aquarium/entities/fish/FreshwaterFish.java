package aquarium.entities.fish;


public class FreshwaterFish extends BaseFish {
    private static int INITIAL_SIZE = 3;
    //Can only live in FreshwaterAquarium!
    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
    }
    @Override
    public void eat() {
        super.setSize(INITIAL_SIZE*3);
    }


}
