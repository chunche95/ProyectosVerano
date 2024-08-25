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
    mostrarNombre() {
      const isThere = 'navigator' in window;
      let os = "";
      const userAgent = isThere && 'userAgent' in navigator && navigator.userAgent.toLowerCase() || '';
      const vendor = isThere && 'vendor' in navigator && navigator.vendor.toLowerCase() || '';
      const appVersion = isThere && 'appVersion' in navigator && navigator.appVersion.toLowerCase() || '';
      const platform = isThere && 'platform' in navigator && navigator.platform.toLowerCase() || '';

      if (/iphone/i.test(userAgent) || /ipad/i.test(userAgent) || /ipod/i.test(userAgent)) os = 'ios';
      if (/android/i.test(userAgent)) os = 'android'
      if (/win/i.test(appVersion) && /phone/i.test(userAgent)) os = 'windowsPhone'
      if (/mac/i.test(appVersion)) os = 'MacOSX'
      if (/win/i.test(appVersion)) os = 'windows'
      if (/linux/i.test(appVersion)) os = 'linux'

      return {
        os,
        userAgent,
        vendor,
        appVersion,
        platform,
      }
    }, 
    filtrarTitulo() 
    {

      if (this.nuevaTarea === null || this.nuevaTarea === '' )
        return null;

      return this.tareas.filter(tarea => tarea.titulo.toLowerCase().includes(this.nuevaTarea.toLowerCase()));
      
    }
  }
})
