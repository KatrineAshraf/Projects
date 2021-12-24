import tkinter as tk
from tkinter import *
from tkinter import messagebox
window = tk.Tk()
window.title("XO Gameplay")
window.iconbitmap("566294.ico")

count =0
turn = True

def compMove(): 
  global count  
  for i in ['O','X']:
      for x in [b1,b2,b3,b4,b5,b6,b7,b8,b9]:
         if x["text"]==" ": 
           x["text"] = i
           if check(i):
            x["text"] = "O"   
            count +=1
            return 1
           else:
              x["text"] = " "  
  if b5["text"] == " ":
      b5["text"] = "O"
      count+=1
      return 1      
      
           

  for  x in  [b1,b3,b9,b7]:
      if x["text"]==" ":
          count +=1
          x["text"] = "O"
          return 1

  for  x in [b2,b4,b8,b6]:
      if x["text"]==" ":
          count +=1
          x["text"] = "O"
          return 1   

  if b5["text"] == " ":
      b5["text"] = "O"
      count+=1
      return 1               

  return 0

def check(le):
    return (b7["text"] == le and b8["text"] == le and b9["text"] == le) or (b4["text"] == le and b5["text"] == le and b6["text"] == le) or (b1["text"] == le and b2["text"] == le and b3["text"] == le) or (b1["text"] == le and b4["text"] == le and b7["text"] == le) or (b2["text"] == le and b5["text"] == le and b8["text"] == le) or (b3["text"] == le and b6["text"] == le and b9["text"] == le) or (b1["text"] == le and b5["text"] == le and b9["text"] == le) or (b3["text"] == le and b5["text"] == le and b7["text"] == le)

def replay():
    global count
    count = 0
    for x in [b1,b2,b3,b4,b5,b6,b7,b8,b9]:
         x["text"]= " " 
    

def isWinner(le): 
    if (b7["text"] == le and b8["text"] == le and b9["text"] == le):
        b7.config(bg="black")
        b8.config(bg="black")
        b9.config(bg="black")
        return True
    elif (b4["text"] == le and b5["text"] == le and b6["text"] == le):
        b4.config(bg="black")
        b6.config(bg="black")
        b5.config(bg="black")
        return True
    elif (b1["text"] == le and b2["text"] == le and b3["text"] == le):
        b1.config(bg="black")
        b2.config(bg="black")
        b3.config(bg="black")
        return True
    elif (b1["text"] == le and b4["text"] == le and b7["text"] == le) :
        b1.config(bg="black")
        b4.config(bg="black")
        b7.config(bg="black")
        return True
    elif (b2["text"] == le and b5["text"] == le and b8["text"] == le) :
        b5.config(bg="black")
        b2.config(bg="black")
        b8.config(bg="black")
        return True
    elif (b3["text"] == le and b6["text"] == le and b9["text"] == le) :
        b6.config(bg="black")
        b9.config(bg="black")
        b3.config(bg="black") 
        return True
    elif (b1["text"] == le and b5["text"] == le and b9["text"] == le):
        b1.config(bg="black")
        b5.config(bg="black")
        b9.config(bg="black") 
        return True
    elif (b3["text"] == le and b5["text"] == le and b7["text"] == le):
        b5.config(bg="black")
        b7.config(bg="black")
        b3.config(bg="black") 
        return True
    else:
        return False
        

def clicked(b):
    global count
    turn = True
    while turn:
        if b["text"] == " " and not check("X") and not check("O") and count <9:
            b["text"] = "X"
            count += 1
            if isWinner("X"):
                messagebox.showinfo("XO Gameplay", "X's won this time!")   
            elif count == 9:
                messagebox.showinfo("XO Gameplay","It's a tie game!")    
            
            elif isWinner("O"):
                messagebox.showinfo("XO Gameplay", "O's won this time!")
            else:    
                compMove()    
            turn = False
        elif count == 9 or ( check("X") or check("O")):
            messagebox.showerror("XO Gameplay", "The game has ended! Please re-play the game")    
            turn = False
        else:        
            messagebox.showerror("XO Gameplay", "This spot is already taken\nplease, choose another") 
            turn = False       

b1 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b1))
b2 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b2))
b3 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b3))
b4 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b4))
b5 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b5))
b6 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b6))
b7 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b7))
b8 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b8))
b9 = Button(window, text=" ",width=8, height=4, font="sans-serif", bg= "black", fg="white", command= lambda: clicked(b9))
retry = Button(window, text="Re-Match", width=8,height=1, font="times", bg= "cyan",fg="black", command= lambda: replay())
quit = Button(window, text="Quit", width=8,height=1, font="times", bg= "red",fg="black", command= window.destroy)


b1.grid(row =1, column =1)
b2.grid(row =1, column =2)
b3.grid(row =1, column =3)

b4.grid(row =2, column =1)
b5.grid(row =2, column =2)
b6.grid(row =2, column =3)

b7.grid(row =3, column =1)
b8.grid(row =3, column =2)
b9.grid(row =3, column =3)

retry.grid(row=4, column=2)
quit.grid(row=5, column = 2)
window.mainloop()