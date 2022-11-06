async function cargarPlanes(){
  const request = await fetch('planes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const planes = await request.json();
}