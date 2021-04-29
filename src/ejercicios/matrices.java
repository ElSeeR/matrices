package ejercicios;
import java.util.Scanner;

public class matrices {
static int matrizA[][];
static int matrizB[][];
static int matrizResultado[][];
static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean salir = false;
		int opcion, filas, columnas;
		 
		 while(!salir){
			   System.out.println("Seleccione la operación");
	           System.out.println("1. Suma de dos matrices");
	           System.out.println("2. Producto de un escalar por una matriz");
	           System.out.println("3. Producto de dos matrices");
	           System.out.println("4. Transponer una matriz");
	           System.out.println("5. Diagonal principal de una matriz");
	           System.out.println("6. Comprobar si una matriz es simétrica");
	           System.out.println("7. Potencia de una matriz cuadrada");
	           System.out.println("8. Resta de dos matrices");
	           System.out.println("9. Salir");
	           System.out.println("-------------------------------------------");
	           opcion = sc.nextInt();
	       
	           switch(opcion){
               case 1: //Suma
                   introducirMatriz(1);
                   matrizResultado = matrizA;
                    for (int i = 0; i < matrizA.length; i++) {
                    	for (int j = 0; j < matrizA[i].length; j++) {
                    		matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
                    	}
           			}
                    
                    System.out.println("RESULTADO:");
                   pintaMatriz(matrizResultado);
                   
                   System.out.println("-------------------------------------------");
                   break;
                   
               case 2: //Producto de un escalar por una matriz
            	   System.out.println("Introduce un escalar:");
            	   	int escalar = sc.nextInt();
            	   	introducirMatriz(3);
            	   	matrizResultado = matrizA;
            	   	for (int i = 0; i < matrizA.length; i++) {
                    	for (int j = 0; j < matrizA[i].length; j++) {
                    		matrizResultado[i][j] = escalar * (matrizA[i][j]);
                    	}
           			}
                    
                    System.out.println("RESULTADO:");
                    pintaMatriz(matrizResultado);
                   
                   System.out.println("-------------------------------------------");
                   break;
                   
                case 3: //Producto de dos matrices
                	introducirMatriz(2);
                	
                	multiplicaMatriz();
                	 
                	 System.out.println("RESULTADO:");
                     pintaMatriz(matrizResultado);
                     
                   System.out.println("-------------------------------------------");
                   break;
                   
                case 4: //Transponer una matriz
                    introducirMatriz(3);
                    filas = matrizA.length;
                    columnas = matrizA[0].length;
                	matrizResultado = new int[columnas][filas];
                	
                	for (int i = 0; i < filas; i++) {
                    	for (int j = 0; j < columnas; j++) {
                    		matrizResultado[j][i] = matrizA[i][j];
                    	}
           			}
                	
                	System.out.println("RESULTADO:");
                	pintaMatriz(matrizResultado);
                	
                    System.out.println("-------------------------------------------");
                    break;
                    
                case 5: //Diagonal principal de una matriz
                	introducirMatriz(4);
                    filas = matrizA.length;
                    columnas = matrizA[0].length;
                    matrizResultado = new int[1][filas];
                    
                    for (int i = 0; i < filas; i++) {
                    	for (int j = 0; j < columnas; j++) {
                    		if (i == j) {
                    			matrizResultado[0][i] = matrizA[i][j];
                    		}
                    	}
           			}
                    System.out.println("RESULTADO:");
                	pintaMatriz(matrizResultado);
                    System.out.println("-------------------------------------------");
                    break;
                    
                case 6: //Comprobar si una matriz es simétrica
                	introducirMatriz(4);
                    filas = matrizA.length;
                    columnas = matrizA[0].length;
                    boolean simetrica = true;
                    
                    for (int i = 0; i < filas; i++) {
                    	for (int j = 0; j < columnas; j++) {
                    		if (matrizA[i][j] != matrizA[j][i]) {
                    			 simetrica = false;
                    		}
                    		
                    	}
           			}
                    if (!simetrica) {
                    	System.out.println("No es simétrica");
                    }
                    else {
                    	System.out.println("Sí es simétrica");
                    }
                    
                    System.out.println("-------------------------------------------");
                    break;
                    
                case 7: //Potencia de una matriz cuadrada
                	introducirMatriz(4);
                    System.out.println("Introduce un exponente: ");
                    int exp = sc.nextInt();
                    matrizB = matrizA;
                    for(int i=1;i<exp;i++) {
                    	multiplicaMatriz();
                    	matrizA = matrizResultado;
                    }
                    
                	System.out.println("RESULTADO:");
                    pintaMatriz(matrizResultado);
                	System.out.println("-------------------------------------------");
                    break;
                    
                case 8: //Resta de dos matrices
                	 introducirMatriz(1);
                     matrizResultado = matrizA;
                      for (int i = 0; i < matrizA.length; i++) {
                      	for (int j = 0; j < matrizA[i].length; j++) {
                      		matrizResultado[i][j] = matrizA[i][j] + (-(matrizB[i][j]));
                      	}
             		  }
                      
                      System.out.println("RESULTADO:");
                     pintaMatriz(matrizResultado);
                     
                    System.out.println("-------------------------------------------");
                    break;
                case 9:
                	 salir=true;
                     break;
                default:
                   System.out.println("Introduzca un número del 1 al 9");
                   System.out.println("-------------------------------------------");
                  
	           }
	       }
	}
	public static void introducirMatriz (int condicion) {
		//Valores condición: 0 - Normal  1 - Suma  2 - Producto  3 - Una matriz  4 - A Cuadrada
		boolean repetir;
		int fA = 0, cA = 0, cB = 0, fB = 0;
		
		do {
			repetir = false;
		System.out.println("Introduce el número de filas de A");
			fA = sc.nextInt();
				
		System.out.println("Introduce el número de columnas de A");
			cA = sc.nextInt();
		if (condicion != 3 && condicion != 4) {
		System.out.println("Introduce el número de filas de B");
			fB = sc.nextInt();
			
		System.out.println("Introduce el número de columnas de B");
			cB = sc.nextInt();
		}
			matrizA = new int[fA][cA];
			matrizB = new int[fB][cB];
			if (condicion == 1) {
				if (fA != fB || cA != cB) {
					System.out.println("Las dimensiones de A tienen que ser iguales a las dimensiones de B");
					repetir = true;
				}
				
			}
			if (condicion == 2) {
				if(cA != fB) {
					System.out.println("Las columnas de A tienen que ser iguales a las filas de B");
					repetir = true;
				}
				
			}
			
			if (condicion == 4) {
				if(cA != fA) {
					System.out.println("Las columnas de A tienen que ser iguales a las filas de A");
					repetir = true;
				}
				
			}
			
		} while(repetir);
		
		
		rellenaMatriz(fA, cA, matrizA);
		System.out.println("MATRIZ A:");
		pintaMatriz(matrizA);
		if (condicion != 3 && condicion != 4) {
			rellenaMatriz(fB, cB, matrizB);
			System.out.println("MATRIZ B:");
			pintaMatriz(matrizB);
		}
		
	}
	public static void rellenaMatriz(int filas, int columnas, int matriz[][]) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = (int) (Math.random()*10);
			}
		}
	}
	
	public static void pintaMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void multiplicaMatriz() {
		int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int filasb = matrizB.length;
        
        matrizResultado = new int[columnas][filasb];
        
    	 for (int a = 0; a < filasb; a++) {
             for (int i = 0; i < filas; i++) {
                 int suma = 0;
                 for (int j = 0; j < columnas; j++) {
                     
                     suma += matrizA[i][j] * matrizB[j][a];
                 }
                 matrizResultado[i][a] = suma;
             }
         }
	}
	
	
}
