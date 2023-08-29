import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LerArquivoTexto {
  private String path;   
  private List<String> listaDeLexico = new ArrayList<>();

  
  public LerArquivoTexto (String path){
    this.path = path;
      System.out.println("Extraindo dados do Arquivo Texto...");
      System.out.println("---------------------------------");
  }
  
  public List<String> getListaDeLexico() {
    return listaDeLexico;
  }
  public void arquivotxt() throws IOException{
    FileReader arquivo = new FileReader(path);
    BufferedReader bufferedReader = new BufferedReader(arquivo);
    try{
        String linha = bufferedReader.readLine();
         while (linha!=null) {
           listaDeLexico.add(linha);
           //System.out.println(linha);
           linha = bufferedReader.readLine();  
          }
      System.out.println("Extração de dados concluida.");
      System.out.println("---------------------------------");
    } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo: " + e.getMessage());
    }
    bufferedReader.close();
  }
 
  
}