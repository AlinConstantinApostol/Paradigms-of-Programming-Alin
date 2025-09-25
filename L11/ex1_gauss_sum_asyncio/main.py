from collections import deque  # Importam deque pentru a crea o coada (FIFO sau LIFO)
import asyncio  # Importam modulul asyncio pentru programare asincrona


# Definim o functie asincrona care calculeaza suma Gauss pana la n
async def gauss_summation(task_nr, n):
    suma = 0
    for i in range(0, n + 1):
        await asyncio.sleep(0.1)  # Simulam o intarziere asincrona
        suma += i  # Adaugam valoarea i la suma
    print("TASK", task_nr, ": S(", n, ") = ", suma, "\n")  # Afisam rezultatul
    return suma  # Returnam suma calculata


# Functia principala asincrona
async def main():
    queue = deque()  # Cream o coada de tip deque

    # Adaugam patru valori in coada
    queue.append(5)
    queue.append(7)
    queue.append(12)
    queue.append(15)

    # Rulam cele patru corutine in paralel folosind asyncio.gather
    await asyncio.gather(
        gauss_summation("A", queue.pop()),  # Scoatem ultimul element din coada si il trimitem corutinei
        gauss_summation("B", queue.pop()),
        gauss_summation("C", queue.pop()),
        gauss_summation("D", queue.pop())
    )


# Daca scriptul este rulat direct, pornim bucla de evenimente asyncio
if __name__ == '__main__':
    asyncio.run(main())  # Rulam functia main asincron
