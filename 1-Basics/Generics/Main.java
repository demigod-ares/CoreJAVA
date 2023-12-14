package Generics;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    FootballPlayer joe = new FootballPlayer("Joe");
    BaseballPlayer pat = new BaseballPlayer("Pat");
    SoccerPlayer beckham = new SoccerPlayer("Beckham");

    Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
    adelaideCrows.addPlayer(joe);
    // adelaideCrows.addPlayer(pat); // Generics type issue
    // adelaideCrows.addPlayer(beckham); // Generics type issue

    System.out.println(adelaideCrows.numPlayers()); // 1

    Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
    baseballTeam.addPlayer(pat);

    Team<SoccerPlayer> brokenTeam = new Team<>("broken team");
    brokenTeam.addPlayer(beckham);

    Team<FootballPlayer> melbourne = new Team<>("Melbourne");
    FootballPlayer banks = new FootballPlayer("Gordon");
    melbourne.addPlayer(banks);

    Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
    Team<FootballPlayer> fremantle = new Team<>("Fremantle");

    hawthorn.matchResult(fremantle, 1, 0);
    hawthorn.matchResult(adelaideCrows, 3, 8);

    adelaideCrows.matchResult(fremantle, 2, 1);
    // adelaideCrows.matchResult(baseballTeam, 1, 1); // Type Mismatch

    System.out.println("Rankings");
    System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
    System.out.println(melbourne.getName() + ": " + melbourne.ranking());
    System.out.println(fremantle.getName() + ": " + fremantle.ranking());
    System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

    System.out.println(adelaideCrows.compareTo(melbourne));
    System.out.println(adelaideCrows.compareTo(hawthorn));
    System.out.println(hawthorn.compareTo(adelaideCrows));
    System.out.println(melbourne.compareTo(fremantle));

    ArrayList<Team<FootballPlayer>> teams = new ArrayList<>();
    teams.add(melbourne);
    teams.add(hawthorn);
    teams.add(fremantle);
    teams.add(adelaideCrows);
    // teams.add(brokenTeam); // Generics don't match, type match issue
    // teams.add(baseballTeam); // Generics don't match, type match issue
    System.out.println(teams + " : before sorting");
    Collections.sort(teams); // Can be modified using Comparator or Comparable
    System.out.println(teams + " : after sorting");
  }
}
