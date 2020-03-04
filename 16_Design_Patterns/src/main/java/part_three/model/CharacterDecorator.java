package part_three.model;

abstract class CharacterDecorator implements Character {

  protected Character baseCharacter;

  public CharacterDecorator(Character baseCharacter){
    this.baseCharacter = baseCharacter;
  }

  public void draw(){
    baseCharacter.draw();
  }

}