KidsBrowser: Secure Web Navigation via Design Patterns
📝 Description

KidsBrowser is a specialized HTTP client wrapper designed with safety as a priority. It implements a multi-layered parental control system that intercepts web requests to filter out restricted content. The project serves as a technical showcase for the practical application of Creational and Structural Design Patterns in Kotlin, ensuring the code remains modular, secure, and easy to use.
🚀 Design Patterns in Action

To achieve a clean architecture, the project utilizes three fundamental patterns:
Pattern	Role in Project	Benefit
Prototype	GenericRequest implementation	Allows efficient cloning of base HTTP requests to reuse headers and configurations.
Proxy	CleanGetRequest layer	Acts as a security firewall, intercepting GET requests to validate URLs against a blacklist before execution.
Facade	KidsBrowser interface	Provides a high-level, simplified entry point for the user, hiding the complexity of request types and filtering logic.
🏗️ Project Structure
Plaintext

ParentalControl/
├── blockedKeywords.txt      # Blacklist of restricted terms/URLs
src/
├── Clonable.kt              # Interface for Prototype pattern
├── GenericRequest.kt        # Base Prototype implementation
├── GetRequest.kt            # Standard GET implementation
├── CleanGetRequest.kt       # The Security Proxy (Parental Control)
├── PostRequest.kt           # Standard POST implementation
├── KidsBrowser.kt           # The Facade (Simplified API)
└── Hello.kt                 # Main entry point
target/
pom.xml                      # Maven configuration

🔄 How It Works

The browser flow follows a secure pipeline to protect the end-user:

    Request Initiation: The user interacts with the KidsBrowser (Facade).

    Security Interception: If a GET request is made, the CleanGetRequest (Proxy) checks the target URL.

    Blacklist Validation: The Proxy reads blockedKeywords.txt. If a match is found, the request is aborted.

    Redirection/Execution: Safe requests proceed normally; blocked requests are redirected to a pre-defined "Safe Page."

💻 Usage Example

Input (Console):
Plaintext

Enter request type (GET/POST): 
GET
URL: http://restricted-site.com

Output:
Plaintext

CANNOT ACCESS THIS WEBSITE! ACCESS DENIED BY PARENTAL CONTROL.
Redirecting to: http://safe-for-kids.com

⚙️ Build & Run

Ensure you have Maven and JDK 8+ installed.

    Clone and Navigate:
    Bash

    git clone <repo-url>
    cd ParentalControl

    Compile and Execute:
    Bash

    mvn clean compile exec:java -Dexec.mainClass="org.alin.HelloKt"

🛠️ Tech Stack

    Language: Kotlin 1.3.71

    Build Tool: Maven

    HTTP Client: khttp
