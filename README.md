# solva_services
В этом репозитории я создал 2 api которые работают друг с другом посредством openfeign 
ИНСТРУКЦИЯ по запуску. 
1. Освобождаем порты 8080 8081 1001 1000 они нам понадобятся для работы.
2. Запускаем 2 проекта, в обоих проектах есть папка docker-compose.(В solva-user помимо Dockerfile есть d-c.yaml)
3. В обоих проектах создаем джарник bootJar и копируем эти файлы в docker-compose меняя название на backend.jar
4. Затем в терминале пишем cd docker-compose и создаем 2 образа (iso)
5. В solva-bank в терминале пишем команду: docker build -t solva-bank-iso . (не забывайте про точку в конце)
6. В solva-user: docker build -t solva-bank-iso .
7. даллее в solva-user треминале пишем docker-compose up -d
8. Дальше в постман localhost:1001/user/set?category=SERVICES&transaction=400.00&limitUSD=300.00
9. Можете поменять категорию на FOODS, лимит устанавливается только 1 раз, если оставить пустым он будет 1000
10. Далее делаем тоже самое для solva-bank, то есть меняем лишь порт на 1000. Здесь вам нужно лишь создать айди
11. После всего выполненного Postgres хранит данные клиента и его айди в банк сервесе.
12. Вводим команду localhost:1000/1 что получить результат превышения лимита. (ВАЖНО, чтобы id совпадали)

Таким образом на вход принимаются данные от клиента и через банк обрабатывается запрос.

Стек:
PostgreSQL
Liquibase 
OpenFeign
Mockito 
JUtin
Lombok
Spring Web
Spring Data Jpa
MapStruct
    
