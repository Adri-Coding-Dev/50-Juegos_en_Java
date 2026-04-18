package juegos_Nivel_1;

import java.util.Random;
import java.util.Scanner;

public class _3_TresEnRaya {
    //Variables
    static char[][] tablero = new char[3][3];
    static boolean turnoMaquina;
    static boolean ganaMaquina = false;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args){
        inicioJuego();
        iniciarTablero();

        turnoMaquina = primerTurnoMaquina();

        System.out.println(turnoMaquina ? "EMPIEZA LA MAQUINA - X" : "EMPIEZA EL HUMANO - O");

        while(true){
            mostrarTableroActual();
            System.out.println(turnoMaquina ? "TURNO MAQUINA" : "TURNO HUMANO");
            realizarMovimiento(turnoMaquina);

            if(verificarVictoria()){
                mostrarTableroActual();
                System.out.println(turnoMaquina ? "GANA LA MAQUINA" : "GANA EL HUMANO");
                break;
            }
            if(tableroLleno()){
                mostrarTableroActual();
                System.out.println("EMPATE");
                break;
            }
            turnoMaquina = !turnoMaquina;
        }
    }

    private static boolean verificarVictoria(){
        char simbolo = turnoMaquina ? 'X' : 'O';
        //Filas y columnas
        for(int i = 0; i < 3; i ++){
            if((tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) ||
                    (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo)){
                ganaMaquina = turnoMaquina;
                return true;
            }
        }

        //Diagonales
        if((tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) ||
                (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo)){
            ganaMaquina = turnoMaquina;
            return true;
        }
        return false;
    }

    private static boolean tableroLleno(){
        for(char[] fila : tablero){
            for(char c : fila){
                if(c == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    private static void mostrarTableroActual(){
        System.out.println("-".repeat(15));
        for(char[] fila : tablero){
            for(char c : fila){
                System.out.print("| " + c + " |");
            }
            System.out.println();
        }

        System.out.println("-".repeat(15));
    }

    private static void realizarMovimiento(boolean turnoMaquina){
        int posX, posY;

        if(turnoMaquina){
            //Generar movimiento aleatorio
            do{
                posX = rand.nextInt(tablero.length);
                posY = rand.nextInt(tablero.length);
            }while (!colocarFigura(posX, posY, true));
        }else{
            //Humano elige
            do{
                System.out.println("Movimiento a elegir: ");
                System.out.print("X (0-2): ");
                posX = sc.nextInt();
                System.out.print("Y (0-2): ");
                posY = sc.nextInt();
            }while (!colocarFigura(posX, posY, false));

        }
    }

    private static boolean colocarFigura(int posX, int posY, boolean maquina){
        if(tablero[posX][posY] == ' '){
            tablero[posX][posY] = maquina ? 'X' : 'O';
            return true;
        }
        return false;
    }

    private static void iniciarTablero(){
        for(int col = 0; col < tablero.length; col++){
            for(int row = 0; row < tablero[0].length; row++){
                tablero[col][row] = ' ';
            }
        }
    }

    private static boolean primerTurnoMaquina(){
        return rand.nextBoolean();
    }

    private static void inicioJuego(){
        System.out.println("-".repeat(40));
        System.out.println("TRES EN RAYA");
        System.out.println("-".repeat(40));
    }
}
