package Dao;

import Model.City;

import java.util.List;

public interface CityDAO {

    // 1.Создание(добавление) сущности Employee в таблицу
    void createCity (City city);
    // 2.Получение конкретного объекта Employee по id
    City city(int id);

    City getByIdCity(int id);

    // 3.Получение списка всех объектов Employee из базы
    List<City> getAllCity ();
    // 4.Изменение конкретного объекта Employee в базе по id
    void updateCity (City city);
    // 5.Удаление конкретного объекта Employee из базы по id
    void deleteCity (City city);
}