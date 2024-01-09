import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<String, Double> products;

    public Calculator() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, double price) {
        products.put(name, price);
    }

    public Map<String, Double> getProducts() {
        return products;
    }

    public double calculateTotalCost() {
        return products.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double calculateCostPerPerson(int numberOfPeople) {
        return calculateTotalCost() / numberOfPeople;
    }
}

