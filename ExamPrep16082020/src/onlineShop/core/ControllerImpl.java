package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;
    private Map<Integer, Peripheral> peripherals;
    private Map<Integer, Component> components;

    public ControllerImpl() {
        computers = new HashMap<>();
        peripherals = new HashMap<>();
        components = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        if (computerType == null || computerType.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        Computer computer = null;
        switch (computerType){
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
        }
        computers.put(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer
            , String model, double price, double overallPerformance, String connectionType) {
        if (peripherals.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        if (peripheralType == null || peripheralType.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        Peripheral peripheral = null;
        switch (peripheralType){
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
        }
        computers.get(computerId).addPeripheral(peripheral);
        peripherals.put(id, peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(
                    NOT_EXISTING_COMPUTER_ID);
        }
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id,
                        manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        components.put(component.getId(), component);

        computers.get(computerId).addComponent(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(
                    NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }


    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(
                    NOT_EXISTING_COMPUTER_ID);
        }
        Component component =
                computers.get(computerId).removeComponent(componentType);

        components.remove(component.getId());

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(
                    NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> filteredComputers = computers.values()
                .stream()
                .filter(c -> c.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        if (filteredComputers.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        Computer computer = filteredComputers.get(0);

        computers.remove(computer.getId());

        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(
                    NOT_EXISTING_COMPUTER_ID);
        }
        return computers.get(id).toString();
    }
}
