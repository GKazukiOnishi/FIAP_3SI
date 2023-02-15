class Retangulo {
    double largura;
    double altura;

    Retangulo(this.largura, this.altura);

    double calcularArea() {
        return largura * altura;
    }
}

main() {
    Retangulo retangulo1 = Retangulo(5, 10);
    print(retangulo1.calcularArea());
}