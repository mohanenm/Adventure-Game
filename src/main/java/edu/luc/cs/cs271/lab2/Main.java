package edu.luc.cs.cs271.lab2;

import java.util.*;

public class Main {
  public static void main(String[] args) {

    // supposed to be for the help command, user presses help and gets the commands, not down with
    // help commands

    System.out.print("Would you like to play an adventure game?(Y/N): ");
    Scanner scan = new Scanner(System.in);
    String playerInput;
    char answer = scan.next().charAt(0);
    character playerCharacter = setup();
    String[] commands =
        new String[] {
          "Welcome",
          "This is how the game works. You can use these commands:",
          "WEST to travel into the west-most room",
          "EAST to travel into the east-most room",
          "NORTH to travel into the north-most room",
          "SOUTH to travel into the west-most room",
          "USE to utilize a certain object,",
          "PICK to pick up an object,",
          "LOOK to receive a description of the room in which you are located",
          "GRAB to grab an item",
          "FIX to fix things like a broken generator",
          "HELP to revisit this list of commands",
          "Q to quit",
          "The use of any other verbs will not work and you will be prompted to re-enter your command",
        };

    if ((answer == 'y') || (answer == 'Y')) {
      for (int i = 0; i < 14; i++) {
        System.out.printf(commands[i] + "\n");
      }
    } else {
      System.out.printf("your loss");
      return;
    }
    while (true) {
      playerInput = scan.next();
      playerInput.toLowerCase();
      playerCharacter.handlePlayerIO(playerInput);
    }
  }

  // Hey Nick, this should be set up. Feel free to text me any questions
  @SuppressWarnings("all")
  public static character setup() {
    LinkedList<String> roomOneObj;
    LinkedList<String> roomTwoObj;

    room[][] roomGrid; //the rooms are represented by the multidimensional array
    LinkedList<String> invLs;

    Map<playerInput, String> inputMapThree;

    String[] verbArr = new String[] {"pick", "grab", "use", "look", "fix"};

    // as we never implimented a command to read out the player's inventory, we're not touching
    // this.
    invLs = new LinkedList<String>();

    // Objects in RoomState One
    roomOneObj = new LinkedList<String>();
    roomOneObj.add("Dresser with open drawer and light on top");
    roomOneObj.add("Light bulb");
    roomOneObj.add("lamp"); // A is whateer items we want to add to the room, noting that
    // you have to describe
    // what's in the room using the roomState's description
    // repeat as needed
    roomOneObj.add("light-bulb");

    // Objects in RoomState Two
    roomTwoObj = new LinkedList<String>();
    roomTwoObj.add(
        "chair"); // A is whatever items we want to add to the room, noting that you have to
    // describe
    // what's in the room using the roomState's description

    Map<playerInput, String> inputMapOne = new HashMap<playerInput, String>();
    Map<playerInput, String> inputMapTwo = new HashMap<playerInput, String>();
    inputMapOne.put(
        new playerInput("look"),
        "You see a dresser with an open drawer and a lamp on top infront of you, Inside, there is a light bulb"); // Use this to assign a certain response to a

    inputMapTwo.put(new playerInput("grab"), "Nice");

    // certain playerInput. REMEMBER! You only need
    // the verb in playerInput, the other two
    // strings are optional.
    // repeat as needed.

    Stack roomStackOne = new Stack();
    Stack roomStackTwo = new Stack();
    roomStackOne.push(
        new roomState(
            roomOneObj,
            inputMapOne,
            new playerInput(
                "grab",
                "look"))); // This player input is the trigger for changing to the next room state
    roomStackTwo.push(
        new roomState(
            roomTwoObj,
            inputMapTwo,
            new playerInput("This isn't a valid verb"))); // Don't change this.

    roomGrid = new room[1][1];
    roomGrid[0][0] =
        new room(
            "Bedroom with a dresser",
            "You enter the room and push the dresser drawer closed",
            roomStackOne); // Just fill in  a basic title in A and a basic description in B, they
    // don't
    // actually come up in this demo

    character fixture = new character(verbArr, invLs, roomGrid);

    return fixture;
  }
}
