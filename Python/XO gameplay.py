


b = [' ' for x in range(10)]

def insertLetter(letter, pos):
    b[pos] = letter

def spaceIsFree(pos):
    return b[pos] == ' '

def printBoard1(b):
    print(' 1 | 2 | 3')
    print('-----------')
    print(' 4 | 5 | 6')
    print('-----------')
    print(' 7 | 8 | 9')
    print()

def printBoard(b):
    print(' ' + b[1] + ' | ' + b[2] + ' | ' + b[3])
    print('-----------')
    print(' ' + b[4] + ' | ' + b[5] + ' | ' + b[6])
    print('-----------')
    print(' ' + b[7] + ' | ' + b[8] + ' | ' + b[9])
    print()
    
def isWinner(b, le):
    return (b[7] == le and b[8] == le and b[9] == le) or (b[4] == le and b[5] == le and b[6] == le) or (b[1] == le and b[2] == le and b[3] == le) or(b[1] == le and b[4] == le and b[7] == le) or(b[2] == le and b[5] == le and b[8] == le) or(b[3] == le and b[6] == le and b[9] == le) or(b[1] == le and b[5] == le and b[9] == le) or(b[3] == le and b[5] == le and b[7] == le)

def playerMove(le):
    run = True
    while run:
        move = input('Please select a position to place ' + le +  ' (1-9): ')
        try:
            move = int(move)
            if move > 0 and move < 10:
                if spaceIsFree(move):
                    run = False
                    insertLetter(le, move)
                else:
                    print('Sorry, this space is occupied!')
            else:
                print('Please type a number within the range!')
        except:
            print('Please type a number!')
            

def compMove():
    possibleMoves = [x for x, letter in enumerate(b) if letter == ' ' and x != 0]
    move = 0

    for let in ['O', 'X']:
        for i in possibleMoves:
            boardCopy = b[:]
            boardCopy[i] = let
            if isWinner(boardCopy, let):
                move = i
                return move

    cornersOpen = []
    for i in possibleMoves:
        if i in [1,3,7,9]:
            cornersOpen.append(i)
            
    if len(cornersOpen) > 0:
        move = selectRandom(cornersOpen)
        return move

    if 5 in possibleMoves:
        move = 5
        return move

    edgesOpen = []
    for i in possibleMoves:
        if i in [2,4,6,8]:
            edgesOpen.append(i)
            
    if len(edgesOpen) > 0:
        move = selectRandom(edgesOpen)
        
    return move

def selectRandom(li):
    import random
    ln = len(li)
    r = random.randrange(0,ln)
    return li[r]
    

def isBoardFull(b):
    if b.count(' ') > 1:
        return False
    else:
        return True

def main():
    print('Welcome to Tic Tac Toe!')
    printBoard1(b)
    play = input("for player vs computer press 1\nfor player vs player press 2")
    try:
        if (int(play) == 1): 
             while not(isBoardFull(b)):
                if not(isWinner(b, 'O')):
                   playerMove('X')
                   printBoard(b)
                else:
                   print('Sorry, O\'s won this time!')
                   break
                if not(isWinner(b, 'X')):
                   move = compMove()
                   if move == 0:
                     print('Tie Game!')
                   else:
                     insertLetter('O', move)
                     print('Computer placed an \'O\' in position', move , ':')
                     printBoard(b)
                else:
                    print('X\'s won this time! Good Job!')
                    break
        elif (int(play) == 2) :
         while not(isBoardFull(b)):
                if not(isWinner(b, 'O')):
                   playerMove('X')
                   printBoard(b)
                else:
                   print(' O\' won this time!')
                   break      
                if not(isWinner(b, 'X')):
                   if isBoardFull(b):
                      print('Tie Game!')
                   else:
                       playerMove('O')  
                       printBoard(b)
                else:
                     print('X\'s won this time!')
                     break       
        else:
            print('Please choose either 1 or 2')
    except:
            print('please enter a number!')          
main()
while True:
    print()
    answer = input('Do you want to play again? (Y/N)')
    if answer.lower() == 'y' or answer.lower == 'yes':
        b = [' ' for x in range(10)]
        print('-----------------------------------')
        main()
    else:
        break