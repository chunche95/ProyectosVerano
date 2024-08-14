const express = require('express');
const app = express();
const port = 3000;

const os = require('os');

// Función para obtener la dirección IP
function getIPAddress() {
    const interfaces = os.networkInterfaces();
    for (const devName in interfaces) {
        const iface = interfaces[devName];
        for (let i = 0; i < iface.length; i++) {
            const alias = iface[i];
            if (alias.family === 'IPv4' && alias.address !== '127.0.0.1' && !alias.internal) {
                return alias.address;
            }
        }
    }
    return '0.0.0.0'; // Retorna esto si no se encuentra una IP válida
}

// Almacenar la IP en una constante
const ipAddress = getIPAddress();
const users = [
  { id: 1, name: 'Pedro' },
  { id: 2, name: 'Josue' },
  { id: 3, name: 'Alicia' },
  { id: 4, name: 'Karol' }
];


app.get('/api/users', (req, res) => {
  res.json(users);
});


app.listen(port, () => {
  console.log(`Server is running on http://${ipAddress}:${port}`);
});
