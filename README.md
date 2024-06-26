# Adam Podlaski

# AbsenceManagementSystem
Program ułatwiający zarządzanie nieobecnościami pracowników.

## Założenia:

### Utworzenie bazowej wersji aplikacji przygotowanej pod dalszą rozbudowę.

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
  - spring.datasource.url=jdbc:mysql://localhost:3306/${db.name}
  - #spring.datasource.url=jdbc:mysql://${db.host}:${db.port}/${db.name} (zakomentuj tą linię)
  - spring.datasource.username=${db.username}
  - spring.datasource.password=${db.pass}
- Po konfiguracji w bazie danych należy utworzyć nową bazę danych korzystając z polecenia:
  - CREATE DATABASE amsystemdb;
  - USE amsystemdb;
  - Uruchom aplikację AbsenceManagementSystem w IDE;
  - W bazie danych wprowadź nowy rekord korzystając z polecenia:
    - INSERT INTO amsystemdb.employees
    - (id, last_name, first_name, email, password, phone_number, employee_role, remaining_days)
    - VALUES
    - (null, 'admin', 'admin', 'admin@admin.com', '$2y$11$mpya140ccuKgw/8MGifSHuzkUxDlBFUWNdjJ/AFT7Z3XsQwCm7bDC',
        000000000, 'ADMIN', 0);
  - Po ponownym uruchomeiniu aplikacji możesz zalogować się za pomoca danych: login: admin@admin.com, password: admin
  - Domyślnie ustawiono: server.port = 8081

