package sistema;

import java.util.Scanner;

public class RespostaUsuario {

	private static final String[] PALAVRAS = {"java", "programacao", "computador", "desenvolvimento","openia"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String palavraSecreta = Estrutura.selecionarPalavraSecreta(PALAVRAS);
        Estrutura jogo = new Estrutura(palavraSecreta);
        
        while (!jogo.jogoAcabou()) {
            System.out.println("Palavra: " + jogo.obterPalavraEscondida());
            System.out.println("Tentativas restantes: " + jogo.getTentativasRestantes());
            char letra = lerProximaLetra(sc, jogo.getLetrasUtilizadas());
            if (!jogo.tentarLetra(letra)) {
                System.out.println("Letra não encontrada na palavra secreta.");
            } else {
                System.out.println("Letra encontrada na palavra secreta!");
            }
        }
        
        if (jogo.palavraRevelada()) {
            System.out.println("Parabéns! Você ganhou! A palavra secreta era: " + jogo.getPalavraSecreta());
        } else {
            System.out.println("Você perdeu! A palavra secreta era: " + jogo.getPalavraSecreta());
        }
    }
    
    private static char lerProximaLetra(Scanner scanner, boolean[] letrasUtilizadas) {
        char letra;
        while (true) {
            System.out.print("Digite uma letra: ");
            String input = scanner.next().toLowerCase();
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Entrada inválida. Por favor, digite apenas uma letra.");
                continue;
            }
            letra = input.charAt(0);
            if (letrasUtilizadas[letra - 'a']) {
                System.out.println("Você já tentou essa letra. Tente outra.");
            } else {
                break;
            }
        }
        return letra;
    }
}

