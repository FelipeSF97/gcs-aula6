import java.util.Scanner;
import java.util.HashSet;

public class JogoForca {
    public static void main (String[] args) {
        System.out.println("===============");
        System.out.println(" Jogo da Forca ");
        System.out.println("===============");

        Scanner in = new Scanner(System.in);

        // Configurar jogo
        String[] bancoPalavras = {
            "ABACATE",
            "MANGA",
            "MELANCIA",
            "JABUTICABA",
            "BANANA",
            "PESSEGO",
        };

        int indicePalavraSorteada = 2;
        int chancesRestantes = 10;
        String palavraSorteada = bancoPalavras[indicePalavraSorteada];
        int tamPalavraSorteada = palavraSorteada.length();
        char[] letrasEscondidas = palavraSorteada.toCharArray();
        char[] letrasReveladas = new char[tamPalavraSorteada];
        for (int i = 0; i < tamPalavraSorteada; i++) {
            letrasReveladas[i] = '?';
        }

        HashSet<Character> letrasUsadas = new HashSet<>();

		// Loop do jogo
        while (chancesRestantes > 0) {
            System.out.println("\nChances restantes: " + chancesRestantes);
            
            // Mostra letras ja reveladas
            for (int i = 0; i < tamPalavraSorteada; i++) {
                System.out.print(letrasReveladas[i]);
            }
            System.out.println(); // quebra a linha

            // Solicita letra do usuario
            System.out.print("Letra: ");
            String strLetraDigitada = in.nextLine();
            char letraDigitada = strLetraDigitada.toUpperCase().charAt(0);


            // Revela letras, se existirem.
            boolean letraEncontrada = false;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasEscondidas[i] == letraDigitada) {
                    letraEncontrada = true;
                    letrasReveladas[i] = letrasEscondidas[i];
                }
            }
            
			// Reduz nro de chances se letra digitada nao existir.
            if (!letraEncontrada) {
                chancesRestantes--;
            }

            // Verifica se o jogo acabou
            boolean venceu = true;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasReveladas[i] == '?') {
                    venceu = false;
                    break;
                }
            }
            if (venceu) {
                System.out.println("Parabens, voce venceu!");
                break;
            }
            if (letrasUsadas.contains(letraDigitada)) {
                System.out.println("Você já tentou essa letra.");
                continue;
            }
            letrasUsadas.add(letraDigitada);
            if (strLetraDigitada.length() != 1) {
                System.out.println("Digite apenas uma letra!");
                continue;
            }
            
        }
        System.out.println("===========");
        System.out.println(" Game Over ");
        System.out.println("===========");

    }



}