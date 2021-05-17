# Camunda SQL Connector

SQL-connector to connect directly to MS SQL database.

MSSQL driver for jdbc https://download.microsoft.com/download/4/c/3/4c31fbc1-62cc-4a0b-932a-b38ca31cd410/sqljdbc_9.2.1.0_enu.zip

## Parameters

uri: 
```
jdbc:sqlserver://yourserver.database.windows.net:1433;database=AdventureWorks;user=yourusername@yourserver;password=yourpassword;encrypt=true;trustServerCertificate=false;loginTimeout=30;
```

query:
```
Select top 1000 * from DimPartners
```


## Result

rows:
```
[
	[ id:1, Name:"Partner1" ],
	[ id:2, Name:"Partner2" ],
	...
]
```
