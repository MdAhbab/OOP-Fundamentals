"""
Dunder Methods Demo
Covers magic methods (__str__, __repr__, __eq__, __len__, etc.).
"""

class Book:
    def __init__(self, title: str, author: str, pages: int):
        self.title = title
        self.author = author
        self.pages = pages
        
    # 1. String Representation (Human-readable)
    def __str__(self):
        return f"'{self.title}' by {self.author}"
        
    # 2. Developer Representation (Official representation)
    def __repr__(self):
        return f"Book(title='{self.title}', author='{self.author}', pages={self.pages})"
        
    # 3. Equality Comparison (__eq__)
    def __eq__(self, other):
        if not isinstance(other, Book):
            return False
        return self.title == other.title and self.author == other.author
        
    # 4. Length (__len__)
    def __len__(self):
        return self.pages

def main():
    book1 = Book("Python 101", "Guido", 300)
    book2 = Book("Python 101", "Guido", 300)
    book3 = Book("Advanced Python", "Raymond", 500)
    
    # Calls __str__
    print(f"Print book1: {book1}")
    
    # Calls __repr__
    print(f"Repr book1: {repr(book1)}")
    
    # Calls __eq__
    print(f"book1 == book2: {book1 == book2}")
    print(f"book1 == book3: {book1 == book3}")
    
    # Calls __len__
    print(f"Total pages: {len(book1)}")

if __name__ == "__main__":
    main()
