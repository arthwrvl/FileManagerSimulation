import java.util.ArrayList;

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
    public void deleteFile(String file){
        int dataIndex = 0;
        Node current = null;
        boolean fileExists = false;
        ArrayList<Integer> filePointers = new ArrayList<>();
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == null){
                continue;
            }
            if(nodes[i].data == file.charAt(0)){
                filePointers.clear();
                filePointers.add(i);
                current = nodes[i];
                while (current.next != -1){
                    dataIndex++;
                    if(nodes[current.next].data == file.charAt(dataIndex)){
                        filePointers.add(current.next);
                        current = nodes[current.next];
                    }
                }
                if(filePointers.size() == file.length()){
                    fileExists = true;
                    break;
                }
            }

        }
        if(fileExists){
            freeSpace += file.length();
            for(int i = 0; i < filePointers.size(); i++){
                nodes[filePointers.get(i)] = null;
            }
        }else{
            System.out.println("Arquivo não encontrado!");
        }

    }
    public void seeFiles(){
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] != null){
                System.out.printf("%02d %c\n", i, nodes[i].data);
            }else{
                System.out.printf("%02d -\n", i);
            }
        }
    }
    public void debugFiles(){
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] != null){
                System.out.printf("%02d %c pointing to %02d\n", i, nodes[i].data, nodes[i].next);
            }else{
                System.out.printf("%02d -\n", i);
            }
        }
    }
}
