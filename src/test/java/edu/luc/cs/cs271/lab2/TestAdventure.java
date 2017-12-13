package edu.luc.cs.cs271.lab2;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdventure {

  LinkedList<String> objArr;
  String[] verbArr;
  String[] objStr;
  room[][] roomGrid;
  LinkedList<String> invLs;
  playerInput testInput;
  Map<playerInput, String> inputMap;
  Stack<roomState> roomStack;
  room fixtureA;
  character fixture;

  @Before
  public void setUp() {
    verbArr = new String[4];
    verbArr[0] = "look";
    verbArr[1] = "use";
    verbArr[2] = "pick";
    verbArr[3] = "go";

    objArr = new LinkedList<String>();
    objArr.add("lever");
    objArr.add("box");

    invLs = new LinkedList<String>();
    invLs.add("matches");
    invLs.add("flashlight");
    inputMap = new HashMap<playerInput, String>();
    testInput = new playerInput("use", "lever");
    inputMap.put(testInput, "You hear the sound of mechanisms working");
    roomStack = new Stack<roomState>();
    roomStack.push(new roomState(objArr, inputMap, testInput));

    roomGrid = new room[2][2];
    roomGrid[0][0] = new room("Test Room", "A Room Used for Testing", roomStack);
    roomGrid[0][1] = new room("Test RoomB", "Another Room Used for Testing", roomStack);

    fixture = new character(verbArr, invLs, roomGrid);
  }

  @After
  public void tearDown() {
    verbArr = null;
    objArr = null;
    fixture = null;
  }

  @Test
  public void testCharacterParser() {
    fixture.handlePlayerIO("use lever");
    assertEquals(testInput.getVerb(), fixture.getLastInput().getVerb());
    assertEquals(testInput.getObjectA(), fixture.getLastInput().getObjectA());
    assertEquals(testInput.getObjectB(), fixture.getLastInput().getObjectB());
  }
  /*
  @Test
  public void testCharacterMovement() {
    fixture.handlePlayerIO("go north");
    //assertEquals(roomGrid[0][0], fixture.getCurrentRoom());
    //assertEquals(roomGrid[0][1], fixture.getCurrentRoom());
  }

  @Test
  public void testCharacterPickUp() {
    fixture.handlePlayerIO("pick up box");
    // assertEquals(true, fixture.getInv().contains("box"));
  }
  */
}
