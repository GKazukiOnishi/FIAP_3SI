//Parâmetros nomeados opcionais
void login(String email, int senha, {String? apelido}) { //nullsafety, por padrão não deixa entrar null, só se for opcional
    print("Seu email é $email e apelido é $apelido");
}
	
void main() {
    login("k@k.com", 123, apelido: "kaka");
    login(apelido: "kaka", "k@k.com", 123);
    login("k@k.com", 123);
}
