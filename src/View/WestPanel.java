package View;

import javax.swing.*;
import java.awt.*;

/**
 * File name: WestPanel.java
 * Short description: Class to .....
 * IST 242 Assignment: Module #
 *
 * @author Nannette D'Imperio
 * @version 1.01 4/7/2022
 */

public class WestPanel extends JPanel {
    // Instance Variables -- define your private data
    private JRadioButton selection;
    private JRadioButton merge;
    private JRadioButton quick;

    // Constructors
    public WestPanel() {
        // set layout
        setLayout(new GridLayout(4, 1));
        // create objects
        JLabel label = new JLabel("Choose SORT Type", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLUE);
        label.setOpaque(true);
        add(label);
        // buttons
        selection = new JRadioButton("Selection Sort");
        selection.setBackground(Color.LIGHT_GRAY);
        merge = new JRadioButton("Merge Sort");
        merge.setBackground(Color.GRAY);
        merge.setForeground(Color.WHITE);
        quick = new JRadioButton("Quick Sort");
        quick.setBackground(Color.LIGHT_GRAY);
        ButtonGroup grp = new ButtonGroup();
        grp.add(selection);
        grp.add(merge);
        grp.add(quick);
        // add buttons to panel
        add(selection);
        add(merge);
        add(quick);
    }

     // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public JRadioButton getSelection() {
        return selection;
    }

    public JRadioButton getMerge() {
        return merge;
    }

    public JRadioButton getQuick() {
        return quick;
    }
}