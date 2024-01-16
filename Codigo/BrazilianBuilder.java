import javax.swing.*;
import java.awt.*;

public class BrazilianBuilder extends UIBuilder {

    private JLabel lblOrderAmount;

    private JLabel lblAdditionalSH;

    private JTextField txtOrderAmount;

    private JTextField txtAdditionalSH;

    public void addUIControls() {

        searchUI = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);
        lblAdditionalSH = new JLabel("Additional S & H(Overseas and Brazilian Orders Only):");
        txtAdditionalSH = new JTextField(10);

        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();



        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalSH);
        searchUI.add(txtAdditionalSH);


        gbc.insets.top = 5;
        gbc.insets.bottom = 5;


        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);



        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);

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
        double sHValue = Double.parseDouble(txtAdditionalSH.getText());
        return sHValue;
    }
}
