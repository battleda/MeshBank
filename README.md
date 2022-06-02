# MeshBank

Необходимо создать приложение реализующие REST API

База данных Postgres

Java 11 версии

Собранный jar должен прилагаться к проекту

Использовать maven

База данных (по согласованию можно добавить поля и таблицы)

USERS:

    ID: bigint
    
    NAME: varchar
    
    AGE: ?
    
    EMAIL: varchar
    
PROFILES:
    
    ID: bigint
    
    CASH: ? рубли + копейки
    
    USER_ID: связь с таблицей users по ID

PHONES:
    
    ID: bigint
    
    VALUE: varchar

    USER_ID: связь с таблицей users по ID

Требование к API и функционалу

1. Реализовать CRUD для пользователя (обязательно сделать сервис слой)

    а. email уникальны
    
    б. добавить возможность фильтрации данных по разным полям: age(год или возраст), phone, name(like), email 

    в. добавить пагинацию к списку пользователей

2. Связь с таблицей USERS для PHONES и PROFILE  происходит через по ID

3. У пользователя может быть более одного телефона (не более одного профиля)
    
    а. телефоны уникальны
    
    б. пользователь может сменить email если он не занят другим пользователям (пользователь может сменить только свои данные)

4. Добавить swagger

5. Добавить JWT token, механизм получения токена на ваше усмотрение (закрыть необходимый функционал авторизацией)

6. Кеширование 2-го уровня

7. Реализовать проверку входных данных

8. Начальный счет указывается при создании пользователя
    
    а. раз в 20 секунд счета клиентов увеличиваются на 10% но не более 107% от начального депозита

9. Добавить логирование

10. Простые тесты

11. Результат тестового задания необходимо предоставить в виде публичного репозитория на Гитхабе 