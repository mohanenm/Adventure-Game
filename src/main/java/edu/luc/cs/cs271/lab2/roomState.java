package edu.luc.cs.cs271.lab2;

import java.util.*;

public class roomState {
  // LinkedStack<String> stack = new LinkedStack<String>()
  String[] objectsInScene;
  playerInput changeCondition;
  String endOfStateDescription;
  String description;
  Map<playerInput, String> validInputs;

  public String getDescription() {
    return null;
  }

  roomState(String[] objInScene, Map<playerInput, String> vInputs, playerInput pIn) {
    objectsInScene = objInScene;
    validInputs = vInputs;
    changeCondition = pIn;
  }

  public String[] getObjects() {
    return objectsInScene;
  }

  public void removeObject(String obj) {
    for (int i = 0; i < objectsInScene.length; i++) {
      if (objectsInScene[i] == obj) {
        objectsInScene[i] = null;
        return;
      }
    }
  }

  // Returns true if input was trigger for roomState change, false if not
  public boolean getRoomResponse(playerInput input) {
    for (playerInput vInput : validInputs.keySet()) {
      if (vInput == input) {
        System.out.println(validInputs.get(vInput));
        if (vInput == changeCondition) {
          return true;
        }
        return false;
      }
    }
  }
}
