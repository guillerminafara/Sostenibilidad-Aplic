<?php
// Datos de entrada: comunidades (municipios) y su infraestructura de agua
$comunidades = [
    ["nombre" => "Paiporta", "poblacion" => 5000, "pozos" => 8, "acueducto" => true],
    ["nombre" => "Picanya", "poblacion" => 3000, "pozos" => 3, "acueducto" => false],
    ["nombre" => "Sedavi", "poblacion" => 7000, "pozos" => 12, "acueducto" => true]
];
// Función lambda para calcular el acceso a agua potable
$calcularAcceso = function ($comunidad) {
    $totalAcceso = 0;
    $accesoBase = $comunidad["acueducto"] ? 0.9 : 0.4; // 90% o 40% decobertura base

    $bonoPozos = ($comunidad["pozos"] / max(1, $comunidad["poblacion"])) * 1000; //Bono por pozos (1 pozo cada 1000 personas = +10%)

    $bonoPozos=min(0.30, 0.1);

    $totalAcceso = $accesoBase + $bonoPozos;
    $totalAcceso= max(0, $totalAcceso);
    $totalAcceso= min(1, $totalAcceso);

    return $totalAcceso;
    // return $accesoBase + $bonoPozos;
};
// Calcular población total y con acceso
$poblacionTotal = 0;
$poblacionConAcceso = 0;
echo "<h2>Poblaciones con acceso a agua</h2>";
foreach ($comunidades as $comunidad) {
    $poblacionTotal += $comunidad["poblacion"];
    $acceso = $calcularAcceso($comunidad);
    $acceso = round($acceso * 100, 2);
    echo "<p>$comunidad[nombre]:  $acceso %  de la población</p>";
    $poblacionConAcceso += $comunidad["poblacion"] * $acceso;
}
$global= $poblacionTotal>0 ?round($poblacionConAcceso/$poblacionTotal): 0;
echo "<br>";
echo "<p>Población total $poblacionTotal,</p> ";
echo"<p> Porcentaje general: $global%</p>";
echo "<p>Población con acceso  $poblacionConAcceso </p>";
echo "<br>";

echo "Cálculo completado";
