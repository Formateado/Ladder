package matriz_ladders;

//Solo puede haber un caracter por posicion de matriz

import java.util.Scanner;

public class Ladders {

  public static void start_ladder(int ladder) {
      if (ladder > 0 || ladder < 0) { //Si el número es mayor o menor a cero
          int ladder_election = ladder;
          if(ladder < 0){
              ladder = ladder * -1;
          }
          //En caso de que el número sea negativo se multiplicará por 1 para que no afecte a la matriz
          String matrizLadder[][] = new String[ladder + 1][ladder + 1]; //Crea la matriz en la que se almacenará la escalera
          //Le dará un valor por defecto a toda la matriz de nada para que no salte null
          for (int i = 0; i < ladder + 1; i++) {
              for (int j = 0; j < ladder + 1; j++) {
                  matrizLadder[i][j] = "  ";
              }
          }
          if (ladder_election > 0) { //Si el número leido es positivo
              int pipe = 1, barraBaja = 0; //pipe y barraBaja iran aumentando en el for para colocar en matriz "|" y "_"
              for (int i = ladder; i >= 0; i--) { // Este for es inversamente proporcional, mientras una posición baja la otra sube
                  matrizLadder[i][barraBaja] = "_";
                  if(i != 0){ // Este if indica que cuando el for llegue a 0 no siga colocando pipes ya que la escalera termina con "_"
                      matrizLadder[i][pipe] = "|";
                      pipe += 1;
                  }
                  barraBaja += 1;
              }
          } else {//Si el número leido es negativo
              int pipe = 1, barraBaja = 0; //pipe y barraBaja iran aumentando en el for para colocar en matriz "|" y "_"
              for(int i = 0; i <= ladder; i++){ // Este for es directamente proporcional, mientras una posición sube la otra también sube
                  matrizLadder[barraBaja][i] = "_";
                  if(i != ladder){ // Este if indica que cuando el for llegue a 0 no siga colocando pipes ya que la escalera termina con "_"
                      matrizLadder[pipe][i] = " |";
                      barraBaja += 1;
                  }
                  pipe += 1;
              }
          }
          //Pinta la escalera
          for(int i = 0; i < ladder + 1; i++){
              for(int j = 0; j < ladder + 1; j++){
                  System.out.print(matrizLadder[i][j]);
              }
              System.out.println(" ");
          }
      }else{ //Si el número es 0
              System.out.println("__");
      }
  }
  
  public static void main(String args[])  {
      Scanner in = new Scanner(System.in);
      System.out.println("Escribe la cantidad de escalones que quieres que tenga tu escalera");
      //Leerá la cantidad de escalones que quieres que tenga
      int num_ladder = in.nextInt();
      start_ladder(num_ladder);
  }
}