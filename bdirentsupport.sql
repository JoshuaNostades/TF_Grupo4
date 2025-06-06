-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2025 a las 15:36:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdirentsupport`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE `asistencias` (
  `id_asistencia` int(11) NOT NULL,
  `id_tecnico` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora_entrada` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos_calendario`
--

CREATE TABLE `eventos_calendario` (
  `id_evento` int(11) NOT NULL,
  `id_plantilla` int(11) DEFAULT NULL,
  `fecha_evento` date DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

CREATE TABLE `informes` (
  `id_informe` int(11) NOT NULL,
  `id_ticket` int(11) DEFAULT NULL,
  `id_tecnico` int(11) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `fecha` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_anexos`
--

CREATE TABLE `inventario_anexos` (
  `id_inventario` int(11) NOT NULL,
  `direccion_ip` varchar(50) DEFAULT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL,
  `hostname` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_biometrico`
--

CREATE TABLE `inventario_biometrico` (
  `id_inventario` int(11) NOT NULL,
  `serie` varchar(100) DEFAULT NULL,
  `ip_biometrico` varchar(50) DEFAULT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_equipos`
--

CREATE TABLE `inventario_equipos` (
  `id_inventario` int(11) NOT NULL,
  `procesador` varchar(100) DEFAULT NULL,
  `ram` varchar(50) DEFAULT NULL,
  `disco_duro` varchar(100) DEFAULT NULL,
  `antivirus` varchar(100) DEFAULT NULL,
  `nombre_usuario` varchar(100) DEFAULT NULL,
  `nombre_equipo` varchar(100) DEFAULT NULL,
  `mac_address` varchar(50) DEFAULT NULL,
  `seguridad` varchar(100) DEFAULT NULL,
  `teclado` varchar(50) DEFAULT NULL,
  `mouse` varchar(50) DEFAULT NULL,
  `adaptadores` text DEFAULT NULL,
  `red_hdmi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_general`
--

CREATE TABLE `inventario_general` (
  `id_inventario` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `id_tipo` int(11) DEFAULT NULL,
  `contrato` varchar(100) DEFAULT NULL,
  `anio_fabricacion` int(11) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `marca` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `serie` varchar(100) DEFAULT NULL,
  `piso` varchar(50) DEFAULT NULL,
  `ubicacion_area` varchar(100) DEFAULT NULL,
  `fecha_inventario` date DEFAULT NULL,
  `tecnico_responsable` varchar(100) DEFAULT NULL,
  `jefe_sede` varchar(100) DEFAULT NULL,
  `observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_impresoras`
--

CREATE TABLE `inventario_impresoras` (
  `id_inventario` int(11) NOT NULL,
  `ip_impresora` varchar(50) DEFAULT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL,
  `hostname` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_panacast`
--

CREATE TABLE `inventario_panacast` (
  `id_inventario` int(11) NOT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_proyectores`
--

CREATE TABLE `inventario_proyectores` (
  `id_inventario` int(11) NOT NULL,
  `etiqueta` varchar(100) DEFAULT NULL,
  `hostname` varchar(100) DEFAULT NULL,
  `direccion_ip` varchar(50) DEFAULT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL,
  `hora_luz_fabrica` int(11) DEFAULT NULL,
  `hora_luz_consumidos` int(11) DEFAULT NULL,
  `hora_luz_restante` int(11) DEFAULT NULL,
  `cables` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_robotica`
--

CREATE TABLE `inventario_robotica` (
  `id_inventario` int(11) NOT NULL,
  `numero_parte` varchar(100) DEFAULT NULL,
  `series` varchar(100) DEFAULT NULL,
  `procesador` varchar(100) DEFAULT NULL,
  `ram` varchar(100) DEFAULT NULL,
  `disco_solido` varchar(100) DEFAULT NULL,
  `tarjeta_video` varchar(100) DEFAULT NULL,
  `modelo_video` varchar(100) DEFAULT NULL,
  `ram_video` varchar(100) DEFAULT NULL,
  `cargador` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario_televisores`
--

CREATE TABLE `inventario_televisores` (
  `id_inventario` int(11) NOT NULL,
  `direccion_ip` varchar(50) DEFAULT NULL,
  `direccion_mac` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes_chat`
--

CREATE TABLE `mensajes_chat` (
  `id_mensaje` int(11) NOT NULL,
  `emisor` int(11) DEFAULT NULL,
  `receptor` int(11) DEFAULT NULL,
  `mensaje` text DEFAULT NULL,
  `fecha_envio` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantillas`
--

CREATE TABLE `plantillas` (
  `id_plantilla` int(11) NOT NULL,
  `id_tecnico` int(11) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `visible_admin` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnicos`
--

CREATE TABLE `tecnicos` (
  `id_tecnico` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tickets`
--

CREATE TABLE `tickets` (
  `id_ticket` int(11) NOT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `estado` enum('abierto','en_proceso','cerrado') DEFAULT 'abierto',
  `prioridad` enum('baja','media','alta') DEFAULT 'media',
  `id_usuario` int(11) DEFAULT NULL,
  `id_tecnico` int(11) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT current_timestamp(),
  `fecha_cierre` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_equipo`
--

CREATE TABLE `tipo_equipo` (
  `id_tipo` int(11) NOT NULL,
  `nombre_tipo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `rol` enum('admin','tecnico') NOT NULL,
  `fecha_registro` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD PRIMARY KEY (`id_asistencia`),
  ADD KEY `id_tecnico` (`id_tecnico`);

--
-- Indices de la tabla `eventos_calendario`
--
ALTER TABLE `eventos_calendario`
  ADD PRIMARY KEY (`id_evento`),
  ADD KEY `id_plantilla` (`id_plantilla`);

--
-- Indices de la tabla `informes`
--
ALTER TABLE `informes`
  ADD PRIMARY KEY (`id_informe`),
  ADD KEY `id_ticket` (`id_ticket`),
  ADD KEY `id_tecnico` (`id_tecnico`);

--
-- Indices de la tabla `inventario_anexos`
--
ALTER TABLE `inventario_anexos`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_biometrico`
--
ALTER TABLE `inventario_biometrico`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_equipos`
--
ALTER TABLE `inventario_equipos`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_general`
--
ALTER TABLE `inventario_general`
  ADD PRIMARY KEY (`id_inventario`),
  ADD KEY `id_tipo` (`id_tipo`);

--
-- Indices de la tabla `inventario_impresoras`
--
ALTER TABLE `inventario_impresoras`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_panacast`
--
ALTER TABLE `inventario_panacast`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_proyectores`
--
ALTER TABLE `inventario_proyectores`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_robotica`
--
ALTER TABLE `inventario_robotica`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `inventario_televisores`
--
ALTER TABLE `inventario_televisores`
  ADD PRIMARY KEY (`id_inventario`);

--
-- Indices de la tabla `mensajes_chat`
--
ALTER TABLE `mensajes_chat`
  ADD PRIMARY KEY (`id_mensaje`),
  ADD KEY `emisor` (`emisor`),
  ADD KEY `receptor` (`receptor`);

--
-- Indices de la tabla `plantillas`
--
ALTER TABLE `plantillas`
  ADD PRIMARY KEY (`id_plantilla`),
  ADD KEY `id_tecnico` (`id_tecnico`);

--
-- Indices de la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  ADD PRIMARY KEY (`id_tecnico`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_tecnico` (`id_tecnico`);

--
-- Indices de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  MODIFY `id_asistencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `eventos_calendario`
--
ALTER TABLE `eventos_calendario`
  MODIFY `id_evento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `informes`
--
ALTER TABLE `informes`
  MODIFY `id_informe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inventario_general`
--
ALTER TABLE `inventario_general`
  MODIFY `id_inventario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensajes_chat`
--
ALTER TABLE `mensajes_chat`
  MODIFY `id_mensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `plantillas`
--
ALTER TABLE `plantillas`
  MODIFY `id_plantilla` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  MODIFY `id_tecnico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id_ticket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD CONSTRAINT `asistencias_ibfk_1` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`);

--
-- Filtros para la tabla `eventos_calendario`
--
ALTER TABLE `eventos_calendario`
  ADD CONSTRAINT `eventos_calendario_ibfk_1` FOREIGN KEY (`id_plantilla`) REFERENCES `plantillas` (`id_plantilla`);

--
-- Filtros para la tabla `informes`
--
ALTER TABLE `informes`
  ADD CONSTRAINT `informes_ibfk_1` FOREIGN KEY (`id_ticket`) REFERENCES `tickets` (`id_ticket`),
  ADD CONSTRAINT `informes_ibfk_2` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`);

--
-- Filtros para la tabla `inventario_anexos`
--
ALTER TABLE `inventario_anexos`
  ADD CONSTRAINT `inventario_anexos_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_biometrico`
--
ALTER TABLE `inventario_biometrico`
  ADD CONSTRAINT `inventario_biometrico_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_equipos`
--
ALTER TABLE `inventario_equipos`
  ADD CONSTRAINT `inventario_equipos_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_general`
--
ALTER TABLE `inventario_general`
  ADD CONSTRAINT `inventario_general_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_equipo` (`id_tipo`);

--
-- Filtros para la tabla `inventario_impresoras`
--
ALTER TABLE `inventario_impresoras`
  ADD CONSTRAINT `inventario_impresoras_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_panacast`
--
ALTER TABLE `inventario_panacast`
  ADD CONSTRAINT `inventario_panacast_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_proyectores`
--
ALTER TABLE `inventario_proyectores`
  ADD CONSTRAINT `inventario_proyectores_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_robotica`
--
ALTER TABLE `inventario_robotica`
  ADD CONSTRAINT `inventario_robotica_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `inventario_televisores`
--
ALTER TABLE `inventario_televisores`
  ADD CONSTRAINT `inventario_televisores_ibfk_1` FOREIGN KEY (`id_inventario`) REFERENCES `inventario_general` (`id_inventario`);

--
-- Filtros para la tabla `mensajes_chat`
--
ALTER TABLE `mensajes_chat`
  ADD CONSTRAINT `mensajes_chat_ibfk_1` FOREIGN KEY (`emisor`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `mensajes_chat_ibfk_2` FOREIGN KEY (`receptor`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `plantillas`
--
ALTER TABLE `plantillas`
  ADD CONSTRAINT `plantillas_ibfk_1` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`);

--
-- Filtros para la tabla `tecnicos`
--
ALTER TABLE `tecnicos`
  ADD CONSTRAINT `tecnicos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnicos` (`id_tecnico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
