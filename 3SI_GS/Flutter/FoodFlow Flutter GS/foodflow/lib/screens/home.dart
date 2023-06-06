import 'package:flutter/material.dart';
import 'package:foodflow/components/main_drawer.dart';
import 'package:foodflow/screens/highlights_home.dart';
import 'package:foodflow/screens/historic_page.dart';
import 'package:foodflow/screens/visualization_page.dart';
import 'package:foodflow/themes/app_colors.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int _currentPage = 0;
  @override
  Widget build(BuildContext context) {
    final List<Widget> pages = [
      const HighlightsHome(),
      const VisualizationPage(),
      const HistoricPage()
    ];
    return Scaffold(
      appBar: AppBar(
        title: const Text("FoodFlow",
            style: TextStyle(
                color: Color(0xFF0E4F24),
                fontFamily: "Poppins",
                fontWeight: FontWeight.w800)),
        backgroundColor: Theme.of(context).colorScheme.surfaceVariant,
        actions: const <Widget>[
          Padding(
            padding: EdgeInsets.symmetric(horizontal: 16.0),
            child: Icon(
              Icons.account_circle,
              size: 32,
            ),
          )
        ],
        centerTitle: true,
      ),
      drawer: const MainDrawer(),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Início',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.auto_awesome_mosaic),
            label: 'Visualização',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.article),
            label: 'Histórico',
          ),
        ],
        selectedItemColor: AppColors.bottomNavigationBarIconColor,
        currentIndex: _currentPage,
        onTap: (index) {
          setState(() {
            _currentPage = index;
          });
        },
      ),
      body: pages.elementAt(_currentPage),
    );
  }
}
