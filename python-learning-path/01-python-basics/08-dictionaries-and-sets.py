"""
Dictionaries and Sets Demo
Covers key-value mappings and unique collections.
"""

def main():
    # 1. Dictionaries (Mutable hash maps)
    user = {
        "id": 1,
        "name": "ahbab",
        "email": "ahbab@example.com",
        "roles": ["Admin", "Student"]
    }
    
    # Accessing and modifying
    print(f"User Name: {user['name']}")
    user["status"] = "Active"
    print(f"User Keys: {list(user.keys())}")
    
    # Safe access using get()
    print(f"Safe access (missing key): {user.get('phone', 'N/A')}")
    
    # 2. Iterating over Dictionaries
    print("Dictionary items:")
    for key, value in user.items():
        print(f"  {key}: {value}")
        
    # 3. Sets (Unordered unique items)
    ids = {101, 102, 103, 101, 104} # Duplicate 101 will be removed
    print(f"Unique IDs: {ids}")
    
    # 4. Set Operations
    set_a = {1, 2, 3, 4}
    set_b = {3, 4, 5, 6}
    
    print(f"Union (A | B): {set_a | set_b}")
    print(f"Intersection (A & B): {set_a & set_b}")
    print(f"Difference (A - B): {set_a - set_b}")

if __name__ == "__main__":
    main()
