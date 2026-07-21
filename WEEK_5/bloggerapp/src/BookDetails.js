import React from "react";

function BookDetails() {

  const books = [
    {
      id: 1,
      title: "React Basics",
      author: "John"
    },
    {
      id: 2,
      title: "Java Programming",
      author: "James"
    },
    {
      id: 3,
      title: "Spring Boot",
      author: "David"
    }
  ];

  return (

    <div>

      <h2>Book Details</h2>

      <ul>

        {
          books.map(book => (

            <li key={book.id}>
              {book.title} - {book.author}
            </li>

          ))
        }

      </ul>

    </div>

  );

}

export default BookDetails;