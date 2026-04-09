package juegos_Nivel_1;

import java.util.Scanner;

public class PiedraPapelTijera {
    private static int cantidadRounds = 3;
    private static int contadorRounds = 0;

    private static int contadorVictoriasMaquina = 0;
    private static int contadorVictoriasUsuario = 0;
    public static void main(String[] args){
        //Variables
        boolean usuarioGana = false;
        boolean maquinaGana = false;
        iniciarJuego();
        do{
            int eleccionMaquina = eleccionMaquina();
            int eleccionUsuario = eleccionUsuario();
            determinarGandor(eleccionMaquina,eleccionUsuario);
            contadorRounds ++;
            mostarStats();
        }while(contadorVictoriasMaquina != cantidadRounds && contadorVictoriasUsuario != cantidadRounds);
        if(contadorVictoriasUsuario > contadorVictoriasMaquina){
            System.out.println("Victoria para el Usuario!!!");
        }else{
            System.out.println("Victoria para la Maquina!!!");
        }
    }
    private static void mostarStats(){
        System.out.println("-".repeat(40));
        System.out.println("CANTIDAD DE VICTORIAS USUARIO: " + contadorVictoriasUsuario);
        System.out.println("CANTIDAD DE VICTORIAS MAQUINA: " + contadorVictoriasMaquina);
        System.out.println("-".repeat(40));
    }

    private static void determinarGandor(int eleccionMaquina, int eleccionUsuario){
        // Piedra(1) > Tijera(3)
        //Tijera(3) > Papel(2)
        //Papel(2) > Piedra(1)
        boolean ganaMaquina = compararMovimientos(eleccionMaquina, eleccionUsuario);
        boolean ganaUsuario = compararMovimientos(eleccionUsuario, eleccionMaquina);

        if(ganaMaquina){
            contadorVictoriasMaquina++;
            System.out.println("Gana Maquina. Victorias actuales: " + contadorVictoriasMaquina);
        }else if(ganaUsuario){
            contadorVictoriasUsuario++;
            System.out.println("Gana Usuario. Victorias actuales: " + contadorVictoriasUsuario);
        }else{
            System.out.println("EMPATE");
        }
    }

    private static boolean compararMovimientos(int miMovimiento, int otroMovimiento){
        if((miMovimiento == 1 && otroMovimiento == 3) || (miMovimiento == 3 && otroMovimiento == 2) || (miMovimiento == 2 && otroMovimiento == 1)){
            return true;
        }else {
            return false;
        }
    }

    private static int eleccionMaquina(){
        return (int) Math.round(Math.random()*(3 - 1) + 1);
    }

    private static int eleccionUsuario(){
        Scanner s = new Scanner(System.in);
        System.out.println("[Round: " + contadorRounds + "] Elije la tirada de esta ronda: ");
        System.out.println("[1] Piedra - [2] Papel - [3] Tijeras");
        return s.nextInt();
    }

    private static void iniciarJuego(){
        System.out.println("-".repeat(40));
        System.out.println("PIEDRA-PAPEL-TIJERA");
        System.out.println("-".repeat(40));
    }
}
