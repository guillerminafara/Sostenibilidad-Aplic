<?php
// Datos de entrada: comunidades (municipios) y su infraestructura de agua
$comunidades = [
    ["nombre" => "Paiporta", "poblacion" => 5000, "pozos" => 8, "acueducto" => true],
    ["nombre" => "Picanya", "poblacion" => 3000, "pozos" => 3, "acueducto" => false],
    ["nombre" => "Sedavi", "poblacion" => 7000, "pozos" => 12, "acueducto" => true]
];
// Función lambda para calcular el acceso a agua potable
$calcularAcceso = function ($comunidad) {
    $accesoBase = $comunidad["acueducto"] ? 0.9 : 0.4; // 90% o 40% decobertura base

    $bonoPozos = ($comunidad["pozos"] / max(1,$comunidad["poblacion"]) )* 1000; //Bono por pozos (1 pozo cada 1000 personas = +10%)
    $toca = $bonoPozos > 1 ? 0.30 : 0; 
    return $accesoBase + $bonoPozos + $toca;
    // return $accesoBase + $bonoPozos ;

};
// Calcular población total y con acceso
$poblacionTotal = 0;
$poblacionConAcceso = 0;
foreach ($comunidades as $comunidad) {
    $poblacionTotal += $comunidad["poblacion"];
    $acceso = $calcularAcceso($comunidad);
    // $acceso = round($calcularAcceso($comunidad));

    $poblacionConAcceso += $comunidad["poblacion"] * $acceso;
} 

    echo "Población total $poblacionTotal, $acceso % , con acceso  $poblacionConAcceso ";
    echo "<br>";

echo "Cálculo completado";
?>