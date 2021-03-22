# Contact-book

```text
Legend:
✅ - Done
❌ - Not done
```

### Progress table

| Feature  | Implemented  | Tested  | Comments |
|---|:---:|:---:|---|
| Contact has full name  | ✅  | ✅  | |
| Contact has date of birth  |  ✅ | ✅  | |
| Contact has address as an object  | ✅  |  ✅ | |
| Address has generic field city | ~  |  ~ | Kind a implemented as String not sure if it desired outcome can implement this with json or interfaces as another table |
| Address has generic field postcode | ~  |  ~ | Kind a implemented as String not sure if it desired outcome can implement this with json or interfaces as another table |
| Filter contacts by postcode  | ✅  |  ✅ | |
| Create a new contact with POST(+address)  | ✅  |  ✅ | |
| Everything is persisted in in-memory database  | ✅  |  ✅ | Used in-memory H2 for simplicity with auto create of tables on startup|
| Every entity in database have autogenerate on id field  | ✅  |  ✅ | |
| Log message when add new contact into system  | ✅  | ❌ | Hard to test logging so will leave for now |
| Project on github  | ✅  |  ✅ | https://github.com/frikit/contact-book |
| Write tests  | ✅  |  ✅ | Write tests for what is important for now didn't write any for controller level |
| Describe API in README  | ✅  |  ✅ | Next chapter |

### API endpoints

| Method | URL | Description | Comments |
|:---:|---|---|---|
| GET | /contacts | return all contacts in the system | no params, no body, could add pagination with required
| GET | /contacts?postcode={postcode} | return all contacts in the system which match this postcode | no body, could add pagination with required
| POST | /add/contact | return status code 200,500... | require to pass a body like: (Look at Extras 1.1)

### How to run project

NOTE: Server by default is running on 8080 and tests are running on 8081

#### Run from terminal with gradle

```shell
./gradlew bootRun
```

#### Run from terminal in docker image

```shell
./gradlew bootBuildImage --imageName=contact-book && docker run -p 8080:8080 -t contact-book
```

## Extras

### 1.1 Contact with address payload

```json
{
  "fullName": "Victor O2",
  "dateOfBirth": "2019-01-19",
  "address": {
    "city": "Kiv99",
    "postcode": "No postcode33"
  }
}
```
