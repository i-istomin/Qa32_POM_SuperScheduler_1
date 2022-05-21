package configuration;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("wick@gmail.com").password("Ww12345$").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("Qa32_POM_SuperScheduler_1/src/test/resources/data.csv")));
        // kak tolko vizvali buffered reader, mojem skazat emu chitat
        String line = reader.readLine();

        while (line != null) {//do teh por poka est chto chitat-> budu chitat
            String[] split = line.split(",");
            list.add(new Object[]{Auth.builder().email(split[0]).password(split[1]).build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}