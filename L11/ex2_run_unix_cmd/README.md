# Executor de comenzi cu pipe-uri (Python)

## Descriere
Aplicația permite citirea de la tastatură a unei comenzi ce poate conține **pipe-uri** (`|`) și execută fiecare segment al comenzii într-un proces separat, legând stdout-ul unei comenzi la stdin-ul următoarei, simulând comportamentul unui shell.

### Cerințe esențiale
- Citirea unei comenzi complete de la tastatură.
- Separarea comenzii în subcomenzi individuale pe baza caracterului `|`.
- Executarea fiecărei comenzi într-un proces (`subprocess.Popen`).
- Legarea stdout-ului unei comenzi la stdin-ul următoarei.
- Colectarea și afișarea rezultatului final.

---

## Structura proiectului

project-root/
├── main.py
├── .idea/
└── .venv/

---

## Funcționalitate
1. Funcția `get_commands()` citește comanda de la tastatură și o împarte în subcomenzi.
2. Pentru fiecare subcomandă:
   - Prima subcomandă este lansată cu stdout redirecționat către pipe.
   - Comenzile următoare primesc stdin de la stdout-ul comenzii anterioare.
3. Se așteaptă ca ultima comandă să se finalizeze (`communicate()`) și se afișează rezultatul.

---

## Exemplu de rulare

Input:
ip a | grep inet | wc -l

Output:
3

- Comenzile sunt rulate secvențial, legând pipe-urile corespunzător.
- Rezultatul final al ultimei comenzi este afișat pe ecran.

---

## Execuție

Rularea programului:

```bash
python main.py
Se introduce comanda completă cu eventuale pipe-uri.

Programul procesează și afișează rezultatul final.
