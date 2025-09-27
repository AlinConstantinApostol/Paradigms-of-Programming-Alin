File Type Detector – Laborator Paradigms of Programming
Descriere proiect

Acest proiect implementează o aplicație care detectează tipul fișierelor dintr-un director dat, indiferent de extensia lor, pe baza frecvenței caracterelor din conținut.

Tipurile de fișiere detectate:

Text ASCII/UTF-8 – frecvențe mari pentru caractere între 9, 10, 13 și 32–127; frecvențe foarte mici pentru caractere control (0–8, 11, 12, 14–31, 128–255)

Text UNICODE/UTF-16 – caracterul 0 apare în cel puțin 30% din text

Binar – distribuție uniformă a frecvențelor între 0–255

XML – fișiere ASCII cu tag-uri XML

BMP – fișiere binare cu dimensiuni și bits-per-pixel extrase din header

Structura proiectului
FileTypeDetector/
│
├── main.py                  # Script principal pentru scanarea directorului și clasificarea fișierelor
├── filetype.py              # Clasele pentru fiecare tip de fișier (GenericFile, TextASCII, TextUNICODE, Binary, XMLFile, BMP)
├── filesToParse/            # Directorul cu fișierele test
│   ├── file.xml
│   ├── file02.txt
│   ├── sample_1280x853.bmp
│   ├── utf8.txt
│   └── utf16.txt
├── .venv/                   # Mediu virtual (opțional)
├── .idea/                   # Configurații IDE
└── __pycache__/             # Fișiere cache Python

Clase principale
Clasă	Rol
GenericFile	Clasă de bază pentru toate fișierele, definește interfața get_path() și get_freq()
TextASCII	Reprezintă fișiere ASCII/UTF-8, moștenește GenericFile
TextUNICODE	Reprezintă fișiere Unicode/UTF-16, moștenește GenericFile
Binary	Reprezintă fișiere binare generale
XMLFile	Reprezintă fișiere XML, moștenește TextASCII și adaugă metoda get_first_tag()
BMP	Reprezintă fișiere BMP, moștenește Binary și include width, height, bpp
Funcții importante

    frequencies_get(content) – calculează frecvențele caracterelor și media lor

    is_UTF8(freq) – verifică dacă fișierul este ASCII/UTF-8

    is_UTF16(freq) – verifică dacă fișierul este Unicode/UTF-16

    is_BINARY(freq, mean) – verifică dacă fișierul este binar

    width_and_height(content) – extrage lățimea și înălțimea pentru fișiere BMP

Cum funcționează

    Scanare director

        Scriptul parcurge recursiv directorul filesToParse cu os.walk().

        Fiecare fișier este deschis în mod binar (rb) și conținutul său este citit.

    Determinarea tipului fișierului

        Se calculează frecvențele caracterelor.

        Se verifică dacă fișierul este:

            UTF-8 (is_UTF8)

            UTF-16 (is_UTF16)

            Binar (is_BINARY)

        Dacă este ASCII și are extensia .xml, este tratat ca XML.

        Dacă este BMP, se extrag width, height și bpp.

    Stocarea și afișarea informațiilor

        Fiecare fișier este instanțiat într-un obiect corespunzător (TextASCII, TextUNICODE, Binary, XMLFile, BMP).

        La final, toate fișierele sunt afișate cu informațiile relevante.

Exemplu rulare

python main.py

