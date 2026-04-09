package juegos_Nivel_1;

import java.util.Scanner;

public class AdivinaElNumero {
    private static int contadorIntentos = 0;
    public static void main(String[] args){
        //Variables del juego
        int numeroIntentos = 5;

        boolean ganado = false;

        //Limites del numero
        int min = 0;
        int max = 100;

        int numeroObjetivo = (int) Math.round(Math.random()*(max - min) + min);
        introduccionJuego();
        do{
            int numeroUsuario = pedirNumeroUsuario();
            if(numeroUsuario == numeroObjetivo){
                System.out.println("ACERTASTE!!!! El numero a adivinar era el: " + numeroObjetivo);
                ganado = true;
                break;
            }else{
                if(numeroUsuario < numeroObjetivo){
                    System.out.println("ERROR, no era ese PERO tu numero es mas pequeño que el objetivo");
                }else{
                    System.out.println("ERROR, no era ese PERO tu numero es mas grande que el objetivo");
                }
                contadorIntentos ++;
            }
        }while (contadorIntentos != numeroIntentos);
        if(!ganado){
            System.out.println("Mala suerte, Prueba mas tarde... El numero pensado era: " + numeroObjetivo);
        }
    }

    private static int pedirNumeroUsuario(){
        Scanner s = new Scanner(System.in);
        System.out.println("[" + contadorIntentos + "/5]Introduce el numero que creas que es el pensado: ");
        return s.nextInt();
    }

    private static void introduccionJuego(){
        System.out.println("-".repeat(40));
        System.out.println("ADIVINA EL NUMERO");
        System.out.println("-".repeat(40));
    }
}
