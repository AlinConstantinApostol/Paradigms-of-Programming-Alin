# Vending Machine STM - Automat de sucuri (Finite State Machine + Observer)

## Descriere
Proiectul implementează un automat de sucuri compus din mai multe mașini de stări finite (STM) coordonate de o entitate centrală:

- **TakeMoneySTM** — automatul pentru introducerea banilor (gestionarea stării `WaitingForClient` și `InsertMoney`).
- **SelectProductSTM** — automatul pentru selectarea produsului (stări pentru `CocaCola`, `Pepsi`, `Sprite`, etc.).
- **VendingMachineSTM** — entitatea centrală care coordonează tranzacția (sumă introdusă, validare, returnare rest).

Se folosește și **modelul observator (Observer)** pentru:
- afișarea la consolă a sumei introduse de fiecare dată când aceasta este actualizată (observator atasat la `TakeMoneySTM`);
- notificarea lui `VendingMachineSTM` când un produs este selectat, pentru a valida tranzacția.

## Structura proiectului

```
STM/
├── __init__.py
├── main.py
├── Observable.py
├── SelectProduct.py
├── SelectProductSTM.py
├── TakeMoneySTM.py
├── VendingMachineSTM.py
├── WaitingForClient.py
.venv/
.idea/
```

## Componente principale

### Observable.py
Clasa de bază pentru modelul observator. Permite atașarea, detașarea și notificarea observatorilor.

### TakeMoneySTM.py
- Gestionează stările legate de primirea banilor.
- Păstrează suma curentă (`money`) și actualizează starea (`WaitingForClient` ↔ `InsertMoney`).
- Notifică observatorii când suma se actualizează.

### WaitingForClient.py
- Definirea stării `WaitingForClient` și a stării `InsertMoney` cu metode pentru inserarea diferitelor valori (ex.: `insert_50bani`, `insert_1leu`, `insert_5lei`).

### SelectProduct.py / SelectProductSTM.py
- Modelează produsele disponibile (`CocaCola`, `Pepsi`, `Sprite`) și logica de alegere a unui produs.
- `SelectProductSTM` menține stările și permite trecerea la starea corespunzătoare produsului ales.

### VendingMachineSTM.py
- Coordonează `TakeMoneySTM` și `SelectProductSTM`.
- Primește notificări de la observator și validează tranzacția (dacă suma introdusă acoperă prețul produsului).
- Decide între returnarea restului sau permisiunea de a selecta alt produs.

### main.py
- Punctul de intrare al aplicației; inițializează mașinile de stări, atașează observatorii și pornește interacțiunea cu utilizatorul.

## Funcționare (exemplu de utilizare)
1. Pornești aplicația:
```bash
python STM/main.py
```

2. Flux tipic:
- Utilizatorul ajunge la automat → `WaitingForClient`.
- Utilizatorul introduce bani (ex.: `insert_1leu`, `insert_5lei`) → `TakeMoneySTM` actualizează suma și notifică observatorii (mesaj în consolă cu suma curentă).
- Utilizatorul selectează produsul → `SelectProductSTM` stabilește produsul selectat și notifică `VendingMachineSTM`.
- `VendingMachineSTM` validează tranzacția comparând suma introdusă cu prețul produsului:
  - dacă suma e suficientă → livrare produs + opțiune returnare rest;
  - dacă nu e suficientă → solicitare de introducere bani suplimentari sau posibilitatea de a alege alt produs.

## Detectare și extindere
- Pentru a adăuga produse noi: definiți o clasă pentru produs în `SelectProduct.py` și adăugați starea corespunzătoare în `SelectProductSTM`.
- Pentru a adăuga noi bilete/monede: implementați metode suplimentare în `WaitingForClient/InsertMoney` și asigurați actualizarea sumei în `TakeMoneySTM`.

## Dependențe și rulare
- Limbaj: Python 3.x
- Nu sunt dependențe externe specifice; folosiți mediul virtual (`.venv`) dacă doriți.
- Rulare:
```bash
python STM/main.py
```

