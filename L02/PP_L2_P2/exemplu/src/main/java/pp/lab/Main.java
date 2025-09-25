package pp.lab;

import java.io.*; // lucru cu fisiere si liste
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>(); // lista goala pentru valori de pe axa X
        List<Integer> y = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            x.add(i);
            y.add(2 * i);
        }

        System.out.println("x: " + x);
        System.out.println("y: " + y);

        try {
            // Creeaza fisierul Python
            File scriptFile = new File("regression_plot.py"); // obiect File care face referire la fisierul 
                                                                       // regression_plot.py
                                                                       // efectueaza operatiuni pe fisier
            FileWriter writer = new FileWriter(scriptFile); // scire continutul codului Python intr-un fisier pe disk
            writer.write(getPythonScript());
            writer.close();

            // Construieste comanda pentru a rula scriptul Python
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/python3", "regression_plot.py");
            // proces care executa scriptul regression_plot.py cu python3
            pb.redirectErrorStream(true);
            // redirectioneaza erorile pentru a fi vizibile in consola
            Process process = pb.start();
            // porneste procesul

            // Citeste output-ul scriptului Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            System.out.println("Graficul a fost salvat ca 'plot_regresie.png'");
            // acest bloc citeste si afiseaza orice output generat de codul Python
            // adica procesul de generare a graficului
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getPythonScript() {
        return """
                import matplotlib.pyplot as plt
                import numpy as np
                
                # Definirea datelor
                x = np.array([1,2,3,4,5,6,7,8,9,10])
                y = np.array([2,4,6,8,10,12,14,16,18,20])
                
                # Calcul regresie liniara
                coef = np.polyfit(x, y, 1)  # Panta si interceptul
                a, b = coef  # a = panta, b = interceptul, valoarea lui y cand x = 0
                # am considerat ca variabila independata este x si cea dependenta y
                # deci y este ce prezicem, x este valoarea independenta, datele de la care pornim
                # deci avem o relatie y = a * x + b, notata y_pred
                
                # Generare valori pentru linia de regresie
                y_pred = a * x + b
                
                # Plotare
                plt.figure(figsize=(8,6)) 
                plt.scatter(x, y, color='red', label='Date originale') # afiseaza datele originale ca puncte rosii
                plt.plot(x, y_pred, color='blue', linestyle='--', label=f'Regresie: y = {a:.2f}x + {b:.2f}') # traseaza linia de regresie
                plt.xlabel('x')
                plt.ylabel('y')
                plt.title('Regresie Liniara')
                plt.legend()
                plt.savefig('plot_regresie.png') # salveaza graficl intr-un fisier PNG cu numele respectiv
                plt.show()
                """;
    }
}
