const app = new Vue(
  {
    el:'#main',
    data: 
    {
      tareas:[
        { nombre: 'Tarea 1', completada: false },
        { nombre: 'Tarea 2', completada: true },
        { nombre: 'Tarea 3', completada: false },
        { nombre: 'Tarea 4', completada: false },
        { nombre: 'Tarea 5', completada: false }
      ]
    },
    methods: 
    {
      completarTarea(tarea)
      {
        tarea.completado = !tarea.completado
      }
    }
  }
)
