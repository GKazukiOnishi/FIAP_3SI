import 'package:flutter/material.dart';
import 'package:foodflow/components/text.dart';
import 'package:foodflow/constants/borders.dart';
import 'package:foodflow/constants/spacings.dart';
import 'package:foodflow/constants/typography.dart';
import 'package:foodflow/extensions/theme_data_extensions.dart';


class CustomButton extends StatelessWidget {
  final String label;
  final bool isDisabled;
  final VoidCallback onPressed;

  const CustomButton({
    super.key,
    required this.label,
    required this.onPressed,
    this.isDisabled = false,
  });

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      child: OutlinedButton(
        onPressed: isDisabled ? null : onPressed,
        style: ButtonStyle(
          backgroundColor: MaterialStateProperty.all(
            isDisabled
                ? context.colors.kDisabledColor
                : context.colors.kAccentColor,
          ),
          shape: MaterialStateProperty.all(shapeBorder(
            isDisabled
                ? context.colors.kDisabledColor
                : context.colors.kAccentColor,
          )),
          side: MaterialStateProperty.all(
            BorderSide(
              width: borderWidth,
              color: isDisabled
                  ? context.colors.kDisabledColor
                  : context.colors.kAccentColor,
            ),
          ),
        ),
        child: _getButtonContent(context.colors.kBackgroundColor),
      ),
    );
  }

  Widget _getButtonContent(Color contentColor) {
    return SizedBox(
      height: Spacings.XXL,
      child: Row(
        mainAxisSize: MainAxisSize.min,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          CustomText(
            color: contentColor,
            style: TypographyType.button,
            text: label.toUpperCase(),
            textAlign: TextAlign.center,
          ),
        ],
      ),
    );
  }
}
