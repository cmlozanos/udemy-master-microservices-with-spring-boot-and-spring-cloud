#RESTful Web Services

#Social Media Application

## Rest Paths
User -> Posts

- Retrieve all Users	- GET 		/users
- Create a User			- POST 		/users
- Retrieve a User		- GET 		/users/{id} -> /users/1
- Delete a User			- DELETE	/users/{id} -> /users/1

- Retrieve all posts for a User 	- GET	/users/{id}/posts
- Create a posts for a User			- POST	/users/{id}/posts
- Retrieve details of a post		- GET	/users/{id}/posts/{post_id}


## Table
[USER]
* id integer not null,
* birth_date date,
* name varchar(255),
* primary_key(id)
 