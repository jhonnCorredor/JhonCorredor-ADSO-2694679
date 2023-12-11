async function save() {
    var id_continente = parseInt($("#pais_id").val())
    console.log(id_continente)
    
    try {
      // Esperar a que se resuelva la promesa antes de continuar
      var continente = await getPaisId(id_continente);
      
      var data = {
        "codigo": $("#codigo").val(),
        "nombre": $("#nombre").val(),
        "pais": continente,
        "estado": parseInt($("#estado").val()),
      };
  
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/v1/api/departamento",
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
    
    var id_continente = parseInt($("#pais_id").val())
  
    try{
        var continente = await getPaisId(id_continente);
      var data = {
        "codigo": $("#codigo").val(),
        "nombre": $("#nombre").val(),
        "pais": continente,
        "estado": parseInt($("#estado").val()),
      };
      
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/v1/api/departamento/" + id,
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
      url: "http://localhost:9000/v1/api/departamento",
      method: "GET",
      dataType: "json",
      success: function (data) {
        console.log(data);
        var html = "";
  
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html +=
            `<tr>
                    <td>` + item.codigo +`</td>
                    <td>` + item.nombre +`</td>
                    <td>` + item.pais.nombre + `</td>
                    <td>` + item.pais.continente.nombre + `</td>
                    <td>` + (item.estado == true ? "Activo" : "Inactivo") + `</td>
                    <th><img src="../Assets/icon/pencil-square.svg" alt="" onclick="findById(` + item.id + `)"></th>
                    <th><img src="../Assets/icon/trash3.svg" alt="" onclick="deleteById(` + item.id + `)"></th>
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
      url: "http://localhost:9000/v1/api/departamento/" + id,
      method: "GET",
      dataType: "json",
      success: function (data) {
        $("#id").val(data.id);
        $("#codigo").val(data.codigo);
        $("#pais_id").val(data.pais.id);
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
      url: "http://localhost:9000/v1/api/departamento/" + id,
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
    $("#nombre").val("");
    $("#pais_id").val("");
    $("#estado").val("");
  }
  
  function loadPais() {
    $.ajax({
      url: "http://localhost:9000/v1/api/pais",
      method: "GET",
      dataType: "json",
      success: function (data) {
        var html = "";
  
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          html += `<option value="${item.id}">${item.nombre}</option>`;
        });
  
        $("#pais_id").html(html);
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error("Error en la solicitud:", error);
      },
    });
  }
  
  async function getPaisId(id) {
    return new Promise(function(resolve, reject) {
      $.ajax({
        url: "http://localhost:9000/v1/api/pais/" + id,
        method: "GET",
        dataType: "json",
        success: function(data_Continente) {
          resolve(data_Continente);
        },
        error: function(error) {
          reject(error);
        },
      });
    });
  }