package Pattern;

public class UserPatternStorage {
    CircularList<Color> userPatternStorage = new CircularList<>();

    public UserPatternStorage() {
    }
    public void addColor(String color){
        Color newColor = new Color();
        newColor.setColor(color);
        userPatternStorage.addLast(newColor);
        userPatternStorage.printList();
    }
}
