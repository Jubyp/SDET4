def sum(num):
  if num:
    return num + sum(num-1)
  else:
    return 0

total = sum(10)  
print("The sum is: ", + total)


