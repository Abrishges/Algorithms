package com.Maze.com;

public class StepStack {
    private Step[] stack;
    private int size;
    static final int MAX = 1000;

    public StepStack() {
        //TODO: Implement constructor
    	 this.size = 0;
    	 this.stack = new Step[MAX];
    }

    public void push(Step step) {
        //TODO: Implement push()	
    	if (size == MAX) {
    		System.out.println("StackOverflow");
    	} else {
    		stack[++size] = step;
    	}
    }

    public Step peek() throws EmptyStackException {
    	
    	if (size == 0) {
    		throw new EmptyStackException();
    	} else {
    		Step step = stack[size];
    		return step;
    	}
    	
    }

    public Step pop() throws EmptyStackException {
    	
    	if (size == 0) {
    		throw new EmptyStackException();
    	} else {
    		Step step = stack[size--];
    		return step;
    	}
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String path = "";
        for (int i = 0; i < size; i++) {
            if (stack[i] != null) {
                {
                    path += stack[i];
                }
            }
        }
        return path;
    }
}
