function validacionRegistro() {
  var user = document.getElementById('user').value;
  var name = document.getElementById('name').value;
  var subname = document.getElementById('subname').value;
  var email = document.getElementById('email').value;
  var telf = document.getElementById('telf').value;
  var pass1 = document.getElementById('pass1').value;
  var pass2 = document.getElementById('pass2').value;


  //Comprobar que no esten vacios
  if (user.length === 0 || name.length === 0 || subname.length === 0 ||
     pass1.length === 0 || pass2.length === 0) {
    alert("Los campos no pueden quedar vacios");
    return false;
  }
  
  //Comprobar que no introduce caracteres raros en el usuario
  var expresionRegular = /^[a-z0-9][a-z0-9_]{3,9}$/;
  if(!expresionRegular.test(user)){
    document.getElementById('user').style="border: 2px solid red";
    return false;
  }

  //comprobar que es un Email y no vacio
  var regex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
  if (!regex.test(email)) {
    document.getElementById('email').style="border: 2px solid red";
    return false;
  }

  //comprobar que es un telefono y no vacio
  if(!(/^\d{9}$/.test(telf))) {
    document.getElementById('telf').style="border: 2px solid red";
    return false;
  }


  //Comprobar que ambas password son iguales
  if (pass1 !== pass2) {
    document.getElementById('pass1').style="border: 2px solid red";
    document.getElementById('pass2').style="border: 2px solid red";
    return false;
  }
}
function validarLogin() {
  var user = document.getElementById('user').value;
  var pass = document.getElementById('pass').value;

  if((user.length === 0) && (pass.length === 0)){
    document.getElementById('user').style="border: 2px solid red";
    document.getElementById('pass').style="border: 2px solid red";
    return false;
  }else if((user.length === 0) || (user === null)){
    document.getElementById('user').style="border: 2px solid red";
    return false;
  } else if ((pass.length === 0) || (pass === null)){
    document.getElementById('pass').style="border: 2px solid red";
    return false;
  }

}
function mostrarFecha() {
  var ultimaModif = document.lastModified;
  document.getElementById('fecha').innerHTML = ultimaModif;
}

function mostrarGif() {
    var puntos = document.getElementById('ptos').value;
  
    if(puntos>3){
      document.getElementById('gif').src = 'images/bien.gif';
    } else{
      document.getElementById('gif').src = 'images/mal.gif';
    }

}
