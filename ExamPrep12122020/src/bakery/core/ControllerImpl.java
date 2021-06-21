package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.Bread;
import bakery.entities.bakedFoods.Cake;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.Tea;
import bakery.entities.drinks.Water;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double income;
    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
    this.foodRepository = foodRepository;
    this.drinkRepository = drinkRepository;
    this.tableRepository = tableRepository;
    this.income = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = null;
        if (this.foodRepository.getAll().stream().anyMatch(e -> e.getName().equals(name))){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type, name));
        }
        if (type.equals("Bread")){
            food = new Bread(name, price);
        }else if (type.equals("Cake")){
            food = new Cake(name, price);
        }
        this.foodRepository.add(food);
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = null;
        if (this.drinkRepository.getAll().stream().anyMatch(e -> e.getName().equals(name))){
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type, name));
        }
        if (type.equals("Tea")){
            drink = new Tea(name, portion, brand);
        }else if (type.equals("Water")){
            drink = new Water(name, portion, brand);
        }
        this.drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (this.tableRepository.getAll().stream().anyMatch(e -> e.getTableNumber() == tableNumber)){
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        if (type.equals("InsideTable")){
            table = new InsideTable(tableNumber, capacity);
        }else if (type.equals("OutsideTable")){
            table = new OutsideTable(tableNumber, capacity);
        }
        this.tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        for (Table table : this.tableRepository.getAll()) {
            if (table.getCapacity() >= numberOfPeople && !table.isReserved()){
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED ,table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        BakedFood food = this.foodRepository.getByName(foodName);
        if (this.tableRepository.getAll().stream().noneMatch(e -> e.getTableNumber() != tableNumber)){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if(food == null){
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        for (Table table : tableRepository.getAll()) {
            if (table.getTableNumber() == tableNumber){
                table.orderFood(food);
                return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
            }
        }
        return null;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (this.tableRepository.getAll().stream().noneMatch(e -> e.getTableNumber() != tableNumber)){
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        if(drink == null){
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        for (Table table : tableRepository.getAll()) {
            if (table.getTableNumber() == tableNumber){
                table.orderDrink(drink);
                return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
            }
        }
        return null;

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = this.tableRepository.getByNumber(tableNumber);
        double tableBill = table.getBill();
        this.income += tableBill;
        table.clear();
        return String.format(BILL, tableNumber, tableBill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder result = new StringBuilder();
        for (Table table : this.tableRepository.getAll()) {
            if (!table.isReserved()){
                result.append(table.getFreeTableInfo());
            }
        }
        return result.toString();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.income);
    }
}
