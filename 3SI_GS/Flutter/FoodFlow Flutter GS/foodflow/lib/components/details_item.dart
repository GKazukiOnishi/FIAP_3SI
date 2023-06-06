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
                Row(
                  children: [
                    const Text("Nome: ",
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemName,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Row(
                  children: [
                    const Text('Status: ',
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemStatus,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Row(
                  children: [
                    const Text('Tipo de Cultivo: ',
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemTypeOfCultivation,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Row(
                  children: [
                    const Text('Pestes Detectadas: ',
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemPestsDetected,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Row(
                  children: [
                    const Text('Deficiência de Nutrientes: ',
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemNutrientDeficiency,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Row(
                  children: [
                    const Text('Irrigação Necessária : ',
                        style: TextStyle(
                            fontFamily: "Poppins",
                            fontWeight: FontWeight.w700)),
                    Text(itemIrrigationNeed,
                        style: const TextStyle(
                            fontFamily: "Poppins", fontWeight: FontWeight.w500))
                  ],
                ),
                Padding(
                  padding: const EdgeInsets.symmetric(vertical: 8.0),
                  child: Text(itemDescription,
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
