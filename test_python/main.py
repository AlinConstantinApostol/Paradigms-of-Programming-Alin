# import tkinter as tk
# from tkinter import ttk
# def callbackFunc(event):
#     print("Un nou element din combobox a fost selectat")
# app = tk.Tk()
# app.geometry('200x100')
# labelTop = tk.Label(app, text="Alege Luna")
# labelTop.grid(column=0, row=0)
# Excombo = ttk.Combobox(app,
#                        values=[
#                            "Ianuarie",
#                            "Februarie",
#                            "Martie",
#                            "Aprilie"])
# Excombo.grid(column=0, row=1)
# Excombo.current(1)
# Excombo.bind("<<ComboboxSelected>>", callbackFunc)
# app.mainloop()
# # Press the green button in the gutter to run the script.
# # if __name__ == '__main__':

# from tkinter import *
# from tkinter import ttk
# root = Tk()
# ttk.Button(root, text="Hello World").grid()
# root.mainloop()

from tkinter import *
from tkinter import ttk

# def calculate(*args):
#     try:
#         value = float(feet.get())
#         meters.set(int(0.3048*value*10000.0 + 0.5)/10000.0)
#     except ValueError:
#         pass
#
# root = Tk()
# root.title("Feet to Meters")
#
# mainframe = ttk.Frame(root, padding="3 3 20 12")
# mainframe.grid(column = 0, row = 0, sticky = (N, W, E, S))
# root.columnconfigure(0, weight=1)
# root.rowconfigure(0, weight=1)
# feet = StringVar()
# feel_entry = ttk.Entry(mainframe, width=7, textvariable=feet)
# feel_entry.grid(column=2, row=1, sticky=(W,E))
#
# meters = StringVar()
# ttk.Label(mainframe,textvariable=meters).grid(column=2, row=2, sticky=(W,E))
# ttk.Button(mainframe, text="Calculate", command=calculate).grid(column=3, row=3, sticky=W)
#
# ttk.Label(mainframe, text="feet").grid(column=3, row=1, sticky=W)
# ttk.Label(mainframe, text="is equivalent to").grid(column=1, row=2, sticky=W)
# ttk.Label(mainframe, text="meters").grid(column=3, row=2, sticky=W)
# for child in mainframe.winfo_children():
#     child.grid_configure(padx=5, pady=5)
# feel_entry.focus()
# root.bind("<Return>", calculate)
#
# root.mainloop()

from PyQt5.QtWidgets import QApplication, QLabel, QWidget
import sys

app = QApplication(sys.argv)
window = QWidget()
window.setWindowTitle("Test PyQt5")
label = QLabel("PyQt5 este instalat corect!", parent=window)
window.show()
sys.exit(app.exec_())
