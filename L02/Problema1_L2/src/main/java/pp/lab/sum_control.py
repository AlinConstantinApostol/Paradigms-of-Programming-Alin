def polynomial_checksum(text):
    """
    Calculează suma de control folosind un polinom de gradul 5.
    Se exclude primul și ultimul caracter din șir înainte de calcul.
    """
    if len(text) <= 2:
        return 0  # Dacă textul are 2 sau mai puține caractere, returnăm 0

    text = text[1:-1]  # Eliminăm primul și ultimul caracter

    checksum = sum((ord(ch) ** 5) % 997 for ch in text)  # Mod 997 pentru a evita numere foarte mari
    return checksum

def words_with_same_checksum(words):
    checksum_dict = {}

    for word in words:
        cs = polynomial_checksum(word)
        if cs in checksum_dict:
            checksum_dict[cs].append(word)
        else:
            checksum_dict[cs] = [word]
    return checksum_dict

# Test pentru a verifica dacă funcția funcționează corect
# if __name__ == "__main__":
#     test_words = ["Hello", "World", "Python", "Java"]
#     for word in test_words:
#         print(f"{word}: {polynomial_checksum(word)}")
