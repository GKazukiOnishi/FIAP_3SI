//stl é atalho para Flutter Stateless Widget
// import 'package:flutter/src/foundation/key.dart';
// import 'package:flutter/src/widgets/framework.dart';

import 'package:flutter/material.dart';
import 'package:font_awesome_flutter/font_awesome_flutter.dart';
import 'package:my_first_project_flutter/user_screen.dart'; //vamos usar do Material

class MyApp extends StatelessWidget {
  const MyApp({Key? key})
      : super(key: key); //o const obriga a instanciar com const

  @override
  Widget build(BuildContext context) {
    //BuildContext é o cara que trata a árvore de widgets
    return MaterialApp(
      debugShowCheckedModeBanner: false, //tirar a marca d água
      home: Builder(builder: (context) {
        return Scaffold(
          appBar: AppBar(
            elevation: 20,
            backgroundColor: Colors.black,
            title: const Text(
              "Meu App",
              style: TextStyle(
                color: Colors.purple,
                fontSize: 30,
                fontWeight: FontWeight.bold,
              ),
            ),
            centerTitle: true,
            actions: [
              // Icon(Icons.person)
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  IconButton(
                    onPressed: () {},
                    icon: const FaIcon(
                      FontAwesomeIcons.home,
                      size: 30,
                    ),
                  ),
                  IconButton(
                    onPressed: () {
                      Navigator.of(context).push(MaterialPageRoute(
                          builder: (context) => const UserScreen()));
                    },
                    icon: const FaIcon(
                      FontAwesomeIcons.user,
                      size: 30,
                    ),
                  ),
                ],
              ),
            ],
          ),
          // *** parte 1
          // body: Container(
          //   width: double.infinity, //largura de 100%, sem isso o CrossAxisAlignment.center não vai fazer o que esperávamos, porque vai centralizar no espaço que não é total
          //   child: Column( //clique direito refator wrapp Container
          //     mainAxisAlignment: MainAxisAlignment.center, //alinhamento da coluna -> vertical
          //     crossAxisAlignment: CrossAxisAlignment.center, //alinhamento transversal da coluna -> horizontal
          //     children: [
          //       Container(
          //         width: 100,
          //         height: 100,
          //         color: Colors.blue,
          //       ),
          //       Container(
          //         width: 100,
          //         height: 100,
          //         color: Colors.green,
          //       ),
          //       Container(
          //         width: 100,
          //         height: 100,
          //         color: Colors.yellow,
          //       ),
          //     ],
          //   ),
          // ),
          // *** parte 2
          // body: Padding( //serve para adicionar espaçamento interno
          //   padding: const EdgeInsets.all(8.0),
          //   child: SizedBox( //Container também cria caixa, mas o SizedBox é bem limitado, não tem cor etc., só altura, largura e filho
          //     height: double.infinity,
          //     child: Row( //clique direito refator remove widget do Container
          //       mainAxisAlignment: MainAxisAlignment.spaceAround, //alinhamento da Linha -> horizontal
          //       crossAxisAlignment: CrossAxisAlignment.center, //alinhamento transversal da linha -> vertical
          //       children: [
          //         Container(
          //           width: 100,
          //           height: 100,
          //           color: Colors.blue,
          //         ),
          //         Container(
          //           width: 100,
          //           height: 100,
          //           color: Colors.green,
          //         ),
          //         Container(
          //           width: 100,
          //           height: 100,
          //           color: Colors.yellow,
          //         ),
          //       ],
          //     ),
          //   ),
          // ),
          body: Center(
            child: Image.network(
              "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/IMG_logo_%282017%29.svg/220px-IMG_logo_%282017%29.svg.png",
              width: 200,
              height: 200,
            ),
            // child: Image.asset("image/IMG.png"),
          ),
        );
      }),
    ); //tem vários parâmetros
    /*
      Tem rotas -> map
      Tem home -> outro Widget
    */
  }
}
