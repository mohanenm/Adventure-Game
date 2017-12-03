package main.java.edu.luc.cs.cs271.advent;

import java.util.*;

public class Main {
  public static void Main(String args) {
    String[] verbArr;
    Map<playerInput, String> inputMap;
    Stack<roomState> roomStack;

    verbArr = new String[2];
    verbArr[0] = "Look";
    verbArr[1] = "Use";

    String[] strArr = new String[2];
    strArr[0] = "Lever";
    strArr[1] = "Box";
    inputMap = new HashMap<playerInput, String>();
    inputMap.put(new playerInput("Look"), "You see a Room");
    inputMap.put(new playerInput("Use"), "You hear the sound of mechnaisms working");
    roomStack = new Stack<roomState>();
    roomStack.push(new roomState(strArr, inputMap));

    room fixtureA = new room("Test Room", "A Room Used for Testing", roomStack);
    character fixtureB = new character(verbArr, new String[2], fixtureA);

    fixtureB.parseText("Use Lever");
    System.out.print(fixtureB.getLastInput());
  }
  /*
  public static void main(String args){
      Scanner input = new Scanner(System.in);
      character player = new character(new String[], new String[], new Room())
      while(){
          player.parseText(Scanner.nextLine());
      }
  }
  */
}
