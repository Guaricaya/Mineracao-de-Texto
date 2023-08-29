import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException{
    String path = "Dados/preadores-br.xml";
    String pathtxt = "Dados/Depress-pr-br.txt";
    LerXML arquivo  = new LerXML(path);
    arquivo.lerMensagem();
    LerArquivoTexto arqtxt = new LerArquivoTexto(pathtxt);
    arqtxt.arquivotxt();
    System.out.println("Mostrando as 100 Palavras mais ocorrentes no dataset: ");
      System.out.println("-----------------------------------------");
    arquivo.mostraContagemFinal(100);
    System.out.println("Mostrando as 20 Palavras mais ocorrentes no dataset que também aparencem no arquivo do lexico: ");
      System.out.println("-----------------------------------------");
    arqtxt.getListaDeLexico();
    CruzadorDeString selecaoFinal = new CruzadorDeString(arqtxt.getListaDeLexico(),arquivo.getDataset());
    selecaoFinal.imprimirOrdenadoPorValor(arquivo.getDataset(), arqtxt.getListaDeLexico(), 20);
    
  }
}
