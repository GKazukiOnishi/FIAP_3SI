void main() {
  User usuario = User(email: "k@k.com",nome: "Ka",idade: 10);
  print(usuario.somarIdade());
}

class User extends People {
  String? email;
  int idade;
  User({this.email, nome, altura, required this.idade}) : super(nome);

  int somarIdade() {
    return ++idade; 
  }
}

class People {
  String? nome;
  double? altura;

  People(this.nome, { this.altura });
}