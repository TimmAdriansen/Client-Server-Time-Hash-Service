# Client-Server Time-Hash Service

## Overview
This project implements a simple client-server system:
- **Server (Spring Boot)**  
  Generates a SHA-256 hash based on the current time (UTC, per minute) and exposes it via a REST endpoint.

- **Client (HTML/JS)**  
  Periodically requests the hash, verifies it locally, and displays the result.

---

## Requirements for running application

- Docker

---

## How to run

- Run the following command in the project root:

docker compose up --build

- Go to http://localhost:3000/ in browser
- Logs will be shown in the terminal



## UI
- Client side page


<img width="859" height="721" alt="image" src="https://github.com/user-attachments/assets/887f2145-ab4b-4b15-a46d-aa2ad4d81731" />


- Logs

<img width="1896" height="687" alt="image" src="https://github.com/user-attachments/assets/0493f379-a3b3-475d-9b2a-11b67da33250" />

