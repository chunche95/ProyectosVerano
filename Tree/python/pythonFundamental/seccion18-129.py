#!/bin/python3

# Crear un programa con tres clases Universidad, con atributos nombre (Donde se almacena el nombre de la Universidad). 
# Otra llamada Carerra, con los atributos especialidad (En donde me guarda la especialidad de un estudiante). 
# Una ultima llamada Estudiante, que tenga como atributos su nombre y edad. El programa debe imprimir la especialidad, 
# edad, nombre y universidad de dicho estudiante con un objeto llamado persona.

class Universidad():
    def nombre(self, nombreU):
        self.nombreU = nombreU
        print(f'Universidad: {self.nombreU}')
class Carrera():
    def especialidad(self, especialidadEstudiante):
        self.especialidadEstudiante = especialidadEstudiante
        print(f'Especialidad: {self.especialidadEstudiante}')
class Estudiante(Universidad, Carrera):     
    def estudiante(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
        print("Datos almacenados del estudiante {self.nombre}")
        print("- Nombre {} \n - Edad: {} \n ".format(self.nombre, self,edad))
        print(f"- Especialidad seleccionada: {self.especialidadEstudiante}")
        print("En la Universidad: {}".format(self.nombreU))    
    
    def __init__(self):
        Estudiante.estudiante()


persona = Estudiante()
persona.carrera('ADE')
persona.estudiante('UCLM','Julian', 18)