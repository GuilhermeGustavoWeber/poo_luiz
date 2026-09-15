import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int altitude = 0;
        double velocidade = 0.0;
        boolean altitudeValida = false;
        boolean velocidadeValida = false;

        System.out.println("=== PAINEL DE CONTROLO DO DRONE ===");

        while (!altitudeValida) {
            try {
                System.out.println("\nDigite a altitude desejada (0 a 120m):");
                System.out.print("> ");
                altitude = scanner.nextInt();
                if (altitude < 0 || altitude > 120) {
                    throw new IllegalArgumentException("O limite máximo é 120 metros.");
                }
                altitudeValida = true;
                System.out.println("Altitude aceite. Digite a velocidade (0 a 60 km/h):");

            } catch (InputMismatchException e) {
                System.out.println("[ALERTA CRÍTICO] Falha de comunicação: " + "Digite apenas números! Pouso de emergência evitado.");
                scanner.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println("[ALERTA DE SEGURANÇA] Altitude inválida: " + e.getMessage());
            }
        }

        while (!velocidadeValida) {
            try {
                System.out.print("> ");
                velocidade = scanner.nextDouble();
                if (velocidade < 0.0 || velocidade > 60.0) {
                    throw new IllegalArgumentException(
                            "A velocidade deve estar entre 0 e 60 km/h."
                    );
                }
                velocidadeValida = true;
                System.out.println("[SUCESSO] Dados validados. Drone em rota!");

            } catch (InputMismatchException e) {
                System.out.println(
                        "[ALERTA CRÍTICO] Falha de comunicação: " +
                                "Digite apenas números! Pouso de emergência evitado."
                );
                scanner.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println(
                        "[ALERTA DE SEGURANÇA] Velocidade inválida: " +
                                e.getMessage()
                );
            }
        }
        scanner.close();
    }
}
