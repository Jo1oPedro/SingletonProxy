import database.DatabaseProxy;
import database.IDatabase;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.fail;

public class DatabaseProxyTest {
    @Test
    public void deveRealizarLogDosDadosEnviadosParaEnvioDoEmail() {
        IDatabase database = new DatabaseProxy();
        database.query("select * from t1");
        this.realizaLeituraDoArquivo("Query: select * from t1");
    }

    public void realizaLeituraDoArquivo(String conteudoDesejado) {
        try {
            String filePath = System.getProperty("user.dir") + "/log.txt";
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            boolean encontrado = false;

            // Lê o arquivo linha por linha e verifica se o conteúdo desejado está presente
            while ((linha = bufferedReader.readLine()) != null) {
                if (linha.equals(conteudoDesejado)) {
                    encontrado = true;
                    break; // Se encontrado, podemos parar de ler o arquivo
                }
            }

            // Fecha o BufferedReader
            bufferedReader.close();

            if (!encontrado) {
                fail();
            }
        } catch (IOException e) {
            fail();
        }
    }
}
