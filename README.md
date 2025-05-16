# Валидатор данных

[![Actions Status](https://github.com/liadiann/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/liadiann/java-project-78/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=liadiann_java-project-78&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=liadiann_java-project-78)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=liadiann_java-project-78&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=liadiann_java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=liadiann_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=liadiann_java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=liadiann_java-project-78&metric=bugs)](https://sonarcloud.io/summary/new_code?id=liadiann_java-project-78)
[![my-workflow](https://github.com/liadiann/java-project-78/actions/workflows/my-workflow.yml/badge.svg)](https://github.com/liadiann/java-project-78/actions/workflows/my-workflow.yml)

Библиотека, с помощью которой можно проверять корректность данных.

Сейчас может работать с данными трех типов:
1. String,
2. Integer,
3. Map

## Использование
1. Создание валидатора
```bash
var v = new Validator();
```
2. Создание схемы валидации
```bash
var schema = v.string(); // для строк
```
или
```bash
var schema = v.number(); // для чисел
```
или
```bash
var schema = v.<K, V>map(); // для map
```
3. Настройка схемы

Схема StringSchema содержит следующий набор методов:
1. required() - строка не может быть пустой и null;
2. minLength(3) - длина строки должна быть больше либо равна указанному числу;
3. contains("substr") - строка должна содержать указанную подстроку.

Схема NumberSchema содержит следующий набор методов:
1. required() - число не может быть null;
2. positive() - число должно быть положительное;
3. range(3, 10) - число должно быть в указанном диапазоне, включая границы.

Схема MapSchema содержит следующий набор методов:
1. required() - map не может быть null;
2. sizeof(3) - количество пар ключ-значение в map должно быть равно указанному числу.

Также можно проверять значения map на корректность. Для этого создаем набор схем для проверки каждого ключа map.
Передаем созданный набор схем в метод shape().
```bash
schema.shape(schemas);
```
