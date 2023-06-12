# AbsenceManagementSystem
Program ułatwiający zarządzanie nieobecnościami pracowników.

## Założenia:
### Pracownik:
- Uzyskuje login i hasło do aplikacji

- Po zalogowaniu się ma dostęp do interfejsu graficznego przedstawiającego cały rok z zaznaczonymi dostępnymi do rezerwacji datami łącznie z podanym aktualnym stanem dni wolnych do wykorzystania.

- Akcje pracownika:

  - Rezerwacja terminu.

  - Podgląd pod własne rezerwacje

  - Możliwość edycji rezerwacji

  - Możliwość usunięcia rezerwacji

  - Możliwość wysłania/odbierania wiadomości

### Manager:
- Uzyskuje login i hasło do aplikacji.
- Po zalogowaniu się ma dostęp do interfejsu graficznego przedstawiającego cały rok z zaznaczonymi rezerwacjami.
- Ma dostęp do listy wszystkich pracowników zawierającej najważniejsze informacje.
- Ma możliwość wprowadzenia dodatkowych walidacji w logice działania programu.
- Akcje Managera:
  - Akceptacja otrzymanej prośby o rezerwację.
  - Brak akceptacji otrzymanej prośby o rezerwację z możliwością wysłania wiadomości zwrotnej.
  - Możliwość wysłania prośby o zmianę terminu z podaniem dodatkowych informacji.
  - Możliwość wysłania/odbierania wiadomości.

### Interfejs graficzny:
- Przedstawia cały rok kalendarzowy.
- W sposób graficzny przedstawia:
  - Wszystkie zatwierdzone rezerwacje z uwzględnieniem rodzaju.
  - Wszystkie do-zatwierdzenia rezerwacje.
  - Dni ustawowo wolne od pracy.
  - Dodatkowe informacje.

