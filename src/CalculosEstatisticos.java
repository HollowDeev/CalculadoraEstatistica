import java.util.ArrayList;
import java.util.Collections;

public class CalculosEstatisticos {

    // media aritmetica
    public static double calcularMedia(ArrayList<Double> dados) {

        double soma = 0;

        for (int i = 0; i < dados.size(); i++) {
            soma = soma + dados.get(i);
        }

        double media = soma / dados.size();
        return media;

    }

    // mediana
    public static double calcularMediana(ArrayList<Double> dados) {

        ArrayList<Double> copia = new ArrayList<>(dados);
        Collections.sort(copia);

        int tamanho = copia.size();
        int meio = tamanho / 2;

        if (tamanho % 2 != 0) {
            return copia.get(meio);
        }

        double valor1 = copia.get(meio - 1);
        double valor2 = copia.get(meio);
        double mediana = (valor1 + valor2) / 2.0;

        return mediana;

    }

    // moda
    public static String calcularModa(ArrayList<Double> dados) {

        int maiorFrequencia = 0;

        for (int i = 0; i < dados.size(); i++) {
            int frequencia = 0;
            for (int j = 0; j < dados.size(); j++) {
                if (dados.get(i).equals(dados.get(j))) {
                    frequencia++;
                }
            }
            if (frequencia > maiorFrequencia) {
                maiorFrequencia = frequencia;
            }
        }

        if (maiorFrequencia == 1) {
            return "Amodal (nenhum valor se repete)";
        }

        ArrayList<Double> valoresModa = new ArrayList<>();

        for (int i = 0; i < dados.size(); i++) {
            double numero = dados.get(i);
            int frequencia = 0;
            for (int j = 0; j < dados.size(); j++) {
                if (dados.get(j).equals(numero)) {
                    frequencia++;
                }
            }
            if (frequencia == maiorFrequencia && !valoresModa.contains(numero)) {
                valoresModa.add(numero);
            }
        }

        String resultado = "Moda: ";
        for (int i = 0; i < valoresModa.size(); i++) {
            resultado = resultado + valoresModa.get(i);
            if (i < valoresModa.size() - 1) {
                resultado = resultado + ", ";
            }
        }

        return resultado;

    }

    // desvio padrao
    public static double calcularDesvioPadrao(ArrayList<Double> dados) {

        double media = calcularMedia(dados);
        double somaQuadrados = 0;

        for (int i = 0; i < dados.size(); i++) {
            double diferenca = dados.get(i) - media;
            somaQuadrados = somaQuadrados + Math.pow(diferenca, 2);
        }

        double variancia = somaQuadrados / dados.size();
        double desvioPadrao = Math.sqrt(variancia);

        return desvioPadrao;

    }

    // coeficiente de variacao
    public static double calcularCoeficienteVariacao(ArrayList<Double> dados) {

        double desvioPadrao = calcularDesvioPadrao(dados);
        double media = calcularMedia(dados);

        if (media == 0) {
            return 0;
        }

        double cv = (desvioPadrao / Math.abs(media)) * 100;
        return cv;

    }

    // verifica se a dispersao é alta ou baixa
    public static String verificarDispersao(double cv) {

        if (cv <= 20) {
            return "Baixa Dispersão (Dados Homogêneos)";
        } else {
            return "Alta Dispersão (Dados Heterogêneos)";
        }

    }

}
