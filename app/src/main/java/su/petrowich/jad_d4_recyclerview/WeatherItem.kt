package su.petrowich.jad_d4_recyclerview

class WeatherItem(weatherCity: String, weatherForecast: String, weatherTemperature : String) {
    val weatherCity : String = weatherCity
    val weatherForecast : String = weatherForecast
    val weatherTemperature : String = weatherTemperature

    override fun toString(): String {
        return "$weatherCity $weatherForecast $weatherTemperature"
    }
}