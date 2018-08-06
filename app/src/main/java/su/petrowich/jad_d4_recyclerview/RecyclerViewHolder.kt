package su.petrowich.jad_d4_recyclerview

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import java.lang.Integer.parseInt


class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewWeatherCityName: TextView = itemView.findViewById(R.id.textView_WeatherCityName)
    private val textViewWeatherForecast: TextView = itemView.findViewById(R.id.textView_WeatherForecast)
    private val textViewWeatherTemperature: TextView = itemView.findViewById(R.id.textView_WeatherTemperature)

    fun bind(textToShow: WeatherItem) {
        if (textToShow.weatherCity.isEmpty()){
            textViewWeatherCityName.visibility = View.GONE
        } else {
            textViewWeatherCityName.visibility = View.VISIBLE
        }

        if (textToShow.weatherForecast.isEmpty()){
            textViewWeatherForecast.visibility = View.GONE
        } else {
            textViewWeatherForecast.visibility = View.VISIBLE
        }

        if (textToShow.weatherTemperature.isEmpty()){
            textViewWeatherTemperature.visibility = View.GONE
        } else {
            textViewWeatherTemperature.visibility = View.VISIBLE

        }

        textViewWeatherCityName.text = textToShow.weatherCity
        textViewWeatherForecast.text = textToShow.weatherForecast
        textViewWeatherTemperature.text = textToShow.weatherTemperature

        val temperature : Int = parseInt(textToShow.weatherTemperature)

        //конструкция  textViewWeatherTemperature.setTextColor(getResources().getColor(R.color.colorHeat))
        //не заработала, не понимаю почему
        //вернее, понимаю, не понимаю, как получить контекст приложения, или как ещё

        if (temperature>=30)
            textViewWeatherTemperature.setTextColor(Color.RED)

        if (temperature<0)
            textViewWeatherTemperature.setTextColor(Color.BLUE)



    }
}