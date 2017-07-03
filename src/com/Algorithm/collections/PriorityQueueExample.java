package com.Algorithm.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author aberehamwodajie
 *
 *         The elements of the priority queue are ordered according to their natural
 *         ordering, or by a Comparator provided at queue construction time. The default
 *         PriorityQueue is implemented with Min-Heap, that is the top element is the minimum one in
 *         the heap. A priority queue relying on natural ordering also does not permit insertion of
 *         non-comparable objects (doing so may result in ClassCastException).
 *         Note that this implementation is not synchronized. Multiple threads should not access a
 *         PriorityQueue instance concurrently if any of the threads modifies the list structurally.
 *         Instead, use the thread-safe PriorityBlockingQueue class.
 *
 *         Implementation note: this implementation provides O(log(n)) time for the insertion
 *         methods (offer, poll, remove() and add) methods; linear time for the remove(Object) and
 *         contains(Object) methods; and constant time for the retrieval methods (peek, element, and
 *         size). Iterator is not granted to return in order
 *
 *         iterator doesn't give ordering assurance, we'll be getting unordered output.
 *         The ordering assurance only applies to offer, take, poll, peek:
 *
 *         Jun 15, 2017
 */
public class PriorityQueueExample {

  public static void main(final String args[]) {
    // queue
    final Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList("Hello", "Joe", "ZA", "Addis Ababa", "Rechmend", "Iowa", "Virigina", "Ethiopia"));
    System.out.println("Queue: It keeps insertion order");
    System.out.println(queue);

    System.out.println("\n default priority queue (min heap): ");
    final Queue<String> minHeap = new PriorityQueue<>();
    minHeap.addAll(Arrays.asList("Hello", "Joe", "ZA", "Addis Ababa", "Rechmend", "Iowa", "Virigina", "Ethiopia"));
    System.out.println("Iterator doesn't give ordering assurance: " + "\n" + minHeap);
    System.out.println("minHeap size: " + minHeap.size());
    for (int i = 0; i <= 7; i++) {
      final String head = minHeap.poll();
      System.out.print(head + " ,");
    }


    System.out.println("\n Priority queue with Comparator");
    final Queue<String> maxHeap = new PriorityQueue<>((s1, s2) -> -s1.compareTo(s2));
    maxHeap.addAll(Arrays.asList("Hello", "Joe", "ZA", "Addis Ababa", "Rechmend", "Iowa", "Virigina", "Ethiopia"));

    for (int i = 0; i <= 7; i++) {
      final String head = maxHeap.poll();
      System.out.print(head + " ,");
    }

    System.out.println("\n Priority Queue with customer object");
    final Queue<Customer> pq = new PriorityQueue<>((c1, c2) -> -c1.getAge().compareTo(c2.getAge()));

    final List<Customer> customers = Arrays.asList(
        new Customer("James", "James", 100, "United states"),
        new Customer("Beck", "James", 56, "United states"),
        new Customer("Abrham", "Lincon", 10, "United states"),
        new Customer("Jone", "doa", 98, "United states"),
        new Customer("John", "Alexinder", 66, "United states"));
    pq.addAll(customers);

    for (int i = 0; i <= 7; i++) {
      final Customer customer = pq.poll();
      if (customer == null) {
        break;
      }
      System.out.println(customer.getAge() + ", " + customer.getFirstName());
    }

  }
}
/*
 * //Comparator anonymous class implementation
 * public static Comparator<Customer> idComparator = new Comparator<Customer>(){
 * 
 * @Override
 * public int compare(Customer c1, Customer c2) {
 * return (int) (c1.getId() - c2.getId());
 * }
 * }
 */
