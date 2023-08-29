import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class CruzadorDeString {
  
  private List<String> lexico; 
  private Map<String, Integer> dataset;
  public CruzadorDeString(List<String> lexico, Map<String, Integer> dataset){
     this.dataset = dataset;
     this.lexico = lexico;
   }

   public void imprimirOrdenadoPorValor(Map<String, Integer> map, List<String> lista, int numeroPalavras) {
     List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(map.entrySet());
      Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
          public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
              return b.getValue().compareTo(a.getValue());
          }
      });
     
      int contadorOcorrencias = 0;

      for (Map.Entry<String, Integer> entry : listaOrdenada) {
      String chave = entry.getKey();    
        if (lista.contains(chave)) {
          if (contadorOcorrencias < numeroPalavras) {
            System.out.println(contadorOcorrencias + 1 +"- Palavra: " + entry.getKey() + ", Valor: " + entry.getValue());
            contadorOcorrencias++;
          }else {
              break;
          }
        }
      }
    }
}
