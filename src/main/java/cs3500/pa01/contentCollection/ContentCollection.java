package cs3500.pa01.contentCollection;

public interface ContentCollection {
  public String toString();

  public <T> T get(int index);
}