package P03BirthdayCelebrations;

public class Pet implements Birthable, Creaturable {
    private String name;
    private String birthDate;
    public Pet(String name, String birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }
    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
