const url = "http://localhost:8081/ApiRest/api/productos"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalProductos = new bootstrap.Modal(document.getElementById('modalProducto'))
const formProductos = document.querySelector('form')
const nombreProducto = document.getElementById('nombre')
const descripcionProducto = document.getElementById('descripcion')
const referenciaProducto = document.getElementById('referencia')
const cantidadProducto = document.getElementById('cantidad')
const nuevacantidadProducto = document.getElementById('nuevacantidad')
const categoriaProducto = document.getElementById('categoria')
const idProducto = document.getElementById('id')


let opcion = ''  

btnCrear.addEventListener('click', () => {
    nombreProducto.value = ''
    descripcionProducto.value = ''
    referenciaProducto.value = ''
    cantidadProducto.value = ''
    categoriaProducto.value = ''
    idProducto.value = ''
    //idProducto.disabled = false
    modalProductos.show()
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

            res.forEach((productos) => {
                resultados += `<tr>
                        <td width="10%">${productos.id}</td>
                        <td width="15%">${productos.nombre_producto}</td>
                        <td width="25%">${productos.descripcion}</td>
                        <td width="15%">${productos.referencia}</td>
                        <td width="10%">${productos.cantidad}</td>
                        <td width="15%">${productos.id_categoria}</td>
                        
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">ingresar</a></td>
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

   
    if (e.target.matches(".btnEditar")) {
        const fila = e.target.parentNode.parentNode
        idProducto.value = fila.children[0].innerHTML
        nombreProducto.value = fila.children[1].innerHTML
        descripcionProducto.value = fila.children[2].innerHTML
        referenciaProducto.value = fila.children[3].innerHTML
        cantidadProducto.value = fila.children[4].innerHTML
        categoriaProducto.value = fila.children[5].innerHTML
        
        
        idProducto.disabled = true
        cantidadProducto.disabled = true
        referenciaProducto.disabled = true
        nombreProducto.disabled = true
        descripcionProducto.disabled = true
        categoriaProducto.disabled = true
        opcion = 'editar'
        modalProductos.show()
    }
})



formProductos.addEventListener('submit', (e) => {

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
            "cantidad": parseInt(cantidadProducto.value) + parseInt(nuevacantidadProducto.value),
            "descripcion": descripcionProducto.value,
            "id": idProducto.value,
            "id_categoria": categoriaProducto.value,
            "nombre_producto": nombreProducto.value,
            "referencia": referenciaProducto.value
        },
    });
    modalProductos.hide()
})



