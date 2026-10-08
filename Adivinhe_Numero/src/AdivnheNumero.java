import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;

public class AdivnheNumero{
    
    // Retorna um palpite válido ou indica que a entrada foi encerrada.
    static OptionalInt lerPalpite(Scanner scanner, int min, int max){
        while (true) {
            System.out.print("Seu palpite (" + min + " a " + max + "): ");
            if (!scanner.hasNextLine()) {
                return OptionalInt.empty();
            }
            String entrada = scanner.nextLine();
            try{
                int palpite = Integer.parseInt(entrada.trim());
                if (palpite < min || palpite > max) {
                    // Mantém o jogador no pedido até informar um valor dentro do intervalo.
                    System.out.println("O número do palpite tem que ser entre " + min + " e " + max + ".");
                } else{
                    return OptionalInt.of(palpite);
                }
            } catch (NumberFormatException e) {
                // Trata entradas que não podem ser convertidas para um inteiro.
                System.out.println("Digite apenas números inteiros.");
            }
        }
    }

    public static void main(String[] args) {
        // Recursos e limites usados durante as partidas.
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 50;
        final int MAX_TENTATIVAS = 7;

        String jogarNovamente;
        do{
            // Cada partida começa com um novo número secreto e tentativas zeradas.
            int sorteado = random.nextInt(MAX - MIN + 1) + MIN;
            int tentativas = 0;
            boolean acertou = false;

            System.out.println("Pense em um número entre " + MIN + " e " + MAX + ".");
            System.out.println("Você tem " + MAX_TENTATIVAS + " tentativas ");

            // Continua enquanto houver tentativas e o jogador ainda não tiver acertado.
            while (tentativas < MAX_TENTATIVAS && !acertou) {
                OptionalInt entradaPalpite = lerPalpite(scanner, MIN, MAX);
                if (!entradaPalpite.isPresent()) {
                    System.out.println("\nEntrada encerrada. Até a próxima!");
                    scanner.close();
                    return;
                }
                int palpite = entradaPalpite.getAsInt();
                tentativas++;

                if (palpite == sorteado) {
                    acertou = true;
                } else if (palpite < sorteado) {
                    // Dá uma dica e informa quantas tentativas ainda restam.
                    System.out.println("Maior! Restam " + (MAX_TENTATIVAS - tentativas) + " tentativas.");
                } else{
                    System.out.println("Menor! Restam " + (MAX_TENTATIVAS - tentativas) + " tentativas.");
                }
            }

            // Exibe o resultado da partida após acertar ou esgotar as tentativas.
            if (acertou) {
                String unidadeTentativa = tentativas == 1 ? "tentativa" : "tentativas";
                System.out.println("Parabéns! Você acertou o número em " + tentativas + " "
                        + unidadeTentativa + " de " + MAX_TENTATIVAS + ".");
            } else {
                System.out.println("Fim de jogo! O número era " + sorteado + ".");
            }

            // Aceita apenas "s" ou "n"; entradas inválidas não encerram o jogo por engano.
            while (true) {
                System.out.print("Jogar novamente? (s/n): ");
                if (!scanner.hasNextLine()) {
                    System.out.println("\nEntrada encerrada. Até a próxima!");
                    scanner.close();
                    return;
                }
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
                if (jogarNovamente.equals("s") || jogarNovamente.equals("n")) {
                    break;
                }
                System.out.println("Digite 's' para sim ou 'n' para não.");
            }
        } while (jogarNovamente.equals("s"));

        System.out.println("Até a próxima!");
        // Fecha a leitura da entrada ao encerrar o jogo.
        scanner.close();
    }
}
