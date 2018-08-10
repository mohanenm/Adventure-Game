package edu.luc.cs.cs271.lab2;

import java.util.*;

// The character class handels user input, and any data related to the player. Its main purpose is
// to turn
// the text the user inputs into readable commands for methods to use via the 'parse Text' method.
public class character {

  room[][] roomGrid;
  int xGridPosition = 0;
  int yGridPosition = 0;
  String[] validVerbs;
  LinkedList<String> inventory;
  String[] cardinalDirections;
  String[] inputArr;
  roomState currentRoomState;
  room currentRoom;
  playerInput currentPlayerInput;

  public character(
      String[] verbs, LinkedList<String> inv, room[][] grid) { // multidimensional array :)
    validVerbs = verbs;
    inventory =
        inv; // incompitable; do you want the string list to be turned into a string? or what?
    currentRoom = grid[0][0];
    currentRoomState = currentRoom.getStateStack().peek();
    roomGrid = grid;
    cardinalDirections = new String[] {"north", "south", "east", "west"};
  }

  void go(int horz, int vert) {
    yGridPosition += vert;
    xGridPosition += horz;
    currentRoom = roomGrid[xGridPosition][yGridPosition];
    currentRoomState = currentRoom.getStateStack().peek();
    System.out.println(currentRoomState.getDescription());
  }

  public LinkedList<String> getInv() {
    return inventory;
  }

  String getSurroundingRoomDesc() {
    // Gets the short descriptions/names of the rooms surrounding the current room

    return "";
  }

  // Returns the last playerInput 'parseText()' was able to create
  public playerInput getLastInput() {
    return currentPlayerInput;
  }

  public String[] getInputArray() {
    return inputArr;
  }

  // Takes in a string from the user, and searches for certain keywords. It then turns those
  // keywords into a command readable by other classes.
  // So "Use Crowbar on Door" turns into a playerInput object with "Use", "Crowbar", and "Door" as
  // it's verb and objects. That then may be read by
  // other classes to 'know' what the player is attempting to do.

  public void handlePlayerIO(String input) {
    inputArr = input.split(" ");
    currentPlayerInput = null;

    currentPlayerInput = convertIOToPlayerInput(inputArr);
    if (currentPlayerInput != null) {
      if ((currentPlayerInput.getVerb() == "go")
          || (currentPlayerInput.getVerb() == "pick")
          || (currentPlayerInput.getVerb() == "look")) {
        handleKeywords();
      }

      if (currentPlayerInput.getVerb() != "go") {
        if (currentRoomState.getRoomResponse(currentPlayerInput)) {
          currentRoom.getStateStack().pop();
          currentRoomState = currentRoom.getStateStack().peek();
          System.out.println(currentRoomState.getDescription());
        }
      }
    } else {
      System.out.println("I didn't understand that");
    }
  }

  private void handleKeywords() {
    if (currentPlayerInput.getVerb() == "go") {
      go(0, 1);

      /*
      if (currentPlayerInput.getObjectA() == "north") {
        go(0, 1);
      } else if (currentPlayerInput.getObjectA() == "east") {
        go(1, 0);
      } else if (currentPlayerInput.getObjectA() == "south") {
        go(0, -1);
      } else if (currentPlayerInput.getObjectA() == "west") {
        go(-1, 0);
      }
      */
    } else if (currentPlayerInput.getVerb() == "pick") {
      for (String str : currentRoomState.getObjects()) {
        if (currentPlayerInput.getObjectA() == str) {
          inventory.add(currentPlayerInput.getObjectA());
          currentRoomState.removeObject(currentPlayerInput.getObjectA());
          System.out.println("You pick up" + currentPlayerInput.getObjectA());
        }
      }
    } else if (currentPlayerInput.getVerb() == "look") {
      System.out.println(currentRoomState.getDescription() + " " + getSurroundingRoomDesc());
    }
  }

  /*Go word-by-word, looking for anything that matches either A. an established Verb or B. an Object currently available (in the scene or in the inventory)
   *When it detects the first verb it creates an input object
   *And when it detects the first two objects, it assings them as objectA and objectB respectively
   *Once it either has iteratred through the whole string or filled the object B slot, it sends this input on to the current roomstate using prepOutput().
   *In certain cases that change the gamestate outside of the current room state, such as moving between rooms or performing an action that
   */

  private playerInput convertIOToPlayerInput(String[] args) {
    String[] inputStaging = new String[3];
    for (int i = 0; i < args.length; i++) {
      if (Arrays.asList(validVerbs).contains(args[i])) {
        inputStaging[0] = args[i];
        continue;
      }
      if (Arrays.asList(cardinalDirections).contains(args[i])) {
        inputStaging[1] = args[i];
        break;
      }
      if (inputStaging[0] != null
          && (currentRoomState.getObjects().contains(args[i]) || inventory.contains(args[i]))) {
        if (inputStaging[1] == null) {
          inputStaging[1] = args[i];
          continue;
        } else {
          inputStaging[2] = args[i];
          break;
        }
      }
    }

    if (inputStaging[0] != null) {
      if (inputStaging[1] != null) {
        if (inputStaging[2] != null) {
          return new playerInput(inputStaging[0], inputStaging[1], inputStaging[2]);
        }
        return new playerInput(inputStaging[0], inputStaging[1]);
      }
      return new playerInput(inputStaging[0]);
    }
    return null;
  }

  public room getCurrentRoom() {
    return currentRoom;
  }
}
