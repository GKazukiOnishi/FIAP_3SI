import 'package:flutter/material.dart';
import 'package:foodflow/components/visualization_item.dart';
import 'package:foodflow/mocks/coffee.dart';

class VisualizationPage extends StatelessWidget {
  const VisualizationPage({super.key});

  final List items = cafes;
  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16.0, 16.0, 16.0, 16.0),
      child: CustomScrollView(
        slivers: <Widget>[
          const SliverToBoxAdapter(
            child: Text(
              "Visualização",
              textAlign: TextAlign.center,
              style: TextStyle(fontFamily: "Poppins", fontSize: 20),
            ),
          ),
          SliverList(
              delegate: SliverChildBuilderDelegate((context, index) {
            return VisualizationItem(
                itemId: items[index]['id'],
                itemTypeOfCultivation: items[index]['typeOfCultivation'],
                imageURI: items[index]['image']);
          }, childCount: items.length))
        ],
      ),
    );
  }
}
