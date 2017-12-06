package edu.luc.cs.cs271.lab2;

import java.util.*;

/*
room - gaming location
*/
public class room {
  // Member variables
  private String m_roomTitle;
  private String m_roomDescription;
  private Stack<roomState> stateStack;

  /*
  Blank constructor
  */
  public room() {
    /*
    Blank title + description
    */
    m_roomTitle = new String();
    m_roomDescription = new String();
  }
  /*
   *Partial constructor
   * Assign title
   *Blank description
   * removed all vectors, not using that implementation
   */
  public room(String title) {

    m_roomTitle = title;
    m_roomDescription = new String();
  }
  // Full constructor
  public room(String title, String description, Stack<roomState> sStack) {
    // Assign title + description
    m_roomTitle = title;
    m_roomDescription = description;
    stateStack = sStack;
  }

  public Stack<roomState> getStateStack() {
    return stateStack;
  }
  // toString method
  public String toString() {
    return m_roomTitle;
  }
  // Returns location title
  public String getTitle() {
    return m_roomTitle;
  }
  // Assigns location title
  public void setTitle(String roomTitle) {
    m_roomTitle = roomTitle;
  }
  // Returns location description
  public String getDescription() {
    return m_roomDescription;
  }
  // Assigns location description
  public void setDescription(String roomDescription) {
    m_roomDescription = roomDescription;
  }
}
/*
public class statesStack<Item> implements Iterable<Item> {
   private int n;          // size of the stack
   private Node first;     // top of stack

   // helper linked list class
   private class Node {
       private Item item;
       private Node next;
   }

  /**
    * Initializes an empty stack.

      @Override
   public Stack() {
       first = null;
       n = 0;
   }
   /*
    * Returns the number of items in this stack.
    */
     /*
        @Override
     public int size() {
         return n;
         system.out.println("You have"  +  return size + "objectives to complete");
     }

     /*
      * Adds the item to this stack.
      */
     /*
        @Override
     public void push(Item item) {
         Node oldfirst = first;
         first = new Node();
         first.item = item;
         first.next = oldfirst;
         n++;

     s.push("state");
     s.push("state");
     s.push("state");
     }

     /*
       Removes and returns the item most recently added to this stack.
      */
    /*    @Override
       public Item pop() {
           if (isEmpty()) throw new NoSuchElementException("You have completed all objectives");
           Item item = first.item;        // save item to return
           first = first.next;            // delete first node
           n--;
           return item;                   // return the saved item
       }
       /*
         Returns an iterator to this stack that iterates through the items in LIFO order.


         @Override
       public Iterator<Item> iterator()  { return new ListIterator();  }

       //iterator
         @Override
       private class ListIterator implements Iterator<Item> {
           private Node current = first;
           public boolean hasNext()  { return current != null;                     }
           public void remove()      { throw new UnsupportedOperationException();  }

           public Item next() {
               if (!hasNext()) throw new NoSuchElementException();
               Item item = current.item;
               current = current.next;
               return item;
           }
       }

    */
