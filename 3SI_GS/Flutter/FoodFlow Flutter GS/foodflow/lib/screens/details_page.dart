import 'package:flutter/material.dart';
import 'package:foodflow/components/details_item.dart';
import 'package:foodflow/mocks/details.dart';

class DetailsPage extends StatelessWidget {
  const DetailsPage({super.key});
  final List items = details;
  @override
  Widget build(BuildContext context) {
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
      body: Padding(
        padding: const EdgeInsets.fromLTRB(16.0, 16.0, 16.0, 16.0),
        child: CustomScrollView(
          slivers: <Widget>[
            const SliverToBoxAdapter(
              child: Text("Detalhes",
                  textAlign: TextAlign.center,
                  style: TextStyle(
                      fontFamily: "Poppins",
                      fontSize: 20,
                      fontWeight: FontWeight.w600)),
            ),
            SliverList(
                delegate: SliverChildBuilderDelegate((context, index) {
              return DetailsItem(
                  imageURI: items[index]['image'],
                  itemId: items[index]['id'],
                  itemStatus: items[index]['status'],
                  itemName: items[index]['name'],
                  itemTypeOfCultivation: items[index]['typeOfCultivation'],
                  itemPestsDetected: items[index]['pestsDetected'],
                  itemNutrientDeficiency: items[index]['nutrientDeficiency'],
                  itemIrrigationNeed: items[index]['irrigationNeed'],
                  itemDescription: items[index]['description']);
            }, childCount: items.length))
          ],
        ),
      ),
    );
  }
}
