package com.example.demo.controller;

import com.example.demo.dto.Persona;
import com.example.demo.dto.ProductoDto;
import com.example.demo.dto.informacionNumeros;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//http://localhost:8080/producto-controlador/obtener-cantidad-producto

@RestController // > Enviar json y recibir json <
@RequestMapping(value = "/producto-controlador")
public class ProductoController {

    public ProductoController() {
    }

    @GetMapping(value = "/obtener-cantidad-producto")
    public ResponseEntity<Integer> cantidadProductos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(100);
    }

    @GetMapping(value = "/obtener-precios")
    public ResponseEntity<Integer[]> obtenerPrecios() {
        Integer[] precios = new Integer[100];
        for (int i = 0; i < precios.length; i++) {
            precios[i] = i * i;

        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(precios);
    }

    //Crear un endpoint que devuelva los cubos de los primeros 80 numeros naturales
    @GetMapping(value = "/obtener-cubos")
    public ResponseEntity<Integer[]> obtenerCubos() {
        Integer[] cubos = new Integer[80];
        for (int i = 0; i < cubos.length; i++) {
            cubos[i] = i * i * i;
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(cubos);
    }

    //Crear un edpoint que devuelva la fecha actual
    @GetMapping(value = "/obtener-fecha-actual")
    public ResponseEntity<String> obtenerFecha() {
        String fecha = java.time.LocalDate.now().toString();

        return ResponseEntity.status(HttpStatus.OK)
                .body(fecha);
    }

    @GetMapping(value = "/obtener-producto{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductoDto> obtenerProducto(@PathVariable("idProducto") Integer idProducto) {
        ProductoDto producto = new ProductoDto(
                idProducto,
                "Playstation",
                "Consola de videojuegos",
                9999.99);

        return ResponseEntity.status(HttpStatus.OK)
                .body(producto);
    }

    @GetMapping(value = "/obtener-lista-producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoDto>> obtenerListaProductos() {
        List<ProductoDto> productos = new ArrayList<>();
        productos.add(new ProductoDto(
                1,
                "Playstation",
                "Consola de videojuegos",
                9999.99));
        productos.add(new ProductoDto(
                2,
                "XBOX",
                "Consola de videojuegos",
                9999.99));
        productos.add(new ProductoDto(
                3,
                "Nintendo",
                "Consola de videojuegos",
                9999.99));

        return ResponseEntity.status(HttpStatus.OK)
                .body(productos);

    }

    @GetMapping(value = "/aumentar-precio-producto{precioAumentar}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoDto>> aumentarPrecioProducto(@PathVariable("precioAumentar") Double precioAumentar) {
        List<ProductoDto> productos = new ArrayList<>();
        productos.add(new ProductoDto(
                1,
                "Playstation",
                "Consola de videojuegos",
                9999.99
        ));
        productos.add(new ProductoDto(
                2,
                "XBOX",
                "Consola de videojuegos",
                9999.99
        ));
        productos.add(new ProductoDto(
                3,
                "Nintendo",
                "Consola de videojuegos",
                9999.99
        ));
        for (ProductoDto productoActual : productos) {
            productoActual.setPrecio(productoActual.getPrecio() * precioAumentar);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(productos);

    }

    //Realiza un endpoimt que dada una lista de 5 productos, convierta todos sus nombres a mayusculas
    @GetMapping(value = "/obtener-nombre-mayuculas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> obtenerNombreMayuculas() {
        List<Persona> persona = new ArrayList<>();
        persona.add(new Persona(
                "Damaris",
                "Ortiz",
                20
        ));
        persona.add(new Persona(
                "Luis",
                "Mendoza",
                80
        ));
        persona.add(new Persona(
                "Fernando",
                "Munguia",
                91
        ));
        persona.add(new Persona(
                "Laura",
                "Hernandez",
                25
        ));
        persona.add(new Persona(
                "Misterio",
                "Bebe",
                74
        ));
        for (Persona personas : persona) {
            personas.setNombre(personas.getNombre().toUpperCase());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(persona);

    }
    //Realiza un endpoint que dada una lista de 5 productos, elimine con el metodo replace la palabra CONSOLA de su descripcion solo para aquellos que lo tengan
    @GetMapping(value = "/eliminar-consola-producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductoDto>> eliminarConsolaProductos() {
        List<ProductoDto> productos = new ArrayList<>();
        productos.add(new ProductoDto(
                1,
                "Playstation",
                "Consola de videojuegos",
                9999.99));
        productos.add(new ProductoDto(
                2,
                "XBOX",
                "Consola de videojuegos",
                9999.99));
        productos.add(new ProductoDto(
                3,
                "Nintendo",
                "Consola de videojuegos",
                9999.99));

        for (ProductoDto producto : productos) {
            producto.setDescripcion(producto.getDescripcion().replace("Consola", ""));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(productos);

    }
    // Has una clase llamada Información números que tenga 2 campos,
    // índice y primo,deberás de devolver una lista de esa clase en un
    // Endpoint donde dicha lista guarde los primero n números primos.

    //Por ejemplo si a tu Endpoint le llega un 3, entonces deberá ser una lista de la clase que represente eso.

    @GetMapping(value = "/obtener-primos{numerosPrimos}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<informacionNumeros>> obtenerPrimos(@PathVariable("numerosPrimos") Integer numerosPrimos ){
        List<informacionNumeros> listaPrimos = new ArrayList<>();
        int contador = 1;
            for (int i = 2; i <= numerosPrimos ; i++) {
                boolean esPrimo = true;
                for (int j = 2; j <=(i-1) ; j++) {
                    if(i % j == 0){
                        esPrimo = false;
                        break;
                    }

                }
                if (esPrimo){
                    listaPrimos.add(new informacionNumeros(contador,i));
                    contador++;
                }

        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(listaPrimos);

    }
}