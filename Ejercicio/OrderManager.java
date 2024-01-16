import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {
  private JPanel pSearchCriteria;
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String UPDATE_ORDER = "Update Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER = "Non-California Order";
  public static final String OVERSEAS_ORDER = "Overseas Order";
  public static final String BRAZILIAN_ORDER = "Brazilian Order";


  private JComboBox cmbOrderType;
  private JLabel lblOrderType, lblOrderId;
  private JLabel lblTotal, lblTotalValue;
  private JTextField txtOrderId;
  private OrderVisitor objVisitor;
  private JTextArea taAllOrders;

  public OrderManager() {
    super("Visitor Pattern - Example");

    // Create controls
    taAllOrders = new JTextArea(15, 20);
    //taSelectedCandidates.setMargin(new Insets(1,1,1,1));
    taAllOrders.setEditable(false);

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderManager.BRAZILIAN_ORDER);

    lblOrderId = new JLabel("Order Id:");
    lblOrderType = new JLabel("Order Type:");
    lblTotal = new JLabel("Result:");
    lblTotalValue = new JLabel("Click Create or GetTotal Button");

    txtOrderId = new JTextField(10);

    pSearchCriteria = new JPanel();
    //Create the open button
    JButton getTotalButton = new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton = new JButton(OrderManager.CREATE_ORDER);
    createOrderButton.setMnemonic(KeyEvent.VK_C);
    JButton updateOrderButton = new JButton(OrderManager.UPDATE_ORDER);
    updateOrderButton.setMnemonic(KeyEvent.VK_Z);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);

    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    updateOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(updateOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(updateOrderButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 5;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderId);
    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(pSearchCriteria);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);
    buttonPanel.add(txtOrderId);
    buttonPanel.add(taAllOrders);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;


    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderId, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(txtOrderId, gbc);


    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(cmbOrderType, gbc);

    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(pSearchCriteria, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 5;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 5;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.anchor = GridBagConstraints.CENTER;
    gbc.gridx = 1;
    gbc.gridy = 7;
    gridbag.setConstraints(taAllOrders, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    try {
      //UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }

  public void displayNewUI(JPanel panel) {
    pSearchCriteria.removeAll();
    pSearchCriteria.add(panel);
    pSearchCriteria.validate();
    validate();
  }

  public JComboBox getSearchTypeCtrl(){
    return cmbOrderType;
  }

  public String getOrderIdValue() {
    return txtOrderId.getText();
}

public void setTaAllOrders(String orders) {
  taAllOrders.setText(orders);
}

  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );
    //frame.pack();
    frame.setSize(700, 700);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }

} // End of class OrderManager

class ButtonHandler implements ActionListener {

  OrderManager objOrderManager;
  UIBuilder builder;
  

  public void actionPerformed(ActionEvent e) {

    String totalResult = null;


    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }

    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {
      String orderType = objOrderManager.getOrderType();
      String orderId = objOrderManager.getOrderIdValue();
  
      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      double dblSH = 0.0;
      // Singleton, creación de HashMap
      AllOrders allOrders = AllOrders.getOrders();

      if(orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
        dblOrderAmount = builder.getOrderAmountValue();
        dblTax = builder.getTaxValue();
      } else if(orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
        dblOrderAmount = builder.getOrderAmountValue();
      } else if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)){
        dblOrderAmount = builder.getOrderAmountValue();
        dblSH =  builder.getSHValue();
      } else if (orderType.equalsIgnoreCase(OrderManager.BRAZILIAN_ORDER)){
        dblOrderAmount = builder.getOrderAmountValue();
        dblSH =  builder.getSHValue();
      }
      if (orderId.trim().length() != 0){
        boolean existingOrder = allOrders.findExistingOrder(orderId);
        if (!existingOrder){
          //Create the order
          Order order = createOrder(orderId, orderType, dblOrderAmount, dblTax, dblSH);
          //Get the Visitor
          OrderVisitor visitor = objOrderManager.getOrderVisitor();
          // accept the visitor instance
          order.accept(visitor);
          //AddOrder
          allOrders.addOrder(orderId, order);
          objOrderManager.setTotalValue(" Order Created Successfully");
          String orderPrint = "";
          Iterator ao = allOrders.getAllOrder();
          while (ao.hasNext()) {
            Map.Entry<String, Order> entry = (Map.Entry<String, Order>) ao.next();
            orderPrint = orderPrint + "\n" + "Order Id: " + entry.getKey() + ", Order Type: " + entry.getValue().getClass().getName() + ", Total: " + entry.getValue().getOrderValue() ;

          }
          objOrderManager.setTaAllOrders(orderPrint);
          //System.out.println(orderPrint); 
        } 
        else {
          objOrderManager.setTotalValue("An Order with id: " + orderId +" Already exists, Press update or set another id");
        }
      } 
      else{
        objOrderManager.setTotalValue("An order identifier must be ingress");
      }
    }

    if (e.getActionCommand().equals(OrderManager.UPDATE_ORDER)) {
      String orderType = objOrderManager.getOrderType();
      String orderId = objOrderManager.getOrderIdValue();
  
      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      double dblSH = 0.0;
      // Singleton, creación de HashMap
      AllOrders allOrders = AllOrders.getOrders();

      if(orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
        dblOrderAmount = builder.getOrderAmountValue();
        dblTax = builder.getTaxValue();
      } else if(orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
        dblOrderAmount = builder.getOrderAmountValue();
      } else if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)){
        dblOrderAmount = builder.getOrderAmountValue();
        dblSH =  builder.getSHValue();
      } else if (orderType.equalsIgnoreCase(OrderManager.BRAZILIAN_ORDER)){
        dblOrderAmount = builder.getOrderAmountValue();
        dblSH =  builder.getSHValue();
      }

      if (orderId.trim().length() != 0){
        Boolean existingOrder = allOrders.findExistingOrder(orderId);
        if (existingOrder){
          //Create the order
          Order order = createOrder(orderId, orderType, dblOrderAmount, dblTax, dblSH);
          //Get the Visitor
          OrderVisitor visitor = objOrderManager.getOrderVisitor();
          // accept the visitor instance
          order.accept(visitor);
          //AddOrder
          allOrders.addOrder(orderId, order);
          objOrderManager.setTotalValue(" Order with id: "+ orderId +" Updated Successfully");
          String orderPrint = "";
          Iterator ao = allOrders.getAllOrder();
          while (ao.hasNext()) {
            Map.Entry<String, Order> entry = (Map.Entry<String, Order>) ao.next();
            orderPrint = orderPrint + "\n" + "Order Id: " + entry.getKey() + ", Order Type: " + entry.getValue().getClass().getName() + ", Total: " + entry.getValue().getOrderValue() ;
          }
          objOrderManager.setTaAllOrders(orderPrint);
          //System.out.println(orderPrint); 
        } 
        else {
          objOrderManager.setTotalValue("An Order with id: " + orderId +" Doesn't exists, Press create or set another id");
        }
      } 
      else{
        objOrderManager.setTotalValue("An order identifier must be ingress");
      }
    }
    if (e.getSource() == objOrderManager.getSearchTypeCtrl()) {
      String selection = objOrderManager.getOrderType();
      if (selection.equals("") == false) {
        BuilderFactory factory = new BuilderFactory();
        builder = factory.getUIBuilder(selection);
        UIDirector director = new UIDirector(builder);
        director.build();
        JPanel UIObj = builder.getSearchUI();
        objOrderManager.displayNewUI(UIObj);

      }
    }

    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      AllOrders allOrders = AllOrders.getOrders();
      OrderVisitor visitor =objOrderManager.getOrderVisitor();
      Iterator ao = allOrders.getAllOrder();
      totalResult = String.valueOf(visitor.getOrderTotal(ao));
      totalResult = " Orders Total = " + totalResult;
      objOrderManager.setTotalValue(totalResult);
    }
  }

  public Order createOrder(String orderId, String orderType,double orderAmount, double tax, double SH) {

    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
      return new CaliforniaOrder(orderId,orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
      return new NonCaliforniaOrder(orderId,orderAmount);

    }
    if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)) {
      return new OverseasOrder(orderId,orderAmount, SH);
    }
    if (orderType.equalsIgnoreCase(OrderManager.BRAZILIAN_ORDER)) {
      return new BrazilianOrder(orderId,orderAmount, SH);
    }
    return null;
  }

  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
  }

} // End of class ButtonHandler
