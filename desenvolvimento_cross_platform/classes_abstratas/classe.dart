void main() {
  User usuario = User("k@k.com", "Ka", 10);
  print(usuario.somarIdade());
  print(usuario.metodoComRetornoDinamico(0));
  print(usuario.metodoComRetornoDinamico(1));
}

class User {
  String nome;
  String email;
  int idade;

  User(this.email, this.nome, this.idade);

  int somarIdade() { //boa prática determinar o tipo do retorno
    return ++idade;
  }

  dynamic metodoComRetornoDinamico(int p) {
    if (p == 0) {
      return "a";
    } else {
      return 2;
    }
  }
}