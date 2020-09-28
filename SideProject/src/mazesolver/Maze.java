/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver;

import java.util.LinkedList;

/**
 *
 * @author Dinamo
 */
public class Maze {
     public int[][] maze;
    public LinkedList<Position> path = new LinkedList<Position>(); //new linkedlist defined in Maze class to save position
    public Position start;
}
