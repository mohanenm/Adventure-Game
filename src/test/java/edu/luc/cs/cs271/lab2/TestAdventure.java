

/* package main.java.edu.luc.cs.cs271.advent;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAdventure{

    String[] verbArr;
    Map<playerInput, String> inputMap;
    Stack<roomState> roomStack;

@Before
public void setUp(){
    verbArr = new String[2];
    verbArr[0] = "Look";
    verbArr[1] = "Use";

    String[] strArr = new String[2];
    strArr[0] = "Lever";
    strArr[1] = "Box";
    inputMap = new HashMap<playerInput, String>();
    inputMap.put(new playerInput("Look"), "You see a Room");
    inputMap.put(new playerInput("Use").setObjectA("Lever"), "You hear the sound of mechnaisms working");
    roomStack = new Stack<roomState>();
    roomStack.push(new roomState(objStr, inputMap));

    room fixtureA = new room ("Test Room", "A Room Used for Testing", roomStack);
    character fixtureB = new character(verbArr, new String[2], fixtureA);
}

@After
public void tearDown(){
    verbArr = null;
    strArr = null;
    fixtureA = null;
    fixtureB = null;
}

@Test
public void testCharacterParser(){
    fixtureB.parseText("Use Lever");

}

@After
public void charactertest(){;
//assertEquals(,);
//assertEquals(,);
}

}

*/
