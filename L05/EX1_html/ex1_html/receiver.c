#include <stdio.h>
#include <sys/ipc.h>
#include <sys/msg.h>

// Structure for message queue
struct mesg_buffer {
    long mesg_type;
    char mesg_text[1000];  // Modificat aici pentru a crește dimensiunea
} message;

int main()
{
    key_t key = 1234;  // Folosim aceeasi valoare ca în Python
    int msgid;

    // msgget creeaza o coada de mesaje
    msgid = msgget(key, 0666 | IPC_CREAT); // creaza sau obtine ID-ul uneo cozi de mesaje
                                           // asociate cu cheia
    if (msgid == -1) {
        perror("msgget failed");
        return 1;
    }

    // msgrcv pentru a primi mesajul din coada
    // &message este adresa structurii unde va fi stocat mesajul primit
    int ret = msgrcv(msgid, &message, sizeof(message), 1, 0);
    if (ret == -1) {
        perror("msgrcv failed");
        return 1;
    }

    // Afiseaza mesajul
    printf("Data Received is: %s\n", message.mesg_text);

    // Distruge coada de mesaje
    msgctl(msgid, IPC_RMID, NULL); // ID-ul cozii
                                   // IPC_RMID comanda pentru stergerea cozii
                                   // NULL - fara argumente suplimentare

    return 0;
}
