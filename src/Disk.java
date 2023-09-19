public class Disk {
    private Node nodes[];
    private int freeSpace = 0;

    public Disk(int size){
        nodes = new Node[size];
        freeSpace = size;
    }
    public void createFile(String file){
        if(freeSpace >= file.length()){
            Node current = null;
            for(int i = 0; i < file.length(); i++){
                for(int j = 0; j < nodes.length; j++){
                    if(nodes[j] == null){
                        nodes[j] = new Node(file.charAt(i));
                        freeSpace--;
                        if(current != null){
                            current.next = j;
                        }
                        current = nodes[j];
                        break;
                    }
                }
            }
        }else{
            System.out.println("Não há espaço livre no disco");
        }
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
