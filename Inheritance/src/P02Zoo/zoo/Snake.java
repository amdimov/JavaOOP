package P02Zoo.zoo;

public class Snake extends Reptile{
    public Snake(String snakeName){
        super(snakeName);
    }

    @Override
    public String getName() {
        return super.getName() + " sss";
    }
}
