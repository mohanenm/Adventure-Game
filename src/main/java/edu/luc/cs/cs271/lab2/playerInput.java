// The player input class is a way of containing user inputted data in a way that's readable by
// other methods.
// It stores what verb the player is trying to use, as well as up to two objects they're using in
// conjunction with that action.

package edu.luc.cs.cs271.lab2;

public class playerInput {
  String verb;
  String objectA;
  String objectB;

  public playerInput(String predicate) {
    verb = predicate;
  }

  public playerInput(String predicate, String thingA) {
    verb = predicate;
    objectA = thingA;
  }

  public void setObjectA(String thingA) {
    objectA = thingA;
  }

  public String getObjectA() {
    return objectA;
  }

  public void setObjectB(String thingB) {
    objectB = thingB;
  }

  public String getObjectB() {
    return objectB;
  }

  public String getVerb() {
    return verb;
  }

  public boolean equals(playerInput other) {
    if (other.verb == verb) {
      if (other.objectA == objectA) {
        return other.objectB == objectB;
      }
    }
    return false;
  }
}
