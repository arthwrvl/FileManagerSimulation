public class Disk {
    private Node nodes[];
    private int freeSpace = 0;

    public Disk(int size){
        nodes = new Node[size];
        freeSpace = size;
    }
}
