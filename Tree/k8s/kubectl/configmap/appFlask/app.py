from flask import Flask, jsonify
import mysql.connector
import os

app = Flask(__name__)

def get_db_connection():
    return mysql.connector.connect(
        host=os.environ['DB_HOST'],
        user=os.environ['DB_USER'],
        password=os.environ['DB_PASSWORD'],
        database=os.environ['DB_NAME']
    )

@app.route('/')
def index():
    return '¡Bienvenido a mi aplicación web!'

@app.route('/events')
def get_events():
    db = get_db_connection()
    cursor = db.cursor()
    cursor.execute('SELECT * FROM events')
    events = cursor.fetchall()
    db.close()
    return jsonify(events)

@app.route('/tickets')
def get_tickets():
    db = get_db_connection()
    cursor = db.cursor()
    cursor.execute('SELECT * FROM tickets')
    tickets = cursor.fetchall()
    db.close()
    return jsonify(tickets)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8090)
