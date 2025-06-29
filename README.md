# История в улицах Ульяновска

Простое Android-приложение, которое знакомит пользователя с историческими фактами, привязанными к геолокациям. Проект создан для демонстрации навыков работы с картами и основными компонентами Android.

## 📱 Скриншоты


| Главный экран с картой | Экран с историей |
| :---: | :---: |
| ![Главный экран](![image](https://github.com/user-attachments/assets/d4dc17fb-77cf-4839-bbda-12e46519365b)
) | ![Экран истории](![image](https://github.com/user-attachments/assets/9e9e6991-fe57-4550-852e-771a06eb3d2b)
) |

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
