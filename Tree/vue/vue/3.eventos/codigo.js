const app = new Vue({
  el: '#main',
  data: {
    conectado: true,
    nuevaTarea: null,
    tareas:[
      'id: 1, titulo:',
      'id: 2, titulo:',
      'id: 3, titulo:'
    ],    
  },
  methods: {
    agregarTarea() {
      this.tareas.unshift(this.nuevaTarea)
    }
  }
})
