const app = new Vue(
  {
    el:'#main',
    data: 
    {
      titulo:'Hello, Vue.js!'      
    }
  }
)

const app2 = new Vue(
  {
    el:'#main2',
    data: 
    {
      titulo:app.titulo
    }
  }
)