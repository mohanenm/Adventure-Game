package edu.luc.cs.cs271.lab2;

import java.util.*;

// The character class handels user input, and any data related to the player. Its main purpose is
// to turn
// the text the user inputs into readable commands for methods to use via the 'parse Text' method.
public class character {

  room[][] roomGrid;
  int xGridPosition = 0;
  int yGridPosition = 0;
  String[] validVerbs = new String[15];
  LinkedList<String> inventory = new LinkedList<String>();
  String[] temp;
  roomState currentRoomState;
  room currentRoom;
  playerInput currentPlayerInput;
  Scanner pInput = new Scanner(System.in);

  public character(String[] verbs, LinkedList<String> inv, room curRoom, room[][] grid) {
    validVerbs = verbs;
    inventory =
        inv; // incompitable; do you want the string list to be turned into a string? or what?
    currentRoom = curRoom;
    currentRoomState = currentRoom.getStateStack().peek();
    roomGrid = grid;
  }

  void go(int vert, int horz) {}

  String getSurroundingRoomDesc() {
    // Gets the short descriptions/names of the rooms surrounding the current room
    return null;
  }

  // Returns the last playerInput 'parseText()' was able to create
  public playerInput getLastInput() {
    return currentPlayerInput;
  }

  // Takes in a string from the user, and searches for certain keywords. It then turns those
  // keywords into a command readable by other classes.
  // So "Use Crowbar on Door" turns into a playerInput object with "Use", "Crowbar", and "Door" as
  // it's verb and objects. That then may be read by
  // other classes to 'know' what the player is attempting to do.

  public void handlePlayerIO(String input) {
    temp = input.split("\\s+");
    currentPlayerInput = null;

    convertIOToPlayerInput(temp);

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
  }

  private void handleKeywords() {
    if (currentPlayerInput.getVerb() == "go") {
      if (currentPlayerInput.getObjectA() == "north") {
        go(1, 0);
      } else if (currentPlayerInput.getObjectA() == "east") {
        go(0, 1);
      } else if (currentPlayerInput.getObjectA() == "south") {
        go(-1, 0);
      } else if (currentPlayerInput.getObjectA() == "west") {
        go(0, -1);
      }
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

  private void convertIOToPlayerInput(String[] input) {
    for (String word : input) {
      // Is this specific word a verb we have? If not, keep going
      if (currentPlayerInput == null) {
        for (String verb : validVerbs) {
          if (word == verb) {
            currentPlayerInput = new playerInput(word);
            break;
          }
        }
      } else if (currentPlayerInput.getObjectA() == null) {
        // Is this specific word in the players inventory? If not, keeping going.
        for (String object : inventory) {
          if (word == object) {
            currentPlayerInput.setObjectA(word);
            break;
          }
        }
        // Is this specific word in the roomStates objects? If not, keep going.
        for (String object : currentRoomState.objectsInScene) {
          if (word == object) {
            currentPlayerInput.setObjectA(word);
            break;
          }
        }
      }

      if ((word == "north") || (word == "south") || (word == "east") || (word == "west")) {
        // == has higher priority, error fixed
        currentPlayerInput.setObjectA(word);
      } else if (currentPlayerInput.getObjectB() == null) {
        // Is this specific word in the players inventory? If not, keeping going.
        for (String object : inventory) {
          if (word == object) {
            currentPlayerInput.setObjectB(word);
            break;
          }
        }
        // Is this specific word in the roomStates objects? If not, keep going.
        for (String object : currentRoomState.getObjects()) {
          if (word == object) {
            currentPlayerInput.setObjectB(word);
            break;
          }
        }
      }
    }
  }
}
