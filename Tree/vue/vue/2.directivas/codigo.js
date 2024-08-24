const app = new Vue({
  el: '#main',
  data: {
    activeClass: 'active',
    errorClass: 'text-danger',
    conectado: true,
    edad: 2, 
    nombre: 'John Doe',
    apellidos: 'Doe, John',
    edadMin: 17,
    items: ['Juan', 'John', 'Doe', 'Alice'],
    listaPrecios: [
      { nombre: 'Producto 1', precio: 100 },
      { nombre: 'Producto 2', precio: 200 },
      { nombre: 'Producto 3', precio: 300 }
    ]
  }  
})
