package edu.luc.cs.cs271.lab2;

import java.util.*;

// The character class handels user input, and any data related to the player. Its main purpose is
// to turn
// the text the user inputs into readable commands for methods to use via the 'parse Text' method.
public class character {
  String[] validVerbs = new String[15];
  String[] inventory = new String[5];
  String[] temp;
  roomState currentRoomState;
  room currentRoom;
  playerInput currentInput;
  Scanner pInput = new Scanner(System.in);

  public character(String[] verbs, String[] inv, room curRoom) {
    validVerbs = verbs;
    inventory = inv;
    currentRoom = curRoom;
    currentRoomState = currentRoom.getStateStack().peek();
  }

  // Returns the last playerInput 'parseText()' was able to create
  public playerInput getLastInput() {
    return currentInput;
  }

  // Takes in a string from the user, and searches for certain keywords. It then turns those
  // keywords into a command readable by other classes.
  // So "Use Crowbar on Door" turns into a playerInput object with "Use", "Crowbar", and "Door" as
  // it's verb and objects. That then may be read by
  // other classes to 'know' what the player is attempting to do.
  public void parseText(String input) {
    /*Go word-by-word, looking for anything that matches either A. an established Verb or B. an Object currently available (in the scene or in the inventory)
     *When it detects the first verb it creates an input object
     *And when it detects the first two objects, it assings them as objectA and objectB respectively
     *Once it either has iteratred through the whole string or filled the object B slot, it sends this input on to the current roomstate using prepOutput()
     */
    temp = input.split("\\s+");
    currentInput = null;
    // check through every word in our input string
    for (String word : temp) {
      // Is this specific word a verb we have? If not, keep going
      if (currentInput == null) {
        for (String verb : validVerbs) {
          if (input == verb) {
            currentInput = new playerInput(input);
            break;
          }
        }
      } else if (currentInput.getObjectA() == null) {
        // Is this specific word in the players inventory? If not, keeping going.
        for (String object : inventory) {
          if (input == object) {
            currentInput = new playerInput(input);
            break;
          }
        }
        // Is this specific word in the roomStates objects? If not, keep going.
        for (String object : currentRoomState.objectsInScene) {
          if (input == object) {
            currentInput = new playerInput(input);
            break;
          }
        }
      } else if (currentInput.getObjectB() == null) {
        // Is this specific word in the players inventory? If not, keeping going.
        for (String object : inventory) {
          if (input == object) {
            currentInput = new playerInput(input);
            break;
          }
        }
        // Is this specific word in the roomStates objects? If not, keep going.
        for (String object : currentRoomState.getObjects()) {
          if (input == object) {
            currentInput = new playerInput(input);
            break;
          }
        }
      }
    }
    currentRoomState.prepOutput(currentInput);
  }
}
