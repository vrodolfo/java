public interface PokemonInterface {
    // your code here
    Pokemon createPokemon(int health, String name, String type);
    void attackPokemon(Pokemon pokemon);
    String pokemonInfo(Pokemon pokemon);
}
