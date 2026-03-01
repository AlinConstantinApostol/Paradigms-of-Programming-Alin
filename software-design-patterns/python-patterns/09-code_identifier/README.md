# File Executor - Aplicație de determinare și executare a codului

## Descriere
Această aplicație citește fișiere fără extensie care conțin cod în limbaje Kotlin, Python, Bash sau Java și:

1. Determină tipul fișierului pe baza conținutului folosind **modelul lanț de responsabilități (Chain of Responsibility)**.
2. Execută fișierul cu comanda corespunzătoare folosind **modelul comandă (Command)** și modulul `subprocess`.

Aplicația identifică tipul fișierului prin verificarea cuvintelor cheie specifice fiecărui limbaj, prezența funcției `main` sau directivei shebang.

---

## Structura proiectului

```
ProjectRoot/
├── Files/
│   ├── cod_bash
│   ├── cod_java
│   ├── cod_kotlin
│   ├── cod_kotlin.jar
│   ├── cod_kotlin.kt
│   ├── cod_python
│   └── file.java
├── META-INF/
│   └── main.kotlin_module
├── __pycache__/
├── .idea/
├── .venv/
├── Command.py
├── Handlers.py
└── main.py
```

---

## Componente principale

### Command.py
Definește clase pentru **executarea efectivă a codului** în funcție de limbaj:

- `PythonCommand` – rulează fișiere Python.
- `KotlinCommand` – compilează fișiere Kotlin într-un JAR și le rulează cu JVM.
- `BashCommand` – rulează scripturi Bash.
- `JavaCommand` – rulează fișiere Java.

### Handlers.py
Implementează **lanțul de responsabilități**, fiecare handler detectând un singur tip de fișier:

- `HandleKotlinFile`
- `HandlePythonFile`
- `HandleBashFile`
- `HandleJavaFile`

Fiecare handler:

1. Verifică dacă fișierul poate fi procesat.
2. Dacă da, execută fișierul folosind comanda corespunzătoare.
3. Dacă nu, pasează cererea mai departe către următorul handler din lanț.

### main.py
- Creează lanțul de handleri.
- Primește calea fișierului de la utilizator.
- Inițiază procesul de determinare și executare a fișierului.

---

## Funcționare

1. Setează calea fișierului în `main.py`:

```python
file_path = "Files/cod_python"
# sau
file_path = "Files/cod_kotlin.kt"
# sau
file_path = "Files/cod_bash"
# sau
file_path = "Files/file.java"
```

2. Rulează aplicația:

```bash
python main.py
```

3. Aplicația va:

- Determina tipul fișierului.
- Executa codul folosind comanda corespunzătoare.

---

## Detectarea limbajului

- **Kotlin:** `fun`, `val`, `var`, `when`
- **Python:** `if __name__ == '__main__':`, `def`
- **Bash:** `#!/bin/bash`, `#!/bin/sh`, `echo`, `mkdir`, `cd`, `pwd`
- **Java:** `import java`, `String[] args`, `System.out.println`, `abstract`, `Boolean`, `instanceof`

