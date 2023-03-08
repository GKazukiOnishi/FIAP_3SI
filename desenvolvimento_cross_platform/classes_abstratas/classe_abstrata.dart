//geralmente criamos classes abstratas para implementar os métodos delas
//equivalente a interfaces em outras linguagens
abstract class BD {
  void cadastro();
  void consulta();
  void edit();
  void excluir();
}

class User implements BD {
  static String? nome; //pertence à classe

  String name;
  int idade;

  //classe pode ter mais de um construtor
  User({required this.name, required this.idade});

  //construtor from Json
  User.fromJson(
      Map<String, dynamic> map) //converte o map em variáveis de instância
      : name = map["name"],
        idade = map["idade"];

  @override
  void cadastro() {
    print("cadastro");
  }

  @override
  void consulta() {}
  @override
  void edit() {}
  @override
  void excluir() {}
}

void main() {
  User user = User(name: "Kazuki", idade: 12);
  User.nome = "Nome estático da classe User";
  user.cadastro();
  print(User.nome);

  Map<String, dynamic> map = {};
  map["name"] = "Kazuki";
  map["idade"] = 21;
  print(map);
  User usuarioFromJson = User.fromJson(map);
  User usuarioFromJson1 = User.fromJson({"name": "Kazuki", "idade": 21});

  print(usuarioFromJson.name);
  print(usuarioFromJson1.name);
}
