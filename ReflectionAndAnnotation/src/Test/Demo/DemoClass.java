package Test.Demo;

public class DemoClass extends SuperDemoClass{
    private int id;
    private String name;
    private int age;

    public DemoClass(String name) {
        super(name);
        this.id = 15;
        this.name = name;
        this.age = 1;
    }
//    public DemoClass() {
//        super("Check");
//        this.id = 2;
//        this.name = "Some Random Name";
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
