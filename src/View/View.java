/***************************************
* Filename: View.java
* Short description: This class ...
* @author Nannette D'Imperio
* @version  ??/??/2019
***************************************/

package View;

import Model.Course;
import Model.GenEd;

import java.util.ArrayList;

/**
 *
 * @author nxd13
 */
public class View {
    // GUI attributes
    private InitialFrame iFrame;
    private InitialPanel iPanel;
    private CenterPanel cPanel;

    public View() {
        iFrame = new InitialFrame();
        iPanel = iFrame.getiPanel();
        cPanel = iFrame.getcPanel();
    }

    // Methods needed for L04C onward
    // Calls method to create panel grid
    public void centerInitialSetup(int lines, int headers) {
        // call method on cPanel
        cPanel.setupCenterPanel(lines, headers);
    }

    public void centerUpdate(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        cPanel.panelUpdate(lines, headers);
    }
    
    // Methods to display data
    public void displayGenEdInfo(GenEd ge) {
    }
    
    public void displayCourseInfo(String text, String data) {
        System.out.println(text + data);
    }

    public InitialFrame getiFrame() {
        return iFrame;
    }

    public InitialPanel getiPanel() {
        return iPanel;
    }

    public CenterPanel getcPanel() {
        return cPanel;
    }
}
