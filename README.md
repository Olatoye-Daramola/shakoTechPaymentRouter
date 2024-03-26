<h1>ShakoTech Payment Router Demo 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.o-blue.svg?cacheSeconds=2592000" />
</p>


> This project is a multi-tenant application, provided as a solution to the task below:
> 
> There is a payment aggregator, MgTech, that has financial operations in 7 Francophone West African countries.
> A Financial Technology service firm (ShakoTech) desires to integrate with MgTech to route transactions to any one of the 7 countries. The transactions are routed through MgTech, which proceeds with completing the transaction. ShakoTech desires to implement a schema-based multi-tenancy for the integration to MgTech.
> 1. Develop an application such that, for every transaction that ShakoTech sends to MgTech, the transaction is logged in the schema of the respective source country.
> 2. Explain Multi-tenancy.
> 3. Describe the forms of multi-tenancy.
> 4. Describe 5 API security best practices


### Running the application
1. clone the repository
2. run your application
```sh
gradlew bootRun
```
3. Note that you must have the Java JRE library on your machine.

### Create user
```sh
curl --location 'http://localhost:8082/api/v1/users/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "toye",
"password": "olatoye",
"email": "toye@gmail.en",
"firstName": "Olatoye",
"lastName": "Daramola",
"phoneNumber": "1234567890",
"isActive": true
}'
```
### Create country tenant
```sh
curl --location --request POST 'http://localhost:8082/api/v1/tenants/create/Burkina_Faso' \
--header 'Authorization: Basic dG95ZTpvbGF0b3ll'
```
### Create transaction
```sh
curl --location 'http://localhost:8082/api/v1/transactions/create' \
--header 'X-Country-Code: Burkina_Faso' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic dG95ZTpvbGF0b3ll' \
--data '{
  "sessionId": "SS-1235",
  "accountNumber": "0113801890",
  "transactionAmount": 10.0,
  "vatAmount": 0.0,
  "feeAmount": 0.0,
  "settledAmount": 10.0,
  "settlementId": "ST-12345",
  "transactionRemark": "String"
}'
```

-----------------------------------------------------------------------------
## MULTI-TENANCY
> Multi-tenancy is a design approach where individual groups of users, called tenants, can utilize a single software instance and its underlying infrastructure.
> Its aim is to allocate each tenant their own portion of the instance while safeguarding and segregating their respective information.<br><br>
> Every tenant gets a personalized share of the application instance including its data, configuration, user management, 
> tenant-specific functional and non-functional properties. Due to efficient resource sharing among tenants, multi-tenancy
> can reduce the overall cost of running a software/application due to the fact that there is no dedicated resource for each tenant.<br><br>
> It offers data privacy and infrastructure in such a way that a security breach in a database does not cascade to other 
> tenant's database due to the level of data separation.isolation. Also, it simplifies maintenance and upgrades as updates and maintenance can be applied to all tenants simultaneously, paving way for software
> version standardization.
> ### Forms
> There are several forms of multi-tenancy, and the 3 major forms are:
> 1. Separate Database, Separate Schema (Database-per-tenant) Multi-tenancy
> 2. Shared Database, Shared Schema Multi-tenancy
> 3. Shared Database, Separate Schema (Schema-per-tenant) Multi-tenancy.
><br><br>
>
> <b>Separate Database, Shared Schema Multi-tenancy</b><br>
> In this type of multi-tenancy, while each tenant have the same instance of the application, an individual database is 
> created and assigned to each tenant, hence, the databases are isolated from each tenant. Their data is physically separated.
> It affords the tenant the ability to customize their database to their use cases. It is usually not easy to set up as 
> there are complexities in setting up the separate database infrastructure.However, tenants get a higher level of data 
> isolation, improving the privacy and security of their data.
> <br><br>
> <b>Shared Database, Shared Schema Multi-tenancy</b><br>
> This form/model is directly opposite the first form. The database and application instance are physically shared but
> their data is logically isolated, using a discriminator column. As much as it saves on database resources, it provides
> the least level of security. There is a big chance that the separate tenants can access each other's data by chance as
> the basic separating instance for every tenant would be the discriminator field. It is the easiest to set up in a multi-tenant
> application.
> <br><br>
> <b>Share Database, Separate Schema Multi-tenancy</b><br>
> It is a compromise point between the first two forms. While it provides the security and isolation in database-per-tenant
> multi-tenancy, it also offers the simplicity of a shared database. It is set up similarly to database-per-tenant multi-tenancy.
> Tenants share the same database but own different schema, thereby giving the feel of segregated data. So, even though
> the tenants' data are on the same database, they are isolated by schema, which is like an abstraction of tables, views,
> and other database metadata within the database itself.
> <br><br>
-----------------------------------------------------------------------------
## API SECURITY
> 1. Validate the input fields in the request body, path variables, and query parameters. Also, for APIs that accept file
> upload, Java provides a method that restricts Path traversal attacks using the File.getCanonicalPath() method
> 2. Apply authentication to restrict access to the APIs, and authorization to limit the parts of the application a user
> can access using role-based privileges
> 3. Apply SSL/TLS certificates to encrypt data in transit, while also applying modern encryption algorithms on sensitive data at rest
> 4. Apply rate-limiting and throttling measures to prevent malicious users from overloading the API in a DDOS attack. Rate limiting can also
> be achieved through the use of API gateway which could provide authentication and authorization for every service the application
> provides
> 5. Use logging and monitoring mechanisms to track and identify potential security threats, keeping an up-to-date registry
> of malicious patterns.

-----------------------------------------------------------------------------
<br><br>

## Author
👤 **olatoye-daramola**
* Github: [@olatoye-daramola](https://github.com/olatoye-daramola)
* LinkedIn: [Olatoye Daramola](https://www.linkedin.com/in/olatoye-daramola/)

