"""
Dates and Time Demo
Covers the datetime module and common operations.
"""

from datetime import datetime, date, timedelta

def main():
    # 1. Current Date and Time
    now = datetime.now()
    print(f"Current Timestamp: {now}")
    print(f"Current Date: {now.date()}")
    print(f"Current Time: {now.time()}")
    
    # 2. Formatting (strftime)
    print(f"Formatted: {now.strftime('%A, %d %B %Y %I:%M %p')}")
    
    # 3. Parsing (strptime)
    date_str = "2026-03-25"
    parsed_date = datetime.strptime(date_str, "%Y-%m-%d")
    print(f"Parsed Date: {parsed_date}")
    
    # 4. Date Arithmetic (timedelta)
    tomorrow = now + timedelta(days=1)
    past = now - timedelta(days=7)
    
    print(f"Tomorrow: {tomorrow}")
    print(f"One week ago: {past}")
    
    # 5. Comparing dates
    is_future = tomorrow > now
    print(f"Is tomorrow in future? {is_future}")

if __name__ == "__main__":
    main()
