package trading;

import java.util.*;

public class MatchingEngine {
//    private final Map<String, OrderBook> orderBooks;
//
//    public MatchingEngine() {
//        orderBooks = new HashMap<>();
//    }
//
//    public void addOrder(Order order) {
//        String symbol = order.getSymbol();
//        OrderBook orderBook = orderBooks.get(symbol);
//        if (orderBook == null) {
//            orderBook = new OrderBook(order.getSymbol());
//            orderBooks.put(symbol, orderBook);
//        }
//        Map<Double, OrderList> doubleOrderListMap = order.isBuy() ? orderBook.getBids() : orderBook.getAsks();
//
//        doubleOrderListMap.get(order.getPrice()).add(order);
//
//        matchOrders(symbol);
//    }
//
//    public void matchOrders(String symbol) {
//        Map<Double, OrderList> bids = orderBooks.get(symbol).getBids();
//        Map<Double, OrderList> asks = orderBooks.get(symbol).getAsks();
//
//        Iterator<Map.Entry<Double, OrderList>> bidItr = bids.entrySet().iterator();
//        Iterator<Map.Entry<Double, OrderList>> askItr = asks.entrySet().iterator();
//
//        while (bidItr.hasNext() && askItr.hasNext()) {
//            Map.Entry<Double, OrderList> bidEntry = bidItr.next();
//            Map.Entry<Double, OrderList> askEntry = askItr.next();
//
//            Double bidPrice = bidEntry.getKey();
//            Double askPrice = askEntry.getKey();
//
//            if (bidPrice.compareTo(askPrice) < 0) {
//                // No matching orders found
//                break;
//            }
//
//            OrderList bidList = bidEntry.getValue();
//            OrderList askList = askEntry.getValue();
//
//            while (!bidList.isEmpty() && !askList.isEmpty()) {
//
//                Map.Entry<Double, LinkedList<Order>> ceiling = bidList.getCeiling();
//
//                Order askOrder = askList.peek();
//
//                if (bidOrder.getPrice() < askOrder.getPrice()) {
//                    // No matching orders found at this price level
//                    break;
//                }
//
//                if (bidOrder.isBuy() && askOrder.isSell()) {
//                    // Matching orders found
//                    int matchedQuantity = Math.min(bidOrder.getQuantity(), askOrder.getQuantity());
//                    bidOrder.setQuantity(bidOrder.getQuantity() - matchedQuantity);
//                    askOrder.setQuantity(askOrder.getQuantity() - matchedQuantity);
//
//                    if (bidOrder.getQuantity() == 0) {
//                        bidList.remove();
//                    }
//
//                    if (askOrder.getQuantity() == 0) {
//                        askList.remove();
//                    }
//
//                    System.out.println("Matched order: " + bidOrder + " with " + askOrder);
//                }
//            }
//
//            // Remove price level if it has no orders
//            if (bidList.isEmpty()) {
//                bidItr.remove();
//            }
//
//            if (askList.isEmpty()) {
//                askItr.remove();
//            }
//        }
//    }
//
//
//    private void removeOrder(OrderBook orderBook, Order order) {
//        OrderList orderList = orderBook.getOrderList(order.isBuy());
//        orderList.removeOrder(order);
//    }
}
