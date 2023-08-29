import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.Map;

public class LerXML {
  private String arquivo; 
  private ContadorDePalavras contagem;
  
  public LerXML(String path){
      this.arquivo = path;
      System.out.println("Extraindo dados do Arquivo XML...");
      System.out.println("---------------------------------");
  }
  
  public void lerMensagem(){
    try{
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(arquivo);
      
      // Navegando pelos elementos "elemento"
      NodeList elementos = document.getElementsByTagName("message");
      for(int i = 0; i < elementos.getLength(); i++){
          Element elemento = (Element) elementos.item(i);
          String msg = elemento.getElementsByTagName("text").item(0).getTextContent();
          ContadorDePalavras contador = new ContadorDePalavras(msg);
          //System.out.println("text: " + msg);
          //System.out.println("------------------------");
          contagem = contador;
      }
      System.out.println("Extração de dados concluida.");
      System.out.println("---------------------------------");
    } catch (Exception e) {
            e.printStackTrace();
        }
  }

  public void mostraContagemFinal(int numeroPalavras){
    contagem.imprimirContagemPalavras(numeroPalavras);
  }

  public Map<String, Integer> getDataset(){
    return contagem.getContador();
  }
 
  
}

  