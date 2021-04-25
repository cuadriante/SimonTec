package Pattern;

public class UserPatternStorage {
    CircularList<Color> userPatternStorage = new CircularList<>();
    CircularList<String> userPatternStorageColor = new CircularList<>();
    private int index = -1;

    public UserPatternStorage() {
    }

    public void addColor(String color){
        Color newColor = new Color();
        newColor.setColor(color);
        userPatternStorage.addLast(newColor);
        userPatternStorageColor.addLast(newColor.getColorColor());
        index ++;
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

    public CircularList<String> getUserPatternStorageColor() {
        return userPatternStorageColor;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public void deleteUserPatternStorage(){
        userPatternStorageColor.deleteAll();
        System.out.println("print listtt");
        userPatternStorageColor.printList();
    }
}
