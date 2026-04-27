# Client-Server Time-Hash Service

## Overview
This project implements a simple client-server system:
- **Server (Spring Boot)**  
  Generates a SHA-256 hash based on the current time (UTC, per minute) and exposes it via a REST endpoint.

- **Client (HTML/JS)**  
  Periodically requests the hash, verifies it locally, and displays the result.

---

## Requirements

- Docker

---

## How to run

Run the following command in the project root:

docker compose up --build
