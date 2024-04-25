function LoadClient() {
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
                        .text(cliente.person.firstName);
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

