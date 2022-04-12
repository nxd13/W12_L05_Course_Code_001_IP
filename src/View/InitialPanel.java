package View;

import javax.swing.*;
import java.awt.*;

/**
 * File name: InitialPanel.java
 * Short description:
 * IST 242 Assignment Module:
 *
 * @author Nannette D'Imperio
 * @version 1.01 3/22/2022
 */

public class InitialPanel extends JPanel {
    // Instance Variables -- define your private data
    private CenterPanel cPanel;
    private WestPanel wPanel;

    // Constructors
    public InitialPanel() {
        // initialize default values
        super();
        setLayout(new BorderLayout());
        cPanel = new CenterPanel();
        add(cPanel,"Center");
        wPanel = new WestPanel();
        add(wPanel, "West");
    }

     // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public CenterPanel getcPanel() {
        return cPanel;
    }

    public WestPanel getwPanel() {
        return wPanel;
    }
}