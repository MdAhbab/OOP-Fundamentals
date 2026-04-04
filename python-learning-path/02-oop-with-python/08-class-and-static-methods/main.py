"""
Class and Static Methods Demo
Covers @classmethod and @staticmethod decorators.
"""

class Employee:
    company_name = "Pythonic Corp"
    num_employees = 0
    
    def __init__(self, name: str, salary: float):
        self.name = name
        self.salary = salary
        Employee.num_employees += 1
        
    # 1. Instance Method (Takes 'self')
    def get_details(self):
        return f"{self.name} works at {self.company_name}"
        
    # 2. Class Method (Takes 'cls')
    # Often used as factory methods or to modify class state.
    @classmethod
    def change_company_name(cls, new_name: str):
        cls.company_name = new_name
        
    @classmethod
    def from_string(cls, emp_str: str):
        """Alternative constructor (Factory Method)."""
        name, salary = emp_str.split("-")
        return cls(name, float(salary))
        
    # 3. Static Method (Takes no implicit first argument)
    # used for utility functions that don't need class or instance state.
    @staticmethod
    def is_workday(day: int) -> bool:
        """Simple utility: 0-4 are workdays (Mon-Fri)."""
        return 0 <= day <= 4

def main():
    e1 = Employee("Alice", 50000)
    e2 = Employee.from_string("Bob-60000")
    
    print(f"Employee 1: {e1.get_details()}")
    print(f"Employee 2: {e2.get_details()}")
    
    # Using Class Method
    Employee.change_company_name("PyWorld")
    print(f"New company name: {e1.company_name}")
    
    # Using Static Method
    print(f"Is today (Mon) a workday? {Employee.is_workday(0)}")
    print(f"Total employees: {Employee.num_employees}")

if __name__ == "__main__":
    main()
