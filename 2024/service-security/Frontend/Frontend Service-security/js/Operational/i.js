function add(id) {
    try {
      var idToUse;
      if (typeof id !== 'undefined') {
          idToUse = parseInt(id);
      } else {
          idToUse = parseInt($("#selected_document_id").val());
      }
  
      var data = {
          "state": true,
          "person": {
              "id": idToUse
          }
      };
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
        $.ajax({
          url: "http://localhost:9000/service-security/v1/api/customer",
          method: "POST",
          dataType: "json",
          contentType: "application/json",
          data: jsonData,
          success: function(data) {
            // alert("Registro agregado con éxito customer");
            clearData();
            loadData();
          },
          error: function(error) {
            alert("Error no se pudo realizar el registro.");
            //console.log($("#person_id").val());
          },
        });
      } catch (error) {
        console.error("Error obteniendo el cliente:", error);
      }
    }
  
  
    function clearData() {
      $("#id").val("");
      $("#nit").val("");
      $("#rs").val("");
      $("#web").val("");
      $("#email").val("");
      $("#phone").val("");
      $("#person_id").val("");
      $("#address").val("");
      $("#estate").val("");
      var btnAgregar = $('button[name="btnAgregar"]');
          btnAgregar.text("Agregar");
          btnAgregar.attr("onclick", "save()");
    }
  
  
    function loadData() {
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/customer",
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
                      <td>${item.person.firstName}</td>
                      <td>` + item.code + `</td>
                      
                      <td>` + item.person.email   + `</td>
                      <td>` + item.person.phone + `</td>
  
                   
                       <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                      <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.person.id})"> <img src="/Frontend Service-security/assets/icon/pencil-square.svg" > </button>
                      <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/Frontend Service-security/assets/icon/trash3.svg" > </button></td>
                  </tr>`;
            }
          });
    
          $("#resultData").html(html);
        },
        error: function (error) {
          // Función que se ejecuta si hay un error en la solicitud
          console.error("Error en la solicitud:", error);
          window.location.href = "/Frontend Service-security/404.html";
        },
      });
    }
  
  
    
  
  
  
  
    function deleteById(id) {
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/customer/" + id,
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
      var selectedpersonId = parseInt($("#selected_person_id").val());
      if (isNaN(selectedpersonId) || selectedpersonId === null) {
        console.error("ID de ciudad no válido");
        return;
      }6
      // Construir el objeto data
      try{
        var data = {
        
          "person": {
              "id": selectedpersonId
            },
          "state": parseInt($("#estate").val())
        };
    
        
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
        $.ajax({
          url: "http://localhost:9000/service-security/v1/api/customer/"+id,
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
      console.log(id +"id de modificar");
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/customer/"+ id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
      
          $("#id").val(data.id);
          
          $("#selected_person_id").val(data.person.id);
        $("#person_id").val(data.person.name);
  
          $("#estate").val(data.state == true ? 1 : 0);
    
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
  
  
    function loadPerson() {
      console.log("ejecutando loadperson");
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/person",
        method: "GET",
        dataType: "json",
        success: function (response) {
          if (response.status && Array.isArray(response.data)) {
            var cities = response.data.map(function (person) {
              return {
                label: person.firstName,
                value: person.id // Agrega el ID como valor
              };
            });
    
            // Inicializar el autocompletado en el campo de entrada de texto
            $("#person_id").autocomplete({
              source: cities,
              select: function (event, ui) {
                // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
                $("#selected_person_id").val(ui.item.value);
                // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
                $("#person_id").val(ui.item.label);
                console.log("ID de ciudad seleccionada: " + ui.item.value);
                return false; // Evita la propagación del evento y el formulario de envío
              }
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
  
  
  
  function loadDocuemt() {
    console.log("ejecutando  document");
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/person",
      method: "GET",
      dataType: "json",
      success: function (response) {
        if (response.status && Array.isArray(response.data)) {
          var cities = response.data.map(function (person) {
            return {
              label: person.document + " - " + person.firstName + " "+ person.lastName , 
              
              value: person.id // Agrega el ID como valor
            };
          });
  
          $("#document_id").autocomplete({
            source: cities,
            select: function (event, ui) {
              // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
              $("#selected_document_id").val(ui.item.value);
              
              // Divide la etiqueta para obtener el número de documento y el nombre
              var parts = ui.item.label.split(" - ");
              var documentNumber = parts[0];
              var firstName = parts[1];
              
              // Coloca el número de documento en el campo document_id
              $("#document_id").val(documentNumber);
              
              // Coloca el nombre en el campo firsName_id
              $("#firsName_id").val(firstName);
          
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; // Evita la propagación del evento y el formulario de envío
            },
            response: function(event, ui) {
              if (ui.content.length === 0) {
                // Si no se encontraron coincidencias, habilita el modal para el botón
                $("#searchButton").attr("data-bs-toggle", "modal");
                // Además, elimina el evento onclick actual y agrega el evento para guardar
                $("#searchButton").off("click").on("click", save);
                $("#searchButton").text("save");
              } else {
                // Si se encontraron coincidencias, deshabilita el modal para el botón
                $("#searchButton").removeAttr("data-bs-toggle");
                $("#searchButton").text("add");
                // Elimina el evento onclick actual y agrega el evento para abrir el modal
                $("#searchButton").off("click").on("click", add);
              }
            }
            
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
  
  
  
  
  
  
  function loadCity() {
    console.log("ejecutando loadCity");
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/municipality",
      method: "GET",
      dataType: "json",
      success: function (response) {
        if (response.status && Array.isArray(response.data)) {
          var cities = response.data.map(function (municipality) {
            return {
              label: municipality.name,
              value: municipality.id // Agrega el ID como valor
            };
          });
  
          // Inicializar el autocompletado en el campo de entrada de texto
          $("#city_id").autocomplete({
            source: cities,
            select: function (event, ui) {
              // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
              $("#selected_city_id").val(ui.item.value);
              // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
              $("#city_id").val(ui.item.label);
              console.log("ID de ciudad seleccionada: " + ui.item.value);
              return false; // Evita la propagación del evento y el formulario de envío
            }
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
  
  
  // person
  
  function save() {
    console.log("Guardando datos...");
    try {
      var selectedCityId = parseInt($("#selected_city_id").val());
      if (isNaN(selectedCityId) || selectedCityId === null) {
        console.error("ID de ciudad no válido");
        return;
      }
  
      var personData = {
        "firstName": $("#firstName").val(),
        "lastName": $("#lastName").val(),
        "typeDocument": $("#t_document").val(),
        "document": $("#document").val(),
        "email": $("#email").val(),
        "phone": $("#phone").val(),
        "dateOfBirth": $("#dateOfBirth").val(),
        "gender": $("#gender").val(),
        "address": $("#address").val() + ' No ' + $("#numeral").val() + ' - ' + $("#numeral2").val()  +' - ' + $("#description").val(),
        "ubication": $("#city_id").val(),
        "city": {
           "id": selectedCityId
        },
        "state": true
      };
      console.log(personData);
  
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/person",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(personData),
        success: function(data) {
         
        
          // alert("Registro agregado con éxito " + id);
          Swal.fire({
            title: "Perfect!",
            text: "",
            icon: "success",
            timer: 2000, 
            buttons: false 
        })
        var id = data.data.id;
  console.log("data id person " +id);
        add(id);
          clearData();
          loadData();
        },
        error: function(error) {
          alert("Error al agregar el registro de la persona.");
          console.error("Error en la solicitud de inserción:", error);
        },
      });
    } catch (error) {
      console.error("Error obteniendo el cliente:", error);
    }
  }
  
  
  
  function findById(id) {
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/person/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data = response.data;
        console.log(data.municipality.name);
        $("#id").val(data.id);
        $("#firstName").val(data.firstName);
        $("#lastName").val(data.lastName);
        $("#t_document").val(data.typeDocument); // Corregir aquí el selector
        $("#document").val(data.document);
        $('#email').val(data.email);
        $('#phone').val(data.phone);
        $('#dateOfBirth').val(data.dateOfBirth);
        $('#gender').val(data.gender);
        $('#address').val(data.address);
  
        $("#selected_city_id").val(data.municipality.id);
        $("#city_id").val(data.municipality.name);
  
        $("#estado").val(data.state == true ? 1 : 0);
        
        // Cambiar boton.
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
    // Construir el objeto data
    var selectedCityId = parseInt($("#selected_city_id").val());
    if (isNaN(selectedCityId) || selectedCityId === null) {
      console.error("ID de ciudad no válido");
      return;
    }
    try{
      var data = {
        "firstName": $("#firstName").val(),
        "lastName": $("#lastName").val(),
        "typeDocument": $("#t_document").val(),
        "document": $("#document").val(),
        "email": $("#email").val(),
        "phone": $("#phone").val(),
        "dateOfBirth": $("#dateOfBirth").val(),
        "gender": $("#gender").val(),
        "address": $("#address").val(),
        "city": {
          "id": selectedCityId
        },
        "state": true
      };
      console.log(data);
      
      var id = $("#id").val();
      var jsonData = JSON.stringify(data);
  
      $.ajax({
        url: "http://localhost:9000/service-security/v1/api/person/" + id,
        data: jsonData,
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
      }).done(function (result) {
      
        Swal.fire({
          title: "Perfect!",
          text: "Registration successfully updated",
          icon: "success",
          timer: 2000, 
          buttons: false 
      })
        loadData();
        clearData();
    
        //actualzar boton
        var btnAgregar = $('button[name="btnAgregar"]');
        btnAgregar.text("Agregar");
        btnAgregar.attr("onclick", "validation()");
      });
    }catch (error) {
      alert("Error en actualizar user.");
      console.error("Error en la solicitud:", error);
      //actualzar boton
      loadData();
      clearData();
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Agregar");
      btnAgregar.attr("onclick", "validation()");
    }
  }