here’s a tight-but-detailed recap you can skim before interviews 👇

# Part-1 Summary — Spring Boot Interview Q&A (Java Techie)

## 1) Why choose Spring Boot over “classic” Spring?

* **Dependency management & version conflicts:**

    * *Before Boot:* you manually list many dependencies (spring-core, context, webmvc, hibernate, jackson, servlet API, DB driver, etc.) and pin versions → easy to mismatch.
    * *With Boot:* declare a few **starters** (e.g., `spring-boot-starter-web`, `spring-boot-starter-data-jpa`), and the **parent BOM** aligns transitive versions automatically.
* **Fewer configurations:**

    * *Before:* XML/Java config to wire DataSource, SessionFactory/EntityManager, TxManager, DispatcherServlet, component scanning.
    * *With Boot:* set properties in `application.properties|yml`; Boot autoconfigures DataSource/JPA/Tx/Web; only define repos (`JpaRepository`) & entities.
* **Embedded server:**

    * Boot ships **embedded Tomcat/Jetty/Undertow**; run directly from your IDE or CLI. No external app server needed.
* **Production-ready features:**

    * **Actuator**: health, metrics, info, env, etc.; easy to add custom metrics & expose endpoints.

## 2) Common Spring Boot starters & modules (what you can say you’ve used)

* `spring-boot-starter-web` (REST, MVC), `spring-boot-starter-data-jpa`, `spring-boot-starter-security`, `spring-boot-starter-aop`, `spring-boot-starter-web-services` (SOAP), Kafka/Rabbit starters for messaging, **Spring Cloud** (discovery/config/load-balancing), `spring-boot-starter-thymeleaf`, `spring-boot-starter-actuator`.

## 3) Ways to run a Spring Boot app

* **IDE**: run the `main` class with `@SpringBootApplication`.
* **CLI (Maven)**: `mvn spring-boot:run` (executes from compiled **target/classes**; no jar needed).
* **Packaged jar**: `mvn package` → run `java -jar app.jar`.
  Inside the jar: `META-INF/MANIFEST.MF` contains `Start-Class`, Boot loader uses `BOOT-INF/classes` and `BOOT-INF/lib`.

## 4) `@SpringBootApplication` = three annotations

* `@EnableAutoConfiguration` — drives Boot’s auto-config mechanism based on classpath, properties, and conditions.
* `@ComponentScan` — scans the package of your **main class** and subpackages.

    * If beans live **outside** that root, specify `@ComponentScan(basePackages = "...")`.
* `@Configuration` — lets you write Java config classes (e.g., `SecurityConfig`, `SwaggerConfig`) that register beans.

> You can replace `@SpringBootApplication` with the trio: `@EnableAutoConfiguration`, `@ComponentScan(...)`, `@Configuration` (+ `@Import` for extra configs); app still works.

## 5) Auto-configuration — how it really works

* Boot evaluates **conditions** to decide whether to configure a feature:

    * `@ConditionalOnClass` (e.g., `ObjectMapper` present → enable Jackson auto-config),
    * `@ConditionalOnMissingBean` (don’t override your explicit beans),
    * `@ConditionalOnProperty` (e.g., `spring.aop.auto=true` by default),
    * `@EnableConfigurationProperties` (binds `spring.datasource.*`, etc.).
* **Positive vs Negative matches** (when setting `debug=true`): console shows which auto-configs matched/missed and why.
* Example:

    * Add JPA starter → `DataSourceAutoConfiguration` becomes a *positive* match.
    * It still **fails** if required props (`spring.datasource.url`, `username`, `password`, `driver-class-name`) are missing—conditions must be fully satisfied.

## 6) Disabling an auto-configuration

* In code:

  ```java
  @SpringBootApplication(exclude = {
      DataSourceAutoConfiguration.class,
      AopAutoConfiguration.class
  })
  ```
* Or in properties:
  `spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.aop.AopAutoConfiguration`

## 7) Customizing defaults (overrides)

* Put overrides in `application.properties` or `application.yml`.
  Examples: `server.port=8181`, `spring.jpa.hibernate.ddl-auto=update`, `logging.level.*`, `management.*` (Actuator).

## 8) What happens inside `SpringApplication.run(...)`

**Execution flow (debug walk-through):**

1. **Prepare environment**: merges property sources from `application.properties`/`yml`, system/env vars; renders banner.
2. **Detect app type**: `WebApplicationType` = `SERVLET` (MVC), `REACTIVE`, or `NONE`.
3. **Create ApplicationContext**: for servlet apps → `AnnotationConfigServletWebServerApplicationContext`.
4. **Register beans**: component scan & config classes loaded into context.
5. **Start embedded server**: creates `TomcatServletWebServerFactory` (or Jetty/Undertow) & starts server.
6. **Refresh context**: lifecycle callbacks, `SmartLifecycle`, etc.

Return value of `run(...)` is the **ApplicationContext**.

## 9) `CommandLineRunner`

* A functional interface whose `run(String... args)` executes **after** `SpringApplication.run(...)` completes.
  Use it for boot-time tasks: priming caches, seeding DB, validating configs, warming up clients, etc.
* Ordering: `SpringApplication.run` happens first; then `CommandLineRunner.run`.

---

## Tiny code reminders you can quote in interviews

**Minimal JPA repo setup**

```java
public interface CustomerRepo extends JpaRepository<Customer, Long> {}
```

**Disable one autoconfig**

```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class App {}
```

**Custom scan root**

```java
@ComponentScan(basePackages = {"com.myapp", "com.partner.lib"})
```

**Boot-time task**

```java
@Bean
CommandLineRunner init(CustomerRepo repo) {
  return args -> { /* seed or validate */ };
}
```

---

## Interviewer-friendly contrasts (1-liners)

* **Boot vs Spring**: Boot = *opinionated defaults + autoconfiguration + starters + embedded server* → drastically less setup and fewer version issues than classic Spring.
* **Autoconfig**: *Classpath + properties + conditions* decide what’s wired; your explicit beans always win.
* **Run modes**: IDE / `mvn spring-boot:run` / fat jar; Boot’s loader uses `Start-Class` & `BOOT-INF/*`.
* **Component scan gotcha**: main class package is the scan root; anything outside needs explicit `@ComponentScan`.
* **Actuator**: instant health/metrics/endpoints; production visibility with minimal work.

If you want, I can turn this into a printable one-pager or an Anki deck with Q→A cards for spaced repetition.

Here’s a detailed **Part-2 summary** of the Spring Boot Interview Q&A series 👇

---

# Part 2 Summary — Spring Boot Interview Q&A (Java Techie)

## 1. **Stereotype Annotations**

* **Purpose:** Indicate a class’s role in the application.
* **Types:**

    * `@Component` → generic bean.
    * `@Service` → business logic layer.
    * `@Repository` → persistence/DAO layer.
    * `@Controller` / `@RestController` → web layer (endpoints).
* **Hierarchy:** All inherit from `@Component`. `@RestController` → `@Controller` → `@Component`.
* **Trick:** You *can* swap them (e.g., mark DAO as `@Controller`), it will still work, but not recommended (semantics matter for readability).

---

## 2. **Ways to Define Beans**

* **Stereotype annotations** (above).
* **Java config**:

  ```java
  @Configuration
  public class AppConfig {
      @Bean
      public DemoService demoService() { return new DemoService(); }
  }
  ```

---

## 3. **Dependency Injection (DI)**

* **Definition:** A design pattern to achieve *loose coupling* by delegating object creation to Spring.
* **Without Spring:** tight coupling (direct `new`), or partial coupling (factories/interfaces).
* **With Spring:** just declare `@Autowired` on a dependency; lifecycle managed by container.

---

## 4. **Types of Dependency Injection**

* **Field injection:**

  ```java
  @Autowired private OrderRepo repo;
  ```
* **Setter injection:**

  ```java
  @Autowired public void setRepo(OrderRepo repo) { this.repo = repo; }
  ```
* **Constructor injection:**

  ```java
  @Autowired
  public OrderService(OrderRepo repo) { this.repo = repo; }
  ```
* **Note:** If only one constructor, `@Autowired` is optional.

---

## 5. **Constructor vs Setter Injection**

* **Constructor injection**

    * Mandatory dependencies.
    * Immutable → can’t be changed after creation.
    * Doesn’t handle circular dependencies.
* **Setter injection**

    * Optional dependencies.
    * Mutable (can reset via setter).
    * Works with circular dependencies (with `@Lazy`).

**Circular dep fix with Setter + `@Lazy`:**

```java
@Autowired @Lazy private RestClientService restClientService;
```

---

## 6. **`@PostConstruct`**

* Runs preprocessing logic **after Spring context initialized** but before `CommandLineRunner`.
* **Execution order:**

    1. `SpringApplication.run()`
    2. `@PostConstruct` methods
    3. `CommandLineRunner.run()`
* **Use cases:**

    * Initialize DB connection pools.
    * Preload cache/data.
    * Bootstrap Kafka/Rabbit producers/consumers.
    * Seed DB with test data.

---

## 7. **Dynamic Values in Spring Boot**

* **Via `@Value`:**

  ```java
  @Value("${discount.offer.price}") private int discountPrice;
  ```
* **Via `Environment`:**

  ```java
  @Autowired private Environment env;
  String price = env.getProperty("discount.offer.price");
  ```
* **Sources:**

    * `application.properties`
    * `application.yml`
    * Environment variables / VM args
    * External property files

---

## 8. **Properties vs YAML**

* **Properties file:** flat, key=value, simulate hierarchy with dot prefixes.
* **YAML:** structured, indentation, supports arrays/lists directly, better readability.
* **Example:**

  ```properties
  spring.datasource.url=jdbc:mysql://localhost/db
  spring.datasource.username=user
  ```

  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost/db
      username: user
  ```

---

## 9. **`.yml` vs `.yaml`**

* Both identical.
* `.yml` was used historically (3-char extensions on Windows).
* Today `.yaml` is more common, but both work in Spring Boot.

---

## 10. **Properties vs YAML Precedence**

* If same key exists in both: **`application.properties` takes precedence** (loaded first).
* Verified via Spring’s `PropertySourceLoader`:

    * `PropertiesPropertySourceLoader` runs before `YamlPropertySourceLoader`.

---

## 11. **Loading External Properties**

* Keep configs outside jar (best practice).
* Example: `test.properties` on Desktop.
* In `application.properties`:

  ```properties
  spring.config.import=optional:file:////Users/you/Desktop/test.properties
  ```
* Now Spring loads values from external file without redeploying code.

---

## 12. **Binding Properties to Java Objects**

* Use `@ConfigurationProperties`:

  ```java
  @Component
  @ConfigurationProperties(prefix="spring.datasource")
  public class DataSourceConfig {
      private String username;
      private String password;
      // getters/setters
  }
  ```
* This binds `spring.datasource.username` and `spring.datasource.password` to object fields.
* Advantage: structured, type-safe config instead of scattered `@Value` fields.

---

# 🚀 Key Takeaways for Interviews

* **Stereotype annotations:** semantics matter (use correct layer annotation).
* **DI types:** field, setter, constructor — know pros/cons.
* **Constructor vs Setter:** mandatory vs optional, immutability vs flexibility, circular deps.
* **`@PostConstruct` vs `CommandLineRunner`:** both preprocess, order matters.
* **Config:** prefer YAML for complex/hierarchical configs; properties still valid.
* **Precedence:** properties > YAML.
* **External configs:** via `spring.config.import`.
* **Type-safe binding:** use `@ConfigurationProperties`.

---

Do you want me to also create a **comparison table (Setter vs Constructor, Properties vs YAML, PostConstruct vs CommandLineRunner)** so you can revise quickly before interviews?
Got it 👍 — here’s a **detailed structured summary of Part-3 of the Spring Boot Interview Q&A series**.

---

# Part 3 Summary — Spring Boot Interview Q&A (Java Techie)

---

## 1. **Bean Dependency Ambiguity**

* **Problem:** When an interface has multiple implementations, injecting by interface alone leads to ambiguity:

  ```
  @Autowired
  private OrderRepository repo;  // fails if two impls exist
  ```
* **Error:**

  ```
  required a single bean, but 2 were found: [orderRepositoryImpl1, orderRepositoryImpl2]
  ```
* **Solutions:**

    1. **`@Qualifier`** (Spring-specific, by type + name):

       ```java
       @Autowired
       @Qualifier("orderRepositoryImpl2")
       private OrderRepository repo;
       ```
    2. **`@Resource`** (Java standard, JSR-250, by name):

       ```java
       @Resource(name="orderRepositoryImpl1")
       private OrderRepository repo;
       ```
* **Key difference:**

    * `@Qualifier` → by **type**, Spring annotation.
    * `@Resource` → by **name**, Java standard annotation.

---

## 2. **Bean Scopes in Spring**

**Definition:** Determines a bean’s **lifecycle and visibility** in the Spring IoC container.

* **Core scopes:**

    * `singleton` (default): one instance per Spring context.
    * `prototype`: new instance every time bean is requested.
* **Web scopes:**

    * `request`: new bean per HTTP request.
    * `session`: one bean per user session.
    * `application`: one bean per web application (ServletContext-wide).
    * `websocket`: one bean per WebSocket session.

### Demonstrations

* **Singleton:** only 1 instance created, reused for all requests.
* **Prototype:** new instance created every time `context.getBean()` is called.
* **Request:** new instance created per HTTP request (discarded after response).
* **Session:** one instance per user session (destroyed at session timeout).
* **Application:** one instance shared across entire web app.
* **WebSocket:** one instance per WebSocket connection.

---

## 3. **Custom Bean Scope**

* **Use case:** e.g., need one bean instance **per thread**.
* **Steps:**

    1. Implement `org.springframework.beans.factory.config.Scope`.

        * Override: `get()`, `remove()`, `registerDestructionCallback()`, etc.
    2. Manage beans using a `ThreadLocal` map.
    3. Register custom scope in Spring context:

       ```java
       context.getBeanFactory().registerScope("thread", new ThreadScope());
       ```
    4. Use in beans:

       ```java
       @Scope("thread")
       @Component
       public class MyThreadBean { ... }
       ```
* **Demo:** Each thread gets its own instance; within same thread, bean reused.

---

## 4. **Real-world Use Cases for Scopes**

* **Singleton scope:**

    * Database configurations / connection pools.
    * Stateless service classes.
    * Application-wide configs or constants.
* **Prototype scope:**

    * User session-specific objects.
    * Non-thread-safe objects (e.g., parsers, builders).
    * Heavy initialization objects where disposal is required after use.

---

## 5. **Injecting Prototype into Singleton**

* **Problem:** If a `@Prototype` bean is injected into a `@Singleton`, the prototype bean behaves like a **singleton** (only one instance created at injection time).
* **Workarounds:**

    1. **ApplicationContext:** manually fetch prototype each time.

       ```java
       context.getBean(PrototypeBean.class);
       ```
    2. **`ObjectFactory<T>` or `Provider<T>`:**

       ```java
       @Autowired private ObjectFactory<PrototypeBean> factory;
       factory.getObject();
       ```
    3. **`@Lookup` method injection:**

       ```java
       @Lookup
       public PrototypeBean getPrototypeBean() { return null; }
       ```
* **Takeaway:** Use these techniques to preserve prototype semantics inside singleton beans.

---

## 6. **Spring Singleton vs Plain Java Singleton**

* **Plain Java Singleton:** single instance per **JVM** (per classloader).
* **Spring Singleton:** single instance per **ApplicationContext**.
* Implication: If you have multiple Spring contexts in one JVM, each context creates its own singleton instance.

---

## 7. **BeanPostProcessor**

* **Purpose:** Customize bean logic **before and/or after initialization**.
* **Interface methods:**

    * `postProcessBeforeInitialization(Object bean, String beanName)`
    * `postProcessAfterInitialization(Object bean, String beanName)`
* **Example Use Case:**

    * Validate password field in a `User` bean before initialization.
    * Add logging, monitoring, or AOP proxies after initialization.
* **Other Real-world Use Cases:**

    * Modify/add properties dynamically.
    * Add custom aspects or proxies.
    * Integrate monitoring or custom lifecycle hooks.

---

# 🚀 Key Interview Takeaways from Part 3

* **Bean ambiguity:** resolved via `@Qualifier` (by type) or `@Resource` (by name).
* **Scopes:**

    * Singleton = 1 per context.
    * Prototype = new instance every request.
    * Web scopes = per request/session/app/websocket.
* **Custom scope:** implement `Scope` (e.g., per thread).
* **Singleton vs Prototype conflict:** injecting prototype into singleton “freezes” it → solve with `ApplicationContext`, `ObjectFactory`, or `@Lookup`.
* **Spring singleton vs Java singleton:** context vs JVM.
* **BeanPostProcessor:** hook for bean lifecycle, useful for validation, proxies, logging.

---

Do you want me to also build a **quick-reference comparison table** (Scopes | Lifetime | Use case | Example) so you can glance it before interviews?
Perfect — here’s a **detailed structured summary of Part-4 of the Spring Boot Interview Q&A series** 👇

---

# Part 4 Summary — Spring Boot Interview Q&A (Java Techie)

---

## 1. **HTTP Methods in RESTful Services**

* Common methods: **GET, POST, PUT, PATCH, DELETE**.
* **GET** → retrieve resources.
* **POST** → create resource (non-idempotent).
* **PUT** → full update (idempotent).
* **PATCH** → partial update.
* **DELETE** → remove resource.
* These five are the most widely used.

---

## 2. **Mapping HTTP Methods in Spring**

* Specific annotations:

    * `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping`, `@DeleteMapping`.
* All extend from **`@RequestMapping`** (older style, with `method=RequestMethod.GET`).
* **Request Body:** required for POST & PUT; optional in GET/DELETE (input usually comes via URL).

---

## 3. **Scenario-Based Endpoint Design**

### a) Filter products by product type

* **PathVariable approach:**

  ```java
  @GetMapping("/products/search/{type}")
  public List<Product> getByType(@PathVariable String type) { … }
  ```

### b) Return all products if no filter

* **RequestParam approach:**

  ```java
  @GetMapping("/products/filter")
  public List<Product> findProducts(@RequestParam(required=false) String type) { … }
  ```
* Supports optional input (`required=false`), even **defaultValue** if needed.

---

## 4. **PathVariable vs RequestParam**

* **PathVariable**:

    * Input is mandatory.
    * Missing → `404 Not Found`.
* **RequestParam**:

    * Input optional.
    * Missing → still valid (default or return all).
* **Real-life analogy:** e-commerce product filter →

    * PathVariable = mandatory category ID.
    * RequestParam = optional filters (brand, color, etc.).

---

## 5. **`@RestController` vs `@Controller`**

* `@Controller`:

    * Returns **view names** (e.g., JSP/Thymeleaf templates).
    * To return JSON/strings → must add `@ResponseBody`.
* `@RestController`:

    * Combines `@Controller + @ResponseBody`.
    * Directly returns JSON/XML/plain text as HTTP response.
* **Conclusion:** Use `@RestController` for REST APIs; use `@Controller` for MVC web apps.

---

## 6. **Deserializing JSON into Objects**

* Use `@RequestBody` in method parameter:

  ```java
  @PostMapping("/books")
  public String addBook(@RequestBody Book book) { … }
  ```
* Keys in JSON **must match field names** in DTO (case-sensitive).
* Example: Book DTO contains nested `Author` list.

---

## 7. **POST vs PUT**

* Both can technically create/update.
* **Best practice:**

    * **POST** → create resource (non-idempotent).
    * **PUT** → update/replace resource (idempotent).
* **Idempotency principle:**

    * Multiple POST calls → new records each time.
    * Multiple PUT calls with same payload → only one update, no extra records.

---

## 8. **Can GET Have Request Body?**

* **Technically possible**, but **not recommended**.
* Best practice: send parameters via URL/query string.
* Interviewer trap question → always emphasize REST convention.

---

## 9. **Content Negotiation**

* REST endpoint can produce multiple media types:

  ```java
  @GetMapping(value="/products", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<Product> getProducts() { … }
  ```
* Needs Jackson for JSON, Jackson-dataformat-xml for XML.
* Controlled via `Accept` header or query param (`?format=json`).

---

## 10. **HTTP Status Codes**

* Common ones:

    * `200 OK` → success.
    * `201 Created` → new resource created.
    * `204 No Content` → update successful, no body.
    * `400 Bad Request` → invalid input.
    * `401 Unauthorized` → authentication failed.
    * `403 Forbidden` → not authorized.
    * `404 Not Found` → resource missing.
    * `405 Method Not Allowed` → wrong HTTP method.
    * `415 Unsupported Media Type` → wrong input format.
    * `500 Internal Server Error` → server error.
    * `502 Bad Gateway` → upstream failure.

---

## 11. **Customizing Status Codes**

* Use `@ResponseStatus`:

  ```java
  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED) // 201
  public void createUser(@RequestBody User user) { … }
  ```

---

## 12. **CORS (Cross-Origin Resource Sharing)**

* Enable at method/class level:

  ```java
  @CrossOrigin(origins="http://localhost:4200")
  ```
* Or global config:

  ```java
  registry.addMapping("/api/**")
          .allowedOrigins("http://localhost:4200")
          .allowedMethods("GET","POST","PUT","DELETE")
          .allowCredentials(true)
          .maxAge(3600);
  ```

---

## 13. **File Upload**

* Use `MultipartFile`:

  ```java
  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) { … }
  ```
* Access file name, bytes, and store to desired location.

---

## 14. **API Versioning Strategies**

* **URI versioning:** `/api/v1/…`, `/api/v2/…`.
* **Request param versioning:** `/api/resource?version=2`.
* **Header versioning:** send `API-Version: 2`.
* Ensures **backward compatibility** while introducing new versions.

---

## 15. **API Documentation with Swagger / OpenAPI 3**

* Dependency: `springdoc-openapi-starter-webmvc-ui`.
* Auto-generates `/swagger-ui.html`.
* Provides:

    * Endpoints list.
    * Request/response models.
    * Status codes.
    * Try-it-out testing.
* **API spec:** available in JSON (`/v3/api-docs`) or YAML (`/v3/api-docs.yaml`).

### Customizations:

* Hide endpoints: `@Hidden`.
* Add descriptions: `@Operation(summary="Insert user", description="...")`.

---

## 16. **Consuming REST APIs**

### a) **RestTemplate**

* Synchronous, simple.
* Example:

  ```java
  restTemplate.getForObject(url, UserResponse.class);
  ```

### b) **Feign Client**

* Declarative client from Netflix.
* Example:

  ```java
  @FeignClient(name="userClient", url="https://jsonplaceholder.typicode.com")
  interface UserClient {
      @GetMapping("/users")
      List<User> getUsers();
  }
  ```

### c) **WebClient**

* Reactive, asynchronous, non-blocking.
* Best for reactive pipelines.
* Example:

  ```java
  webClient.get()
           .uri("/users")
           .retrieve()
           .bodyToFlux(User.class);
  ```

### d) **Advanced Rest Client (Spring Boot 3.2+)**

* Newer, more feature-rich API client (not demonstrated fully here).

---

# 🚀 Key Interview Takeaways from Part 4

* Know HTTP methods & their **idempotency rules**.
* **PathVariable = mandatory**, **RequestParam = optional**.
* `@RestController` = `@Controller + @ResponseBody`.
* Always use `@RequestBody` for JSON → Object mapping.
* Version APIs using **URI, params, or headers**.
* Document APIs with **Swagger/OpenAPI**.
* CORS config is critical for frontend-backend integration.
* File upload handled via **MultipartFile**.
* **RestTemplate, Feign, WebClient** are main API clients.

---

👉 Do you also want me to prepare a **quick one-page “cheat sheet”** (tables of HTTP methods, annotations, status codes, versioning strategies, and clients) so you can revise in minutes before an interview?
Great — here’s a **detailed structured summary of Part-5 of the Spring Boot Interview Q&A series** 👇

---

# Part 5 Summary — Spring Boot Interview Q&A (Java Techie)

---

## 1. **Exception Handling in Spring Boot**

### Problem

* By default, unhandled exceptions return **500 Internal Server Error** with no meaningful info to the end user.
* Users need **clear, actionable error messages**.

### Steps

1. **Custom Exception Classes**

    * Example: `ProductNotFoundException`, `DuplicateProductException`.
    * Extend `RuntimeException` or `Exception` depending on need.

2. **Global Exception Handler**

    * Use `@RestControllerAdvice` + `@ExceptionHandler`.
    * Return a custom `ErrorDTO` (status, message, code).
    * Spring Boot 3+ supports `ProblemDetail` instead of writing custom DTO.

   ```java
   @ExceptionHandler(ProductNotFoundException.class)
   public ProblemDetail handle(ProductNotFoundException ex) {
       return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
   }
   ```

3. **Best Practice**

    * Instead of handling every exception separately, **wrap multiple exceptions into a custom service exception** (`ProductServiceException`) to avoid multiple handlers.

---

## 2. **Validation of Input Payload**

### Bean Validation (Jakarta Validation API)

* Dependency: `spring-boot-starter-validation`.
* Annotate fields with constraints:

    * `@NotNull`, `@NotEmpty`, `@NotBlank` → string checks.
    * `@Min`, `@Max`, `@DecimalMin`, `@DecimalMax` → numeric constraints.
    * `@Email`, `@Pattern` → format checks.
    * `@AssertTrue`, `@AssertFalse` → boolean checks.
    * `@Past`, `@Future` → date checks.

### Example

```java
public class Product {
    @NotNull @NotEmpty private String id;
    @NotBlank private String name;
    @Min(49) @Max(100000) private double price;
    @Email private String email;
}
```

### Handling Validation Errors

* Invalid payload → `MethodArgumentNotValidException`.
* Capture with `@ExceptionHandler` and return a **map of field → error message**.

---

## 3. **Custom Validation**

* Define a custom annotation and validator.
* Example: restrict `productType` to **Education, Electronics, Baby & Kids**.

```java
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductTypeValidator.class)
public @interface ValidProductType {
   String message() default "Invalid product type";
}
```

```java
public class ProductTypeValidator implements ConstraintValidator<ValidProductType, String> {
   private static final List<String> ALLOWED = List.of("Education","Electronics","Baby");
   public boolean isValid(String value, ConstraintValidatorContext ctx) {
       return ALLOWED.contains(value);
   }
}
```

---

## 4. **Spring Profiles**

* Allow **environment-specific configs** (dev, stage, prod).
* Config naming convention:

    * `application.properties` (default).
    * `application-dev.properties`, `application-stage.properties`, `application-prod.properties`.
* Activate with:

  ```properties
  spring.profiles.active=prod
  ```
* Ensures DB, Kafka, or other env configs switch easily.

---

## 5. **Alternative to Profiles → Conditional Beans**

* Use `@ConditionalOnProperty`, `@ConditionalOnClass`, etc.
* Example:

```java
@Configuration
@ConditionalOnProperty(prefix="app.active", name="environment", havingValue="prod")
public class ProdConfig { … }
```

* More flexible than profiles (toggle by bean availability, properties, or classpath).

---

## 6. **Spring AOP (Aspect-Oriented Programming)**

### Purpose

* Separate **cross-cutting concerns** (logging, transactions, auditing, validation, notifications).
* Avoid duplicating code across multiple methods.

### Key Terminologies

* **Aspect** → Class containing cross-cutting logic.
* **Join Point** → Target where aspect is applied (e.g., a method).
* **Pointcut** → Expression to identify join points.
* **Advice** → Action taken at a join point.

### Types of Advice

1. **Before** → runs before method execution.
2. **After** → runs after method, regardless of exceptions.
3. **After Returning** → runs after method only if no exception.
4. **After Throwing** → runs if exception is thrown.
5. **Around** → surrounds method, can run both before & after.

---

## 7. **AOP Practical Use Cases**

### a) Logging Advice

```java
@Before("execution(* com.demo.service.ProductService.*(..))")
public void logBefore(JoinPoint jp) { … }
```

* Logs request before service method executes.
* `@After`, `@AfterReturning`, and `@AfterThrowing` handle respective scenarios.

### b) Performance Tracking with **Around Advice**

```java
@Around("@annotation(TrackExecutionTime)")
public Object track(ProceedingJoinPoint pjp) throws Throwable {
   long start = System.currentTimeMillis();
   Object result = pjp.proceed();
   long duration = System.currentTimeMillis() - start;
   log.info("Execution took: " + duration + " ms");
   return result;
}
```

### c) Logging Request/Response Payload

* Use custom annotation `@LogPayloads`.
* Capture request body before and response after method execution.

---

# 🚀 Key Interview Takeaways (Part 5)

* Always use **`@RestControllerAdvice` + `@ExceptionHandler`** for clean error handling.
* Use **ProblemDetail (Spring Boot 3)** instead of custom DTOs where possible.
* Input validation → **Jakarta Bean Validation API** (`@NotNull`, `@Email`, etc.) + **custom annotations** when needed.
* Use **Profiles** for env switching, **Conditionals** as flexible alternatives.
* **AOP** → clean separation of concerns.

    * Remember 5 types of advice.
    * Common interview question: difference between **Pointcut** and **Join Point**.
* Real-world AOP examples: request/response logging, performance monitoring, transaction handling.

---

Would you like me to also prepare a **condensed “one-pager” cheat sheet** (tables of Exception Handling, Validation Annotations, Profile vs Conditional, and AOP Advices) so you can revise quickly before interviews?
