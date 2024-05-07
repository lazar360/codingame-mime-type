import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        HashMap<String, String> mapExtMt = new HashMap<>();
        List<String> listExt = new ArrayList<>();
        List<String> listMim = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next().toLowerCase(); // file extension
            String MT = in.next(); // MIME type.
            // System.err.println("EXT= " + EXT);
            // System.err.println("MT= " + MT);
            mapExtMt.put(EXT, MT);
            listExt.add(EXT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase(); // One file name per line.
            System.err.println("FNAME= " + FNAME);
            // Check if the filename contains an extension
            if (
                    !FNAME.matches(".*\\..+")
                            ||
                            (FNAME.startsWith(".") && FNAME.endsWith("."))
            ) {
                FNAME = "UNKNOWN.UNKNOWN";
            }

            String[] parts = FNAME.split("\\.");
            String extension = "UNKNOWN";
            if(parts.length - 1 != -1){
                extension = parts[parts.length - 1];
            }

            listMim.add(mapExtMt.get(extension) == null ? "UNKNOWN" : mapExtMt.get(extension));
        }
        // System.err.println("listMim= " + listMim);
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        for (String ext : listMim) {
            // System.out.println("UNKNOWN");
            System.out.println(ext);
        }

    }
}