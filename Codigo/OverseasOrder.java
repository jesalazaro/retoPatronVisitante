public class OverseasOrder implements Order {
  private String orderId;
  private double orderAmount;
  private double additionalSH;
  private double orderTotal;

  public OverseasOrder() {
  }
  public OverseasOrder(String inp_orderId, double inp_orderAmount, double inp_additionalSH) {
    orderId = inp_orderId;
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    orderTotal = v.visit(this);
  }
  public double getOrderValue() {
    return orderTotal;
  }
}
