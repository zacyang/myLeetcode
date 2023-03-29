package trading;

import java.util.*;

public class OrderList {
    private final TreeMap<Double, LinkedList<Order>> orders;

    public OrderList() {
        orders = new TreeMap<>();

    }

    public Map.Entry<Double, LinkedList<Order>> getCeiling() {
        Map.Entry<Double, LinkedList<Order>> doubleLinkedListEntry = orders.ceilingEntry(null);
        return doubleLinkedListEntry;
    }

    public void add(Order order) {
        LinkedList<Order> list = orders.computeIfAbsent(order.getPrice(), k -> new LinkedList<>());
        list.add(order);
    }

    public void remove(Order order) {
        LinkedList<Order> list = orders.get(order.getPrice());
        if (list != null) {
            list.remove(order);
            if (list.isEmpty()) {
                orders.remove(order.getPrice());
            }
        }
    }

    public List<Order> getOrders() {
        List<Order> allOrders = new ArrayList<>();
        orders.values().forEach(allOrders::addAll);
        return allOrders;
    }

    public void update(Order order) {
        LinkedList<Order> list = orders.get(order.getPrice());
        if (list != null) {
            int index = list.indexOf(order);
            if (index >= 0) {
                list.set(index, order);
            }
        }
    }

    public boolean isEmpty() {
        return false;
    }
}

enum Side {BUY, SELL}

class Order {
    private final String orderId;
    private final String symbol;
    private final Side side;
    private final int quantity;
    private final double price;
    private boolean isBuy;
    private boolean isBusy;

    public Order(String orderId, String symbol, Side side, int quantity, double price, boolean isBuy) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.isBuy = isBuy;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public boolean isBusy() {
        return isBusy;
    }

    // method to set the busy state of the order
    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public Side getSide() {
        return side;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
    }
}