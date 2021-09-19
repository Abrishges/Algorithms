package com.Maze.com;

public class StepQueue {

    private int size;
    private Node head;
    private Node tail;

    public StepQueue() {
        //TODO: Implement constructor()
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void enqueue(Step step) {
        //TODO: Implement enqueue()
    }

    public Step dequeue() throws EmptyQueueException {
        //TODO: Implement dequeue()
    }


    /**
     * If the linked list is: Up->Down->Left->Right,
     * toString should return "UDLR"
     */
    @Override
    public String toString() {
        //TODO: Implement toString
    }

    private static class Node {
        Step step;
        Node next;
    }
}