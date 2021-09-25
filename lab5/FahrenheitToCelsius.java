public class FahrenheitToCelsius extends Converter {
    @Override
    public void convert() {
        to = (from - 32) * 5d/9d;
    }
}
