package GenericsEx;

import java.util.ArrayList;
import java.util.Collections;

// <?> is called wildcard in Generics

public class League<T extends Team<P>, P extends Player> { // Team<P> instead of Team<?> for type safety
  public String name;
  private ArrayList<T> league = new ArrayList<>();

  public League(String name) {
    this.name = name;
  }

  public boolean add(T team) {
    if (league.contains(team)) {
      return false;
    }
    league.add(team);
    return true;
  }

  public void showLeagueTable() {
    Collections.sort(league);
    for (T t : league) {
      System.out.println(t.getName() + ": " + t.ranking());
    }
  }
}
