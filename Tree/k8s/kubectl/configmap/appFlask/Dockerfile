# Usa una imagen base de Python
FROM python:3.9-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo de requerimientos y lo instala
COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

# Copia el resto de la aplicación al contenedor
COPY . .

# Exponer el puerto en el que Flask correrá
EXPOSE 8080

# Comando para ejecutar la aplicación Flask
CMD ["python3", "app.py"]
