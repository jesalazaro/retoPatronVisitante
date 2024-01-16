import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import java.util.Iterator;

public class AllOrders implements Iterator{

    private static AllOrders allOrders;
    private HashMap<String, Order> orderCollection;
    private Order nextOrder;
    Iterator<Map.Entry<String, Order>> iterator;

    

    private AllOrders() {
        orderCollection =  new HashMap<>();
    }
  
    public static synchronized AllOrders getOrders() {
      if (allOrders == null) {
        allOrders = new AllOrders();
      }
      return allOrders;
    }

    public void addOrder(String orderId, Order order){
        orderCollection.put(orderId, order);
    }

    public Iterator getAllOrder(){
      iterator = orderCollection.entrySet().iterator();
      return iterator;
    }

    public boolean hasNext() {
      return iterator.hasNext();
    }

    public boolean findExistingOrder(String orderId) {
      Order existingOrder = orderCollection.get(orderId);
      if (existingOrder != null ){
        return true;
      }
      else {
        return false;
      }
    }

    public Map.Entry<String, Order> next() {
      return iterator.next();
    }
}
