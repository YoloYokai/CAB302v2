import java.util.ArrayList;

public class VecFile {
    public static void main(String[] args) {
        FileParser test = new FileParser();
        ArrayList<DrawingCommand> storagepoint = test.loadfile();
        test.savefile(storagepoint);
    }
}
