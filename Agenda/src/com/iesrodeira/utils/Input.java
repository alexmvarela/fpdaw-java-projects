package com.iesrodeira.utils;

import java.util.Scanner;

public class Input {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void testNif(String nif) throws IllegalArgumentException {
        // Validación del formato
        if (nif == null || !nif.matches("^[0-9]{8}[A-Za-z]$")) {
            throw new IllegalArgumentException("El Nif introducido no es válido: formato incorrecto.");
        }
        
        // Validación de la letra
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(nif.substring(0, 8));
        char letraCorrecta = letras.charAt(numero % 23);
        char letraInput = nif.toUpperCase().charAt(8);

        if (letraInput != letraCorrecta) {
            throw new IllegalArgumentException("El Nif introducido no es válido: letra incorrecta.");
        }
    }
    
    public static void testEmail(String email) throws IllegalArgumentException {
        if (email == null || !email.matches("^[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z]{2,3}$")) {
            throw new IllegalArgumentException("El email introducido no es válido.");
        }
    }
    
    public static void testPhone(String phone) throws IllegalArgumentException {
        if (phone == null || !phone.matches("^(\\+[0-9]{2})?[0-9]{9}$")) {
            throw new IllegalArgumentException("El teléfono introducido no es válido.");
        }
    }
    
    public static String readText(String title) throws CancelException {
        System.out.println(title + " (* para cancelar):");
        String input = scanner.nextLine();
        
        if (input.equals("*")) {
            throw new CancelException("Entrada cancelada por el usuario");
        }
        
        return input;
    }
    
    public static String readText(String title, String defaultInput) throws CancelException {
        System.out.println(title + " (* para cancelar):");
        String input = scanner.nextLine();
        
        if (input.equals("*")) {
            throw new CancelException("Entrada cancelada por el usuario");
        }
        
        if (input.isEmpty()) {
            input = defaultInput;
        }
        
        return input;
    }
    
    public static String readNif(String title) throws CancelException {
        String input = "";
        boolean esValido = false;
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();

            if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            }

            try {
                testNif(input);
                esValido = true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!esValido);
         
        return input;
    }
    
    public static String readPhone(String title) throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            }
            
            try {
                testPhone(input);
                esValido = true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!esValido);
        
        return input;
    }
    
    public static String readPhone(String title, String defaultInput) throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.isEmpty()) {
                input = defaultInput;
                esValido = true;
            } else if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            } else {
                try {
                    testPhone(input);
                    esValido = true;
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!esValido);
        
        return input;
    }
    
    public static String readEmail(String title) throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            }
            
            try {
                testEmail(input);
                esValido = true;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!esValido);
        
        return input; 
    }
    
    public static String readEmail(String title, String defaultInput) throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.isEmpty()) {
                input = defaultInput;
                esValido = true;
            } else if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            } else {
                try {
                    testEmail(input);
                    esValido = true;
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } while (!esValido);
        
        return input;
    }
    
    public static String option(String title,String validos) throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println(title + " (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            }
                
            if (input.length() == 1 && validos.toLowerCase().contains(input.toLowerCase())) {
                esValido = true;
            } else {
                System.out.println("La opción introducida no es válida.");
            }
        } while (!esValido);
        
        return input; 
    }
    
    public static boolean areYouSure() throws CancelException {
        String input = "";
        boolean esValido = false;
        
        do {
            System.out.println("¿Estás seguro? (S/N) (* para cancelar):");
            input = scanner.nextLine();
            
            if (input.equals("*")) {
                throw new CancelException("Entrada cancelada por el usuario");
            }
            
            if (input.equalsIgnoreCase("S") || input.equalsIgnoreCase("N")) {
                esValido = true;
            } else {
                System.out.println("La opción introducida no es válida.");
            }
        } while (!esValido);
        
        return input.equalsIgnoreCase("S");
    }
    
    public static boolean waitEnter(String message) {
        System.out.println(message);
        scanner.nextLine();
        return true;
        
    }
        
    public static boolean waitEnter() {
        System.out.println("Para continuar pulsa Enter");
        scanner.nextLine();
        return true;
    }
}