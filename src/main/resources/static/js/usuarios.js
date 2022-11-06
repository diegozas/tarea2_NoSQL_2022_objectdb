async function cargarUsuarios(){
  const request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();
}

async function registrarUsuarios(email,nombre,edad,password){
    let datos = {};
    datos.email=email;
    datos.nombre=nombre;
    datos.edad=edad;
    datos.password=password;
  const request = await fetch('usuarios/registrar', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
async function agregarPlan(emal,id) {
 const request = await fetch('usuarios/agregar' +email + id, {
    method: 'POST',
    headers: getHeaders()
  });
}

}