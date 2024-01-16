import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel searchUI;

    public abstract void addUIControls();

    public abstract double getOrderAmountValue();

    public abstract double getTaxValue();

    public abstract double getSHValue();

    public JPanel getSearchUI() {
        return searchUI;
    }
}

