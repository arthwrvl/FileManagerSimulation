public class Main {
    public static void main(String[] args) {
        Disk disk = new Disk(32);
        disk.createFile("Arapiraca");
        disk.createFile("Alagoas");
        disk.deleteFile("Arapiraca");
        disk.createFile("Major Izidoro");
        disk.seeFiles();
        disk.debugFiles();
    }
}