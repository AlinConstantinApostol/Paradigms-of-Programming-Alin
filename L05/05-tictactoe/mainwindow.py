# This Python file uses the following encoding: utf-8
import string
import sys # folosite pentru manipularea sistemului
# import threading
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton, QWidget
# importa modulele necesare pentru a crea interfata grafica
# Important:
# You need to run the following command to generate the ui_form.py file
#     pyside6-uic form.ui -o ui_form.py, or
#     pyside2-uic form.ui -o ui_form.py
from ui_form import Ui_MainWindow
from sysv_ipc import MessageQueue, IPC_CREAT # creaza si manipuleaza cozi de
# mesaje intre 2 procese

queue = MessageQueue(100, flags=IPC_CREAT)


def modify_string(str,index,char):
    return str[:index] + char + str[index+1:] # modifica un sir de caractere
                                              # 000000000,0,x -> x00000000


class TicTacToe:

    def __init__(self):
        self.app = QApplication(sys.argv) # initializeaza aplicatia Qt
        self.widget = game_ui()  # instanta interfetei grafice a jocului
        self.widget.show() # afisarea vizuala a widget-ului pe ecran
        self.game_functionality = game_functionality(self.widget.ui)  # creaza logica jocului care va gestiona evenimentele
        sys.exit(self.app.exec())



class game_functionality:
    def __init__(self, ui):
        self.ui = ui
        self.win = False
        self.tie = False
        self.playerTurn = 1
        self.game_table_usage = "000000000"
        print(self.game_table_usage)
        self.my_type = input("Player no. 1 or 2: ")
        self.make_a_move()
        self.push_buttons = [
            [self.ui.pushButton_1, self.ui.pushButton_2, self.ui.pushButton_3],
            [self.ui.pushButton_4, self.ui.pushButton_5, self.ui.pushButton_6],
            [self.ui.pushButton_7, self.ui.pushButton_8, self.ui.pushButton_9],
        ]

    def set_player_turn(self):
        if self.playerTurn == 1:
            self.playerTurn = 2
        elif self.playerTurn == 2:
            self.playerTurn = 1

    def make_a_move(self): # asociaza fiecare buton de pe interfata grafica cu o
                           # functie care va marca o miscare a jucatorului
        self.ui.pushButton_1.clicked.connect(lambda: self.set_occupied(0, 0))
        self.ui.pushButton_2.clicked.connect(lambda: self.set_occupied(0, 1))
        self.ui.pushButton_3.clicked.connect(lambda: self.set_occupied(0, 2))
        self.ui.pushButton_4.clicked.connect(lambda: self.set_occupied(1, 0))
        self.ui.pushButton_5.clicked.connect(lambda: self.set_occupied(1, 1))
        self.ui.pushButton_6.clicked.connect(lambda: self.set_occupied(1, 2))
        self.ui.pushButton_7.clicked.connect(lambda: self.set_occupied(2, 0))
        self.ui.pushButton_8.clicked.connect(lambda: self.set_occupied(2, 1))
        self.ui.pushButton_9.clicked.connect(lambda: self.set_occupied(2, 2))

    def set_occupied(self, x, y):
        if not self.win and not self.tie: # verificam daca jocul nu a fost castigat deja
            print(queue.__sizeof__())
            if queue.max_size == 0: # detaliu de debug, verifica daca dimensiunea maxima a cozii este 0
                                    # ceea ce sugereaza ca trebuie sa primim un mesaj de la celalalt jucator
                message = queue.receive(type=(2 if self.my_type == "1" else 1))
                print(message)
                # daca jucatorul curent este 1 => type=2 => primim mesaj de la jucatorul 2 si invers

            # Calculeaza indexul corespunzator în sirul de 9 caractere
            index = x * 3 + y
            if self.game_table_usage[index] == "0":
                # Actualizeaza șirul cu mutarea curenta
                self.game_table_usage = modify_string(self.game_table_usage, index, str(self.playerTurn))
                self.push_buttons[x][y].setText("X" if self.playerTurn == 1 else "O")
                print("Block (", x, ",", y, ") now is occupied.")
                self.check_for_win()

            print("Current state of game table: ", self.game_table_usage, "\n")

            self.check_for_win()

            #Transmiterea starii pjocului prin coada de mesaje
            queue.send(self.game_table_usage, type=int(self.my_type)) # trimite mutarea sub forma unui string
            message = queue.receive(type=int(self.my_type)) # primirea mutarii de la adversar
            print(message)
            # Dupa transmiterea starii asteapta ca celalt jucator sa trimita la randul sau
            # starea jocului actualizata
            self.set_player_turn() # Duoa mutare, tura este schimbata la celalalt jucator


    def check_for_win(self):
        if (self.game_table_usage[0] == self.game_table_usage[1] == self.game_table_usage[2] == 1 or
                self.game_table_usage[3] == self.game_table_usage[4] == self.game_table_usage[5] == 1 or
                self.game_table_usage[6] == self.game_table_usage[7] == self.game_table_usage[8] == 1):
            self.win = True

        elif (self.game_table_usage[0] == self.game_table_usage[3] == self.game_table_usage[6] == 1 or
              self.game_table_usage[1] == self.game_table_usage[4] == self.game_table_usage[7] == 1 or
              self.game_table_usage[2] == self.game_table_usage[5] == self.game_table_usage[8] == 1):
            self.tie = True

        elif (self.game_table_usage[0] == self.game_table_usage[4] == self.game_table_usage[8] == 1 or
              self.game_table_usage[2] == self.game_table_usage[4] == self.game_table_usage[6] == 1):
            self.tie = True

        elif self.game_table_usage.find("0") == -1:
            self.tie = True

        print("Tie! No one wins...")
         # if self.win:
         #     print("Player ", self.playerTurn, "wins!")


class game_ui(QMainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
    # self.game_functionality = game_functionality(self.ui)


if __name__ == "__main__":
    game = TicTacToe()


