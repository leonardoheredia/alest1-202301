package T2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeituraArquivo {

    public static void main(String[] args) throws ParseException {


        String linhas[] = new String[110000];
        int numLinhas = 0;

        Path filePath = Paths.get("c:\\temp\\dataEditado.csv");


        // Ler o arquivo
        try ( BufferedReader reader = Files.newBufferedReader(filePath, Charset.defaultCharset())) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: ", e.getMessage());
        }

        // Mude numLinhas para algum numero pequeno para executar testes mais rapidamente.
        // Ex:
        // for (int i = 0; i < 50; i++) {
        for (int i = 0; i < numLinhas; i++) {
            String[] campos = linhas[i].split(";");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime dateTime = LocalDateTime.parse(campos[0], formatter);
            int anoDataExtracao = dateTime.getYear();
            int mesDataExtracao = dateTime.getMonthValue();
            int diaDataExtracao = dateTime.getDayOfMonth();
            int horaDataExtracao = dateTime.getHour();
            int minDataExtracao = dateTime.getMinute();

            System.out.println("Data e hora extracao: " + diaDataExtracao + "/" + mesDataExtracao + "/" + anoDataExtracao + ", " + horaDataExtracao + ":" + minDataExtracao);

            String descricao = campos[1];
            String estado = campos[2];
            String complemento = campos[3];

            System.out.println("Descricao: " + descricao);
            System.out.println("Estado: " + estado + ", " + complemento);

            int anoImplantacao = 0;
            int mesImplantacao = 0;
            int diaImplantacao = 0;            
            if(!campos[4].equals("")) {
                if(campos[4].contains("-"))
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                else
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(campos[4], formatter);
                anoImplantacao = date.getYear();
                mesImplantacao = date.getMonthValue();
                diaImplantacao = date.getDayOfMonth();
            }
            
            System.out.println("Data implantacao: " + diaImplantacao + "/" + mesImplantacao + "/" + anoImplantacao);

            String logradouro = campos[5].split(" ", 2)[0];
            String nomeLog = campos[5].split(" ", 2)[1];
            System.out.println("Logradouro: " + logradouro + " " + nomeLog);

            double numInicial;
            if(campos[6].equals(""))
                numInicial = 0;
            else
                numInicial = Double.parseDouble(campos[6]);
            
            double numFinal;
            if(campos[7].equals(""))
                numFinal = 0;
            else
                numFinal = Double.parseDouble(campos[7]);
            
            String defronte = campos[8];
            String cruzamento = campos[9];
            String lado = campos[10];
            String fluxo = "";
            if(campos.length>=12)
                fluxo = campos[11];
            String localInstalacao = "";
            if(campos.length>=13)
                localInstalacao = campos[12];

            System.out.println("Num inicial e final: " + numInicial + ", " + numFinal + "; "
                    + defronte + "; " + cruzamento + "; " + lado + "; " + fluxo + "; " + localInstalacao);
            System.out.println("---------------------------------------> " + i);
        }
    }
}
