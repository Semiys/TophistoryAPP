# История в улицах Ульяновска

Мобильное приложение, разработанное в рамках **Научно-исследовательской работы студентов (НИРС)**. Приложение знакомит пользователя с историческими фактами, привязанными к геолокациям, и служит мобильным гидом по историческим местам Ульяновска.

## 🏆 Достижения

**Проект занял 1-е место в конкурсе НИРС.**
**Приложение опубликовано в официальном магазине приложений RuStore.**

[![Доступно в RuStore](https://cdn-www.rustore.ru/b2c-static-images/logo/RuStore_Badge_Monochrome_RUS.svg)](https://www.rustore.ru/catalog/app/com.example.tophistoryapp)


## 📱 Скриншоты

| Главный экран с картой | Экран с историей |
| :---: | :---: |
| ![Главный экран](https://github.com/user-attachments/assets/09b2256f-a76c-47f3-b1cd-24233da939bd) | ![Экран истории](https://github.com/user-attachments/assets/cb0f5a5d-5943-4c2d-a0a7-41c9f7c1a0b6) |


## ⚙️ Стек технологий

- **Язык:** Kotlin
- **Архитектура:** MVVM (ViewModel + LiveData)
- **Пользовательский интерфейс (UI):**
  - XML
  - ViewBinding
  - Material Design
  - ConstraintLayout
  - CardView
- **Навигация:** Jetpack Navigation Component
- **Карты:** Yandex Maps SDK
- **Другое:** AndroidX, Fragments, SplashScreen API

## 🏛️ Архитектура

Приложение построено с использованием паттерна Model-View-ViewModel, где:
- **View** (Fragment'ы) отвечает за отображение данных и передачу действий пользователя.
- **ViewModel** обрабатывает логику и предоставляет данные для View через LiveData.
- **Model** (в данном случае, локальные данные) представляет собой источник информации.
