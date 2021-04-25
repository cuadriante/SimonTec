package Pattern;

public class UserPatternStorage {
    CircularList<Color> userPatternStorage = new CircularList<>();

    public UserPatternStorage() {
    }
    public void addColor(String color){
        Color newColor = new Color();
        newColor.setColor(color);
        userPatternStorage.addLast(newColor);
        printColorList();
    }

    public void printColorList() {
        int size = userPatternStorage.listSize();
        int index = 0;
        do {
            Color temp = userPatternStorage.getElement(index);
            System.out.print(temp.getColorColor() + ", ");
            index++;
        } while (index != size);
    }
}
