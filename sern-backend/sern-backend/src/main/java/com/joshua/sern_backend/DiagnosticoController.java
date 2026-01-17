package com.joshua.sern_backend;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // Esto es vital para que tu web no sea bloqueada
public class DiagnosticoController {

    @PostMapping("/diagnostico")
    public Map<String, String> procesar(@RequestBody Map<String, String> datos) {
        // Extraemos los datos que vienen de tu diseño Sern
        String usuario = datos.get("usuario");
        String servicio = datos.get("tipoServicio");
        
        // Creamos un ID de diagnóstico único para darle autoridad a tu consultoría
        String idDiagnostico = "SERN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
        // Lógica de prioridad: Si pide App es ALTA, si es Landing es MEDIA
        String prioridad = (servicio != null && servicio.contains("Web App")) ? "ALTA (SISTEMA)" : "MEDIA (LANDING)";

        // Java devuelve esto a tu página web
        return Map.of(
            "id", idDiagnostico,
            "usuario", usuario != null ? usuario : "Prospecto Sern",
            "prioridad", prioridad,
            "mensaje", "Análisis estratégico completado para " + servicio,
            "status", "success"
        );
    }
}