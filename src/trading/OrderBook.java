package trading;
import java.util.Map;
import java.util.TreeMap;

public class OrderBook {
    private String symbol;
    private Map<Double, OrderList> bids;
    private Map<Double, OrderList> asks;

    public OrderBook(String symbol) {
        this.symbol = symbol;
        bids = new TreeMap<>(java.util.Collections.reverseOrder());
        asks = new TreeMap<>();
    }

    public void add(Order order) {
        double price = order.getPrice();
        OrderList orders = (order.isBuy() ? bids : asks).getOrDefault(price, new OrderList());
        orders.add(order);
        (order.isBuy() ? bids : asks).put(price, orders);
    }

    public void remove(Order order) {
        double price = order.getPrice();
        OrderList orders = (order.isBuy() ? bids : asks).get(price);
        if (orders != null) {
            orders.remove(order);
            if (orders.isEmpty()) {
                (order.isBuy() ? bids : asks).remove(price);
            }
        }
    }

    public void update(Order order, double newPrice) {
        remove(order);
        order.setPrice(newPrice);
        add(order);
    }

    public String getSymbol() {
        return symbol;
    }

    public Map<Double, OrderList> getBids() {
        return bids;
    }

    public Map<Double, OrderList> getAsks() {
        return asks;
    }

}







