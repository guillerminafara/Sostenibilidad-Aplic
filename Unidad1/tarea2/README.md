# Viviendas por intensidad de uso
En este proyecto extraeremos aquellos municipios con mayor consumo central eléctrico de la comunidad de Madrid durante el periodo 2021. Tanto la cantidad de municipios, como el ingreso del archivo .csv la debe ingresar el user desde terminal de la siguiente manera:   
        
        javac .\Energia.java
        java .\Energia.java .\viviendas.csv 3
        


## Tecnologías utilizadas 

**Visual Studio Code:** como entorno de desarrollo. 
**Java 17 y Java Development Kit openJDK:** herramienta para desarrollar en java incluye la JVM para ejecutar.

## Parte del código favorito      

        listaValorMunicipios.stream()
                    .limit(cant)
                    .forEach(m->System.out.printf("codigo: %s Territorio: %s  valor: %.0f \n",m.codigo, m.territorio, m.valor));

Mí favorito porque stream() crea un stream y no modifica la original, en este caso solo realiza un bucle foreach para leer el contenido de la lista, con un límite de repeticiones          