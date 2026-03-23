"""
Encapsulation Demo
Covers private members (_ and __) and name mangling.
"""

class BankAccount:
    """Demonstrates information hiding in Python."""
    
    def __init__(self, owner: str, balance: float):
        self.owner = owner
        # Python uses underscores for 'private' members by convention.
        self._internal_id = "REF-123"      # Protected (_): "Please don't touch"
        self.__balance = balance            # Private (__): "Hard to access from outside"
        
    # Public method (Getter equivalent)
    def get_balance(self) -> float:
        return self.__balance
        
    # Public method to modify state safely
    def deposit(self, amount: float):
        if amount > 0:
            self.__balance += amount
            print(f"Deposited ${amount}. New balance: ${self.__balance}")
            
    def withdraw(self, amount: float):
        if 0 < amount <= self.__balance:
            self.__balance -= amount
            print(f"Withdrew ${amount}. Remaining: ${self.__balance}")
        else:
            print("Insufficient funds or invalid amount.")

def main():
    account = BankAccount("ahbab", 1000.0)
    
    print(f"Account Owner: {account.owner}")
    print(f"Current Balance: ${account.get_balance()}")
    
    # 1. Accessing 'Protected' members (Possible, but discouraged)
    print(f"Internal ID (protected): {account._internal_id}")
    
    # 2. Accessing 'Private' members (Fails directly)
    try:
        print(account.__balance)
    except AttributeError:
        print("Caught error: Cannot access '__balance' directly due to name mangling.")
        
    # 3. How name mangling works: _ClassName__attributeName
    print(f"Accessing private via mangled name: {account._BankAccount__balance}")

if __name__ == "__main__":
    main()
