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
          "LOOK to receive a description of the room in which you are located,",
          "HELP to revisit this list of commands",
          "Q to quit",
          "The use of any other verbs will not work and you will be prompted to re-enter your command",
        };

    if ((answer == 'y') || (answer == 'Y')) {
      for (int i = 0; i < 9; i++) {
        System.out.printf(commands[i] + "\n");
      }
    } else{
      System.out.printf("your loss");
      return;
    }
     while (true){
      playerInput = scan.next();
      playerInput.toLowerCase();
      playerCharacter.handlePlayerIO(playerInput);
    } 
  }

  // TEST CODE, PLEASE IGNORE
  public static character setup() {
    LinkedList<String> objArr;
    String[] verbArr;
    room[][] roomGrid;
    LinkedList<String> invLs;
    playerInput testInput;
    Map<playerInput, String> inputMap;

    verbArr = new String[7];
    verbArr[0] = "look";
    verbArr[1] = "use";
    verbArr[2] = "pick";
    verbArr[3] = "east";
    verbArr[4] = "west";
    verbArr[5] = "north";
    verbArr[6] = "south";

    objArr = new LinkedList<String>();
    objArr.add("lever");
    objArr.add("box");

    invLs = new LinkedList<String>();
    invLs.add("matches");
    invLs.add("flashlight");
    inputMap = new HashMap<playerInput, String>();
    testInput = new playerInput("use", "lever");
    inputMap.put(testInput, "You hear the sound of mechanisms working");
    Stack roomStack = new Stack<roomState>();
    roomStack.push(new roomState(objArr, inputMap, testInput));
    roomStack.push(new roomState(objArr, inputMap, testInput));

    roomGrid = new room[2][2];
    roomGrid[0][0] = new room("Test Room", "A Room Used for Testing", roomStack);//instead of roomStack, maybe a roomState?
    roomGrid[0][1] = new room("Test RoomB", "Another Room Used for Testing", roomStack);

    character fixture = new character(verbArr, invLs, roomGrid);

    return fixture;
  } 

}