package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class EliminarDelCarrito{
    public static Performable producto(String nombreProducto){
        return Task.where("{0} removes product '" + nombreProducto + "' from cart",
                Click.on(Target.the("Remove " + nombreProducto).locatedBy(CarritoPage.removeButton(nombreProducto)))
        );
    }
}
