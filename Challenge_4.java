import java.util.*;

public class Challenge_4 {
    
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String banner = """
        
        ██████╗ ██╗     ███████╗███████╗██╗    ██╗ █████╗ ██████╗ ███████╗
        ██╔══██╗██║     ██╔════╝██╔════╝██║    ██║██╔══██╗██╔══██╗██╔════╝
        ██████╔╝██║     █████╗  ███████╗██║ █╗ ██║███████║██████╔╝█████╗  
        ██╔══██╗██║     ██╔══╝  ╚════██║██║███╗██║██╔══██║██╔══██╗██╔══╝  
        ██████╔╝███████╗███████╗███████║╚███╔███╔╝██║  ██║██║  ██║███████╗
        ╚═════╝ ╚══════╝╚══════╝╚══════╝ ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝

        Desafio semana 4 de Codember v1.0

        (En Windows presiona Ctrl + Z en una nueva línea para terminar de leer)
        (En Linux Ctrl + D en una nueva línea para terminar de leer)

        Ingresa un texto:""";

        System.out.println(banner);

        //Se lee el texto línea por línea hasta que se ingrese Ctrl + Z para finalizar
        StringBuilder texto = new StringBuilder();
        
        while (input.hasNextLine()) {

            texto.append(input.nextLine());
            texto.append("\n"); // Agregar un salto de línea después de cada línea ingresada
        }

        String textKeys = texto.toString().trim();        

        //Dividir el texto por saltos de línea
        String[] lineas = textKeys.split("\n");

        String[] checksumValid = new String[lineas.length];

        int validCounter = 0;

        for(int i = 0; i < lineas.length; i++) {

            for(int j = 0; j < lineas[i].length(); j++) {
                
                if(String.valueOf(lineas[i].charAt(j)).equals("-")) {
                    
                    String alfa = lineas[i].substring(0, j);
                    String checksum = lineas[i].substring((j + 1), lineas[i].length());
                    String check = "";                    
                    
                    ArrayList<Character> uniqueCharacters = new ArrayList<>();
                    Map<Character, Integer> charCount = new HashMap<>();

                    //Contar la frecuencia de cada carácter
                    for (char c : alfa.toCharArray()) {

                        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                    }

                    //Almacenar los caracteres que aparecen una sola vez
                    for (char c : alfa.toCharArray()) {

                        if (charCount.get(c) == 1) {

                            uniqueCharacters.add(c);
                        }
                    }                    

                    //Obtener el checksum real del String
                    for (char c : uniqueCharacters) {

                        check = check + String.valueOf(c);
                    }

                    //Verificar si el checksum es igual al dado originalmente
                    if(checksum.equals(check)) {                        

                        checksumValid[validCounter] = check;
                        validCounter++;
                    }                                    
                }                
            }            
        }

        try {
                        
            System.out.println("\nEl checksum valido numero 33 es: " + checksumValid[32] + "\n");            

        } catch (Exception e) {
            
            System.out.println("\nNo hay 33 checksums en el texto dado anteriormente\n");
        }        
    }
}
