public class NonCaliforniaOrder implements Order {
  private String orderId;
  private double orderAmount;
  private double orderTotal;

  public NonCaliforniaOrder(String inp_orderId,double inp_orderAmount) {
    orderId =  inp_orderId;
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    orderTotal = v.visit(this);
  }
  public double getOrderValue() {
    return orderTotal;
  }
}
