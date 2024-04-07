function save() {
    var selectedEmployId = parseInt($("#selected_empleado_id").val());
    if (isNaN(selectedEmployId) || selectedEmployId === null) {
      console.error("ID de empleado no válido");
      return;
    }

    console.log(selectedEmployId);

    var selectedCompanyId = parseInt($("#selected_company_id").val());
    if (isNaN(selectedCompanyId) || selectedCompanyId === null) {
      console.error("ID de ciudad no válido");
      return;
    }

    try {
      
      var data = {
        "code": $("#code").val(),
        "dateStart": $("#dateStart").val(),
        "dateEnding": $("#dateEnding").val(),
        "salary": Number($("#salary").val()),
        "object": $("#Object").val(),
        "employed": {
            "id": selectedEmployId
          },
          "company": {
            "id": selectedCompanyId
          },
        "state": parseInt($("#estado").val())
      };
  
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/contract",
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
    $("#code").val("");
    $("#dateStart").val("");
    $("#dateEnding").val("");
    $("#salary").val("");
    $("#Object").val("");
    $("#empleado_id").val("");
    $("#company_id").val("");
    $("#estado").val("");
    var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "save()");
  }


  function loadData() {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/contract/list",
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
                    <td>${item.code}</td>
                    <td>` + item.salary + `</td>
                    <td>` + item.person + `</td>
                    <td>` + item.company + `</td>
                    <td>` + item.object + `</td>
                    <td>` + item.date_start + `</td>
                    <td>` + item.date_ending + `</td>
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
      url: "http://localhost:9000/service-security/v1/api/contract/" + id,
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
    var selectedEmployId = parseInt($("#selected_empleado_id").val());
    if (isNaN(selectedEmployId) || selectedEmployId === null) {
      console.error("ID de empleado no válido");
      return;
    }

    console.log(selectedEmployId);

    var selectedCompanyId = parseInt($("#selected_company_id").val());
    if (isNaN(selectedCompanyId) || selectedCompanyId === null) {
      console.error("ID de ciudad no válido");
      return;
    }
    // Construir el objeto data
    try{
      var data = {
        "code": $("#code").val(),
        "dateStart": $("#dateStart").val(),
        "dateEnding": $("#dateEnding").val(),
        "salary": Number($("#salary").val()),
        "object": $("#Object").val(),
        "employed": {
            "id": selectedEmployId
          },
          "company": {
            "id": selectedCompanyId
          },
        "state": parseInt($("#estado").val())
      };
      
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/contract/" + id,
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
      url: "http://localhost:9000/service-security/v1/api/contract/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data=response.data;
        $("#id").val(data.id);
        $("#code").val(data.code);
        $('#dateStart').val(data.dateStart);
        $('#dateEnding').val(data.dateEnding);
        $('#salary').val(data.salary);
        $('#Object').val(data.object);

        $("#selected_company_id").val(data.company.id);
      $("#company_id").val(data.company.rs);

      $("#selected_empleado_id").val(data.employed.id);
      $("#empleado_id").val( data.employed.person.firstName + " "+ data.employed.lastName);

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


  function loadCompany() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/company",
        method: "GET",
        dataType: "json",
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var companies = response.data.map(function(company) {
                    return {
                        label: company.rs, // Cambiar 'rs' por el nombre adecuado de la empresa
                        value: company.id
                    };
                });

                // Inicializar el autocompletado en el campo de entrada de texto
                $("#company_id").autocomplete({
                  source: function(request, response) {
                    var results = $.ui.autocomplete.filter(companies, request.term);
                    if (!results.length) {
                      results = [{ label: 'No se encontraron resultados', value: null }];
                    }
                    response(results);
                  },
                    select: function(event, ui) {
                        // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
                        $("#selected_company_id").val(ui.item.value);
                        // Actualiza el valor del campo de entrada con el nombre de la empresa seleccionada
                        $("#company_id").val(ui.item.label);
                        console.log("ID de empresa seleccionada: " + ui.item.value);
                        return false; // Evita la propagación del evento y el formulario de envío
                    }
                });
            } else {
                console.error("Error: No se pudo obtener la lista de empresas.");
            }
        },
        error: function(error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        }
    });
}

function loadEmploy() {
    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/employed/list",
        method: "GET",
        dataType: "json",
        success: function(response) {
            if (response.status && Array.isArray(response.data)) {
                var employees = response.data.map(function(employed) {
                    return {
                        label: employed.person,
                        value: employed.id
                    };
                });

                // Inicializar el autocompletado en el campo de entrada de texto
                $("#empleado_id").autocomplete({
                  source: function(request, response) {
                    var results = $.ui.autocomplete.filter(employees, request.term);
                    if (!results.length) {
                      results = [{ label: 'No se encontraron resultados', value: null }];
                    }
                    response(results);
                  },
                    select: function(event, ui) {
                        // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
                        $("#selected_empleado_id").val(ui.item.value);
                        // Actualiza el valor del campo de entrada con el ID del empleado seleccionado
                        $("#empleado_id").val(ui.item.label);
                        console.log("ID de empleado seleccionado: " + ui.item.value);
                        return false; // Evita la propagación del evento y el formulario de envío
                    }
                });
            } else {
                console.error("Error: No se pudo obtener la lista de empleados.");
            }
        },
        error: function(error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        }
    });
}

