package mx.tec.utils;

public class CurrencyConverter {

    public CurrencyConverter() {}

    // - Equivalencias obetnidas de https://www.xe.com
    // - Fecha de obtencion 01/03/2021 19:28 GMT-07

    public double MXNtoUSD(double mxn) {
        return mxn * 0.0482425;
    }

    public double MXNtoBRL(double mxn) {
        return mxn * 0.272071; 
    }

    public double USDtoMXN(double usd) {
        return usd * 20.72865;
    }

    public double USDtoBRL(double usd) {
        return usd * 5.64209;
    }

    public double BRLtoMXN(double brl) {
        return brl * 3.67551;
    }

    public double BRLtoUSD(double brl) {
        return brl * 0.177239;
    }

}
