<%-- 
    Document   : index
    Created on : 07/05/2025, 11:31:49 AM
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>





    </head>
    <body class="min-vh-100" style="background: url('flog.png') center center / cover no-repeat;">

        <form action="gui/Prueba.jsp" method="post">

            <!-- ✅ Navbar arriba a la derecha -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid justify-content-end">
                    <a class="navbar-brand me-auto" href="#">Irent</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navbarScroll">
                        <ul class="navbar-nav navbar-nav-scroll">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Contáctenos</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Solicitar requerimiento
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                                    <li><a class="dropdown-item" href="#">Soy Cliente</a></li>
                                    <li><a class="dropdown-item" href="#">Cuenta bloqueada</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled">INICIO DE SESION - SOPORTE TÉCNICO</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


            <div class="position-fixed end-0 mt-5 me-4" style="top: 3rem; bottom: 3rem; width: 41%;">
                <div class="card h-100 w-100 rounded-start border-1 shadow-sm">
                    <div class="card-body d-flex justify-content-center align-items-center text-center">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-12 col-md-8 col-lg-6">
                                    <img src="iRent.png" class="img-fluid mb-1" alt="...">

                                    <h3 class="card-title mt-2 mb-5">Inicio de sesión</h3>

                                    <div class="form-floating mb-3">
                                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                                        <label for="floatingInput">Correo</label>
                                    </div>

                                    <div class="form-floating mb-4">
                                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                                        <label for="floatingPassword">Contraseña</label>
                                    </div>

                                    <div class="d-flex justify-content-between align-items-center mb-5 small">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="rememberCheck">
                                            <label class="form-check-label" for="rememberCheck">
                                                Guardar contraseña
                                            </label>
                                        </div>
                                        <a href="#" class="text-decoration-none">¿Olvidaste tu contraseña?</a>
                                    </div>

                                    <button type="submit" class="btn btn-danger btn-lg w-100">ENTRAR</button>

                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>








            <!-- Bootstrap JS (necesario para que funcione el dropdown y el botón colapsable) -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        </form>
    </body>
</html>
