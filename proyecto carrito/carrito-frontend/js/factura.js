async function save() {
  var id_cliente = parseInt($("#cliente_id").val())
  console.log(id_cliente)
  
  try {
    // Esperar a que se resuelva la promesa antes de continuar
    var cliente = await getClienteId(id_cliente);
    
    var data = {
      "codigo": $("#codigo").val(),
      "fecha": $("#fecha").val(),
      "valorTotal": parseFloat($("#valor_total").val()),
      "clienteId": cliente,
      "estado": parseInt($("#estado").val()),
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:9000/v1/api/factura",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: jsonData,
      success: function(data) {
        alert("Registro agregado con éxito");
        loadData();
        clearData();
      },
      error: function(error) {
        console.error("Error en la solicitud:", error);
      },
    });
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
}


async function update() {
  // Construir el objeto data
  
  var id_cliente = parseInt($("#cliente_id").val())

  try{
    var cliente = await getClienteId(id_cliente);
    var data = {
      "codigo": $("#codigo").val(),
      "fecha": $("#fecha").val(),
      "valorTotal": parseFloat($("#valor_total").val()),
      "clienteId": cliente,
      estado: parseInt($("#estado").val()),
    };
    
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:9000/v1/api/factura/" + id,
      data: jsonData,
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
    }).done(function (result) {
      alert("Registro actualizado con éxito");
      loadData();
      clearData();
  
      //actualzar boton
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Agregar");
      btnAgregar.attr("onclick", "save()");
    });
  }catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
}

function loadData() {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura",
    method: "GET",
    dataType: "json",
    success: function (data) {
      console.log(data);
      var html = "";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html +=
          `<tr>
                  <td>` +
          item.codigo +
          `</td>
                  <td>` +
          item.fecha +
          `</td>
                  <td>` +
          item.valorTotal +
          `</td>
                  <td>` +
          item.clienteId.nombre +
          `</td>
                  <td>` +
          (item.estado == true ? "Activo" : "Inactivo") +
          `</td>
                  <th><img src="../asset/icon/pencil-square.svg" alt="" onclick="findById(` +
          item.id +
          `)"></th>
                  <th><img src="../asset/icon/trash3.svg" alt="" onclick="deleteById(` +
          item.id +
          `)"></th>
              </tr>`;
      });

      $("#resultData").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

function findById(id) {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura/" + id,
    method: "GET",
    dataType: "json",
    success: function (data) {
      $("#id").val(data.id);
      $("#codigo").val(data.codigo);
      $("#fecha").val(data.fecha);
      $("#valor_total").val(data.valorTotal);
      $("#cliente_id").val(data.clienteId.id);
      $("#estado").val(data.estado == true ? 1 : 0);

      //Cambiar boton.
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Actualizar");
      btnAgregar.attr("onclick", "update()");
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

function deleteById(id) {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura/" + id,
    method: "delete",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (result) {
    alert("Registro eliminado con éxito");
    loadData();
    clearData();
  });
}

function clearData() {
  $("#id").val("");
  $("#codigo").val("");
  $("#fecha").val("");
  $("#valor_total").val("");
  $("#cliente_id").val("");
  $("#estado").val("");
}

function loadCliente() {
  $.ajax({
    url: "http://localhost:9000/v1/api/cliente",
    method: "GET",
    dataType: "json",
    success: function (data) {
      var html = "<option selected>--Seleccione--</option>";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html += `<option value="${item.id}">${item.nombre}</option>`;
      });

      $("#cliente_id").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

async function getClienteId(id) {
  return new Promise(function(resolve, reject) {
    $.ajax({
      url: "http://localhost:9000/v1/api/cliente/" + id,
      method: "GET",
      dataType: "json",
      success: function(data_cliente) {
        resolve(data_cliente);
      },
      error: function(error) {
        reject(error);
      },
    });
  });
}