package edu.luc.cs.cs271.lab2;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdventure {

  String[] strArr;
  String[] verbArr;
  String[] objStr;
  playerInput testInput;
  Map<playerInput, String> inputMap;
  Stack<roomState> roomStack;
  room fixtureA;
  character fixtureB;

  @Before
  public void setUp() {
    verbArr = new String[2];
    verbArr[0] = "look";
    verbArr[1] = "use";

    String[] strArr = new String[2];
    strArr[0] = "lever";
    strArr[1] = "box";
    inputMap = new HashMap<playerInput, String>();
    inputMap.put(new playerInput("look"), "You see a Room");
    testInput = new playerInput("use");
    testInput.setObjectA("lever");
    inputMap.put(testInput, "You hear the sound of mechanisms working");
    roomStack = new Stack<roomState>();
    roomStack.push(new roomState(objStr, inputMap));

    fixtureA = new room("Test Room", "A Room Used for Testing", roomStack);
    fixtureB = new character(verbArr, new String[2], fixtureA, new room[5][5]);
  }

  @After
  public void tearDown() {
    verbArr = null;
    strArr = null;
    fixtureA = null;
    fixtureB = null;
  }

  @Test
  public void testCharacterParser() {
    fixtureB.parseText("Use Lever");
  }
}
