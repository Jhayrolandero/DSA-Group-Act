import time


def main():
    print("In the mystical realm of Eldoria, where magic flowed like a river, there lived a young wizard named Aeliana.")
    input("Press Enter to continue...")

    print("Aeliana possessed a rare and powerful gift: the ability to control fire with a mere thought.")
    input("Press Enter to continue...")

    print("One day, while exploring the enchanted forest, Aeliana stumbled upon an ancient spellbook.")
    input("Press Enter to continue...")

    print("The spellbook contained a spell of unimaginable power, capable of reshaping reality itself.")
    input("Press Enter to continue...")

    print("Intrigued and brimming with curiosity, Aeliana faced a choice:")
    print("1. Study the spell further.")
    print("2. Leave the spellbook untouched.")

    choice = input("Enter your choice (1 or 2): ")

    if choice == "1":
        cast_spell()
    elif choice == "2":
        print("Aeliana decided not to meddle with the powerful spell and left the spellbook undisturbed.")
        input("Press Enter to end the story...")
    else:
        print("Invalid choice. The story ends here.")


def cast_spell():
    print("Days turned into weeks, and Aeliana delved deep into her studies, fueled by a thirst for knowledge.")
    input("Press Enter to continue...")

    print("Finally, the day came when Aeliana felt ready to cast the spell. She stood in the heart of the forest,")
    print("surrounded by ancient trees and the whispers of nature.")
    input("Press Enter to continue...")

    print("With a deep breath and unwavering focus, Aeliana chanted the incantation and unleashed the magic.")
    time.sleep(2)
    print("A blinding light enveloped her, and for a moment, everything stood still.")
    input("Press Enter to continue...")

    print("When the light faded, Aeliana realized that she had become one with the forest. She could feel the")
    print("pulse of life in every leaf, the heartbeat of the earth beneath her feet, and the whispers of the wind.")
    input("Press Enter to continue...")

    print("Aeliana had achieved a profound connection with nature, a magic beyond her wildest dreams.")
    input("Press Enter to continue...")

    print("From that day forward, she vowed to protect Eldoria's magical balance and use her newfound power for good.")
    input("Press Enter to end the story...")


if __name__ == "__main__":
    main()
