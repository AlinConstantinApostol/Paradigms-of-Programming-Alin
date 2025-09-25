# #!/usr/bin/python3
# import os
# import pathlib
# import tkinter as tk
#
# import multiprocessing as mp
# from doctest import master
# from multiprocessing.managers import BaseManager
# import pygubu
# import self
#
# PROJECT_PATH = pathlib.Path(__file__).parent
# PROJECT_UI = PROJECT_PATH / "parser5.ui"
#
#
# def is_prime(n):
#     for i in range(2, n):
#         if n % i == 0:
#             return False
#     return True
#
#
# class Parser:
#     ROOT_DIR = os.path.dirname(os.path.abspath(__file__))
#
#     def __init__(self, master=None):
#         # Initiate the messages queue
#         self.message_queue = mp.Queue()
#         self.worker = Worker(self)
#         self.worker.__init__(self)
#         self.worker.start()
#
#         self.master = master
#         self.builder = builder = pygubu.Builder()
#
#         ui_path = os.path.join(self.ROOT_DIR, 'parser5.ui')
#         builder.add_from_file(ui_path)
#
#         # Main widget
#         self.main_window = self.builder.get_object('frame', master)
#
#         self.input_text_lbl = self.builder.get_object('input_text')
#         self.output_text = self.builder.get_object('output_text')
#
#         self.add_list_button = self.builder.get_object('add_list_button')
#         self.filter_odd_button = self.builder.get_object('filter_odd_button')
#         self.filter_primes_button = self.builder.get_object('filter_primes_button')
#         self.sum_numbers_button = self.builder.get_object('sum_numbers_button')
#
#         # Buttons functionality
#
#         self.add_list_button['command'] = self.add_list
#         self.add_list_button['command'] = lambda: self.message_queue.put("add-list")
#         self.filter_odd_button['command'] = lambda: self.message_queue.put("odd")
#         self.filter_primes_button['command'] = lambda: self.message_queue.put("primes")
#         self.sum_numbers_button['command'] = lambda: self.message_queue.put("sum")
#
#         builder.connect_callbacks(self)
#         self.integer_list = None
#
#     def run(self):
#         self.main_window.mainloop()
#
#     def handle_message(self, message):
#         pass
#
#     def add_list(self):
#         result = self.input_text_lbl.get()
#         result = result.strip().replace(' ', '')
#         result = [int(item) for item in result.split(',')]
#         self.integer_list = result
#         print(result)
#         print("List added")
#         return result
#
#     def filter_odd(self):
#         result = self.input_text_lbl.get()
#         result = result.strip().replace(' ', '')
#         result = [int(item) for item in result.split(',')]
#         final_res = [num for num in result if num % 2 != 0]
#         print(final_res)
#         self.output_text.insert(tk.END, final_res)
#         self.output_text.insert(tk.END, '\n')
#
#     def filter_primes(self):
#         result = self.input_text_lbl.get()
#         result = result.strip().replace(' ', '')
#         result = [int(item) for item in result.split(',')]
#         final_res = [num for num in result if (is_prime(num) and num != 1)]
#         print(final_res)
#         self.output_text.insert(tk.END, final_res)
#         self.output_text.insert(tk.END, '\n')
#
#     def sum_numbers(self):
#         result = self.input_text_lbl.get()
#         result = result.strip().replace(' ', '')
#         result = [int(item) for item in result.split(',')]
#         # result = self.add_list()
#         suma = sum(result)
#         print(suma)
#         self.output_text.insert(tk.END, suma)
#         self.output_text.insert(tk.END, '\n')
#
#     def callback(self, event=None):
#         pass
#
#     def x(self, event=None):
#         pass
#
#
# class Worker(mp.Process):
#     def __init__(self, app_instance):
#         self.app_instance = app_instance
#         self.message_queue = app_instance.message_queue
#         super().__init__()
#
#     def run(self):
#         message = self.message_queue.get()
#         if message == "add-list":
#             self.app_instance.add_list()
#         elif message == "odd":
#             self.app_instance.filter_odd()
#         elif message == "primes":
#             self.app_instance.filter_primes()
#         elif message == "sum":
#             self.app_instance.sum_numbers()
#
#
# if __name__ == '__main__':
#     root = tk.Tk()
#     root.title('Example 1 with Tkinter and PyGubu')
#     app = Parser(root)
#     app.run()
#     app.worker.terminate()
#
#
#


# !/usr/bin/python3
import os
import pathlib
import tkinter as tk
import multiprocessing as mp
import pygubu

PROJECT_PATH = pathlib.Path(__file__).parent
PROJECT_UI = PROJECT_PATH / "parser5.ui"


def is_prime(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True


class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self, master=None):
        # Initiate the messages queue
        self.message_queue = mp.Queue()
        self.worker = Worker(self)
        self.worker.__init__(self)
        self.worker.start()

        self.master = master
        self.builder = builder = pygubu.Builder()

        ui_path = os.path.join(self.ROOT_DIR, 'parser5.ui')
        builder.add_from_file(ui_path)

        # Main widget
        self.main_window = self.builder.get_object('frame', master)
        self.input_text = self.builder.get_object('input_text')
        self.output_text = self.builder.get_object('output_text')
        self.add_list_button = self.builder.get_object('add_list_button')
        self.filter_odd_button = self.builder.get_object('filter_odd_button')
        self.filter_primes_button = self.builder.get_object('filter_primes_button')
        self.sum_numbers_button = self.builder.get_object('sum_numbers_button')

        # Buttons functionality

        self.add_list_button['command'] = self.add_list
        self.add_list_button['command'] = lambda: self.handle_message("add-list")
        self.filter_odd_button['command'] = lambda: self.handle_message("odd")
        self.filter_primes_button['command'] = lambda: self.handle_message("primes")
        self.sum_numbers_button['command'] = lambda: self.handle_message("sum")

        builder.connect_callbacks(self)
        self.integer_list = None

    def run(self):
        self.main_window.mainloop()

    def handle_message(self, message):
        if message == "add-list":
            self.add_list()
        elif message == "odd":
            self.filter_odd()
        elif message == "primes":
            self.filter_primes()
        elif message == "sum":
            self.sum_numbers()

    def add_list(self):
        result = self.input_text.get()
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        print(result)
        self.output_text.insert(tk.END, "List added: ")
        self.output_text.insert(tk.END, result)
        self.output_text.insert(tk.END, '\n')
        return result

    def filter_odd(self):
        result = self.input_text.get()
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        final_res = [num for num in result if num % 2 != 0]
        print(final_res)
        self.output_text.insert(tk.END, "Odd numbers: ")
        self.output_text.insert(tk.END, final_res)
        self.output_text.insert(tk.END, '\n')

    def filter_primes(self):
        result = self.input_text.get()
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        final_res = [num for num in result if (is_prime(num) and num != 1)]
        print(final_res)
        self.output_text.insert(tk.END, "Prime numbers: ")
        self.output_text.insert(tk.END, final_res)
        self.output_text.insert(tk.END, '\n')

    def sum_numbers(self):
        result = self.input_text.get()
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        # result = self.add_list()
        suma = sum(result)
        print(suma)
        self.output_text.insert(tk.END, "Sum: ")
        self.output_text.insert(tk.END, suma)
        self.output_text.insert(tk.END, '\n')

    def callback(self, event=None):
        pass

    def x(self, event=None):
        pass


class Worker(mp.Process):
    def __init__(self, app_instance):
        self.app_instance = app_instance
        self.message_queue = app_instance.message_queue
        super().__init__()

    def run(self):
        while True:
            message = self.message_queue.get()
            self.app_instance.handle_events(message)


if __name__ == '__main__':
    root = tk.Tk()
    root.title('Example 1 with Tkinter and PyGubu')
    app = Parser(root)
    app.run()
    app.worker.terminate()
