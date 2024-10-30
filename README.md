# CoinMarketTest

`CoinMarketTest` - это Java-программа, созданная для тестирования соединения с криптовалютным агрегатором цен CoinMarketCap. Основная цель программы - отладка соединения и получение актуальных данных по криптовалютам. Эта программа служит предварительным этапом для разработки полноценного приложения с графическим интерфейсом GUI - `CryptoPulse`, которое будет отображать аналитику криптовалют.

## Основные возможности

- Получение данных о топовых криптовалютах с использованием API CoinMarketCap.
- Отображение названия криптовалюты, символа, текущей цены в USD и рыночной капитализации.
- Удобный форматированный вывод информации для облегчения восприятия.

## Требования

- **Java**: JDK 8 или выше
- **Maven**: Для сборки и управления зависимостями
- **API-ключ CoinMarketCap**: Необходим для доступа к данным API. Получить его можно на [CoinMarketCap API](https://coinmarketcap.com/api/).

## Зависимости

- **Retrofit**: Для выполнения HTTP-запросов.
- **Gson**: Для обработки JSON-ответов.
- **SLF4J**: Для логирования.

## Установка

1. Клонируйте репозиторий:

   git clone https://github.com/your-username/CoinMarketTest.git
   cd CoinMarketTest

2. Добавьте ваш API-ключ в файл CoinMarketTest.java:
private static final String API_KEY = "your_api_key_here";

3. Соберите проект с помощью Maven:
mvn clean install

## Использование

1. Запустите приложение, используя следующую команду:

mvn exec:java -Dexec.mainClass="com.example.coinmarkettest.CoinMarketTest"

2. Программа выведет список криптовалют с информацией о названии, символе, цене в USD и рыночной капитализации.

Пример вывода:

=== Ответ от CoinMarketCap API ===
----------------------------------
Название: Bitcoin
Символ: BTC
Цена (USD): 72266,24
Рыночная капитализация: 1429085466714,98
----------------------------------

## Вклад в проект

Хотите внести вклад? Создайте форк репозитория, внесите изменения и отправьте Pull Request.

