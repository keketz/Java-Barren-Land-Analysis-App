package barrenlandanalysis;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ForestFireFillLand {	
	private static int landLength = 600;
	private static int landWidth = 400;
	private static int [][] land = new int[400][600]; //All plots are marked as 0 by default. 0 will be unsorted fertile land.
	
	public ForestFireFillLand(){ 
            ForestFireFillLand.land = new int[400][600];  
	} 
	
	
	private static int[] CountIndividualPlots(int[][] land, int numbOfPlots) {
            //Counts each separate plot area in land. 
            int plots[] = new int[numbOfPlots];
            for (int x = 0; x < landWidth; x++) {
                for (int y = 0; y < landLength; y++) {
                    plots[land[x][y]] += 1;
                }
            }
        
            int[] fertilePlots = new int[numbOfPlots-2];
            for (int i = 2; i < plots.length; i++) {
                    fertilePlots[i-2] = plots[i];
            }

            return fertilePlots;
	}

	//Finds all adjacent plots from the original point and marks them all with the same group number.
	private int[][] ForestFireAlgorithm(int[][] land, int x, int y, int targetPlot, int newPlot) {
            if(targetPlot == newPlot) {return land;} 					//1. If target-color is equal to replacement-color, return
            if(land[x][y] != targetPlot) {return land;} 				//2. If color of node is not equal to target-color, return.

            Queue<Node> queue = new ArrayDeque<Node>();										//3. Set Q to the empty queue.
            land[x][y] = newPlot;   	                    //4. Set the color of node to replacement-color.
            Node n;
            queue.add(new Node(x, y ));                    //5. Add node to the end of Q. ???

            while (!queue.isEmpty()) {  	                //6. While Q is not empty:
                n = queue.remove();                         //8.     Remove first element from Q.
                if (n.x > 0) {
                    if (land[n.x - 1][n.y] == targetPlot) {//9.     If the color of the node to the west of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
                        land[n.x - 1][n.y] = newPlot;
                        queue.add(new Node(n.x - 1, n.y )); //add coordinates to end of queue ???
                    }
                }
                if (n.x < landWidth - 1) {
                    if (land[n.x + 1][n.y] == targetPlot) {//10.     If the color of the node to the east of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
                        land[n.x + 1][n.y] = newPlot;
                        queue.add(new Node(n.x + 1, n.y )); //add coordinates to end of queue ???
                    }
                }
                if (n.y < landLength - 1) {
                    if (land[n.x][n.y + 1] == targetPlot) {//11.     If the color of the node to the north of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
                        land[n.x][n.y + 1] = newPlot;
                        queue.add(new Node( n.x, n.y + 1 )); //add coordinates to end of queue ???
                    }
                }
                if (n.y> 0) {
                    if (land[n.x][n.y - 1] == targetPlot) {//12.     If the color of the node to the south of n is target - color, set the color of that node to replacement - color and add that node to the end of Q.
                        land[n.x][n.y - 1] = newPlot;
                        queue.add(new Node( n.x, n.y - 1 )); //add coordinates to end of queue ???
                    }
                }
            }
            return land;
	}

	//Uses the flood fill algorithm to mark adjacent plots of land with the same group number starting at 2. 
	//0 is unsorted plots of fertile land, 1 is barren land.	
	int[] FertileLand() {
            int newPlot = 2;
            for (int x = 0; x < landWidth; x++) {
                for (int y = 0; y < landLength; y++) {
                    if (land[x][y] == 0) { //If a fertile plot marked as 0 is found then..
                        ForestFireAlgorithm(land, x, y, land[x][y], newPlot); //The flood fill algorithm will mark all adjacent plots with the same group number
                        newPlot++; //increments to the next group number. If another plot marked as 0 is found, the new group will be assigned with the new incremented group number.
                    }
                }
            }

            int[] plots = CountIndividualPlots(land, newPlot); 
            Arrays.sort(plots); //Sort smallest to largest land

            return plots;	
        }

	//Assigns Barren land to 1. 
	void MarkBarrenLand(String[] coordinates) {		
            for (String coordinate : coordinates) {
                String[] coords = coordinate.split(" ");
                for (int x = Integer.parseInt(coords[0]); x <= Integer.parseInt(coords[2]); x++) {
                    for (int y = Integer.parseInt(coords[1]); y <= Integer.parseInt(coords[3]); y++) {
                        land[x][y] = 1;
                    }
                }
            }		
	}

    void ResetPlots() {
        for(int x = 0; x < 400; x++) {
            for(int y = 0; y < 600; y++) {
                if(land[x][y] != 1){land[x][y] = 0;}
            }
        }
        	
    }
	
	private class Node{
		public final int x;
		public final int y;
		
		public Node(int setX, int setY) {
			x = setX;
			y=setY;
		}
	}
	
}
