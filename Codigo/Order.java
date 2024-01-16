public interface Order {
  public void accept(OrderVisitor v);
  public double getOrderValue();
}
