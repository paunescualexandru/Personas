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
public class MazeSolver {

    static int[][] maze = {
        {2, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 1, 1}
    };

    // 0 = wall
    // 1 = path
    // 2 = destination
    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main (String[] args) {
        Position p = new Position(0, 3);
        path.push(p);
        
        while(true){
        int y = path.peek().y;
        int x = path.peek().x;
        maze[y][x] = 0;
           //down
        if (maze[y + 1][x] == 2) {
            System.out.println("You won!");
            return;
        } else if (maze[y + 1][x] == 1) {
            System.out.println("Move Down");
         path.push(new Position(y+1, x));
            }
        //left
        if (maze[y ][x -1] == 2) {
            System.out.println("You won!");
            return;
        } else if (maze[y][x-1] == 1) {
            System.out.println("Move Left");
         path.push(new Position(y, x-1));
            }
            // up
        if (maze[y - 1][x] == 2) {
            System.out.println("You won!");
            return;
        } else if (maze[y - 1][x] == 1) {
            System.out.println("Move Up");
         path.push(new Position(y-1, x));
            }
        //right
        if (maze[y ][x+1] == 2) {
            System.out.println("You won!");
            return;
        } else if (maze[y][x+1] == 1) {
            System.out.println("Move Right");
         path.push(new Position(y, x+1));
            }
        }
    }
}

    
