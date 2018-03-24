public class Pokedex extends AbstractPokemon {
    // your code here

    public String pokemonInfo(Pokemon pokemon){
    	return ("Name: "+pokemon.getName() + " Health "+pokemon.getHealth() + " Type: "+ pokemon.getType());
    }
}
