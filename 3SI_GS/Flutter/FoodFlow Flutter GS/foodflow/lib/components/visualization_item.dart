import 'package:flutter/material.dart';
import 'package:foodflow/screens/details_page.dart';
import 'package:foodflow/themes/app_colors.dart';

class VisualizationItem extends StatelessWidget {
  const VisualizationItem(
      {Key? key,
      required this.itemId,
      required this.itemTypeOfCultivation,
      required this.imageURI})
      : super(key: key);
  final String itemId;
  final String itemTypeOfCultivation;
  final String imageURI;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Card(
        clipBehavior: Clip.hardEdge,
        color: Theme.of(context).colorScheme.surfaceVariant,
        elevation: 0,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    'ID: $itemId',
                    style: const TextStyle(
                        fontSize: 16, fontWeight: FontWeight.w500),
                  ),
                  Text(itemTypeOfCultivation),
                  const Text(''),
                  ElevatedButton(
                    onPressed: () {
                      Navigator.push(context,
                          MaterialPageRoute(builder: (context) {
                        return const DetailsPage();
                      }));
                    },
                    style: AppColors.buttonStyle,
                    child: const Text('Detalhes'),
                  )
                ],
              ),
            ),
            Image(
              height: 130,
              width: 130,
              image: AssetImage(imageURI),
              fit: BoxFit.cover,
            ),
          ],
        ),
      ),
    );
  }
}
