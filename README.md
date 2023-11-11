# Adam Podlaski

# AbsenceManagementSystem
Program ułatwiający zarządzanie nieobecnościami pracowników.

## Założenia:
### Pracownik:
- Uzyskuje login i hasło do aplikacji od administratora (ADMIN).
- Po zalogowaniu się ma dostęp do własnych wniosków urlopowych (REQUEST) oram mozliwość tworzenia nowego wniosku (REQUEST).

- Akcje pracownika:
  - Utworzenie wniosku urlopowego (REQUEST).
  - Podgląd pod własne wnioski urlopowe (REQUEST).
  - Możliwość usunięcia wniosku urlopowego ze statusem "PENDING".

### Manager:
- Uzyskuje login i hasło do aplikacji od administratora (ADMIN).
- Ma dostęp do listy wszystkich pracowników zawierającej najważniejsze informacje.
- Ma możliwość edycji wybranych pól pracownika.
  
- Akcje Managera:
  - Akceptacja wniosku urlopowego (REQUEST).
  - Odrzucenie wniosku urlopowego (Request).
  - Edycja wybranych pól wniosku urlopowego (REQUEST).
 
### Admin:
- Uzyskuje domyślny login: admin@admin.com oraz hasło: admin.
- Po zalogowaniu się ma dostęp do wszystkich funkcji aplikacji.

- Akcje Administratora:
  - Tworzenie nowych pracowników z podziałem na role.
  - Edycja utworzonych pracowników.
  - Usunięcie pracowników.
  - Podgląd pod wszystkie wnioski urlopowe (REQUEST).
  - Możliwość edycji/usunięcia wniosków urlopowych (REQUEST).


### Uwagi:
- Przed pierwszym uruchomieniem programu należy skonfigurować bazę danych w application.properties.
- Po konfiguracji w bazie danych należy utworzyć nową bazę danych korzystając z polecenia:
  - CREATE DATABASE amsystemdb;
  - USE amsystemdb;
- Domyślnie ustawiono: server.port = 8081
