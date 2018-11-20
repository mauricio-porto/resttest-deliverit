## Testar

```
./buildw clean

./buildw build

java -jar build/libs/deliverit.resttest-0.1.0.jar

curl  http://localhost:8080/conta/

curl -i -X POST -H "Content-Type:application/json" -d '{"nome":"Condominio","valorOriginal":534.88,"dataVencimento":"2018-11-11","dataPagamento":""}' \
   http://localhost:8080/conta

curl  http://localhost:8080/conta/search/findByNome?nome=Condominio
```
