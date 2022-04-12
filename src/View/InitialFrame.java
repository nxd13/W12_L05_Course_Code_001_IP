package View;

import javax.swing.*;

/**
 * File name: InitialFrame.java
 * Short description:
 * IST 242 Assignment Module:
 *
 * @author Nannette D'Imperio
 * @version 1.01 3/22/2022
 */

public class InitialFrame extends JFrame {
    // Instance Variables -- define your private data
    private InitialPanel iPanel;
    private CenterPanel cPanel;

    // Constructors
    public InitialFrame() {
        // initialize default values
        super("W10 L04C Graphics - D'Imperio");
        // setupLayout for Macs
        iPanel = new InitialPanel();
        cPanel = iPanel.getcPanel();
        add(iPanel, "Center");
        //-------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setVisible(true);
    }

    public InitialFrame(int data) { // pass in data to initialize variables

    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable


    public InitialPanel getiPanel() {
        return iPanel;
    }

    public CenterPanel getcPanel() {
        return cPanel;
    }
}