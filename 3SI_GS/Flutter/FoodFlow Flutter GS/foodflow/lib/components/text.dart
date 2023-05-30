import 'package:flutter/material.dart';
import 'package:foodflow/constants/typography.dart';
import 'package:foodflow/extensions/theme_data_extensions.dart';


class CustomText extends StatelessWidget {
  final String text;
  final TypographyType style;
  final Color? color;
  final TextAlign? textAlign;
  final TextOverflow? textOverflow;
  final bool wrap;

  const CustomText({
    super.key,
    required this.text,
    required this.style,
    this.color,
    this.textAlign,
    this.textOverflow,
    this.wrap = true,
  });

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: typography[style]?.copyWith(
        color: color ?? context.colors.kTextPrimaryColor,
      ),
      textHeightBehavior: const TextHeightBehavior(
        applyHeightToFirstAscent: true,
        applyHeightToLastDescent: true,
        leadingDistribution: TextLeadingDistribution.even,
      ),
      textAlign: textAlign,
      overflow: textOverflow,
      softWrap: wrap,
    );
  }
}
