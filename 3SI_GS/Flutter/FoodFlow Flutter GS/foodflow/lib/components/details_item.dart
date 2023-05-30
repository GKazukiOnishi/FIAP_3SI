import 'package:flutter/material.dart';
import 'package:foodflow/themes/app_colors.dart';

class DetailsItem extends StatelessWidget {
  const DetailsItem(
      {Key? key,
      required this.imageURI,
      required this.itemId,
      required this.itemStatus,
      required this.itemName,
      required this.itemTypeOfCultivation,
      required this.itemPestsDetected,
      required this.itemNutrientDeficiency,
      required this.itemIrrigationNeed,
      required this.itemDescription})
      : super(key: key);

  final String imageURI;
  final String itemId;
  final String itemStatus;
  final String itemName;
  final String itemTypeOfCultivation;
  final String itemPestsDetected;
  final String itemNutrientDeficiency;
  final String itemIrrigationNeed;
  final String itemDescription;

  @override
  Widget build(BuildContext context) {
    return Card(
      clipBehavior: Clip.hardEdge,
      color: Theme.of(context).colorScheme.surfaceVariant,
      elevation: 0,
      child: Column(
        children: <Widget>[
          Image(
            height: 400,
            width: double.infinity,
            image: AssetImage(imageURI),
            fit: BoxFit.cover,
          ),
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                Text('Nome: $itemName',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Text('Status: $itemStatus',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Text('Tipo de Cultivo: $itemTypeOfCultivation',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Text('Pestes Detectadas: $itemPestsDetected',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Text('Deficiência de Nutrientes: $itemNutrientDeficiency',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Text('Irrigação Necessária : $itemIrrigationNeed',
                    style: const TextStyle(
                        fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 8.0),
                  child: Text('Descrição: $itemDescription',
                      style: const TextStyle(
                          fontFamily: "Poppins", fontWeight: FontWeight.w500)),
                ),
                Align(
                  alignment: Alignment.centerRight,
                  child: ElevatedButton(
                    onPressed: () {},
                    style: AppColors.buttonStyle,
                    child: const Text('Voltar'),
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
