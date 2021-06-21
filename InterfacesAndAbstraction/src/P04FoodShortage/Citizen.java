package P04FoodShortage;

public class Citizen implements Identifiable, Birthable, Buyer, Person {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        setName(name);
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    private void setName(String name) {
        if (name.isEmpty()){
            name = null;
        }else {
            this.name = name;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
    @Override
    public int getFood() {
        return this.food;
    }
}
