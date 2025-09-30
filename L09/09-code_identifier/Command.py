import subprocess


class Command:
    def execute(self, file):
        pass


class PythonCommand(Command):
    def execute(self, file):
        subprocess.run(["python", file])


class KotlinCommand(Command):
    def execute(self, file):
        subprocess.run(["kotlinc", file, "-include-runtime", "-d", "cod_kotlin.jar"]) # compilare, ambalare in jar, rulat cu jvm
        subprocess.run(["java", "-jar", "Files/cod_kotlin.jar"])


class BashCommand(Command):
    def execute(self, file):
        subprocess.run(["bash", file])


class JavaCommand(Command):
    def execute(self, file):
        subprocess.run(["java", file])
