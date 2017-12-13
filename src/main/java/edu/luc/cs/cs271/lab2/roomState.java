package edu.luc.cs.cs271.lab2;

import java.util.*;

public class roomState {
  // LinkedStack<String> stack = new LinkedStack<String>()
  LinkedList<String> objectsInScene;
  playerInput changeCondition;
  String endOfStateDescription;
  String description;
  Map<playerInput, String> validInputs;

  public String getDescription() {
    return null;
  }

  roomState(LinkedList<String> objInScene, Map<playerInput, String> vInputs, playerInput pIn) {
    objectsInScene = objInScene;
    validInputs = vInputs;
    changeCondition = pIn;
  }

  public LinkedList<String> getObjects() {
    return objectsInScene;
  }

  public void removeObject(String obj) {
    if (objectsInScene.contains(obj)) {
      objectsInScene.remove(obj);
    }
  }

  // Returns true if input was trigger for roomState change, false if not
  public boolean getRoomResponse(playerInput input) {
    for (playerInput vInput : validInputs.keySet()) {
      if (vInput.getVerb() == input.getVerb() || vInput.getObjectA() == input.getObjectA() || vInput.getObjectB() == input.getObjectB()) {
        System.out.println(validInputs.get(vInput));
        if (vInput == changeCondition) {
          return true;
        }
      }
    }
    System.out.println("I didn't understand that");
    return false;
  }
}
