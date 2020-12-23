# H2O.ai Assignment for a feedback system

### Assumptions
*   Only logged in users can give feedback, therefore a feedback contains the logged in user id.
*   It is assumed that the user is already logged in and no validation is performed on that.
*   User gives the feedback for a product which is already stored in the db, therefore feedback contains only the product id.
*   Rating is mandatory, but not the description (comment).

### Requirements
- Docker
- Docker Compose

### Steps
*   Clone repository
```shell script
git clone https://github.com/evantha/h2o_assignment.git
cd h2o_assignment
```
*   Run Docker Compose
```shell script
docker-compose up
```
*   Visit the following links to see the implementation
    - web application is available at http://localhost
    - add feedbacks and refresh the page to see the saved data
    - rest api is available at http://localhost:8080/api/v1/feedback
    - MinIO is available at http://127.0.0.1:9000/minio/
        - Access key: `minio`
        - Secret key: `minio123`

### Demo
![](https://github.com/evantha/h2o_assignment/blob/main/img/Assignment.gif)
