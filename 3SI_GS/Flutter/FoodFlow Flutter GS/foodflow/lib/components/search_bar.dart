import 'package:flutter/material.dart';
import 'package:foodflow/components/button.dart';
import 'package:foodflow/components/search_input.dart';
import 'package:foodflow/extensions/theme_data_extensions.dart';

class CustomSearchBar extends StatelessWidget implements PreferredSizeWidget {
  @override
  final Size preferredSize;
  final void Function(String) onChanged;
  final VoidCallback onPressed;

  const CustomSearchBar({
    super.key,
    required this.onChanged,
    required this.onPressed,
  }) : preferredSize = const Size.fromHeight(kToolbarHeight);

  @override
  Widget build(BuildContext context) {
    return Container(
      color: context.colors.kPrimaryColor,
      child: Row(
        mainAxisSize: MainAxisSize.max,
        children: [
          Expanded(
            child: CustomSearchInput(
              hint: 'Digite o ID desejado',
              onChanged: onChanged,
              
            ),
          ),
          CustomButton(
            label: 'Pesquisar',
            onPressed: onPressed,
          ),
        ],
      ),
    );
  }
}
