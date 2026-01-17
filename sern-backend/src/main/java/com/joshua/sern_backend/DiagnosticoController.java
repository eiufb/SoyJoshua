@PostMapping("/diagnostico")
public Map<String, String> procesar(@RequestBody Map<String, String> datos) {
    String nombre = datos.get("usuario");
    String presupuesto = datos.get("presupuesto");
    String urgencia = datos.get("urgencia");
    
    // Algoritmo Sern de Calificación
    int score = 0;
    if ("Alto".equals(presupuesto)) score += 50;
    if ("Medio".equals(presupuesto)) score += 30;
    if ("Inmediato".equals(urgencia)) score += 40;
    
    String prioridad = (score >= 70) ? "🔥 CRÍTICA" : (score >= 40) ? "⚡ ALTA" : "🧊 BAJA";
    String id = "SERN-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();

    return Map.of(
        "id", id,
        "usuario", nombre,
        "prioridad", prioridad,
        "score", String.valueOf(score) + "/100"
    );
}
