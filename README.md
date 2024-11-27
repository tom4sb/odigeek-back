# Instructions
### Generating the Docker Image
To build the image, run the following command from the Dockerfile directory:


**$ docker image build -t odigeek:0.0.1 .**

Running the Image
To execute the image, use:

**$ docker run -p 8080:8080 odigeek:0.0.1 --profile=dragon-ball**

## Available Profiles

You can specify one of the following profiles:
- `dragon-ball`
- `star-wars`
- `dragon-ball,star-wars`
- No profile

## Postman Collection

A Postman collection file is included in the `postman` directory. This collection contains examples of all the API endpoints developed.

## Data Types for Requests

Below are the specific values allowed for certain data types:

### Currency Codes
- `EUR`
- `USD`

### Scope
- `CATALOG`
- `CATEGORY`
- `TITLE`

### Subscription Titles
- `DRAGON_BALL_HUMANS`
- `DRAGON_BALL_SAIYANS`
- `STAR_WARS_PEOPLE`
- `STAR_WARS_PLANETS`

### Categories
- `ANIME`
- `LIVING_BEINGS`
- `SPACE_OPERA`

### Roles
- `BI_TEAM`
- `FINANCE_TEAM`
- `GEEK_SPECIALIST`
- `SALES_TEAM`
- `USER`

### Dates
- Format: `yyyy-MM-dd`

## Technologies Used

I chose **Java 21** to use the latest language features. In addition to Spring Boot, the project includes the following dependencies:
- **OpenFeign**: For external API calls (Dragon Ball and Star Wars data).
- **Spring Security**: For basic authentication.
- **Mockito**: For unit test mocking.
- **JaCoCo**: For test coverage reports.

## Application Design and Decisions

I opted for a **hexagonal architecture** as it fits well with the proposed problem.

### Identified Domains and Use Cases

#### Domain Layer
- `Offer`
- `Subscription`
- `User`

#### Application Layer (Use Cases)
- `CreateOffer`
- `CreateSubscription`
- `UpdateSubscriptionContent`
- `UpdateSubscriptionPrice`
- `UpdateSubscriptionStatus`
- `CreateUser`
- `SubscribeUser`
- `UnsubscribeUser`

#### Infrastructure Layer
This layer includes:
- Controllers
- Various configurations
- Port adapters (e.g., for persistence)
- Scheduled tasks

Configurations can also be found in the `application.yml` file.

### CQRS Approach

I've aimed to follow a **CQRS pattern** by separating commands and queries, though improvements could be made.

---

## Database

Since this is a proof of concept, I chose **in-memory persistence**. However, my initial choice for production would be a **NoSQL database** (e.g., MongoDB), due to:
- **Low write frequency**: Data is written only occasionally (e.g., user creation, offer application) but read frequently.
- **Data heterogeneity**: Entities like characters in subscriptions have non-uniform data structures, making a JSON-based document database advantageous.

---

## Authentication

I implemented **basic authentication**, which suffices for this test. However, in a real-world scenario, a more robust solution like **JWT** would be ideal.

---

## Application Logic

### API Downtime on Weekends

To handle the unavailability of APIs on weekends:
- All possible subscriptions are created at startup.
- The active ones are determined by the profile parameter.

### Daily Updates

Content updates are processed only on weekdays. This ensures data availability and allows new subscriptions during weekends using the stored data.
> **Note**: With in-memory persistence, application restarts would lead to data loss in this test setup.

---

### User Role Projections

Different user roles (e.g., `BI_TEAM`, `SALES_TEAM`) determine what information is shown. Role-specific projections are used to display only the relevant user data.

---

## Additional Features

### Future Expansion for Figures

The system is prepared to handle figures in the future. Currently, an empty list is always returned until a data source is available.

---

### Cross-Department Data Sharing

To share data with other departments, I propose an **event-driven system**:
- Events are triggered for each action.
- Other departments can subscribe to these events to keep their systems synchronized in real-time.

---

## API Design

I aimed for **RESTful compliance** in:
- URL design
- HTTP verbs
- Response codes

Additionally, a basic exception handler was implemented for some common exceptions.

---

## Testing

### Tools
- **JUnit** and **Mockito**: Used for testing.
- **JaCoCo**: Generates test coverage reports, available in `target/site/jacoco` after building the project.

---

## Design Patterns

I applied the following patterns:
- **Command**: Used for the command bus to streamline command dispatching across the application.
- **Strategy**: Used for applying offers based on their scope. This pattern simplifies adding new strategies without affecting existing code.
    - *Note*: Implementation can be improved.
- **Factory**: Used for consuming external API data from different suppliers, keeping the system scalable for future additions.

---

## Future Improvements

- **Price History**: Implement an audit trail for price changes (reason, user, date, etc.) via event-driven logging.
- **Test Coverage**: Increase test coverage, adding integration and end-to-end (e2e) tests.
    - Tests should use randomized data for reliability and tools like Mothers for clean test data generation.
- **Configuration Management**: Extract dependency versions and other configuration details into separate files.
- **Bug Fixes**: With more time, several potential bugs and code improvements could be addressed.
