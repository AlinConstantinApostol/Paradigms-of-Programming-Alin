Tic-Tac-Toe P2P – Laborator Paradigms of Programming
Descriere proiect

Acest proiect implementează un joc Tic-Tac-Toe pentru doi jucători în regim peer-to-peer folosind PySide6 (Qt) și cozi de mesaje System-V.

Funcționalități principale:

Interfață grafică cu PySide6/Qt (grid 3x3 de butoane + câmp pentru afișarea informațiilor).

Joc P2P pentru doi jucători care comunică printr-o coadă de mesaje.

Fiecare jucător își introduce numărul (1 sau 2) la pornirea jocului.

Mutările sunt transmise și primite prin coada de mesaje, astfel încât starea jocului să fie sincronizată între instanțele celor doi jucători.

Verificarea câștigătorului și a egalului în joc.

Posibilitate de extindere pentru salvarea scorului în SQLite (în prezent, codul nu gestionează baza de date).

Structura proiectului
Pași de utilizare

Creează mediul virtual și instalează dependențele:
python -m venv venv
source venv/bin/activate   # Linux/macOS
venv\Scripts\activate      # Windows
pip install PySide6 sysv_ipc

Rulează două instanțe ale jocului (una pentru Player 1, alta pentru Player 2):

python mainwindow.py

Introduceți numărul jucătorului și începeți jocul.
