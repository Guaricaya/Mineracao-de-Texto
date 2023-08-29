import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class ContadorDePalavras {
    private String texto;
    private static Map<String, Integer> contador = new HashMap<String, Integer>();

    public ContadorDePalavras(String msg) {
        this.texto = msg;
        contarPalavrasRepetidas(texto, contador);
    }
    public Map<String, Integer> getContador(){
      return contador;
    }

    public void contarPalavrasRepetidas(String texto, Map<String, Integer> contador) {
        String[] palavras = texto.split("\\s+");

        for (String palavra : palavras) {
            palavra = palavra.toUpperCase();
            palavra = palavra.replaceAll("\\p{Punct}", "");
            if(palavra != ""){
              contador.put(palavra, contador.getOrDefault(palavra, 0) + 1);
            }
            
        }
    }
    public void imprimirContagemPalavras(int numeroPalavras) {
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(contador.entrySet());
        Collections.sort(listaOrdenada, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
            }
        });

        int contadorPalavras = 0;
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            if (contadorPalavras < numeroPalavras) {
                System.out.println(contadorPalavras+1 +"- Palavra: " + entry.getKey() + ", Ocorrências: " + entry.getValue());
                contadorPalavras++;
            } else {
                break;
            }
        }
    }
}