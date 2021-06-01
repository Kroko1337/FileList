import sun.awt.datatransfer.ClipboardTransferable;

import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> list = searchNames("jar", new File("../"));
        list.forEach(System.out::println);
    }

    public static List<String> searchNames(String type, File location) {
        final List<String> list = new ArrayList<>();
        final File[] files = location.listFiles();
        if(files != null) {
            for (File file : files) {
                final String name = file.getName();
                if(name.endsWith("." + type))
                    list.add(name.substring(0, name.substring(0, name.length() - ("." + type).length()).length()));
            }
        }
        return list;
    }
}
