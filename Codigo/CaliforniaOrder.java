public class CaliforniaOrder implements Order {
  private String orderId;
  private double orderAmount;
  private double additionalTax;
  private double orderTotal;

  public CaliforniaOrder() {
  }
  public CaliforniaOrder(String inp_orderId, double inp_orderAmount, double inp_additionalTax) {
    orderId = inp_orderId;
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public void accept(OrderVisitor v) {
    orderTotal = v.visit(this);
  }
  
  public double getOrderValue() {
    return orderTotal;
  }

}

