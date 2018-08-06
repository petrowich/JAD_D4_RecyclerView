package su.petrowich.jad_d4_recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        //val items = listOf<String>("Первый элемент","Второй элемент","Третий Элемент")

        val adapter = RecyclerAdapter()
        adapter.setOnRecyclerClicked(object : RecyclerAdapter.OnRecyclerClicked{
            override fun onClick(weatherItem: WeatherItem) {
                Toast.makeText(this@MainActivity, weatherItem.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.adapter = adapter

        //val items = (1..20).map { i -> "Элемент #$i" }
        val items = getWeather() //это функция возвращает коллекцию данных по городам, внутри функции начинается порнография
        adapter.setItems(items)
    }

    private fun getWeather(): List<WeatherItem> {
        //более красивго способа вернуть неизменяемый массив я не нашёл, этот хотя бы работает
        var items = mutableSetOf<WeatherItem>()

        //массив с данными решил сохранить в ресурсах
        //можно ли деражать сразу несколько значений внутри айтема проверять времени не было, хотя было бы полезно
        val cityArray = resources.getStringArray(R.array.cities)
        val forecastsArray = resources.getStringArray(R.array.forecasts)
        val temperaturesArray = resources.getStringArray(R.array.temperatures)

        for((i, city) in cityArray.withIndex()){
            items.add(WeatherItem(city.toString(),forecastsArray[i].toString(),temperaturesArray[i].toString()))
        } //что будет, если кол-во айтемов в массивах будет меньше, чем в cityArray, подумать страшно


        return items.toList()
        //мне нужно рассказать основыне приёмы работы с коллекциями
    }
}
