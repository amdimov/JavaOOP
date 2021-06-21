package testPackage;

public class Human extends Animal {
    private String humanName;
    private int age;
    public Human(){
        super("Default Name", 0);
    }

    @Override
    public void canEat() {
        System.out.println("I Am testPackage.Human");
    }

    public void humanEat(){
        System.out.println("I am testPackage.Human");
    }
}
