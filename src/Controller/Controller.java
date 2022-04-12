/***************************************
* Filename: Controller.java
* Short description: This class ...
* @author Nannette D'Imperio
* @version  ??/??/2019
***************************************/

package Controller;

import Model.GenEdData;
import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

/**
 *
 * @author nxd13
 */
public class Controller {
    // attributes
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        //displayData();
        // code only for Courses DB
        int[] cdSelectedFields = new int[0];
        model.getCd().setSelectedFields(cdSelectedFields);

        // create Grid layout -- button and labels in GUI
        view.centerInitialSetup(model.getCd().getLinesBeingDisplayed(),
                model.getCd().getHeaders().size());
        // add the model data to the buttons in the view
        view.centerUpdate(model.getLines(), model.getCd().getHeaders());
        // set up listeners
        addListeners();
        addScrolling();
        addSorting();
    }

    private void addSorting() {
        // selection
        view.getiPanel().getwPanel().getSelection().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        model.getCd().sort(1, model.getCd().getSortField());
                        view.getiPanel().getwPanel().getSelection().setBackground(Color.ORANGE);
                        view.getiPanel().getwPanel().getMerge().setBackground(Color.GRAY);
                        view.getiPanel().getwPanel().getQuick().setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
        // Merge
        view.getiPanel().getwPanel().getMerge().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        model.getCd().sort(2, model.getCd().getSortField());
                        view.getiPanel().getwPanel().getMerge().setBackground(Color.ORANGE);
                        view.getiPanel().getwPanel().getSelection().setBackground(Color.LIGHT_GRAY);
                        view.getiPanel().getwPanel().getQuick().setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
        // Quick sort
        view.getiPanel().getwPanel().getQuick().addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        model.getCd().sort(3, model.getCd().getSortField());
                        view.getiPanel().getwPanel().getQuick().setBackground(Color.ORANGE);
                        view.getiPanel().getwPanel().getMerge().setBackground(Color.GRAY);
                        view.getiPanel().getwPanel().getSelection().setBackground(Color.LIGHT_GRAY);
                    }
                }
        );
    }

    private void addScrolling() {
        view.getcPanel().addMouseWheelListener(
            new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent mwe) {
                    int units = mwe.getUnitsToScroll();
                    System.out.println("units: " + units);
                    // code to make table scroll
                    // modify variables in CourseData - displayable
                    int first = model.getCd().getFirstLineToDisplay() + units;
                    System.out.println("first 1: " + first);
                    if (first < 0) first = 0;
                    if (first > model.getCd().getTable().size() -
                            model.getCd().getLinesBeingDisplayed()) {
                        first -= units;
                    }
                    System.out.println("first 2: " + first);
                    model.getCd().setFirstLineToDisplay(first);
                    int last = first + model.getCd().getLinesBeingDisplayed();
                    System.out.println("last: " + last);
                    model.getCd().setLastLineToDisplay(last);
                    // need to retrieve the updated data and call view.centerUpdate
                    view.centerUpdate(model.getLines(), model.getCd().getHeaders());
                }
            }
        );
    }

    private void addListeners() {
        final ArrayList<JButton> heads = view.getcPanel().getHeaders();
        for (int i = 0; i < heads.size(); i++) {
            JButton btn = heads.get(i);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JButton obj = (JButton) actionEvent.getSource();
                    // loop to reset buttons
                    for (int b = 0; b < heads.size(); b++) {
                        heads.get(b).setBackground(Color.GRAY);
                        if (heads.get(b) == obj) {
                            model.getCd().setSortField(b);
                            System.out.println("sort b: " + model.getCd().getSortField());
                        }
                    }
                    obj.setBackground(Color.BLUE);
                    // sort data
                    model.getCd().sort(model.getCd().getSortType(), model.getCd().getSortField());
                    System.out.println("sort out: " + model.getCd().getSortField() );
                    // update view with newly sorted data.
                    view.centerUpdate(model.getLines(), // lines will be updated)
                            model.getCd().getHeaders());
                }
            });
        }
    }
    public void displayData() {
        int[] cdSelectedFields = new int[0];
        model.getCd().setSelectedFields(cdSelectedFields);
        view.displayCourseInfo("Course Headers=", model.getCd().getHeaders().toString());
        view.displayCourseInfo("Course line 5=", model.getCd().getLine(5).toString());
        view.displayCourseInfo("Course range 3-5=", model.getCd().getLines(3, 5).toString());
        System.out.println("==============================================================="); 
        
        cdSelectedFields = new int[3];
        cdSelectedFields[0] = 0;
        cdSelectedFields[1] = 2;
        cdSelectedFields[2] = 3;
        model.getCd().setSelectedFields(cdSelectedFields);
        view.displayCourseInfo("Course Headers=", model.getCd().getHeaders().toString());
        view.displayCourseInfo("Course line 5=", model.getCd().getLine(5).toString());
        view.displayCourseInfo("Course range 3-5=", model.getCd().getLines(3, 5).toString());
        System.out.println("===============================================================");
        
        int[] gdSelectedFields = new int[0];
        model.getGd().setSelectedFields(gdSelectedFields);
        view.displayCourseInfo("Gen Ed Headers=", model.getGd().getHeaders().toString());
        view.displayCourseInfo("Gen Ed line 3=", model.getGd().getLine(3).toString());
        view.displayCourseInfo("Gen Ed range 0-3=", model.getGd().getLines(0, 3).toString());
        System.out.println("===============================================================");
     
    }
    
      
    
    
}
