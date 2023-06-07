const express = require('express');
const app = express();
const port = 8000;

app.use(express.json());

app.post('/api/palindromo', (req, res) => {
const { palabra } = req.body;

if (typeof palabra !== 'string') {
    res.status(404).json({ message: 'No se pudo comprobar la palabra' });
    return;
}

const palabraSinEspacios = palabra.replace(/\s/g, '').toLowerCase();
const palabraReversa = palabraSinEspacios.split('').reverse().join('');

if (palabraSinEspacios === palabraReversa) {
    res.status(200).json({ message: `${palabra} es una palabra Palíndroma` });
} else {
    res.status(302).json({ message: `${palabra} no es una palabra Palíndroma` });
}
});

app.listen(port, () => {
console.log(`Servidor iniciado en http://localhost:${port}`);
});
