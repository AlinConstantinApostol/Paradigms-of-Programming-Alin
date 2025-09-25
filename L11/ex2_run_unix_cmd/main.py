# This is a sample Python script.
import subprocess

# Functie care citeste o comanda cu pipe-uri si o separa in comenzi individuale
def get_commands():
    # Exemplu de input: ip a | grep inet | wc -l
    commands = input("Insert command:")  # Citim comanda completa de la tastatura
    commands_list = commands.split(" | ")  # Impartim comanda folosind separatorul de pipe "|"
    return commands_list  # Returnam lista de comenzi separate
if __name__ == '__main__':

    output = ""  # Variabila care va retine output-ul (PIPE-ul) intre procese

    cmds = get_commands()  # Citim lista de comenzi de la tastatura

    # Parcurgem fiecare comanda din lista
    for cmd in cmds:
        if cmds.index(cmd) == 0:
            # Prima comanda: rulam cu stdout catre PIPE (output va fi input-ul pentru urmatoarea)
            output = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True, text=True)
        else:
            # Comenzile urmatoare: primesc input din stdout-ul comenzii anterioare
            output = subprocess.Popen(cmd, stdin=output.stdout, stdout=subprocess.PIPE, shell=True, text=True)
            # Inchidem output-ul anterior pentru a evita blocaje
            #output.stdout.close()
    # Asteptam ca ultima comanda sa termine si colectam rezultatul final
    result_out, result_err = output.communicate()

    # Afisam rezultatul obtinut din ultima comanda
    print(result_out)
