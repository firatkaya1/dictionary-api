[Turkish ](https://github.com/firatkaya1/dictionary-api/blob/master/README_tr.md)  :point_left:  

## What is this ? 
This is a web service for translating english words to turkish or turkish to english. This web service has been created to use [Dictionary](https://raw.githubusercontent.com/firatkaya1/dictionary)  more comfortably.

## How to install ? 

Copy the project to your computer.
```git
git clone https://github.com/firatkaya1/dictionary-api.git
```
After that open the terminal in  project file.
```
cd dictionary-api
```
Compile java project to .jar file.
```
mvn clean package
```

Then build project with docker.
```
docker build -f Dockerfile -t dictionary-api .
```

Lastly run the docker.
```
docker run -p 8085:8085 dictionary-api
```
Open your browser and send a request to **localhost:8085**. Successfully installed the project to your computer. That's it! :punch:

## How to use ? 
In this step we will see how we can use each REST endpoint with examples. This web service has Swagger API Docs. If you would like to see all endpoints just send a request to **localhost:8085/swagger-ui/index.html**.

Simply this service created for search by word,category,type and create,read,update,delete.You can find the Database in this [address](https://raw.githubusercontent.com/firatkaya1/dictionary) .

There are 5 endpoints totally. These are start with english/  turkish/  category/ type/ translate/

| Endpoint | HTTP Method | Explain |
| ------------- | ------------- |------------- |
| translate/id/{id}  | GET  | Returns matched words with the specified ID number |
| translate/{word} | GET | Returns the Turkish meanings of the English word. |
| translate/ | GET | Returns the Turkish meanings of the English word in pageable format. |
| translate/ | POST | Create new mapping.  |
| english/{id}  | GET  | Returns the English word with the ID number. |
| english/ | POST | Used to add new English word. |
| english/ | PUT | Used to update the existing English word. |
| english/{id}  | DELETE | Used to delete existing English word by id. |
| english/ | GET | Returns all English words in pageable format. |
| turkish/{id}  | GET  | Returns matched word with the specified ID number |
| turkish/ | POST | Used to add new Turkish word. |
| turkish/ | PUT | Used to update the existing Turkish word.  |
| turkish/{id}  | DELETE | Used to delete existing Turkish word by id. |
| turkish/ | GET | Returns all Turkish words in pageable format. |
| category/{id}  | GET  | Returns matched category with the specified ID number. |
| category/ | POST | Used to add new Category. |
| category/ | PUT |  Used to update the existing Category. |
| category/{id}  | DELETE | Used to delete existing Category by id. |
| type/{id}  | GET  | Returns matched type with the specified ID number |
| type/ | POST |  Used to add new type. |
| type/ | PUT |  Used to update the existing type.. |
| type/{id}  | DELETE | Used to delete existing type by id. |


## Examples

### 1- Returns the Turkish meanings of the English word 

If you want to bring the Turkish meanings of an English word you want in pageable format in JSON type, request as below.  As an example, the word **hello** is used.
  
The only thing needed here is the word you want to search. Other values are up to you. Parentheses represent default values.  
**page** = Page number (1),     
**size** = Number of element each page(10),    
**sort** = Sort by XX(id)  
**order** = Ascending or Descending(asc),  
**word** = Represents the searched word.

```
curl -X GET "http://localhost:8085/translate?order=asc&page=1&size=10&sort=id&word=word" -H "accept: */*"
```
Example output : 

```json
{
  "content": [
    {
      "id": 635276,
      "word_en": "hello",
      "word_tr": "merhaba",
      "category": "Common Usage",
      "type": "interjection"
    },
    {
      "id": 635277,
      "word_en": "hello",
      "word_tr": "merhaba",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635278,
      "word_en": "hello",
      "word_tr": "selam",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635279,
      "word_en": "hello",
      "word_tr": "alo",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635280,
      "word_en": "hello",
      "word_tr": "merhabalar",
      "category": "Speaking",
      "type": "noun"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 10,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 5,
  "last": true,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "size": 10,
  "number": 0,
  "numberOfElements": 5,
  "first": true,
  "empty": false
}
```
### 2- Returns the Turkish meanings of the English word 
Here, the same process above is repeated. But the output here will be different from the one above. The output contains only one list structure. It does not offer a paginated format. This method is **not recommended**. If the word you request has hundreds of meanings, your waiting time will be longer.
```
curl -X GET "http://localhost:8085/translate/hello" -H "accept: */*"
```
Example output : 

```json
[
  {
    "id": 635276,
    "word_en": "hello",
    "word_tr": "merhaba",
    "category": "Common Usage",
    "type": "interjection"
  },
  {
    "id": 635277,
    "word_en": "hello",
    "word_tr": "merhaba",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635278,
    "word_en": "hello",
    "word_tr": "selam",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635279,
    "word_en": "hello",
    "word_tr": "alo",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635280,
    "word_en": "hello",
    "word_tr": "merhabalar",
    "category": "Speaking",
    "type": "noun"
  }
]
```

### 3- Fetch by ID values

Under this heading, it is shown to bring English, Turkish words, categories and types according to an ID value.

Just to bring the English word;
```
curl -X GET "http://localhost:8085/english/125365" -H "accept: */*"
```
Example output ;
```
{
  "id": 125365,
  "en_word": "outports"
}
```
Just to bring the Turkish word;
```
curl -X GET "http://localhost:8085/turkish/56324" -H "accept: */*"
```
Example output ;
```
{
  "id": 56324,
  "word": "astronot gibi"
}
```
Just to bring the Category;
```
curl -X GET "http://localhost:8085/category/35" -H "accept: */*"
```
Example output ;
```
{
  "id": 35,
  "name": "Music"
}
```

Just to bring the Type;
```
curl -X GET "http://localhost:8085/type/3" -H "accept: */*"
```
Example output ;
```
{
  "id": 3,
  "name": "adverb"
}
```
You can use the Swagger to examine and test endpoints in more detail. 

Contact me if you encounter any problems.

[me@kayafirat.com](mailto:me@kayafirat.com?subject=[GitHub]%20dictionary-api)






