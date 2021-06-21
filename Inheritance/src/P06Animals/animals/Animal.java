package P06Animals.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;

    protected Animal(String name, int age, String gender) {
        this.name = name;
        setAge(age);
        this.gender = gender;
    }
    public abstract String produceSound();
    private void throwException() {
        throw new IllegalStateException("Invalid input!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    private void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %s %s%n%s", this.getClass().getSimpleName(),
                this.getName(), this.getAge(), this.getGender(), this.produceSound());
    }
}
