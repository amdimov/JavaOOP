package P03WildFarm;

public class Food {
    private Integer quantity;
    protected Food(Integer quantity){
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
