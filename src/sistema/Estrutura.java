package sistema;

import java.util.Random;

public class Estrutura {

	private String palavraSecreta;
    private char[] palavraEscondida;
    private boolean[] letrasUtilizadas;
    private int tentativasRestantes;
    private static final int MAX_TENTATIVAS = 6;
    
    public Estrutura(String palavraSecreta) {
        this.palavraSecreta = palavraSecreta;
        this.palavraEscondida = new char[palavraSecreta.length()];
        this.letrasUtilizadas = new boolean[26];
        this.tentativasRestantes = MAX_TENTATIVAS;
    }
    
    public boolean tentarLetra(char letra) {
        letrasUtilizadas[letra - 'a'] = true;
        if (!palavraSecreta.contains(String.valueOf(letra))) {
            tentativasRestantes--;
            return false;
        } else {
            atualizarPalavraEscondida(letra);
            return true;
        }
    }
    
    public boolean jogoAcabou() {
        return tentativasRestantes <= 0 || palavraRevelada();
    }
    
    public boolean palavraRevelada() {
        for (char c : palavraEscondida) {
            if (c == 0) {
                return false;
            }
        }
        return true;
    }
    
    public String obterPalavraEscondida() {
        StringBuilder sb = new StringBuilder();
        for (char c : palavraEscondida) {
            if (c == 0) {
                sb.append("_ ");
            } else {
                sb.append(c).append(" ");
            }
        }
        return sb.toString();
    }
    
    private void atualizarPalavraEscondida(char letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraEscondida[i] = letra;
            }
        }
    }
    
    public int getTentativasRestantes() {
        return tentativasRestantes;
    }
    
    public String getPalavraSecreta() {
        return palavraSecreta;
    }
    
    public boolean[] getLetrasUtilizadas() {
        return letrasUtilizadas;
    }
    
    public static String selecionarPalavraSecreta(String[] palavras) {
        Random random = new Random();
        return palavras[random.nextInt(palavras.length)];
    }
}
