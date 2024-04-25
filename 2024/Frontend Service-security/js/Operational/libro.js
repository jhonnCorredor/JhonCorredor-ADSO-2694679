function loadData() {

    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/book",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("ejecutando loadData");
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                if (!item.deletedAt) {
                    //&& item.cantidad != 0
                    html +=
                        `<tr>
                        <td>` + item.title + `</td>
                        <td>` + item.author.person.firstName + `</td>
                        <td>` + item.code + `</td>
                        <td>` + item.amount + `</td>
                        <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                    <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> <img src="/assets/icon/pencil-square.svg" > </button>
                    <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/assets/icon/trash3.svg" > </button></td>
                </tr>`;
                }

            });
            $("#resultData").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    })
}

function clearData() {
    $("#id").val("");
    $("#titulo").val("");
    $("#autor").val("");
    $("#codigo").val("");
    $("#cantidad").val("");
    $("#state").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
    btnAgregar.text("Agregar");
    btnAgregar.attr("onclick", "save()");

}


function save() {
    // Obtener datos del formulario
    var libroData = {
        title: $("#titulo").val(),
        author: {
            id: parseInt($("#autor").val())
        },
        code: $("#codigo").val(),
        amount: parseInt($("#cantidad").val()), // Asegurarse de que sea un número
        state: $("#state").val() === "1" // Convertir el valor a un booleano
    };

    console.log(libroData);
    // Validar datos antes de enviar
    if (!libroData.title || !libroData.author || !libroData.code || isNaN(libroData.amount)) {
        alert("Por favor, complete todos los campos correctamente antes de enviar.");
        return;
    }

    // Enviar datos mediante una solicitud AJAX POST
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/book",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(libroData),
        success: function (response) {
            // Manejo de éxito: notificar al usuario y actualizar la interfaz
            Swal.fire({
                title: "perfect!",
                text: "Registro agregado con éxito!",
                icon: "success",
                timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
                buttons: false // Deshabilitar botones de confirmación y cancelación
            });
            clearData(); // Limpiar el formulario
            loadData(); // Actualizar la lista de libros disponibles
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // Manejo de errores: notificar al usuario del problema
            console.error("Error en la solicitud AJAX:", textStatus, errorThrown);
            alert("Error: no se pudo realizar el registro. Por favor, intente nuevamente.");
        }
    });
}

function update() {
    // Obtén los datos del formulario
    var libroData = {
        id: parseInt($("#id").val()),
        title: $("#titulo").val(),
        author: {
            id: parseInt($("#autor").val())
        },
        code: $("#codigo").val(),
        amount: parseInt($("#cantidad").val()), // Asegurarse de que sea un número
        state: $("#state").val() === "1" // Convertir el valor a un booleano
    };

    console.log(libroData);
    // Validar datos antes de enviar
    if (!libroData.title || !libroData.author || !libroData.code || isNaN(libroData.amount)) {
        alert("Por favor, complete todos los campos correctamente antes de enviar.");
        return;
    }

    // Realiza una solicitud PUT con AJAX
    $.ajax({
        url: `http://localhost:9000/service-security/v1/api/book/${libroData.id}`,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(libroData),
        success: function (response) {
            // Manejo de éxito
            Swal.fire({
                title: "perfect!",
                text: "Registro actualizado con éxito!",
                icon: "success",
                timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
                buttons: false // Deshabilitar botones de confirmación y cancelación
            });
            clearData();
            loadData(); // Recarga los datos para reflejar los cambios
        },
        error: function (jqXHR, textStatus, errorThrown) {
            // Manejo de errores
            console.error("Error en la solicitud AJAX:", textStatus, errorThrown);
            alert(`Error: No se pudo actualizar el registro. Código de estado: ${jqXHR.status}. Por favor, intente nuevamente.`);
            console.log(jqXHR.responseText); // Muestra detalles adicionales sobre el error
        }
    });
}


function findById(id) {
    $.ajax({
        url: `http://localhost:9000/service-security/v1/api/book/` + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            // Llenar el formulario con los datos obtenidos
            $("#id").val(data.id);
            $("#titulo").val(data.title);
            $("#autor").val(data.author.id);
            $("#codigo").val(data.code);
            $("#cantidad").val(data.amount);
            $("#state").val(data.state ? "1" : "0"); // Convertir a valores de select
            // Abre la modal (si está cerrada) para editar los datos
            $('#staticBackdrop').modal('show');

            //Cambiar boton.
            var btnAgregar = $('button[name="btnAgregar"]');
            btnAgregar.text("Actualizar");
            btnAgregar.attr("onclick", "update()");
        },
        error: function (error) {
            // Manejo de errores
            console.error("Error en la solicitud AJAX:", error);
            alert("Error al obtener los datos del libro.");
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
                url: "http://localhost:9000/service-security/v1/api/book/" + id,
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

function loadAuthor() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/author",
        method: "GET",
        dataType: "json",
        success: function (response) {

            // Verifica que la respuesta contenga datos
            if (response && response.data) {
                // Obtén el elemento select del formulario
                var selectAuthor = $("#autor");
                // Vacía las opciones actuales
                selectAuthor.empty();
                // Itera sobre la lista de Authores y crea opciones para el select
                response.data.forEach(function (author) {
                    // Añade una opción para cada Author
                    var option = $("<option>")
                        .val(author.id) // El valor de la opción será el ID del Author
                        .text(`${author.person.firstName} ${author.person.lastName}`); // El texto de la opción será el título del Author
                    // Añade la opción al select
                    selectAuthor.append(option);
                });

            }
        },
        error: function (error) {
            console.error("Error al cargar la lista de personas:", error);
        }
    });
}