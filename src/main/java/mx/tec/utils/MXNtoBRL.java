package mx.tec.utils;

public class MXNtoBRL implements CurrencyConverter {
    
    // - Equivalencias obetnidas de https://www.xe.com
    // - Fecha de obtencion 01/03/2021 19:28 GMT-07

    public double convert(double price) {
        return price * 0.272071;
    }
}
