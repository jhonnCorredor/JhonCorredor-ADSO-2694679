function login() {
    // Obtener los datos del formulario
    var username = document.getElementById('USERNAME').value;
    var password = document.getElementById('PASSWORD').value;

    var userData = {
        username: username,
        password: password
    };

    $.ajax({
        url: 'http://localhost:9000/service-security/v1/api/user/login',
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(userData),
        success: function (data) {  
            if (data && data.data) {
                 // Almacenar los datos del usuario en localStorage
            localStorage.setItem('userData', JSON.stringify(data.data));

            // Redirigir al usuario al navbar o a la página que necesites
            
            console.log("dato consedido");
            
            Swal.fire({
                title: "Perfect!",
                text: "access granted!",
                icon: "success",
                timer: 2000, 
                buttons: false 
            }).then(()=>{
                window.location.href = "/view/navbar.html";

            });
            // Notificar al usuario que el acceso ha sido concedido
            //alert(alert());
           // console.log("dsddsds")

            }
            else{

                
                    swal.fire({
                        title: "Oops!",
                        text: "Failed to log in!",
                        icon: "error",
                        timer: 2000, // Tiempo en milisegundos (2 segundos en este caso)
                        buttons: false // Deshabilitar botones de confirmación y cancelación
                    });
                
            }
           

        
        },
        error: function (error) {
            console.error('Error en la solicitud:', error);
            // Si hay un error en la solicitud, redireccionar a la página de inicio de sesión
            window.location.href = "../login.html";
        }
    });
}
// function alert(){
//     return`<div class="alert alert-success d-flex align-items-center" role="alert">
//     <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
//     <div>
//       An example success alert with an icon
//     </div>`
// }
