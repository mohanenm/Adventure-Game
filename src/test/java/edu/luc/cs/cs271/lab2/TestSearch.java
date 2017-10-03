package edu.luc.cs.cs271.lab2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;


public class TestSearch {

  Team[] makeArrayFixture(final int size) {
    final Team[] array = new Team[size];
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      array[i] = new Team("Team " + s, "Coach " + s, i * 100 + 50);
    }
    return array;
  }

  // DONE makeListFixture
  List<Team> makeListFixture(final int size) {
    final List<Team> list = new ArrayList<Team>();
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      list.add(new Team("Team " + s, "Coach "+ s, i * 100 + 50));
    }
    return list;
  }

  @Test
  public void testFindPositionArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10f() {
    final Team[] arr = makeArrayFixture(10);
    assertFalse(Search.findTeamPosition(arr, "Team 11").isPresent());
  }

  // DONE: testFindPositionList0, 10s, 10f
  @Test
  public void testFindPositionList0() {
    final List<Team> list = makeListFixture(0);
    assertFalse(Search.findTeamPosition(list, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionList10s() {
    final List<Team> list = makeListFixture(10);
    assertTrue(Search.findTeamPosition(list, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionList10f() {
    final List<Team> list = makeListFixture(10);
    assertFalse(Search.findTeamPosition(list, "Team 11").isPresent());
  }

  // TODO: testFindMinFundingArray for several sizes and scenarios
  @Test
  public void testFindMinFundingArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamMinFunding(arr, 250).isPresent());
  }
  
  @Test
  public void testFindMinFundingArray8s() {
    final Team[] arr = makeArrayFixture(8);
    assertTrue(Search.findTeamMinFunding(arr, 250).isPresent());
  }
  
  @Test
  public void testFindMinFundingArray4f() {
    final Team[] arr = makeArrayFixture(4);
    assertTrue(Search.findTeamMinFunding(arr, 400).isPresent());
  }

  // TODO: testFindMinFundingArrayFast for several sizes and scenarios
  @Test
  public void testFindMinFundingArrayFast0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamMinFundingFast(arr, 250).isPresent());
  }
  
   @Test
  public void testFindMinFundingArrayFast8s() {
    final Team[] arr = makeArrayFixture(8);
    assertTrue(Search.findTeamMinFundingFast(arr, 250).isPresent());
  }
  
   @Test
  public void testFindMinFundingArrayFast4f() {
    final Team[] arr = makeArrayFixture(4);
    assertFalse(Search.findTeamMinFundingFast(arr, 500).isPresent());
  }
}