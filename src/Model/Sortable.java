/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nxd13
 */
public interface Sortable {
    public void sort(int sortType, int sortField);
    public int getSortType();
    public void setSortType(int sortType);
    public int getSortField();
    public void setSortField(int sortField);
}
