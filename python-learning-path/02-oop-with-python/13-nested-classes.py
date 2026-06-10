"""
Nested Classes Demo
Covers classes defined inside other classes.
"""

class Computer:
    def __init__(self, brand: str, cpu_name: str):
        self.brand = brand
        # 1. Nesting an instance of an inner class
        self.cpu = self.CPU(cpu_name)
        
    def show_specs(self):
        print(f"Computer: {self.brand}")
        self.cpu.display()
        
    # 2. Defining a Nested Class (Inner Class)
    # often used when a class is only relevant to its outer class.
    class CPU:
        def __init__(self, name: str):
            self.name = name
            self.cores = 8
            
        def display(self):
            print(f"  CPU: {self.name} ({self.cores} cores)")

def main():
    my_comp = Computer("Apple", "M2 Ultra")
    my_comp.show_specs()
    
    # 3. Accessing inner class directly (rarely done)
    # inner_obj = Computer.CPU("Intel i9")
    # inner_obj.display()

if __name__ == "__main__":
    main()
