# Crear una clase Fabrica que tenga los atributos de Llantas, Color y Precio; luego crear dos clases mas que hereden de Fabrica, 
# las cuales son Moto y Carro. Crear metodos que muestren la cantidad de llantas, color y precio de ambos transportes. 
# Por ultimo, crear objetos para cada clase y mostrar por pantalla los atributos de cada uno
class Fabrica():
    def __init__(self, llantas, color, precio):
        self.llantas = llantas
        self.color = color
        self.precio = precio

class Carro(Fabrica):
    def datos(self):
        print("Datos carro:")
        print(" Cantidad llantas {}  \n Color: {}  \n Precio: $ {}".format(self.llantas, self.color , self.precio))


class Moto(Fabrica):
    def datos(self):
        print("Datos moto:")
        print(f' Cantidad de llantas {self.llantas} \n Color: {self.color} \n Precio: $ {self.precio} ')

moto = Moto(2, "Negro", 4300)
moto.datos()
carro = Carro(4, "Gris", 23000)
carro.datos()