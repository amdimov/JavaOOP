package P03BirthdayCelebrations;

public class Robot implements Identifiable, Machinable {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.setId(id);
        this.setModel(model);
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
