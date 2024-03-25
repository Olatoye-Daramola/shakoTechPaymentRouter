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
1. run your application
2. yeah, it's that straightforward...provided that you have JDK installed on your machine.

```sh
gradlew bootRun
```

### Run the tests

```sh
gradlew test
```

## MULTI-TENANCY
> Multi-tenancy is a design approach where numerous tenants can utilize a single software instance and underlying infrastructure.
> Its aim is to allocate each tenant their own portion of the instance while safeguarding the segregation of their respective information.<br><br>
> Every tenant gets a personalized share of the application instance including its data, configuration, user management, 
> tenant-specific functional and non-functional properties. Due to efficient resource sharing among tenants, multi-tenancy
> can reduce the overall cost of running a software/application due to the fact that there is no dedicated resource for each tenant.<br><br>
> It offers data privacy and infrastructure in such a way that a security breach in a database does not cascade to other 
> tenant's database due to the level of data separation.isolation. Also, it simplifies maintenance and upgrades as updates and maintenance can be applied to all tenants simultaneously, paving way for software
> version standardization.

## Author

👤 **olatoye-daramola**

* Github: [@olatoye-daramola](https://github.com/olatoye-daramola)
* LinkedIn: [Olatoye Daramola](https://www.linkedin.com/in/olatoye-daramola/)

