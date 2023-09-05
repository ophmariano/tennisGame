public class Player {

  private final String name;
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

  public String getName() {
    return name;
  }
}
