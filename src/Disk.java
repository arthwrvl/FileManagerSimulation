public class Disk {
    private Node nodes[];
    private int freeSpace = 0;

    public Disk(int size){
        nodes = new Node[size];
        freeSpace = size;
    }
    public void seeFiles(){
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] != null){
                System.out.println(i + " " + nodes[i].data);
            }else{
                System.out.println(i + " " + "-");
            }
        }
    }
}
