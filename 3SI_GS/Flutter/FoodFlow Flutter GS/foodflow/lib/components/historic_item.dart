import 'package:flutter/material.dart';

class HistoricItem extends StatelessWidget {
  const HistoricItem(
      {Key? key,
      required this.imageURI,
      required this.itemId,
      required this.itemStatus})
      : super(key: key);
  final String imageURI;
  final String itemId;
  final String itemStatus;

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.hardEdge,
      color: Theme.of(context).colorScheme.surfaceVariant,
      elevation: 0,
      child: Column(
        children: <Widget>[
          Image(
            height: 200,
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
                  'ID: $itemId',
                  style: const TextStyle(fontSize: 16),
                ),
                Text('Status: $itemStatus'),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
