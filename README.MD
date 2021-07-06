<h1>Testowe API</h1>
<h3>Wykorzystane technologie</h3>
<ul>
<li>Spring Boot</li>
<li>Hibernate</li>
<li>Mongo</li>
<li>Spock</li>
<li>Junit</li>
<li>Swagger</li>
</ul>
<h3>Opis aplikacji</h3>
<p>Aplikacja realizuje dwa zadania, pierwszym jest pobranie danych
o użytkowniku z githuba. Drugie z realizowanych zadań polega na zliczaniu 
zapytań per login. Każde żądanie o dane użytkownika jest zapisywane 
do bazy mongo, na podstawie zapisanych dokumentów tworzona jest statystyka odwiedzin
która zapisywana jest do bazy relacyjnej. Dzięki takiemu podejściu nie mamy tu do czynienia z sytuacją brudnego odczytu. 
Oczywiście nie jest to jedyne z możliwych rozwiązań, możemy stosować 
poziomy izolacji na procesie inkrementacji liczby zapytań. Moje podejście charakteryzuje się jednak 
wysoką wydajnością, jest to przydatne zwłaszcza dla endpointu, który może być często wykorzystywany a takim wydaje mi się endpoint 
zwracający dane o użytkownikach</p>
<h3>Przygotowanie statystyki odbywa się przez wysłanie żądania PUT na adres /statistics</h3>