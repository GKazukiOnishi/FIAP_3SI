//Parâmetros com valor default
void main() {
	login("k@k.com", apelido: "Kaka");
    login("k@k.com");
}

void login(String email, {String apelido = "kah"}) {
	print("Seu email é $email e apelido $apelido");
}