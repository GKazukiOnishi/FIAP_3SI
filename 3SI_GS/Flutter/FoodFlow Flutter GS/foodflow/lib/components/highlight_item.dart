import 'package:flutter/material.dart';
import 'package:foodflow/mocks/coffee.dart';
import 'package:foodflow/themes/app_colors.dart';

class HighlightItem extends StatelessWidget {
  const HighlightItem(
      {Key? key,
      required this.imageURI,
      required this.itemTypeOfCultivation,
      required this.itemStatus,
      required this.itemDescription})
      : super(key: key);
  final String imageURI;
  final String itemTypeOfCultivation;
  final String itemStatus;
  final String itemDescription;
  final List items = cafes;
  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.hardEdge,
      color: Theme.of(context).colorScheme.surfaceVariant,
      elevation: 0,
      child: Column(
        children: <Widget>[
          Image(
            height: 120,
            width: double.infinity,
            image: AssetImage(imageURI),
            fit: BoxFit.cover,
          ),
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Text(
                  itemTypeOfCultivation,
                  style: const TextStyle(
                      fontSize: 16, fontWeight: FontWeight.w900),
                ),
                Text('Status: $itemStatus'),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 8.0),
                  child: Text(itemDescription),
                ),
                Align(
                  alignment: Alignment.centerRight,
                  child: ElevatedButton(
                    onPressed: () {},
                    style: AppColors.buttonStyle,
                    child: const Text('Ver mais'),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
