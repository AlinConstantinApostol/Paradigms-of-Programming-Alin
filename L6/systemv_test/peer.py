import threading
from time import sleep

from sysv_ipc import MessageQueue, IPC_CREAT

queue = MessageQueue(69, flags=IPC_CREAT)


def sendLoop():
    while True:
        s = str(input(">"))
        queue.send(s, type=my_type)
        sleep(1)


def rcvLoop():
    while True:
        message, _ = queue.receive(type=(2 if my_type == 1 else 1))
        print(message)


if __name__ == '__main__':
    my_type = int(input("Player 1 or Player 2?"))
    threading.Thread(target=sendLoop).start()
    threading.Thread(target=rcvLoop).start()
