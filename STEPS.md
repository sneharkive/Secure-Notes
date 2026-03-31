- Add Spring Security =>  Every end point becomes authenticated (form based by defaults) 

- Default password is keep changing during re-run

- Configure Static Username and Password in application.properties
 
- Additional Note => InMemoryUserDetailsManager -> this comes to rescue if you are using username password auth without storing it to the database
Non-persistent implementation of InMemoryUserDetailsManager which is backed by an in-memory map.


# Implement Basic Authentication

- Basic Authentication is one of the simplest form of authentication supported by Spring Security.

- It involves sending the username and password with each HTTP request in the Authorization header.

- The credentials are encoded using Base64 and sent over the network. Spring Security then decodes and validates these credentials.



| HTTP Method | Endpoint              | Description                          | Request Body   | Request Parameter                                      | Response                     |
|------------|-----------------------|--------------------------------------|----------------|--------------------------------------------------------|------------------------------|
| POST       | /api/notes            | Create a new note                    | String content | @AuthenticationPrincipal UserDetails userDetails       | Note (created note)          |
| GET        | /api/notes            | Retrieve all notes for the logged-in user | None           | @AuthenticationPrincipal UserDetails userDetails       | List<Note> (user's notes)    |
| PUT        | /api/notes/{noteId}   | Update an existing note              | String content | @AuthenticationPrincipal UserDetails userDetails       | Note (updated note)          |
| DELETE     | /api/notes/{noteId}   | Delete a note                        | None           | @AuthenticationPrincipal UserDetails userDetails       | void                         |