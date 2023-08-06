package Grados;

public class Logica {
    
    private Double celcius;
    private Double fareheint;
    private Double kelvin;

    public Double getCelcius() {
        return celcius;
    }

    public void setCelcius(Double celcius) {
        this.celcius = celcius;
    }

    public Double getFareheint() {
        return fareheint;
    }

    public void setFareheint(Double fareheint) {
        this.fareheint = fareheint;
    }

    public Double getKelvin() {
        return kelvin;
    }

    public void setKelvin(Double kelvin) {
        this.kelvin = kelvin;
    }

    public Double CelciusFareheint() {
        this.setFareheint(((9 * this.getCelcius()) / 5) + 32);
        return this.getFareheint();
    }

    public Double CelciusKelvin() {
        this.setKelvin(this.getCelcius() + 273.15);
        return this.getKelvin();
    }

    public Double FareheintCelcius() {
        this.setCelcius((5 * (this.getFareheint() - 32)) / 9);
        return this.getCelcius();
    }

    public Double FareheintKelvin() {
        this.setKelvin(FareheintCelcius() + 273.15);
        return this.getKelvin();
    }

    public Double KelvinFareheint() {
        this.setFareheint(((9 * KlevinCelcius()) / 5) + 32);
        return this.getFareheint();
    }

    public Double KlevinCelcius() {
        this.setCelcius(this.getKelvin() - 273.15);
        return this.getCelcius();
    }

}
