package Generics;

import java.util.ArrayList;

// Comparable is implemented

public class Team<T extends Player> implements Comparable<Team<T>> { // Generics added to class
  // this class can have implemented an interface as generics also instead of abstrct class
  // both extend and implement can be used togather on generics (extends Class & Interface1 & Interface2)
  // interface comes with <T> generics also
  private String name;
  int played = 0;
  int won = 0;
  int lost = 0;
  int tied = 0;

  private ArrayList<T> members = new ArrayList<>(); // generics used

  public Team(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public boolean addPlayer(T player) { // generics used
    if (members.contains(player)) {
      System.out.println(player.getName() + " is already on this team");
      return false;
    } else {
      members.add(player);
      System.out.println(player.getName() + " picked for team " + this.name);
      return true;
    }
  }

  public int numPlayers() {
    return this.members.size();
  }

  public void matchResult(Team<T> opponent, int ourScore, int theirScore) { // type safety using generics for opponent

    String message;

    if (ourScore > theirScore) {
      won++;
      message = " beat ";
    } else if (ourScore == theirScore) {
      tied++;
      message = " drew with ";
    } else {
      lost++;
      message = " lost to ";
    }
    played++;
    if (opponent != null) {
      System.out.println(this.getName() + message + opponent.getName());
      opponent.matchResult(null, theirScore, ourScore);
    }
  }

  public int ranking() {
    return (won * 2) + tied - lost;
  }

  @Override
  public String toString() {
    return name + " : W-" + won + " L-" + lost + " T-" + tied;
  }

  @Override
  public int compareTo(Team<T> team) { // Comparable with Generics
    if (this.ranking() > team.ranking()) {
      return -1;
    } else if (this.ranking() < team.ranking()) {
      return 1;
    } else {
      return 0;
    }
  }
}