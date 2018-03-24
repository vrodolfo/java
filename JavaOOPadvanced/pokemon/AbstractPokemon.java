public abstract class AbstractPokemon implements PokemonInterface {
    // your code here

    public Pokemon createPokemon(int health, String name, String type){
    	Pokemon pokemon = new Pokemon(health, name, type);
    	return pokemon;

    }
    public void attackPokemon(Pokemon pokemon){
    	pokemon.setHealth(pokemon.getHealth()-5); 

    }
}

