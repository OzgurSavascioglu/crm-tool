
# CRM Tool

**CRM Tool for Etiya Internship**

A Spring Boot–based Customer Relationship Management (CRM) application developed as part of the Etiya internship program. This project includes customer, contacts, and notes management with soft delete support, integrated H2 database, and API endpoints documented via Swagger.

----------

## Features

-   **CRUD Operations**  for Customers, Contacts, and Notes

-   **Soft Delete**  using an  `isactive`  flag

-   **H2 Database**  (in-memory or file-based) for easy development and testing

-   **Spring Data JPA**  for simplified data access

-   **Optional Swagger (Springdoc OpenAPI)**  UI for API exploration

-   **Secure (or disabled) Security Configuration**  depending on your needs


----------

## Quick Start

### Prerequisites

-   Java 21 (or compatible)

-   Maven (or can run via included Maven Wrapper)


### Setup

1.  **Clone the repo**:

    bash

    CopyEdit

    `git clone https://github.com/OzgurSavascioglu/crm-tool.git cd crm-tool`

2.  **Add Swagger UI dependency**  (optional):

    xml

    CopyEdit

    `<dependency> <groupId>org.springdoc</groupId> <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId> <version>2.1.0</version> </dependency>`

    Refresh Maven if needed.

3.  **Configure Security**  to disable authentication (optional):

    java

    CopyEdit

    `@Configuration  @EnableWebSecurity  public  class  SecurityConfig { @Bean  public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {
            http.authorizeHttpRequests(authz -> authz.anyRequest().permitAll())
                .csrf(csrf -> csrf.disable()); return http.build();
        }
    }`

4.  **Set Up H2 Database**  in  `application.properties`:

    properties

    CopyEdit

    `spring.datasource.url=jdbc:h2:file:~/crmdb;AUTO_SERVER=TRUE
    spring.datasource.username=sa
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update`

5.  **Run the App**:

    bash

    CopyEdit

    `./mvnw spring-boot:run`


----------

## API Overview

-   `GET /customers/getall`  — List all customers

-   `GET /customers/getactive`  — List all active customers

-   `POST /customers/add`  — Create a new customer

-   `GET /customers/getById/{id}`  — Retrieve customer by ID

-   `PUT /customers/update`  — Update customer details

-   `DELETE /customers/softDelete/{id}`  — Soft-delete (set `isactive = false`)

-   `DELETE /customers/{id}`  — Permanent delete

----------

## Soft Delete Implementation

-   `isactive`  field added to entities (default  `true`)

-   Service method wrapped with  `@Transactional`

-   DELETE request sets  `isactive = false`

----------

## Learn More

-   For API documentation, access Swagger UI:

    bash

    CopyEdit

    `http://localhost:8080/swagger-ui.html`

    (Ensure the Swagger dependency is included.)

-   For inspecting the DB, go to:

    bash

    CopyEdit

    `http://localhost:8080/h2-console`