const app = new Vue({
  el: '#main',
  data: {
    conectado: true,
    nuevaTarea: null,
    tareas:[
      { id: 1, titulo: 'Tarea 1', estado:true },
      { id: 2, titulo: 'Tarea 2', estado:false },
      { id: 3, titulo: 'Tarea 3', estado:false },
      { id: 4, titulo: 'Tarea 4', estado:true}

    ],    
  },
  methods: {
    agregarTarea() {
      this.tareas.unshift(
        { id: this.tareas.length + 1, titulo: this.nuevaTarea, estado: false }
      )
    }
  }, 
  computed: {
    tareasPendientes() {
      return this.tareas.filter(tarea =>!tarea.estado)
    },
    tareasCompletadas() {
      return this.tareas.filter(tarea => tarea.estado)
    }
  }
})
