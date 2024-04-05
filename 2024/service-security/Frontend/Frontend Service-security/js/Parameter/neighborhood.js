function save() {
    
    try {
      
      var data = {
        "code": $("#codigo").val(),
        "name": $("#nombre").val(),
        "description": $("#descripcion").val(),
        "location":{
          "id": parseInt($('#locacion_id').val())
      },
        "state": parseInt($("#estado").val())
      };
  
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/neighborhood",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsonData,
        success: function(data) {
          alert("Registro agregado con éxito");
          clearData();
          loadData();
        },
        error: function(error) {
          alert(`Error no se pudo realizar el registro.`);
          //console.log($("#person_id").val());
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }


  function clearData() {
    $("#id").val("");
    $("#codigo").val("");
    $("#nombre").val("");
    $("#locacion_id").val("");
    $("#descripcion").val("");
    $("#estado").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
  }


  function loadData() {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/neighborhood",
      method: "GET",
      dataType: "json",
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          if (!item.deletedAt) {
          html +=
            `<tr>
                    <td>${item.name}</td>
                    <td>` + item.code + `</td>
                    <td>` + item.description + `</td>
                    <td>` + item.location.name + `</td>
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
    });
  }


  function deleteById(id) {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/municipality/" + id,
      method: "delete",
      headers: {
        "Content-Type": "application/json",
      },
    }).done(function (result) {
      alert("Registro eliminado con éxito");
      loadData();
    });
  }


  function update() {
    // Construir el objeto data
    try{
      var data = {
        "code": $("#codigo").val(),
        "name": $("#nombre").val(),
        "description": $("#descripcion").val(),
        "municipality":{
          "id": parseInt($('#locacion_id').val())
      },
        "state": parseInt($("#estado").val())
      };
      
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/neighborhood/" + id,
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
      alert("Error en actualizar user.");
      console.error("Error en la solicitud:", error);
      //actualzar boton
      loadData();
      clearData();
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Agregar");
      btnAgregar.attr("onclick", "save()");
    }
  }

  function findById(id) {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/neighborhood/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data=response.data;
        $("#id").val(data.id);
        $("#codigo").val(data.code);
        $('#nombre').val(data.name);
        $('#descripcion').val(data.description);
        $('#locacion_id').val(data.location.id);
        $("#estado").val(data.state == true ? 1 : 0);
  
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


  function loadLocation() {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/location",
      method: "GET",
      dataType: "json",
      success: function (response) {
        var html = "";
        if (response.status && Array.isArray(response.data)) {
            console.log(response.data);
            response.data.forEach(function (item) {
              // Construir el HTML para cada objeto
              html += `<option value="${item.id}">${item.name}</option>`;
            });
            $("#locacion_id").html(html);
          } else {
            console.error("Error: No se pudo obtener la lista de roles.");
          }
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error("Error en la solicitud:", error);
      },
    });
  }