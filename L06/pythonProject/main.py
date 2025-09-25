import sys
import threading
from PySide6.QtCore import QTimer
from PySide6.QtWidgets import QApplication, QMainWindow, QPushButton, QWidget
from ui_form import Ui_MainWindow


class TicTacToeGame:
    def __init__(self, my_type):
        self.my_type = my_type
        self.game_table_usage = "000000000"
        self.win = False
        self.tie = False

    def make_a_move(self, x):
        if self.game_table_usage[x] == "0":
            self.game_table_usage = self.game_table_usage[:x] + str(self.my_type) + self.game_table_usage[x + 1:]
            # Check for win/tie
            self.check_for_win()

    def check_for_win(self):
        # Logic to check for win or tie
        pass


class TicTacToeUI(QMainWindow):
    def __init__(self, game_instance):
        super().__init__()
        self.ui = Ui_MainWindow()
        self.ui.setupUi(self)
        self.game_instance = game_instance
        self.setup_buttons()

    def setup_buttons(self):
        self.ui.pushButton_1.clicked.connect(lambda: self.make_move(0))
        self.ui.pushButton_2.clicked.connect(lambda: self.make_move(1))
        self.ui.pushButton_3.clicked.connect(lambda: self.make_move(2))
        self.ui.pushButton_4.clicked.connect(lambda: self.make_move(3))
        self.ui.pushButton_5.clicked.connect(lambda: self.make_move(4))
        self.ui.pushButton_6.clicked.connect(lambda: self.make_move(5))
        self.ui.pushButton_7.clicked.connect(lambda: self.make_move(6))
        self.ui.pushButton_7.clicked.connect(lambda: self.make_move(7))
        self.ui.pushButton_7.clicked.connect(lambda: self.make_move(8))
        # Connect other buttons similarly

    def make_move(self, index):
        self.game_instance.make_a_move(index)

        # Update UI based on game state


def run_game(num):
    app = QApplication(sys.argv)
    game = TicTacToeGame(num)  # You can specify player type here
    window = TicTacToeUI(game)
    window.show()
    sys.exit(app.exec())


if __name__ == "__main__":
    # Run two games in parallel
    threading.Thread(target=run_game(1)).start()
    threading.Thread(target=run_game(2)).start()
