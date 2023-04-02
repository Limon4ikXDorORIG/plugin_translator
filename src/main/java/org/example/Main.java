package org.example;


import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Path pathToConfig = Path.of("D:\\JP\\pluginTranslator\\txt\\messages.yml");
        Path pathToTranslate = Path.of("D:\\JP\\pluginTranslator\\txt\\translate.yml");
        Path pathForTest = Path.of("D:\\JP\\pluginTranslator\\txt\\test.yml");

        Scanner scan = new Scanner(System.in);
        Methods utils = new Methods();

        utils.fileRead("config",pathToConfig);
        utils.fileRead("translate",pathToTranslate);
        utils.Constructor();
        utils.fileWrite(pathForTest,utils.forWrite);

    }
}