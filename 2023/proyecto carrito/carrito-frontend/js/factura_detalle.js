async function save() {
  var producto_id = parseInt($("#producto_id").val());
  console.log(producto_id);
  var factura_id = parseInt($("#factura_id").val());
  console.log(factura_id);

  try {
    // Esperar a que se resuelva la promesa antes de continuar
    var factura = await getFacturaId(factura_id);
    var producto = await getProductoId(producto_id);
    console.log(factura);
    console.log(producto);

    var data = {
      cantidad: parseInt($("#cantidad").val()),
      valorPagar: parseFloat($("#valor_pagar").val()),
      estado: parseInt($("#estado").val()),
      productoId: producto,
      facturaId: factura,
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:9000/v1/api/DetalleFactura",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: jsonData,
      success: function (data) {
        alert("Registro agregado con éxito");
        loadData();
        clearData();
      },
      error: function (error) {
        console.error("Error en la solicitud:", error);
      },
    });
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
}

async function update() {
  // Construir el objeto data
  
  var producto_id = parseInt($("#producto_id").val());
  console.log(producto_id);
  var factura_id = parseInt($("#factura_id").val());
  console.log(factura_id);

  try {
    // Esperar a que se resuelva la promesa antes de continuar
    var factura = await getFacturaId(factura_id);
    var producto = await getProductoId(producto_id);
    console.log(factura);
    console.log(producto);

    var data = {
      cantidad: parseInt($("#cantidad").val()),
      valorPagar: parseFloat($("#valor_pagar").val()),
      estado: parseInt($("#estado").val()),
      productoId: producto,
      facturaId: factura,
    };
    
    var id = $("#id").val();
    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:9000/v1/api/DetalleFactura/" + id,
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
    url: "http://localhost:9000/v1/api/DetalleFactura",
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
          item.facturaId.codigo +
          `</td>
                    <td>` +
          item.productoId.nombre +
          `</td>
                    <td>` +
          item.cantidad +
          `</td>
                    <td>` +
          item.valorPagar +
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
    url: "http://localhost:9000/v1/api/DetalleFactura/" + id,
    method: "GET",
    dataType: "json",
    success: function (data) {
      $("#id").val(data.id);
      $("#valor_pagar").val(data.valorPagar);
      $("#cantidad").val(data.cantidad);
      $("#producto_id").val(data.productoId.id);
      $("#factura_id").val(data.facturaId.id);
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
    url: "http://localhost:9000/v1/api/DetalleFactura/" + id,
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
  $("#valor_pagar").val("");
  $("#producto_id").val("");
  $("#factura_id").val("");
  $("#estado").val("");
}

function loadFactura() {
  $.ajax({
    url: "http://localhost:9000/v1/api/factura",
    method: "GET",
    dataType: "json",
    success: function (data) {
      var html = "<option selected>--Seleccione--</option>";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html += `<option value="${item.id}">${item.codigo}</option>`;
      });

      $("#factura_id").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

function loadProducto() {
  $.ajax({
    url: "http://localhost:9000/v1/api/producto",
    method: "GET",
    dataType: "json",
    success: function (data) {
      var html = "<option selected>--Seleccione--</option>";

      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        html += `<option value="${item.id}">${item.nombre}</option>`;
      });

      $("#producto_id").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}

async function getFacturaId(id) {
  return new Promise(function (resolve, reject) {
    $.ajax({
      url: "http://localhost:9000/v1/api/factura/" + id,
      method: "GET",
      dataType: "json",
      success: function (data_factura) {
        resolve(data_factura);
      },
      error: function (error) {
        reject(error);
      },
    });
  });
}

async function getProductoId(id) {
  return new Promise(function (resolve, reject) {
    $.ajax({
      url: "http://localhost:9000/v1/api/producto/" + id,
      method: "GET",
      dataType: "json",
      success: function (data_producto) {
        resolve(data_producto);
      },
      error: function (error) {
        reject(error);
      },
    });
  });
}


