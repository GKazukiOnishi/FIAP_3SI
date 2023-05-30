import 'package:flutter/material.dart';
import 'package:foodflow/constants/theme.dart';
import 'package:foodflow/screens/home.dart';

void main() {
  runApp(const FoodFlow());
}

class FoodFlow extends StatelessWidget {
  const FoodFlow({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Food Flow',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(colorSchemeSeed: Colors.purple, useMaterial3: true),
      darkTheme: themeDark,
      home: const Home(),
    );
  }
}
