import 'dart:math';

class Personagem {
  String nome;
  double vida;
  int forca;

  Personagem(this.nome, this.vida, this.forca);

  void atacar(Personagem alvo) {
    Random r = Random();
    double danoCausado = this.forca * (r.nextDouble() + 0.5);
    alvo.vida -= double.parse(danoCausado.toStringAsPrecision(2));
  }

  bool verificarVida() {
    return vida > 0;
  }
}

class Heroi extends Personagem {
  Heroi(String nome, double vida, int forca): super(nome, vida, forca);

  void curar(int pontos) {
    this.vida += pontos;
  }
}

class Vilao extends Personagem {
  Vilao(String nome, double vida, int forca): super(nome, vida, forca);

  void roubarVida(Personagem alvo) {
    this.vida += alvo.vida / 2;
    alvo.vida -= alvo.vida / 2;
  }
}

void imprimeSeEstaVivo(Personagem p) {
  print('O ${p.nome} está ${p.verificarVida() ? 'vivo' : 'morto'} com ${p.vida} pontos');
}

void narrarAtaque(Personagem p, Personagem alvo) {
  print('${p.nome} irá atacar ${alvo.nome}');
  p.atacar(alvo);
  imprimeSeEstaVivo(p);
  imprimeSeEstaVivo(alvo);
}

void narrarRouboDeVida(Vilao v, Personagem alvo) {
  print('${v.nome} irá roubar a vida de ${alvo.nome}');
  v.roubarVida(alvo);
  imprimeSeEstaVivo(v);
  imprimeSeEstaVivo(alvo);
}

void narrarCura(Heroi h, int pontos) {
  print('${h.nome} irá se curar em $pontos pontos');
  h.curar(pontos);
  imprimeSeEstaVivo(h);
}

main() {
  Heroi h = Heroi("Herói", 100, 10);
  Vilao v = Vilao("Vilão", 100, 10);

  imprimeSeEstaVivo(h);
  imprimeSeEstaVivo(v);

  narrarAtaque(h, v);

  narrarRouboDeVida(v, h);

  narrarCura(h, 50);

  narrarAtaque(v, h);

  narrarRouboDeVida(v, h);
  narrarRouboDeVida(v, h);
  narrarRouboDeVida(v, h);
  narrarAtaque(v, h);
}