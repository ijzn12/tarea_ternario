package tarea_ternario;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto_Programacion1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        double opcion = 0, efectivo_caja, ganancia_dia = 0, avena_stock = 0, azucar_stock = 0, trigo_stock = 0, maiz_stock = 0, azucar = 0, avena = 0, trigo = 0, maiz = 0;
        double efectivo_total = 0, cantidad_compra = 0, cantidad_venta = 0, precio = 0, total_venta = 0, total_compra = 0, count = 0, ganancia = 0, volumen_venta = 0, volumen_compra = 0;
        double cont_venta = 0, cont_compra = 0, cont_total = 0, descuento = 0, subtotal = 0, impuesto = 0, mayorVenta = 0;
        double totalAzucarVendido = 0, totalAvenaVendido = 0, totalTrigoVendido = 0, totalMaizVendido = 0, maxVenta = totalAzucarVendido;
        double totalAzucarVendidoR = 0, totalAvenaVendidoR = 0, totalTrigoVendidoR = 0, totalMaizVendidoR = 0;
        int dia = 1, codigo_producto = 0, cantVentas = 0, cantCompras = 0;
        String cliente, usuario, nombre = " ", respuesta_venta = "", respuesta_compra = "", productoMayorVenta = "", productoEstrella = "Azucar";
        boolean cajaAbierta = false, stock = false, primeraApertura = true;

        do {
            System.out.println("");
            System.out.println("1 Abrir Caja ");
            System.out.println("2 Ventas ");
            System.out.println("3 Compras ");
            System.out.println("4 Reportes ");
            System.out.println("5 Cierre de caja");
            System.out.println("6 Salir Del Sistema ");

            try {
                opcion = sc.nextDouble();
                if (opcion < 1 || opcion > 6) {
                    System.out.println("Opcion no valida, seleccione una correcta.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Por favor, ingrese un numero.");
                sc.next(); 
                continue;
            }

            System.out.println("");

            if (opcion == 1) {
                System.out.println("");

                if (primeraApertura) {
                    System.out.println("Caja abierta por primera vez");
                    System.out.println("Ingresar la cantidad de efectivo: ");
                    try {
                        efectivo_caja = sc.nextDouble();
                        efectivo_total += efectivo_caja;
                        System.out.println("Cantidad de efectivo en caja: " + efectivo_total);
                        primeraApertura = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                        sc.next(); 
                    }
                } else {
                    System.out.println("Caja abierta nuevamente");
                    System.out.println("Cantidad de efectivo en caja: " + efectivo_total);
                }

                cajaAbierta = true;
                System.out.println("");

            }

            if (opcion == 2) {

                if (cajaAbierta) {
                    if (azucar_stock > 0 || avena_stock > 0 || trigo_stock > 0 || maiz_stock > 0) {
                        do {

                            System.out.println("Ingresar tipo de cliente A/B/C");
                            cliente = sc.next();
                            while (!cliente.equalsIgnoreCase("a") && !cliente.equalsIgnoreCase("b") && !cliente.equalsIgnoreCase("c")) {
                                System.out.println("La opcion ingresada no es valida, por favor ingrese uno de los tres tipos A/B/C");
                                cliente = sc.next();
                            }

                            if (cliente.equalsIgnoreCase("A")) {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("|codigo |  producto |  precio venta | productos en almacen |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  1    |   Azucar  |   lps.30      |   " + azucar_stock + " kg |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  2    |   Avena   |   lps.25      |   " + avena_stock + " kg |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  3    |   Trigo   |   lps.32      |   " + trigo_stock + " kg |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  4    |   Maiz    |   lps.20      |   " + maiz_stock + " kg |");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Ingresar el codigo de producto");
                                try {
                                    codigo_producto = sc.nextInt();
                                    while (codigo_producto != 1 && codigo_producto != 2 && codigo_producto != 3 && codigo_producto != 4) {
                                        System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                        codigo_producto = sc.nextInt();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida. Debe ingresar un numero.");
                                    sc.next(); 
                                    continue;
                                }
                                if (codigo_producto > 0 && codigo_producto <= 4) {
                                    System.out.println("Ingresar la cantidad que desea vender en kilogramos");
                                    try {
                                        cantidad_venta = sc.nextDouble();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                                        sc.next(); 
                                        continue;
                                    }
                                    System.out.println("");

                                    if (codigo_producto == 1) {
                                        nombre = "Azucar";
                                        precio = 30;
                                        if (azucar_stock >= cantidad_venta) {
                                            azucar += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                    if (codigo_producto == 2) {
                                        nombre = "Avena";
                                        precio = 25;
                                        if (avena_stock >= cantidad_venta) {
                                            avena += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                    if (codigo_producto == 3) {
                                        nombre = "Trigo";
                                        precio = 32;
                                        if (trigo_stock >= cantidad_venta) {
                                            trigo += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                    if (codigo_producto == 4) {
                                        nombre = "Maiz";
                                        precio = 20;
                                        if (maiz_stock >= cantidad_venta) {
                                            maiz += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                }
                            }
                            if (cliente.equalsIgnoreCase("B")) {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("|codigo |  producto |  precio venta | productos en almacen |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  1    |   Azucar  |   lps.30      |   " + azucar_stock + " kg|");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  2    |   Avena   |   lps.25      |   " + avena_stock + " kg |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  3    |   Trigo   |   lps.32      |   " + trigo_stock + " kg |");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Ingresar el codigo de producto");
                                try {
                                    codigo_producto = sc.nextInt();
                                    while (codigo_producto != 1 && codigo_producto != 2 && codigo_producto != 3) {
                                        System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                        codigo_producto = sc.nextInt();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida. Debe ingresar un numero.");
                                    sc.next(); 
                                    continue;
                                }
                                if (codigo_producto > 0 && codigo_producto <= 3) {
                                    System.out.println("Ingresar la cantidad que desea comprar en kilogramos");
                                    try {
                                        cantidad_venta = sc.nextDouble();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                                        sc.next(); 
                                        continue;
                                    }
                                    System.out.println("");
                                    if (codigo_producto == 1) {
                                        nombre = "Azucar";
                                        precio = 30;
                                        if (azucar_stock >= cantidad_venta) {
                                            azucar += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                    if (codigo_producto == 2) {
                                        nombre = "Avena";
                                        precio = 25;
                                        if (avena_stock >= cantidad_venta) {
                                            avena += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                    if (codigo_producto == 3) {
                                        nombre = "Trigo";
                                        precio = 32;
                                        if (trigo_stock >= cantidad_venta) {
                                            trigo += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                }
                            }
                            if (cliente.equalsIgnoreCase("C")) {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("|codigo |  producto |  precio venta | productos en almacen |");
                                System.out.println("|----------------------------------------------------------|");
                                System.out.println("|  4    |   Maiz    |   lps.20      |   " + maiz_stock + " kg  |");
                                System.out.println("------------------------------------------------------------");
                                System.out.println("Ingresar el codigo de producto");
                                try {
                                    codigo_producto = sc.nextInt();
                                    while (codigo_producto != 4) {
                                        System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                        codigo_producto = sc.nextInt();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada invalida. Debe ingresar un numero.");
                                    sc.next(); 
                                    continue;
                                }
                                if (codigo_producto > 3 && codigo_producto <= 4) {
                                    System.out.println("Ingresar la cantidad que desea comprar en kilogramos");
                                    try {
                                        cantidad_venta = sc.nextDouble();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                                        sc.next(); 
                                        continue;
                                    }
                                    System.out.println("");

                                    if (codigo_producto == 4) {
                                        nombre = "Maiz";
                                        precio = 20;
                                        if (maiz_stock >= cantidad_venta) {
                                            maiz += cantidad_venta;
                                            stock = true;
                                        }
                                    }
                                }
                            }
                            subtotal = precio * cantidad_venta;
                            if (subtotal > 1000) {
                                descuento = subtotal * 0.05;
                            }
                            if (subtotal > 5000) {
                                descuento = subtotal * 0.10;
                            }
                            impuesto = subtotal * 0.7;
                            total_venta = subtotal - descuento + impuesto;

                            if (efectivo_total >= total_venta) {
                                if (stock) {
                                    cont_venta += cantidad_venta;
                                    cantVentas++;
                                    System.out.println("");
                                    System.out.println("El producto seleccionado es " + nombre);
                                    System.out.println("El codigo seleccionado es " + codigo_producto);
                                    System.out.println("El precio individual es " + precio + " Lps");
                                    System.out.println("El descuento " + descuento + " Lps");
                                    System.out.println("El impuesto es " + impuesto);
                                    System.out.println("El subtotal es " + subtotal + " Lps");
                                    System.out.println("El precio total es " + total_venta + " Lps");
                                    System.out.println(" ");

                                    volumen_venta += total_venta;
                                    efectivo_total += total_venta;
                                    ganancia_dia += total_venta;
                                    ganancia += total_venta;
                                    azucar_stock -= azucar;
                                    avena_stock -= avena;
                                    trigo_stock -= trigo;
                                    maiz_stock -= maiz;

                                    System.out.println("Dinero en caja actualizado " + efectivo_total + " Lps");
                                    System.out.println("");
                                    if (total_venta > mayorVenta) {
                                        mayorVenta = total_venta;
                                        productoMayorVenta = nombre;
                                    }
                                    if (nombre.equals("Azucar")) {
                                        totalAzucarVendido += cantidad_venta;
                                        totalAzucarVendidoR += cantidad_venta;
                                    } else if (nombre.equals("Avena")) {
                                        totalAvenaVendido += cantidad_venta;
                                        totalAvenaVendidoR += cantidad_venta;
                                    } else if (nombre.equals("Trigo")) {
                                        totalTrigoVendido += cantidad_venta;
                                        totalTrigoVendidoR += cantidad_venta;
                                    } else if (nombre.equals("Maiz")) {
                                        totalMaizVendido += cantidad_venta;
                                        totalMaizVendidoR += cantidad_venta;
                                    }
                                } else {
                                    System.out.println("La cantidad que esta comprando no es valida, verifique si hay en almacen.");
                                }
                            } else {
                                System.out.println("");
                                System.out.println("Su dinero en caja es insuficiente para efectuar la compra");
                                System.out.println("Dinero actual " + efectivo_total + " Lps");
                                System.out.println("");
                            }

                            stock = false;
                            azucar = 0;
                            avena = 0;
                            trigo = 0;
                            maiz = 0;
                            System.out.println("Desea comprar otro producto? Si/No");
                            respuesta_venta = sc.next();
                        } while (!respuesta_venta.equalsIgnoreCase("no"));
                        if (totalAvenaVendido > maxVenta) {
                            maxVenta = totalAvenaVendido;
                            productoEstrella = "Avena";
                        }
                        if (totalTrigoVendido > maxVenta) {
                            maxVenta = totalTrigoVendido;
                            productoEstrella = "Trigo";
                        }
                        if (totalMaizVendido > maxVenta) {
                            maxVenta = totalMaizVendido;
                            productoEstrella = "Maiz";
                        }
                    } else {
                        System.out.println("No hay productos en inventario, por favor llenar inventario para poder vender.");
                    }
                } else {
                    System.out.println("");
                    System.out.println("La caja esta cerrada, necesita abrir la caja para ingresar a ventas.");
                    System.out.println("");
                }

            }
            if (opcion == 3) {
                if (cajaAbierta) {
                    do {

                        System.out.println("Ingresar proveedor A/B/C");
                        usuario = sc.next();
                        while (!usuario.equalsIgnoreCase("a") && !usuario.equalsIgnoreCase("b") && !usuario.equalsIgnoreCase("c")) {
                            System.out.println("La opcion ingresada no es valida, por favor ingrese uno de los tres tipos A/B/C");
                            usuario = sc.next();
                        }
                        if (usuario.equalsIgnoreCase("A")) {
                            System.out.println("-------------------------------------");
                            System.out.println("|codigo |  producto |  precio compra|");
                            System.out.println("|-----------------------------------|");
                            System.out.println("|  1    |   Azucar  |   lps.25      |");
                            System.out.println("|-----------------------------------|");
                            System.out.println("|  4    |   Maiz    |   lps.18      |");
                            System.out.println("-------------------------------------");
                            System.out.println("Ingresar el codigo del producto a comprar ");
                            try {
                                codigo_producto = sc.nextInt();
                                while (codigo_producto != 1 && codigo_producto != 4) {
                                    System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                    codigo_producto = sc.nextInt();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next();
                                continue;
                            }
                            System.out.println("Ingresar la cantidad que desea comprar por kilogramos");
                            try {
                                cantidad_compra = sc.nextDouble();
                                while (cantidad_compra < 0) {
                                    System.out.println("Ingresar un numero valido");
                                    cantidad_compra = sc.nextDouble();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next(); 
                                continue;
                            }
                            System.out.println("");
                            if (codigo_producto == 1) {
                                nombre = "Azucar";
                                precio = 25;
                                azucar += cantidad_compra;
                            }
                            if (codigo_producto == 4) {
                                nombre = "Maiz";
                                precio = 18;
                                maiz += cantidad_compra;
                            }
                        }
                        if (usuario.equalsIgnoreCase("B")) {
                            System.out.println("-------------------------------------");
                            System.out.println("|codigo |  producto |  precio venta |");
                            System.out.println("|-----------------------------------|");
                            System.out.println("|  2    |   Avena   |   lps.20      |");
                            System.out.println("|-----------------------------------|");
                            System.out.println("|  3    |   Trigo   |   lps.30      |");
                            System.out.println("-------------------------------------");
                            System.out.println("Ingresar el codigo del producto a comprar ");
                            try {
                                codigo_producto = sc.nextInt();
                                while (codigo_producto != 2 && codigo_producto != 3) {
                                    System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                    codigo_producto = sc.nextInt();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next(); 
                                continue;
                            }
                            System.out.println("Ingresar la cantidad que desea comprar por kilogramos");
                            try {
                                cantidad_compra = sc.nextDouble();
                                while (cantidad_compra < 0) {
                                    System.out.println("Ingresar un numero valido");
                                    cantidad_compra = sc.nextDouble();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next(); 
                                continue;
                            }
                            System.out.println("");
                            if (codigo_producto == 2) {
                                nombre = "Avena";
                                precio = 20;
                                avena += cantidad_compra;
                            }
                            if (codigo_producto == 3) {
                                nombre = "Trigo";
                                precio = 30;
                                trigo += cantidad_compra;
                            }
                        }
                        if (usuario.equalsIgnoreCase("C")) {
                            System.out.println("-------------------------------------");
                            System.out.println("|codigo |  producto |  precio venta |");
                            System.out.println("|-----------------------------------|");
                            System.out.println("|  2    |   Avena   |   lps.22      |");
                            System.out.println("-------------------------------------");
                            System.out.println("Ingresar el codigo del producto a comprar ");
                            try {
                                codigo_producto = sc.nextInt();
                                while (codigo_producto != 4) {
                                    System.out.println("Numero ingresado no valido, intente de nuevo con uno valido");
                                    codigo_producto = sc.nextInt();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next();
                                continue;
                            }
                            System.out.println("Ingresar la cantidad que desea comprar por kilogramos");
                            try {
                                cantidad_compra = sc.nextDouble();
                                while (cantidad_compra < 0) {
                                    System.out.println("Ingresar un numero valido");
                                    cantidad_compra = sc.nextDouble();
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada invalida. Debe ingresar un numero.");
                                sc.next();
                                continue;
                            }
                            System.out.println("");
                            if (codigo_producto == 2) {
                                nombre = "Avena";
                                precio = 22;
                                avena += cantidad_compra;
                            }
                        }
                        total_compra = precio * cantidad_compra;
                        if (efectivo_total >= total_compra) {
                            cantCompras++;
                            efectivo_total -= total_compra;
                            cont_compra += count;
                            count = azucar + trigo + maiz + avena;
                            System.out.println("");
                            System.out.println("El producto seleccionado es " + nombre);
                            System.out.println("El codigo seleccionado es " + codigo_producto);
                            System.out.println("El precio individual es " + precio + " Lps");
                            System.out.println("Cantidad comprada " + count);
                            System.out.println("El precio total es " + total_compra + " Lps");
                            System.out.println(" ");
                            System.out.println("Dinero en caja actualizado " + efectivo_total + " Lps");
                            System.out.println("");
                            volumen_compra += total_compra;
                            ganancia_dia -= total_compra;
                            ganancia -= total_compra;
                            azucar_stock += azucar;
                            avena_stock += avena;
                            trigo_stock += trigo;
                            maiz_stock += maiz;

                        } else {
                            System.out.println("");
                            System.out.println("Su dinero en caja es insuficiente para efectuar la compra");
                            System.out.println("Dinero actual " + efectivo_total + " Lps");
                            System.out.println("");
                        }
                        count = 0;
                        azucar = 0;
                        avena = 0;
                        trigo = 0;
                        maiz = 0;
                        System.out.println("Desea realizar otra compra? Si/No");
                        respuesta_compra = sc.next();
                    } while (!respuesta_compra.equalsIgnoreCase("no"));
                } else {
                    System.out.println("La caja actualmente se encuentra cerrada.");
                }

            }
            if (opcion == 4) {
                cont_total = cont_venta + cont_compra;
                System.out.println("Cantidad de dinero en caja: " + efectivo_total);
                System.out.println("Cantidad de ventas: " + cantVentas);
                System.out.println("Cantidad de compras: " + cantCompras);
                System.out.println("Ganancias total: " + ganancia);
                System.out.println("Volumen total ventas: " + volumen_venta);
                System.out.println("Volumen total compras: " + volumen_compra);
                System.out.println("Valor medio de ventas: " + volumen_venta / cont_venta);
                System.out.println("Valor medio de compras: " + volumen_compra / cont_compra);
                System.out.println("La venta mas grande fue de " + mayorVenta + " Lps con el producto " + productoMayorVenta);
                System.out.println("El Producto Estrella del dia es " + productoEstrella + " con una venta de " + maxVenta + " kilogramos");
                double azucarrank = totalAzucarVendidoR, avenarank = totalAvenaVendidoR, trigorank = totalTrigoVendidoR, maizrank = totalMaizVendidoR;
                int rank = 1;
                while (rank <= 4) {
                    if (azucarrank >= avenarank && azucarrank >= trigorank && azucarrank >= maizrank) {
                        System.out.println(rank + ". Azucar: " + azucarrank + " kg");
                        azucarrank = -1;
                    } else if (avenarank >= azucarrank && avenarank >= trigorank && avenarank >= maizrank) {
                        System.out.println(rank + ". Avena: " + avenarank + " kg");
                        avenarank = -1;
                    } else if (trigorank >= azucarrank && trigorank >= avenarank && trigorank >= maizrank) {
                        System.out.println(rank + ". Trigo: " + trigorank + " kg");
                        trigorank = -1;
                    } else if (maizrank >= azucarrank && maizrank >= avenarank && maizrank >= trigorank) {
                        System.out.println(rank + ". Maiz: " + maizrank + " kg");
                        maizrank = -1;
                    }
                    rank++;
                }

            }
            if (opcion == 5) {
                if (cajaAbierta) {
                    System.out.println("");
                    System.out.println("Cierre de caja completo del dia = " + dia);
                    System.out.println("Las ganancias totales son " + ganancia_dia + " Lps");
                    System.out.println("");
                    dia++;
                    cajaAbierta = false;
                    ganancia_dia = 0;
                    cantVentas=0;
                    cantCompras=0;
                    ganancia=0;
                    volumen_venta=0;
                    volumen_compra=0;
                    cont_venta=0;
                    cont_compra=0;
                } else {
                    System.out.println("La caja se encuentra cerrada actualmente");
                }
            }

            if (opcion == 6) {
                System.out.println("Salio del sistema correctamente");

            }

        } while (opcion != 6);

    }

}
