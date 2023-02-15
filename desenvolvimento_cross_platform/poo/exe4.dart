class ContaBancaria {
  double saldo;
  int numero;

  ContaBancaria(this.saldo, this.numero);

  void depositar(double valor) {
    this.saldo += valor;
  }
}

main() {
  ContaBancaria conta1 = ContaBancaria(1000, 1234);
  conta1.depositar(500);
  print(conta1.saldo);
}