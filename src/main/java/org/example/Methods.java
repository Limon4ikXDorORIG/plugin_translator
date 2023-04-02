package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Methods {
    List<String> readList = new ArrayList<>();
    List<String> listTranslate = new ArrayList<>();
    List<String> listEqual = new ArrayList<>();
    List<String> forWrite = new ArrayList<>();
    void fileRead(String mode,Path pathToFile) throws Exception {
        if (Objects.equals(mode, "config")) {
            readList = Files.readAllLines(pathToFile);
            System.out.println("-------------------------------------------CONFIG READ-------------------------------------------");
            for (String s : readList){
                System.out.println(s);
            }


            System.out.println("-------------------------------------------MESSAGES-------------------------------------------");
            for (String s : readList) {
                if (s.contains(":")) {
                    listEqual.add(s.substring((s.indexOf(':')) + 1));
                    System.out.println(s.substring((s.indexOf(':')) + 1));
                }
            }
        }
        if (Objects.equals(mode, "translate")) {
            listTranslate = Files.readAllLines(pathToFile);
        }
    }

    void fileWrite(Path path,List<String> list) throws Exception
    {
        Files.write(path,list);
    }

    void Constructor() {

        String temp;
        System.out.println("-------------------------------------------TRANSLATE-------------------------------------------");
        for(String s : listTranslate){
            System.out.println(s);
        }

        System.out.println("-------------------------------------------CONFIG CONSTRUCTOR-------------------------------------------");
        int j = 0;
        for(String s : readList){
            if (s.contains(":")){
                temp = s.substring(0,(s.indexOf(':'))) + ":" + listTranslate.get(j);
                forWrite.add(temp);
                System.out.println(temp);
                j = j + 1;
            }
        }
    }
}