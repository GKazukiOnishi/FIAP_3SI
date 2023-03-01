//Parâmetros nomeados obrigatórios
void main() {
    login("k@k.com", apelido: "Kaka");
    login1(apelido: "Teste", email: "teste@teste");
}

void login(String email, {required String apelido}) {
	print("Seu email é $email e apelido $apelido");
}

void login1({required String email, required String apelido}) {
	print("Seu email é $email e apelido $apelido");
}