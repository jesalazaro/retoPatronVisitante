import javax.swing.*;
import java.awt.*;

public class NonCaliforniaBuilder extends UIBuilder {

    private JLabel lblOrderAmount;

    private JTextField txtOrderAmount;

    public void addUIControls() {

        searchUI = new JPanel();


        lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();


        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);
    }


    public double getOrderAmountValue() {
        double orderAmountValue = Double.parseDouble(txtOrderAmount.getText());
        return orderAmountValue;
    }

    public double getTaxValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTaxValue'");
    }

    public double getSHValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSHValue'");
    }
}
