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

