list1 = [2,5,1,8,9,3]
list2= [4,7,2,8,6]
print(list1)
print(list2)

list3 = []

for num in list1:
    if(num % 2 != 0):
        list3.append(num)
for num in list2:
    if(num % 2 == 0):
        list3.append(num)

print("Result is : " , list3)
    