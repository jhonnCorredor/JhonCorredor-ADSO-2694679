  
  function loadData() {
      $.ajax({
          url: "http://localhost:9000/service-security/v1/api/author",
          method: "GET",
          dataType: "json",
          success: function (response) {
              console.log(response.data);
              var html = "";
              var data = response.data;
              console.log( data);
              data.forEach(function (item) {
                  // Construir el HTML para cada objeto
                  if (!item.deletedAt) {
                      html +=
                          `<tr>
                      <td>` + item.code + `</td>
                      <td> ${item.person.firstName}  ${item.person.lastName}</td>
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
  
           
          function save(){
              try {
                
                  var data = {
                    "code" : $("#codigo").val(),
                    "person": {
                        "id": parseInt($("#person").val())
                      },
                    "state": $("#state").val() === "1" 
                  };
              
                  var jsonData = JSON.stringify(data);
                  $.ajax({
                    url: "http://localhost:9000/service-security/v1/api/author",
                    method: "POST",
                    dataType: "json",
                    contentType: "application/json",
                    data: jsonData,
                    success: function(data) {
                      Swal.fire({
                        title: "perfect!",
                        text: "Registro agregado con éxito!",
                        icon: "success",
                        timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
                        buttons: false // Deshabilitar botones de confirmación y cancelación
                    });
                      // clearData();
                      loadData();
                    },
                    error: function(error) {
                      //console.log($("#person_id").val());
                    },
                  });
                } catch (error) {
                  console.error("Error obteniendo el cliente:", error);
                }
          }
  
  function deleteById(id) {
    Swal.fire({
      title: "Are you sure?",
      text: "You won't be able to revert this!",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes, delete it!"
    }).then((result) => {
      if (result.isConfirmed) {
        $.ajax({
          url: "http://localhost:9000/service-security/v1/api/author/" + id,
          method: "delete",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          loadData();
          Swal.fire({
            title: "Deleted!",
            text: "Your file has been deleted.",
            icon: "success"
          });
        });
      }
    });
    }
  
  
    function update() {

      
      try{
        var data = {
          "code" : $("#codigo").val(),
          "person" :{
          "id" : parseInt($("#person").val())
        },
        "state": $("#state").val() === "1" 
        };
    
        console.log(data);
        
        var id = $("#id").val();
        var jsonData = JSON.stringify(data);
    
        $.ajax({
          url: "http://localhost:9000/service-security/v1/api/author/" + id,
          data: jsonData,
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
        }).done(function (result) {
          Swal.fire({
            title: "perfect!",
            text: "Registro actualizado con éxito!",
            icon: "success",
            timer: 8000, // Tiempo en milisegundos (2 segundos en este caso)
            buttons: false // Deshabilitar botones de confirmación y cancelación
        });
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
        url: "http://localhost:9000/service-security/v1/api/author/" + id,
        method: "GET",
        dataType: "json",
        success: function (response) {
          var data=response.data;
          $("#id").val(data.id);
          $("#person").val(data.person.id);
          $("#codigo").val(data.code);   
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
      $("#person").val("");
      $("#codigo").val("");
      $("#estado").val("");
    }

    function loadPerson() {
        $.ajax({
            url: "http://localhost:9000/service-security/v1/api/person",
            method: "GET",
            dataType: "json",
            success: function (response) {
    
                // Verifica que la respuesta contenga datos
                if (response && response.data) {
                    // Obtén el elemento select del formulario
                    var selectPerson = $("#person");
                    // Vacía las opciones actuales
                    selectPerson.empty();
                    // Itera sobre la lista de personas y crea opciones para el select
                    response.data.forEach(function (person) {
                        // Añade una opción para cada persona
                        var option = $("<option>")
                            .val(person.id) // El valor de la opción será el ID del persona
                            .text(`${person.firstName} ${person.lastName}`); // El texto de la opción será el título del persona
                        // Añade la opción al select
                        selectPerson.append(option);
                    });
    
                }
            },
            error: function (error) {
                console.error("Error al cargar la lista de personas:", error);
            }
        });
    }