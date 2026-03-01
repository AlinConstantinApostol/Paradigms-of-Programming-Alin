class GenericFile:
    def get_path(self):
        pass

    def get_freq(self):
        pass


class TextASCII(GenericFile): # interfata
    path_absolut = ""
    frequencies = 0

    def __init__(self, path, freq):
        self.path_absolut = path
        self.frequencies = freq

    def get_path(self):
        return self.path_absolut

    def get_freq(self):
        return self.frequencies

    def print(self):
        print("ASCII text file")
        print("Absolut path: ", self.path_absolut)


# clasele TextUNICODE, Binary, XMLFile care mostenesc clasa GenericFile

class TextUNICODE(GenericFile):
    path_absolut = ""
    frequencies = 0

    def __init__(self, path, freq):
        self.path_absolut = path
        self.frequencies = freq

    def get_path(self):
        return self.path_absolut

    def get_freq(self):
        return self.frequencies

    def print(self):
        print("UNICODE text file")
        print("Absolut path: ", self.path_absolut)


class Binary(GenericFile):
    path_absolut = ""
    frequencies = 0

    def __init__(self, path, freq):
        self.path_absolut = path
        self.frequencies = freq

    def get_path(self):
        return self.path_absolut

    def get_freq(self):
        return self.frequencies

    def print(self):
        print("BINARY text file")
        print("Absolut path: ", self.get_path())


class XMLFile(TextASCII):  # XML Files uses ASCII
    first_tag = ""

    def __init__(self, path, freq, first_tag):
        super().__init__(path, freq)
        self.first_tag = first_tag

    def get_first_tag(self):
        return self.first_tag

    def print(self):
        super().print()
        print("First tag: ", self.get_first_tag())


class BMP(Binary):  # la acest tip de fisier se adauga width, height, bpp
                    # se suprascriu constructorii si metodele de afisare
    width = 0
    height = 0
    bpp = 0  # bits per pixel

    def __init__(self, path, freq, width, height, bpp):
        super().__init__(path, freq)
        self.width = width
        self.height = height
        self.bpp = bpp

    def show_info(self):
        print("BMP File\nWidth: ", self.width, "\nHeight: ", self.height, "\nBits per pixel: ", self.bpp)

    def print(self):
        super().print()
        print("Width: ", self.width)
        print("Height: ", self.height)
        print("Bits per pixel: ", self.bpp)