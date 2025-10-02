> # Calcul simultan cu corutine (asyncio)

## Descriere
Aplicația realizează calculul simultan al sumei Gauss pentru patru valori diferite ale lui `n` preluate dintr-o coadă (`deque`). Fiecare calcul este efectuat de o **corutină** separată, utilizând modulul `asyncio` pentru programare asincronă.

### Cerințe esențiale
- Se folosesc patru corutine care preiau valorile din coadă.
- Fiecare corutină calculează suma Gauss `S(n) = 0 + 1 + 2 + ... + n`.
- Se utilizează `await asyncio.sleep(...)` pentru a simula întârzieri de procesare.
- Rezultatele sunt afișate în paralel, fără blocarea execuției.

---

## Structura proiectului

project-root/
├── main.py
├── .idea/
└── .venv/
> 
---

## Funcționalitate
1. Se creează o **coadă** cu patru valori de test.
2. Fiecare valoare este preluată de câte o corutină.
3. Corutinele calculează simultan suma Gauss pentru valorile respective.
4. Rezultatele sunt afișate pe ecran pe măsură ce fiecare corutină finalizează calculul.

---

## Funcții principale
- `async def gauss_summation(task_nr, n)`  
  Calculează suma Gauss pentru `n` și afișează rezultatul împreună cu identificatorul task-ului.

- `async def main()`  
  Creează coada cu valori, lansează cele patru corutine și așteaptă finalizarea lor folosind `asyncio.gather`.

---

python main.pymului se face astfel:
> Rezultatele vor fi afișate sub formă:
> TASK A : S(15) = 120
TASK B : S(12) = 78
TASK C : S(7) = 28
TASK D : S(5) = 15
Numerele și ordinea pot varia, corutinele rulând simultan.

