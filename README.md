# История в улицах Ульяновска

Простое Android-приложение, которое знакомит пользователя с историческими фактами, привязанными к геолокациям. Проект создан для демонстрации навыков работы с картами и основными компонентами Android.

## 📱 Скриншоты


| Главный экран с картой |
| :---: | :---: |
| ![image](https://github.com/user-attachments/assets/dc9e78b9-2ecc-426b-8f05-fc36ddc49cdf)|
| Экран с историей |
| ![image](https://github.com/user-attachments/assets/fed7b075-d1d4-4017-aad8-ccd3555d6e89)|

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
