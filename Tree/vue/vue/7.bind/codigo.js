const app = new Vue({
  el: '#main',
  data: {
      titulo: 'Instancia Vue.js 1',
      dato: 1.5*2
    },

  }

)


// Segunda instancia de Vue
const app2 = new Vue({
  el: '#main2',
  data: {
    titulo: 'Aplicación Vue.js',
    dato: 2.5,
    lista: ['uno', 'dos', 'tres']

})


// Tercera instancia de Vue
const app3 = new Vue({
  el: '#main3',
  data: {
    titulo: 'Clonado de Int. 1',
    dato: app.dato

})
