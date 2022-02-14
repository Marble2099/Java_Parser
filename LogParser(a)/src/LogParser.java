import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        try {
            Pattern pattern = Pattern.compile(args[0]);
            File parts = new File(args[1]);
            ArrayList<String> filesList = listFilesForFolder(parts);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2])));
            Iterator fileiterator = filesList.iterator();

            while(fileiterator.hasNext()) {
                String s = (String)fileiterator.next();
                File rawLog = new File(s);
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(rawLog), StandardCharsets.UTF_8));

                while(br.ready()) {
                    StringBuilder sb = new StringBuilder(br.readLine());
                    if (pattern.matcher(sb.toString()).find()) {
                        bw.write(sb.toString() + "\n");
                    }
                }
                br.close();
            }
            bw.close();
        }catch (IOException var) {
            var.printStackTrace();
        }
    }

    private static ArrayList<String> listFilesForFolder(File folder) {
        ArrayList<String> total_files = new ArrayList();
        File[] filelist = (File[]) Objects.requireNonNull(folder.listFiles());
        int list_length = filelist.length;

        for(int i = 0; i < list_length; ++i) {
            File fileEntry = filelist[i];
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                total_files.add(fileEntry.getPath());
            }
        }

        return total_files;
    }
}
