package barrenlandanalysis;

import java.util.Arrays;

public class FloodFillLand {	
	private static int landLength = 600;
	private static int landWidth = 400;
	private static int [][] land = new int[400][600]; //All plots are marked as 0 by default. 0 will be unsorted fertile land.
	
	public FloodFillLand(){ 
		 FloodFillLand.land = new int[400][600];  
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
	private static void FloodFillAlgorithm(int[][] land, int x, int y, int prevPlot, int newPlot) {
		if (x < 0 || x >= landWidth || y < 0 || y >= landLength) { return; }
        if (land[x][y] != prevPlot) { return; }

        land[x][y] = newPlot; //Sets plot to the new group number. 
        
        //Repeats for E, W ,N ,S directions
        FloodFillAlgorithm(land, x + 1, y, prevPlot, newPlot);
        FloodFillAlgorithm(land, x - 1, y, prevPlot, newPlot);
        FloodFillAlgorithm(land, x, y + 1, prevPlot, newPlot);
        FloodFillAlgorithm(land, x, y - 1, prevPlot, newPlot);		
	}

	//Uses the flood fill algorithm to mark adjacent plots of land with the same group number starting at 2. 
	//0 is unsorted plots of fertile land, 1 is barren land.	
	int[] FertileLand() {
		int newPlot = 2;
        for (int x = 0; x < landWidth; x++) {
            for (int y = 0; y < landLength; y++) {
                if (land[x][y] == 0) { //If a fertile plot marked as 0 is found then..
                	FloodFillAlgorithm(land, x, y, land[x][y], newPlot); //The flood fill algorithm will mark all adjacent plots with the same group number
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
		for (int c = 0; c < coordinates.length; c++) {
            String[] coords = coordinates[c].split(" ");
			for (int x = Integer.parseInt(coords[0]); x <= Integer.parseInt(coords[2]); x++) {
				for (int y = Integer.parseInt(coords[1]); y <= Integer.parseInt(coords[3]); y++) {
					land[x][y] = 1;
				}
			}
        }		
	}
}
