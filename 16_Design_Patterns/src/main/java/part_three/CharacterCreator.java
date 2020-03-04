package part_three;

import part_three.model.Character;
import part_three.model.Flower;
import part_three.model.PlainCharacter;
import part_three.model.Tall;

public class CharacterCreator{

  public static void main(String[] args){

    Character fancyCharacter = new Tall(new Flower(new PlainCharacter()));
    fancyCharacter.draw();

  }

}