# To-Do List Application

**Java Swing To-Do List с сохранением задач в файл**

[![Java](https://img.shields.io/badge/Java-20.0.2-blue)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/Swing-GUI-orange)](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

---

## 📌 Описание проекта

**To-Do List** — это десктопное приложение для управления ежедневными задачами. Приложение позволяет:
- Добавлять, редактировать и удалять задачи.
- Сохранять задачи в файл (`hash_file.dat`) для последующей загрузки.
- Выбирать задачи по датам (месяц + день).
- Отмечать выполненные задачи (зачёркивание).

---

## 🛠 Технологии

- **Java 20.0.2**
- **Swing** — для графического интерфейса.
- **HashMap** — для хранения задач по датам.
- **Сериализация** — для сохранения/загрузки данных в файл.
- **JUnit 5** — для тестирования.

---

## 📦 Структура проекта

```
src/
├── main/
│   ├── java/
│   │   ├── Model.java          # Логика работы с данными
│   │   ├── View.java           # Графический интерфейс
│   │   ├── Controller.java     # Связь Model и View
│   │   ├── TaskComponent.java  # Компонент задачи
│   │   ├── Size.java           # Константы размеров GUI
│   │   └── Main.java           # Точка входа
│   └── resources/              # Ресурсы (иконки, gif)
└── test/                       # Тесты (JUnit 5)
```

---

## 🚀 Как запустить проект

### Требования
- Java 20.0.2 или выше.
- IntelliJ IDEA (рекомендуется).

### Шаги
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/tvoe-username/todo-list-java.git
   ```
2. Откройте проект в IntelliJ IDEA.
3. Запустите `Main.java`.

---

## 🎯 Особенности реализации

### 1. **Архитектура MVC**
- **Model**: Работа с данными (`HashMap<MonthDay, List<String>>`), сериализация.
- **View**: Графический интерфейс на Swing.
- **Controller**: Обработка событий (добавление, удаление, сохранение задач).

### 2. **Сохранение данных**
- Задачи сохраняются в файл `hash_file.dat` с помощью `ObjectOutputStream`.
- При запуске приложения данные автоматически загружаются из файла.

### 3. **Тестирование**
- **JUnit 5** для проверки ключевых методов:
  - `getValueFromCache` (Model)
  - `checkLastIndex` (TaskComponent)
  - `checkCreateDayBox` (Controller)

---

## 📸 Скриншот
---
<img width="1004" height="1016" alt="image" src="https://github.com/user-attachments/assets/800009aa-d738-4dfe-b679-d57d1651803d" />

## 🧪 Тесты

### 1. `getValueFromCache`
Проверяет корректность извлечения задач из `HashMap` по ключу (дата).

### 2. `checkLastIndex`
Проверяет, отмечена ли задача как выполненная (по символу `*`).

### 3. `checkCreateDayBox`
Проверяет наличие компонента выбора дня на форме.

---
