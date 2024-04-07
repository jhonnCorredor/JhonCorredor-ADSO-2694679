function loadData() {
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Categoria",
      method: "GET",
      dataType: "json",
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
          // Construir el HTML para cada objeto
          if (!item.deletedAt) {
            // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
  
            html +=
              `<tr>
                      <td>${item.nombre}</td>
                      <td>` +
              (item.state == true ? "Activo" : "Inactivo") +
              `</td>
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
  
  function save() {
    try {
      var personData = {
        "nombre": $("#nombre").val(),
        "state": parseInt($("#estado").val())
      };
  
      $.ajax({
        url: "http://localhost:9000/biblioteca/v1/api/Categoria",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(personData),
        success: function (data) {
          var id = data.id;
          console.log(data.data);
  
          alert("Registro agregado con éxito" + id);
          clearData();
          loadData();
        },
        error: function (error) {
          alert(
            `La persona: ${$(
              "#person_id"
            ).val()} ya cuenta con una cuenta de usuario`
          );
          //console.log($("#person_id").val());
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }
  
  function clearData() {
    $("#nombre").val(""),
      $("#estado").val("");
  }
  
  function deleteById(id) {
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Categoria/" + id,
      method: "delete",
      headers: {
        "Content-Type": "application/json",
      },
    }).done(function (result) {
      alert("Registro eliminado con éxito");
      loadData();
    });
  }
  
  function findById(id) {
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Categoria/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data = response.data;
        $("#id").val(data.id);
        $("#nombre").val(data.nombre),
  
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
  
  function update() {
      try{
        var data = {
          "nombre": $("#nombre").val(),
        "state": parseInt($("#estado").val())
        };
    
        console.log(data);
        
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
    
        $.ajax({
          url: "http://localhost:9000/biblioteca/v1/api/Categoria/" + id,
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
  