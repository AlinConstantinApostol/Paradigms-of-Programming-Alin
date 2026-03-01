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
