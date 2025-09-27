# Lxx – Interfață Grafică cu Tkinter/PyQt și Procesare Multiproces

## Descriere
Proiectul implementează o aplicație grafică în Python (PyQt5) care:
- Încarcă un fișier text cu numere întregi.
- Convertește conținutul într-un format HTML simplu.
- Trimite datele către un program C printr-o coadă de mesaje System V IPC.

Partea de procesare în C primește mesajele din coadă și le afișează, putând fi extinsă cu funcționalități precum:
- filtrarea numerelor impare,
- filtrarea numerelor prime,
- sumarea elementelor.

Astfel se demonstrează comunicarea inter-proces între Python și C și integrarea GUI cu procese separate.

## Structura proiectului

├── html_converter.py # Aplicația principală Python (GUI + IPC)
├── html_converter.ui # Fișier UI pentru PyQt5
├── receiver.c # Program C care citește din coada de mesaje
├── venv/ # Mediu virtual Python (ignorat în .gitignore)
├── .idea/ # Configurații IDE (ignorat în .gitignore)


## Cum funcționează
- **GUI-ul**: permite selectarea unui fișier text și conversia lui în HTML.
- **Coada de mesaje**: trimite rezultatul HTML din Python către C.
- **Programul C**: primește datele din coadă și le afișează în consolă.

## Cerințe
- Python 3.x  
- PyQt5  
- sysv_ipc (pip install sysv_ipc)  
- GCC pentru compilarea programului C  

## Cum se rulează
1. **Configurează mediul Python**  
   ```bash
   python3 -m venv venv
   source venv/bin/activate   # Linux
   pip install PyQt5 sysv_ipc

    Compilează programul C

gcc receiver.c -o receiver

Rulează programul C într-un terminal separat

./receiver

Rulează aplicația Python

    python html_converter.py

    Pași în aplicație

        Selectează fișierul text cu numere.

        Apasă „Convert to HTML” pentru a-l transforma.

        Apasă „Send to C Program” pentru a trimite rezultatul prin coada de mesaje.

        Vezi rezultatul în terminalul unde rulează programul C.


