package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * File name: CenterPanel.java
 * Short description:
 * IST 242 Assignment Module:
 *
 * @author Nannette D'Imperio
 * @version 1.01 3/22/2022
 */

public class CenterPanel extends JPanel {
    // Instance Variables -- define your private data
    private ArrayList<JButton> headers = new ArrayList<JButton>();
    private ArrayList<JButton> rowData = new ArrayList<JButton>();

    // Constructors
    public CenterPanel() {
        super();
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    // Draw the actual grid in the panel --- create labels, create buttons
    public void setupCenterPanel(int rows, int cols) {
        setLayout(new GridLayout(rows + 1, cols));
        // create header labels and add them to panel
        for (int c = 0; c < cols; c++) {
            JButton label = new JButton("L");
            //label.setHorizontalAlignment(JLabel.CENTER);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.WHITE);
            //label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            headers.add(label); // add to list
            add(headers.get(c)); // add to panel
        }
        // create row data buttons and add to list, panel
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JButton btn = new JButton("B");
                btn.setBackground(Color.pink);
                rowData.add(btn); // to list
                add(btn);  // add(rowData.get(c));
            }
        }
        validate();
        repaint();
    }

    public void panelUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> head) {
        // update the header row
        for (int h = 0; h < head.size(); h++) {
            headers.get(h).setText(head.get(h));
        }
        // update the rowdata --- a single list of buttons
        int b = 0;
        for (int r = 0; r < lines.size(); r++) {
            ArrayList<String> data = lines.get(r);
            for (int d = 0; d < data.size(); d++) {
                rowData.get(b).setText(data.get(d));
                b++;
                //System.out.println(b);
            }
        }
        validate();
        repaint();
    }

    public ArrayList<JButton> getHeaders() {
        return headers;
    }

    public ArrayList<JButton> getRowData() {
        return rowData;
    }

}