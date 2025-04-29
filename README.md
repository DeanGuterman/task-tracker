# 🗂 Task Tracker API (Spring Boot)

This is a simple RESTful Task Tracker API built with Spring Boot.  
It supports basic task management operations (CRUD) using an in-memory data structure, and it's structured for future integration with a real PostgreSQL database.

---

##  Features

- View all tasks (`GET /tasks`)
- View a task by ID (`GET /tasks/{id}`)
- Add a new task (`POST /tasks`)
- Delete a task (`DELETE /tasks/{id}`)
- Data is stored in-memory for now (Java List)

---

##  Task Model

Each task has the following fields:

- `id`: unique task identifier (auto-generated)
- `title`: short title of the task
- `description`: longer text
- `dueDate`: date the task is due (in ISO format)
- `status`: one of `TODO`, `IN_PROGRESS`, `COMPLETED`, `CANCELED`

---

##  Testing the API

You can use [Postman](https://www.postman.com/) or `curl` to interact with the endpoints.

### Sample `POST` request:
```http
POST /tasks
Content-Type: application/json

{
  "title": "Finish README",
  "description": "Write a clean README for the project",
  "dueDate": "2025-05-01",
  "status": "IN_PROGRESS"
}
