// Obtener los datos del usuario almacenados en localStorage
var userData = JSON.parse(localStorage.getItem('userData'));

// Función para cargar contenido en el iframe
function loadContent(viewRoute) {
    var contentFrame = document.getElementById('contentFrame');
    contentFrame.src = viewRoute;
    console.log("Ruta de la vista cargada: " + viewRoute);
}

// Verificar si se han encontrado datos de usuario y si hay al menos un módulo
if (userData && userData.modules && userData.modules.length > 0) {
    var navbarMenu = document.getElementById('navbarMenu');

    // Recorrer cada módulo
    
    userData.modules.forEach(function(module) {
        var liItem = document.createElement('li');
        liItem.classList.add('nav-item', 'dropdown');

        var aLink = document.createElement('a');
        aLink.classList.add('nav-link', 'dropdown-toggle');
        aLink.href = '#';
        aLink.setAttribute('role', 'button');
        aLink.setAttribute('data-bs-toggle', 'dropdown');
        aLink.setAttribute('aria-expanded', 'false');
        aLink.textContent = module.module;

        // Agregar el enlace al elemento <li>
        liItem.appendChild(aLink);

        // Crear un submenú <ul> con la clase "dropdown-menu"
        var subMenu = document.createElement('ul');
        subMenu.classList.add('dropdown-menu');

        // Verificar si el módulo tiene vistas asociadas
        if (module.viewName && module.viewRoute) {
            var viewNames = module.viewName.replace(/[\[\]"]+/g, '').split(',');
            var viewRoutes = JSON.parse(module.viewRoute);

            // Iterar sobre las vistas y agregarlas al submenú
    
for (var i = 0; i < viewNames.length; i++) {
    var viewName = viewNames[i].trim();
    var viewRoute = viewRoutes[i].trim();

    var viewItem = document.createElement('li');
    var viewLink = document.createElement('a');
    viewLink.classList.add('dropdown-item');
    viewLink.textContent = viewName;

    // Utilizar un closure para capturar el valor correcto de viewRoute
    (function(route) {
        // Asignar la función loadContent al evento onclick con la ruta de la vista como argumento
        viewLink.addEventListener('click', function() {
            loadContent(route); // Pasar la ruta de la vista como argumento
            console.log("Ruta de la vista cargada: " + route);
        });
    })(viewRoute);

    // Agregar el enlace a la vista como hijo del elemento de lista
    viewItem.appendChild(viewLink);

    // Agregar la vista al submenú
    subMenu.appendChild(viewItem);
}

        }

        // Agregar el submenú al elemento <li>
        liItem.appendChild(subMenu);

        // Agregar el elemento <li> al menú de la barra de navegación
        navbarMenu.appendChild(liItem);
    });

    var logoutButton = document.createElement('button');
    logoutButton.classList.add('btn',  'ms-2');
    logoutButton.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="50" height="25" fill="red" class="bi bi-person-x" viewBox="0 0 16 16"><path d="M11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m.256 7a4.5 4.5 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10q.39 0 .74.025c.226-.341.496-.65.804-.918Q8.844 9.002 8 9c-5 0-6 3-6 4s1 1 1 1z"/><path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m-.646-4.854l.646.647.646-.647a.5.5 0 0 1 .708.708l-.647.646.647.646a.5.5 0 0 1-.708.708l-.646-.647-.646.647a.5.5 0 0 1-.708-.708"/></svg>';
    //logoutButton.textContent += ' Cerrar Sesión';
    logoutButton.addEventListener('click', function() {
        // Eliminar los datos del usuario del localStorage
        localStorage.removeItem('userData');
  
        window.location.href = '../view/Security/login.html';
    });
    navbarMenu.appendChild(logoutButton);
} else {
    console.log("No se encontraron datos de usuario o módulos disponibles.");
}
