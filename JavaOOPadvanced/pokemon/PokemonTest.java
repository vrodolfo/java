public class PokemonTest{
	public static void main(String[] args){

		Pokedex pokedex = new Pokedex();
		Pokemon pokemon;
		pokemon = pokedex.createPokemon(100, "Rodolfo", "Super");
		System.out.println(pokedex.pokemonInfo(pokemon));
		pokedex.attackPokemon(pokemon);
		System.out.println(pokedex.pokemonInfo(pokemon));

		Pokemon pokemon2;
		pokemon2 = pokedex.createPokemon(200, "Emma", "SuperSuper");
		System.out.println(pokedex.pokemonInfo(pokemon2));

		System.out.println("Total Pokemon created: "+pokemon2.getCount());


	}
}