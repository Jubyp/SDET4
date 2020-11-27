User1 = input("Input User1: ")
User2 = input("Input User2: ")

User1selection = input(User1 + ", Do you want to choose rock, scissors or paper? ").lower()
User2selection = input(User2 + ", Do you want to choose rock, scissors or paper? ").lower()

if User1selection == User2selection:
    print("Tie")

elif User1selection == "rock":
    if User2selection == "scissors":
        print("Rock won")
    else:
        print("Paper won")
elif User1selection == "scissors":
    if User2selection == "paper":
        print("scissors won")
    else:
        print("Rock won")
elif User1selection == "paper":
    if User2selection == "rock":
        print("Paper won")
    else:
        print("scissors won")
else:
    print("Invalid input , enter again :")




