import java.io.*;

class FileSplit {
    public static void main(String[] args) throws IOException {
        splitFile(new File(args[0]), args[1]);
    }

    public static void splitFile(File f, String path) throws IOException {
        int partCounter = 1;//Новые файлы будут нумероваться как 001, 002, 003, ...
        //Можно заменить на 0 и будет 000, 001, ...

        int sizeOfFiles = 1024 * 1024 * 10;// создаться 7 файлов (7MB)
        byte[] buffer = new byte[sizeOfFiles];

        String fileName = f.getName();

        try (FileInputStream fis = new FileInputStream(f);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            int bytesAmount = 0;
            while ((bytesAmount = bis.read(buffer)) > 0) {
                //запись каждого фрагмента данных в отдельный файл с другим номером в имени
                String filePartName = String.format("%s.%03d", fileName, partCounter++);
                BufferedWriter br = new BufferedWriter(new FileWriter(path+"\\"+filePartName));
                File newFile = new File(path, filePartName);
                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(buffer, 0, bytesAmount);
                }
                br.close();
            }
        }
    }
}