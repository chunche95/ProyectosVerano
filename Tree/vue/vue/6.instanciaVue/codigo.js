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
    },    
    filtrarTitulo() 
    {

      if (this.nuevaTarea === null || this.nuevaTarea === '' )
        return null;

      return this.tareas.filter(tarea => tarea.titulo.toLowerCase().includes(this.nuevaTarea.toLowerCase()));
      
    }
  }
})


// Segunda instancia de Vue
const app2 = new Vue({
  el: '#main2',
  data: {
    mensaje: 'Hola desde la segunda instancia Vue',
    conectado: false,
    nuevaTarea: null,
    tareas:[
      { id: 5, titulo: 'Tarea 5', estado:false },
      { id: 6, titulo: 'Tarea 6', estado: true },
      { id: 7, titulo: 'Tarea 7', estado: false },
      { id: 8, titulo: 'Tarea 8', estado: true}

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
      return this.tareas.filter(tarea =>!
