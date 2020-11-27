fruits = {
    "apple": 50,
    "orange": 60,
    "kiwi":35,
    "grapes":70
}
print(fruits)
fruit_check = input("Enter fruit: ").lower()
if(fruit_check in fruits):
    print("yes")
else:
    print("no")


