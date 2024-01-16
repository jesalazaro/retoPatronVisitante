import java.util.*;

class OrderVisitor implements VisitorInterface {
  private HashMap orderObjList;
  private double orderValue;

  public OrderVisitor() {
    orderObjList = new HashMap();
  }
  public double visit(NonCaliforniaOrder inp_order) {
    orderValue = inp_order.getOrderAmount();
    return orderValue ;
  }
  public double visit(CaliforniaOrder inp_order) {
    orderValue = inp_order.getOrderAmount() + inp_order.getAdditionalTax();
    return orderValue;
  }
  public double visit(OverseasOrder inp_order) {
    orderValue = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    return orderValue;
  }

  public double visit(BrazilianOrder inp_order){
    orderValue = inp_order.getOrderAmount() + inp_order.getAdditionalSH();
    return orderValue;
  }
  
  public double getOrderTotal(Iterator ao) {
    double orderResult = 0.0;
    while (ao.hasNext()) {
      Map.Entry<String, Order> entry = (Map.Entry<String, Order>) ao.next();
      orderResult = orderResult + entry.getValue().getOrderValue() ;
    }
   // orderObjList = ordenes;
    return orderResult;
  }

}
