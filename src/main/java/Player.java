package main.java;

public class Player {
  String name;
  int score;

  boolean advantage;

  public boolean hasAdvantage() {
    return advantage;
  }

  public void setAdvantage(boolean advantage) {
    this.advantage = advantage;
  }

  public Player(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
