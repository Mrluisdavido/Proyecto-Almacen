const url = "http://localhost:8081/ApiRest/api/usuarios"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalUsuario = new bootstrap.Modal(document.getElementById('modalUsuario'))
const formUsuarios = document.querySelector('form')
const nombreUsuario = document.getElementById('nombre')
const correoUsuario = document.getElementById('correo')
const usuarioUsuario = document.getElementById('usuario')
const contrasenaUsuario = document.getElementById('contrasena')
const rolUsuario = document.getElementById('rol')
const idUsuario = document.getElementById('id')

let opcion = ''

btnCrear.addEventListener('click', () => {
	nombreUsuario.value = ''
    correoUsuario.value = ''
    usuarioUsuario.value = ''
    contrasenaUsuario.value = ''
    rolUsuario.value = ''
    idUsuario.value = ''
    //idProducto.disabled = false
    modalUsuario.show()
    opcion = 'crear'
})

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

//cerebro que conecta la tabla de datos//
const getAll = () => {
    ajax({
        url: url,
        method: "GET",
        success: (res) => {
            console.log(res);

            res.forEach((usuarios) => {
                resultados += `<tr>
                        <td width="5%">${usuarios.id}</td>
                        <td width="15%">${usuarios.nombre_usuario}</td>
                        <td width="25%">${usuarios.correo}</td>
                        <td width="15%">${usuarios.usuario}</td>
                        <td width="15%">${usuarios.contrasena}</td>
                        <td width="8%">${usuarios.id_rol}</td>
                        <td class="text-center" width="40%"><a class="btnEditar btn btn-success">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
            });

            contenedor.innerHTML = resultados
        },
        error: (err) => {
            console.log(err);
            $table.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`);
        },
    });
};
//carga el contenido//
document.addEventListener("DOMContentLoaded", getAll);
document.addEventListener("click", (e) => {

    if (e.target.matches(".btnBorrar")) {
        const fila = e.target.parentNode.parentNode
        const id = fila.firstElementChild.innerHTML
        console.log(id)
        alertify.confirm(`¿Estás seguro de eliminar el id ${id}?`,
            function () {
                ajax({
                    url: url + "/" + id,
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    success: (res) => location.reload(),
                    error: (err) => alert(err),
                });
                alertify.success('Registro eliminado')
            },
            function () {
                alertify.error('Cancel')
            });



    }
if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        idUsuario.value = fila.children[0].innerHTML
        nombreUsuario.value = fila.children[1].innerHTML
        correoUsuario.value = fila.children[2].innerHTML
        usuarioUsuario.value = fila.children[3].innerHTML
        contrasenaUsuario.value = fila.children[4].innerHTML
        rolUsuario.value = fila.children[5].innerHTML
        idUsuario.disabled = true
        opcion = 'editar'
        modalUsuario.show()
    }
})
formUsuarios.addEventListener('submit', (e) => {
    e.preventDefault()
    let metodo = "POST"
    if (opcion == 'editar') {
        metodo = "PUT"

    }
    ajax({
        url: url,
        method: metodo,
        headers: {
            'Content-Type': 'application/json'
        },
        success: (res) => location.reload(),
        error: (err) =>
            $form.insertAdjacentHTML("afterend", `<p><b>${err}</b></p>`),
        data: {
            "contrasena": contrasenaUsuario.value,
       		"correo": correoUsuario.value,
        	"id": idUsuario.value,
        	"id_rol": rolUsuario.value,
        	"nombre_usuario": nombreUsuario.value,
        	"usuario": usuarioUsuario.value
        },
    });
    modalUsuario.hide()
})
