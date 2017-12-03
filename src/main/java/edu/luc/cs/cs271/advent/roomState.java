package main.java.edu.luc.cs.cs271.advent;

import java.util.*;

public class roomState {
  //LinkedStack<String> stack = new LinkedStack<String>()
  String[] objectsInScene;
  Map<playerInput, String> validInputs;

  roomState(String[] objInScene, Map<playerInput, String> vInputs) {
    objectsInScene = objInScene;
    validInputs = vInputs;
  }

  public String[] getObjects() {
    return objectsInScene;
  }

  public void prepOutput(playerInput input) {
    for (playerInput vInput : validInputs.keySet()) {
      if (vInput == input) {
        System.out.println(validInputs.get(vInput));
      }
    }
  }
}
