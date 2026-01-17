@PostMapping("/diagnostico")
public Map<String, String> procesar(@RequestBody Map<String, String> datos) {
    // 1. Capturamos los datos que vienen del formulario
    String nombre = datos.get("usuario");
    String servicio = datos.get("tipoServicio");
    String presupuesto = datos.get("presupuesto");
    String urgencia = datos.get("urgencia");

    // 2. Creamos un ID único (estilo Sern) para que el mensaje se vea profesional
    String idDiagnostico = "SERN-" + java.util.UUID.randomUUID().toString().substring(0, 5).toUpperCase();

    // 3. Armamos el mensaje exacto que pediste
    // El formato será: "Hola Joshua! Soy [nombre]. Me interesa el servicio de [servicio] y quiero una consultoría."
    String mensajeFormateado = "Hola Joshua! Soy " + nombre + ". Me interesa el servicio de " + servicio + " y quiero una consultoría.";

    // 4. Devolvemos todo al Frontend
    return Map.of(
        "id", idDiagnostico,
        "usuario", nombre,
        "mensaje", mensajeFormateado,
        "status", "success"
    );
}
