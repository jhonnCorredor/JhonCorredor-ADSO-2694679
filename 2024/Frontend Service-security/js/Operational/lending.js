function loadData() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/lending",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("Cargando datos...");
            console.log(response.data);

            // Variable para almacenar el contenido HTML
            var html = "";

            // Itera a través de los datos recibidos
            response.data.forEach(function (item) {
                // Verifica si no hay una marca de borrado
                if (!item.deletedAt) {
                    // Construye una fila de tabla para cada elemento
                    html += `
                        <tr>

                            <td>${item.book.title}</td>
                            <td>${item.employed.person.firstName} ${item.employed.person.lastName}</td>
                            <td>${item.client.person.firstName} ${item.client.person.lastName}</td>
                            <td>${item.amount}</td>
                            <td>${item.action ? "Prestado" : "Devuelto"}</td>
                            <td>${new Date(item.date).toLocaleString()}</td> <!-- Convertir a formato local -->
                            <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                            <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> <img src="/assets/icon/pencil-square.svg" > </button>
                            <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/assets/icon/trash3.svg" > </button></td>
                        </tr>
                    `;
                }
            });

            // Inserta el HTML generado en el elemento con ID `resultData`
            $("#resultData").html(html);
        },
        error: function (error) {
            // Manejo de errores en la solicitud
            console.error("Error en la solicitud:", error);
            alert("Error al cargar los datos.");
        },
    });
}

function clearData() {

    $("#id").val("");
    $("#libro").val("");
    $("#prestamo").val("");
    $("#cliente").val("");
    $("#cantidad").val("");
    $("#accion").val("");
    $("#fecha").val("");
    $("#state").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
    btnAgregar.text("Agregar");
    btnAgregar.attr("onclick", "save()");
}

function LoadBook() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/book",
        method: "GET",
        dataType: "json",
        success: function (response) {

            // Verifica que la respuesta contenga datos
            if (response && response.data) {
                // Obtén el elemento select del formulario
                var selectLibro = $("#libro");
                // Vacía las opciones actuales
                selectLibro.empty();
                // Itera sobre la lista de libros y crea opciones para el select
                response.data.forEach(function (book) {
                    // Añade una opción para cada libro
                    var option = $("<option>")
                        .val(book.id) // El valor de la opción será el ID del libro
                        .text(book.title); // El texto de la opción será el título del libro
                    // Añade la opción al select
                    selectLibro.append(option);
                });
            }
        },
        error: function (error) {
            console.error("Error al cargar la lista de libros:", error);
        }
    });
}

function LoadEmployed() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/employed",
        method: "GET",
        dataType: "json",
        success: function (response) {

            // Verifica que la respuesta contenga datos
            if (response && response.data) {
                // Obtén el elemento select del formulario
                var selectLibro = $("#empleado");
                // Vacía las opciones actuales
                selectLibro.empty();
                // Itera sobre la lista de libros y crea opciones para el select
                response.data.forEach(function (employed) {
                    // Añade una opción para cada libro
                    var option = $("<option>")
                        .val(employed.id) // El valor de la opción será el ID del libro
                        .text(`${employed.person.firstName} ${employed.person.lastName}`); // El texto de la opción será el título del libro
                    // Añade la opción al select
                    selectLibro.append(option);
                });
            }
        },
        error: function (error) {
            console.error("Error al cargar la lista de libros:", error);
        }
    });
}

function LoadClient() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/client",
        method: "GET",
        dataType: "json",
        success: function (response) {

            // Verifica que la respuesta contenga datos
            if (response && response.data) {
                // Obtén el elemento select del formulario
                var selectLibro = $("#cliente");
                // Vacía las opciones actuales
                selectLibro.empty();
                // Itera sobre la lista de libros y crea opciones para el select
                response.data.forEach(function (cliente) {
                    // Añade una opción para cada libro
                    var option = $("<option>")
                        .val(cliente.id) // El valor de la opción será el ID del libro
                        .text(`${cliente.person.firstName} ${cliente.person.lastName}`); // El texto de la opción será el título del libro
                    // Añade la opción al select
                    selectLibro.append(option);
                });
            }
        },
        error: function (error) {
            console.error("Error al cargar la lista de libros:", error);
        }
    });
}


function save() {
    var data = {
        book: { id: parseInt($("#libro").val()) },
        employed: { id: parseInt($("#empleado").val()) },
        client: { id: parseInt($("#cliente").val()) },
        amount: $("#cantidad").val(),
        action: $("#accion").val() === "1",
        date: $("#fecha").val(),
        state: $("#estado").val() === "1"

    };
    console.log(data);


    // Realiza una solicitud POST a la API
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/lending",
        method: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            // La solicitud fue exitosa, recarga los datos para reflejar los cambios
            loadData();
            Swal.fire({
                title: "perfect!",
                text: "Registro agregado con éxito!",
                icon: "success",
                timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
                buttons: false // Deshabilitar botones de confirmación y cancelación
            });
            // Limpia los datos del formulario
            clearData();
        },
        error: function (error) {
            console.error("Error al guardar los datos:", error);
        }
    });
}

function update() {
    var data = {
        id: parseInt($("#id").val()),
        book: { id: $("#libro").val() },
        employed: { id: $("#empleado").val() },
        client: { id: $("#cliente").val() },
        amount: $("#cantidad").val(),
        action: $("#accion").val() === "1",
        date: $("#fecha").val(),
        state: $("#estado").val() === "1"
    };

    // Realiza una solicitud PUT a la API para actualizar el registro
    $.ajax({
        url: `http://localhost:9000/service-security/v1/api/lending/${data.id}`,
        method: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            // La actualización fue exitosa, recarga los datos para reflejar los cambios
            loadData();
            Swal.fire({
                title: "perfect!",
                text: "Registro actualizado con éxito!",
                icon: "success",
                timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
                buttons: false // Deshabilitar botones de confirmación y cancelación
            });
            // Limpia los datos del formulario
            clearData();
        },
        error: function (error) {
            console.error("Error al actualizar los datos:", error);
        }
    });
}

function findById(id) {
    // Realiza una solicitud GET a la API para obtener los datos del registro con el ID específico
    $.ajax({
        url: `http://localhost:9000/service-security/v1/api/lending/` + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
            // Verifica que la respuesta contenga datos
            var data = response.data;
            // Llena los campos del formulario con los datos obtenidos
            $("#id").val(data.id); // El ID del registro

            // Llena el select de libro
            $("#libro").val(data.book.id);

            // Llena el select de préstamo
            $("#prestamo").val(data.employed.id);
            $("#cliente").val(data.client.id);

            // Llena los demás campos
            $("#cantidad").val(data.amount);
            $("#accion").val(data.action ? "1" : "0");
            $("#fecha").val(new Date(data.date).toISOString().slice(0, 16));
            $("#estado").val(data.state ? "1" : "0");

            // Abre el modal para mostrar el formulario de edición
            $('#staticBackdrop').modal('show');
            //Cambiar boton.
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text("Actualizar");
            btnAgregar.attr("onclick", "update()");

        },
        error: function (error) {
            console.error("Error al obtener los datos del registro:", error);
        }
    });
}

function deleteById(id) {
    Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "http://localhost:9000/service-security/v1/api/lending/" + id,
                method: "delete",
                headers: {
                    "Content-Type": "application/json",
                },
            }).done(function (result) {
                loadData();
                Swal.fire({
                  title: "Deleted!",
                  text: "Your file has been deleted.",
                  icon: "success"
                });
            });
        }
      });
}


function LoadClients() {
    console.log('ejecutando LoadClient()');
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/client",
        method: "GET",
        dataType: "json",
        success: function (response) {
            if (response && response.data) {
                var selectCliente = $("#clientes");
                selectCliente.empty();
                response.data.forEach(function (cliente) {
                    var option = $("<option>")
                        .val(cliente.id)
                        .text(`${cliente.person.firstName} ${cliente.person.lastName}`);
                    selectCliente.append(option);
                });
            }
        },
        error: function (error) {
            console.error("Error al cargar la lista de clientes:", error);
        }
    });
}

function loadDataClient() {
    var id = parseInt($("#clientes").val());
    console.log(id);
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/lending/list/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("Cargando datos...");
            console.log(response.data);

            var html = "";

            response.data.forEach(function (item) {
                if (!item.deletedAt) {
                    html += `
                        <tr>
                            <td>${item.book}</td>
                            <td>${item.employed}</td>
                            <td>${item.client}</td>
                            <td>${item.amount}</td>
                            <td>${item.action ? "Prestado" : "Devuelto"}</td>
                            <td>${new Date(item.date).toLocaleString()}</td>
                            <td>${item.state ? "Activo" : "Inactivo"}</td>
                        </tr>
                    `;
                }
            });

            $("#resultData").html(html);
        },
        error: function (error) {
            console.error("Error en la solicitud:", error);
            alert("Error al cargar los datos.");
        },
    });
}

