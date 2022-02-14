public class Help {
    public static void main(String[] args) {
        if (args[0].equals("--help")) {
            System.out.println("Для запуска разделителя файлов FileSplit.jar необходимо передать через пробел 2 аргумента: \n" +
                    "1- путь лога \n" +
                    "2- путь до папки \n" +
                    "*Постоянная часть имени полученных файлов задана регулярным выражением в коде программы* \n" +
                    "Для запуска парсера логов LogParser(a).jar необходимо передать через пробел 3 аргумента:  \n" +
                    "1- Фраза поиска (можно символьно, без пробелов, или в виде регулярного выражения) \n" +
                    "2- Путь до папки, в которой лежит созданный файл после работы FileSplit.jar \n" +
                    "3- Путь и имя нового файла \n" +
                    "*Пример: путь\\file.txt* \n" +
                    "Для запуска парсера логов LogParser(b).jar необходимо передать через пробел 3 аргумента:  \n" +
                    "1- Разделитель (один символ), по умолчанию лучше ставить \";\" \n" +
                    "2- Путь до папки, в которой лежит созданный файл после работы LogParser(a).jar и его имя \n" +
                    "3- Путь и имя нового файла в формате \"путь\\имя\". \n" +
                    "*файл автоматически сохранится в формате .csv*");
        }

    }
}
