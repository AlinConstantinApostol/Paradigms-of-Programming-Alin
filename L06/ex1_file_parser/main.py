import os
from filesTypes import *
import numpy as np # pentru deviatia standard
import xml.etree.ElementTree as ET # parsare XML


def width_and_height(content): # fisierele .bmp au un header fix la inceput
                               # in care byte[18:21] -> width, byte[22-25] -> width
    width = int.from_bytes(content[18:22], byteorder='little') # datele sunt in little-endian
    height = int.from_bytes(content[22:26], byteorder='little')
    return width, height


def frequencies_get(content):
    frequencies = dict()
    for i in content:
        if i not in frequencies:
            frequencies[i] = 1
        else:
            frequencies[i] += 1

    if len(frequencies) == 0:
        freq_mean = 0
    else:
        freq_mean = sum(frequencies.values()) / len(frequencies)
    return frequencies, freq_mean


def is_UTF8(freq):
    char_ratio = sum(freq.get(i) for i in freq.keys() if i == 9 or i == 10 or i == 13 or 31 < i < 128) / sum(
        freq.values())
    if char_ratio > 0.5:
        return True
    else:
        return False


def is_UTF16(freq):
    zero_ratio = 0
    if 0 in freq:
        zero_ratio = freq[0] * 100 / sum(freq.values())
    if zero_ratio >= 30:
        return True
    return False


def is_BINARY(frequencies, freq_mean):
    std_deviation = np.std(list(frequencies.values()))
    if std_deviation < freq_mean:
        return True
    else:
        return False


def main():
    all_files = []  # lista unde se vor salva toate fisierele, indiferent de tipul lor

    ROOT_DIR = os.path.join(os.getcwd(), "filesToParse")
    for root, sub_dirs, files in os.walk(ROOT_DIR):
        for file in os.listdir(root):
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path):
                f = open(file_path, 'rb')
                try:
                    content = f.read()

                    frequencies, freq_mean = frequencies_get(content)

                    isUTF8 = is_UTF8(frequencies)
                    isUTF16 = is_UTF16(frequencies)
                    isBINARY = is_BINARY(frequencies, freq_mean)

                    if isBINARY:
                        if file_path.split('.')[-1] == "bmp":
                            f = open(file_path, 'rb')
                            content = f.read(54)
                            width, height = width_and_height(content)
                            bpp = sum(frequencies.values()) / (width * height)

                            all_files.append(BMP(file_path, frequencies, width, height, bpp))

                        else:
                            all_files.append(Binary(file_path, frequencies))

                    elif isUTF8:
                        if file_path.split('.')[-1] == "xml":
                            f = open(file_path, 'rb')
                            content = f.read()
                            first_tag = ET.fromstring(content)

                            all_files.append(XMLFile(file_path, frequencies, str(first_tag)))

                        else:
                            all_files.append(TextASCII(file_path, frequencies))

                    elif isUTF16:
                        all_files.append(TextUNICODE(file_path, frequencies))

                finally:
                    f.close()

    for i in all_files:
        i.print()
        print('\n')


if __name__ == "__main__":
    main()
