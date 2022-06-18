package javaimc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaIMC {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        
        String path = "C:\Users\MichaelS\Documents\Trabalho\eclipse\javaimc-main";

        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String titulos = buffRead.readLine();

        String linha = buffRead.readLine();
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("../MichaelShumakerQueirozLoulaDeCarvalho.txt"));
        while (true) {
            if (linha != null) {
                
                String[] infos = linha.split(";");
                List<String> lista = new ArrayList<String>(Arrays.asList(infos));
                if (lista.size() == 4) {
                    String altura = lista.get(3).toString();
                    String peso = lista.get(2).toString();
                    if (peso.isEmpty() || altura.isEmpty()) {

                        String linha2 = lista.get(0).trim().toUpperCase() + " "
                                + lista.get(1).trim().toUpperCase();
                        buffWrite.append(linha2 + "\n");
                        buffWrite.newLine();

                    } else {
                        float IMC = Float.parseFloat(peso.trim().replace(",", "."))
                                / (Float.parseFloat(altura.trim().replace(",", ".")) * Float.parseFloat(altura.trim().replace(",", ".")));
                        DecimalFormat df = new DecimalFormat("##.##");
                        System.out.println(df.format(IMC) + " ");

                        String linha2 = lista.get(0).trim().toUpperCase() + " "
                                + lista.get(1).trim().toUpperCase() + " " + df.format(IMC) + " ";
                        buffWrite.append(linha2 + "\n");
                        buffWrite.newLine();

                    }

                } else {
                    String linha2 = lista.get(0).trim().toUpperCase() + " "
                            + lista.get(1).trim().toUpperCase();
                    buffWrite.append(linha2 + "\n");
                    buffWrite.newLine();
                }

            } else {
                break;
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
        buffWrite.close();
    }
}
