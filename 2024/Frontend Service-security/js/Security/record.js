function save() {
  try {
    var selectedCityId = parseInt($("#selected_city_id").val());
    if (isNaN(selectedCityId) || selectedCityId === null) {
      Swal.fire({
        title: "Oops!",
        text: "failed registration city!",
        icon: "error",
        timer: 2000, 
        buttons: false 
    });
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


    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/person/validationSave",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(personData),
      success: function(data) {
        var id = data.data.id;
        console.log(data);
       
        User(id); // Aquí se pasa el ID a la función User
       // alert("Registro agregado con éxito" + id);
        clearData();
        loadData();
      },
      error: function(error) {
        alert(error.responseJSON.message);
      },
    });
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
}


function User(id) {
  try {
    var data = {
      "username": $("#email").val(),
      "password": $("#password").val(),
      "person": {
        "id": id
      },
      "role": [{
        "id": 2
      }],
      "state": true
    };

    var jsonData = JSON.stringify(data);
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/user",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: jsonData,
      success: function(data) {
        
        Swal.fire({
          title: "Perfect!",
          text: "Successful registration!",
          icon: "success",
          timer: 2000, 
          buttons: false 
      }).then(()=>{
        window.location.href = '../login.html';
      });
        
        
      },
      error: function(error) {
        alert(`La persona: ${$("#person_id").val()} ya cuenta con una cuenta de usuario`);
      },
    });
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }
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
          source: function(request, response) {
            var results = $.ui.autocomplete.filter(cities, request.term);
            if (!results.length) {
              results = [{ label: 'No se encontraron resultados', value: null }];
            }
            response(results);
          },
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
  
  
  
  
  function clearData() {
    $("#id").val("");
    $("#firstName").val("");
    $("#lastName").val("");
    $("#email").val("");
    $("#phone").val("");
    $("#dateOfBirth").val("");
    $("#gender").val("");
    $("#address").val("");
    $("#city_id").val("");
   
    $("#estado").val("");
  }
  function loadData() {
    console.log("ejecutando loadData");
    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/person",
      method: "GET",
      dataType: "json",
      success: function (response) {
        console.log(response.data);
        var html = "";
        var data = response.data;
        data.forEach(function (item) {
          if (!item.deletedAt) { // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)
            // Construir el HTML para cada objeto
            html +=
              `<tr>
                <td>${item.firstName}</td>
                <td>${item.lastName}</td>
                <td>${item.email}</td>
                <td>${item.phone}</td>
                <td>${item.dateOfBirth}</td>
                <td>${item.gender}</td>
                <td>${item.address}</td>
                <td>${item.city.name_city}</td>
                <td>${item.deletedAt ? "Eliminado" : "Activo"}</td>
                <td>
                  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})">
                    <img src="../assets/icon/pencil-square.svg">
                  </button>
                  <button type="button" class="btn btn-primary" onclick="deleteById(${item.id})">
                    <img src="../assets/icon/trash3.svg">
                  </button>
                </td>
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
      url: "http://localhost:9000/service-security/v1/api/person/" + id,
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
      url: "http://localhost:9000/service-security/v1/api/person/" + id,
      method: "GET",
      dataType: "json",
      success: function (response) {
        var data=response.data;
        $("#id").val(data.id);
        $("#firstName").val(data.firstName);
        $("#lastName").val(data.lastName);
        $('#email').val(data.email);
        $('#phone').val(data.phone);
        $('#dateOfBirth').val(data.dateOfBirth);
        $('#gender').val(data.gender);
        $('#address').val(data.address);
    
        $("#selected_city_id").val(data.city.id);
        $("#city_id").val(data.city.firstName+" "+data.city.lastName);
       
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
  
  
  function clearData() {
    $("#id").val("");
   
    $("#email").val("");
    $("#phone").val("");
    $("#dateOfBirth").val("");
    $("#gender").val("");
    $("#address").val("");
    $("#city_id").val("");
   
    $("#estado").val("");
  }
  