import sys # pentru operatiuni legate de sistemul de operare
import os #
import sysv_ipc  # comunicare intre procese folosind cozi de mesaje
from PyQt5.QtWidgets import QWidget, QApplication, QFileDialog
from PyQt5.uic import loadUi # aceste 2 librarii sunt folosite pentru interfata grafica

def convert_to_html(text):
    #prin acesta aux, cream un sablon HTML de baza
    aux = """<!DOCTYPE html> 
    <html lang="en">
    <head>
        <title>HTML Converter</title>
    </head>
    <body>\n"""
    for line in text.splitlines():
        if line.isupper(): # dca linia este scrisa cu majuscule, este transformata intr-un <h1>
            aux += "\t\t<h1>" + line + "</h1>\n"
        else:
            aux += "\t\t<p>" + line + "</p>\n" #altfel este pusa intr-un <p>
    aux += "\t</body>\n</html>\n"
    return aux # inchidem tag-urile HTML si returnam rezultatul

class HTMLConverter(QWidget):
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__)) # stocheaza calea directorului in care se afla scriptul

    def __init__(self):
        super(HTMLConverter, self).__init__()
        ui_path = os.path.join(self.ROOT_DIR, 'html_converter.ui')
        loadUi(ui_path, self) # incarca interfata grafica dintr fisierul UI
        self.browse_btn.clicked.connect(self.browse)
        self.convert_html.clicked.connect(self.load_file_contents)
        self.send_to_c.clicked.connect(self.send_to_c_func)
        self.file_path = None
        # Asociaza butoanele cu functiile corespunzatoare

    def browse(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        file, _ = QFileDialog.getOpenFileName(self,
                                              caption='Select file',
                                              directory='',
                                              filter="Text Files (*.txt)",
                                              options=options)
        # deschide o fereastra pentru selectarea unui fisier text
        if file:
            self.file_path = file
            self.path_line_edit.setText(file)
            print(file) # file contine
        # daca un fisier a fost selectat, salveaza calea lui si o afiseaza
    def load_file_contents(self):
        if self.file_path: # deschide fisierul in modul read
            try:
                with open(self.file_path, 'r') as file:
                    #citeste continutul lui
                    text = file.read()
                    html_text = convert_to_html(text)
                    self.textOutput.setPlainText(html_text) # afiseaza HTML-ul generat in interfata
                    return html_text
                # Deschide fisierul selectat, converteste textul in HTML si l afiseaza
                # in interfata
            except Exception as e:
                print("Error:", e)

    def send_to_c_func(self):
        message = self.load_file_contents()
        if message:
            print("Sending message to C program:", message)  # Adaugat pentru verificare
            try:
                # Cream sau obține coada de mesaje IPC
                message_queue = sysv_ipc.MessageQueue(1234, sysv_ipc.IPC_CREAT)  # Folosește IPC_CREAT
                message_queue.send(message.encode())  # Trimite mesajul
                print("Message sent to C program")
            except sysv_ipc.ExistentialError:
                print("Message queue not initialized. Please run the C program first.")


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())
