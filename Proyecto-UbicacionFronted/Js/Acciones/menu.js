// sidebar.js
function generateSidebarContent() {
    return `
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
    
        <title>SOFTWARE INVENTORY</title>
    
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    
        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
    </head>
    
    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">
    
            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        
                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Ubicación <sup>1</sup></div>
                </a>
        
                <!-- Divider -->
                <hr class="sidebar-divider my-0">
        
                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="index.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Historial</span></a>
                </li>
        
                <!-- Divider -->
                <hr class="sidebar-divider">
        
                <!-- Heading -->
                <div class="sidebar-heading">
                    Acciones
                </div>
        
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                        aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Carrito</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Opciones:</h6>
                            <a class="collapse-item" href="buttons.html">Comprar</a>
                            <a class="collapse-item" href="cards.html">Ordenar</a>
                        </div>
                    </div>
                </li>
        
                <!-- Nav Item - Utilities Collapse Menu -->
                <!-- ... -->
        
                <!-- Divider -->
                <hr class="sidebar-divider">
        
                <!-- Heading -->
                <div class="sidebar-heading">
                    Registrar
                </div>
        
               
        
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="productosTienda.html">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Productos</span></a>
                </li>
        
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="clientesTienda.html">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Clientes</span></a>
                </li>
        
                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="facturaTienda.html">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Factura</span></a>
                </li>
        
                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">
        
                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
        
                <!-- Sidebar Message -->
                <div class="sidebar-card d-none d-lg-flex">
                    <img class="sidebar-card-illustration mb-2" src="img/undraw_rocket.svg" alt="...">
                    <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
                    <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
                </div>
        
            </ul>
            
            <!-- Contenido específico de la página principal -->
            <div id="content-wrapper" class="d-flex flex-column">
                <div id="content">
                    <!-- Contenido de la página principal -->
                </div>
            </div>
    
            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>
            <!-- Page level plugins -->
            <script src="vendor/chart.js/Chart.min.js"></script>
            <!-- Page level custom scripts -->
            <script src="js/demo/chart-area-demo.js"></script>
            <script src="js/demo/chart-pie-demo.js"></script>
            
        </div>
    </body>
    
   

    
    
    
    
    
    
    `;
}
