import 'package:flutter/material.dart';
import 'package:foodflow/components/highlight_item.dart';
import 'package:foodflow/mocks/coffee.dart';

class HighlightsHome extends StatelessWidget {
  const HighlightsHome({super.key});

  final List items = cafes;
  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: const EdgeInsets.fromLTRB(16.0, 16.0, 16.0, 0),
        child: CustomScrollView(
          slivers: <Widget>[
            const SliverToBoxAdapter(
                child: Padding(
              padding: EdgeInsets.only(bottom: 16.0),
              child: Text(
                "Início",
                style: TextStyle(fontFamily: "Poppins", fontSize: 20),
                textAlign: TextAlign.center,
              ),
            )),
            SliverList(
                delegate: SliverChildBuilderDelegate((context, index) {
              return HighlightItem(
                  imageURI: items[index]['image'],
                  itemTypeOfCultivation: items[index]['typeOfCultivation'],
                  itemStatus: items[index]['status'],
                  itemDescription: items[index]['description']);
            }, childCount: items.length))
          ],
        ));
  }
}
