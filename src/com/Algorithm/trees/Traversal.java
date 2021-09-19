package com.Algorithm.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by aberehamwodajie on 4/7/17.
 */
public class Traversal {

    public static void main(String args[]){
        //inserting node in level order 12, 10, 18, 28, 34, 67, 45
        Node<Integer> root = new Node<Integer>(12);
        root.left = new Node(10);
        root.right = new Node (18);
        root.left.right = new Node(34);
        root.left.left = new Node (28);
        root.right.left  = new Node(67);
        root.right.right = new Node(45);

        Traversal traversal = new Traversal();
        System.out.println("Level order traversal: ");
        traversal.levelOrder(root);
    }


    public void levelOrder(Node root) {
        Queue<Node>  queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
             Node temp = queue.poll();
             System.out.print(temp.value + ", ");
            if(temp.left != null){
                queue.add(temp.left);
            }

            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

}
