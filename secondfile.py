import random
import time

def animate_winner(player):
    print("\n" * 100)
    for i in range(10):
        print(" " * i + f"{player} wins!")
        time.sleep(0.1)

def draw_dice(number):
    if number == 1:
        print(" _______ ")
        print("|       |")
        print("|   *   |")
        print("|_______|")
    elif number == 2:
        print(" _______ ")
        print("| *     |")
        print("|       |")
        print("|_____*_|")
    elif number == 3:
        print(" _______ ")
        print("| *     |")
        print("|   *   |")
        print("|_____*_|")
    elif number == 4:
        print(" _______ ")
        print("| *   * |")
        print("|       |")
        print("| *___*_|")
    elif number == 5:
        print(" _______ ")
        print("| *   * |")
        print("|   *   |")
        print("| *___*_|")
    elif number == 6:
        print(" _______ ")
        print("| *   * |")
        print("| *   * |")
        print("| *___*_|")

print("Welcome to the dice rolling game!")

while True:
    player1_total = 0
    player2_total = 0

    for i in range(3):
        player1_input = input("Player 1, press enter to roll the dice: ")
        player1_roll = random.randint(1, 6)
        print(f"Player 1 rolled a {player1_roll}!")
        draw_dice(player1_roll)
        player1_total += player1_roll

    for i in range(3):
        player2_input = input("Player 2, press enter to roll the dice: ")
        player2_roll = random.randint(1, 6)
        print(f"Player 2 rolled a {player2_roll}!")
        draw_dice(player2_roll)
        player2_total += player2_roll

    if player1_total > player2_total:
        animate_winner("Player 1")
    elif player2_total > player1_total:
        animate_winner("Player 2")
    else:
        print("It's a tie!")

    play_again = input("Would you like to play again? (y/n) ")
    if play_again.lower() != 'y':
        break

print("Thank you for playing!")

