import java.io.*;

public class LogParser {
    public static void main(String[] args) {
        try {
            char Delimeter = args[0].toCharArray()[0];
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[2] + ".csv")));

                while(br.ready()) {
                    StringBuilder sb = new StringBuilder(br.readLine());
                        sb.setCharAt(10, Delimeter);
                        sb.setCharAt(23, Delimeter);
                        sb.replace(29, 30, Character.toString(Delimeter));
                        if (sb.indexOf("\t") != -1) {
                            sb.setCharAt(sb.indexOf("\t"), Delimeter);
                        }

                        bw.write(sb.toString() + "\n");
                    }
                br.close();
            bw.close();
        } catch (IOException var) {
            var.printStackTrace();
        }
    }
}
