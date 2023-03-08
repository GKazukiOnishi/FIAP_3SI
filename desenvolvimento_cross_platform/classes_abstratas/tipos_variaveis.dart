void main() {
  //const String name;
  //name = "Kazuki"; não pode porque precisa ser definida na declaração quando é const
  //const String name = "Kazuki";
  final String name;
  name =
      "Kazuki"; //valor pode ser atribuído depois, mas não pode mudar mais depois

  Viajar viajar = Viajar(tipoDeTransporte: Transporte.helicoptero);

  print(viajar.visitas);
  print(viajar.tipoDeTransporte);
  print(viajar
      ._viagens); //está no mesmo arquivo então é acessável, private no dart é no sentido de biblioteca

  print(viajar.numeroDeViagens);
  viajar.alterarViagens = 12; //usamos o set alterando diretamente
  print(viajar.numeroDeViagens); //usamos o get acessando diretamente

  viajar.visitarLugar();
  viajar.viajei();
}

class Viajar {
  Transporte tipoDeTransporte;
  int visitas = 0;
  int _viagens = 0; //underline diz que a variável é privada

  Viajar({required this.tipoDeTransporte});

  void visitarLugar() {
    visitas++;
    _viagens++;
    print("Você fez um total de $_viagens viagens");
  }

  //vantagens de usar get/set ao invés de deixar público é vc poder centralizar comportamente, get só do jeito definido, set só
  //nas regras definidas
  int get numeroDeViagens {
    return _viagens;
  }

  void set alterarViagens(int novoValor) {
    if (novoValor > 10) {
      print("Viajando muito hein");
    }
    _viagens = novoValor;
  }

  void viajei() {
    switch (tipoDeTransporte) {
      case Transporte.aviao:
        print("Você viajou de avisão, que dahora");
        break;
      case Transporte.bicicleta:
        print("Você está disposto hein, ta com coragem");
        break;
      case Transporte.carro:
        print("Você viajou de carro, tá caro a gasolina rapaz");
        break;
      case Transporte.helicoptero:
        print("Que rico, voando de Helicoptero");
        break;
      case Transporte.moto:
        print("Você viajou de moto, que aventura");
        break;
      case Transporte.onibus:
        print("Você viajou de ônibus, tá economizando hein");
        break;
      case Transporte.patins:
        print("Você viajou de patins... caramba");
        break;
      case Transporte.skate:
        print("Você viajou de skate, que maneiro");
        break;
      default:
        print("Veículo não identificado");
    }
  }
}

enum Transporte {
  carro,
  bicicleta,
  onibus,
  aviao,
  helicoptero,
  patins,
  skate,
  moto
}

//comando flutter doctor -> mostra se ambiente está ok
//comando flutter create nomeProjeto -> cria projeto