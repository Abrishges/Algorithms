package com.Maze.com;

public class MazeSolver {
    public static StepStack findPath(Maze maze){
        //TODO: Implement MazeSolver()
    	
    	StepQueue[][] mazeArray = maze.mazeArray;
    	int row = maze.rows;
    	int col = maze.cols;
    	
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col ; j++) {
    			
    			StepQueue queue = mazeArray[i][j];
    			
    			    			
    		}
    	}
    
    	
    	return new StepStack();
    }
    
    private static boolean walk(StepQueue queue, String type) {
    	
    	     while(!queue.isEmpty()) {
    	    	  Step step = queue.dequeue();
    	    	  
    	    	 if (step.U) {
    	    		 
    	    	 }
    	     }
    	
    	return false;
    }
}