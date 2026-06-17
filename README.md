# Springboot-DynamoDB Project

This project demonstrates how to build a Spring Boot REST API that integrates with Amazon DynamoDB using the AWS SDK v2 **DynamoDbEnhancedClient**.

It supports:
- Local DynamoDB setup for development
- Switching to AWS DynamoDB for production
- Clean repository/service/controller layered architecture

---

# Tech Stack

- Java 21+
- Spring Boot
- AWS SDK v2 (DynamoDB Enhanced Client)
- DynamoDB (Local + AWS)
- Gradle
- Docker (for local DynamoDB)

---

# Project Structure
```
com.java.springboot_dynamodb
├── config → DynamoDB configuration (local + AWS clients)
├── controller → REST APIs
├── service → Business logic
├── repository → DynamoDB access layer
├── model → DynamoDB entities
└── dto → API request/response objects
```


---

# Local DynamoDB Setup

This project supports running DynamoDB locally using Docker.

## 1. Start DynamoDB Local

```
docker run -p 8000:8000 amazon/dynamodb-local
```

## 2. Application Configuration (Local)
```
aws:
  region: ca-central-1
  dynamodb:
    endpoint: http://localhost:8000
```

# AWS DynamoDB Setup

## 1. Install AWS CLI on macOS

If you have Homebrew (most developers do):
```
brew install awscli

Verify:

aws --version
```
## 2. Configure AWS Credentials

After installation:
```
aws configure
```
You'll be prompted for:
```
AWS Access Key ID:
AWS Secret Access Key:
Default region:
Default output format:

Example:

AWS Access Key ID: AKIA...
AWS Secret Access Key: xxxxxxxxx
Default region: us-east-1
Default output format: json
```
This creates:
```
~/.aws/credentials
~/.aws/config
```
## 3. Test Connectivity

After configuring:
```
aws sts get-caller-identity
```
You should see your AWS account information returned.

## 4. Then test DynamoDB:
```
aws dynamodb list-tables
```
If that works, your Spring Boot application can usually connect to AWS DynamoDB using the same credentials.

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)