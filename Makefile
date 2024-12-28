all: build

start:
	@docker compose -f docker-compose.ci.yml up -d

build:
	@./gradlew build --warning-mode all

lint:
	@docker exec pfragatina-purchase-center-test-server ./gradlew spotlessCheck

run-tests:
	@./gradlew test --warning-mode all

test:
	@docker exec pfragatina-purchase-center-test-server ./gradlew test --warning-mode all

run:
	@./gradlew :run

ping-mysql:
	@docker exec pfragatina-mysql mysqladmin --user=root --password=pfr4g4t1n4 --host "127.0.0.1" ping --silent

# Start the app
start-backend:
	@./gradlew bootRun --args='backend server'
