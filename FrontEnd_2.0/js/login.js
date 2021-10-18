const url = "http://localhost:8081/ApiRest/api/login"

const formLogin = document.querySelector('form')
const usuarioLogin= document.getElementById('login-username')
const passwordLogin = document.getElementById('login-password')



const ajax = (options) => {
    let { url, method, success, error, data } = options;
    const xhr = new XMLHttpRequest();

    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState !== 4) return;

        if (xhr.status >= 200 && xhr.status < 300) {
            let json = JSON.parse(xhr.responseText);
            success(json);
        } else {
            let message = xhr.statusText || "Ocurrió un error";
            error(`Error ${xhr.status}: ${message}`);
        }
    });

    xhr.open(method || "GET", url);
    xhr.setRequestHeader("Content-type", "application/json; charset=utf-8");
    xhr.send(JSON.stringify(data));
};


formLogin.addEventListener('submit', (e) => {

    e.preventDefault()
     
    
    ajax({
        url: url + "/" + usuarioLogin.value,
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        },
        success: (res) => {
            console.log(res)
            if(res.usuario == usuarioLogin.value && res.contrasena == passwordLogin.value){
                if(res.id_rol==2){
                    window.location.href="gestionar_productos_almacen.html";
                }else if(res.id_rol==3){
                   window.location.href="gestionar_productos_usuario.html";
                }else{
                    window.location.href="inicio.html";
                }
                
            }else{
               
               passwordLogin.value=''
               usuarioLogin.value=''
               alertify.error('Credenciales Incorrectas')
            }

        },
        error: (err) => {
            console.log(err);
            
        },
    
    });

});
    


 