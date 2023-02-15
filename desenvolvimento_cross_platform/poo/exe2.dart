class Cachorro {
    String nome;
    int idade;

    Cachorro(this.nome, this.idade);

    void latir() {
        print("au au!");
    }
}

main() {
    Cachorro cachorro1 = Cachorro("Rex", 2);
    cachorro1.latir();
}