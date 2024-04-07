function loadData() {
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Bibliotecario",
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
                        <td>${item.codigo}</td>
                        <td>${item.person.nombre}</td>
                        <td>${item.person.direccion}</td>
                        <td>${item.person.telefono}</td>
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
      var selectedPersonId = parseInt($("#selected_person_id").val());
    if (isNaN(selectedPersonId) || selectedPersonId === null) {
      return;
    }
    try {
      var personData = {
          "codigo": $("#codigo").val(),
          "person": {
            "id": selectedPersonId,
          },
          "state": true,
      };
  
      $.ajax({
        url: "http://localhost:9000/biblioteca/v1/api/Bibliotecario",
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
    $("#codigo").val(""),
      $("#selected_person_id").val(""),
      $("#person_id").val(""),
      $("#estado").val("");
  }
  
  function deleteById(id) {
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Bibliotecario/" + id,
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
      url: "http://localhost:9000/biblioteca/v1/api/Bibliotecario/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data = response.data;
        $("#id").val(data.id);
        $("#codigo").val(data.codigo),
          $("#selected_person_id").val(data.person.id),
          $("#person_id").val(data.person.nombre),
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
    var selectedPersonId = parseInt($("#selected_person_id").val());
    if (isNaN(selectedPersonId) || selectedPersonId === null) {
      return;
    }
    try {
      var data = {
        "codigo": $("#codigo").val(),
        "person": {
          "id": selectedPersonId,
        },
        "state": true,
      };
  
      console.log(data);
  
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
  
      $.ajax({
        url: "http://localhost:9000/biblioteca/v1/api/Bibliotecario/" + id,
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
    } catch (error) {
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
  
  function loadPerson() {
    console.log("Ejecutando loadCity");
    $.ajax({
      url: "http://localhost:9000/biblioteca/v1/api/Person",
      method: "GET",
      dataType: "json",
      success: function (response) {
        if (response.status && Array.isArray(response.data)) {
          var cities = response.data.map(function (person) {
            return {
              label: person.nombre,
              value: person.id, // Agrega el ID como valor
            };
          });
  
          // Inicializar el autocompletado en el campo de entrada de texto
          $("#person_id").autocomplete({
            source: function (request, response) {
              var results = $.ui.autocomplete.filter(cities, request.term);
              if (!results.length) {
                results = [
                  { label: "No se encontraron resultados", value: null },
                ];
              }
              response(results);
            },
            select: function (event, ui) {
              // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
              $("#selected_person_id").val(ui.item.value);
              // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
              $("#person_id").val(ui.item.label);
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; // Evita la propagación del evento y el formulario de envío
            },
          });
        } else {
          console.error("Error: No se pudo obtener la lista de ciudades.");
        }
      },
      error: function (error) {
        // Función que se ejecuta si hay un error en la solicitud
        console.error("Error en la solicitud:", error);
      },
    });
  }
  