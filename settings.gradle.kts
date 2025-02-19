rootProject.name = "banking-system"

pluginManagement {
        repositories {
                gradlePluginPortal()
                mavenCentral()
        }
}

dependencyResolutionManagement {
        repositories {
                mavenCentral()
        }
}

include("service:account-service")
include("service:fraud-detection-service")
include("service:reporting-service")
include("service:transaction-service")

// Include common shared module and API Gateway
include("common")
include("api-gateway")

// Map project names to their actual folder paths (optional, but cleaner)
project(":service:account-service").projectDir = file("service/account-service")
project(":service:fraud-detection-service").projectDir = file("service/fraud-detection-service")
project(":service:reporting-service").projectDir = file("service/reporting-service")
project(":service:transaction-service").projectDir = file("service/transaction-service")

project(":common").projectDir = file("common")
project(":api-gateway").projectDir = file("api-gateway")