import 'package:flutter/material.dart';
import 'package:foodflow/components/historic_item.dart';
import 'package:foodflow/components/search_bar.dart';
import 'package:foodflow/mocks/coffee.dart';

class HistoricPage extends StatelessWidget {
  const HistoricPage({super.key});
  final List items = cafes;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(16.0, 16.0, 16.0, 0.0),
      child: CustomScrollView(
        slivers: <Widget>[
          SliverToBoxAdapter(
            child: Padding(
              padding: const EdgeInsets.only(bottom: 16.0),
              child: CustomSearchBar(
                onChanged: (search) => debugPrint('search'),
                onPressed: () {},
              ),
            ),
          ),
          SliverGrid(
              delegate: SliverChildBuilderDelegate((context, index) {
                return HistoricItem(
                    imageURI: items[index]['image'],
                    itemId: items[index]['id'],
                    itemStatus: items[index]['status']);
              }, childCount: items.length),
              gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 2,
                crossAxisSpacing: 8,
                mainAxisSpacing: 8,
                childAspectRatio: 158 / 194,
              ))
        ],
      ),
    );
  }
}
