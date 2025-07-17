<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fondo Pastel en Clase</title>
    <style>
        .fondo-pastel-animado {
            position: relative;
            overflow: hidden;
        }

        .fondo-pastel-animado::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(-45deg,
                #fff5b7,   /* Amarillo pastel */
                #b3e5fc,   /* Celeste chicle */
                #ffb3c6,   /* Rosado pastel */
                #c8facc    /* Verde pastel */
            );
            background-size: 600% 600%;
            animation: pastelFlow 20s ease infinite;
            z-index: -1;
        }

        @keyframes pastelFlow {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .fondo-pastel-animado > * {
            position: relative;
            z-index: 1;
        }

        .caja-central {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        h1 {
            font-size: 3em;
            text-shadow: 0 0 8px rgba(255, 255, 255, 0.6);
            color: #333;
        }
    </style>
</head>
<body>
    <div class="fondo-pastel-animado caja-central">
        <h1>Hello World!</h1>
    </div>
</body>
</html>